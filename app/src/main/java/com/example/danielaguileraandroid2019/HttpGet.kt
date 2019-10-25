package com.example.danielaguileraandroid2019

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_http_get.*
import org.jetbrains.anko.doAsync
import org.jetbrains.anko.uiThread
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import android.app.SearchManager
import android.view.inputmethod.InputMethodManager
import android.widget.SearchView
import android.widget.SearchView.OnQueryTextListener
import androidx.recyclerview.widget.LinearLayoutManager
import org.jetbrains.anko.alert

class HttpGet : AppCompatActivity(), OnQueryTextListener {
    lateinit var imagesPuppies:List<String>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_http_get)
        searchBreed.setOnQueryTextListener(this)
    }
    private fun getRetrofit(): Retrofit {
        return Retrofit.Builder()
            .baseUrl("https://dog.ceo/api/breed/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

    private fun searchByName(query: String) {
        doAsync {
            val call = getRetrofit().create(APIService::class.java).getCharacterByName("$query/images").execute()
            val puppies = call.body() as DogsResponse
            uiThread {
                if(puppies.status == "success") {
                    initCharacter(puppies)
                }else{
                    showErrorDialog()
                }
                hideKeyboard()
            }
        }
    }
    override fun onQueryTextSubmit(query: String?): Boolean {
        if (query != null) {
            searchByName(query.toLowerCase())
        }
        return true
    }
    override fun onQueryTextChange(newText: String?): Boolean {
        return true
    }

    private fun initCharacter(puppies: DogsResponse) {
        if(puppies.status == "success"){
            imagesPuppies = puppies.images
        }
        var dogsAdapter = DogsAdapter(imagesPuppies)
        rvDogs.setHasFixedSize(true)
        rvDogs.layoutManager = LinearLayoutManager(this)
        rvDogs.adapter = dogsAdapter
    }
    private fun showErrorDialog() {
        alert("Ha ocurrido un error, inténtelo de nuevo.") {
            yesButton { }
        }.show()
    }
    private fun hideKeyboard(){
        val imm = getSystemService(INPUT_METHOD_SERVICE) as InputMethodManager
        imm.hideSoftInputFromWindow(viewRoot.windowToken, 0)
    }
}
