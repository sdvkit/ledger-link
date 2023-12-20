package com.sulitsa.dev.ledgerlink.domain.model

import androidx.room.ColumnInfo
import androidx.room.ColumnInfo.Companion.INTEGER
import androidx.room.ColumnInfo.Companion.REAL
import androidx.room.ColumnInfo.Companion.TEXT
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "correspondence")
data class AccountCorrespondence(

    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "id", typeAffinity = INTEGER)
    val id: Int,

    @ColumnInfo(name = "account_number", typeAffinity = REAL)
    val accountNumber: Float,

    @ColumnInfo(name = "debit", typeAffinity = REAL)
    val debit: Float,

    @ColumnInfo(name = "credit", typeAffinity = REAL)
    val credit: Float,

    @ColumnInfo(name = "description", typeAffinity = TEXT)
    val description: String
)