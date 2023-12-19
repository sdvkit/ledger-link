package com.sulitsa.dev.ledgerlink.domain.manager

interface LocalJsonManager {
    suspend fun <T> readList(resId: Int, clazz: Class<T>): List<T>
}