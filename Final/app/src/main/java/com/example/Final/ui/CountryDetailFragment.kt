package com.example.Final.ui

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.navArgs
import com.example.Final.R
import com.example.Final.databinding.FragmentCountryDetailBinding
import com.example.Final.view_models.CountryViewModel
import org.koin.androidx.viewmodel.ext.android.viewModel
import java.text.SimpleDateFormat
import java.util.*


class CountryDetailFragment : Fragment() {
    private val args: CountryDetailFragmentArgs by navArgs()
    private lateinit var binding: FragmentCountryDetailBinding
    private val viewModel: CountryViewModel by viewModel<CountryViewModel>()



    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentCountryDetailBinding.inflate(layoutInflater)
        val slug = args.slug
        viewModel.getStatistics(slug)

        viewModel.statistics.observe(viewLifecycleOwner) { response->
            if (response.isSuccessful){
                val statistics = response.body()
                if (statistics!!.isEmpty()){
                    return@observe
                }
                val statistic = statistics.last()
                binding.country.text = "Country: " + statistic.country
                binding.deaths.text = "Deaths: " + statistic.deaths.toString()
                binding.date.text = "Date: " + SimpleDateFormat("yyyy-MM-dd", Locale.ROOT).format(statistic.date)
                binding.time.text = "Time: " + SimpleDateFormat("HH:mm:ss", Locale.ROOT).format(statistic.date)
                binding.recovered.text = "Recovered: " + statistic.recovered.toString()
            }
        }

        return binding.root
    }
}