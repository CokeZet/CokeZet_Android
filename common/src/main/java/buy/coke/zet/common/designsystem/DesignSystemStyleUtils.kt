package buy.coke.zet.common.designsystem

import buy.coke.zet.common.R

object NormalButtonStyle {
    enum class Color {
        LIGHT_RED, RED, WHITE, GRAY, BLACK
    }

    enum class Shape(val drawableId: Int) {
        RECTANGLE(R.drawable.rectangle_button), ROUND(R.drawable.round_button)
    }

}

object TopBarStyle {
    enum class Image {
        LOGO, BACK, NOTIFICATION, GRAPH, PERSON, EXIT
    }

}

object LogoButtonStyle {
    enum class BrandName(val defaultResourceId: Int, val activeResourceId: Int) {
        BC(R.drawable.bc_defaulticon, R.drawable.bc_activeicon),
        CITY(R.drawable.city_defaulticon, R.drawable.city_activeicon),
        COUPANG(R.drawable.coupang_defaulticon, R.drawable.coupang_activeicon),
        ELEVENTHSTREET(R.drawable.eleventhstreet_defaulticon, R.drawable.eleventhstreet_activeicon),
        GMARKET(R.drawable.gmarket_defaulticon, R.drawable.gmarket_activeicon),
        HANA(R.drawable.hana_defaulticon, R.drawable.hana_activeicon),
        HYUNDAI(R.drawable.hyundai_defaulticon, R.drawable.hyundai_activeicon),
        KOOKMIN(R.drawable.kookmin_defaulticon, R.drawable.kookmin_activeicon),
        LOTTE(R.drawable.lotte_defaulticon, R.drawable.lotte_activeicon),
        MARKETKURLY(R.drawable.marketkurly_defaulticon, R.drawable.marketkurly_activeicon),
        NAVERSHOPPING(R.drawable.navershopping_defaulticon, R.drawable.navershopping_activeicon),
        NONGHYUP(R.drawable.nonghyup_defaulticon, R.drawable.nonghyup_activeicon),
        SAMGSUNG(R.drawable.samgsung_defaulticon, R.drawable.samgsung_activeicon),
        SHINHAN(R.drawable.shinhan_defaulticon, R.drawable.shinhan_activeicon),
        WOORI(R.drawable.woori_defaulticon, R.drawable.woori_activeicon)
    }

}