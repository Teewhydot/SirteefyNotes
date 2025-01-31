package ng.com.sirteefyapps.sirteefynotes.data

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Update
import ng.com.sirteefyapps.sirteefynotes.models.Note

@Dao
interface NotesDatabaseDao {
    @Query("SELECT * from notes_table")
    fun getNotes(): List<Note>


    @Query("SELECT * from notes_table where id =:id")
    fun getNoteById(id: String): Note


    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insert(note: Note)


    @Query("DELETE from notes_table")
    fun deleteAll()


    @Update(onConflict = OnConflictStrategy.REPLACE)
    fun update(note: Note)

    @Delete
    fun deleteNote(note: Note)
}
