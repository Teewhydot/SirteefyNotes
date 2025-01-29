package ng.com.sirteefyapps.sirteefynotes.view_models

import androidx.compose.runtime.mutableStateListOf
import androidx.lifecycle.ViewModel
import ng.com.sirteefyapps.sirteefynotes.models.Note

class NotesViewModel : ViewModel() {
    var _notes = mutableStateListOf<Note>()

    fun addNote(note: Note) {
        _notes.add(note)
    }

    fun removeNote(note: Note) {
        _notes.remove(note)
    }

}
