//package com.android.basearchitecture.generic
//
//import android.os.Bundle
//import androidx.appcompat.app.AppCompatActivity
//import androidx.viewbinding.ViewBinding
//import com.architecture.framework.extensions.getBinding
//
//open class BindingActivity<VB: ViewBinding> : AppCompatActivity(){
//
//    lateinit var binding: VB
//    override fun onCreate(savedInstanceState: Bundle?) {
//        super.onCreate(savedInstanceState)
//        if (::binding.isInitialized.not()) {
//            binding = getBinding()
//            setContentView(binding.root)
//        }
//    }
//}