package com.example.crucialemergencyresponse

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.example.crucialemergencyresponse.databinding.FragmentSignupBinding


/**
 * A simple [Fragment] subclass.
 * Use the [SignupFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class SignupFragment : Fragment() {

    lateinit var signupViewBinding : FragmentSignupBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_signup, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val binding = FragmentSignupBinding.bind(view)
        signupViewBinding = binding

        binding.btnSignup.setOnClickListener {
            findNavController().navigate(R.id.action_signupFragment_to_mainActivity)
            requireActivity().finish()
        }

        binding.btnSignupHaveaccount.setOnClickListener {
            findNavController().navigate(R.id.action_signupFragment_to_loginFragment)
        }


    }
}