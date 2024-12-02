package buy.coke.zet.presentation.info.announcement

import android.os.Bundle
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.LinearLayoutManager
import buy.coke.zet.presentation.R
import buy.coke.zet.presentation.databinding.ActivityAnnouncementBinding
import buy.coke.zet.presentation.info.announcement.list.AnnouncementListItem
import buy.coke.zet.presentation.info.announcement.list.AnnouncementListItemAdapter

class AnnouncementActivity : AppCompatActivity() {
    private lateinit var binding: ActivityAnnouncementBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_announcement)

        val items = listOf(
            AnnouncementListItem("2024-12-01", "v.1.0 업데이트 안내 드립니다. 1) 알림 기능이 추가되었습니다. 참고 부탁드립니다.", 0) { item ->
                Toast.makeText(this, "Clicked: ${item.title}", Toast.LENGTH_SHORT).show()
            },
            AnnouncementListItem("2024-12-02", "v.1.0 업데이트 안내 드립니다. 1) 알림 기능이 추가되었습니다. 참고 부탁드립니다.", 1) { item ->
                Toast.makeText(this, "Clicked: ${item.title}", Toast.LENGTH_SHORT).show()
            },
            AnnouncementListItem("2024-12-03", "v.1.0 업데이트 안내 드립니다. 1) 알림 기능이 추가되었습니다. 참고 부탁드립니다.", 2) { item ->
                Toast.makeText(this, "Clicked: ${item.title}", Toast.LENGTH_SHORT).show()
            }
        )

        val adapter = AnnouncementListItemAdapter()
        binding.annoucementList.adapter = adapter
        binding.annoucementList.layoutManager = LinearLayoutManager(this)

        adapter.submitList(items)
    }
}