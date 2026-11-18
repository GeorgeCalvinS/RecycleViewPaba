package com.example.recycleviewpaba

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.recycleviewpaba.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private val _arWayang = ArrayList<dcWayang>()
    private var _nama: Array<String> = arrayOf()
    private var _karakter: Array<String> = arrayOf()
    private var _deskripsi: Array<String> = arrayOf()
    private var _gambar: Array<String> = arrayOf()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        siapkanData()
        tambahData()
        tampilkanData()
    }

    private fun siapkanData() {
        _nama = resources.getStringArray(R.array.namaWayang)
        _karakter = resources.getStringArray(R.array.karakterWayang)
        _deskripsi = resources.getStringArray(R.array.deskripsiWayang)
        _gambar = resources.getStringArray(R.array.gambarWayang)
    }

    private fun tambahData() {
        _arWayang.clear()
        for (i in _nama.indices) {
            val wayang = dcWayang(
                foto = _gambar[i],
                nama = _nama[i],
                karakter = _karakter[i],
                deskripsi = _deskripsi[i]
            )
            _arWayang.add(wayang)
        }
    }

    private fun tampilkanData() {
        binding.rvWayang.layoutManager = LinearLayoutManager(this)
        binding.rvWayang.adapter = adapterRecView(_arWayang)
    }
}
