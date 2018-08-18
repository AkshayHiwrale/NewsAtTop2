package com.akandro.www.newsattop

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.Toast
import com.akandro.www.newsattop.Bean.NEWSStatusBean
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.activity_main.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        var r = Retrofit.Builder().
                baseUrl("https://newsapi.org/").
                addConverterFactory(GsonConverterFactory.create()).
                build()

        var api = r.create(NEWSStatusAPI::class.java)

        var call: Call<NEWSStatusBean> = api.getStatusInfoAPI()
        call.enqueue(object : Callback<NEWSStatusBean> {
            override fun onFailure(call: Call<NEWSStatusBean>?, t: Throwable?) {

                Toast.makeText(this@MainActivity, "Failure occur", Toast.LENGTH_LONG).show()
            }

            override fun onResponse(call: Call<NEWSStatusBean>?,
                                    response: Response<NEWSStatusBean>?) {
                var bean = response!!.body()
                var list = mutableListOf<String>()
                list.add("Source: "+bean!!.status)
               // list.add("Artical"+bean!!.articles)
                var artical = bean.articles
                /*for (a in artical!!) {
                    list.add("title :"+a.title )
                    list.add("description :"+a.description)
                    list.add("url :"+a.url)
                    list.add("image url :"+a.urlToImage)

                }*/

                var adapter = ArrayAdapter<String>(this@MainActivity, android.R.layout.simple_list_item_1, list)
                lview.adapter = Myadapter(artical,this@MainActivity)

            }


        })



    }


}

