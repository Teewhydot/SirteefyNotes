package ng.com.sirteefyapps.sirteefynotes.data

import androidx.room.Database
import androidx.room.RoomDatabase
import ng.com.sirteefyapps.sirteefynotes.models.Note

@Database(entities = [Note::class], version = 1, exportSchema = false)
abstract  class NotesDatabase: RoomDatabase(){
    abstract  fun notesDao(): NotesDatabaseDao
}
