package com.medialink.recycleroptionsmenu

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.PopupMenu
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.main_item.view.*

class CustomAdapter(val list: List<MyList>, val mCtx: Context) :
    RecyclerView.Adapter<CustomAdapter.MyViewHolder>() {

    inner class MyViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        fun bind(item: MyList) {
            with(itemView) {
                tv_header.text = item.head
                tv_desc.text = item.desc
                tv_options.setOnClickListener {
                    val popup: PopupMenu = PopupMenu(mCtx, tv_options)
                    popup.inflate(R.menu.options_menu)
                    popup.setOnMenuItemClickListener {
                        when (it.itemId) {
                            R.id.menu1 -> Toast.makeText(mCtx, "menu 1", Toast.LENGTH_SHORT).show()
                            R.id.menu2 -> Toast.makeText(mCtx, "menu 2", Toast.LENGTH_SHORT).show()
                            else -> {
                                Toast.makeText(mCtx, "menu 3", Toast.LENGTH_SHORT).show()
                            }

                        }
                        return@setOnMenuItemClickListener true
                    }
                    popup.show()
                }

            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val v = LayoutInflater.from(parent.context)
            .inflate(R.layout.main_item, parent, false)
        return MyViewHolder(v)
    }

    override fun getItemCount(): Int = list.size

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        holder.bind(list[position])
    }

}