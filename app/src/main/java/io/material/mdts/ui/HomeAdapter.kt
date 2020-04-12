package io.material.mdts.ui

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import io.material.mdts.R
import kotlinx.android.synthetic.main.list_item_home.view.*

// TODO: Home list adapter
class HomeAdapter : ListAdapter<String, HomeViewHolder>(DIFF_CALLBACK) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) =
        HomeViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.list_item_home, parent, false))

    override fun onBindViewHolder(holder: HomeViewHolder, position: Int) {
        val text = getItem(position)
        holder.bind(text)
    }

    companion object {
        val DIFF_CALLBACK = object : DiffUtil.ItemCallback<String>() {
            override fun areItemsTheSame(oldItem: String, newItem: String) = oldItem == newItem
            override fun areContentsTheSame(oldItem: String, newItem: String) = oldItem == newItem
        }
    }
}

// TODO: Home list view holder
class HomeViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

    fun bind(text: String) {
        itemView.textView.text = text
    }
}
