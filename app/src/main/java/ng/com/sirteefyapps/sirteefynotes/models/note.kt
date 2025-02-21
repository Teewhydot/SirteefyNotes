package ng.com.sirteefyapps.sirteefynotes.models

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import java.util.UUID



@Entity(tableName = "notes_table")
data class Note(
    @PrimaryKey
    val id: UUID = UUID.randomUUID(),

    @ColumnInfo(name = "note_title")
    val title: String,

    @ColumnInfo(name = "note_content")
    val content: String,
)
