package com.curiousapps.bambupractice.di

import com.curiousapps.bambupractice.data.BamRepoImpl
import com.curiousapps.bambupractice.domain.BamRepo
import com.curiousapps.bambupractice.network.BamApi
import com.curiousapps.bambupractice.util.BASE_URL
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class AppModule {

    @Provides
    @Singleton
    fun provideBamRepo(
        api: BamApi
    ): BamRepo = BamRepoImpl(api)

    @Provides
    @Singleton
    fun provideBamApi(): BamApi{
        return Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(BamApi::class.java)
    }
}