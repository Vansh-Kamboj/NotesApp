package com.example.notesapp

import androidx.lifecycle.LiveData
import androidx.room.*

@Dao
interface NoteDao {
    @Insert(onConflict=OnConflictStrategy.IGNORE)
     fun insertNote(note:Note)

    @Delete
   suspend fun delete(note:Note)

    @Query("Select * from NotesTable order by id ASC")
      fun getAllNote():LiveData<List<Note>>
}