package com.example.notesapp

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.view.menu.MenuView
import androidx.recyclerview.widget.RecyclerView

class NoteAdapt(val context: Context,val listener: ClickNote):RecyclerView.Adapter<NoteAdapt.NoteViewHolder>() {
    val allNotes=ArrayList<Note>()
    inner class NoteViewHolder(itemView: View):RecyclerView.ViewHolder(itemView) {
        val textview:TextView=itemView.findViewById(R.id.NoteText)
        val delete_image:ImageView=itemView.findViewById(R.id.DeleteNote)
    }
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NoteViewHolder {
        val viewHolder=NoteViewHolder(LayoutInflater.from(context).inflate(R.layout.note_item,parent,false))
        viewHolder.delete_image.setOnClickListener{
           listener.onClick(allNotes[viewHolder.adapterPosition])
        }
        return viewHolder

    }

    override fun getItemCount(): Int {
        return allNotes.size
    }

    override fun onBindViewHolder(holder: NoteViewHolder, position: Int) {
     val currnote=allNotes[position]
        holder.textview.text=currnote.text
    }
   fun updateNoteList(noteList:List<Note>){
       allNotes.clear()
       allNotes.addAll(noteList)
       notifyDataSetChanged()
   }
}
interface  ClickNote{
    fun onClick(note:Note){

    }
}