package buy.coke.zet.presentation

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

class IntroViewModel: ViewModel() {
    private val _clickCountState = MutableStateFlow(0)
    val clickCountState: StateFlow<Int> = _clickCountState.asStateFlow()

    fun rotateDesign() = viewModelScope.launch {
        _clickCountState.value = (++_clickCountState.value) % BUTTON_DESIGN_NUMBER
    }

    companion object {
        const val BUTTON_DESIGN_NUMBER = 5
    }
}