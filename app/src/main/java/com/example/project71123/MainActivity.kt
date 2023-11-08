package com.example.project71123

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.content.Intent

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //Button Click start HelloActivity
        val button = findViewById<Button>(R.id.button)
        button.setOnClickListener {

            val intent = Intent(this@MainActivity, HelloActivity::class.java)
            startActivity(intent)
        }
    }
}
