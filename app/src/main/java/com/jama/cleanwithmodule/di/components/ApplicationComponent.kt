package com.jama.cleanwithmodule.di.components

import com.jama.cleanwithmodule.App
import com.jama.cleanwithmodule.presentation.MainActivity
import com.jama.cleanwithmodule.di.module.ApplicationModule
import com.jama.cleanwithmodule.di.module.DataModule
import com.jama.cleanwithmodule.di.module.ViewModelModule
import dagger.BindsInstance
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(modules = [ApplicationModule::class,DataModule::class,ViewModelModule::class])
interface ApplicationComponent {
    @Component.Factory
    interface Factrory{
        fun create(@BindsInstance app:App) : ApplicationComponent
    }
    fun inject(app: App)
    fun inject(mainActivity: MainActivity)

}