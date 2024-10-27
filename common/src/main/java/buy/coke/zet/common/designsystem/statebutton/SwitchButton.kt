package buy.coke.zet.common.designsystem.statebutton

import android.content.Context
import android.util.AttributeSet
import android.view.LayoutInflater
import androidx.constraintlayout.widget.ConstraintLayout
import buy.coke.zet.common.databinding.LayoutLogoButtonBinding
import buy.coke.zet.common.databinding.LayoutSwitchButtonBinding

class SwitchButton @JvmOverloads constructor(
    context: Context,
    attrs: AttributeSet? = null,
    defStyleAttr: Int = 0
) : ConstraintLayout(context, attrs, defStyleAttr) {
    private val binding: LayoutSwitchButtonBinding =
        LayoutSwitchButtonBinding.inflate(LayoutInflater.from(context), this, true)


}