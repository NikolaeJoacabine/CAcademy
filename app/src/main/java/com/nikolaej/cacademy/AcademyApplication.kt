package com.nikolaej.cacademy

import android.app.Application
import com.nikolaej.cacademy.dataSQL.AppContainer
import com.nikolaej.cacademy.dataSQL.AppDataContainer

class AcademyApplication : Application() {

    lateinit var container: AppContainer

    override fun onCreate() {
        super.onCreate()
        container = AppDataContainer(this)
    }
}