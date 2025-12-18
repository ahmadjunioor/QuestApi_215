package com.example.questapi_215.uicontroller

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.questapi_215.uicontroller.route.DestinasiEntry
import com.example.questapi_215.uicontroller.route.DestinasiHome
import com.example.questapi_215.view.EntrySiswaScreen
import com.example.questapi_215.view.HomeScreen

@Composable
fun DataSiswaApp(
    navController: NavHostController = rememberNavController(),
    modifier: Modifier = Modifier
) {
    HostNavigasi(navController = navController, modifier = modifier)
}

@Composable
fun HostNavigasi(
    navController: NavHostController,
    modifier: Modifier = Modifier
) {
    NavHost(
        navController = navController,
        startDestination = DestinasiHome.route,
        modifier = modifier
    ) {
        // Rute untuk Halaman Utama
        composable(DestinasiHome.route) {
            HomeScreen(
                navigateToItemEntry = {
                    navController.navigate(DestinasiEntry.route)
                },
                // Perbaikan Error: Nama parameter harus 'navigateToItemUpdate' sesuai HomeScreen.kt
                // Dan tambahkan tanda koma setelah navigateToItemEntry
                navigateToItemUpdate = {
                    // navController.navigate("${DestinasiDetail.route}/$itemId")
                }
            )
        }

        // Rute untuk Halaman Entry Siswa
        composable(DestinasiEntry.route) {
            EntrySiswaScreen(
                navigateBack = {
                    navController.popBackStack() // Gunakan popBackStack untuk kembali dengan benar
                },
                // Perbaikan Error: Parameter 'onNavigateUp' wajib diisi sesuai HalamanEntry.jpg
                onNavigateUp = {
                    navController.navigateUp()
                }
            )
        }
    }
}