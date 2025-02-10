package setting

import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import buy.coke.zet.presentation.R
import buy.coke.zet.presentation.databinding.ActivityCardListSettingBinding
import buy.coke.zet.presentation.product.list.ProductListActivity

class CardListSettingActivity : AppCompatActivity() {
    private lateinit var binding: ActivityCardListSettingBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_card_list_setting)

        binding.nextButton.clickListener = View.OnClickListener {
            startActivity(Intent(this, ProductListActivity::class.java))
        }
    }
}