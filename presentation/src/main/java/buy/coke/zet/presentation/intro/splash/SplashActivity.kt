package buy.coke.zet.presentation.intro.splash

import android.content.Intent
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.widget.Toast
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.lifecycleScope
import buy.coke.zet.domain.ServiceResult
import buy.coke.zet.domain.entitiy.login.LoginResponseEntity
import buy.coke.zet.presentation.LoginStatus
import buy.coke.zet.presentation.R
import buy.coke.zet.presentation.databinding.ActivitySplashBinding
import buy.coke.zet.presentation.intro.signup.SignUpActivity
import buy.coke.zet.presentation.product.list.ProductListActivity
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.launch

@AndroidEntryPoint
class SplashActivity : AppCompatActivity() {
    private lateinit var binding: ActivitySplashBinding
    private val viewModel: SplashViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_splash)

        lifecycleScope.launch {
            val autoLoginResult = viewModel.isAutoLoginPossible()

            if (autoLoginResult is ServiceResult.Success) {
                Toast.makeText(this@SplashActivity, "로그인 성공", Toast.LENGTH_SHORT).show()
                LoginStatus.userInfo = autoLoginResult.data
                
                Handler(Looper.getMainLooper()).postDelayed({
                    startActivity(Intent(this@SplashActivity, ProductListActivity::class.java))
                    finish()
                }, 2000)
            }
            else {
                Toast.makeText(this@SplashActivity, "로그인 실패", Toast.LENGTH_SHORT).show()
                Handler(Looper.getMainLooper()).postDelayed({
                    startActivity(Intent(this@SplashActivity, SignUpActivity::class.java))
                    finish()
                }, 2000)
            }
        }
    }
}