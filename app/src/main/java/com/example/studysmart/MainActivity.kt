package com.example.studysmart

import android.content.ComponentName
import android.content.Intent
import android.content.ServiceConnection
import android.os.Bundle
import android.os.IBinder
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.compose.runtime.getValue
import androidx.compose.ui.graphics.toArgb
import androidx.core.app.ActivityCompat
import com.example.studysmart.destinations.SessionScreenRouteDestination
import com.example.studysmart.domain.model.Subject
import com.example.studysmart.domain.model.Session
import com.example.studysmart.domain.model.Task
import com.example.studysmart.presentation.session.StudySessionTimerService
import com.example.studysmart.ui.theme.StudySmartTheme
import com.ramcosta.composedestinations.DestinationsNavHost
import com.ramcosta.composedestinations.navigation.dependency
import dagger.hilt.android.AndroidEntryPoint
import kotlin.concurrent.timer


@AndroidEntryPoint
class MainActivity : ComponentActivity() {

    private var isBound by mutableStateOf(false)
    private lateinit var timerService: StudySessionTimerService

    private val connection = object : ServiceConnection {
        override fun onServiceConnected(name: ComponentName?, service: IBinder?) {
            val binder = service as StudySessionTimerService.StudySessionTimerBinder
            timerService = binder.getService()
            isBound = true
        }

        override fun onServiceDisconnected(p0: ComponentName?) {
            isBound = false
        }
    }

    override fun onStart() {
        super.onStart()
        val serviceIntent = Intent(this, StudySessionTimerService::class.java)
        bindService(serviceIntent, connection, BIND_AUTO_CREATE)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        enableEdgeToEdge() // Enables edge-to-edge display

        setContent {
            if (isBound) {
                StudySmartTheme {
                    //DestinationsNavHost(navGraph = NavGraphs.root)
                    DestinationsNavHost(navGraph = NavGraphs.root,
                        dependenciesContainerBuilder = {
                            dependency(SessionScreenRouteDestination){
                                timerService
                            }
                        }
                    )
                }
            }
        }

        requestPermission()
    }

    private fun requestPermission(){
        ActivityCompat.requestPermissions(
            this,
            arrayOf(android.Manifest.permission.POST_NOTIFICATIONS),
            0
        )
    }

    override fun onStop() {
        super.onStop()
        if (isBound) {
            unbindService(connection)
            isBound = false
        }
    }
}


