package com.example.volley_library

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.android.volley.Response
import com.android.volley.toolbox.StringRequest
import com.android.volley.toolbox.Volley
import com.google.gson.Gson
import com.google.gson.GsonBuilder
import com.google.gson.reflect.TypeToken

class MainActivity : AppCompatActivity() {
    var url = "https://api.github.com/users";
    var list = arrayListOf<UserItem>();
    var user = User();
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main2)

        var stringRequest = StringRequest(url, {//success listner

            var gsonBuilder = GsonBuilder()
            var gson = gsonBuilder.create()
            list = gson.fromJson(it, object : TypeToken<List<UserItem>>() {}.type)

            list.forEach{
                user.add(it)
            }
            Toast.makeText(this, list.toString() , Toast.LENGTH_LONG).show()


        }, { //failure listner
           Toast.makeText(this, "something went wrong $it" , Toast.LENGTH_LONG).show()
        }
        )
        val volleyQueue = Volley.newRequestQueue(this)
        volleyQueue.add(stringRequest)

    }
}