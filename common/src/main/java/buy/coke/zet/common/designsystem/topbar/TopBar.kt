package buy.coke.zet.common.designsystem.topbar

import android.content.Context
import android.util.AttributeSet
import android.view.LayoutInflater
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.databinding.BindingAdapter
import buy.coke.zet.common.R
import buy.coke.zet.common.databinding.LayoutTopbarBinding
import buy.coke.zet.common.designsystem.TopBarStyle

class TopBar @JvmOverloads constructor(
    context: Context,
    attrs: AttributeSet? = null,
    defStyleAttr: Int = 0
): ConstraintLayout(context, attrs, defStyleAttr) {
    private val binding: LayoutTopbarBinding =
        LayoutTopbarBinding.inflate(LayoutInflater.from(context), this, true)

    var leftIconImage: TopBarStyle.Image? = null
        set(value) {
            field = value
            value?.let { binding.leftIcon.setImageResource(getImageId(it)) }
        }

    var leftText: String = ""
        set(value) {
            field = value
            binding.leftText.text = value
        }

    var rightFirstIconImage: TopBarStyle.Image? = null
        set(value) {
            field = value
            value?.let { binding.rightFirstIcon.setImageResource(getImageId(it)) }
        }

    var rightSecondIconImage: TopBarStyle.Image? = null
        set(value) {
            field = value
            value?.let { binding.rightSecondIcon.setImageResource(getImageId(it)) }
        }

    var rightThirdIconImage: TopBarStyle.Image? = null
        set(value) {
            field = value
            value?.let { binding.rightThirdIcon.setImageResource(getImageId(it)) }
        }

    var leftIconClickListener: OnClickListener? = null
        set(value) {
            field = value
            binding.leftIcon.setOnClickListener(value)
        }

    var rightFirstIconClickListener: OnClickListener? = null
        set(value) {
            field = value
            binding.rightFirstIcon.setOnClickListener(value)
        }

    var rightSecondIconClickListener: OnClickListener? = null
        set(value) {
            field = value
            binding.rightSecondIcon.setOnClickListener(value)
        }

    var rightThirdIconClickListener: OnClickListener? = null
        set(value) {
            field = value
            binding.rightThirdIcon.setOnClickListener(value)
        }

    private fun getImageId(image: TopBarStyle.Image): Int {
        return when(image) {
            TopBarStyle.Image.LOGO -> R.drawable.logo_topbar
            TopBarStyle.Image.BACK -> R.drawable.back_topbar
            TopBarStyle.Image.NOTIFICATION -> R.drawable.notification_topbar
            TopBarStyle.Image.GRAPH -> R.drawable.graph_topbar
            TopBarStyle.Image.PERSON -> R.drawable.person_topbar
            TopBarStyle.Image.EXIT -> R.drawable.exit_topbar
        }
    }

    companion object {
        @JvmStatic
        @BindingAdapter("leftIconImage")
        fun setLeftIconImage(topBar: TopBar, iconImage: TopBarStyle.Image) {
            topBar.leftIconImage = iconImage
        }

        @JvmStatic
        @BindingAdapter("leftText")
        fun setLeftText(topBar: TopBar, text: String) {
            topBar.leftText = text
        }

        @JvmStatic
        @BindingAdapter("rightFirstIconImage")
        fun setRightFirstIconImage(topBar: TopBar, iconImage: TopBarStyle.Image) {
            topBar.rightFirstIconImage = iconImage
        }

        @JvmStatic
        @BindingAdapter("rightSecondIconImage")
        fun setRightSecondIconImage(topBar: TopBar, iconImage: TopBarStyle.Image) {
            topBar.rightSecondIconImage = iconImage
        }

        @JvmStatic
        @BindingAdapter("rightThirdIconImage")
        fun setRightThirdIconImage(topBar: TopBar, iconImage: TopBarStyle.Image) {
            topBar.rightThirdIconImage = iconImage
        }

        @JvmStatic
        @BindingAdapter("leftIconClickListener")
        fun setLeftIconClickListener(topBar: TopBar, clickListener: OnClickListener) {
            topBar.leftIconClickListener = clickListener
        }

        @JvmStatic
        @BindingAdapter("rightFirstIconListener")
        fun setRightFirstIconListener(topBar: TopBar, clickListener: OnClickListener) {
            topBar.rightFirstIconClickListener = clickListener
        }

        @JvmStatic
        @BindingAdapter("rightSecondIconListener")
        fun setRightSecondIconListener(topBar: TopBar, clickListener: OnClickListener) {
            topBar.rightSecondIconClickListener = clickListener
        }

        @JvmStatic
        @BindingAdapter("rightThirdIconListener")
        fun setRightThirdIconListener(topBar: TopBar, clickListener: OnClickListener) {
            topBar.rightThirdIconClickListener = clickListener
        }
    }

}