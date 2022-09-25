package com.example.blogapp

import android.content.ContentValues.TAG
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.EditText
import com.google.firebase.firestore.FirebaseFirestore

class ReadRecordsActivity : AppCompatActivity() {

    private var db: FirebaseFirestore? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_read_records)

        db = FirebaseFirestore.getInstance()






    }

    fun getOneRecord(view: View) {
        // one record

        var email: String = findViewById<EditText>(R.id.email3_edit_text).text.toString()
        val docRef = db!!.collection("Users").document(email)
        docRef.get()
            .addOnSuccessListener { document ->
                if (document != null) {
                    Log.d(TAG, "DocumentSnapshot data: ${document.data}")
                } else {
                    Log.d(TAG, "No such document")
                }
            }
            .addOnFailureListener { exception ->
                Log.d(TAG, "get failed with ", exception)
            }

    }
    fun recordCondition(view: View) {
        // records with condition

        var phNo: String = findViewById<EditText>(R.id.phone_num_edit_text).text.toString()
        db!!.collection("Users")
            .whereEqualTo("phoneNo", phNo )
            .get()
            .addOnSuccessListener { documents ->
                for (document in documents) {
                    Log.d(TAG, "${document.id} => ${document.data}")
                }
            }
            .addOnFailureListener { exception ->
                Log.w(TAG, "Error getting documents: ", exception)
            }
    }
    fun allUsersRead(view: View) {
        // all docs
        db!!.collection("Users")
            .get()
            .addOnSuccessListener { result ->
                for (document in result) {
                    Log.d(TAG, "${document.id} => ${document.data}")
                }
            }
            .addOnFailureListener { exception ->
                Log.d(TAG, "Error getting documents: ", exception)
            }

    }
}