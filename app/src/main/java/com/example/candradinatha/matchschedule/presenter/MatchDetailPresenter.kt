package com.example.candradinatha.matchschedule.presenter

import com.example.candradinatha.matchschedule.api.ApiRepository
import com.example.candradinatha.matchschedule.api.TheSportDBApi
import com.example.candradinatha.matchschedule.model.MatchDetailResponse
import com.example.candradinatha.matchschedule.model.TeamBadgeResponse
import com.example.candradinatha.matchschedule.view.detail.MatchDetailView
import com.google.gson.Gson
import org.jetbrains.anko.doAsync
import org.jetbrains.anko.uiThread

class MatchDetailPresenter(private val matchDetailView: MatchDetailView,
                           private val apiRepository: ApiRepository,
                           private val gson: Gson) {
    fun getMatchDetail(eventId: String?){
        matchDetailView.showLoading()

        doAsync {
            val data = gson.fromJson(apiRepository
                    .doRequest(TheSportDBApi.getEventDetail(eventId)),
                    MatchDetailResponse::class.java)

            uiThread {
                matchDetailView.hideLoading()
                matchDetailView.showMatchList(data.events)
            }
        }
    }

    fun getHomeTeamBadge(teamId: String?) {
        matchDetailView.showLoading()

        doAsync {
            val data = gson.fromJson(apiRepository
                    .doRequest(TheSportDBApi.getTeamBadge(teamId)),
                    TeamBadgeResponse::class.java)

            uiThread {
                matchDetailView.hideLoading()
                matchDetailView.showTeamBadge(data.teams)
            }
        }
    }

    fun getAwayTeamBadge(teamId: String?) {
        doAsync {
            val data = gson.fromJson(apiRepository
                    .doRequest(TheSportDBApi.getTeamBadge(teamId)),
                    TeamBadgeResponse::class.java)

            uiThread {
                matchDetailView.hideLoading()
                matchDetailView.showAwayBadge(data.teams)
            }
        }
    }
}