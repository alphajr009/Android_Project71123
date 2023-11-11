package com.example.project71123

import android.content.Intent
import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.appbar.MaterialToolbar

class HelloActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_hello)

        val tableName = intent.getStringExtra("tableName")

        val materialToolbar: MaterialToolbar = findViewById(R.id.messageActualToolbar)


        val textView8: TextView = findViewById(R.id.textView8)
        val tableNumber = tableName?.let { extractTableNumber(it) }
        textView8.text = tableNumber


        materialToolbar.setNavigationOnClickListener {
            val mainActivityIntent = Intent(this, MainActivity::class.java)
            startActivity(mainActivityIntent)
        }
    }


    private fun extractTableNumber(tableName: String): String {

        val numberRegex = Regex("\\d+")
        val matchResult = numberRegex.find(tableName)
        return matchResult?.value ?: ""
    }
}
