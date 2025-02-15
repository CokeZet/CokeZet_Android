package buy.coke.zet.presentation.setting

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.view.MotionEvent
import android.view.View
import android.view.inputmethod.InputMethodManager
import androidx.activity.enableEdgeToEdge
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.databinding.DataBindingUtil
import buy.coke.zet.presentation.R
import buy.coke.zet.presentation.databinding.ActivityNicknameSettingBinding

class NicknameSettingActivity : AppCompatActivity() {
    private lateinit var binding: ActivityNicknameSettingBinding
    private val viewModel: NicknameSettingViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_nickname_setting)
        binding.viewModel = viewModel
        binding.lifecycleOwner = this

        binding.inputNickname.requestFocus()

        binding.nextButton.clickListener = View.OnClickListener {
            startActivity(Intent(this, ShoppingListSettingActivity::class.java))
        }
    }

    override fun dispatchTouchEvent(ev: MotionEvent): Boolean {
        // 터치 이벤트가 발생하면 키보드 숨기기
        if (currentFocus != null) {
            val imm = getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
            imm.hideSoftInputFromWindow(currentFocus?.windowToken, 0)
            currentFocus?.clearFocus()
        }
        return super.dispatchTouchEvent(ev)
    }
}