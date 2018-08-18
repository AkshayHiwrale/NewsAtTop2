package com.akandro.www.newsattop

import android.graphics.BitmapFactory
import android.media.ThumbnailUtils
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.ImageView
import com.akandro.www.newsattop.Bean.Article
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.include.view.*




/**
 * Created by akshay on 8/18/2018.
 */
class Myadapter : BaseAdapter{

    var article:List<Article>? = null
    var activity:MainActivity? = null
    var picasso:Picasso? = null

    constructor(article: List<Article>,activity: MainActivity)
    {

        this.article = article
        this.activity = activity
    }







    override fun getView(p0: Int, p1: View?, p2: ViewGroup?): View {
        var inflater = LayoutInflater.from(activity)
        var v= inflater.inflate(R.layout.include,null)

        var news = article!![p0]
        Picasso.get().load(news.urlToImage).into(v.iview)

       // var current = getItemViewType(p0)
        v.title.text = news.title
        v.desc.text = news.description
        return v
    }

    override fun getItem(p0: Int): Any {
        return 0
    }

    override fun getItemId(p0: Int): Long {
        return 0
    }

    override fun getCount(): Int {

        return article!!.size
    }

}