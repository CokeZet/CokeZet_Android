package buy.coke.zet.presentation.setting

import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import buy.coke.zet.presentation.R
import buy.coke.zet.presentation.databinding.ActivityShoppingListSettingBinding
import buy.coke.zet.presentation.product.list.ProductListActivity

class ShoppingListSettingActivity : AppCompatActivity() {
    private lateinit var binding: ActivityShoppingListSettingBinding
    private val viewModel: ShoppingListSettingViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_shopping_list_setting)
        binding.viewModel = viewModel
        binding.lifecycleOwner = this

        val nickname = intent.getStringExtra(NicknameSettingActivity.USER_NICKNAME) ?: ""
        binding.nickname = nickname

        binding.nextButton.clickListener = View.OnClickListener {
            startActivity(Intent(this, CardListSettingActivity::class.java))
        }
    }
}