package com.example.lab5

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.widget.Button
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val btnOpenDialog: Button = findViewById(R.id.btnOpenDialog)
        val btnOpenBrowser: Button = findViewById(R.id.btnOpenBrowser)
        val btnCallMe: Button = findViewById(R.id.btnCallMe)
        val btnSendEmail: Button = findViewById(R.id.btnSendEmail)

        btnOpenDialog.setOnClickListener {
            val dialog = MyDialogFragment()
            dialog.show(supportFragmentManager, "MyDialogFragment")
        }

        btnOpenBrowser.setOnClickListener {
            val browserIntent = Intent(Intent.ACTION_VIEW, Uri.parse("https://www.google.com"))
            startActivity(browserIntent)
        }

        btnCallMe.setOnClickListener {
            val callIntent = Intent(Intent.ACTION_DIAL)
            callIntent.data = Uri.parse("tel:+1234567890") // Replace with your number
            startActivity(callIntent)
        }

        btnSendEmail.setOnClickListener {
            val emailIntent = Intent(Intent.ACTION_SENDTO)
            emailIntent.data = Uri.parse("mailto:your-email@example.com") // Replace with your email
            emailIntent.putExtra(Intent.EXTRA_SUBJECT, "Hello from my app")
            startActivity(emailIntent)
        }
    }
}