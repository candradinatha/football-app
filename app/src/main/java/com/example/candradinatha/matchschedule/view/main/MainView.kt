package com.example.candradinatha.matchschedule.view.main

import com.example.candradinatha.matchschedule.model.Match

interface MainView {
    fun showLoading()
    fun hideLoading()
    fun showMatchList(data: List<Match>)
}