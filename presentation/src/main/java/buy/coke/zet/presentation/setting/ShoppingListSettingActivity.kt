package buy.coke.zet.presentation.setting

import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import buy.coke.zet.presentation.R
import buy.coke.zet.presentation.databinding.ActivityShoppingListSettingBinding
import buy.coke.zet.presentation.product.list.ProductListActivity

class ShoppingListSettingActivity : AppCompatActivity() {
    private lateinit var binding: ActivityShoppingListSettingBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_shopping_list_setting)
        binding.nickname = "복슬복슬한반달가슴곰"
        binding.nextButton.clickListener = View.OnClickListener {
            startActivity(Intent(this, CardListSettingActivity::class.java))
        }
    }
}