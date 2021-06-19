package dev.ronnie.apidemo.api

import dev.ronnie.apidemo.models.PlayersResponse
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiService {
    @GET("players")
    suspend fun getPlayers(
        @Query("page") page: Int,
        @Query("per_page") perPage: Int,
    ): PlayersResponse
}