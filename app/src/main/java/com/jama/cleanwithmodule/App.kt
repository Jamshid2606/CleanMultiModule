package com.jama.cleanwithmodule

import android.app.Application
import com.jama.cleanwithmodule.di.components.ApplicationComponent
import com.jama.cleanwithmodule.di.components.DaggerApplicationComponent

class App:Application() {

    companion object {
        lateinit var applicationComponent: ApplicationComponent
    }

    override fun onCreate() {
        super.onCreate()
        applicationComponent = DaggerApplicationComponent.factory()
            .create(this)
        applicationComponent.inject(this)


    }
}