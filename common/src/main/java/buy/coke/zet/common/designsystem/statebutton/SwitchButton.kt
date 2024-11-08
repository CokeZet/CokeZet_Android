package buy.coke.zet.common.designsystem.statebutton

import android.content.Context
import android.util.AttributeSet
import android.view.LayoutInflater
import android.widget.CompoundButton.OnCheckedChangeListener
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.databinding.BindingAdapter
import buy.coke.zet.common.databinding.LayoutSwitchButtonBinding

class SwitchButton @JvmOverloads constructor(
    context: Context,
    attrs: AttributeSet? = null,
    defStyleAttr: Int = 0
) : ConstraintLayout(context, attrs, defStyleAttr) {
    private val binding: LayoutSwitchButtonBinding =
        LayoutSwitchButtonBinding.inflate(LayoutInflater.from(context), this, true)

    var checkedChangedListener: OnCheckedChangeListener? = null
        set(value) {
            field = value
            binding.switchButtonBody.setOnCheckedChangeListener(value)
        }

    companion object {
        @JvmStatic
        @BindingAdapter("checkedChangedListener")
        fun setOnCheckedChangedListener(switchButton: SwitchButton, onCheckedChangeListener: OnCheckedChangeListener) {
            switchButton.checkedChangedListener = onCheckedChangeListener
        }
    }
}