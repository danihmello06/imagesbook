package com.example.imagesbook

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.imagesbook.backend.DataSource
import kotlinx.android.synthetic.main.fragment_01.*



class Fragment01 : Fragment() {

    private lateinit var recyclerAdapter: RecyclerAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_01, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        initRecyclerView()
        addDataSet()
    }

//    companion object {
//        @JvmStatic
//        fun newInstance(param1: String, param2: String) =
//            Fragment01().apply {
//                arguments = Bundle().apply {
//                }
//            }
//    }

    private fun addDataSet() {
        val data = DataSource.createDataSet()
        recyclerAdapter.submitList(data)
    }

    private fun initRecyclerView() {
        recycler_view.apply {
            layoutManager = LinearLayoutManager(context)
            val topSpacingDecoration = TopSpacingItemDecoration(30)
            addItemDecoration(topSpacingDecoration)
            recyclerAdapter = RecyclerAdapter()
            adapter = recyclerAdapter
        }
    }


}