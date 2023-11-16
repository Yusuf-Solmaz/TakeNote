package com.yusuf.takenote.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.yusuf.takenote.databinding.RecyclerRowBinding
import com.yusuf.takenote.db.Note

class NoteAdapter(private val context: Context, private val noteList: List<Note>) : RecyclerView.Adapter<NoteAdapter.NoteHolder>() {

    class NoteHolder(val binding: RecyclerRowBinding ) : RecyclerView.ViewHolder(binding.root) {

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NoteHolder {
        return NoteHolder(RecyclerRowBinding.inflate(LayoutInflater.from(parent.context),parent,false))
    }

    override fun getItemCount(): Int {
       return noteList.size
    }

    override fun onBindViewHolder(holder: NoteHolder, position: Int) {

        holder.binding.lesson.text = noteList[position].lesson
        holder.binding.textViewPoint1.text = noteList[position].point1.toString()
        holder.binding.textViewPoint2.text = noteList[position].point2.toString()

        holder.binding.cardView.setOnClickListener {
            Toast.makeText(context,"Clicked on CardView!",Toast.LENGTH_LONG).show()
        }
    }
}


