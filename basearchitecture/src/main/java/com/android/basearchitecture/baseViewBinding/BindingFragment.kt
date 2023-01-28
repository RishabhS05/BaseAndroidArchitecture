//package com.android.basearchitecture.generic
//
//import android.os.Bundle
//import android.view.LayoutInflater
//import android.view.View
//import android.view.ViewGroup
//import androidx.fragment.app.Fragment
//import androidx.viewbinding.ViewBinding
//import com.architecture.framework.extensions.getBinding
//
//open class BindingFragment<VB : ViewBinding> : Fragment() {
//    private var _binding: VB? = null
//    val binding: VB
//        get() = _binding
//            ?: throw RuntimeException("Should only use binding after onCreateView and before onDestroyView")
//
//    protected fun requireBinding(): VB = requireNotNull(_binding)
//    override fun onCreateView(
//        inflater: LayoutInflater,
//        container: ViewGroup?,
//        savedInstanceState: Bundle?
//    ): View? {
//        _binding = getBinding(inflater, container)
//        return binding.root
//    }
//
//}