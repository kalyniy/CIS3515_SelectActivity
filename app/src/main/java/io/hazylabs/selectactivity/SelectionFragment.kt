package io.hazylabs.selectactivity


import android.os.Bundle
import android.widget.Toast
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.MutableLiveData
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView


private const val ARG_PARAM1 = "items"
class SelectionFragment : Fragment() {
    // TODO: Rename and change types of parameters
    private var param1: ArrayList<ImageObject>? = null
    private lateinit var recycle: RecyclerView
    private lateinit var layout: View

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            param1 = it.getSerializable(ARG_PARAM1) as ArrayList<ImageObject>?
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        layout =  inflater.inflate(R.layout.fragment_selection, container, false)
        return layout
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        recycle = layout.findViewById<RecyclerView>(R.id.recyclerView)

        recycle.layoutManager = GridLayoutManager(layout.context, 3)

        val onClickListener = View.OnClickListener {
            val index = recycle.getChildAdapterPosition(it)
            val selectedImage = param1!![index];
        }

        recycle.adapter = ImageAdapter(param1!!, onClickListener)
    }
    companion object
    {
        @JvmStatic
        fun newInstance(param1: ArrayList<ImageObject>) =
            SelectionFragment().apply {
                arguments = Bundle().apply {
                    putSerializable(ARG_PARAM1, param1)
                }
            }
    }
}