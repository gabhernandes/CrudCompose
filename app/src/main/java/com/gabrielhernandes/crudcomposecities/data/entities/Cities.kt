package com.gabrielhernandes.crudcomposecities.data.entities

import android.os.Parcelable
import androidx.room.Entity
import androidx.room.PrimaryKey
import kotlinx.parcelize.Parcelize

@Entity(tableName = "cidades")
@Parcelize
data class Cities(
    @PrimaryKey
    val id: Int? = null,
    val cep: String? = null,
    val uf: String? = null,
    val nome: String? = null
) : Parcelable
