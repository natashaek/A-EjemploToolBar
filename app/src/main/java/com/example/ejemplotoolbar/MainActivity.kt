package com.example.ejemplotoolbar

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.Toast
import androidx.appcompat.widget.Toolbar

class MainActivity : AppCompatActivity() {

    var toolbar: Toolbar? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        toolbar = findViewById(R.id.toolbar)
        toolbar?.setTitle(R.string.app_name)
        setSupportActionBar(toolbar)
    }
    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu, menu)

        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when(item?.itemId){
            R.id.bFav -> {
                Toast.makeText(this, "Elemento añadido como favorito", Toast.LENGTH_SHORT).show()
                return true
            } else -> {
            return super.onOptionsItemSelected(item)
        }
        }

        return super.onOptionsItemSelected(item)
    }
}