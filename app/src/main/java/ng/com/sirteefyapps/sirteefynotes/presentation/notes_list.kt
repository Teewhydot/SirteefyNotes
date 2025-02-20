package ng.com.sirteefyapps.sirteefynotes.presentation

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.SheetState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.launch
import ng.com.sirteefyapps.sirteefynotes.presentation.widgets.NoteItem
import ng.com.sirteefyapps.sirteefynotes.view_models.NotesViewModel

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun NotesList(viewModel: NotesViewModel = viewModel(),sheetState: SheetState,scope: CoroutineScope){
    val notes = viewModel.noteList.collectAsState().value;
    LazyColumn(
            modifier = Modifier.fillMaxSize().padding(16.dp)
        ) {
            items(viewModel.noteList.value.size) { index ->
                NoteItem(
                    note = notes[index],
                    onTapNoteItem = {
                        viewModel.removeNote(notes[index])
                    },
                    onLongPress = {
                        //   viewModel.setCurrentNote(notes[index])
//                        scope.launch {
//                            sheetState.show()
//                        }
                    }
                )
            }
        }
}
