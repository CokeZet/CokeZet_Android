package buy.coke.zet.data.di

import buy.coke.zet.data.repository.AuthRepositoryImpl
import buy.coke.zet.data.repository.ContentsRepositoryImpl
import buy.coke.zet.data.repository.ProductRepositoryImpl
import buy.coke.zet.data.repository.PromotionRepositoryImpl
import buy.coke.zet.data.repository.UserRepositoryImpl
import buy.coke.zet.domain.repository.AuthRepository
import buy.coke.zet.domain.repository.ContentsRepository
import buy.coke.zet.domain.repository.ProductRepository
import buy.coke.zet.domain.repository.PromotionRepository
import buy.coke.zet.domain.repository.UserRepository
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
abstract class RepositoryModule {

    @Binds
    abstract fun bindAuthRepository(
        authRepositoryImpl: AuthRepositoryImpl
    ): AuthRepository

    @Binds
    abstract fun bindUserRepository(
        userRepositoryImpl: UserRepositoryImpl
    ): UserRepository

    @Binds
    abstract fun bindPromotionRepository(
        promotionRepositoryImpl: PromotionRepositoryImpl
    ): PromotionRepository

    @Binds
    abstract fun bindProductRepository(
        productRepositoryImpl: ProductRepositoryImpl
    ): ProductRepository

    @Binds
    abstract fun bindContentsRepository(
        contentsRepositoryImpl: ContentsRepositoryImpl
    ): ContentsRepository
}