package ng.com.sirteefyapps.sirteefynotes.data

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Update
import kotlinx.coroutines.flow.Flow
import ng.com.sirteefyapps.sirteefynotes.models.Note

@Dao
interface NotesDatabaseDao {
    @Query("SELECT * from notes_table")
    fun getNotes(): Flow<List<Note>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend  fun insert(note: Note)

    @Delete
    suspend  fun deleteNote(note: Note)

    @Update(onConflict = OnConflictStrategy.REPLACE)
    suspend  fun updateNote(note: Note)
}
