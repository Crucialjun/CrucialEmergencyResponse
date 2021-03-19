package com.example.crucialemergencyresponse

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.example.crucialemergencyresponse.databinding.FragmentLoginBinding
import com.example.crucialemergencyresponse.databinding.FragmentSignupBinding

class LoginFragment : Fragment() {
    lateinit var loginViewBinding : FragmentLoginBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_login, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val binding = FragmentLoginBinding.bind(view)
        loginViewBinding = binding

        binding.btnLogin.setOnClickListener {
            findNavController().navigate(R.id.action_loginFragment_to_splashActivity)
            requireActivity().finish()
        }

        binding.btnLoginRespondent.setOnClickListener {
            findNavController().navigate(R.id.action_loginFragment_to_respondentDashboardActivity)
        }

        binding.btnNewuser.setOnClickListener {
            findNavController().navigate(R.id.action_loginFragment_to_signupFragment)
        }
    }
}