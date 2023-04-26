package com.example.notesapp

import androidx.lifecycle.LiveData

class NoteRepoistory(val noteDao: NoteDao) {
    val allnotes:LiveData<List<Note>> =  noteDao.getAllNote()
     suspend fun insertRepo(note:Note){
        noteDao.insertNote(note)
    }
     suspend fun delete(note:Note){
        noteDao.delete(note)
    }
}