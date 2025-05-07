package buy.coke.zet.presentation.info.mypage

import android.content.Intent
import android.os.Bundle
import android.text.Spannable
import android.text.SpannableString
import android.text.style.ForegroundColorSpan
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.lifecycleScope
import buy.coke.zet.common.designsystem.dialog.LongDialog
import buy.coke.zet.domain.usecase.DeleteUseCase
import buy.coke.zet.domain.usecase.LogoutUseCase
import buy.coke.zet.presentation.LoginStatus
import buy.coke.zet.presentation.R
import buy.coke.zet.presentation.databinding.ActivityMyPageBinding
import buy.coke.zet.presentation.info.announcement.AnnouncementActivity
import buy.coke.zet.presentation.info.notification_setting.NotificationSettingActivity
import buy.coke.zet.presentation.info.term.TERM_TITLE
import buy.coke.zet.presentation.info.term.TermActivity
import buy.coke.zet.presentation.intro.signup.SignUpActivity
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

@AndroidEntryPoint
class MyPageActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMyPageBinding
    @Inject lateinit var logoutUseCase: LogoutUseCase
    @Inject lateinit var deleteUseCase: DeleteUseCase

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
                        deleteUseCase()
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