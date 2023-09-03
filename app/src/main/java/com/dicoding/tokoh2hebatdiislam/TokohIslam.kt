package com.dicoding.tokoh2hebatdiislam

import android.os.Parcelable
import kotlinx.parcelize.Parcelize


@Parcelize
data class TokohIslam(
    val nama: String,       // Nama tokoh Islam
    val deskripsi: String, // Deskripsi atau biografi tokoh Islam
    val foto: Int          // ID resource gambar tokoh Islam (misalnya, R.drawable.namagambar)
): Parcelable


