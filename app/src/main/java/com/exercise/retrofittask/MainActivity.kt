package com.exercise.retrofittask

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import com.exercise.retrofittask.adapter.MovieAdapter
import com.exercise.retrofittask.databinding.ActivityMainBinding
import com.exercise.retrofittask.model.ResponsePopularMovie
import com.exercise.retrofittask.network.APIClient
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        getDataFilm()
    }

    private fun getDataFilm(){
        APIClient.instance.getPopularMovies("d4e032a78d32940d67d6b1e0a21d82ca", 4).enqueue(object : Callback<ResponsePopularMovie> {
            override fun onResponse(call: Call<ResponsePopularMovie>, response: Response<ResponsePopularMovie>) {
                if (response.isSuccessful) {
                    val popularMovies = response.body()
                        binding.rvClient.layoutManager = GridLayoutManager(this@MainActivity, 2)
                    if (popularMovies != null) binding.rvClient.adapter = MovieAdapter(popularMovies.results)
                } else {
                    Toast.makeText(this@MainActivity, "Failed Load Data", Toast.LENGTH_SHORT).show()
                }
            }

            override fun onFailure(call: Call<ResponsePopularMovie>, t: Throwable) {
                Toast.makeText(this@MainActivity, t.message, Toast.LENGTH_SHORT).show()
            }
        })
    }

}
