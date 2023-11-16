package com.yusuf.takenote.ui

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import com.yusuf.takenote.R
import com.yusuf.takenote.adapter.NoteAdapter
import com.yusuf.takenote.databinding.ActivityMainBinding
import com.yusuf.takenote.db.Note

class MainActivity : AppCompatActivity() {
    private lateinit var noteList: ArrayList<Note>
    private lateinit var binding: ActivityMainBinding
    private lateinit var adapter:NoteAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        noteList = ArrayList<Note>()
        val note1 = Note(1,"Math",80,90)
        val note2 = Note(2,"Bio",70,80)
        val note3 = Note(3,"PE",50,60)

        noteList.add(note1)
        noteList.add(note2)
        noteList.add(note3)

        binding.recyclerView.layoutManager = LinearLayoutManager(this@MainActivity)
        adapter = NoteAdapter(this@MainActivity,noteList)
        binding.recyclerView.adapter = adapter

        binding.floatingActionButton.setOnClickListener {
            val intent = Intent(this@MainActivity,SaveNote::class.java)
            intent.putExtra("info",1)
            startActivity(intent)
            finish()
        }

    }

    override fun onBackPressed() {
        val intent = Intent(Intent.ACTION_MAIN)
        intent.addCategory(Intent.CATEGORY_HOME)
        intent.flags=Intent.FLAG_ACTIVITY_NEW_TASK
        startActivity(intent)
        super.onBackPressed()
    }
}