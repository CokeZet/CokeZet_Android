package buy.coke.zet.presentation.info.mypage

import android.content.Intent
import android.os.Bundle
import android.text.Spannable
import android.text.SpannableString
import android.text.style.ForegroundColorSpan
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import buy.coke.zet.presentation.R
import buy.coke.zet.presentation.databinding.ActivityMyPageBinding
import buy.coke.zet.presentation.info.announcement.AnnouncementActivity
import buy.coke.zet.presentation.info.notification_setting.NotificationSettingActivity
import buy.coke.zet.presentation.info.term.TERM_TITLE
import buy.coke.zet.presentation.info.term.TermActivity

class MyPageActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMyPageBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_my_page)
        val originalText = binding.userNickname.text.toString()
        binding.userNickname.text = SpannableString(originalText).apply {
            val start = originalText.indexOf("님")
            val end = start + 1

            this.setSpan(ForegroundColorSpan(getColor(buy.coke.zet.common.R.color.gray_500)), start, end, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE)
        }

        binding.setPriceNotificationButton.root.setOnClickListener { startActivity(Intent(this, NotificationSettingActivity::class.java)) }
        binding.announcementButton.root.setOnClickListener { startActivity(Intent(this, AnnouncementActivity::class.java)) }
        binding.serviceTermButton.root.setOnClickListener {
            val intent = Intent(this, TermActivity::class.java).apply {
                putExtra(TERM_TITLE, getString(R.string.service_term))
            }

            startActivity(intent)
        }
        binding.personalInformationTermButton.root.setOnClickListener {
            val intent = Intent(this, TermActivity::class.java).apply {
                putExtra(TERM_TITLE, getString(R.string.service_term))
            }

            startActivity(intent)
        }
        binding.mypageTopbar.leftIconClickListener = View.OnClickListener { finish() }
    }
}