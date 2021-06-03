package com.i.myminesweeper

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.app.AlertDialog
import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    var level = ""
    private lateinit var sharedPreferences: SharedPreferences


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        sharedPreferences = this.getSharedPreferences("time", Context.MODE_PRIVATE)
        bestTime.text = sharedPreferences.getString("Best", "00:00")
        val lasttime: String? = sharedPreferences.getString("Last", "00:00")

        lastGameTime.text = lasttime

        // Make Custom Button
        custom_button.setOnClickListener {

            val intent = Intent(this@MainActivity, CustomBoard::class.java).apply {
                putExtra("height", 9)  //put the value
                putExtra("width", 9)
                putExtra("mines", 40)
            }
            startActivity(intent)
        }

        easy_level.setOnClickListener {
            level = "easy"
        }


        medium_level.setOnClickListener {
            level = "medium"
        }

        hard_level.setOnClickListener {
            level = "hard"
        }

        // start button click handling
        start_button.setOnClickListener {

            if (level == "") {
                Toast.makeText(this, "Choose Valid Option", Toast.LENGTH_SHORT).show()
            } else {
                val intent = Intent(this, GamePlay::class.java).apply {
                    putExtra("selectedLevel", level)
                    putExtra("flag", 1)
                }
                startActivity(intent)
            }
        }
        rules_button.setOnClickListener {
            showInstructions()
        }

    }


    // instructions dialog
    private fun showInstructions() {
        val builder: AlertDialog.Builder = AlertDialog.Builder(this)

        builder.setTitle("INSTRUCTIONS")
        builder.setMessage("The purpose of the game is to open all the cells of the board. You lose if you open a bomb cell.\n" +
                "\n" +
                "Every non-bomb cell you open will tell you the total number of bombs in the eight neighboring cells. Once you are sure that a cell contains a bomb, you can click bomb button at the top to start putting flag on the cells as a reminder. Once you have flagged all the bombs around an open cell, you can quickly open the remaining non-bomb cells.\n" +
                "\n" +
                "Go Play!")

        builder.setCancelable(false)

        builder.setPositiveButton("OK"
        ) { dialog, which ->

        }

        val alertDialog = builder.create()
        alertDialog.show()
    }

    override fun onBackPressed() {
        finishAffinity()
    }

}


