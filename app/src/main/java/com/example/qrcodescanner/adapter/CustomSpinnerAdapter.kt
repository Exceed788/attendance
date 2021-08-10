package com.example.qrcodescanner.adapter


import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.TextView
import com.example.qrcodescanner.R
import com.example.qrcodescanner.network.Post

class CustomSpinnerAdapter(mContext : Context, private var myList : ArrayList<Post>) : BaseAdapter() {

    private val inflater: LayoutInflater = mContext.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater

    override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {

        val view: View
        val vh: ItemHolder
        if (convertView == null) {
            view = inflater.inflate(R.layout.spinner_item, parent, false)
            vh = ItemHolder(view)
            view?.tag = vh
        } else {
            view = convertView
            vh = view.tag as ItemHolder
        }
        vh.postId.text = myList[position].id.toString()
        vh.postTitle.text = myList[position].title
        return view
    }

    override fun getItem(position: Int): Any {
        return myList[position]
    }

    override fun getCount(): Int {
        return myList.size
    }

    override fun getItemId(position: Int): Long {
        return position.toLong()
    }

    private class ItemHolder(row: View?) {
        val postId: TextView = row?.findViewById(R.id.spinnerPostId) as TextView
        val postTitle : TextView = row?.findViewById(R.id.spinnerPostTitle) as TextView
    }

}