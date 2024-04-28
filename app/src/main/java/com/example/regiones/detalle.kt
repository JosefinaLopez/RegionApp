package com.example.regiones
import android.os.Bundle
import android.widget.ImageView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.regiones.databinding.DetalleBinding

class detalle : AppCompatActivity() {
   private lateinit var binding: DetalleBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = DetalleBinding.inflate(layoutInflater)
        setContentView(binding.root)



        binding.nombreReg.setText(intent.getStringExtra("nombre"))
        binding.CantDtp.setText(intent.getStringExtra("iso"))
        binding.cabeceraTxt.setText("Cabecera: "+ intent.getStringExtra("cabecera"))
        binding.densidadTxt.setText("Densidad: "+ intent.getStringExtra("densidad"))
        binding.areaTxt.setText("Area en mt2: "+ intent.getStringExtra("area"))
        binding.densidadPoblTxt.setText("Densidad Poblacional: "+intent.getStringExtra("poblacion"))
        binding.RegionTxt.setText("Region: "+ intent.getStringExtra("region"))

        val img:ImageView = findViewById(R.id.imageDpto)
        val imgResource = resources.getIdentifier(intent.getStringExtra("imagen"),"drawable",packageName)
        img.setImageResource(imgResource)
    }
}