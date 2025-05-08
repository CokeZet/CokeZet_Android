package buy.coke.zet.data.di

import buy.coke.zet.data.datasource.AuthDataSource
import buy.coke.zet.data.datasource.AuthDataSourceImpl
import buy.coke.zet.data.datasource.ContentsDataSource
import buy.coke.zet.data.datasource.ContentsDataSourceImpl
import buy.coke.zet.data.datasource.ProductDataSource
import buy.coke.zet.data.datasource.ProductDataSourceImpl
import buy.coke.zet.data.datasource.PromotionDataSource
import buy.coke.zet.data.datasource.PromotionDataSourceImpl
import buy.coke.zet.data.datasource.UserDataSource
import buy.coke.zet.data.datasource.UserDataSourceImpl
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
abstract class DataSourceModule {

    @Binds
    abstract fun bindAuthDataSource(
        authDataSourceImpl: AuthDataSourceImpl
    ): AuthDataSource

    @Binds
    abstract fun bindUserDataSource(
        userDataSourceImpl: UserDataSourceImpl
    ): UserDataSource

    @Binds
    abstract fun bindPromotionDataSource(
        promotionDataSourceImpl: PromotionDataSourceImpl
    ): PromotionDataSource

    @Binds
    abstract fun bindProductDataSource(
        productDataSourceImpl: ProductDataSourceImpl
    ): ProductDataSource

    @Binds
    abstract fun bindContentsDataSource(
        contentsDataSourceImpl: ContentsDataSourceImpl
    ): ContentsDataSource
}