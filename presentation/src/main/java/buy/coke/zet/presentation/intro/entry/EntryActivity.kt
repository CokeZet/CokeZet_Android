package buy.coke.zet.presentation.intro.entry

import android.os.Bundle
import android.view.View
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.databinding.DataBindingUtil
import buy.coke.zet.common.designsystem.dialog.ShortDialog
import buy.coke.zet.presentation.R
import buy.coke.zet.presentation.databinding.ActivityEntryBinding

class EntryActivity : AppCompatActivity() {
    private lateinit var binding: ActivityEntryBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_entry)

        binding.startButton.clickListener = View.OnClickListener {
            ShortDialog(this).show()
        }
    }
}