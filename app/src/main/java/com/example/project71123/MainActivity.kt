package com.example.project71123

import TableButtonAdapter
import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity(), TableButtonAdapter.OnTableItemClickListener {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val tableList = listOf(
            Table("Table 1"),
            Table("Table 2"),
            Table("Table 3") ,
            Table("Table 4")
        )

        val recyclerView: RecyclerView = findViewById(R.id.rvtablelist)

        val adapter = TableButtonAdapter(this, tableList)
        adapter.tableItemClickListener = this

        recyclerView.layoutManager = LinearLayoutManager(this)
        recyclerView.adapter = adapter
    }

    override fun onTableItemClick(table: Table) {
        val intent = Intent(this, HelloActivity::class.java)
        intent.putExtra("tableName", table.tableName)
        startActivity(intent)
    }
}