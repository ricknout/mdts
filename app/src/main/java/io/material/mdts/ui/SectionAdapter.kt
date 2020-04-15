package io.material.mdts.ui

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import io.material.mdts.R
import io.material.mdts.model.Album
import io.material.mdts.model.Section
import kotlinx.android.synthetic.main.list_item_section.view.*

class SectionAdapter(
    private val onClick: (itemView: View, album: Album) -> Unit
) : ListAdapter<Section, SectionViewHolder>(DIFF_CALLBACK) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) = SectionViewHolder(
        LayoutInflater.from(parent.context).inflate(R.layout.list_item_section, parent, false),
        onClick
    )

    override fun onBindViewHolder(holder: SectionViewHolder, position: Int) {
        val section = getItem(position)
        holder.bind(section)
    }

    companion object {
        val DIFF_CALLBACK = object : DiffUtil.ItemCallback<Section>() {
            override fun areItemsTheSame(oldItem: Section, newItem: Section) = oldItem.id == newItem.id
            override fun areContentsTheSame(oldItem: Section, newItem: Section) = oldItem == newItem
        }
    }
}

class SectionViewHolder(
    itemView: View,
    private val onClick: (itemView: View, album: Album) -> Unit
) : RecyclerView.ViewHolder(itemView) {

    private val adapter = AlbumAdapter(horizontal = true) { itemView, album -> onClick(itemView, album) }

    fun bind(section: Section) {
        itemView.title.text = section.title
        itemView.recyclerView.adapter = adapter
        adapter.submitList(section.albums)
        val space = itemView.context.resources.getDimensionPixelSize(R.dimen.spacing_xs)
        val spaceItemDecoration = SpaceItemDecoration(
            left = space, top = space, bottom = space
        )
        itemView.recyclerView.addItemDecoration(spaceItemDecoration)
    }
}
