package br.com.dan.businesscardapp

import android.app.Application
import br.com.dan.businesscardapp.data.AppDatabase
import br.com.dan.businesscardapp.data.BusinesscardRepository

class App : Application() {
    private val database by lazy { AppDatabase.getDatabase(this) }
    val repository by lazy { BusinesscardRepository(database.businessDAO()) }
}