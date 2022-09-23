package com.challenge.wefitchallenge.presentation.favorites

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.challenge.wefitchallenge.data.PersistenceManager
import com.challenge.wefitchallenge.data.models.RepositoryInfo
import com.challenge.wefitchallenge.databinding.FragmentFavoritesBinding
import com.challenge.wefitchallenge.presentation.home.HomeCardAdapter
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import org.koin.android.ext.android.inject


class FavoritesFragment : Fragment() {

    private lateinit var binding: FragmentFavoritesBinding
    private val persistenceManager : PersistenceManager by inject()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentFavoritesBinding.inflate(layoutInflater)
        setupRecyclerView()
        return binding.root
    }

    private fun setupRecyclerView() {
        CoroutineScope(Dispatchers.IO).launch {
            val favorites = persistenceManager.getAll()
            activity?.runOnUiThread {
                binding.rvFavorites.run {
                    layoutManager = LinearLayoutManager(context, RecyclerView.VERTICAL, false)
                    adapter = HomeCardAdapter(
                        repositoryList = favorites as ArrayList<RepositoryInfo>,
                        onClick = null
                    )
                }
            }
        }
    }
}