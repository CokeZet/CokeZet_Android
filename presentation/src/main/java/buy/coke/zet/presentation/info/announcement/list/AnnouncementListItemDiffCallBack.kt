package buy.coke.zet.presentation.info.announcement.list

import androidx.recyclerview.widget.DiffUtil

class AnnouncementListItemDiffCallBack: DiffUtil.ItemCallback<AnnouncementListItem>() {
    override fun areItemsTheSame(
        oldItem: AnnouncementListItem,
        newItem: AnnouncementListItem
    ): Boolean {
        return oldItem.index == newItem.index
    }

    override fun areContentsTheSame(
        oldItem: AnnouncementListItem,
        newItem: AnnouncementListItem
    ): Boolean {
        TODO("Not yet implemented")
    }

}