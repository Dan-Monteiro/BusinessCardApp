package br.com.dan.businesscardapp.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.activity.viewModels
import br.com.dan.businesscardapp.App
import br.com.dan.businesscardapp.R
import br.com.dan.businesscardapp.data.Businesscard
import br.com.dan.businesscardapp.databinding.ActivityAddBusinessCardBinding

class AddBusinessCardActivity : AppCompatActivity() {

    private val binding: ActivityAddBusinessCardBinding by lazy { ActivityAddBusinessCardBinding.inflate(layoutInflater) }

    private val mainViewModel: MainViewModel by viewModels{
        MainViewModelFactory((application as App).repository)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        startListener()
    }

    private fun startListener(){
        binding.ibtnClose.setOnClickListener{
            finish()
        }

        binding.btnSave.setOnClickListener {
            val businesscard = Businesscard(
                name = binding.tilName.editText?.text.toString(),
                enterprise = binding.tilEnterprise.editText?.text.toString(),
                phone = binding.tilPhone.editText?.text.toString(),
                emailAdress = binding.tilEmail.editText?.text.toString(),
                backgroundColor = binding.colorPicker.color.toString()
            )
            mainViewModel.insert(businesscard)
            Toast.makeText(this, R.string.label_show_success, Toast.LENGTH_SHORT).show()
            finish()
        }
    }
}
