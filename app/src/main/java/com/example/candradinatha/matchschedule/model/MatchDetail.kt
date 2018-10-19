package com.example.candradinatha.matchschedule.model

import com.google.gson.annotations.SerializedName

class MatchDetail(
        @SerializedName("idEvent")
        var eventId: String? = null,

        @SerializedName("strDate")
        var dateEvent: String? = null,

        @SerializedName("strHomeTeam")
        var homeTeam: String? = null,

        @SerializedName("strAwayTeam")
        var awayTeam: String? = null,

        @SerializedName("intHomeScore")
        var homeScore: String? = null,

        @SerializedName("intAwayScore")
        var awayScore: String? = null,

        @SerializedName("strHomeGoalDetails")
        var homeGoalDetail: String? = null,

        @SerializedName("strAwayGoalDetails")
        var awayGoalDetail: String? = null,

        @SerializedName("intHomeShots")
        var homeShot: String? = null,

        @SerializedName("intAwayShots")
        var awayShot: String? = null,

        @SerializedName("strHomeLineupGoalkeeper")
        var homeKeeper: String? = null,

        @SerializedName("strHomeLineupDefense")
        var homeDefense: String? = null,

        @SerializedName("strHomeLineupMidfield")
        var homeMidfield: String? = null,

        @SerializedName("strHomeLineupForward")
        var homeForward: String? = null,

        @SerializedName("strHomeLineupSubstitutes")
        var homeSubstitute: String? = null,

        @SerializedName("strAwayLineupGoalkeeper")
        var awayKeeper: String? = null,

        @SerializedName("strAwayLineupDefense")
        var awayDefense: String? = null,

        @SerializedName("strAwayLineupMidfield")
        var awayMidfield: String? = null,

        @SerializedName("strAwayLineupForward")
        var awayForward: String? = null,

        @SerializedName("strAwayLineupSubstitutes")
        var awaySubstitute: String? = null
)