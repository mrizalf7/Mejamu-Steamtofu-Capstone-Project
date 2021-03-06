package com.steamtofu.mejamu.ui.main

import android.app.Application
import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.paging.LivePagedListBuilder
import androidx.paging.PagedList
import com.steamtofu.mejamu.database.Classes
import com.steamtofu.mejamu.repository.ClassesRepository

class MainViewModel(application: Application) : ViewModel() {
    private val mClassesRepository: ClassesRepository = ClassesRepository(application)
    fun getAllClasses(): LiveData<PagedList<Classes>> = LivePagedListBuilder(mClassesRepository.getAllClasses(), 20).build()
}
