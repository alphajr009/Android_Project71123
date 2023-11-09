package com.example.project71123

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import android.widget.Toast

class HelloActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_hello)

        val tableName = intent.getStringExtra("tableName")
        // Handle the clicked table here based on the tableName
        Toast.makeText(this, "Clicked on $tableName", Toast.LENGTH_SHORT).show()
    }
}