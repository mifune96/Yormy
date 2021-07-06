package tomuch.coffee.yormy.ui.adapter

import android.app.Activity
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.squareup.picasso.Picasso
import tomuch.coffee.yormy.R
import tomuch.coffee.yormy.model.FoodModel

class FoodsAdapter(val activity: Activity, val arrayFood: ArrayList<FoodModel>) :
    RecyclerView.Adapter<FoodsAdapter.Holder>() {
    class Holder(view: View) : RecyclerView.ViewHolder(view) {
        val foodChef = view.findViewById<TextView>(R.id.tv_chef)
        val foodName = view.findViewById<TextView>(R.id.tv_food)
        val imgFood = view.findViewById<ImageView>(R.id.iv_food)

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): Holder {
        val view: View =
            LayoutInflater.from(parent.context).inflate(R.layout.food_item, parent, false)
        return Holder(view)
    }

    override fun onBindViewHolder(holder: Holder, position: Int) {
        Picasso.get()
            .load(arrayFood[position].foodimg)
            .placeholder(R.drawable.nasiuduk)
            .error(R.drawable.nasiuduk)
            .into(holder.imgFood)

        holder.foodChef.text = arrayFood[position].chefname
        holder.foodName.text = arrayFood[position].foodname

        Log.d("isi datanya","adalah :" +arrayFood[position].chefname)
    }

    override fun getItemCount() = arrayFood.size


}