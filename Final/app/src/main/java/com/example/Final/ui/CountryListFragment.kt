package com.example.Final.ui

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.Final.adapters.CountryAdapter
import com.example.Final.databinding.FragmentCountryListBinding
import com.example.Final.models.Country
import com.example.Final.view_models.CountryViewModel
import org.koin.androidx.viewmodel.ext.android.viewModel

class CountryListFragment : Fragment() {

    private lateinit var binding: FragmentCountryListBinding
    private val viewModel: CountryViewModel by viewModel<CountryViewModel>()
    private lateinit var layoutManager: RecyclerView.LayoutManager
    private lateinit var adapter: CountryAdapter


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        Log.e("Page", "List")
        binding = FragmentCountryListBinding.inflate(layoutInflater)
        layoutManager = LinearLayoutManager(activity)
        configureAdapter()

        viewModel.getCountries()

        viewModel.countries.observe(viewLifecycleOwner) { response ->
            if (response.isSuccessful){
                val countries = response.body()
                adapter.submitList(countries)
            }else {
                Log.e("Error", response.errorBody().toString())
                Toast.makeText(context, response.errorBody().toString(), Toast.LENGTH_SHORT).show()
            }
        }
        return binding.root
    }

    private fun configureAdapter() {
        binding.countryListRv.layoutManager = layoutManager
        adapter = CountryAdapter(){toDetail(it)}
        binding.countryListRv.adapter = adapter
    }

    private fun toDetail(country: Country){
        val action = CountryListFragmentDirections.actionCountryListToDetail(country.slug)
        findNavController().navigate(action)
    }
}








