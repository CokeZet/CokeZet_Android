package buy.coke.zet.common.designsystem.statebutton

import android.content.Context
import android.graphics.drawable.StateListDrawable
import android.util.AttributeSet
import android.view.LayoutInflater
import android.widget.CompoundButton.OnCheckedChangeListener
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.core.content.ContextCompat
import androidx.databinding.BindingAdapter
import buy.coke.zet.common.R
import buy.coke.zet.common.databinding.LayoutLogoButtonBinding
import buy.coke.zet.common.designsystem.LogoButtonStyle

class LogoButton @JvmOverloads constructor(
    context: Context,
    attrs: AttributeSet? = null,
    defStyleAttr: Int = 0
) : ConstraintLayout(context, attrs, defStyleAttr) {
    private val binding: LayoutLogoButtonBinding =
        LayoutLogoButtonBinding.inflate(LayoutInflater.from(context), this, true)

    private val stateList = StateListDrawable()

    var brandName: LogoButtonStyle.BrandName? = null
        set(branName) {
            field = branName

            stateList.addState(intArrayOf(android.R.attr.state_checked), ContextCompat.getDrawable(context, branName?.activeResourceId ?: R.drawable.all_defaulticon))
            stateList.addState(IntArray(0), ContextCompat.getDrawable(context, branName?.defaultResourceId ?: R.drawable.all_defaulticon))
            binding.logoButtonBody.background = stateList
        }

    var isChecked: Boolean = false
        set(isChecked) {
            field = isChecked
            binding.logoButtonBody.isChecked = isChecked
        }
        get() = binding.logoButtonBody.isChecked

    var checkedChangedListener: OnCheckedChangeListener? = null
        set(checkedChangedListener) {
            field = checkedChangedListener
            binding.logoButtonBody.setOnCheckedChangeListener(checkedChangedListener)
        }

    companion object {
        @JvmStatic
        @BindingAdapter("brand")
        fun setDefaultResourceId(logoButton: LogoButton, brandName: LogoButtonStyle.BrandName) {
            logoButton.brandName = brandName
        }

        @JvmStatic
        @BindingAdapter("checkedChangedListener")
        fun setOnCheckChangedListener(logoButton: LogoButton, onCheckedChangeListener: OnCheckedChangeListener) {
            logoButton.checkedChangedListener = onCheckedChangeListener
        }

        @JvmStatic
        @BindingAdapter("isChecked")
        fun setButtonState(logoButton: LogoButton, isChecked: Boolean) {
            logoButton.isChecked = isChecked
        }
    }

}