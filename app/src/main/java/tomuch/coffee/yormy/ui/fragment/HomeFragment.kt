package tomuch.coffee.yormy.ui.fragment

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import tomuch.coffee.yormy.R
import tomuch.coffee.yormy.model.FoodModel
import tomuch.coffee.yormy.ui.adapter.FoodsAdapter

class HomeFragment : Fragment() {


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view: View = inflater.inflate(R.layout.fragment_home, container, false)
        init(view)
        displayFood()

        return view
    }

    fun displayFood() {
        val layoutManager = GridLayoutManager(activity, 2)
        layoutManager.orientation = LinearLayoutManager.VERTICAL

        rvFood.adapter = FoodsAdapter(requireActivity(), getFood())
        rvFood.layoutManager = layoutManager

        Log.d("getfood", "Adalah" + getFood())
    }


    private fun getFood(): ArrayList<FoodModel> {
        val getChefName = resources.getStringArray(R.array.chefname)
        val getFoodName = resources.getStringArray(R.array.foodname)
        val getFoodImg = resources.obtainTypedArray(R.array.foodimg)

        val arrayListFood: ArrayList<FoodModel> = arrayListOf()
        for (i in getChefName.indices) {
            arrayListFood.add(
                FoodModel(

                    getChefName[i],
                    getFoodName[i],
                    getFoodImg.getResourceId(i,-1)

                )
            )
        }


        return arrayListFood

    }

    lateinit var rvFood: RecyclerView
    fun init(view: View) {
        rvFood = view.findViewById(R.id.rv_food)
    }

}