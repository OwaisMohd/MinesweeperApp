package com.i.myminesweeper

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.textfield.TextInputLayout
import kotlinx.android.synthetic.main.activity_custom_board.*

class CustomBoard : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_custom_board)

        //findviewbyid ids
        val height = findViewById<TextInputLayout>(R.id.height)
        val width = findViewById<TextInputLayout>(R.id.width)
        val mines = findViewById<TextInputLayout>(R.id.numberOfMines)


        submit_dimen.setOnClickListener {

            var height = Integer.parseInt(height.editText?.text.toString())
            var width = Integer.parseInt(width.editText?.text.toString())
            var mine = Integer.parseInt(mines.editText?.text.toString())
            var temp = height * width;
            if(mine > temp/4){
                Toast.makeText(this, "Number of mines should be less", Toast.LENGTH_SHORT).show()
            }
            else {
                // sending to gameplay for setting up board
                val intent = Intent(this, GamePlay::class.java).apply {
                    putExtra("height", height)  //put the value
                    putExtra("width", width)
                    putExtra("mines", mine)
                }
                startActivity(intent)
            }
        }
    }

}