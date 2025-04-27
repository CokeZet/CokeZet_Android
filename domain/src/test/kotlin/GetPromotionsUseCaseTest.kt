import buy.coke.zet.domain.ServiceResult
import buy.coke.zet.domain.entitiy.promotion.PromotionItemEntity
import buy.coke.zet.domain.entitiy.promotion.StorePromotionResponseEntity
import buy.coke.zet.domain.repository.PromotionRepository
import buy.coke.zet.domain.usecase.GetPromotionUseCase
import kotlinx.coroutines.test.runTest
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import org.mockito.kotlin.mock
import org.mockito.kotlin.verify
import org.mockito.kotlin.whenever

class GetPromotionUseCaseTest {

    private lateinit var repository: PromotionRepository
    private lateinit var getPromotionsUseCase: GetPromotionUseCase

    @BeforeEach
    fun setUp() {
        repository = mock()
        getPromotionsUseCase = GetPromotionUseCase(repository)
    }

    @Test
    fun `invoke - Promotion을 성공적으로 가져온다`() = runTest {
        // given
        val expectedData = listOf(
            StorePromotionResponseEntity(
                storeName = "GS25",
                promotions = listOf(
                    PromotionItemEntity(
                        productId = 1,
                        productName = "제로콜라",
                        size = "500ml",
                        promotionTypeLabel = "1+1",
                        price = 2000
                    )
                )
            )
        )
        whenever(repository.getStorePromotions()).thenReturn(ServiceResult.Success(expectedData))

        // when
        val result = getPromotionsUseCase()

        // then
        assertEquals(ServiceResult.Success(expectedData), result)
        verify(repository).getStorePromotions()
    }


    @Test
    fun `invoke - Promotion 가져오기에 실패하면 Error를 반환한다`() = runTest {
        // given
        val errorCode = "500"
        val errorMessage = "서버에서 문제가 발생하였습니다."
        whenever(repository.getStorePromotions()).thenReturn(ServiceResult.Error(errorCode, errorMessage))

        // when
        val result = getPromotionsUseCase()

        // then
        assertEquals(ServiceResult.Error(errorCode, errorMessage), result)
        verify(repository).getStorePromotions()
    }

    @Test
    fun `invoke - 네트워크 오류가 발생하면 NetworkError를 반환한다`() = runTest {
        // given
        whenever(repository.getStorePromotions()).thenReturn(ServiceResult.NetworkError)

        // when
        val result = getPromotionsUseCase()

        // then
        assertEquals(ServiceResult.NetworkError, result)
        verify(repository).getStorePromotions()
    }
}