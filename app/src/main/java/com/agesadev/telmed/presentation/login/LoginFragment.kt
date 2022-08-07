package com.agesadev.telmed.presentation.login

import android.app.AlertDialog
import android.content.DialogInterface
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.findNavController
import com.agesadev.telmed.R
import com.agesadev.telmed.databinding.FragmentLoginBinding
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.flow.collectLatest


@AndroidEntryPoint
class LoginFragment : Fragment() {

    private var _binding: FragmentLoginBinding? = null
    private val binding get() = _binding

    private val loginViewModel: LoginViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentLoginBinding.inflate(inflater, container, false)
        binding?.loginButton?.setOnClickListener {
            loginUser()
        }
        return binding?.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewLifecycleOwner.lifecycleScope.launchWhenCreated {
            loginViewModel.loginState.collectLatest { state ->
                when (state) {
                    is LoginState.Success -> {
                        when (state.response.token) {
                            null -> {
                                Toast.makeText(requireContext(), "Login Failed", Toast.LENGTH_SHORT)
                                    .show()
                                //show error dialog
                                AlertDialog.Builder(context)
                                    .setTitle("Login Failed")
                                    .setMessage("Login Failed")
                                    .setIcon(android.R.drawable.ic_dialog_alert)
                                    .show()
                            }
                            else -> {
                                Toast.makeText(requireContext(), "Login Ok", Toast.LENGTH_SHORT)
                                    .show()
                                findNavController().navigate(R.id.action_loginFragment_to_patientDetailsFragment)
                            }
                        }
                    }
                    is LoginState.Failure -> {
                        Toast.makeText(requireContext(), "Failed", Toast.LENGTH_SHORT).show()
                        //show error dialog
                        AlertDialog.Builder(context)
                            .setTitle("Login Failed")
                            .setMessage("Login Failed")
                            .setIcon(android.R.drawable.ic_dialog_alert)
                            .show()

                    }
                }
            }
        }
    }

    private fun loginUser() {
        loginViewModel.login(
            binding?.emailEdt?.text.toString(),
            binding?.passwordEdt?.text.toString()
        )
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

    }

}