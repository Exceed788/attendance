package com.example.qrcodescanner.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.qrcodescanner.R
import com.example.qrcodescanner.network.Post
import com.example.qrcodescanner.network.Student


class RecyclerAdapter: RecyclerView.Adapter<RecyclerAdapter.MyViewHolder>(){

    private var postList = emptyList<Post>()

    class MyViewHolder(itemView: View): RecyclerView.ViewHolder(itemView)
    {
        val userID : TextView = itemView.findViewById(R.id.userID)
        val postID : TextView = itemView.findViewById(R.id.postID)
        val title : TextView = itemView.findViewById(R.id.title)
        val body : TextView = itemView.findViewById(R.id.body)


    }

    override fun onCreateViewHolder(parent : ViewGroup , viewType : Int) : MyViewHolder {
        return MyViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.row_items, parent, false))
    }
    override fun getItemCount() : Int {
        return postList.size
    }

    override fun onBindViewHolder(holder : MyViewHolder, position : Int) {

        holder.userID.text = postList[position].userId.toString()
        holder.postID.text = postList[position].id.toString()
        holder.title.text = postList[position].title
        holder.body.text = postList[position].body

    }

    fun setData( newList: List<Post> ){
        postList = newList
    }




}