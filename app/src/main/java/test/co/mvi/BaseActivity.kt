package test.co.mvi

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.viewbinding.ViewBinding

abstract class BaseActivity<VB : ViewBinding> : AppCompatActivity() {

    protected lateinit var binding: VB

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = getViewBinding()
        setContentView(binding.root)

        viewInit()
        onClick()
        listener()
    }

    abstract fun getViewBinding(): VB

    open fun viewInit(){

    }

    open fun onClick(){

    }

    open fun listener(){

    }
}