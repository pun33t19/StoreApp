package com.example.resoluteaidemo.ui

import android.graphics.Typeface
import android.os.Build
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.annotation.RequiresApi
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.resoluteaidemo.MainActivity
import com.example.resoluteaidemo.R
import com.example.resoluteaidemo.adapters.BuyItemsRecyclerViewAdapter
import com.example.resoluteaidemo.adapters.ItemsRecyclerViewAdapter
import com.example.resoluteaidemo.databinding.FragmentHomeBinding
import com.example.resoluteaidemo.model.BuyItemsData
import com.example.resoluteaidemo.model.ItemData
import com.google.android.material.imageview.ShapeableImageView


class HomeFragment : Fragment() {

    private lateinit var itemList:ArrayList<ItemData>
    private lateinit var buyItemList:ArrayList<BuyItemsData>
    private lateinit var binding:FragmentHomeBinding
    private lateinit var adapter:ItemsRecyclerViewAdapter
    private lateinit var buyItemsadapter:BuyItemsRecyclerViewAdapter

    val _binding get() = binding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding= FragmentHomeBinding.inflate(inflater)

        return _binding.root
    }

    @RequiresApi(Build.VERSION_CODES.M)
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        itemList= ArrayList(3)
        buyItemList= ArrayList(2)

        itemList.add(ItemData("Lemon Tea",R.drawable.icetea,true))
        itemList.add(ItemData("Black Tea",R.drawable.blacktea,false))
        itemList.add(ItemData("Green Tea",R.drawable.blacktea,false))

        buyItemList.add(BuyItemsData(R.drawable.coffee,"Bubble tea","Good day time","56.99"))
        buyItemList.add(BuyItemsData(R.drawable.multiple_coffee,"Purple tea","Happy Hours","25.99"))


        adapter= ItemsRecyclerViewAdapter(itemList)
        _binding.drinksRecyclerView.layoutManager=LinearLayoutManager(requireContext(),LinearLayoutManager.HORIZONTAL,false)
        _binding.drinksRecyclerView.adapter=adapter

        buyItemsadapter= BuyItemsRecyclerViewAdapter(buyItemList)
        _binding.willBuyRecyclerView.layoutManager=LinearLayoutManager(requireContext(),LinearLayoutManager.VERTICAL,false)
        _binding.willBuyRecyclerView.adapter=buyItemsadapter



        _binding.recommendationText.setOnClickListener {
            _binding.recommendationText.setTextColor(requireContext().getColor(R.color.secondary_text_color))
            _binding.blackTea.setTextColor(requireContext().getColor(R.color.primary_text_color))
            _binding.greenTea.setTextColor(requireContext().getColor(R.color.primary_text_color))
            _binding.recommendationText.setTypeface(Typeface.DEFAULT_BOLD)
            _binding.blackTea.setTypeface(Typeface.DEFAULT)
            _binding.greenTea.setTypeface(Typeface.DEFAULT)
            _binding.drinksRecyclerView.scrollToPosition(0)
        }

        _binding.blackTea.setOnClickListener {
            _binding.blackTea.setTextColor(requireContext().getColor(R.color.secondary_text_color))
            _binding.recommendationText.setTextColor(requireContext().getColor(R.color.primary_text_color))
            _binding.greenTea.setTextColor(requireContext().getColor(R.color.primary_text_color))
            _binding.recommendationText.setTypeface(Typeface.DEFAULT)
            _binding.blackTea.setTypeface(Typeface.DEFAULT_BOLD)
            _binding.greenTea.setTypeface(Typeface.DEFAULT)
            _binding.drinksRecyclerView.scrollToPosition(1)
        }

        _binding.greenTea.setOnClickListener {
            _binding.greenTea.setTextColor(requireContext().getColor(R.color.secondary_text_color))
            _binding.recommendationText.setTextColor(requireContext().getColor(R.color.primary_text_color))
            _binding.blackTea.setTextColor(requireContext().getColor(R.color.primary_text_color))
            _binding.recommendationText.setTypeface(Typeface.DEFAULT)
            _binding.blackTea.setTypeface(Typeface.DEFAULT)
            _binding.greenTea.setTypeface(Typeface.DEFAULT_BOLD)
            _binding.drinksRecyclerView.scrollToPosition(2)
        }

        (activity as MainActivity).findViewById<ShapeableImageView>(R.id.drawer_icon).visibility=View.VISIBLE

    }


}