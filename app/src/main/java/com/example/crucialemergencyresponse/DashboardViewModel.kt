package com.example.crucialemergencyresponse

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class DashboardViewModel {

    class MyViewModel : ViewModel() {
        private val users: MutableLiveData<List<User>> by lazy {
            MutableLiveData().also {
                loadUsers()
            }
        }

        fun getUsers(): LiveData<List<User>> {
            return users
        }

        private fun loadUsers() {
            // Do an asynchronous operation to fetch users.
        }
    }
}