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

public lateinit var selectionFragment: SelectionFragment
public lateinit var displayFragment: DisplayFragment
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

        var names = resources.getStringArray(R.array.breeds);
        var descriptions = resources.getStringArray(R.array.descriptions);
        var items: ArrayList<ImageObject> = ArrayList()
        for (i in ids.indices) {
            var item = ImageObject(ids[i], names[i], descriptions[i])
            items.add(item);
        }
        selectionFragment = SelectionFragment.newInstance(items)
        displayFragment = DisplayFragment()
        supportFragmentManager.beginTransaction()
            .add(R.id.container1, selectionFragment)
            .add(R.id.container2,displayFragment)
            .commit()

    }
    override fun onRestoreInstanceState(savedInstanceState: Bundle) {
        super.onRestoreInstanceState(savedInstanceState)
    }
    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
    }
}