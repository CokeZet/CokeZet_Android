package buy.coke.zet.common.designsystem.statebutton

import android.content.Context
import android.graphics.drawable.StateListDrawable
import android.util.AttributeSet
import android.view.LayoutInflater
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.core.content.ContextCompat
import androidx.databinding.BindingAdapter
import buy.coke.zet.common.R
import buy.coke.zet.common.databinding.LayoutLogoButtonBinding

class LogoButton @JvmOverloads constructor(
    context: Context,
    attrs: AttributeSet? = null,
    defStyleAttr: Int = 0
) : ConstraintLayout(context, attrs, defStyleAttr) {
    private val binding: LayoutLogoButtonBinding =
        LayoutLogoButtonBinding.inflate(LayoutInflater.from(context), this, true)

    private val stateList = StateListDrawable()

    var brandName: BrandName? = null
        set(branName) {
            field = branName

            stateList.addState(intArrayOf(android.R.attr.state_checked), ContextCompat.getDrawable(context, branName?.activeResourceId ?: R.drawable.all_icon))
            stateList.addState(IntArray(0), ContextCompat.getDrawable(context, branName?.defaultResourceId ?: R.drawable.all_icon))
            binding.logoButtonBody.background = stateList
        }

    companion object {
        @BindingAdapter("brand")
        @JvmStatic
        fun setDefaultResourceId(logoButton: LogoButton, brandName: BrandName) {
            logoButton.brandName = brandName
        }
    }

    enum class BrandName(val defaultResourceId: Int, val activeResourceId: Int) {
        BC(R.drawable.bc_defaulticon, R.drawable.bc_activeicon),
        CITY(R.drawable.city_defaulticon, R.drawable.city_activeicon),
        COUPANG(R.drawable.coupang_defaulticon, R.drawable.coupang_activeicon),
        ELEVENTHSTREET(R.drawable.eleventhstreet_defaulticon, R.drawable.eleventhstreet_activeicon),
        GMARKET(R.drawable.gmarket_defaulticon, R.drawable.gmarket_activeicon),
        HANA(R.drawable.hana_defaulticon, R.drawable.hana_activeicon),
        HYUNDAI(R.drawable.hyundai_defaulticon, R.drawable.hyundai_activeicon),
        KOOKMIN(R.drawable.kookmin_defaulticon, R.drawable.kookmin_activeicon),
        LOTTE(R.drawable.lotte_defaulticon, R.drawable.lotte_activeicon),
        MARKETKURLY(R.drawable.marketkurly_defaulticon, R.drawable.marketkurly_activeicon),
        NAVERSHOPPING(R.drawable.navershopping_defaulticon, R.drawable.navershopping_activeicon),
        NONGHYUP(R.drawable.nonghyup_defaulticon, R.drawable.nonghyup_activeicon),
        SAMGSUNG(R.drawable.samgsung_defaulticon, R.drawable.samgsung_activeicon),
        SHINHAN(R.drawable.shinhan_defaulticon, R.drawable.shinhan_activeicon),
        WOORI(R.drawable.woori_defaulticon, R.drawable.woori_activeicon)
    }
}