package com.example.anothernewsapp.model


import android.os.Parcel
import android.os.Parcelable
import com.google.gson.annotations.SerializedName

data class ArticlesItem(

    @field:SerializedName("publishedAt")
    val publishedAt: String? = null,

    @field:SerializedName("author")
    val author: String? = null,

    @field:SerializedName("urlToImage")
    val urlToImage: String? = null,

    @field:SerializedName("description")
    val description: String? = null,

    /*@field:SerializedName("source")
    val source: Source? = null,*/

    @field:SerializedName("title")
    val title: String? = null,

    @field:SerializedName("url")
    val url: String? = null,

    @field:SerializedName("content")
    val content: String? = null
) : Parcelable {
    constructor(source: Parcel) : this(
        source.readString(),
        source.readString(),
        source.readString(),
        source.readString(),
        //source.readSource(),
        source.readString(),
        source.readString(),
        source.readString()
    )

    override fun describeContents() = 0

    override fun writeToParcel(dest: Parcel, flags: Int) = with(dest) {
        writeString(publishedAt)
        writeString(author)
        writeString(urlToImage)
        writeString(description)
        //writeSource(source)
        writeString(title)
        writeString(url)
        writeString(content)
    }

    companion object {
        @JvmField
        val CREATOR: Parcelable.Creator<ArticlesItem> = object : Parcelable.Creator<ArticlesItem> {
            override fun createFromParcel(source: Parcel): ArticlesItem = ArticlesItem(source)
            override fun newArray(size: Int): Array<ArticlesItem?> = arrayOfNulls(size)
        }
    }
}