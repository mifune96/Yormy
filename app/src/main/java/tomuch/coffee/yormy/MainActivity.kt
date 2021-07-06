package tomuch.coffee.yormy

import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import com.google.android.material.bottomnavigation.BottomNavigationView
import tomuch.coffee.yormy.databinding.ActivityMainBinding
import tomuch.coffee.yormy.ui.fragment.*

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private val fm: FragmentManager = supportFragmentManager
    private val mf: Fragment = HomeFragment()
    private var activ : Fragment = mf
    private val f1 : Fragment = BlankFragment()
    private val f2: Fragment = BlankFragment2()
    private val f3: Fragment = BlankFragment3()
    private val f4: Fragment = BlankFragment4()

    private lateinit var bottomNavView: BottomNavigationView
    private lateinit var menu: Menu
    private lateinit var menuItem: MenuItem

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        supportActionBar?.hide()
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setUpBottomNav()

    }

    private fun setUpBottomNav() {
        fm.beginTransaction().add(R.id.nav_host_fragment_activity_main, mf).show(mf).commit()
        fm.beginTransaction().add(R.id.nav_host_fragment_activity_main, f1).hide(f1).commit()
        fm.beginTransaction().add(R.id.nav_host_fragment_activity_main, f2).hide(f2).commit()
        fm.beginTransaction().add(R.id.nav_host_fragment_activity_main, f3).hide(f3).commit()
        fm.beginTransaction().add(R.id.nav_host_fragment_activity_main, f4).hide(f4).commit()

        bottomNavView = findViewById(R.id.nav_view)

        menu = bottomNavView.menu
        menuItem = menu.getItem(0)
        menuItem.isChecked = true

        bottomNavView.setOnItemSelectedListener { item ->
            when(item.itemId){
                R.id.navigation_search -> {
                    callFragment(0,mf)
                }

                R.id.navigation_category -> {
                    callFragment(1,f1)
                }

                R.id.navigation_history -> {
                    callFragment(2,f2)
                }

                R.id.navigation_inbox -> {
                    callFragment(3,f3)
                }

                R.id.navigation_profile -> {
                    callFragment(3,f4)
                }
            }

            false
        }
    }

    fun callFragment(int: Int, fragment: Fragment){
        menuItem = menu.getItem(int)
        menuItem.isChecked = true
        fm.beginTransaction().hide(activ).show(fragment).commit()
        activ = fragment
    }
}