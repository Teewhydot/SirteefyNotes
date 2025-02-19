package ng.com.sirteefyapps.sirteefynotes.dependency_injection

import android.content.Context
import androidx.room.Room
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import ng.com.sirteefyapps.sirteefynotes.data.NotesDatabase
import ng.com.sirteefyapps.sirteefynotes.data.NotesDatabaseDao
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {
        @Singleton
        @Provides
        fun provideNotesDao(notesDatabase: NotesDatabase): NotesDatabaseDao
        = notesDatabase.notesDao()


    @Singleton
    @Provides
    fun provideAppDatabase(
        @ApplicationContext context: Context
    ) = Room.databaseBuilder(
        context,
        NotesDatabase::class.java,
        "notes_db"
    ).fallbackToDestructiveMigration().build()
}
