package com.example.movieapi_recommend.presentation

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuInflater
import android.view.MenuItem
import android.view.View
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.movieapi_recommend.R
import com.example.movieapi_recommend.databinding.ActivityMainBinding
import com.example.movieapi_recommend.presentation.injections.Injector
import javax.inject.Inject


//Whenever we make a interface  , we need to create a class that implements that interface
class MainActivity : AppCompatActivity() {
    @Inject
    lateinit var factory : ViewModelFactory
    private lateinit var movieViewModel : ViewModel
    private lateinit var binding: ActivityMainBinding
    private lateinit var adapter: MovieAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
       binding = DataBindingUtil.setContentView(this,R.layout.activity_main)
        (applicationContext as Injector).createMovieSubComponent().inject(this)
        movieViewModel = ViewModelProvider(this,factory)[ViewModel::class.java]
        initRecyclerView()

    }

    private fun initRecyclerView() {
        binding.recyclerView.layoutManager = LinearLayoutManager(this)
        adapter = MovieAdapter()
        binding.recyclerView.adapter = adapter
        displayPopularMovies()
    }

    private fun displayPopularMovies() {
        binding.progressBar.visibility = View.VISIBLE
        val responsiveLiveData = movieViewModel.getMovie()

        responsiveLiveData.observe(this, Observer {
            if(it!=null){
                adapter .setList(it)
                adapter.notifyDataSetChanged()
                binding.progressBar.visibility=View.GONE
            }else{
                binding.progressBar.visibility=View.GONE
                Toast.makeText(applicationContext," Oopsie ! No data available .",Toast.LENGTH_SHORT).show()
            }
        })


    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        val inflater : MenuInflater = menuInflater
        inflater.inflate(R.menu.update,menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when (item.itemId){
            R.id.action_update->{
                updateMovies()
                true
            }else ->super.onOptionsItemSelected(item)
        }

        }


    private fun updateMovies() {
        binding.progressBar.visibility = View.VISIBLE
        val response = movieViewModel.updateMovie()

        response.observe(this, Observer {
            if(it!=null){
                adapter .setList(it)
                adapter.notifyDataSetChanged()
                binding.progressBar.visibility=View.GONE
            }else{
                binding.progressBar.visibility=View.GONE
            }
        })

    }
}