package com.example.myapplication

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.org_row.view.*
import kotlinx.android.synthetic.main.vet_row.view.*

class VeterinariaAdapter(private val vets: List<veterinaria>) :
    RecyclerView.Adapter<VeterinariaAdapter.ViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.vet_row, parent, false)
        return ViewHolder(view)
    }

    override fun getItemCount() = vets.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.nombreVet.text = vets[position].nombre

    }

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val nombreVet: TextView = itemView.nombre_vet
    }


}
