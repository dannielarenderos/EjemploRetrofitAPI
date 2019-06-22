package com.example.myapplication

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.org_row.view.*

class OrganizacionAdapter(private val orgs: List<organizacion>) :
    RecyclerView.Adapter<OrganizacionAdapter.ViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.org_row, parent, false)
        return ViewHolder(view)
    }

    override fun getItemCount() = orgs.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.nombreOrg.text = orgs[position].direccion

    }

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val nombreOrg: TextView = itemView.nombre
    }


}
