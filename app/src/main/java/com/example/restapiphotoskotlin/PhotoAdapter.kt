package com.example.restapiphotoskotlin

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.annotation.GlideModule
import com.bumptech.glide.request.RequestOptions
import com.bumptech.glide.request.target.Target
import com.example.restapiphotoskotlin.pojo.Jphoto
import kotlinx.android.synthetic.main.photos_list_item.view.*

class PhotoAdapter(): RecyclerView.Adapter<PhotoAdapter.PhotoHolder>() {
    // 2.0
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
val requestOptions=RequestOptions().placeholder(R.drawable.ic_launcher_background).error(R.drawable.ic_launcher_background)
        Glide.with(holder.itemView.context).applyDefaultRequestOptions(requestOptions).load(photos1.url).into(holder.photos0)
    }
    override fun getItemCount(): Int {
        return mDATA.size
    }
}