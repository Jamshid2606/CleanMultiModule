package com.jama.cleanwithmodule.presentation

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.activity.viewModels
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.lifecycleScope
import com.jama.cleanwithmodule.App
import com.jama.cleanwithmodule.R
import com.jama.cleanwithmodule.vm.UserResource
import com.jama.cleanwithmodule.vm.UserViewModel
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch
import javax.inject.Inject

class MainActivity : AppCompatActivity() {
    @Inject
    lateinit var factory: ViewModelProvider.Factory

    private val viewModel:UserViewModel by viewModels {factory}
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        App.applicationComponent.inject(this)
        lifecycleScope.launch {
            viewModel.getUsersFlow()
                .collect{
                    when(it){
                        is UserResource.Success->{
                            for (i in 0 until (it.list?.size ?: 1)){
                                Log.d("MAINACTIVITY","${it.list?.get(i)?.email}")
                            }

                        }
                        is UserResource.Error -> {}
                        is UserResource.Loading -> {}
                    }
                }
        }


    }
}