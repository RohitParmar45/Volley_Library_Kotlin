package com.example.volley_library.Volley

import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.volley_library.R
import com.example.volley_library.Retrofit.MainRetrofit
import com.example.volley_library.dao.User

class MyAdapter(val context: MainRetrofit, val user: User) :
    RecyclerView.Adapter<MyAdapter.MyViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
       val view = LayoutInflater.from(context).inflate(R.layout.single_row,parent,false)
        return MyViewHolder(view)
    }


    override fun getItemCount(): Int {
        return user.size
    }

    class MyViewHolder(itemView: View): RecyclerView.ViewHolder(itemView){

        val image  = itemView.findViewById<ImageView>(R.id.avatarImageView)
        val userName: TextView= itemView.findViewById<TextView>(R.id.usernameTextView)
        val login = itemView.findViewById<TextView>(R.id.loginTextView)
        val idTextView = itemView.findViewById<TextView>(R.id.idTextView)
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        Glide.with(context).load(user.get(position).avatar_url).into(holder.image)
        holder.userName.setText(user.get(position).login)
        holder.idTextView.setText(user.get(position).type)
        holder.login.setText(user.get(position).node_id)

        Log.d("MyTag", "onBindViewHolder: "+ user.get(position).node_id)
    }

}