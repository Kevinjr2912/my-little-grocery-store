package com.softgenix.miabarrotito.features.auth.data.datasoruces.remote.models

class RegisterRequest (
    val userUUID: String,
    val name: String,
    val secondSurname: String,
    val phoneNumber: String,
    val email: String,
    val password: String
)