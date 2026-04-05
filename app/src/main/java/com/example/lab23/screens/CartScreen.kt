package com.example.lab23.screens

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.material3.Checkbox
import androidx.compose.material3.CheckboxDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment

@Composable
fun CartScreen() {
    Column{
        Text(
            "Ваша корзина",
            style = MaterialTheme.typography.headlineMedium,
            color = MaterialTheme.colorScheme.primary)
        Row(verticalAlignment = Alignment.CenterVertically) {
            Checkbox(
                true,
                {},
                colors = CheckboxDefaults.colors(
                    checkedColor = MaterialTheme.colorScheme.secondary
                ))
            Text(
                "Выбрать все товары",
                color = MaterialTheme.colorScheme.onSurfaceVariant)
        }
    }
}