package buy.coke.zet.presentation.info.notification_setting

import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import buy.coke.zet.presentation.R
import buy.coke.zet.presentation.databinding.ActivityNotificationSettingBinding

class NotificationSettingActivity : AppCompatActivity() {
    private lateinit var binding: ActivityNotificationSettingBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_notification_setting)
        binding.notificationTopbar.leftIconClickListener = View.OnClickListener {
            finish()
        }
    }
}