package dev.ronnie.apidemo.data

import dev.ronnie.apidemo.api.ApiService
import javax.inject.Inject

class Repository @Inject constructor(private val apiService: ApiService) : BaseRepository() {

    suspend fun getPlayers() = safeApiCall {
        apiService.getPlayers(1, 50)
    }
}