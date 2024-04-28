package com.example.regiones

import android.content.Intent
import android.os.Bundle
import android.widget.ListView
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.regiones.databinding.ListRegionsBinding

class list_regions : AppCompatActivity() {
    private lateinit var binding: ListRegionsBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //Se configura e Inicializa
        binding = ListRegionsBinding.inflate(layoutInflater)
        setContentView(binding.root)

        //setContentView(R.layout.list_regions)
        var nombreRegion: TextView = findViewById(R.id.nombreReg)

        val regionSeleccionada = intent.getStringExtra("region")
        nombreRegion.setText("Region del $regionSeleccionada")

        val regiones = regionSeleccionada?.let { ObtenerRegion(it) }

        val listView: ListView = findViewById(R.id.listView1)
        val adapter = regiones?.let { RegionesAdapter(this, it) }
        listView.adapter = adapter

        val cantidad = adapter?.count

        binding.listView1.isClickable = true
        binding.listView1.setOnItemClickListener { parent, view, position, id ->
            // Obteniendo los datos del ítem clicado
            val dtp = regiones?.get(position)

            // Puedes usar 'regionSeleccionada' para hacer lo que necesites, por ejemplo:
            if (regionSeleccionada != null) {
                if (dtp != null) {
                    Toast.makeText(
                        this,
                        "Seleccionado: ${dtp.nombre}",
                        Toast.LENGTH_LONG
                    ).show()

                    // Crear el Intent para abrir la actividad Detalle
                    val i:Intent = Intent(this@list_regions, detalle::class.java)
                    i.putExtra("Id",dtp.id)
                    i.putExtra("nombre", dtp.nombre)
                    i.putExtra("area", dtp.Area.toString())
                    i.putExtra("region", dtp.region)
                    i.putExtra("cabecera", dtp.cabecera)
                    i.putExtra("densidad", dtp.densidad.toString())
                    i.putExtra("iso", dtp.iso)
                    i.putExtra("poblacion", dtp.poblacion.toString())
                    i.putExtra("imagen", dtp.imagen)
                    startActivity(i)

                }
            }
                //print("aquiiii")



        }

        var cant:TextView = findViewById(R.id.CantDtp)
        cant.setText("$cantidad de Departamentos")


    }
}