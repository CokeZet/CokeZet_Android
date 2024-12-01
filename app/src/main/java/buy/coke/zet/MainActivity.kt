package buy.coke.zet

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import buy.coke.zet.presentation.info.mypage.MyPageActivity

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        startActivity(Intent(this, MyPageActivity::class.java))
    }
}