package com.sulitsa.dev.ledgerlink.data.manager

import android.content.Context
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import com.sulitsa.dev.ledgerlink.domain.manager.LocalJsonManager
import java.io.InputStreamReader
import javax.inject.Inject

class LocalJsonManagerImpl @Inject constructor(
    private val context: Context
) : LocalJsonManager {

    override suspend fun <T> readList(resId: Int, clazz: Class<T>): List<T> {
        val inputStream = context.resources.openRawResource(resId)
        val inputStreamReader = InputStreamReader(inputStream)
        val type = TypeToken.getParameterized(List::class.java, clazz).type
        return Gson().fromJson(inputStreamReader, type)
    }
}