package buy.coke.zet.presentation.intro.splash

import android.content.Intent
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import buy.coke.zet.presentation.R
import buy.coke.zet.presentation.databinding.ActivitySplashBinding
import buy.coke.zet.presentation.intro.entry.EntryActivity
import buy.coke.zet.presentation.intro.signup.SignUpActivity
import buy.coke.zet.presentation.product.list.ProductListActivity
import buy.coke.zet.presentation.setting.NicknameSettingActivity

class SplashActivity : AppCompatActivity() {
    private lateinit var binding: ActivitySplashBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_splash)

        Handler(Looper.getMainLooper()).postDelayed({
            startActivity(Intent(this, SignUpActivity::class.java))
            finish()
        }, 2000)
    }
}