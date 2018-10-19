package com.example.candradinatha.matchschedule.view.main


import android.content.Intent
import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v4.widget.SwipeRefreshLayout
import android.support.v7.widget.LinearLayoutManager
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ProgressBar
import com.example.candradinatha.matchschedule.R
import com.example.candradinatha.matchschedule.adapter.MatchAdapter
import com.example.candradinatha.matchschedule.api.ApiRepository
import com.example.candradinatha.matchschedule.invisible
import com.example.candradinatha.matchschedule.model.Match
import com.example.candradinatha.matchschedule.view.detail.DetailActivity
import com.example.candradinatha.matchschedule.presenter.MainPresenter
import com.example.candradinatha.matchschedule.visible
import com.google.gson.Gson
import kotlinx.android.synthetic.main.fragment_second.view.*
import org.jetbrains.anko.support.v4.onRefresh


class SecondFragment : Fragment(), MainView {

    private var matches: MutableList<Match> = mutableListOf()
    private lateinit var presenter: MainPresenter
    private lateinit var adapter: MatchAdapter
    private lateinit var progressBar: ProgressBar
    private lateinit var swipeRefresh: SwipeRefreshLayout

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        val view =  inflater.inflate(R.layout.fragment_second, container, false)

        val recyclerView = view.rv_second_fragment
        recyclerView.layoutManager = LinearLayoutManager(context)
        adapter = MatchAdapter(matches, {
            getDetai("${it.eventId}", "${it.idHomeTeam}", "${it.idAwayTeam}")
        })
        recyclerView.adapter = adapter

        swipeRefresh = view.swipe_refresh_second
        progressBar = view.progress_bar_second

        swipeRefresh.onRefresh {
            presenter.getNextMatchList("4328")
        }

        showLoading()

        val apiRequest = ApiRepository()
        val gson = Gson()
        presenter = MainPresenter(this, apiRequest, gson)
        presenter.getNextMatchList("4328")

        return view
    }

    override fun showLoading() {
        progressBar.visible()
    }

    override fun hideLoading() {
        progressBar.invisible()
    }

    override fun showMatchList(data: List<Match>) {
        swipeRefresh.isRefreshing = false
        matches.clear()
        matches.addAll(data)
        adapter.notifyDataSetChanged()
        hideLoading()
    }

    private fun getDetai(idEvent: String, idHome: String, idAway:String) {
        val intent = Intent(context, DetailActivity::class.java)
        intent.putExtra("id", idEvent)
        intent.putExtra("idHomeTeam", idHome)
        intent.putExtra("idAwayTeam", idAway)
        startActivity(intent)
    }
}
