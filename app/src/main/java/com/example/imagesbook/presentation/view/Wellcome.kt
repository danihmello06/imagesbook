package com.example.imagesbook.presentation.view

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.Navigation
import com.example.imagesbook.R
import kotlinx.android.synthetic.main.wellcome.view.*

class Wellcome : Fragment() {


    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {

        val view  = inflater.inflate(R.layout.wellcome, container, false)

        view.btnContinuar.setOnClickListener{
            Navigation.findNavController(view).navigate(R.id.action_wellcome_to_createAccount)
        }

        return view
    }




}