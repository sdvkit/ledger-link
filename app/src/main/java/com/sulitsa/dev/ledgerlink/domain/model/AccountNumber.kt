package com.sulitsa.dev.ledgerlink.domain.model

import androidx.room.ColumnInfo
import androidx.room.ColumnInfo.Companion.INTEGER
import androidx.room.ColumnInfo.Companion.REAL
import androidx.room.ColumnInfo.Companion.TEXT
import androidx.room.Embedded
import androidx.room.Entity
import androidx.room.PrimaryKey
import androidx.room.Relation

@Entity(tableName = "account_numbers")
data class AccountNumber(

    @PrimaryKey
    @ColumnInfo(name = "number", typeAffinity = REAL)
    val number: Float,

    @ColumnInfo(name = "name", typeAffinity = TEXT)
    val name: String,

    @ColumnInfo(name = "is_favourite", typeAffinity = INTEGER)
    val isFavourite: Boolean
)

data class AccountNumberWithCorrespondence(

    @Embedded
    val accountNumber: AccountNumber,

    @Relation(
        parentColumn = "number",
        entityColumn = "account_number"
    )
    val accountCorrespondence: AccountCorrespondence
)