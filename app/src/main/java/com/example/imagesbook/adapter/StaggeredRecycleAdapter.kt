package com.example.imagesbook.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.example.imagesbook.R
import com.example.imagesbook.model.Post
import kotlinx.android.synthetic.main.layout_photo_list_item.view.*

class StaggeredRecycleAdapter : RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    private var items: List<Post> = ArrayList()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(
            LayoutInflater.from(parent.context).inflate(R.layout.layout_photo_list_item, parent, false)
        )
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        when(holder){
            is ViewHolder -> {
                holder.bind(items.get(position))
            }
        }
    }

    override fun getItemCount(): Int {
        return items.size
    }

    fun submitList(list: List<Post>) {
        items = list
        notifyDataSetChanged()
    }

    class ViewHolder constructor(
        itemView: View
    ): RecyclerView.ViewHolder(itemView) {
        val image = itemView.image_card
        val title = itemView.image_title
//        val author = itemView.image_author

        fun bind(post: Post) {
            title.setText(post.title)
//            author.setText(post.username)

            val requestOptions = RequestOptions()
                .placeholder(R.drawable.ic_launcher_background)
                .error(R.drawable.ic_launcher_background)

            Glide.with(itemView.context)
                .applyDefaultRequestOptions(requestOptions)
                .load(post.image)
                .into(image)
        }
    }
}