package com.agesadev.telmed.presentation.detail

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.repeatOnLifecycle
import androidx.recyclerview.widget.LinearLayoutManager
import com.agesadev.telmed.R
import com.agesadev.telmed.core.ItemClick
import com.agesadev.telmed.databinding.FragmentPatientDetailsBinding
import com.agesadev.telmed.domain.model.Patient
import com.google.android.material.snackbar.Snackbar
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch

@AndroidEntryPoint
class PatientDetailsFragment : Fragment(), ItemClick {

    private var _binding: FragmentPatientDetailsBinding? = null
    private val binding get() = _binding

    private lateinit var patientListAdapter: PatientListAdapter
    private val patientListViewModel: PatientListViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentPatientDetailsBinding.inflate(inflater, container, false)
        return binding?.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setUpRecyclerView()
        getAndObservePatients()

    }

    private fun setUpRecyclerView() {
        patientListAdapter = PatientListAdapter(this)
        binding?.patientListRecycler?.apply {
            layoutManager = LinearLayoutManager(context)
            adapter = patientListAdapter
        }

    }

    private fun getAndObservePatients() {
        lifecycleScope.launch {
            viewLifecycleOwner.lifecycle.repeatOnLifecycle(Lifecycle.State.STARTED) {
                patientListViewModel.patientList.collectLatest { state ->
                    when {
                        state.data.isNotEmpty() -> {
                            patientListAdapter.submitList(state.data)
                            hideProgressBar()
                        }

                        state.isLoading -> {
                            showProgressBar()
                        }
                        else -> {
                            hideProgressBar()
                            Snackbar.make(
                                binding?.root!!,
                                "Error loading patients",
                                Snackbar.LENGTH_LONG
                            ).show()
                        }
                    }
                }
            }
        }

    }

    private fun showProgressBar() {
        binding?.patientListProgressbar?.visibility = View.VISIBLE
    }

    private fun hideProgressBar() {
        binding?.patientListProgressbar?.visibility = View.GONE
    }


    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    override fun onPatientClick(patient: Patient) {

    }
}