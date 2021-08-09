package br.com.dan.businesscardapp.ui

import android.content.Intent
import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import br.com.dan.businesscardapp.App
import br.com.dan.businesscardapp.databinding.ActivityMainBinding
import br.com.dan.businesscardapp.util.Image

class MainActivity : AppCompatActivity() {

    private val binding: ActivityMainBinding by lazy { ActivityMainBinding.inflate(layoutInflater) }
    private val mainViewModel: MainViewModel by viewModels{
        MainViewModelFactory((application as App).repository)
    }

    private val adapter by lazy { BusinesscardAdapter() }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        binding.rvCards.adapter = adapter
        getAllBusinesscard()
        startListener()
    }

    private fun startListener() {
        binding.fab.setOnClickListener {
            val intent = Intent(this, AddBusinessCardActivity::class.java)
            startActivity(intent)
        }

        adapter.listnerShare = { card ->
            Image.share(this@MainActivity, card)
        }
    }

    private fun getAllBusinesscard(){
        mainViewModel.getAll().observe(this, {
            businessCard -> adapter.submitList(businessCard)
        })
    }
}