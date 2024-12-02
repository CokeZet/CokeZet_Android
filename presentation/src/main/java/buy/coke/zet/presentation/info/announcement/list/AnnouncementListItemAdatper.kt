package buy.coke.zet.presentation.info.announcement.list

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import buy.coke.zet.presentation.databinding.ItemAnnouncementBinding

class AnnouncementListItemAdapter: ListAdapter<AnnouncementListItem, AnnouncementListItemAdapter.AnnouncementListItemViewHolder>(AnnouncementListItemDiffCallBack()) {

    inner class AnnouncementListItemViewHolder(private val binding: ItemAnnouncementBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind(item: AnnouncementListItem) {
            binding.item = item
            binding.executePendingBindings()
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): AnnouncementListItemViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val binding = ItemAnnouncementBinding.inflate(inflater, parent, false)
        return AnnouncementListItemViewHolder(binding)
    }

    override fun onBindViewHolder(holder: AnnouncementListItemViewHolder, position: Int) {
        holder.bind(getItem(position))
    }
}
