package com.example.notecompose.feature_note.data.repository

import com.example.notecompose.feature_note.data.data_source.NoteDao
import com.example.notecompose.feature_note.domain.model.Note
import com.example.notecompose.feature_note.domain.repository.NoteRepository
import kotlinx.coroutines.flow.Flow

class NoteRepositoryImpl(
    private val dao: NoteDao
) : NoteRepository {
    override fun getNotes(): Flow<List<Note>> =
        dao.getAllNotes()

    override suspend fun getNotesById(id: Int): Note? =
        dao.getNoteById(id)

    override suspend fun insertNote(note: Note) {
        dao.insertNote(note)
    }

    override suspend fun deleteNote(note: Note) {
        deleteNote(note)
    }
}
