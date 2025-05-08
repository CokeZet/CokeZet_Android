package buy.coke.zet.data.repository

import buy.coke.zet.data.datasource.ContentsDataSource
import buy.coke.zet.data.mapper.toEntity
import buy.coke.zet.domain.ServiceResult
import buy.coke.zet.domain.entitiy.contents.GetNoticeResponseEntity
import buy.coke.zet.domain.entitiy.contents.GetPrivacyPolicyResponseEntity
import buy.coke.zet.domain.entitiy.contents.GetTermsResponseEntity
import buy.coke.zet.domain.repository.ContentsRepository
import javax.inject.Inject

class ContentsRepositoryImpl @Inject constructor(
    private val contentsDataSource: ContentsDataSource
) : ContentsRepository {
    override suspend fun getNotices(): ServiceResult<List<GetNoticeResponseEntity>> {
        val result = contentsDataSource.getNotices()
        return when (result) {
            is ServiceResult.Success -> ServiceResult.Success(result.data.toEntity())
            is ServiceResult.Error -> ServiceResult.Error(result.code, result.message)
            is ServiceResult.NetworkError -> ServiceResult.NetworkError
        }
    }

    override suspend fun getPrivacyPolicy(): ServiceResult<GetPrivacyPolicyResponseEntity> {
        val result = contentsDataSource.getPrivacyPolicy()
        return when (result) {
            is ServiceResult.Success -> ServiceResult.Success(result.data.toEntity())
            is ServiceResult.Error -> ServiceResult.Error(result.code, result.message)
            is ServiceResult.NetworkError -> ServiceResult.NetworkError
        }
    }

    override suspend fun getTerms(): ServiceResult<GetTermsResponseEntity> {
        val result = contentsDataSource.getTerms()
        return when (result) {
            is ServiceResult.Success -> ServiceResult.Success(result.data.toEntity())
            is ServiceResult.Error -> ServiceResult.Error(result.code, result.message)
            is ServiceResult.NetworkError -> ServiceResult.NetworkError
        }
    }
}