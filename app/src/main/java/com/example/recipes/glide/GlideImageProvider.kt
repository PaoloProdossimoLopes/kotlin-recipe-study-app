package com.example.recipes.glide

import android.content.Context
import android.net.Uri
import android.widget.ImageView
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.example.recipes.R
import com.example.recipes.recipes.ui.ImageProvider

class GlideImageProvider: ImageProvider {
    override fun loadFrom(uri: Uri, component: ImageView, context: Context) {
        val requestOptions = RequestOptions()
            .centerCrop()
            .error(R.drawable.ic_no_image)
            .placeholder(R.color.gray_100)

        Glide.with(context)
            .load(uri)
            .apply(requestOptions)
            .into(component)
    }
}