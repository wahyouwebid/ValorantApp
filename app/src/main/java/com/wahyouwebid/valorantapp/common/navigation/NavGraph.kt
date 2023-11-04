package com.wahyouwebid.valorantapp.common.navigation

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.wahyouwebid.valorantapp.features.agent.presentation.agentdetail.AgentDetailScreen
import com.wahyouwebid.valorantapp.features.agent.presentation.agents.AgentsScreen
import com.wahyouwebid.valorantapp.features.competitivetiers.presentation.CompetitiveTiersScreen
import com.wahyouwebid.valorantapp.features.map.presentation.mapdetail.MapDetailScreen
import com.wahyouwebid.valorantapp.features.map.presentation.maps.MapsScreen
import com.wahyouwebid.valorantapp.features.splash.SplashScreen
import com.wahyouwebid.valorantapp.features.weapon.presentation.weapondetail.WeaponDetailScreen
import com.wahyouwebid.valorantapp.features.weapon.presentation.weapons.WeaponsScreen

@Composable
fun NavGraph(navController: NavHostController, paddingValues: PaddingValues) {

    NavHost(
        navController = navController,
        startDestination = Screen.Splash.route,
        modifier = Modifier.padding(paddingValues = paddingValues)
    ) {

        composable(route = Screen.Splash.route) {
            SplashScreen(
                navigateToAgents = {
                    navController.navigate(Screen.Maps.route) {
                        popUpTo(Screen.Splash.route) {
                            inclusive = true
                        }
                    }
                }
            )
        }

        composable(route = Screen.Maps.route) {
            MapsScreen(
                navigateToMapDetail = {
                    navController.navigate("${Screen.MapDetail.route}/$it")
                }
            )
        }

        composable(route = "${Screen.MapDetail.route}/{mapUuid}") {
            MapDetailScreen()
        }

        composable(route = Screen.Agents.route) {
            AgentsScreen(
                navigateToAgentDetail = {
                    navController.navigate("${Screen.AgentDetail.route}/$it")
                }
            )
        }

        composable(route = "${Screen.AgentDetail.route}/{agentUuid}") {
            AgentDetailScreen()
        }

        composable(route = Screen.Weapons.route) {
            WeaponsScreen(
                navigateToWeaponDetail = {
                    navController.navigate("${Screen.WeaponDetail.route}/$it")
                }
            )
        }

        composable(route = "${Screen.WeaponDetail.route}/{weaponUuid}") {
            WeaponDetailScreen()
        }

        composable(route = Screen.CompetitiveTiers.route) {
            CompetitiveTiersScreen()
        }
    }
}