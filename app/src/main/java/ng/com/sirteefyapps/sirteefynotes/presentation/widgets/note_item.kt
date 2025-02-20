package ng.com.sirteefyapps.sirteefynotes.presentation.widgets
import androidx.compose.foundation.gestures.detectTapGestures
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.input.pointer.pointerInput
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.dp
import ng.com.sirteefyapps.sirteefynotes.models.Note

@Composable

fun NoteItem(note: Note, onTapNoteItem: () -> Unit, onLongPress: () -> Unit) {
    Card(
        modifier = Modifier
            .padding(vertical = 4.dp).pointerInput(Unit) {
                detectTapGestures(
                    onLongPress = {
                        print("Notes item has been long pressed")
                        onLongPress()
                    },
                    onTap = {
                        onTapNoteItem()
                    }
                )
            }
            .fillMaxWidth()
            .height(100.dp),
        elevation = CardDefaults.cardElevation(
            defaultElevation = 5.dp,
            pressedElevation = 10.dp
        ),
        shape = beveledCornersShape(
            cornerSize = 20.dp
        ),
        colors = CardDefaults.cardColors(
            containerColor = Color.LightGray,
        )    ) {
       Column {
           Text(
               text = note.title,
               modifier = Modifier.padding(6.dp),
               style = TextStyle(
                   color = Color.Black
               )
           )
           Text(
               text = note.content,
               modifier = Modifier.padding(10.dp),
               style = TextStyle(
                   color = Color.Black
               )
           )
       }
    }
}
