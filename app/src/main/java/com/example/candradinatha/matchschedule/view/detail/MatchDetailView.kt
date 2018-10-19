package com.example.candradinatha.matchschedule.view.detail

import com.example.candradinatha.matchschedule.model.MatchDetail
import com.example.candradinatha.matchschedule.model.TeamBadge

interface MatchDetailView {
    fun showLoading()
    fun hideLoading()
    fun showMatchList(data: List<MatchDetail>)
    fun showTeamBadge(data: List<TeamBadge>)
    fun showAwayBadge(data: List<TeamBadge>)
}