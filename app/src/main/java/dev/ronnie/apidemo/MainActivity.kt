package dev.ronnie.apidemo

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.activity.viewModels
import dagger.hilt.android.AndroidEntryPoint
import dev.ronnie.apidemo.viewmodels.MainViewModel
import kotlinx.coroutines.Job


@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    private val viewModel: MainViewModel by viewModels()


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        viewModel.getPlayers()

        viewModel.reponseLivedata.observe(this, { event ->
            event.getContentIfNotHandled()?.let { resource ->

                when (resource) {
                    is NetworkResource.Loading -> {
                        Log.d("ResourceResult", "Is Loading")
                    }
                    is NetworkResource.Success -> {
                        Log.d("ResourceResult", "Data ${resource.value.players[0]}")
                        Toast.makeText(this, resource.value.toString(), Toast.LENGTH_LONG).show()
                    }
                    is NetworkResource.Failure -> {
                        Log.d("ResourceResult", "Failed ${resource.errorCode}")
                    }
                }

            }

        })


    }
}