package com.dicoding.tokoh2hebatdiislam
import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.view.MenuItem
import android.view.View
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class halaman_about : AppCompatActivity(), View.OnClickListener {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_halaman_about)

        supportActionBar?.title = "Profile"

        // Aktifkan tombol back di ActionBar
        val actionBar = supportActionBar
        actionBar?.setDisplayHomeAsUpEnabled(true)

//        Mengambil data dari resources
        val nama = getString(R.string.nama)
        val schoolName = getString(R.string.schoolname)
        val jurusan = getString(R.string.jurusan)

        // Set data ke elemen tampilan
        val tvProfileName = findViewById<TextView>(R.id.tvProfileName)
        val tvSchoolName = findViewById<TextView>(R.id.tvSchoolName)
        val tvJurusan = findViewById<TextView>(R.id.tvJurusan)
        val btnSocialMedia = findViewById<Button>(R.id.btnSocialMedia)

        // Menampilkan data di TextView
        tvProfileName.text = nama
        tvSchoolName.text = schoolName
        tvJurusan.text = jurusan

        // Tambahkan onClickListener untuk tombol sosial media
        btnSocialMedia.setOnClickListener(this)
    }


    override fun onClick(p0: View?) {
        when (p0?.id) {
            R.id.btnSocialMedia -> {
                // Gantilah dengan tautan ke sosial media Anda
                val socialMediaUrl = "https://www.linkedin.com/in/faishol-wijanarko-4338131a0/"
                val intent = Intent(Intent.ACTION_VIEW, Uri.parse(socialMediaUrl))
                startActivity(intent)
            }
        }
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            android.R.id.home -> {
                // Ketika tombol back di ActionBar ditekan
                onBackPressed()
                return true
            }
        }
        return super.onOptionsItemSelected(item)
    }
}
