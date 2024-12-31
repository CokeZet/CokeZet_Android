package buy.coke.zet.presentation.product.list

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import buy.coke.zet.presentation.R
import buy.coke.zet.presentation.databinding.ActivityProductListBinding

class ProductListActivity : AppCompatActivity() {
    private lateinit var binding: ActivityProductListBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_product_list)

        val brandAdapter = SettingItemAdapter(listOf(getString(R.string.coca_cola), getString(R.string.pepsi)))
        binding.brandListView.adapter = brandAdapter

        val volumeAdapter = SettingItemAdapter(listOf(
            getString(R.string.volume_190),
            getString(R.string.volume_210),
            getString(R.string.volume_350),
            getString(R.string.volume_355)))
        binding.volumeListView.adapter = volumeAdapter

        val shoppingMallAdapter = SettingItemAdapter(listOf(
            getString(R.string.coupang),
            getString(R.string.gmarket),
            getString(R.string.eleventh_street),
            getString(R.string.naver),
            getString(R.string.market_kurly),
        ))
        binding.shoppingMallListView.adapter = shoppingMallAdapter

        val discountRateAdapter = SettingItemAdapter(listOf(
            getString(R.string.zetpick),
            getString(R.string.large_discount),
            getString(R.string.middle_discount),
            getString(R.string.low_discount),
            getString(R.string.average)
        ))
        binding.discountRateListView.adapter = discountRateAdapter

        val cardFavorAdapter = SettingItemAdapter(listOf(
            getString(R.string.nonghyup),
            getString(R.string.kookmin),
            getString(R.string.shinhan),
            getString(R.string.lotte),
            getString(R.string.hana),
            getString(R.string.samgsung),
            getString(R.string.city),
            getString(R.string.woori),
            getString(R.string.bc)
        ))
        binding.cardFavorListView.adapter = cardFavorAdapter

        val productInfoAdapter = ProductInfoAdapter()
        binding.productListView.adapter = productInfoAdapter
        productInfoAdapter.submitList(listOf(
            ProductInfo(0, "펩시 제로 355ml 24개", 24, 16000, true),
            ProductInfo(1, "펩시 제로 355ml 25개", 24, 16000, true),
            ProductInfo(2, "펩시 제로 355ml 26개", 24, 16000, true),
            ProductInfo(3, "펩시 제로 355ml 27개", 24, 16000, true),
            ProductInfo(4, "펩시 제로 355ml 28개", 24, 16000, true),
            ProductInfo(5, "펩시 제로 355ml 29개", 24, 16000, true),
            ProductInfo(6, "펩시 제로 355ml 30개", 24, 16000, true),
        ))
    }
}