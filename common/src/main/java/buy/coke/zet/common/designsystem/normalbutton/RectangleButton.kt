package buy.coke.zet.common.designsystem.normalbutton

import android.content.Context
import android.content.res.ColorStateList
import android.util.AttributeSet
import android.view.LayoutInflater
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.core.content.ContextCompat
import androidx.databinding.BindingAdapter
import buy.coke.zet.common.R
import buy.coke.zet.common.databinding.LayoutRectangleButtonBinding

class RectangleButton @JvmOverloads constructor(
    context: Context,
    attrs: AttributeSet? = null,
    defStyleAttr: Int = 0
): ConstraintLayout(context, attrs, defStyleAttr) {
    private val binding: LayoutRectangleButtonBinding =
        LayoutRectangleButtonBinding.inflate(LayoutInflater.from(context), this, true)

    var buttonStyle: Color? = null
        set(value) {
            field = value
            val pair = value?.let { getColorIdPair(it) } ?: Pair(R.color.red_600, R.color.white)

            binding.rectangleButtonBody.backgroundTintList =
                ColorStateList.valueOf(ContextCompat.getColor(context, pair.first))
            binding.rectangleButtonBody.setTextColor(ContextCompat.getColor(context, pair.second))
        }

    var buttonText: String = ""
        set(value) {
            field = value
            binding.rectangleButtonBody.text = value
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
        fun setButtonStyle(rectangleButton: RectangleButton, color: Color) {
            rectangleButton.buttonStyle = color
        }

        @JvmStatic
        @BindingAdapter("buttonText")
        fun setButtonText(rectangleButton: RectangleButton, text: String) {
            rectangleButton.buttonText = text
        }
    }

    enum class Color {
        LIGHT_RED, RED, WHITE, GRAY, BLACK
    }
}