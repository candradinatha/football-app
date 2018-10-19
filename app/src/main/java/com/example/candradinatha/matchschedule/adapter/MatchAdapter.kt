package com.example.candradinatha.matchschedule.adapter

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import com.example.candradinatha.matchschedule.R
import com.example.candradinatha.matchschedule.model.Match

class MatchAdapter(private val events: List<Match>, private val listener: (Match) -> Unit)
    : RecyclerView.Adapter<MatchViewHolder>(){

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MatchViewHolder {
        return MatchViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.match_list, parent, false))
    }

    override fun onBindViewHolder(holder: MatchViewHolder, position: Int) {
        holder.bindItem(events[position],listener)
    }

    override fun getItemCount(): Int = events.size
}

class MatchViewHolder(view: View) : RecyclerView.ViewHolder(view) {

    val matchDate: TextView = view.findViewById(R.id.tv_date)
    val homeTeam: TextView = view.findViewById(R.id.tv_team_home)
    val homeScore: TextView = view.findViewById(R.id.tv_score_home)
    val awayTeam: TextView = view.findViewById(R.id.tv_team_away)
    val awaySCore: TextView = view.findViewById(R.id.tv_score_away)

    fun bindItem(events: Match, listener: (Match) -> Unit) {
        matchDate.text = events.matchDate
        homeTeam.text = events.homeTeam
        homeScore.text = events.homeScore
        awayTeam.text = events.awayTeam
        awaySCore.text = events.awayScore

        itemView.setOnClickListener { listener(events) }
    }
}