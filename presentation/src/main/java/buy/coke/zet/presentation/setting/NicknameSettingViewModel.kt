package buy.coke.zet.presentation.setting

import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow

class NicknameSettingViewModel: ViewModel() {
    private val _currentNicknameFlow = MutableStateFlow("")
    val currentNicknameFlow: StateFlow<String> = _currentNicknameFlow

    private val _nicknameStatusFlow = MutableStateFlow(NicknameStatus.EMPTY)
    val nicknameStatusFlow: StateFlow<NicknameStatus> = _nicknameStatusFlow

    fun onTextChanged(s: CharSequence, start: Int, before: Int, count: Int) {
        _currentNicknameFlow.value = s.toString()
        _nicknameStatusFlow.value = getNicknameStatus(s.toString())
    }

    private fun getNicknameStatus(nickname: String): NicknameStatus {
        val regex = Regex("^[\\p{L}\\p{N}]+\$")

        return if (nickname.isEmpty()) {
            NicknameStatus.EMPTY
        } else if (!regex.matches(nickname)) {
            NicknameStatus.WRONG_TEXT
        } else if (nickname.length >= 10) {
            NicknameStatus.MAX
        } else {
            NicknameStatus.VALID
        }
    }

    enum class NicknameStatus {
        EMPTY, VALID, WRONG_TEXT, MAX
    }
}