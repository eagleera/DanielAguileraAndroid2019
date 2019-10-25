package com.example.danielaguileraandroid2019

import android.widget.ImageView
import com.squareup.picasso.Picasso


fun ImageView.fromUrl(url:String){
    Picasso.get().load(url).into(this)
}