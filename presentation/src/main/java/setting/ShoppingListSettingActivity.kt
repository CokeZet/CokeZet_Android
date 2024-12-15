package setting

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import buy.coke.zet.presentation.R
import buy.coke.zet.presentation.databinding.ActivityShoppingListSettingBinding

class ShoppingListSettingActivity : AppCompatActivity() {
    private lateinit var binding: ActivityShoppingListSettingBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_shopping_list_setting)
        binding.nickname = "복슬복슬한반달가슴곰"
    }
}