package buy.coke.zet.data.di

import buy.coke.zet.data.datasource.AuthDataSource
import buy.coke.zet.data.datasource.AuthDataSourceImpl
import buy.coke.zet.data.datasource.GoogleAuthDataSource
import buy.coke.zet.data.datasource.GoogleAuthDataSourceImpl
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
    abstract fun bindGoogleAuthDataSource(
        googleAuthDataSourceImpl: GoogleAuthDataSourceImpl
    ): GoogleAuthDataSource
}