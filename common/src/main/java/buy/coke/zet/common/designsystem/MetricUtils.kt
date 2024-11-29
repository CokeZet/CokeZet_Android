package buy.coke.zet.common.designsystem

import android.content.Context

fun Context.dpToPx(dp: Int) = (this.resources.displayMetrics.density * dp).toInt()

fun Context.pxToDp(px: Int) = (px / this.resources.displayMetrics.density).toInt()