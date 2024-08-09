package com.example.idzassignment.base

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.viewbinding.ViewBinding

abstract class BaseActivity<VB: ViewBinding>: AppCompatActivity() {
    protected lateinit var binding: VB

    abstract fun getActivityBinding(): VB
    abstract fun activityStarted(savedInstanceState: Bundle?)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = getActivityBinding()
        enableEdgeToEdge()
        setContentView(binding.root)
        activityStarted(savedInstanceState)
    }
}