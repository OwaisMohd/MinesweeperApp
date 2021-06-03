package com.i.myminesweeper

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_results.*
import android.content.Intent

class Results : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_results)

        // retrieving from gameplay activity
        var intent = getIntent()
        var showName = intent.getStringExtra("player_name")
        var showResult = intent.getStringExtra("result")


        // Results
        result.text = showName
        try_again.text = showResult

        // returning to home screen
        home.setOnClickListener {
            Toast.makeText(this, "Thank You For Playing", Toast.LENGTH_SHORT).show()
            val intent = Intent(this, MainActivity::class.java).apply {
            }
            startActivity(intent)
        }
    }
    override fun onBackPressed() {
        finishAffinity()
    }
}