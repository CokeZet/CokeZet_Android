package buy.coke.zet.common.designsystem.normalbutton

import android.content.Context
import android.content.res.ColorStateList
import android.graphics.drawable.GradientDrawable
import android.util.AttributeSet
import android.view.LayoutInflater
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.core.content.ContextCompat
import androidx.databinding.BindingAdapter
import buy.coke.zet.common.databinding.LayoutNormalButtonBinding
import buy.coke.zet.common.designsystem.NormalButtonStyle
import buy.coke.zet.common.designsystem.dpToPx

class NormalButton @JvmOverloads constructor(
    context: Context,
    attrs: AttributeSet? = null,
    defStyleAttr: Int = 0
): ConstraintLayout(context, attrs, defStyleAttr) {
    private val binding: LayoutNormalButtonBinding =
        LayoutNormalButtonBinding.inflate(LayoutInflater.from(context), this, true)

    var clickListener: OnClickListener? = null
        set(value) {
            binding.normalButtonBody.setOnClickListener(value)
        }

    var clickEnable: Boolean = true
        set(value) {
            field = value
            binding.normalButtonBody.isEnabled = value
        }

    var buttonShape: NormalButtonStyle.Shape = NormalButtonStyle.Shape.RECTANGLE
        set(value) {
            field = value
//            val newBackground = binding.normalButtonBody.background as GradientDrawable
//
//            (binding.normalButtonBody.background as GradientDrawable).apply {
//                this.cornerRadius = context.dpToPx(buttonShape.radius).toFloat()
//            }
        }

    var buttonStyle: NormalButtonStyle.Color = NormalButtonStyle.Color.RED
        set(value) {
            field = value

            binding.normalButtonBody.background = ContextCompat.getDrawable(context, value.backgroundColor)
            val colorStateList = ContextCompat.getColorStateList(context, value.textColor)
            binding.normalButtonBody.setTextColor(colorStateList)
        }

    var buttonText: String = ""
        set(value) {
            field = value
            binding.normalButtonBody.text = value
        }

    companion object {
        @JvmStatic
        @BindingAdapter("mainColor")
        fun setButtonStyle(normalButton: NormalButton, color: NormalButtonStyle.Color) {
            normalButton.buttonStyle = color
        }

        @JvmStatic
        @BindingAdapter("buttonShape")
        fun setButtonShape(normalButton: NormalButton, shape: NormalButtonStyle.Shape) {
            normalButton.buttonShape = shape
        }

        @JvmStatic
        @BindingAdapter("clickEnable")
        fun setButtonClickEnable(normalButton: NormalButton, enable: Boolean) {
            normalButton.clickEnable = enable
        }

        @JvmStatic
        @BindingAdapter("clickListener")
        fun setButtonClickListener(normalButton: NormalButton, clickListener: OnClickListener) {
            normalButton.clickListener = clickListener
        }
    }

}