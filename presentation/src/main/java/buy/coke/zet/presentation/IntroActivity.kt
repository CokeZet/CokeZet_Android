package buy.coke.zet.presentation

import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.repeatOnLifecycle
import buy.coke.zet.common.designsystem.dialog.LongDialog
import buy.coke.zet.common.designsystem.dialog.ShortDialog
import buy.coke.zet.presentation.databinding.ActivityIntroBinding
import kotlinx.coroutines.launch

class IntroActivity : AppCompatActivity() {
    private lateinit var binding: ActivityIntroBinding
    private val viewModel: IntroViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_intro)
        binding.viewModel = viewModel

        binding.shortDialogButton.clickListener = View.OnClickListener {
            ShortDialog(this, yesButtonListener = viewModel::clickDialogButton).show()
        }

        binding.longDialogButton.clickListener = View.OnClickListener {
            LongDialog(this, yesButtonListener = viewModel::clickDialogButton).show()
        }
    }

}