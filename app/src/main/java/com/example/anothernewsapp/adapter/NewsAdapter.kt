package com.example.anothernewsapp.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.anothernewsapp.R
import com.example.anothernewsapp.model.ArticlesItem
import kotlinx.android.synthetic.main.item_news.view.*

class NewsAdapter (context: Context,val data: List<ArticlesItem?>?, onItemClickListener: onItemClick): RecyclerView.Adapter<NewsAdapter.NewsHolder>() {



    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NewsAdapter.NewsHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_news,parent,false)
        return NewsHolder(view)
    }

    override fun getItemCount(): Int {
        return data?.size?:0
    }

    override fun onBindViewHolder(holder: NewsAdapter.NewsHolder, position: Int) {

        holder.tvTitle.text = data?.get(position)?.title
        holder.tvAuthor.text = data?.get(position)?.author
        holder.tvDescription.text = data?.get(position)?.description

        Glide.with(holder.itemView.context)
            .load(data?.get(position)?.urlToImage)
            .into(holder.imgNews)

        holder.itemView.setOnClickListener {

        }
    }

    class NewsHolder (itemView: View) :RecyclerView.ViewHolder(itemView){

        val tvTitle = itemView.tv_headline
        val tvAuthor = itemView.tv_author
        val tvDescription = itemView.tv_description
        val imgNews = itemView.img_news



    }

    interface onItemClick {
        fun item(data: ArticlesItem)
    }
}