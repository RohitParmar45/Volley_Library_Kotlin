package com.example.volley_library.Retrofit

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.volley_library.R
import com.example.volley_library.Volley.MyAdapter
import com.example.volley_library.dao.User
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

class MainRetrofit : AppCompatActivity() {

    lateinit var recyclerView : RecyclerView
    var user = User();


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main_retrofit)
        recyclerView=findViewById<RecyclerView>(R.id.recyclerView2)


        val userApi = MyRetrofitBuilder.getInstance().create(MyInterface::class.java)

        GlobalScope.launch {
           val res = userApi.getUser()
            Log.d("MyTag", "onCreate: "+ res.body())

            user = res.body()!!
            runOnUiThread {


                Toast.makeText(this@MainRetrofit, "Main", Toast.LENGTH_LONG).show()
                val adapter = MyAdapter(this@MainRetrofit, user)
                recyclerView.layoutManager = LinearLayoutManager(this@MainRetrofit)
                recyclerView.adapter = adapter


            }
        }






    }
}