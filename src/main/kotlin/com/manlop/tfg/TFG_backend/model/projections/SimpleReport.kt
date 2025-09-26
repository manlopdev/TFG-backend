package com.manlop.tfg.TFG_backend.model.projections

import com.manlop.tfg.TFG_backend.model.Location

data class SimpleReport(
    val tokenId: String,
    val location: Location
)