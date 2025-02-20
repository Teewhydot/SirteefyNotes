package ng.com.sirteefyapps.sirteefynotes.view_models

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.distinctUntilChanged
import kotlinx.coroutines.launch
import ng.com.sirteefyapps.sirteefynotes.models.Note
import ng.com.sirteefyapps.sirteefynotes.repositories.NoteRepository
import javax.inject.Inject

@HiltViewModel
class NotesViewModel @Inject constructor(private val noteRepository: NoteRepository) : ViewModel() {
    private val _noteList = MutableStateFlow<List<Note>>(emptyList())
    val noteList = _noteList.asStateFlow()

    // Current note being edited
    private val _currentNote = MutableStateFlow<Note?>(null)
    val currentNote = _currentNote.asStateFlow()

    init {
        viewModelScope.launch(Dispatchers.IO) {
              getNotes()
        }
    }
    private suspend fun getNotes() {
            noteRepository.getAllNotes().distinctUntilChanged().collect {
                _noteList.value = it
            }
    }

    fun addNote(note: Note) {
        viewModelScope.launch {
            noteRepository.addNote(note)
        }
    }

    fun removeNote(note: Note) {
        viewModelScope.launch {
            noteRepository.deleteNote(note)
        }
    }

    fun setCurrentNote(note: Note) {
        _currentNote.value = note
    }
    fun updateNote(note: Note) {
        viewModelScope.launch {
            noteRepository.updateNote(note)
        }
    }

}
