package com.onedev.dicoding.coronaindonesia.utils

import java.text.DecimalFormat
import java.util.HashMap

object Support {
    fun convertToDec(value: Double): String {
        val dec = DecimalFormat("#,###")
        return dec.format(value)
    }

    fun getImgUrlByProvinceName(key: String): String {
        val hashMap: HashMap<String, String> = HashMap()
        hashMap["DKI Jakarta"]                = "https://upload.wikimedia.org/wikipedia/commons/thumb/e/eb/Coat_of_arms_of_Jakarta.svg/106px-Coat_of_arms_of_Jakarta.svg.png"
        hashMap["Jawa Barat"]                 = "https://upload.wikimedia.org/wikipedia/commons/thumb/9/99/Coat_of_arms_of_West_Java.svg/103px-Coat_of_arms_of_West_Java.svg.png"
        hashMap["Jawa Tengah"]                = "https://upload.wikimedia.org/wikipedia/commons/thumb/b/bd/Coat_of_arms_of_Central_Java.svg/112px-Coat_of_arms_of_Central_Java.svg.png"
        hashMap["Jawa Timur"]                 = "https://upload.wikimedia.org/wikipedia/commons/thumb/7/74/Coat_of_arms_of_East_Java.svg/85px-Coat_of_arms_of_East_Java.svg.png"
        hashMap["Daerah Istimewa Yogyakarta"] = "https://upload.wikimedia.org/wikipedia/commons/thumb/b/b8/Coat_of_arms_of_Yogyakarta.svg/92px-Coat_of_arms_of_Yogyakarta.svg.png"
        hashMap["Kalimantan Utara"]           = "https://upload.wikimedia.org/wikipedia/commons/thumb/2/21/Coat_of_arms_of_North_Kalimantan_%282021_version%29.svg/89px-Coat_of_arms_of_North_Kalimantan_%282021_version%29.svg.png"
        hashMap["Kalimantan Barat"]           = "https://upload.wikimedia.org/wikipedia/commons/thumb/5/5d/Coat_of_arms_of_West_Kalimantan.svg/88px-Coat_of_arms_of_West_Kalimantan.svg.png"
        hashMap["Kalimantan Timur"]           = "https://upload.wikimedia.org/wikipedia/commons/thumb/b/bc/Coat_of_arms_of_East_Kalimantan.svg/98px-Coat_of_arms_of_East_Kalimantan.svg.png"
        hashMap["Kalimantan Tengah"]          = "https://upload.wikimedia.org/wikipedia/commons/thumb/4/4e/Coat_of_arms_of_Central_Kalimantan.svg/90px-Coat_of_arms_of_Central_Kalimantan.svg.png"
        hashMap["Kalimantan Selatan"]         = "https://upload.wikimedia.org/wikipedia/commons/thumb/a/a6/Coat_of_arms_of_South_Kalimantan.svg/86px-Coat_of_arms_of_South_Kalimantan.svg.png"
        hashMap["Sulawesi Barat"]             = "https://upload.wikimedia.org/wikipedia/commons/thumb/8/89/Coat_of_arms_of_West_Sulawesi.svg/104px-Coat_of_arms_of_West_Sulawesi.svg.png"
        hashMap["Sulawesi Utara"]             = "https://upload.wikimedia.org/wikipedia/commons/thumb/6/68/Coat_of_arms_of_North_Sulawesi.svg/120px-Coat_of_arms_of_North_Sulawesi.svg.png"
        hashMap["Sulawesi Tengah"]            = "https://upload.wikimedia.org/wikipedia/commons/thumb/4/46/Coat_of_arms_of_Central_Sulawesi.svg/87px-Coat_of_arms_of_Central_Sulawesi.svg.png"
        hashMap["Sulawesi Selatan"]           = "https://upload.wikimedia.org/wikipedia/commons/thumb/6/67/Coat_of_arms_of_South_Sulawesi.svg/98px-Coat_of_arms_of_South_Sulawesi.svg.png"
        hashMap["Sulawesi Tenggara"]          = "https://upload.wikimedia.org/wikipedia/commons/thumb/3/31/Coat_of_arms_of_Southeast_Sulawesi.svg/120px-Coat_of_arms_of_Southeast_Sulawesi.svg.png"
        hashMap["Sumatera Barat"]             = "https://upload.wikimedia.org/wikipedia/commons/thumb/6/62/Coat_of_arms_of_West_Sumatra.svg/105px-Coat_of_arms_of_West_Sumatra.svg.png"
        hashMap["Sumatera Utara"]             = "https://upload.wikimedia.org/wikipedia/commons/thumb/c/c8/Coat_of_arms_of_North_Sumatra.svg/96px-Coat_of_arms_of_North_Sumatra.svg.png"
        hashMap["Sumatera Selatan"]           = "https://upload.wikimedia.org/wikipedia/commons/thumb/4/45/Coat_of_arms_of_South_Sumatra.svg/93px-Coat_of_arms_of_South_Sumatra.svg.png"
        hashMap["Banten"]                     = "https://upload.wikimedia.org/wikipedia/commons/thumb/5/52/Coat_of_arms_of_Banten.svg/114px-Coat_of_arms_of_Banten.svg.png"
        hashMap["Bali"]                       = "https://upload.wikimedia.org/wikipedia/commons/thumb/1/10/Coat_of_arms_of_Bali.svg/120px-Coat_of_arms_of_Bali.svg.png"
        hashMap["Nusa Tenggara Timur"]        = "https://upload.wikimedia.org/wikipedia/commons/thumb/9/9c/Coat_of_arms_of_East_Nusa_Tenggara.svg/116px-Coat_of_arms_of_East_Nusa_Tenggara.svg.png"
        hashMap["Nusa Tenggara Barat"]        = "https://upload.wikimedia.org/wikipedia/commons/thumb/5/51/Coat_of_arms_of_West_Nusa_Tenggara.svg/81px-Coat_of_arms_of_West_Nusa_Tenggara.svg.png"
        hashMap["Bangka Belitung"]            = "https://upload.wikimedia.org/wikipedia/commons/thumb/0/08/Coat_of_arms_of_Bangka_Belitung_Islands.svg/96px-Coat_of_arms_of_Bangka_Belitung_Islands.svg.png"
        hashMap["Lampung"]                    = "https://upload.wikimedia.org/wikipedia/commons/thumb/f/f0/Coat_of_arms_of_Lampung.svg/81px-Coat_of_arms_of_Lampung.svg.png"
        hashMap["Aceh"]                       = "https://upload.wikimedia.org/wikipedia/commons/thumb/4/41/Coat_of_arms_of_Aceh.svg/118px-Coat_of_arms_of_Aceh.svg.png"
        hashMap["Riau"]                       = "https://upload.wikimedia.org/wikipedia/commons/thumb/0/0b/Coat_of_arms_of_Riau.svg/81px-Coat_of_arms_of_Riau.svg.png"
        hashMap["Kepulauan Riau"]             = "https://upload.wikimedia.org/wikipedia/commons/thumb/5/54/Coat_of_arms_of_Riau_Islands.svg/90px-Coat_of_arms_of_Riau_Islands.svg.png"
        hashMap["Jambi"]                      = "https://upload.wikimedia.org/wikipedia/commons/thumb/f/f2/Coat_of_arms_of_Jambi.svg/115px-Coat_of_arms_of_Jambi.svg.png"
        hashMap["Bengkulu"]                   = "https://upload.wikimedia.org/wikipedia/commons/thumb/5/54/Coat_of_arms_of_Bengkulu.svg/95px-Coat_of_arms_of_Bengkulu.svg.png"
        hashMap["Gorontalo"]                  = "https://upload.wikimedia.org/wikipedia/commons/thumb/0/01/Coat_of_arms_of_Gorontalo.svg/107px-Coat_of_arms_of_Gorontalo.svg.png"
        hashMap["Papua"]                      = "https://upload.wikimedia.org/wikipedia/commons/thumb/9/98/Coat_of_arms_of_Papua_2.svg/104px-Coat_of_arms_of_Papua_2.svg.png"
        hashMap["Papua Barat"]                = "https://upload.wikimedia.org/wikipedia/commons/thumb/d/de/Coat_of_arms_of_West_Papua.svg/84px-Coat_of_arms_of_West_Papua.svg.png"
        hashMap["Maluku"]                     = "https://upload.wikimedia.org/wikipedia/commons/thumb/3/39/Coat_of_arms_of_Maluku.svg/109px-Coat_of_arms_of_Maluku.svg.png"
        hashMap["Maluku Utara"]               = "https://upload.wikimedia.org/wikipedia/commons/thumb/7/73/Coat_of_arms_of_North_Maluku.svg/104px-Coat_of_arms_of_North_Maluku.svg.png"

        return hashMap[key]!!
    }
}