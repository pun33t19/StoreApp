package com.example.resoluteaidemo

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Gravity
import androidx.core.view.GravityCompat
import androidx.drawerlayout.widget.DrawerLayout
import androidx.navigation.NavController
import androidx.navigation.NavHost
import androidx.navigation.Navigation
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.setupWithNavController
import androidx.viewpager2.widget.ViewPager2
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.google.android.material.imageview.ShapeableImageView


class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val drawerLayout=findViewById<DrawerLayout>(R.id.drawer_layout)

        findViewById<ShapeableImageView>(R.id.drawer_icon).setOnClickListener {
            drawerLayout.openDrawer(GravityCompat.START)
        }


        val navHostFragment=supportFragmentManager.findFragmentById(R.id.nav_host_fragment) as NavHostFragment

        val navController=navHostFragment.navController

        findViewById<BottomNavigationView>(R.id.bottom_nav).setupWithNavController(navController)


    }
}