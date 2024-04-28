package com.example.regiones

import com.example.regiones.Regions.Regiones

object Regions{
    var Regiones = listOf(
        Region(1, "Chinandega", "NI-CI", "Chinandega", 432062.00, 4822.00, 87.7, "Pacífico","chinandega"),
        Region(2, "Boaco", "NI-BO", "Boaco", 174682.00, 4177.00, 41.8, "Centro","boaco"),
        Region(3, "Estelí", "NI-ES", "Estelí", 201548.00, 2230.00, 90.0, "Centro","esteli"),
        Region(4, "Granada", "NI-GR", "Granada", 168186.00, 1040.00, 162.0, "Pacífico","granada"),
        Region(5, "Jinotega", "NI-JI", "Jinotega", 331335.00, 9222.00, 36.0, "Centro","jinotega"),
        Region(6, "Carazo", "NI-CA", "Jinotepe", 186898.00, 1081.00, 172.8, "Pacífico","carazo"),
        Region(7, "Chontales", "NI-CO", "Juigalpa", 153932.00, 6481.00, 24.0, "Centro","chontales"),
        Region(8, "León", "NI-LE", "León", 355779.00, 5138.00, 69.0, "Pacífico","leon"),
        Region(9, "Madriz", "NI-MD", "Somoto", 132459.00, 1708.00, 78.0, "Centro","madriz"),
        Region(10, "Managua", "NI-MN", "Managua", 2132421.00, 3465.00, 365.0, "Pacífico","managua"),
        Region(11, "Masaya", "NI-MS", "Masaya", 289988.00, 611.00, 475.0, "Pacífico","masaya"),
        Region(12, "Matagalpa", "NI-MT", "Matagalpa", 469172.00, 6804.00, 69.0, "Centro","matagalpa"),
        Region(13, "Nueva Segovia", "NI-NS", "Ocotal", 208523.00, 3491.00, 60.0, "Centro","nueva_segovia"),
        Region(14, "Costa Caribe Sur", "NI-CS", "Bluefields", 306510.00, 27260.00, 11.0, "Caribe","raccs"),
        Region(15, "Costa Caribe Norte", "NI-CN", "Puerto Cabezas", 31430.00, 33106.00, 10.0, "Caribe","raccn"),
        Region(16, "Rivas", "NI-RI", "Rivas", 15683.00, 2162.00, 72.0, "Pacífico","rivas"),
        Region(17, "Río San Juan", "NI-SJ", "San Carlos", 95596.00, 7541.00, 13.0, "Caribe","rio_san_juan")

    )


}

class Region (val id:Int,val nombre:String, val iso:String, val cabecera:String,val poblacion:Double, val Area:Double,val densidad:Double,val region:String, val imagen:String){}

fun ObtenerRegion(nombreSelect:String):List<Region>{
    return Regiones.filter{it.region == nombreSelect}
}


