package buy.coke.zet.presentation.info.term

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.databinding.DataBindingUtil
import buy.coke.zet.presentation.R
import buy.coke.zet.presentation.databinding.ActivityTermBinding

class TermActivity : AppCompatActivity() {
    private lateinit var binding: ActivityTermBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_term)

        binding.termTitle.text = intent.getStringExtra(TERM_TITLE)
        binding.termFinishButton.setOnClickListener { finish() }
        binding.termDescription.text = servicePolicyTerm
    }
}