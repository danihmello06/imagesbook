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
import kotlinx.android.synthetic.main.create_account.view.*
import java.util.*

class CreateAccount: Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        val view = inflater.inflate(R.layout.create_account, container, false)

        view.btnAvancar.setOnClickListener{
            //createAccount(view)
            Navigation.findNavController(view).navigate(R.id.action_createAccount_to_newsFeed)
        }

        return view
    }

    fun createAccount(view: View) {
        val email = view.findViewById<EditText>(R.id.email_login)
        val senha = view.findViewById<EditText>(R.id.senha)
        val user = User(UUID.randomUUID(), email.text.toString(), senha.text.toString())

        UserServiceFactory.makeService().createUser(user)
    }
}