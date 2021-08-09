package br.com.dan.businesscardapp.data

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class Businesscard(
    @PrimaryKey(autoGenerate = true) val id: Int = 0,
    val name: String,
    val enterprise: String,
    val phone: String,
    val emailAdress: String,
    val backgroundColor: String
) {
}