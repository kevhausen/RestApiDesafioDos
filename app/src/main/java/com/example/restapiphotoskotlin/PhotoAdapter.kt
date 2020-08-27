package com.example.restapiphotoskotlin

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.restapiphotoskotlin.pojo.Jphoto
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.photos_list_item.view.*

class PhotoAdapter(): RecyclerView.Adapter<PhotoAdapter.PhotoHolder>() {

    private lateinit var mDATA: List<Jphoto>
    fun updateList(myDt: List<Jphoto>){
        mDATA= myDt
        notifyDataSetChanged()
    }
    class PhotoHolder (itemView: View) : RecyclerView.ViewHolder(itemView){
        val photos0: ImageView = itemView.photoImageView
        val titlePhoto: TextView = itemView.titlePhotoTextView
    }
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PhotoHolder {
        val view: View = LayoutInflater.from(parent.context).inflate(R.layout.photos_list_item, parent, false)
        return PhotoHolder(view)
    }
    override fun onBindViewHolder(holder: PhotoHolder, position: Int) {
        val photos1 = mDATA[position]
        holder.titlePhoto.text= photos1.title
        Picasso.get().load(photos1.url).into(holder.photos0)
        Picasso.get().setIndicatorsEnabled(true)

    }
    override fun getItemCount(): Int {
        return mDATA.size
    }
}