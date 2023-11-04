package com.wahyouwebid.valorantapp.features

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material.Scaffold
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.wahyouwebid.valorantapp.common.navigation.BottomNavigationBar
import com.wahyouwebid.valorantapp.common.navigation.NavGraph
import com.wahyouwebid.valorantapp.common.navigation.Screen
import com.wahyouwebid.valorantapp.common.theme.ValoWhite
import com.wahyouwebid.valorantapp.common.theme.ValorantComposeTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            ValorantComposeTheme {

                val bottomBarState = rememberSaveable { (mutableStateOf(false)) }

                val navController = rememberNavController()

                val navBackStackEntry by navController.currentBackStackEntryAsState()

                when (navBackStackEntry?.destination?.route) {
                    Screen.Splash.route -> bottomBarState.value = false
                    else -> bottomBarState.value = true
                }

                Scaffold(
                    backgroundColor = ValoWhite,
                    bottomBar = { BottomNavigationBar(navController, bottomBarState) }
                ) {
                    NavGraph(navController = navController, it)
                }
            }
        }
    }
}