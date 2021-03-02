package com.example.crucialemergencyresponse

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.widget.addTextChangedListener
import androidx.navigation.fragment.findNavController
import com.example.crucialemergencyresponse.databinding.FragmentSignupBinding
import com.wajahatkarim3.easyvalidation.core.view_ktx.validator


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

        val binding: FragmentSignupBinding = FragmentSignupBinding.bind(view)
        signupViewBinding = binding

        binding.btnSignup.setOnClickListener {
            if(validateEmail() && validateUserName() && validatePassword() && validateConfirmPassword()){

                val action = SignupFragmentDirections.actionSignupFragmentToSplashActivity(
                )
                findNavController().navigate(action)
                requireActivity().finish()
            }

        }

        binding.btnSignupHaveaccount.setOnClickListener {
            findNavController().navigate(R.id.action_signupFragment_to_loginFragment)
        }

        signupViewBinding.txtInputSignupConfirmpassword.editText?.addTextChangedListener{
            signupViewBinding.txtInputSignupConfirmpassword.error = null
            signupViewBinding.txtInputSignupConfirmpassword.isErrorEnabled = false
        }


    }


    fun validateUserName(): Boolean {
        val userName = signupViewBinding.txtInputSignupUsername.editText!!.text.toString().trim()
        val checkSpaces = "\\A\\w{1,20}\\z".toRegex()

        return if (userName.isEmpty()) {
            signupViewBinding.txtInputSignupUsername.error = "Field Cannot be empty"
            false
        } else if (userName.length > 20) {
            signupViewBinding.txtInputSignupUsername.error = "Username is too long"
            false
        } else if (!userName.matches(checkSpaces)) {
            signupViewBinding.txtInputSignupUsername.error = "No Spaces are allowed"
            false
        } else {
            signupViewBinding.txtInputSignupUsername.error = null
            signupViewBinding.txtInputSignupUsername.isErrorEnabled = false
            true
        }

    }

    fun validateEmail(): Boolean {
        val email = signupViewBinding.txtInputSignupEmail.editText!!.text.toString().trim()
        val checkEmail = "[a-zA-Z0-9._-]+@[a-z]+.+[a-z]+".toRegex()

        return if (email.isEmpty()) {
            signupViewBinding.txtInputSignupEmail.error = "Field Cannot be empty"
            false
        } else if (!email.matches(checkEmail)) {
            signupViewBinding.txtInputSignupEmail.error = "Invalid Email Address"
            false
        } else {
            signupViewBinding.txtInputSignupEmail.error = null
            signupViewBinding.txtInputSignupEmail.isErrorEnabled = false
            true
        }

    }

    private fun validatePassword(): Boolean {
//        val password = sign_up_password.editText!!.text.toString().trim()
//        val checkpassWord = ("^" +
//                //"(?=.*[0-9])" +         //at least 1 digit
//                //"(?=.*[a-z])" +         //at least 1 lower case letter
//                //"(?=.*[A-Z])" +         //at least 1 upper case letter
//                "(?=.*[a-zA-Z])" +      //any letter
//                //"(?=.*[@#$%^&+=])" +    //at least 1 special character
//                "(?=S+$)" +           //no white spaces
//                ".{4,}" +               //at least 4 characters
//                "$").toRegex()
//
//
//        return if (password.isEmpty()) {
//            sign_up_password.error = "Field Cannot be empty"
//            false
//        } else if (!password.matches(checkpassWord)) {
//            sign_up_password.error = "Invalid Password"
//            false
//        } else {
//            sign_up_password.error = null
//            sign_up_password.isErrorEnabled = false
//            true
//        }

        return signupViewBinding.txtInputSignupPassword.editText!!.validator()
            .nonEmpty()
            .atleastOneNumber()
            .atleastOneUpperCase()
            .addErrorCallback {
                signupViewBinding.txtInputSignupPassword.error = it
            }
            .addSuccessCallback {
                signupViewBinding.txtInputSignupPassword.error = null
                signupViewBinding.txtInputSignupPassword.isErrorEnabled = false
            }
            .check()

    }

    private fun validateConfirmPassword() : Boolean{

        return if (signupViewBinding.txtInputSignupEmail.editText!!.text.toString().trim().equals(
            signupViewBinding.txtInputSignupConfirmpassword.editText!!.text.toString().trim())){
            signupViewBinding.txtInputSignupConfirmpassword.error = "Passwords do not match"
            false
        }else{

            true
        }
    }
}