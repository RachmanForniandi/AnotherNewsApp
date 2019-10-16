package com.example.anothernewsapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.ActionMode
import com.example.anothernewsapp.adapter.NewsAdapter
import com.example.anothernewsapp.adapter.NewsAdapter.onItemClick
import com.example.anothernewsapp.model.ArticlesItem
import com.example.anothernewsapp.model.ResultNews
import com.example.anothernewsapp.networkUtils.NetworkConfig
import kotlinx.android.synthetic.main.activity_main.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        NetworkConfig.apiService()
            .getNewsData("id","3aa66a534dbe4bdea05f7a067f7a5fec")
            .enqueue(object : Callback<ResultNews>{
                override fun onFailure(call: Call<ResultNews>, t: Throwable) {

                }

                override fun onResponse(call: Call<ResultNews>, response: Response<ResultNews>) {
                    if (response.isSuccessful){
                        displayData(response.body()?.articles)
                        Log.e("debugNews",""+response.body()?.articles)
                    }
                }
            })
    }

    private fun displayData(articles: List<ArticlesItem?>?) {
        listNews.adapter = NewsAdapter(this,articles, "")
    }


}
