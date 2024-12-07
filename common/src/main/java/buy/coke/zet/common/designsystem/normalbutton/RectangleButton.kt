package buy.coke.zet.common.designsystem.normalbutton

import android.content.Context
import android.util.AttributeSet
import android.view.LayoutInflater
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.core.content.ContextCompat
import androidx.databinding.BindingAdapter
import buy.coke.zet.common.databinding.LayoutRectangleButtonBinding
import buy.coke.zet.common.designsystem.RectangleButtonStyle

class RectangleButton @JvmOverloads constructor(
    context: Context,
    attrs: AttributeSet? = null,
    defStyleAttr: Int = 0
): ConstraintLayout(context, attrs, defStyleAttr) {
    private val binding: LayoutRectangleButtonBinding =
        LayoutRectangleButtonBinding.inflate(LayoutInflater.from(context), this, true)

    var clickListener: OnClickListener? = null
        set(value) {
            binding.rectangleButtonBody.setOnClickListener(value)
        }

    var clickEnable: Boolean = true
        set(value) {
            field = value
            binding.rectangleButtonBody.isEnabled = value
        }

    var buttonStyle: RectangleButtonStyle.Color = RectangleButtonStyle.Color.RED
        set(value) {
            field = value

            binding.rectangleButtonBody.background = ContextCompat.getDrawable(context, value.backgroundColor)
            val colorStateList = ContextCompat.getColorStateList(context, value.textColor)
            binding.rectangleButtonBody.setTextColor(colorStateList)
        }

    var buttonText: String = ""
        set(value) {
            field = value
            binding.rectangleButtonBody.text = value
        }

    companion object {
        @JvmStatic
        @BindingAdapter("mainColor")
        fun setButtonStyle(rectangleButton: RectangleButton, color: RectangleButtonStyle.Color) {
            rectangleButton.buttonStyle = color
        }

        @JvmStatic
        @BindingAdapter("clickEnable")
        fun setButtonClickEnable(rectangleButton: RectangleButton, enable: Boolean) {
            rectangleButton.clickEnable = enable
        }

        @JvmStatic
        @BindingAdapter("clickListener")
        fun setButtonClickListener(rectangleButton: RectangleButton, clickListener: OnClickListener) {
            rectangleButton.clickListener = clickListener
        }

        @JvmStatic
        @BindingAdapter("buttonText")
        fun setButtonText(rectangleButton: RectangleButton, text: String) {
            rectangleButton.buttonText = text
        }
    }

}