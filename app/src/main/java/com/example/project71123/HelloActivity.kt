package com.example.project71123

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import android.widget.Toast
import com.google.android.material.appbar.MaterialToolbar

class HelloActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_hello)

        val tableName = intent.getStringExtra("tableName")

        val materialToolbar: MaterialToolbar = findViewById(R.id.messageActualToolbar)
        materialToolbar.title = tableName

        materialToolbar.setNavigationOnClickListener {

            val mainActivityIntent = Intent(this, MainActivity::class.java)
            startActivity(mainActivityIntent)
        }

    }
}
