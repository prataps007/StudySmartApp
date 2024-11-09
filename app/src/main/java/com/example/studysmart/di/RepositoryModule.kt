package com.example.studysmart.di

import com.example.studysmart.data.repositoryImpl.SessionRepositoryImpl
import com.example.studysmart.data.repositoryImpl.SubjectRepositoryImpl
import com.example.studysmart.data.repositoryImpl.TaskRepositoryImpl
import com.example.studysmart.domain.repository.SessionRepository
import com.example.studysmart.domain.repository.SubjectRepository
import com.example.studysmart.domain.repository.TaskRepository
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton


@Module
@InstallIn(SingletonComponent::class)
abstract class RepositoryModule {

    @Binds
    @Singleton
    abstract fun bindSubjectRepository(
        subjectRepositoryImpl: SubjectRepositoryImpl
    ): SubjectRepository

    @Binds
    @Singleton
    abstract fun bindTaskRepository(
        taskRepositoryImpl: TaskRepositoryImpl
    ): TaskRepository

    @Binds
    @Singleton
    abstract fun bindSessionRepository(
        sessionRepositoryImpl: SessionRepositoryImpl
    ): SessionRepository

}