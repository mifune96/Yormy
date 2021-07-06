package tomuch.coffee.yormy.model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
class FoodModel (

    val chefname: String,
    val foodname: String,
    val foodimg: Int,

        ): Parcelable