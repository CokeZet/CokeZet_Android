package buy.coke.zet.common.designsystem.normalbutton

import android.content.Context
import android.util.AttributeSet
import android.view.LayoutInflater
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.core.content.ContextCompat
import androidx.databinding.BindingAdapter
import buy.coke.zet.common.databinding.LayoutRoundButtonBinding
import buy.coke.zet.common.designsystem.RoundButtonStyle

class RoundButton @JvmOverloads constructor(
    context: Context,
    attrs: AttributeSet? = null,
    defStyleAttr: Int = 0
): ConstraintLayout(context, attrs, defStyleAttr) {
    private val binding: LayoutRoundButtonBinding =
        LayoutRoundButtonBinding.inflate(LayoutInflater.from(context), this, true)

    var clickListener: OnClickListener? = null
        set(value) {
            binding.roundButtonBody.setOnClickListener(value)
        }

    var clickEnable: Boolean = true
        set(value) {
            field = value
            binding.roundButtonBody.isEnabled = value
        }

    var buttonStyle: RoundButtonStyle.Color = RoundButtonStyle.Color.RED
        set(value) {
            field = value

            binding.roundButtonBody.background = ContextCompat.getDrawable(context, value.backgroundColor)
            val colorStateList = ContextCompat.getColorStateList(context, value.textColor)
            binding.roundButtonBody.setTextColor(colorStateList)
        }

    var buttonText: String = ""
        set(value) {
            field = value
            binding.roundButtonBody.text = value
        }

    var textSize: Int = 18
        set(value) {
            field = value
            binding.roundButtonBody.textSize = value.toFloat()
        }

    companion object {
        @JvmStatic
        @BindingAdapter("mainColor")
        fun setButtonStyle(roundButton: RoundButton, color: RoundButtonStyle.Color) {
            roundButton.buttonStyle = color
        }

        @JvmStatic
        @BindingAdapter("clickEnable")
        fun setButtonClickEnable(roundButton: RoundButton, enable: Boolean) {
            roundButton.clickEnable = enable
        }

        @JvmStatic
        @BindingAdapter("clickListener")
        fun setButtonClickListener(roundButton: RoundButton, clickListener: OnClickListener) {
            roundButton.clickListener = clickListener
        }

        @JvmStatic
        @BindingAdapter("buttonText")
        fun setButtonText(roundButton: RoundButton, text: String) {
            roundButton.buttonText = text
        }

        @JvmStatic
        @BindingAdapter("buttonTextSize")
        fun setButtonTextSize(roundButton: RoundButton, size: Int) {
            roundButton.textSize = size
        }
    }

}