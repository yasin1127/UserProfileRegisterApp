package com.example.uprapp.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageButton
import android.widget.TextView
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.uprapp.R
import com.example.uprapp.model.UP

class ProfileAdapter:ListAdapter<UP, ProfileAdapter.ProfileViewHolder>(DiffCallback()) {
    private var onItemClickListener:((UP)->Unit)?=null
    private var onDeleteClickListener:((UP)->Unit)?=null
    private var onEditClickListener:((UP)->Unit)?=null

    fun setOnItemClickListener(listener: (UP)->Unit){
        onItemClickListener=listener
    }
    fun setOnDeleteClickListener(listener: (UP)->Unit){
        onDeleteClickListener=listener
    }
    fun setOnEditClickListener(listener: (UP)->Unit){
        onEditClickListener=listener
    }
    inner class ProfileViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView){
    private val profileName: TextView = itemView.findViewById(R.id.ntxt)
    private val profileEmail: TextView = itemView.findViewById(R.id.etxt)
    private val profileDOB: TextView = itemView.findViewById(R.id.bodtxt)
    private val profileDistrict: TextView = itemView.findViewById(R.id.Dtxt)
    private val profileMobile: TextView = itemView.findViewById(R.id.mtxt)
    private val updateBtn: ImageButton = itemView.findViewById(R.id.ebtn)
    private val deleteBtn: ImageButton = itemView.findViewById(R.id.dbtn)

        init {
            itemView.setOnClickListener{
                val position=adapterPosition
                if(position!= RecyclerView.NO_POSITION){
                    val profile = getItem(position)
                    onItemClickListener?.invoke(profile)

                }
            }
            deleteBtn.setOnClickListener{
                val position=adapterPosition
                if (position!=RecyclerView.NO_POSITION){
                    val profile = getItem(position)
                    onDeleteClickListener?.invoke(profile)
                }

            }
          updateBtn.setOnClickListener{
              val position =adapterPosition
              if (position!=RecyclerView.NO_POSITION){
                  val profile = getItem(position)
                  onEditClickListener?.invoke(profile)
              }
          }

        }

    fun bind(up: UP){
        profileName.text = up.name
        profileEmail.text = up.email
        profileDOB.text = up.dob
        profileDistrict.text = up.dist
        profileMobile.text = up.mobile.toString()
        updateBtn.setOnClickListener {
            //update listener
        }
        deleteBtn.setOnClickListener {
            //delete listener
        }
    }
    }

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): ProfileAdapter.ProfileViewHolder {
        val itemView=LayoutInflater.from(parent.context).inflate(R.layout.activity_profilelist2,parent,false)
        return ProfileViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: ProfileAdapter.ProfileViewHolder, position: Int) {
        holder.bind(getItem(position))
    }
}

class DiffCallback:DiffUtil.ItemCallback<UP>(){
    override fun areItemsTheSame(oldItem: UP, newItem: UP): Boolean {
       return oldItem.id== newItem.id
    }

    override fun areContentsTheSame(oldItem: UP, newItem: UP): Boolean {
     return oldItem==newItem
    }


}