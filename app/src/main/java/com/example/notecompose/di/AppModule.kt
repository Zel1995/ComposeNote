package com.example.notecompose.di

import android.app.Application
import androidx.room.Room
import com.example.notecompose.feature_note.data.data_source.NoteDataBase
import com.example.notecompose.feature_note.data.data_source.NoteDataBase.Companion.DATABASE_NAME
import com.example.notecompose.feature_note.data.repository.NoteRepositoryImpl
import com.example.notecompose.feature_note.domain.repository.NoteRepository
import com.example.notecompose.feature_note.domain.use_case.*
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Provides
    @Singleton
    fun providesNotesDataBase(app: Application): NoteDataBase {
        return Room.databaseBuilder(app, NoteDataBase::class.java, DATABASE_NAME).build()
    }

    @Provides
    @Singleton
    fun provideNoteRepository(db: NoteDataBase): NoteRepository {
        return NoteRepositoryImpl(db.noteDao)
    }

    @Provides
    @Singleton
    fun provideNoteUseCases(repository: NoteRepository): NoteUseCases {
        return NoteUseCases(
            getNotes = GetNotesUseCase(repository),
            deleteNote = DeleteNoteUseCase(repository),
            addNote = AddNoteUseCase(repository),
            getNote = GetNoteUseCase(repository)
        )
    }
}
