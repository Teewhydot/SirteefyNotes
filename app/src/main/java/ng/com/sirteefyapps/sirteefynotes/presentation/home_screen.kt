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
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import ng.com.sirteefyapps.sirteefynotes.models.Note
import ng.com.sirteefyapps.sirteefynotes.view_models.NotesViewModel

@Preview(showBackground = true)
@Composable
fun NotesHome(modifier: Modifier = Modifier, viewModel: NotesViewModel = viewModel()) {
    var title by remember { mutableStateOf("") }
    var content by remember { mutableStateOf("") }
    val context = LocalContext.current
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
    ) {
        TextField(
            value = title,
            onValueChange = {
                title = it
            },
            label = { Text("Title") },
            modifier = Modifier
                .padding(bottom = 16.dp)
                .fillMaxWidth()
                .height(55.dp)
                .border(1.dp, color = Color.Black, shape = AbsoluteRoundedCornerShape(30.dp)),
            shape = AbsoluteRoundedCornerShape(30.dp),
            colors = TextFieldDefaults.colors(
                focusedIndicatorColor = Color.Transparent,
                unfocusedIndicatorColor = Color.Transparent
            )
        )
        Spacer(
            modifier = Modifier.height(20.dp)
        )
        TextField(
            value = content,
            onValueChange = {
                content = it
            },
            label = { Text("Note content") },
            modifier = Modifier
                .padding(bottom = 16.dp)
                .fillMaxWidth()
                .height(55.dp)
                .border(1.dp, color = Color.Black, shape = AbsoluteRoundedCornerShape(30.dp)),
            shape = AbsoluteRoundedCornerShape(30.dp)
        )
        Spacer(
            modifier = Modifier.height(20.dp)
        )
        Button(modifier = Modifier
            .fillMaxWidth()
            .height(50.dp), onClick = {
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
        NotesList(
        )
    }
}
