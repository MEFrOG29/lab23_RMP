package com.example.lab23

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.DarkMode
import androidx.compose.material.icons.filled.LightMode
import androidx.compose.material.icons.filled.List
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material.icons.filled.Palette
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.ShoppingCart
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.lab23.screens.CartScreen
import com.example.lab23.screens.CatalogScreen
import com.example.lab23.screens.ProfileScreen
import com.example.lab23.ui.theme.AltDarkColorScheme
import com.example.lab23.ui.theme.AltLightColorScheme
import com.example.lab23.ui.theme.DarkColorScheme
import com.example.lab23.ui.theme.Lab23Theme
import com.example.lab23.ui.theme.LightColorScheme
import com.example.lab23.ui.theme.Typography

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            var isDarkTheme by remember { mutableStateOf(false) }
            var colorStyle by remember { mutableStateOf(1) }
            Lab23Theme(darkTheme = isDarkTheme, colorStyle = colorStyle) {
                Surface(color = MaterialTheme.colorScheme.background) {
                    MainScreen(
                        isDarkTheme = isDarkTheme,
                        onThemeChange = {isDarkTheme = !isDarkTheme},
                        onStyleChange = { colorStyle = if (colorStyle == 1) 2 else 1 }
                    )
                }

            }
        }
    }
}

enum class AppScreen{
    Catalog,
    Cart,
    Profile
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MainScreen(
    isDarkTheme: Boolean,
    onThemeChange: () -> Unit,
    onStyleChange: () -> Unit
) {
    var currentScreen by remember { mutableStateOf(AppScreen.Catalog) }

    Scaffold(
        topBar = {
            TopAppBar(
                title = {
                    Text(
                        when (currentScreen) {
                            AppScreen.Catalog -> "Каталог"
                            AppScreen.Cart -> "Корзина"
                            AppScreen.Profile -> "Профиль"
                        }
                    )
                },
                navigationIcon = {
                    IconButton(onClick = {}) {
                        Icon(Icons.Default.Menu, "Меню")
                    }
                },
                actions = {
                    IconButton(onClick = onThemeChange) {
                        Icon(
                            imageVector = if (isDarkTheme) Icons.Filled.LightMode else Icons.Default.DarkMode,
                            contentDescription = "Сменить тему"
                        )
                    }
                    IconButton(onClick = onStyleChange) {
                        Icon(Icons.Default.Palette, "Сменить палитру")
                    }
                    IconButton(onClick = { currentScreen = AppScreen.Catalog }) {
                        Icon(Icons.Default.List, "Каталог")
                    }
                    IconButton(onClick = { currentScreen = AppScreen.Cart }) {
                        Icon(Icons.Default.ShoppingCart, "Корзина")
                    }
                    IconButton(onClick = { currentScreen = AppScreen.Profile }) {
                        Icon(Icons.Default.Person, "Профиль")
                    }
                }
            )
        }
    ) { innerPadding ->
        Box(Modifier.padding(innerPadding)) {
            when (currentScreen) {
                AppScreen.Catalog -> CatalogScreen(
                    onNavigateToCart = { currentScreen = AppScreen.Cart }
                )
                AppScreen.Cart -> CartScreen()
                AppScreen.Profile -> ProfileScreen()
            }
        }
    }
}