package com.medialink.recycleroptionsmenu

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    private var list = arrayListOf<MyList>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        rv_main.setHasFixedSize(true)
        rv_main.layoutManager = LinearLayoutManager(this)
        //loading list view item with this function
        loadRecyclerViewItem()
    }

    private fun loadRecyclerViewItem() {
        //you can fetch the data from server or some apis
        //for this tutorial I am adding some dummy data directly
        for (i in 1..5) {
            val myList = MyList(
                "Dummy Heading $i",
                "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Morbi molestie nisi dui."
            )
            list.add(myList)
        }

        val adapter = CustomAdapter(list, this)
        rv_main.adapter = adapter
    }
}
