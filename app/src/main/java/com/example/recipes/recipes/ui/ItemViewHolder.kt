package com.example.recipes.recipes.ui

import android.view.View
import androidx.recyclerview.widget.RecyclerView

abstract class ItemViewHolder<D>(view: View): RecyclerView.ViewHolder(view) {
    abstract fun bind(viewData: D)
}