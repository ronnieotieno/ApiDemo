package dev.ronnie.apidemo.viewmodels

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import dev.ronnie.apidemo.Event
import dev.ronnie.apidemo.NetworkResource
import dev.ronnie.apidemo.data.Repository
import dev.ronnie.apidemo.models.PlayersResponse
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(private val repository: Repository) : ViewModel() {

    private val _reponseLivedata: MutableLiveData<Event<NetworkResource<PlayersResponse>>> =
        MutableLiveData()
    val reponseLivedata get() = _reponseLivedata

    fun getPlayers() = viewModelScope.launch {
        _reponseLivedata.value = Event(NetworkResource.Loading)
        _reponseLivedata.value = Event(repository.getPlayers())
    }


}