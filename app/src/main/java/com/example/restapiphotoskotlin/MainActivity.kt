package com.example.restapiphotoskotlin

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.LinearLayout
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.restapiphotoskotlin.pojo.Jphoto
import com.example.restapiphotoskotlin.retrofit.RetrofitK
import kotlinx.android.synthetic.main.activity_main.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity : AppCompatActivity() {

    var photoAdapter: PhotoAdapter= PhotoAdapter()
    val photoList=ArrayList<Jphoto>()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //photoAdapter.updateList(photoList)

        loadPhotosFromApi()
    }
    private fun loadPhotosFromApi() {
        val call = RetrofitK.retrofitInstance().getPhotos()
        call.enqueue(object : Callback<ArrayList<Jphoto>> {
            override fun onResponse(call: Call<ArrayList<Jphoto>>, response: Response<ArrayList<Jphoto>>) {
                val list : List<Jphoto> = response.body()?.take(10)!!
                photoAdapter.updateList(list)
                reciclerViewPhoto.adapter=photoAdapter
                reciclerViewPhoto.layoutManager= LinearLayoutManager(this@MainActivity)

            }

            override fun onFailure(call: Call<ArrayList<Jphoto>>, t: Throwable) {
                Toast.makeText(this@MainActivity,"error",Toast.LENGTH_SHORT).show()
            }
        })
    }
}