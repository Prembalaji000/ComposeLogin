package com.example.composeprac.screensUI

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.sp
import com.example.composeprac.ui.theme.ComposePracTheme
import com.example.composeprac.ui.theme.redjc

@Composable
fun Profile(){
    Box (modifier = Modifier.fillMaxSize()) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .align(Alignment.Center),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            Text(text = "Profile", fontSize = 40.sp, fontStyle = FontStyle.Italic, color = redjc)
        }
    }
}
@Preview
@Composable
fun ProfilePreview(){
    ComposePracTheme {
        Profile()
    }
}