package com.example.candradinatha.matchschedule.view.detail

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v4.widget.SwipeRefreshLayout
import android.view.View
import android.widget.ProgressBar
import com.example.candradinatha.matchschedule.R
import com.example.candradinatha.matchschedule.api.ApiRepository
import com.example.candradinatha.matchschedule.gone
import com.example.candradinatha.matchschedule.model.MatchDetail
import com.example.candradinatha.matchschedule.model.TeamBadge
import com.example.candradinatha.matchschedule.presenter.MatchDetailPresenter
import com.example.candradinatha.matchschedule.visible
import com.google.gson.Gson
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.activity_detail.*
import org.jetbrains.anko.support.v4.onRefresh

class DetailActivity : AppCompatActivity(), MatchDetailView {
    override fun showAwayBadge(data: List<TeamBadge>) {
        Picasso.get().load(data[0].teamBadge).into(img_away_detail)
        img_away_detail.visible()
    }

    override fun showTeamBadge(data: List<TeamBadge>) {
        Picasso.get().load(data[0].teamBadge).into(img_home_detail)
        img_home_detail.visible()
    }

    private val matchDetail: MutableList<MatchDetail> = mutableListOf()
    private  lateinit var presenter: MatchDetailPresenter
    private lateinit var progressBar: ProgressBar
    private var idEvent: String = ""
    private var idHomeTeam: String = ""
    private var idAwayTeam: String = ""

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)

        val intent = intent
        idEvent = intent.getStringExtra("id")
        idHomeTeam = intent.getStringExtra("idHomeTeam")
        idAwayTeam = intent.getStringExtra("idAwayTeam")
        progressBar = progress_bar_detail

        showLoading()
        val apiRequest = ApiRepository()
        val gson = Gson()
        presenter = MatchDetailPresenter(this, apiRequest, gson)
        presenter.getMatchDetail(idEvent)
        presenter.getHomeTeamBadge(idHomeTeam)
        presenter.getAwayTeamBadge(idAwayTeam)

    }

    override fun showLoading() {
        progressBar.visible()
    }

    override fun hideLoading() {
        progressBar.gone()
    }

    override fun showMatchList(data: List<MatchDetail>) {
        matchDetail.clear()
        matchDetail.addAll(data)

        tv_match_date_detail.text = matchDetail.get(0).dateEvent
        tv_score_home_detail.text = matchDetail.get(0).homeScore
        tv_score_away_detail.text = matchDetail.get(0).awayScore
        tv_team_home_detail.text = matchDetail.get(0).homeTeam
        tv_team_away_detail.text = matchDetail.get(0).awayTeam

        tv_home_goal_detail.text = matchDetail.get(0).homeGoalDetail
        tv_away_goal_detail.text = matchDetail.get(0).awayGoalDetail
        tv_home_shot_detail.text = matchDetail.get(0).homeShot
        tv_away_shot_detail.text = matchDetail.get(0).awayShot


        tv_home_keeper.text = matchDetail.get(0).homeKeeper
        tv_away_keeper.text = matchDetail.get(0).awayKeeper
        tv_home_deffense.text = matchDetail.get(0).homeDefense
        tv_away_deffense.text = matchDetail.get(0).awayDefense
        tv_home_mf.text = matchDetail.get(0).homeMidfield
        tv_away_mf.text = matchDetail.get(0).awayMidfield
        tv_home_fw.text = matchDetail.get(0).homeForward
        tv_away_fw.text = matchDetail.get(0).awayForward
        tv_home_sub.text = matchDetail.get(0).homeSubstitute
        tv_away_sub.text = matchDetail.get(0).awaySubstitute

        hideLoading()
    }

}
