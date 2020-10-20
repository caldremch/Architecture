package com.caldremch.andorid.architecture.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.paging.PagedListAdapter
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.caldremch.andorid.architecture.R
import com.caldremch.andorid.architecture.bean.ItemBean

/**
 *
 * @author Caldremch
 *
 * @date 2020-10-20
 *
 * @email caldremch@163.com
 *
 * @describe
 *
 **/

class ListAdapter() :

    PagedListAdapter<ItemBean, ListAdapter.ViewHolder>(diffCallback) {

    companion object {
        val diffCallback = object : DiffUtil.ItemCallback<ItemBean>() {
            override fun areItemsTheSame(oldItem: ItemBean, newItem: ItemBean): Boolean {
                return oldItem.id == newItem.id
            }

            override fun areContentsTheSame(oldItem: ItemBean, newItem: ItemBean): Boolean {
                return oldItem == newItem
            }

        }
    }

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        fun bindView(itemView: View){
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.item_list, parent, false))
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
       getItem(position)?.id
    }
}