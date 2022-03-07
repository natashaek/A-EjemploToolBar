package com.example.ejemplotoolbar

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.Menu
import android.view.MenuItem
import android.widget.Button
import android.widget.Toast
import androidx.appcompat.widget.SearchView
import androidx.appcompat.widget.ShareActionProvider
import androidx.appcompat.widget.Toolbar
import androidx.core.view.MenuItemCompat


class MainActivity : AppCompatActivity() {

    var toolbar: Toolbar? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        toolbar = findViewById(R.id.toolbar)
        toolbar?.setTitle(R.string.app_name)
        setSupportActionBar(toolbar)

        val bIr = findViewById<Button>(R.id.bIr)

            bIr.setOnClickListener {
                val intent = Intent(this, PantallaDos::class.java)
                startActivity(intent)
            }
    }
    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu, menu)

        val itemsBusqueda = menu?.findItem(R.id.busqueda)
        val vistaBusqueda = itemsBusqueda?.actionView as SearchView
        val itemCompartir = menu?.findItem(R.id.share)
        val shareActionProvider = MenuItemCompat.getActionProvider(itemCompartir) as ShareActionProvider

        compartirIntent(shareActionProvider)

        vistaBusqueda.queryHint = "Escribe tu nombre..."

        vistaBusqueda.setOnQueryTextFocusChangeListener { v, hasFocus ->
            Log.d("LISTENERFOCUS", hasFocus.toString())
        }

        vistaBusqueda.setOnQueryTextListener(object : SearchView.OnQueryTextListener {

            override fun onQueryTextChange(newText: String?): Boolean {
                Log.d("onQueryTextChange", newText!!)
                return true
            }

            override fun onQueryTextSubmit(query: String?): Boolean {
                Log.d("onQueryTextSubmit", query!!)
                return true
            }
        })

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


    private fun compartirIntent(shareActionProvider: ShareActionProvider) {
        if(shareActionProvider != null) {
            val intent = Intent(Intent.ACTION_SEND)
            intent.type = "text/plain"
            intent.putExtra(Intent.EXTRA_TEXT, "Este es un mensaje compartido")
            shareActionProvider.setShareIntent(intent)
        }
    }
}