package com.example.resoluteaidemo.ui

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.resoluteaidemo.MainActivity
import com.example.resoluteaidemo.R
import com.example.resoluteaidemo.adapters.CartItemsAdapter
import com.example.resoluteaidemo.databinding.FragmentOrdersBinding
import com.example.resoluteaidemo.model.CartItemsData
import com.example.resoluteaidemo.viewmodel.CartItemsViewModel
import com.google.android.material.imageview.ShapeableImageView
import com.google.android.material.snackbar.Snackbar


class OrdersFragment : Fragment(), CartItemsAdapter.OnIconClickListener {

    private val viewModel: CartItemsViewModel by viewModels()
    private lateinit var binding: FragmentOrdersBinding
    private val _binding get() = binding
    private var cartItemList: MutableList<CartItemsData> = mutableListOf()
    private lateinit var adapter: CartItemsAdapter
    var temp = 1
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentOrdersBinding.inflate(layoutInflater)


        return _binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        (activity as MainActivity).findViewById<ShapeableImageView>(R.id.drawer_icon).visibility =
            View.VISIBLE


        cartItemList.add(CartItemsData(R.drawable.coffee, "Bubble Tea", "56.99", 1))
        cartItemList.add(CartItemsData(R.drawable.multiple_coffee, "Purple Tea", "25.99", 1))
        cartItemList.add(CartItemsData(R.drawable.multiple_coffee, "Lemon Tea", "12.99", 1))

        _binding.cartItemsRecyclerView.layoutManager =
            LinearLayoutManager(requireContext(), LinearLayoutManager.VERTICAL, false)
        adapter = CartItemsAdapter(cartItemList, this)
        _binding.cartItemsRecyclerView.adapter = adapter

        _binding.orderButton.setOnClickListener {
            Snackbar.make(it, "Thank you for ordering", Snackbar.LENGTH_LONG).show()
        }


    }

    override fun onPlusClickListener(position: Int) {
        Log.d("Clicked", "Clicked here")
        if (temp != position) {
            viewModel.resetCount()
        }
        val item = cartItemList.get(position)
        viewModel.increaseItemQty()

        temp = position
        viewModel._count.observe(viewLifecycleOwner) {

            cartItemList.set(position, CartItemsData(item.image, item.title, item.price, it))
            adapter.notifyItemChanged(position)
        }

        viewModel.increasePrice(cartItemList[position])

        viewModel._price.observe(viewLifecycleOwner) {
            _binding.priceText.text = it.toString()
            adapter.notifyItemChanged(position)
        }
    }

    override fun onMinusClickListener(position: Int) {
        val item = cartItemList.get(position)
        viewModel.decreaseQuantity(view)

        viewModel._count.observe(viewLifecycleOwner) {


            cartItemList.set(position, CartItemsData(item.image, item.title, item.price, it))
            adapter.notifyItemChanged(position)
        }

        viewModel.decreasePrice(cartItemList[position])

        viewModel._price.observe(viewLifecycleOwner) {
            _binding.priceText.text = it.toString()
            adapter.notifyItemChanged(position)
        }
    }
}