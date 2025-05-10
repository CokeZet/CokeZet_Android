package buy.coke.zet.presentation.product.list

import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import buy.coke.zet.presentation.LoginStatus
import buy.coke.zet.presentation.R
import buy.coke.zet.presentation.databinding.ActivityProductListBinding
import buy.coke.zet.presentation.info.mypage.MyPageActivity
import java.util.Locale

class ProductListActivity : AppCompatActivity() {
    private lateinit var binding: ActivityProductListBinding
    private val productList = mutableListOf(
        ProductInfo(ProductInfoAdapter.INTRODUCE_ITEM_INDEX, "펩시 제로 355ml 24개", 24, String.format(Locale.getDefault(), "%,d원", 16000), true),
        ProductInfo(0, "펩시 제로 355ml 24개", 24, String.format(Locale.getDefault(), "%,d원", 16000), true),
        ProductInfo(1, "펩시 제로 355ml 25개", 24, String.format(Locale.getDefault(), "%,d원", 16000), true),
        ProductInfo(2, "펩시 제로 355ml 26개", 24, String.format(Locale.getDefault(), "%,d원", 16000), true),
        ProductInfo(3, "펩시 제로 355ml 27개", 24, String.format(Locale.getDefault(), "%,d원", 16000), true),
        ProductInfo(4, "펩시 제로 355ml 28개", 24, String.format(Locale.getDefault(), "%,d원", 16000), true),
        ProductInfo(5, "펩시 제로 355ml 29개", 24, String.format(Locale.getDefault(), "%,d원", 16000), true),
        ProductInfo(6, "펩시 제로 355ml 30개", 24, String.format(Locale.getDefault(), "%,d원", 16000), true),
        ProductInfo(ProductInfoAdapter.MORE_ITEM_INDEX, "펩시 제로 355ml 24개", 24, String.format(Locale.getDefault(), "%,d원", 16000), true)
    )
    private val productInfoAdapter = ProductInfoAdapter(this::clickMoreProductButton)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_product_list)
        binding.productListTopbar.rightThirdIconClickListener = View.OnClickListener {
            startActivity(Intent(this, MyPageActivity::class.java))
        }
        setAdvertiseViewPager()

        if (LoginStatus.userInfo != null) {
            binding.blockingContainer.visibility = View.GONE
            binding.unlockBlockingContainerButton.visibility = View.GONE
        }

        binding.showSettingToggleButton.setOnCheckedChangeListener { _, isChecked ->
            if (isChecked) {
                binding.settingContainer.visibility = View.GONE
            }
            else {
                binding.settingContainer.visibility = View.VISIBLE
            }
        }

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
            getString(R.string.normal)
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

        binding.productListView.adapter = productInfoAdapter
        productInfoAdapter.submitList(productList)

        binding.productListView.addOnScrollListener(object : RecyclerView.OnScrollListener() {
            override fun onScrolled(recyclerView: RecyclerView, dx: Int, dy: Int) {
                super.onScrolled(recyclerView, dx, dy)

                if (!recyclerView.canScrollVertically(1) && productList.size > 10) {
                    repeat(4) { index ->
                        productList.add(ProductInfo(productList.size - 1 + index, "펩시 제로 355ml 30개", 24, String.format(Locale.getDefault(), "%,d원", 16000), true))
                    }

                    productInfoAdapter.submitList(productList)
                    binding.productListView.requestLayout()
                }
            }
        })
    }

    private fun clickMoreProductButton() {
        productList.removeAt(productList.size - 1)
        repeat(4) { index ->
            productList.add(ProductInfo(productList.size - 1 + index, "펩시 제로 355ml 30개", 24, String.format(Locale.getDefault(), "%,d원", 16000), true))
        }
    }

    private fun setAdvertiseViewPager() {
        val bannerItemList = listOf(R.drawable.advertiese_card_sample,
            R.drawable.advertiese_card_sample,
            R.drawable.advertiese_card_sample,
            R.drawable.advertiese_card_sample,
            R.drawable.advertiese_card_sample
        )

        binding.advertiseBannerViewpager.adapter = BannerPagerAdapter(bannerItemList)
        binding.advertiseBannerViewpager.setCurrentItem(0, false)
    }
}