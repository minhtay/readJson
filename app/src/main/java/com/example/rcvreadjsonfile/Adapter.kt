package com.example.rcvreadjsonfile

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.rcvreadjsonfile.databinding.ItemRcvBinding

class Adapter(val activity: Context, val dataList: ArrayList<DataX>) :
    RecyclerView.Adapter<Adapter.ViewHolder>() {
    class ViewHolder( val binding: ItemRcvBinding) : RecyclerView.ViewHolder(binding.root) {}

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(ItemRcvBinding.inflate(LayoutInflater.from(parent.context),parent,false))
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.binding.id.text = dataList[position].id
        holder.binding.invitedUserId.text = dataList[position].invited_user_id
        holder.binding.invitedUserFullName.text = dataList[position].invited_user_full_name
        holder.binding.type.text = dataList[position].type
        holder.binding.amount.text = dataList[position].amount
        holder.binding.earningDate.text = dataList[position].earning_date.toString()
    }

    override fun getItemCount(): Int {
        return dataList.size
    }
}