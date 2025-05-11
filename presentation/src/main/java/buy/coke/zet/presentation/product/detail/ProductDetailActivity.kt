package buy.coke.zet.presentation.product.detail

import android.os.Bundle
import android.view.View
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.databinding.DataBindingUtil
import buy.coke.zet.presentation.R
import buy.coke.zet.presentation.databinding.ActivityProductDetailBinding
import buy.coke.zet.presentation.databinding.ActivityProductDetailBindingImpl
import com.skydoves.balloon.ArrowOrientation
import com.skydoves.balloon.ArrowPositionRules
import com.skydoves.balloon.Balloon
import com.skydoves.balloon.BalloonSizeSpec

class ProductDetailActivity : AppCompatActivity() {
    private lateinit var binding: ActivityProductDetailBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_product_detail)
        binding.productDetailTopbar.leftIconClickListener = View.OnClickListener {
            finish()
        }

        binding.graphTooltip.setOnClickListener {
            val balloon = Balloon.Builder(this@ProductDetailActivity)
                .setArrowSize(10)
                .setArrowOrientation(ArrowOrientation.TOP)
                .setArrowPositionRules(ArrowPositionRules.ALIGN_ANCHOR)
                .setArrowPosition(0.5F)
                .setWidth(BalloonSizeSpec.WRAP)
                .setPadding(8)
                .setText(getString(R.string.price_graph_tooltip_description))
                .setBackgroundColor(getColor(buy.coke.zet.common.R.color.gray_500))
                .setTextSize(12F)
                .build()

            balloon.showAlignBottom(binding.graphTooltip)
        }

        binding.comparisonTooltip.setOnClickListener {
            val balloon = Balloon.Builder(this@ProductDetailActivity)
                .setArrowSize(10)
                .setArrowOrientation(ArrowOrientation.TOP)
                .setArrowPositionRules(ArrowPositionRules.ALIGN_ANCHOR)
                .setArrowPosition(0.5F)
                .setWidth(BalloonSizeSpec.WRAP)
                .setPadding(8)
                .setText(getString(R.string.price_comparison_tooltip_description))
                .setBackgroundColor(getColor(buy.coke.zet.common.R.color.gray_500))
                .setTextSize(12F)
                .build()

            balloon.showAlignBottom(binding.comparisonTooltip)
        }
    }
}