package io.hazylabs.selectactivity

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Display
import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import java.util.*
import kotlin.collections.ArrayList

val ids: IntArray = intArrayOf(  R.drawable.australian,
    R.drawable.blackretriever,
    R.drawable.chow,
    R.drawable.corgi,
    R.drawable.eskimo,
    R.drawable.goldenretriever,
    R.drawable.husky,
    R.drawable.saluki,
    R.drawable.samoyed,
    R.drawable.shiba)
class SelectActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        var language = Locale.getDefault().getLanguage()
        val textViewTheme = findViewById<TextView>(R.id.textView)
        val txtHint = findViewById<TextView>(R.id.textViewHint)

        textViewTheme.text = resources.getString(R.string.app_theme)
        txtHint.text = resources.getString(R.string.hint)
        var names = resources.getStringArray(R.array.breeds);
        var descriptions = resources.getStringArray(R.array.descriptions);
        if(language == "fr")
        {
            textViewTheme.text = resources.getString(R.string.app_theme_fr)
            txtHint.text = resources.getString(R.string.hint_fr)
            names = resources.getStringArray(R.array.breeds_fr)
            descriptions = resources.getStringArray(R.array.descriptions_fr);
            supportActionBar!!.title = resources.getString(R.string.app_name_fr)
        }
        var items: ArrayList<ImageObject> = ArrayList()
        for (i in ids.indices) {
            var item = ImageObject(ids[i], names[i], descriptions[i])
            items.add(item);
        }

        val recyclerView = findViewById<RecyclerView>(R.id.recyclerView)
        val textView = findViewById<TextView>(R.id.textView)

        recyclerView.layoutManager = GridLayoutManager(this, 3)

        val onClickListener = View.OnClickListener {
            val index = recyclerView.getChildAdapterPosition(it)
            val selectedImage = items[index];

        }

        recyclerView.adapter = ImageAdapter(items, onClickListener)
    }
}