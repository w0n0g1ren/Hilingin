package com.example.hilingin.model

data class tempat_wisata(
    var nama : String? = null,
    var lokasi : String? = null,
    var tiket : Int? = null,
    var gambar : String? = null,
    var keterangan : String? = null
){
    constructor() : this(
        "",
        "",
        0,
        "",
        ""
    )
}
