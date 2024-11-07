package buy.coke.zet.common.designsystem.normalbutton

import android.content.Context
import android.content.res.ColorStateList
import android.util.AttributeSet
import android.view.LayoutInflater
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.core.content.ContextCompat
import androidx.databinding.BindingAdapter
import buy.coke.zet.common.databinding.LayoutNormalButtonBinding
import buy.coke.zet.common.designsystem.NormalButtonStyle

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

    var buttonShape: NormalButtonStyle.Shape = NormalButtonStyle.Shape.RECTANGLE
        set(value) {
            field = value
            binding.normalButtonBody.background = ContextCompat.getDrawable(context, value.drawableId)
        }

    var buttonStyle: NormalButtonStyle.Color = NormalButtonStyle.Color.LIGHT_RED
        set(value) {
            field = value

            binding.normalButtonBody.backgroundTintList =
                ColorStateList.valueOf(ContextCompat.getColor(context, value.backgroundColor))
            binding.normalButtonBody.setTextColor(ContextCompat.getColor(context, value.textColor))
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
        @BindingAdapter("buttonText")
        fun setButtonText(normalButton: NormalButton, text: String) {
            normalButton.buttonText = text
        }

        @JvmStatic
        @BindingAdapter("buttonShape")
        fun setButtonShape(normalButton: NormalButton, shape: NormalButtonStyle.Shape) {
            normalButton.buttonShape = shape
        }

        @JvmStatic
        @BindingAdapter("clickListener")
        fun setButtonClickListener(normalButton: NormalButton, clickListener: OnClickListener) {
            normalButton.clickListener = clickListener
        }
    }

}