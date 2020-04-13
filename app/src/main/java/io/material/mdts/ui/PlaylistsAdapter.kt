package io.material.mdts.ui

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import io.material.mdts.R
import io.material.mdts.model.Playlist
import kotlinx.android.synthetic.main.list_item_playlists.view.*

class PlaylistsAdapter(
    private val onClick: (playlist: Playlist) -> Unit
) : ListAdapter<Playlist, PlaylistsViewHolder>(DIFF_CALLBACK) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) =
        PlaylistsViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.list_item_playlists, parent, false))

    override fun onBindViewHolder(holder: PlaylistsViewHolder, position: Int) {
        val playlist = getItem(position)
        holder.bind(playlist, onClick)
    }

    companion object {
        val DIFF_CALLBACK = object : DiffUtil.ItemCallback<Playlist>() {
            override fun areItemsTheSame(oldItem: Playlist, newItem: Playlist) = oldItem.id == newItem.id
            override fun areContentsTheSame(oldItem: Playlist, newItem: Playlist) = oldItem == newItem
        }
    }
}

class PlaylistsViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

    fun bind(playlist: Playlist, onClick: (playlist: Playlist) -> Unit) {
        itemView.title.text = playlist.title
        itemView.metaInfo.text = playlist.metaInfo
        itemView.setOnClickListener { onClick(playlist) }
    }
}
