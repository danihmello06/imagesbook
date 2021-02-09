package com.example.imagesbook.model.responseModel

data class StatusResponseEntity<T>(val status: Boolean, val message: String, val entity: T?)