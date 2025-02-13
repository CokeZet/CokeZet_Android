package buy.coke.zet.presentation.setting

import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import buy.coke.zet.presentation.R
import buy.coke.zet.presentation.databinding.ActivityCardListSettingBinding
import buy.coke.zet.presentation.product.list.ProductListActivity

class CardListSettingActivity : AppCompatActivity() {
    private lateinit var binding: ActivityCardListSettingBinding
    private val viewModel: CardListSettingViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_card_list_setting)
        binding.viewModel = viewModel
        binding.lifecycleOwner = this

        binding.completeButton.clickListener = View.OnClickListener {
            startActivity(Intent(this, ProductListActivity::class.java))
        }
    }
}