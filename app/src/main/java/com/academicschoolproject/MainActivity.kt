package com.academicschoolproject

import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.lifecycleScope
import com.academicschoolproject.databinding.ActivityMainBinding
import com.academicschoolproject.repository.NetworkResult
import com.academicschoolproject.ui.MainViewModel
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.launch
@AndroidEntryPoint
class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private val mainViewModel: MainViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        fetchData()


    }

    private fun fetchData() {
        lifecycleScope.launch {
            mainViewModel.data.collect { state ->
                when (state) {
                    is NetworkResult.Loading -> {
                        // Show loading indicator if needed
                        Log.e("MainActivity","loading")
                    }

                    is NetworkResult.Success -> {
                        Log.e("MainActivity", state.data.toString())
                    }

                    is NetworkResult.Failure -> {
                        Log.e("MainActivity","Failure")
                        Toast.makeText(this@MainActivity, "hb hj ", Toast.LENGTH_LONG).show()
                    }
                }
            }
        }
    }
}