package ng.com.sirteefyapps.sirteefynotes.presentation

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import ng.com.sirteefyapps.sirteefynotes.models.Note
import ng.com.sirteefyapps.sirteefynotes.presentation.widgets.NoteItem
import ng.com.sirteefyapps.sirteefynotes.view_models.NotesViewModel

@Composable
fun NotesList(viewModel: NotesViewModel = viewModel()){
        LazyColumn(
            modifier = Modifier.fillMaxSize().padding(16.dp)
        ) {
            items(viewModel._notes.size) { index ->
                NoteItem(
                    note = viewModel._notes[index],
                    onTapNoteItem = {
                        viewModel.removeNote(viewModel._notes[index])
                    }
                )
            }
        }
}
