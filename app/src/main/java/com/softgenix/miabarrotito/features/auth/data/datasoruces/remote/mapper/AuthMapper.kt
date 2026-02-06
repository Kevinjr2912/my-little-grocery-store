package com.softgenix.miabarrotito.features.auth.data.datasoruces.remote.mapper

import com.softgenix.miabarrotito.features.auth.data.datasoruces.remote.models.RegisterRequest
import com.softgenix.miabarrotito.features.auth.data.datasoruces.remote.models.RegisterResponse
import com.softgenix.miabarrotito.features.auth.domain.entities.UserEntity


fun RegisterResponse.toDomain(): UserEntity{
    return UserEntity(
        id = this.data.id,
        fullName = "${this.data.attributes.name} ${this.data.attributes.secondSurname}",
        email = this.data.attributes.email,
        phone = this.data.attributes.phoneNumber

    )
}