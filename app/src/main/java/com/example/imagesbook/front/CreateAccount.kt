package com.example.imagesbook.front

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.Navigation
import com.example.imagesbook.R
import kotlinx.android.synthetic.main.create_account.view.*

class CreateAccount: Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        val view = inflater.inflate(R.layout.create_account, container, false)

        view.btnAvancar.setOnClickListener{
            Navigation.findNavController(view).navigate(R.id.action_createAccount_to_feed)
        }

        return view
    }
}