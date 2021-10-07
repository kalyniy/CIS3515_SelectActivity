package io.hazylabs.selectactivity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView


class DisplayActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_display)

        val name: String? = intent?.extras?.getString("name")
        val id: Int? = intent?.extras?.getInt("image")
        val textView = findViewById<TextView>(R.id.textView)
        textView.text = name

        val imageView = findViewById<ImageView>(R.id.imageView)
        imageView.setImageResource(id!!)
    }
}

