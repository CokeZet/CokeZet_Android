package buy.coke.zet.presentation

import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.repeatOnLifecycle
import buy.coke.zet.common.designsystem.normalbutton.NormalButton
import buy.coke.zet.presentation.databinding.ActivityIntroBinding
import kotlinx.coroutines.flow.count
import kotlinx.coroutines.launch

class IntroActivity : AppCompatActivity() {
    private lateinit var binding: ActivityIntroBinding
    private val viewModel: IntroViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_intro)
        binding.viewModel = viewModel

        lifecycleScope.launch {
            repeatOnLifecycle(Lifecycle.State.STARTED) {
                viewModel.clickCountState.collect { count ->
                    binding.rectangleButton.buttonStyle = setButtonStyle(count)
                }
            }
        }
    }

    private fun setButtonStyle(count: Int): NormalButton.Color {
        return when(count) {
            0 -> NormalButton.Color.LIGHT_RED
            1 -> NormalButton.Color.RED
            2 -> NormalButton.Color.WHITE
            3 -> NormalButton.Color.GRAY
            else -> NormalButton.Color.BLACK
        }
    }

}