package com.manlop.tfg.TFG_backend.model

import jakarta.persistence.Embeddable

@Embeddable
data class Location(
    val latitude: Double,
    val longitude: Double
)