package ng.com.sirteefyapps.sirteefynotes.presentation

import android.widget.Toast
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.AbsoluteRoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.Divider
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.ModalBottomSheet
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.material3.rememberModalBottomSheetState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import kotlinx.coroutines.launch
import ng.com.sirteefyapps.sirteefynotes.models.Note
import ng.com.sirteefyapps.sirteefynotes.presentation.widgets.BeveledCornerTextField
import ng.com.sirteefyapps.sirteefynotes.presentation.widgets.beveledCornersShape
import ng.com.sirteefyapps.sirteefynotes.view_models.NotesViewModel

@OptIn(ExperimentalMaterial3Api::class)
@Preview(showBackground = true)
@Composable
fun NotesHome(modifier: Modifier = Modifier, viewModel: NotesViewModel = viewModel()) {
    val currentNote = viewModel.currentNote.collectAsState().value
    var updatedTitle by remember { mutableStateOf("") }
    var updatedContent by remember { mutableStateOf("") }
    var title by remember { mutableStateOf("") }
    var content by remember { mutableStateOf("") }
    val context = LocalContext.current
    val notesViewModel: NotesViewModel = viewModel()
    val sheetState = rememberModalBottomSheetState(
        skipPartiallyExpanded = false,
    )
    val scope = rememberCoroutineScope()
    LaunchedEffect(currentNote) {
        currentNote?.let {
            updatedTitle = it.title
            updatedContent = it.content
            scope.launch {
                sheetState.show()
            }
        }
    }

//    ModalBottomSheet(modifier = Modifier.fillMaxWidth(),
//        sheetState = sheetState,
//        onDismissRequest = {
//        scope.launch {
//            sheetState.hide()
//        }
//    }, content = {
//        Column(modifier = Modifier.padding(16.dp)) {
//            Text(text = "Update Note")
//            Spacer(modifier = Modifier.height(16.dp))
//            BeveledCornerTextField(
//                value = title,
//                label = "New title",
//                onValueChange = {
//                    updatedTitle = it
//                }
//            )
//            Spacer(modifier = Modifier.height(16.dp))
//            BeveledCornerTextField(
//                value = updatedContent,
//                label = "New content",
//                onValueChange = {
//                    updatedContent = it
//                }
//            )
//            Spacer(modifier = Modifier.height(16.dp))
//            Button(modifier = Modifier
//                .fillMaxWidth()
//                .height(50.dp),
//                shape = beveledCornersShape(),
//                onClick = {
//                    if (title.isNotEmpty() && content.isNotEmpty()) {
//                        viewModel.addNote(
//                            Note(
//                                title = title,
//                                content = content
//                            )
//                        )
//                        title = ""
//                        content = ""
//                        Toast.makeText(
//                            context,
//                            "Note saved successfully",
//                            Toast.LENGTH_SHORT
//
//                        ).show()
//                    } else {
//                        Toast.makeText(
//                            context,
//                            "Please enter a title and content",
//                            Toast.LENGTH_SHORT
//                        ).show()
//                    }
//                }) {
//                Text(text = "Update")
//            }
//        }
//    })
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
    ) {
        Spacer(
            modifier = Modifier.height(20.dp)
        )
        BeveledCornerTextField(
            value = title,
            label = "Title",
            onValueChange = {
                title = it
            }
        )
        Spacer(
            modifier = Modifier.height(20.dp)
        )
       BeveledCornerTextField(
           value = content,
           label = "Content",
           onValueChange = {
               content = it
           }
       )
        Spacer(
            modifier = Modifier.height(20.dp)
        )
        Button(modifier = Modifier
            .fillMaxWidth()
            .height(50.dp),
            shape = beveledCornersShape(),
            onClick = {
            if (title.isNotEmpty() && content.isNotEmpty()) {
                viewModel.addNote(
                    Note(
                        title = title,
                        content = content
                    )
                )
                title = ""
                content = ""
                Toast.makeText(
                    context,
                    "Note saved successfully",
                    Toast.LENGTH_SHORT

                ).show()
            } else {
                Toast.makeText(
                    context,
                    "Please enter a title and content",
                    Toast.LENGTH_SHORT
                ).show()
            }
        }) {
            Text(text = "Save")
        }
        Spacer(
            modifier = Modifier.height(20.dp)
        )
        HorizontalDivider(
            thickness = 5.dp,
            color = Color.Gray
        )
        NotesList(viewModel = notesViewModel,sheetState,scope)
        HorizontalDivider(
            thickness = 5.dp,
            color = Color.Gray
        )
    }
}
