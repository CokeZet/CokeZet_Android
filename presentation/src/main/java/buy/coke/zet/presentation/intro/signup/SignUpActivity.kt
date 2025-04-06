package buy.coke.zet.presentation.intro.signup

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.lifecycleScope
import buy.coke.zet.domain.ServiceResult
import buy.coke.zet.domain.usecase.LoginWithGoogleUseCase
import buy.coke.zet.presentation.LoginStatus
import buy.coke.zet.presentation.R
import buy.coke.zet.presentation.databinding.ActivitySignUpBinding
import buy.coke.zet.presentation.intro.entry.EntryActivity
import buy.coke.zet.presentation.setting.NicknameSettingActivity
import buy.coke.zet.presentation.util.GoogleAuthManager
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

@AndroidEntryPoint
class SignUpActivity : AppCompatActivity() {
    private lateinit var binding: ActivitySignUpBinding
    @Inject lateinit var loginWithGoogleUseCase: LoginWithGoogleUseCase

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_sign_up)

        binding.nonMemberButton.setOnClickListener { startActivity(Intent(this, NicknameSettingActivity::class.java)) }
        binding.googleLoginButton.setOnClickListener { loginWithGoogleAccount() }
        binding.kakaoLoginButton.setOnClickListener { Toast.makeText(this, getString(R.string.not_support_feature), Toast.LENGTH_SHORT).show() }
    }

    private fun loginWithGoogleAccount() {
        lifecycleScope.launch {
            GoogleAuthManager.getGoogleToken(this@SignUpActivity)?.let { token ->
                loginWithGoogleUseCase(token).also { result ->
                    if (result is ServiceResult.Success) {
                        LoginStatus.userInfo = result.data
                        Toast.makeText(this@SignUpActivity, getString(R.string.login_success), Toast.LENGTH_SHORT).show()
                    }
                    else {
                        Toast.makeText(this@SignUpActivity, getString(R.string.login_fail), Toast.LENGTH_SHORT).show()
                    }

                    startActivity(Intent(this@SignUpActivity, NicknameSettingActivity::class.java))
                }
            } ?: kotlin.run {
                Toast.makeText(this@SignUpActivity, getString(R.string.login_fail), Toast.LENGTH_SHORT).show()
                startActivity(Intent(this@SignUpActivity, NicknameSettingActivity::class.java))
            }
        }
    }
}