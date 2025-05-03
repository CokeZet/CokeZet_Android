package buy.coke.zet.data.datasource

import androidx.paging.PagingSource
import androidx.paging.PagingState
import buy.coke.zet.data.dto.product.GetProductRequestDto
import buy.coke.zet.data.mapper.toEntity
import buy.coke.zet.domain.ServiceResult
import buy.coke.zet.domain.entitiy.product.GetProductResponseEntity

class ProductPagingSource(
    private val productDataSource: ProductDataSource,
    private val requestDto: GetProductRequestDto
) : PagingSource<Int, GetProductResponseEntity>() {

    override suspend fun load(params: LoadParams<Int>): LoadResult<Int, GetProductResponseEntity> {
        val page = params.key ?: 0
        val size = params.loadSize

        val updatedRequest = requestDto.copy(
            page = page,
            size = size
        )

        return when (val response = productDataSource.getProducts(updatedRequest)) {
            is ServiceResult.Success -> {
                val entityList = response.data.map { it.toEntity() }

                val nextKey = if (entityList.isEmpty()) {
                    null
                } else {
                    page + 1
                }

                LoadResult.Page(
                    data = entityList,
                    prevKey = if (page == 0) null else page - 1,
                    nextKey = nextKey
                )
            }

            is ServiceResult.Error -> {
                LoadResult.Error(Exception(response.message))
            }

            is ServiceResult.NetworkError -> {
                LoadResult.Error(Exception("네트워크 오류 발생"))
            }
        }
    }


    override fun getRefreshKey(state: PagingState<Int, GetProductResponseEntity>): Int? {
        return state.anchorPosition?.let { anchorPosition ->
            val page = state.closestPageToPosition(anchorPosition)
            page?.prevKey?.plus(1) ?: page?.nextKey?.minus(1)
        }
    }
}