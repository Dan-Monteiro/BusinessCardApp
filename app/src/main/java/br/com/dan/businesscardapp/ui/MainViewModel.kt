package br.com.dan.businesscardapp.ui

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import br.com.dan.businesscardapp.data.Businesscard
import br.com.dan.businesscardapp.data.BusinesscardRepository
import java.lang.IllegalArgumentException

class MainViewModel(private val businesscardRepository: BusinesscardRepository) : ViewModel() {

    fun insert(businesscard: Businesscard){
        businesscardRepository.insert(businesscard)
    }

    fun getAll(): LiveData<List<Businesscard>> {
        return businesscardRepository.getAll()
    }
}

class MainViewModelFactory(private val businesscardRepository: BusinesscardRepository): ViewModelProvider.Factory {
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        if(modelClass.isAssignableFrom(MainViewModel::class.java)){
            @Suppress("UNCHEKED_CAST")
            return MainViewModel(businesscardRepository) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }

}