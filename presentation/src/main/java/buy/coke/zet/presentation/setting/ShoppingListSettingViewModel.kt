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

    fun onCheckAllButton(isChecked: Boolean) {
        for (stateIndex in _checkStateFlowList.indices) {
            _checkStateFlowList[stateIndex].value = isChecked
        }
    }

    fun onCheckSingleButton(index: Int, isChecked: Boolean) {
        _checkStateFlowList[index].value = isChecked
    }
}