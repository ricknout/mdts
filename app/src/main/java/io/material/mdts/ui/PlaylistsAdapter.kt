package io.material.mdts.ui

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import io.material.mdts.R
import kotlinx.android.synthetic.main.list_item_playlists.view.*

// TODO: Playlists list adapter
class PlaylistsAdapter : ListAdapter<String, PlaylistsViewHolder>(DIFF_CALLBACK) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) =
        PlaylistsViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.list_item_playlists, parent, false))

    override fun onBindViewHolder(holder: PlaylistsViewHolder, position: Int) {
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

// TODO: Playlists list view holder
class PlaylistsViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

    fun bind(text: String) {
        itemView.textView.text = text
    }
}
