package buy.coke.zet.presentation.info.announcement.list

data class AnnouncementListItem(
    val date: String,
    val title: String,
    val index: Int,
    val clickListener: (AnnouncementListItem) -> Unit
)
