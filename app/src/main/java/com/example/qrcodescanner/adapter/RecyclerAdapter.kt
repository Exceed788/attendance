package com.example.qrcodescanner.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.qrcodescanner.R
import com.example.qrcodescanner.network.Post
import java.util.*




class RecyclerAdapter: RecyclerView.Adapter<RecyclerAdapter.MyViewHolder>(){

    private var myList = emptyList<Post>()

    class MyViewHolder(itemView: View): RecyclerView.ViewHolder(itemView)
    {
        val userId : TextView = itemView.findViewById(R.id.userId)
        val postId : TextView = itemView.findViewById(R.id.postId)
        val postTitle : TextView = itemView.findViewById(R.id.postTitle)
    }

    override fun onCreateViewHolder(parent : ViewGroup , viewType : Int) : MyViewHolder {
        return MyViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.row_items, parent, false))
    }
    override fun getItemCount() : Int {
        return myList.size
    }

    override fun onBindViewHolder(holder : MyViewHolder, position : Int) {

        holder.userId.text = myList[position].userId.toString()
        holder.postId.text = myList[position].id.toString()
        holder.postTitle.text = myList[position].title

    }

    fun setData( newList: List<Post> ){
        myList = newList
        notifyDataSetChanged()
    }




}