package com.akandro.www.newsattop

import com.akandro.www.newsattop.Bean.NEWSStatusBean
import retrofit2.Call
import retrofit2.http.GET

/**
 * Created by akshay on 8/17/2018.
 */
interface NEWSStatusAPI {

    @GET("v2/top-headlines?country=in&apiKey=5d6cce067fbd4e479aea4d89cd16e029")
    fun getStatusInfoAPI(): Call<NEWSStatusBean>
}