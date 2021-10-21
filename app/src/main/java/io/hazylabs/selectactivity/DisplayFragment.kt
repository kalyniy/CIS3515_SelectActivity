package io.hazylabs.selectactivity

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider

class DisplayFragment : Fragment() {

    private lateinit var layout: View
    private lateinit var viewModel: ImageViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View?
    {
        layout =inflater.inflate(R.layout.fragment_display, container, false)
        viewModel = ViewModelProvider(requireActivity()).get(ImageViewModel::class.java)
        val textView = layout.findViewById<TextView>(R.id.txtDescription)
        val imageView = layout.findViewById<ImageView>(R.id.imageView)
        viewModel.description.observe(viewLifecycleOwner, object : Observer<Any> {
            override fun onChanged(o: Any?) {
                textView.text = o!!.toString()
            }
        })
        viewModel.image.observe(viewLifecycleOwner, object : Observer<Any> {
            override fun onChanged(o: Any?) {
                imageView.setImageResource(o!! as Int)
            }
        })
        return layout
    }
}