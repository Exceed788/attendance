package com.example.qrcodescanner


import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.qrcodescanner.adapter.RecyclerAdapter


class FetchedDataActivity : AppCompatActivity() {

    private val recyclerAdapter by lazy { RecyclerAdapter() }

    override fun onCreate(savedInstanceState : Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_fetched_data)

        setupRecyclerview()

    }

    private fun setupRecyclerview() {

        val viewModel = ViewModelProvider(this).get(MainActivityViewModel::class.java)
        val recyclerviewPosts : RecyclerView = this.findViewById(R.id.recyclerview_posts)

        recyclerviewPosts.adapter = recyclerAdapter
        recyclerviewPosts.layoutManager = LinearLayoutManager(this)

        viewModel.getPosts()
        viewModel.myResponsePosts.observe(this, {
            recyclerAdapter.setData(it)
        })
    }

}
