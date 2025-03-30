package buy.coke.zet.presentation.intro.signup

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import buy.coke.zet.presentation.R
import buy.coke.zet.presentation.databinding.ActivitySignUpBinding
import buy.coke.zet.presentation.intro.entry.EntryActivity
import buy.coke.zet.presentation.setting.NicknameSettingActivity

class SignUpActivity : AppCompatActivity() {
    private lateinit var binding: ActivitySignUpBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_sign_up)

        binding.nonMemberButton.setOnClickListener { startActivity(Intent(this, NicknameSettingActivity::class.java)) }
        binding.googleLoginButton.setOnClickListener { Toast.makeText(this, getString(R.string.not_support_feature), Toast.LENGTH_SHORT).show() }
        binding.kakaoLoginButton.setOnClickListener { Toast.makeText(this, getString(R.string.not_support_feature), Toast.LENGTH_SHORT).show() }
    }
}