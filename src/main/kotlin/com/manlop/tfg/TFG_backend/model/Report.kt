package com.manlop.tfg.TFG_backend.model

import com.fasterxml.jackson.annotation.JsonIgnore
import jakarta.persistence.Column
import jakarta.persistence.Embedded
import jakarta.persistence.Entity
import jakarta.persistence.GeneratedValue
import jakarta.persistence.GenerationType
import java.time.Instant
import jakarta.persistence.Id;
import jakarta.persistence.Table
import java.io.Serializable
import java.util.UUID

@Entity
@Table(name = "Report")
data class Report(
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @JsonIgnore
    val id: Long,
    @Column(unique = true)
    val tokenId: String? = UUID.randomUUID().toString().substring(0,8),
    val description: String? = "",
    @Embedded
    val location: Location? = null,
    val createdAt: Instant? = null,
    val imageUrl: String? = null,
) : Serializable

