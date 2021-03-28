package com.example.imagesbook.view.Activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.example.imagesbook.R
import com.example.imagesbook.view.Fragment.NewsFeedFragment
import com.example.imagesbook.view.Fragment.SearchFragment
import com.example.imagesbook.view.Fragment.ProfileFragment
import com.example.imagesbook.viewmodel.AppViewModel
import com.google.android.material.bottomnavigation.BottomNavigationView

class HomeActivity : AppCompatActivity() {

    lateinit var viewModel: AppViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)

        viewModel = ViewModelProvider(this).get(AppViewModel::class.java)

        val bottomNV = findViewById<BottomNavigationView>(R.id.bottom_navigation)

        val newsFeedFragment = NewsFeedFragment()
        val searchFragment = SearchFragment()
        val profileFragment = ProfileFragment()

        makeCurrentFragment(newsFeedFragment)

        bottomNV.setOnNavigationItemSelectedListener {
            when(it.itemId) {
                R.id.menu_home -> makeCurrentFragment(newsFeedFragment)
                R.id.menu_search -> makeCurrentFragment(searchFragment)
                R.id.menu_message -> makeCurrentFragment(profileFragment)
            }
            true
        }
    }

    private fun makeCurrentFragment(fragment: Fragment) =
        supportFragmentManager.beginTransaction().apply {
            replace(R.id.fl_wrapper, fragment)
            commit()
        }

}