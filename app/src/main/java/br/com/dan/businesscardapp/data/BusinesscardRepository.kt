package br.com.dan.businesscardapp.data

import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking

class BusinesscardRepository(private val businesscardDAO: BusinesscardDAO) {

    fun insert(businesscard: Businesscard) = runBlocking {
        launch {
            businesscardDAO.insert(businesscard)
        }
    }

    fun getAll() = businesscardDAO.getAll()
}