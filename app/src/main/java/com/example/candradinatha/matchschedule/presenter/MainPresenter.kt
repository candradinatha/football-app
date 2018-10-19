package com.example.candradinatha.matchschedule.presenter

import com.example.candradinatha.matchschedule.api.ApiRepository
import com.example.candradinatha.matchschedule.api.TheSportDBApi
import com.example.candradinatha.matchschedule.model.MatchResponse
import com.example.candradinatha.matchschedule.view.main.MainView
import com.google.gson.Gson
import org.jetbrains.anko.doAsync
import org.jetbrains.anko.uiThread

class MainPresenter(private val matchView: MainView,
                    private val apiRepository: ApiRepository,
                    private val gson: Gson) {

    fun getLastMatchList(leagueId: String?){
        matchView.showLoading()

        doAsync {
            val data = gson.fromJson(apiRepository
                    .doRequest(TheSportDBApi.getLastMatch(leagueId)),
                    MatchResponse::class.java)

            uiThread {
                matchView.hideLoading()
                matchView.showMatchList(data.events)
            }
        }


    }

    fun getNextMatchList(leagueId: String?){
        matchView.showLoading()

        doAsync {
            val data = gson.fromJson(apiRepository
                    .doRequest(TheSportDBApi.getNextMatch(leagueId)),
                    MatchResponse::class.java)

            uiThread {
                matchView.hideLoading()
                matchView.showMatchList(data.events)
            }
        }
    }
}