package com.example.hbapplicationgroupa.model.authmodule.adduser

data class AddUserModel(
    val firstName: String,
    val lastName: String,
    val emailAddress: String,
    val userName: String,
    val password: String,
    val phoneNumber: String,
    val gender: String,
    val age: String
)