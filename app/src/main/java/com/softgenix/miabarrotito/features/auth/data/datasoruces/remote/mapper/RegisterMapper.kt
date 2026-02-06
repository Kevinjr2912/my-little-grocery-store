package com.softgenix.miabarrotito.features.auth.data.datasoruces.remote.mapper

import com.softgenix.miabarrotito.features.auth.data.datasoruces.remote.models.LoginResponse
import com.softgenix.miabarrotito.features.auth.domain.entities.AuthToken

fun LoginResponse.toDomain(): AuthToken {
    return AuthToken(
        value = this.data.attributes.token
    )
}