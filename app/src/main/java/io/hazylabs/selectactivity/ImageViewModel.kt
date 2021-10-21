package io.hazylabs.selectactivity

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

open class ImageViewModel: ViewModel()
{
    val description: MutableLiveData<String> by lazy{
        MutableLiveData<String>()
    }
    fun description(item:String){
        description.value=item
    }
    val image: MutableLiveData<Int> by lazy{
        MutableLiveData<Int>()
    }
    fun image(item:Int){
        image.value=item
    }
}