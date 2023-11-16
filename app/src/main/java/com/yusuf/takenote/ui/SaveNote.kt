package com.yusuf.takenote.ui

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.Button
import android.widget.Toast
import com.google.android.material.snackbar.Snackbar
import com.yusuf.takenote.R
import com.yusuf.takenote.databinding.ActivitySaveNoteBinding
import com.yusuf.takenote.db.Note

class SaveNote : AppCompatActivity() {

    private lateinit var binding: ActivitySaveNoteBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySaveNoteBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val info = intent.getIntExtra("info",0)
        val note = intent.getSerializableExtra("note") as Note?

        if(info==2){

            setSupportActionBar(binding.toolbar2)

            binding.save.visibility = Button.INVISIBLE
            binding.lesson.isFocusable=false
            binding.point1.isFocusable=false
            binding.point2.isFocusable=false
            binding.lesson.setText(note?.lesson)
            binding.point1.setText(note?.point1.toString())
            binding.point2.setText(note?.point2.toString())


        }
        else{
            binding.save.setOnClickListener {
                val intent = Intent(this@SaveNote,MainActivity::class.java)
                startActivity(intent)
                finish()
            }

        }
    }



    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.toolbar_menu,menu)
        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when (item.itemId){
            R.id.delete -> {
                    Snackbar.make(binding.toolbar2,"Are You Sure?",Snackbar.LENGTH_SHORT)
                        .setAction("Yes!"){
                            val intent = Intent(this@SaveNote,MainActivity::class.java)
                            startActivity(intent)
                            finish()
                        }.show()
                true
            }

            R.id.update ->{
                Toast.makeText(this@SaveNote,"Now You Can Change Infos",Toast.LENGTH_SHORT).show()
                binding.save.visibility = Button.VISIBLE
                binding.lesson.isFocusable=true
                binding.point1.isFocusable=true
                binding.point2.isFocusable=true

                binding.save.setOnClickListener {
                    val intent = Intent(this@SaveNote,MainActivity::class.java)
                    startActivity(intent)
                    finish()
                }
                true
            }

            else -> false
        }

    }


}