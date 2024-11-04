package buy.coke.zet.presentation

import android.graphics.Color
import android.os.Bundle
import android.util.Log
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.databinding.DataBindingUtil
import buy.coke.zet.common.designsystem.statebutton.LogoButton
import buy.coke.zet.presentation.databinding.ActivityIntroBinding

class IntroActivity : AppCompatActivity() {
    private lateinit var binding: ActivityIntroBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_intro)

        Log.d("ZET_Android", ContextCompat.getColor(this, buy.coke.zet.common.R.color.red_600).toString())
        Log.d("ZET_Android", Color.parseColor("#EE2D2B").toString())
    }

    private fun convertColorIdToString(colorId: Int) = String.format("#%06X", 0xFFFFFF and colorId)
}