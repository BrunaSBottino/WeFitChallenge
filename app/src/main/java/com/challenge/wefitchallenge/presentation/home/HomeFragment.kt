package com.challenge.wefitchallenge.presentation.home

import android.content.Context
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.challenge.wefitchallenge.R
import com.challenge.wefitchallenge.data.PersistenceManager
import com.challenge.wefitchallenge.data.models.ApiResponse
import com.challenge.wefitchallenge.data.models.HomeState
import com.challenge.wefitchallenge.databinding.BottomSheetDialogBinding
import com.challenge.wefitchallenge.databinding.FragmentHomeBinding
import com.challenge.wefitchallenge.presentation.home.viewmodel.MainViewModel
import com.google.android.material.bottomsheet.BottomSheetDialog
import kotlinx.coroutines.*
import org.koin.android.ext.android.inject
import org.koin.androidx.viewmodel.ext.android.viewModel

class HomeFragment : Fragment() {

    private lateinit var binding: FragmentHomeBinding
    private val viewModel : MainViewModel by viewModel()
    private val persistenceManager : PersistenceManager by inject()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentHomeBinding.inflate(layoutInflater)
        setupObserver()
        viewModel.loadRepositories()
        binding.ivIconConfig.setOnClickListener {
            showBottomSheetDialog()
        }
        return binding.root
    }

    private fun showBottomSheetDialog() {
        context?.let { context ->
            val bottomSheetDialog = UpdateUserBottomSheet(context){
                viewModel.loadRepositories(it)
            }
            bottomSheetDialog.show()
        }

    }

    class UpdateUserBottomSheet(context: Context, private val onSave: (String)->Unit) : BottomSheetDialog(context){

        private lateinit var binding: BottomSheetDialogBinding

        override fun onCreate(savedInstanceState: Bundle?) {
            super.onCreate(savedInstanceState)
            binding = BottomSheetDialogBinding.inflate(layoutInflater)
            setContentView(binding.root)
            binding.buttonSaveUser.setOnClickListener {
                onSave(binding.etBottomSheet.text.toString())
                dismiss()
            }
        }

    }

    private fun setupObserver() {
        viewModel.state.observe(viewLifecycleOwner) {
            when (it) {
                HomeState.Loading -> showLoading()
                is HomeState.Error -> showError()
                is HomeState.Success -> showRepositoriesList(it.response)
            }
        }
    }

    private fun showRepositoriesList(data: ApiResponse) {
        binding.rvCardContainer.run {
            adapter = HomeCardAdapter(
                repositoryList = data
            ) {
                CoroutineScope(Dispatchers.IO).launch {
                    persistenceManager.saveRepository(it)
                }
            }
            layoutManager = LinearLayoutManager(context, RecyclerView.VERTICAL, false)
        }
    }

    private fun showError() {

    }

    private fun showLoading() {

    }
}