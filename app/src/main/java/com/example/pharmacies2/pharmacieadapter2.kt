package com.example.pharmacies2

import android.content.Context
import android.content.Intent
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import android.widget.Toast

class pharmacieadapter2(var pharmacies: ArrayList<String>,context: Context) :RecyclerView.Adapter<pharmacieadapter2.ViewHolder>() {
    var mContext = context
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int):pharmacieadapter2.ViewHolder {
        val view: View = LayoutInflater.from(parent.context).inflate(R.layout.pharmacie_item,parent,false)
        return ViewHolder(view)
    }

    override fun getItemCount()=pharmacies.size

    override fun onBindViewHolder(holder:ViewHolder, position: Int) {
        holder.pharmacienamename.text=pharmacies[position]
        holder.setOnCostomItemClickListener(object :CostomItemClickListener{
            override fun onCostomItemClickListener(view: View, pos: Int) {
                Toast.makeText(mContext,pharmacies[pos], Toast.LENGTH_LONG).show()
                val intent= Intent(mContext, pharmacies_detail::class.java)
                intent.putExtra("commande from navigation", "false")
                mContext.startActivity(intent)
            }
        })
    }
    class ViewHolder(itemview: View): RecyclerView.ViewHolder(itemview) , View.OnClickListener{
        var pharmacienamename : TextView
        var costomItemClickListener:CostomItemClickListener?=null
        init {
            pharmacienamename=itemview.findViewById(R.id.pharmaciename)
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