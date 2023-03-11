package com.example.task

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.task.databinding.ActivityMainBinding
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.ValueEventListener
import com.google.firebase.database.ktx.database
import com.google.firebase.ktx.Firebase
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        var count=0

        val database = Firebase.database
        val myRef = database.getReference()
        Addbutton.setOnClickListener {
            var namee = Name.text.toString()
            val id = ID.text.toString()
            val age = age.text.toString()
            val parson= hashmap(
                "name" to namee,
                "id" to id,
                "age" to age,
            )
            myRef.child("parson").child("$count").setValue(parson)
            count++
            Toast.makeText(applicationContext,"true",Toast.LENGTH_LONG).show()
        }
        GetData.setOnClickListener {
            myRef.addValueEventListener(object: ValueEventListener {

                override fun onDataChange(snapshot: DataSnapshot) {
                    // This method is called once with the initial value and again
                    // whenever data at this location is updated.
                    val value = snapshot.getValue()
                    Toast.makeText(applicationContext,"true",Toast.LENGTH_LONG).show()
                    textView.text =value.toString()
                }

                override fun onCancelled(error: DatabaseError) {
                    Toast.makeText(applicationContext,"false",Toast.LENGTH_LONG).show()

                }

            })
        }


    }
    }
}