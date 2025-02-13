package buy.coke.zet.presentation.setting


import androidx.lifecycle.ViewModel
import buy.coke.zet.common.designsystem.LogoButtonStyle
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import java.util.HashMap

class CardListSettingViewModel: ViewModel() {
    private val _checkStateFlowList = List(MAX_CARD_NUMBER) { MutableStateFlow(false) }
    val checkStateFlowList: List<StateFlow<Boolean>> = _checkStateFlowList

    private val _canGoNextStep = MutableStateFlow(false)
    val canGoNextStep: StateFlow<Boolean> = _canGoNextStep

    fun onCheckSingleButton(index: Int, isChecked: Boolean) {
        _checkStateFlowList[index].value = isChecked
        _canGoNextStep.value = isAnyStateChecked()
    }

    private fun isAnyStateChecked(): Boolean {
        _checkStateFlowList.forEach { state -> if (state.value) return true }

        return false
    }

    companion object {
        const val MAX_CARD_NUMBER = 10
    }
}