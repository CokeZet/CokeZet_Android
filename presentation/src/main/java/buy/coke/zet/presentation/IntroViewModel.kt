package buy.coke.zet.presentation

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.SharedFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asSharedFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch

class IntroViewModel: ViewModel() {
    private val _clickCountState = MutableStateFlow(0)
    val clickCountState: StateFlow<Int> = _clickCountState.asStateFlow()

    fun rotateDesign() = viewModelScope.launch {
        _clickCountState.value = (++_clickCountState.value) % BUTTON_DESIGN_NUMBER
    }

    fun clickLogoButton(check: Boolean) {
        if (check) Log.d("ZET_Android", "LogoButton : true")
        else Log.d("ZET_Android", "LogoButton : false")
    }

    fun clickSwitchButton(check: Boolean) {
        if (check) Log.d("ZET_Android", "SwitchButton : true")
        else Log.d("ZET_Android", "SwitchButton : false")
    }

    companion object {
        const val BUTTON_DESIGN_NUMBER = 5
    }
}