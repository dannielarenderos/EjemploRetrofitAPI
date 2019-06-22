package com.example.myapplication

import android.os.Bundle
import android.util.Log.d
import com.google.android.material.snackbar.Snackbar
import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.LiveData
import androidx.recyclerview.widget.LinearLayoutManager

import kotlinx.android.synthetic.main.activity_main2.*
import kotlinx.android.synthetic.main.fragment_organizacion.*
import kotlinx.android.synthetic.main.fragment_organizacion.view.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class Main2Activity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.fragment_organizacion)

        val retrofit = Retrofit.Builder()
            .baseUrl("https://animal-care.herokuapp.com/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()

        val api = retrofit.create(ApiService::class.java)

        api.allVeterinarias().enqueue(object : Callback<List<veterinaria>> {
            override fun onFailure(call: Call<List<veterinaria>>, t: Throwable) {
                d("No", "NO VET")
            }

            override fun onResponse(call: Call<List<veterinaria>>, response: Response<List<veterinaria>>) {
                showDataVet(response.body()!!)
                d("YES", "YES VET")
            }

        })



/*
        api.allOrganizaciones().enqueue(object : Callback<List<organizacion>> {
            override fun onFailure(call: Call<List<organizacion>>, t: Throwable) {
                d("JK", "NOOOO")
            }

            override fun onResponse(call: Call<List<organizacion>>, response: Response<List<organizacion>>) {
                d("JK", "YESSSS ${response.body()!![0].direccion}")
                showDataOrg(response.body()!!)
            }


        })


        */
    }


    private fun showDataVet(vets: List<veterinaria>) {
        rv_org.apply {
            layoutManager = LinearLayoutManager(this@Main2Activity)
            adapter = VeterinariaAdapter(vets)

        }
    }


    private fun showDataOrg(orgs: List<organizacion>) {
        rv_org.apply {
            layoutManager = LinearLayoutManager(this@Main2Activity)
            adapter = OrganizacionAdapter(orgs)

        }
    }


}
