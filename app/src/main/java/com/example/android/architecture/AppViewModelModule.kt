package com.example.android.architecture

import com.example.android.architecture.repos.AppBaseRepository
import com.example.android.architecture.repos.IbaseRepository
import dagger.Binds
import dagger.Module

import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent

@Module
@InstallIn(ViewModelComponent::class)
abstract class AppViewModelModule {
@Binds
abstract fun providesAppBaseRepository(repository: AppBaseRepository):IbaseRepository
}