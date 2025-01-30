package ng.com.sirteefyapps.sirteefynotes

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.ui.Modifier
import dagger.hilt.android.AndroidEntryPoint
import ng.com.sirteefyapps.sirteefynotes.presentation.NotesHome
import ng.com.sirteefyapps.sirteefynotes.ui.theme.SirteefyNotesTheme


@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            SirteefyNotesTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    NotesHome(
                        modifier = Modifier.padding(innerPadding)
                    )
                }
            }
        }
    }
}
