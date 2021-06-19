package dev.ronnie.apidemo.models

import com.google.gson.annotations.SerializedName

data class PlayersResponse(
    @SerializedName("data")
    val players: List<Player>,
    val meta: Meta
)