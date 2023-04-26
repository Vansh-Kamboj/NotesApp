package com.example.notesapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity(),ClickNote {

    lateinit var noteViewModel: NoteViewModel
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        recyclerView.layoutManager=LinearLayoutManager(this)
        val adapter=NoteAdapt(this,this)
        recyclerView.adapter=adapter
        noteViewModel=ViewModelProvider(this,ViewModelProvider.AndroidViewModelFactory.getInstance(application)).get(NoteViewModel::class.java)
    noteViewModel.allNotes.observe(this,Observer{
     list->list?.let { adapter.updateNoteList(it) }
    })
    }

    override fun onClick(note: Note) {
       noteViewModel.deleteNote(note)
    }

    fun submitNote(view: View) {
        val text=Input_text.text.toString()
        if(text.isNotEmpty()){
            noteViewModel.InsertNote(Note(text))
        }
    }
}