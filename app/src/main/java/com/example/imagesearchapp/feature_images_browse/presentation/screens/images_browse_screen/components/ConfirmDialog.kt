package com.example.imagesearchapp.feature_images_browse.presentation.screens.images_browse_screen.components

import androidx.compose.material3.AlertDialog
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.platform.LocalContext

@Composable
fun ConfirmDialog(
    onDialogConfirmed: () -> Unit,
    onDialogDismissed: () -> Unit
){
    val context = LocalContext.current
    val openDialog = remember {
        mutableStateOf(true)
    }

    
    if(openDialog.value){
        AlertDialog(
            onDismissRequest = onDialogDismissed,
            title = { Text(text = "Display Image Details?")},
            confirmButton = {
                Button(onClick = onDialogConfirmed) {
                    Text(text = "OK")
                }},
            dismissButton = {
                Button(onClick = onDialogDismissed) {
                    Text(text = "Cancel")
                }}
        )
    }
}