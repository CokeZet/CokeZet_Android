package buy.coke.zet.common.designsystem.normalbutton

import android.content.Context
import android.content.res.ColorStateList
import android.util.AttributeSet
import android.view.LayoutInflater
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.core.content.ContextCompat
import androidx.databinding.BindingAdapter
import buy.coke.zet.common.R
import buy.coke.zet.common.databinding.LayoutNormalButtonBinding

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

    var buttonShape: Shape = Shape.RECTANGLE
        set(value) {
            field = value
            binding.normalButtonBody.background = ContextCompat.getDrawable(context, value.drawableId)
        }

    var buttonStyle: Color? = null
        set(value) {
            field = value
            val pair = value?.let { getColorIdPair(it) } ?: Pair(R.color.red_600, R.color.white)

            binding.normalButtonBody.backgroundTintList =
                ColorStateList.valueOf(ContextCompat.getColor(context, pair.first))
            binding.normalButtonBody.setTextColor(ContextCompat.getColor(context, pair.second))
        }

    var buttonText: String = ""
        set(value) {
            field = value
            binding.normalButtonBody.text = value
        }

    private fun getColorIdPair(color: Color): Pair<Int, Int> {
        return when(color) {
            Color.LIGHT_RED -> Pair(R.color.red_600, R.color.white)
            Color.RED -> Pair(R.color.red_700, R.color.white)
            Color.WHITE -> Pair(R.color.red_50, R.color.black)
            Color.GRAY -> Pair(R.color.gray_500, R.color.white)
            Color.BLACK -> Pair(R.color.gray_700, R.color.gray_500)
        }
    }

    companion object {
        @JvmStatic
        @BindingAdapter("mainColor")
        fun setButtonStyle(normalButton: NormalButton, color: Color) {
            normalButton.buttonStyle = color
        }

        @JvmStatic
        @BindingAdapter("buttonText")
        fun setButtonText(normalButton: NormalButton, text: String) {
            normalButton.buttonText = text
        }

        @JvmStatic
        @BindingAdapter("buttonShape")
        fun setButtonShape(normalButton: NormalButton, shape: Shape) {
            normalButton.buttonShape = shape
        }

        @JvmStatic
        @BindingAdapter("clickListener")
        fun setButtonClickListener(normalButton: NormalButton, clickListener: OnClickListener) {
            normalButton.clickListener = clickListener
        }
    }

    enum class Color {
        LIGHT_RED, RED, WHITE, GRAY, BLACK
    }

    enum class Shape(val drawableId: Int) {
        RECTANGLE(R.drawable.rectangle_button), ROUND(R.drawable.round_button)
    }
}