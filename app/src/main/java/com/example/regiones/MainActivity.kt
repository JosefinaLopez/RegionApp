package com.example.regiones

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.Spinner
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        //El Spinner Va dentro del metodo Oncreate
        //Se crea la lista de elementos
        val items = listOf("Seleccione Una Region","Pacífico","Centro","Caribe")
        //Se obtiene el id del spinner
        val spinner: Spinner = findViewById(R.id.cbxregiones)
        //Se crea un adaptador y ahi se agregan los elementos
        var  adapter = ArrayAdapter(this, android.R.layout.simple_spinner_item,items)
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        spinner.adapter = adapter

        var isFirstTime = true
        spinner.onItemSelectedListener = object: AdapterView.OnItemSelectedListener{
            override fun onItemSelected(
                parent: AdapterView<*>?,
                view: View?,
                position: Int,
                id: Long
            ) {
                val SelectItem = parent?.getItemAtPosition(position).toString()
                val regionesxd = ObtenerRegion(SelectItem)
                //val regionSeleccionada = intent.getStringExtra(SelectItem)
                // Muestra un mensaje Toast con el elemento seleccionado
                if (isFirstTime) {
                    isFirstTime = false
                } else{
                    Toast.makeText(this@MainActivity, "Seleccionaste: $SelectItem", Toast.LENGTH_SHORT).show()
                    val intent = Intent(this@MainActivity, list_regions::class.java)
                    intent.putExtra("region", SelectItem)
                    startActivity(intent)

                }

            }

            override fun onNothingSelected(parent: AdapterView<*>?) {
                TODO("Not yet implemented")
            }
        }

    }


}
