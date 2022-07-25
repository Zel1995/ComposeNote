package com.example.notecompose.feature_note.domain.use_case

import com.example.notecompose.feature_note.domain.model.Note
import com.example.notecompose.feature_note.domain.repository.NoteRepository

class GetNoteUseCase(val repository: NoteRepository) {
    suspend operator fun invoke(id: Int): Note? {
        return repository.getNotesById(id)
    }
}
