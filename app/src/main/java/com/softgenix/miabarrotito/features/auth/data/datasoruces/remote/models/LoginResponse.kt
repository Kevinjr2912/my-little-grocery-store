package com.softgenix.miabarrotito.features.auth.data.datasoruces.remote.models

data class LoginResponse(
    val data: TokenDataDto
)

data class TokenDataDto(
    val type: String,
    val id: String,
    val attributes: TokenAttributesDto
)

data class TokenAttributesDto(
    val token: String
)