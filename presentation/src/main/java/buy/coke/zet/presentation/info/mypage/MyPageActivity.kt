package buy.coke.zet.presentation.info.mypage

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Toast
import androidx.activity.result.contract.ActivityResultContracts
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.lifecycleScope
import buy.coke.zet.common.designsystem.dialog.LongDialog
import buy.coke.zet.domain.usecase.DeleteUseCase
import buy.coke.zet.domain.usecase.LogoutUseCase
import buy.coke.zet.presentation.model.LoginStatus
import buy.coke.zet.presentation.R
import buy.coke.zet.presentation.databinding.ActivityMyPageBinding
import buy.coke.zet.presentation.info.announcement.AnnouncementActivity
import buy.coke.zet.presentation.info.notification_setting.NotificationSettingActivity
import buy.coke.zet.presentation.info.term.TERM_TITLE
import buy.coke.zet.presentation.info.term.TermActivity
import buy.coke.zet.presentation.intro.signup.SignUpActivity
import buy.coke.zet.presentation.util.GoogleDeleteManager
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.launch
import javax.inject.Inject

@AndroidEntryPoint
class MyPageActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMyPageBinding
    @Inject lateinit var logoutUseCase: LogoutUseCase
    @Inject lateinit var deleteUseCase: DeleteUseCase

    private val signInLauncher = registerForActivityResult(
        ActivityResultContracts.StartActivityForResult()
    ) { result ->
        val authCode = GoogleDeleteManager.extractAuthCode(result.data)
        if (authCode != null) {
            lifecycleScope.launch {
                val accessToken = GoogleDeleteManager.getAccessToken(authCode)
                if (accessToken != null) {
                    deleteUseCase(accessToken)
                } else {
                    Toast.makeText(this@MyPageActivity, "Google에서 AccessToken 받아오기 실패", Toast.LENGTH_SHORT).show()
                }
            }
        } else {
            Toast.makeText(this@MyPageActivity, "Google에서 AccessToken 받아오기 실패", Toast.LENGTH_SHORT).show()
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_my_page)

        binding.setPriceNotificationButton.root.setOnClickListener { startActivity(Intent(this, NotificationSettingActivity::class.java)) }
        binding.announcementButton.root.setOnClickListener { startActivity(Intent(this, AnnouncementActivity::class.java)) }
        binding.serviceTermButton.root.setOnClickListener {
            val intent = Intent(this, TermActivity::class.java).apply {
                putExtra(TERM_TITLE, getString(R.string.service_term))
            }

            startActivity(intent)
        }
        binding.personalInformationTermButton.root.setOnClickListener {
            val intent = Intent(this, TermActivity::class.java).apply {
                putExtra(TERM_TITLE, getString(R.string.service_term))
            }

            startActivity(intent)
        }
        binding.mypageTopbar.leftIconClickListener = View.OnClickListener { finish() }
        binding.logoutButton.root.setOnClickListener {
            LongDialog(
                context = this,
                title = getString(R.string.confirm_logout),
                yesButtonListener = {
                    lifecycleScope.launch {
                        logoutUseCase()
                        finishAffinity()
                        startActivity(Intent(this@MyPageActivity, SignUpActivity::class.java))
                    }
                }
            ).show()
        }
        binding.withdraw.root.setOnClickListener {
            LongDialog(
                context = this,
                title = getString(R.string.withdraw_title),
                warning = getString(R.string.withdraw_warning),
                yesButtonListener = {
                    lifecycleScope.launch {
                        val intent = GoogleDeleteManager.getSignInIntent(Activity())
                        signInLauncher.launch(intent)
                        finishAffinity()
                    }
                }
            ).show()
        }

        if (LoginStatus.userInfo == null) setNonMemberPage()
    }

    private fun setNonMemberPage() {
        binding.userNickname.text = getString(R.string.non_member)
        binding.welcomeTitle.text = getString(R.string.mypage_singup_text)
        binding.logoutButton.root.visibility = View.GONE
        binding.withdraw.root.visibility = View.GONE
    }
}