package com.example.rcvreadjsonfile

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.rcvreadjsonfile.databinding.ActivityMainBinding
import com.google.gson.Gson
import org.json.JSONArray
import java.io.IOException
import java.io.InputStream

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private var TAG = "Read json"
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        val jsonFile = applicationContext.assets.open("data.json").bufferedReader().use {
            it.readText()
        }
        val data = Gson().fromJson(jsonFile,Reponse::class.java)
        val datRCV = ArrayList<DataX>()
        datRCV.addAll(data.data.data)

        // setup recyclerview
        binding.rcv.layoutManager = LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)
        val adapter = Adapter(this,datRCV)
        binding.rcv.adapter = adapter
    }


}