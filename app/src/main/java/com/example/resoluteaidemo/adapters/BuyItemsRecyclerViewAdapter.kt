package com.example.resoluteaidemo.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.resoluteaidemo.R
import com.example.resoluteaidemo.model.BuyItemsData
import com.google.android.material.imageview.ShapeableImageView
import com.google.android.material.textview.MaterialTextView

class BuyItemsRecyclerViewAdapter(val buyItemsList:List<BuyItemsData>) : RecyclerView.Adapter<BuyItemsRecyclerViewAdapter.BuyItemsViewHolder>() {
    class BuyItemsViewHolder(val itemView: View):RecyclerView.ViewHolder(itemView){
        val image:ShapeableImageView=itemView.findViewById(R.id.buy_item_image)
        val title:MaterialTextView=itemView.findViewById(R.id.buy_item_name)
        val time:MaterialTextView=itemView.findViewById(R.id.buy_item_time)
        val price:MaterialTextView=itemView.findViewById(R.id.price_text)

        fun bind(item:BuyItemsData){
            Glide.with(itemView.context).load(item.image).into(image)
            title.text=item.title
            time.text=item.time
            price.text=item.price
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BuyItemsViewHolder {
        val view=LayoutInflater.from(parent.context).inflate(R.layout.buy_items_layout,parent,false)
        return BuyItemsViewHolder(view)
    }

    override fun onBindViewHolder(holder: BuyItemsViewHolder, position: Int) {
        val item=buyItemsList[position]
        holder.bind(item)
    }

    override fun getItemCount(): Int {
       return buyItemsList.size
    }
}