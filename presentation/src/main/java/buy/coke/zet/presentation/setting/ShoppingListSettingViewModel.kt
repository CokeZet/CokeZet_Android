package buy.coke.zet.presentation.setting

import android.util.Log
import androidx.databinding.BaseObservable
import androidx.databinding.Bindable
import androidx.lifecycle.ViewModel
import buy.coke.zet.presentation.BR
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow

class ShoppingListSettingViewModel: ViewModel() {
    private val _checkStateFlowList = List(6) { MutableStateFlow(false) }
    val checkStateFlowList: List<StateFlow<Boolean>> = _checkStateFlowList

    private val _canGoNextStep = MutableStateFlow(false)
    val canGoNextStep: StateFlow<Boolean> = _canGoNextStep

    fun onCheckAllButton(isChecked: Boolean) {
        _checkStateFlowList.forEach { state -> state.value = isChecked }
        _canGoNextStep.value = isChecked
    }

    fun onCheckSingleButton(index: Int, isChecked: Boolean) {
        _checkStateFlowList[index].value = isChecked
        _canGoNextStep.value = isAnyStateChecked()
    }

    fun isAnyStateChecked(): Boolean {
        _checkStateFlowList.filterIndexed { index, _ -> index > 0 }
            .forEach { state -> if (state.value) return true }

        return false
    }
}