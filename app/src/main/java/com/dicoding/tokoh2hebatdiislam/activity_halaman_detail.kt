package com.dicoding.tokoh2hebatdiislam

import android.content.Intent
import android.os.Bundle
import android.view.Menu
import android.widget.ImageView
import android.widget.TextView

import androidx.appcompat.app.AppCompatActivity

class activity_halaman_detail : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_halaman_detail)

        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        // Mengambil data dari Intent
        val nama = intent.getStringExtra("nama")
        val deskripsi = intent.getStringExtra("deskripsi")
        val foto = intent.getIntExtra("gambar", 1) //ini untuk gambar

        // Mendapatkan referensi elemen-elemen tampilan dari layout
        val tvDeskripsi = findViewById<TextView>(R.id.tv_item_description)
        val imgFoto = findViewById<ImageView>(R.id.img_item_photo)
        val tvTokohIslam = findViewById<TextView>(R.id.tv_tokoh_islam)

        // Menampilkan data di elemen-elemen tampilan
        val deskripsiDenganEnter = deskripsi?.replace("\\n", "\n")
        tvDeskripsi.text = "Deskripsi:\n$deskripsiDenganEnter"
        imgFoto.setImageResource(foto)
        tvTokohIslam.text = "Tokoh Islam: $nama"
    }

    override fun onSupportNavigateUp(): Boolean {
        onBackPressed()
        return true
    }
    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu, menu)

        // Set onClickListener untuk item Share
        val shareItem = menu?.findItem(R.id.action_share)
        shareItem?.setOnMenuItemClickListener {

            val shareIntent = Intent(Intent.ACTION_SEND)
            shareIntent.type = "text/plain"
            shareIntent.putExtra(Intent.EXTRA_TEXT, "Teks yang akan dibagikan")
            startActivity(Intent.createChooser(shareIntent, "Bagikan ke:"))
            true
        }

        return true
    }
}

