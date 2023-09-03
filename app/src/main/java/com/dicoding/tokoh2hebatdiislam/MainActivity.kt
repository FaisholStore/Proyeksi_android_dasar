package com.dicoding.tokoh2hebatdiislam

import android.content.Intent
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {
    //     inisialisasi variabel
    private lateinit var rvHeroes: RecyclerView
    private val list = ArrayList<TokohIslam>()

    companion object {
        val INTENT_PARCELABLE ="ini object dari intent"
    }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        rvHeroes = findViewById(R.id.recyclerView)
        rvHeroes.setHasFixedSize(true)
        list.addAll(getLisTokohislam())
        showRecyclerList()
    }
    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu, menu)
        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            R.id.menu_about -> {
                val intent = Intent(this, halaman_about::class.java)
                startActivity(intent)
                return true
            }
            R.id.action_list -> {
                rvHeroes.layoutManager = LinearLayoutManager(this)
            }
            R.id.action_grid -> {
                rvHeroes.layoutManager = GridLayoutManager(this,2)
            }
        }
        return super.onOptionsItemSelected(item)
    }


    private fun getLisTokohislam(): Collection<TokohIslam> {
        val dataName = resources.getStringArray(R.array.ulama_names)
        val dataDescription = resources.getStringArray(R.array.ulama_descriptions)
        val dataPhoto = resources.obtainTypedArray(R.array.ulama_images)

        val listUlama = ArrayList <TokohIslam>()

        for (i in dataName.indices){
            val Ulama = TokohIslam (dataName[i],dataDescription[i],dataPhoto.getResourceId(i,-1))
            listUlama.add(Ulama)
        }
        return listUlama
    }
    private fun showRecyclerList() {
        rvHeroes.layoutManager = LinearLayoutManager(this)
        val listulamaAdapter = ListIslamAdapter(list)
        rvHeroes.adapter = listulamaAdapter

        listulamaAdapter.setOnItemClickCallback(object : ListIslamAdapter.OnItemClickCallback{
            override fun onItemClicked(data:TokohIslam){
                showSelectedUlama(data)
                val intent = Intent(this@MainActivity, activity_halaman_detail::class.java)
                intent.putExtra("nama", data.nama)
                intent.putExtra("deskripsi", data.deskripsi)
                intent.putExtra("gambar", data.foto)
                startActivity(intent)
            }

        })
    }
    private fun showSelectedUlama(hero: TokohIslam) {
        Toast.makeText(this, "Kamu memilih " + hero.nama, Toast.LENGTH_SHORT).show()

    }


}