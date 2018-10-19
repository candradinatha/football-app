package com.example.candradinatha.matchschedule.model

import com.google.gson.annotations.SerializedName

data class Match(
        @SerializedName("idEvent")
        var eventId: String? = null,

        @SerializedName("idHomeTeam")
        var idHomeTeam: String? = null,

        @SerializedName("idAwayTeam")
        var idAwayTeam: String? = null,

        @SerializedName("idLeague")
        var leagueId: String? = null,

        @SerializedName("dateEvent")
        var matchDate: String? = null,

        @SerializedName("strHomeTeam")
        var homeTeam: String? = null,

        @SerializedName("strAwayTeam")
        var awayTeam: String? = null,

        @SerializedName("intHomeScore")
        var homeScore: String? = null,

        @SerializedName("intAwayScore")
        var awayScore: String? = null
)