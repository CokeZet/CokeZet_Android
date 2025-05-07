package buy.coke.zet.presentation.intro.splash

import androidx.lifecycle.ViewModel
import buy.coke.zet.domain.ServiceResult
import buy.coke.zet.domain.entitiy.getprofile.GetProfileResponseEntity
import buy.coke.zet.domain.usecase.IsHasTokenUseCase
import buy.coke.zet.domain.usecase.IsValidTokenUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import javax.inject.Inject

@HiltViewModel
class SplashViewModel @Inject constructor(
    val isHasTokenUseCase: IsHasTokenUseCase,
    val isValidTokenUseCase: IsValidTokenUseCase
): ViewModel() {
    suspend fun isAutoLoginPossible(): ServiceResult<GetProfileResponseEntity> {
        return withContext(Dispatchers.IO) {
            isValidTokenUseCase(isHasTokenUseCase())
        }
    }
}