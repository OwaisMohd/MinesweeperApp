package com.i.myminesweeper

import android.content.Intent
import android.os.Bundle
import com.google.android.material.floatingactionbutton.FloatingActionButton
import com.google.android.material.snackbar.Snackbar
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.textfield.TextInputLayout
import kotlinx.android.synthetic.main.activity_custom_board.*

class CustomBoard : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_custom_board)

        //getting ids
        val height = findViewById<TextInputLayout>(R.id.hi)
        val width = findViewById<TextInputLayout>(R.id.wi)
        val mines = findViewById<TextInputLayout>(R.id.mi)


        submit.setOnClickListener {

            //after clicking submit button, this will transfer or pass the value which the user has entered
            var heigh = Integer.parseInt(height.editText?.text.toString())
            var widt = Integer.parseInt(width.editText?.text.toString())
            var mine = Integer.parseInt(mines.editText?.text.toString())

            /* passing the values to the gameplay activity */
            val intent = Intent(this, GamePlay::class.java).apply {
                putExtra("height", heigh)  //put the value
                putExtra("width", widt)
                putExtra("mines", mine)
            }
            startActivity(intent)
        }
    }

}