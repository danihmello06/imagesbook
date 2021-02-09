package com.example.imagesbook.model

import java.util.*

data class User (

    val id: UUID = UUID.randomUUID(),
    val email: String,
    val password: String = "",
    val name: String = ""

)