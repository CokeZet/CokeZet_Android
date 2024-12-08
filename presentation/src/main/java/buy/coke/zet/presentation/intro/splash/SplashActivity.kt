package buy.coke.zet.presentation.intro.splash

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import buy.coke.zet.presentation.R
import buy.coke.zet.presentation.databinding.ActivitySplashBinding
import buy.coke.zet.presentation.intro.signup.SignUpActivity

class SplashActivity : AppCompatActivity() {
    private lateinit var binding: ActivitySplashBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_splash)

        startActivity(Intent(this, SignUpActivity::class.java))
    }
}