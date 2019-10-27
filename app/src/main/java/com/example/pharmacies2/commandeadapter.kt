package com.example.pharmacies2

import android.content.Context
import android.content.Intent
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import android.widget.Toast

class commandeadapter(var commandes: ArrayList<String>,context: Context) : RecyclerView.Adapter<commandeadapter.ViewHolder>() {
    var mContext = context
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): commandeadapter.ViewHolder {
        val view:View =LayoutInflater.from(parent.context).inflate(R.layout.commande_item,parent,false)
        return ViewHolder(view)
    }

    override fun getItemCount()=commandes.size

    override fun onBindViewHolder(holder:ViewHolder, position: Int) {
        holder.commandename.text=commandes[position]
        holder.setOnCostomItemClickListener(object :CostomItemClickListener{
            override fun onCostomItemClickListener(view: View, pos: Int) {
                Toast.makeText(mContext,commandes[pos], Toast.LENGTH_LONG).show()
                val intent= Intent(mContext, commande_detail::class.java)
                intent.putExtra("commande from navigation", "true")
                mContext.startActivity(intent)

            }
        })
    }
    class ViewHolder(itemview: View):RecyclerView.ViewHolder(itemview) , View.OnClickListener{
        val commandename :TextView
        var costomItemClickListener:CostomItemClickListener?=null
        init {
            commandename=itemview.findViewById(R.id.commandename)
            itemview.setOnClickListener(this)
        }
        fun setOnCostomItemClickListener(itemClickListener:CostomItemClickListener){
            this.costomItemClickListener = itemClickListener
        }

        override fun onClick(p0: View?) {
            this.costomItemClickListener!!.onCostomItemClickListener(p0!!,adapterPosition)
        }

    }

}