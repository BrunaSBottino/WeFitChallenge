package com.challenge.wefitchallenge.domain

import android.util.Log
import android.widget.ImageView
import com.bumptech.glide.Glide
import com.challenge.wefitchallenge.data.Constants

fun ImageView.loadImage(imageUrl: String){
    try {
        Glide.with(this).load(imageUrl).into(this)
    } catch (e : Exception) {
        Log.e(Constants.tag, "Erro carregando imagem")
    }
}