package buy.coke.zet.presentation.intro.entry

import android.Manifest
import android.content.Context
import android.content.Intent
import android.content.pm.PackageManager
import android.os.Build
import android.os.Bundle
import android.text.Spannable
import android.text.SpannableString
import android.text.TextPaint
import android.text.method.LinkMovementMethod
import android.text.style.ClickableSpan
import android.text.style.ForegroundColorSpan
import android.text.style.UnderlineSpan
import android.view.View
import android.widget.Toast
import androidx.activity.result.ActivityResultLauncher
import androidx.activity.result.contract.ActivityResultContracts
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import androidx.databinding.DataBindingUtil
import buy.coke.zet.common.designsystem.dialog.ShortDialog
import buy.coke.zet.presentation.R
import buy.coke.zet.presentation.databinding.ActivityEntryBinding
import buy.coke.zet.presentation.intro.splash.SplashActivity
import buy.coke.zet.presentation.setting.NicknameSettingActivity

class EntryActivity : AppCompatActivity() {
    private lateinit var binding: ActivityEntryBinding
    private lateinit var requestPermissionLauncher: ActivityResultLauncher<String>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_entry)
        requestPermissionLauncher = registerForActivityResult(ActivityResultContracts.RequestPermission()) { isGranted ->
            if (isGranted) {
                Toast.makeText(this, "알림 권한이 허용되었습니다.", Toast.LENGTH_SHORT).show()
            } else {
                Toast.makeText(this, "알림 권한이 거부되었습니다.", Toast.LENGTH_SHORT).show()
            }
            startActivity(Intent(this, NicknameSettingActivity::class.java))
        }

        setStartButtonClickListener()
        setWelcomeTextSpan()
        setTermTextSpan()
    }

    private fun setStartButtonClickListener() {
        binding.startButton.clickListener = View.OnClickListener {
            ShortDialog(
                context = this,
                yesButtonListener = {
                    if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.TIRAMISU &&
                        ContextCompat.checkSelfPermission(this, Manifest.permission.POST_NOTIFICATIONS) != PackageManager.PERMISSION_GRANTED) {
                        requestPermissionLauncher.launch(Manifest.permission.POST_NOTIFICATIONS)
                    }
                    else {
                        startActivity(Intent(this, NicknameSettingActivity::class.java))
                    }
                }).show()
        }
    }

    private fun setWelcomeTextSpan() {
        val originalWelcomeText = getString(R.string.entry_welcome)
        binding.welcomeTitle.text = SpannableString(originalWelcomeText).apply {
            val start = originalWelcomeText.indexOf("최저가 할인 정보")
            val end = start + "최저가 할인 정보".length

            this.setSpan(ForegroundColorSpan(getColor(buy.coke.zet.common.R.color.red_500)), start, end, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE)
        }
    }

    private fun setTermTextSpan() {
        val originalTermText = getString(R.string.term_introduce)
        binding.termText.text = SpannableString(originalTermText).apply {
            val startPair = Pair(originalTermText.indexOf("이용약관"), originalTermText.indexOf("개인정보처리방침"))
            val endPair = Pair(startPair.first + "이용약관".length, startPair.second + "개인정보처리방침".length)

            this.setSpan(makeClickableSpan(SplashActivity::class.java), startPair.first, endPair.first, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE)
            this.setSpan(makeClickableSpan(EntryActivity::class.java), startPair.second, endPair.second, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE)
        }
        binding.termText.movementMethod = LinkMovementMethod.getInstance()
    }

    private fun makeClickableSpan(cls: Class<*>): ClickableSpan {
        return object: ClickableSpan() {
            override fun onClick(view: View) {
//                Toast.makeText(this@EntryActivity, "Name : $cls", Toast.LENGTH_SHORT).show()
            }

            override fun updateDrawState(ds: TextPaint) {
                super.updateDrawState(ds)

                ds.color = getColor(buy.coke.zet.common.R.color.gray_500)
            }
        }
    }
}