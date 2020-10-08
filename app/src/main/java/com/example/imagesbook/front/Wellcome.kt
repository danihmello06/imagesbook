package com.example.imagesbook.front

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.EditText
import androidx.fragment.app.Fragment
import androidx.navigation.Navigation
import com.example.imagesbook.R
import com.example.imagesbook.backend.data.remote.UserServiceFactory
import com.example.imagesbook.backend.model.User
import kotlinx.android.synthetic.main.wellcome.view.*
import java.util.*

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