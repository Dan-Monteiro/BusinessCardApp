package br.com.dan.businesscardapp.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import br.com.dan.businesscardapp.databinding.ActivityAddBusinessCardBinding

class AddBusinessCardActivity : AppCompatActivity() {

    private val binding: ActivityAddBusinessCardBinding by lazy { ActivityAddBusinessCardBinding.inflate(layoutInflater) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        startListener()
    }

    private fun startListener(){
        binding.ibtnClose.setOnClickListener{
            finish()
        }
    }

}