package com.example.notesapp

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class NoteViewModel(application: Application) :AndroidViewModel(application) {
    private val repo:NoteRepoistory
    val allNotes:LiveData<List<Note>>

    init {
        val database=NoteDatabase.getDatabase(application).NoteDao()
        repo=NoteRepoistory(database)
        allNotes=repo.allnotes
    }
    fun deleteNote(note:Note)=viewModelScope.launch(Dispatchers.IO){
       repo.delete(note)
    }
    fun InsertNote(note:Note)=viewModelScope.launch (Dispatchers.IO ){
        repo.insertRepo(note)
    }
}