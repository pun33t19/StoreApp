package com.example.resoluteaidemo.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.resoluteaidemo.R
import com.example.resoluteaidemo.model.ItemData
import com.google.android.material.imageview.ShapeableImageView
import com.google.android.material.textview.MaterialTextView

class ItemsRecyclerViewAdapter (val itemList:List<ItemData>): RecyclerView.Adapter<ItemsRecyclerViewAdapter.ItemRecyclerViewHolder>() {
    class ItemRecyclerViewHolder(val itemview: View) : RecyclerView.ViewHolder(itemview){
        val itemImage:ShapeableImageView=itemview.findViewById(R.id.item_img)
        val itemText:MaterialTextView =itemview.findViewById(R.id.item_text)
        val bookmarkIcon:ShapeableImageView =itemview.findViewById(R.id.bookmark_icon)

        fun bind(item: ItemData) {
            itemText.text=item.title
            Glide.with(itemView.context).load(item.img).into(itemImage)
            if (!item.isBookmarked){
                bookmarkIcon.visibility=View.GONE
            }
        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemRecyclerViewHolder {
        val view=LayoutInflater.from(parent.context).inflate(R.layout.items_recycler_view,parent,false)

        return ItemRecyclerViewHolder(view)
    }

    override fun onBindViewHolder(holder: ItemRecyclerViewHolder, position: Int) {
        val item=itemList[position]

        holder.bind(item)
    }

    override fun getItemCount(): Int {
        return itemList.size
    }
}