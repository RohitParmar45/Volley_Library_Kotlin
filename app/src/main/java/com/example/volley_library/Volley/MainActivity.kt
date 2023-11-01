package com.example.volley_library.Volley

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.android.volley.toolbox.StringRequest
import com.android.volley.toolbox.Volley
import com.example.volley_library.R
import com.example.volley_library.dao.User
import com.example.volley_library.dao.UserItem
import com.google.gson.GsonBuilder
import com.google.gson.reflect.TypeToken

class MainActivity : AppCompatActivity() {
    var url = "https://api.github.com/users";
    var list = arrayListOf<UserItem>();
    var user = User();
    lateinit var recyclerView: RecyclerView ;
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        recyclerView  = findViewById<RecyclerView>(R.id.recyclerView)

        var stringRequest = StringRequest(url, { //success listner

            var gsonBuilder = GsonBuilder()
            var gson = gsonBuilder.create()
            list = gson.fromJson(it, object : TypeToken<List<UserItem>>() {}.type)

            list.forEach{
                user.add(it)
            }
//            val adapter  = MyAdapter(this, user)
//            recyclerView.layoutManager = LinearLayoutManager(this)
//            recyclerView.adapter = adapter


        }, { //failure listner
           Toast.makeText(this, "something went wrong $it" , Toast.LENGTH_LONG).show()
        }
        )
        val volleyQueue = Volley.newRequestQueue(this)
        volleyQueue.add(stringRequest)

    }
}