package buy.coke.zet.presentation.info.mypage

import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import buy.coke.zet.presentation.R
import buy.coke.zet.presentation.databinding.ActivityMyPageBinding
import buy.coke.zet.presentation.info.announcement.AnnouncementActivity
import buy.coke.zet.presentation.info.notification_setting.NotificationSettingActivity

class MyPageActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMyPageBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_my_page)

        binding.setPriceNotificationButton.root.setOnClickListener { startActivity(Intent(this, NotificationSettingActivity::class.java)) }
        binding.announcementButton.root.setOnClickListener { startActivity(Intent(this, AnnouncementActivity::class.java)) }
        binding.mypageTopbar.leftIconClickListener = View.OnClickListener {
            finish()
        }
    }
}