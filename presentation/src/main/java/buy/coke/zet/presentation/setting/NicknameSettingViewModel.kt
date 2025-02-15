package buy.coke.zet.presentation.setting

import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow

class NicknameSettingViewModel: ViewModel() {
    private val _currentNicknameFlow = MutableStateFlow("")
    val currentNicknameFlow: StateFlow<String> = _currentNicknameFlow

    fun onTextChanged(s: CharSequence, start: Int, before: Int, count: Int) {
        _currentNicknameFlow.value = s.toString()
    }
}