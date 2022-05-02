package com.example.resoluteaidemo.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.resoluteaidemo.R
import com.example.resoluteaidemo.model.CartItemsData
import com.google.android.material.imageview.ShapeableImageView
import com.google.android.material.textview.MaterialTextView

class CartItemsAdapter(val cartItemsList: MutableList<CartItemsData>,val listener:OnIconClickListener) :
    RecyclerView.Adapter<CartItemsAdapter.CartItemsViewHolder>() {

    class CartItemsViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val itemImage: ShapeableImageView = itemView.findViewById(R.id.buy_item_image)
        val itemName: MaterialTextView = itemView.findViewById(R.id.item_name)
        val itemPrice: MaterialTextView = itemView.findViewById(R.id.price_text)
        val itemQty: MaterialTextView = itemView.findViewById(R.id.item_qty)
        val plusButton:MaterialTextView=itemView.findViewById(R.id.plus)
        val minusButton:MaterialTextView=itemView.findViewById(R.id.minus)

        fun bind(items: CartItemsData) {
            Glide.with(itemView.context).load(items.image).into(itemImage)
            itemName.text = items.title
            itemPrice.text = items.price
            itemQty.text = items.qty.toString()
        }
    }

    interface OnIconClickListener{
        fun onPlusClickListener(position:Int)
        fun onMinusClickListener(position:Int)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CartItemsViewHolder {
        val view =
            LayoutInflater.from(parent.context).inflate(R.layout.cart_item_layout, parent, false)

        return CartItemsViewHolder(view)
    }

    override fun onBindViewHolder(holder: CartItemsViewHolder, position: Int) {
        val items = cartItemsList[position]
        holder.bind(items)

        holder.plusButton.setOnClickListener { listener.onPlusClickListener(position) }
        holder.minusButton.setOnClickListener { listener.onMinusClickListener(position) }


    }

    override fun getItemCount(): Int {
        return cartItemsList.size
    }
}