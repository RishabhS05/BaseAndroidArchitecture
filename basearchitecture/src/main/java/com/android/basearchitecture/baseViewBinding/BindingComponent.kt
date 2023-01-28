//package com.android.basearchitecture.generic
//
//import android.content.Context
//import android.util.AttributeSet
//import android.view.LayoutInflater
//import androidx.constraintlayout.widget.ConstraintLayout
//import androidx.viewbinding.ViewBinding
//import com.architecture.framework.extensions.getBinding
//
//val Context.inflater get() = LayoutInflater.from(this)
//
//class BindingComponent<VB : ViewBinding> @JvmOverloads constructor(
//    context: Context,
//    attrs: AttributeSet? = null
//) : ConstraintLayout(context, attrs) {
//    lateinit var binding: VB
//
//    init {
//        initBinding()
//    }
//
//    private fun initBinding() {
//        if (::binding.isInitialized.not()) {
//            binding = getBinding(context.inflater, container = this)
//        }
//    }
//}