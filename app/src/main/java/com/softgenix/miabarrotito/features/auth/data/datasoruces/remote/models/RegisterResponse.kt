package com.softgenix.miabarrotito.features.auth.data.datasoruces.remote.models

class RegisterResponse (
    val data: UserDataDto
)

data class UserDataDto(
    val id: String,
    val type: String,
    val attributes: UserAttributesDto
)

data class UserAttributesDto(
    val name: String,
    val secondSurname: String,
    val email: String,
    val phoneNumber: String
)