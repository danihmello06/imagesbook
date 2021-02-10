package com.example.imagesbook.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.imagesbook.R
import com.example.imagesbook.viewmodel.AppViewModel
import com.google.android.material.bottomnavigation.BottomNavigationView

class NewsFeed : AppCompatActivity() {

    lateinit var viewModel: AppViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_news_feed)

        viewModel = ViewModelProvider(this).get(AppViewModel::class.java)

        val bottomNV = findViewById<BottomNavigationView>(R.id.bottom_navigation)

        val frag1 = Fragment01()
        val frag2 = Fragment02()
        val frag3 = Fragment03()

        makeCurrentFragment(frag1)

        bottomNV.setOnNavigationItemSelectedListener {
            when(it.itemId) {
                R.id.menu_home -> makeCurrentFragment(frag1)
                R.id.menu_search -> makeCurrentFragment(frag2)
                R.id.menu_message -> makeCurrentFragment(frag3)
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