package buy.coke.zet.data.di

import android.content.SharedPreferences
import buy.coke.zet.data.util.Constants
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import okhttp3.Interceptor
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit.Builder
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object NetworkModule {
    private val logging = HttpLoggingInterceptor().apply {
        level = HttpLoggingInterceptor.Level.BODY
    }

    private fun getTokenFromSharedPreferences(sharedPreferences: SharedPreferences): String? {
        return sharedPreferences.getString(Constants.USER_ACCESS_TOKEN, null)
    }

    private fun authorizationInterceptor(sharedPreferences: SharedPreferences): Interceptor {
        return Interceptor { chain ->
            val token = getTokenFromSharedPreferences(sharedPreferences)
            val newRequest = chain.request().newBuilder()
                .apply {
                    if (token != null) {
                        addHeader("Authorization", "Bearer $token")
                    }
                }
                .build()
            chain.proceed(newRequest)
        }
    }

    @Provides
    @Singleton
    fun provideOkHttpClient(
        sharedPreferences: SharedPreferences
    ): OkHttpClient {
        return OkHttpClient.Builder()
            .addInterceptor(logging)
            .addInterceptor(authorizationInterceptor(sharedPreferences))
            .build()
    }

    @Provides
    @Singleton
    fun provideRetrofitBuilder(): Builder {
        return Builder()
            .addConverterFactory(GsonConverterFactory.create())
    }
}