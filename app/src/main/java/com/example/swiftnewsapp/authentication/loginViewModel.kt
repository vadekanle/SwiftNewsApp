package com.example.swiftnewsapp.authentication

import android.util.Log
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.google.firebase.Firebase
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.auth
import kotlinx.coroutines.launch

class loginViewModel : ViewModel() {


    private val auth: FirebaseAuth = Firebase.auth


    var isLoading by mutableStateOf(false)

    var loginErr by mutableStateOf("")


    fun signInWithEmailAndPassword(email: String, password: String, home: () -> Unit) =
        viewModelScope.launch {

            isLoading = true
            auth.signInWithEmailAndPassword(email, password)
                .addOnCompleteListener { task ->
                    if (task.isSuccessful) {
                        Log.d("FB", "signin good : ${task.result}")
                        home()
                    }
                    isLoading = false
                }.addOnFailureListener { result ->
                    Log.d("FB", "signin bad : ${result.message}")
                    loginErr = result.message.toString()
                }
        }


    fun createUserWithEmailAndPassword(
        email: String,
        password: String,
        home: () -> Unit,

        ) = viewModelScope.launch {
        if (isLoading == false) {
            isLoading = true

            auth.createUserWithEmailAndPassword(email, password)
                .addOnCompleteListener { task ->
                    if (task.isSuccessful) {
                        home()

                        Log.d("create suc", "${task.result}")
                    }

                    isLoading = false
                }.addOnFailureListener { task ->
                    Log.d("fail", "${task.message}")
                    loginErr = task.message.toString()
                }

        }
    }
}