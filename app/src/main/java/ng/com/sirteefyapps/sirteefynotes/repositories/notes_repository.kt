package ng.com.sirteefyapps.sirteefynotes.repositories

import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.conflate
import kotlinx.coroutines.flow.flowOn
import ng.com.sirteefyapps.sirteefynotes.data.NotesDatabaseDao
import ng.com.sirteefyapps.sirteefynotes.models.Note
import javax.inject.Inject

class NoteRepository @Inject constructor(private val notesDatabaseDao: NotesDatabaseDao){

    suspend fun addNote(note: Note) = notesDatabaseDao.insert(note)
    suspend fun deleteNote(note: Note) = notesDatabaseDao.deleteNote(note)
    suspend fun updateNote(note: Note) = notesDatabaseDao.updateNote(note)
    fun  getAllNotes() = notesDatabaseDao.getNotes().flowOn(Dispatchers.IO).conflate()
}
