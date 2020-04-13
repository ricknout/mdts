package io.material.mdts.ui

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import io.material.mdts.R
import io.material.mdts.model.Album
import kotlinx.android.synthetic.main.list_item_album.view.*

class AlbumAdapter(
    private val onClick: (album: Album) -> Unit
) : ListAdapter<Album, AlbumViewHolder>(DIFF_CALLBACK) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) =
        AlbumViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.list_item_album, parent, false))

    override fun onBindViewHolder(holder: AlbumViewHolder, position: Int) {
        val album = getItem(position)
        holder.bind(album, onClick)
    }

    companion object {
        val DIFF_CALLBACK = object : DiffUtil.ItemCallback<Album>() {
            override fun areItemsTheSame(oldItem: Album, newItem: Album) = oldItem.id == newItem.id
            override fun areContentsTheSame(oldItem: Album, newItem: Album) = oldItem == newItem
        }
    }
}

class AlbumViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

    fun bind(album: Album, onClick: (album: Album) -> Unit) {
        itemView.title.text = album.title
        itemView.metaInfo.text = album.metaInfo
        itemView.setOnClickListener { onClick(album) }
    }
}
