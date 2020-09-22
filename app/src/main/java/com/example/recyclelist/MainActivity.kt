package com.example.recyclelist

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.RecoverySystem
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val items = ArrayList<Person>()


        items.add(Person("Musfiqur Rahman", "Android Developer", "01638352180",R.drawable.c))
        items.add(Person("Musfiqur Rahman", "Android Developer", "01638352180",R.drawable.c))
        items.add(Person("Musfiqur Rahman", "Android Developer", "01638352180",R.drawable.c))
        items.add(Person("Musfiqur Rahman", "Android Developer", "01638352180",R.drawable.c))
        items.add(Person("Musfiqur Rahman", "Android Developer", "01638352180",R.drawable.c))
        items.add(Person("Musfiqur Rahman", "Android Developer", "01638352180",R.drawable.c))
        items.add(Person("Musfiqur Rahman", "Android Developer", "01638352180",R.drawable.c))
        items.add(Person("Musfiqur Rahman", "Android Developer", "01638352180",R.drawable.c))
        items.add(Person("Musfiqur Rahman", "Android Developer", "01638352180",R.drawable.c))
        items.add(Person("Musfiqur Rahman", "Android Developer", "01638352180",R.drawable.c))


        val persons = findViewById<RecyclerView>(R.id.recycler_persons)
        val adapter = Adapter(items,applicationContext)

        persons.layoutManager = GridLayoutManager(applicationContext,2)

        persons.adapter = adapter


    }
}