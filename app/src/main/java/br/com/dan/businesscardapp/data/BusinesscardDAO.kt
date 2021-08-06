package br.com.dan.businesscardapp.data

import androidx.lifecycle.LiveData
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query

interface BusinesscardDAO {

    @Query("SELECT * FROM Businesscard")
    fun getAll(): LiveData<List<Businesscard>>

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insert(businesscard: Businesscard)
}