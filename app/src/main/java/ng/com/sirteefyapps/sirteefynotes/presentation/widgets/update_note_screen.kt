//package ng.com.sirteefyapps.sirteefynotes.presentation.widgets
//import androidx.compose.foundation.layout.*
//import androidx.compose.material3.*
//import androidx.compose.runtime.*
//import androidx.compose.ui.Modifier
//import androidx.compose.ui.unit.dp
//import kotlinx.coroutines.launch
//
//@OptIn(ExperimentalMaterial3Api::class)
//
//@Composable
//fun UpdateNoteBottomSheet() {
//    var updatedtitle by remember { mutableStateOf("") }
//    var updatedcontent by remember { mutableStateOf("") }
//    val sheetState = rememberModalBottomSheetState()
//    val scope = rememberCoroutineScope()
//    ModalBottomSheet(modifier = Modifier.fillMaxWidth(), onDismissRequest = {},
//        shape = BottomSheetDefaults.ExpandedShape,
//        sheetState = sheetState) {
//        Column(modifier = Modifier.padding(16.dp)){
//            Text(text = "Update Note")
//            Spacer(modifier = Modifier.height(16.dp))
//            BeveledCornerTextField(
//                value = updatedtitle,
//                label = "Title",
//                onValueChange = {
//                    updatedtitle = it
//                }
//            )
//            Spacer(modifier = Modifier.height(16.dp))
//            BeveledCornerTextField(
//                value = updatedcontent,
//                label = "Content",
//                onValueChange = {
//                    updatedcontent = it
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
//                            "Note updated successfully",
//                            Toast.LENGTH_SHORT
//
//                        ).show()
//                    } else {
//                        Toast.makeText(
//                            context,
//                            "Please enter the updated title and content",
//                            Toast.LENGTH_SHORT
//                        ).show()
//                    }
//                }) {
//                Text(text = "Update Note")
//            }
//        }
//    }
//}
