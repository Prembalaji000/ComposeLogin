package com.example.composeprac

import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Lock
import androidx.compose.material.icons.filled.Person
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.paint
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.composeprac.ui.theme.ComposePracTheme
import com.example.composeprac.ui.theme.bluejc
import com.example.composeprac.ui.theme.redjc

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            ComposePracTheme {
                Box (
                    modifier = Modifier
                        .fillMaxSize()
                        .paint(
                            painterResource(id = R.drawable.backgroundjc),
                            contentScale = ContentScale.FillBounds
                        )
                ){
                    val navController = rememberNavController()
                    NavGraph(navController)
                }
            }
        }
    }
}
@Composable
fun LoginScreen(onLoginSuccess: () -> Unit){
    var username by remember { mutableStateOf("") }
    var password by remember { mutableStateOf("") }
    val context = LocalContext.current.applicationContext
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(horizontal = 26.dp, vertical = 140.dp)
            .background(redjc)
        , horizontalAlignment = Alignment.CenterHorizontally, verticalArrangement = Arrangement.Center
    ) {
        OutlinedTextField(
            value = username, onValueChange = { username = it },
            label = { Text("Username") },
            shape = RoundedCornerShape(20.dp),
            colors = TextFieldDefaults.colors(
                focusedLeadingIconColor = redjc,
                unfocusedLeadingIconColor = redjc,
                focusedLabelColor = redjc,
                unfocusedLabelColor = redjc,
                focusedContainerColor = Color.White,
                unfocusedContainerColor = Color.White,
                focusedIndicatorColor = redjc,
                unfocusedIndicatorColor = redjc,
                unfocusedPlaceholderColor = redjc
            ), leadingIcon = {
                Icon(imageVector = Icons.Default.Person, contentDescription = "username")
            }, modifier = Modifier
                .fillMaxWidth()
                .padding(start = 20.dp, end = 20.dp)
                .padding(bottom = 10.dp)
        )
        OutlinedTextField(
            value = password, onValueChange = { password = it },
            label = { Text(text = "Password") },
            shape = RoundedCornerShape(20.dp),
            colors = TextFieldDefaults.colors(
                focusedIndicatorColor = redjc,
                unfocusedIndicatorColor = redjc,
                focusedContainerColor = Color.White,
                unfocusedContainerColor = Color.White,
                focusedLabelColor = redjc,
                unfocusedLabelColor = redjc,
                focusedLeadingIconColor = redjc,
                unfocusedLeadingIconColor = redjc,
                unfocusedPlaceholderColor = redjc
            ), leadingIcon = {
                Icon(imageVector = Icons.Default.Lock, contentDescription = "password"
                )
            }, modifier = Modifier
                .fillMaxWidth()
                .padding(start = 20.dp, end = 20.dp)
                .padding(bottom = 10.dp)
        )
        Button(onClick = {
            if (authenticate(username, password)){
                onLoginSuccess()
                Toast.makeText(context,"Login Successfully",Toast.LENGTH_LONG).show()
            } else {
                Toast.makeText(context,"username or password are invalided enter validate username & password",Toast.LENGTH_LONG).show()
            }
        }, colors = ButtonDefaults.buttonColors(bluejc)
            , contentPadding = PaddingValues(start = 60.dp,top = 8.dp, end = 60.dp, bottom = 8.dp)
            , modifier = Modifier.padding(18.dp)
            ) {
            Text(text = "Login", fontSize = 20.sp)
        }
    }
}
private fun authenticate(username: String, password: String): Boolean{
    val validusername = "user"
    val validuserpassword = "user123"
    val adminusername = "admin"
    val adminpassword = "admin123"
    val studentusername = "student"
    val studentpassword = "student123"
    val staffusername = "staff"
    val staffpassword = "staff123"
    return username == validusername && password == validuserpassword ||
            username == staffusername && password == staffpassword ||
            username == studentusername && password == studentpassword ||
            username == adminusername && password == adminpassword
}

@Composable
fun NavGraph(navController: NavHostController){
    NavHost(navController = navController, startDestination = "login") {
        composable("login"){
            LoginScreen(onLoginSuccess = {navController.navigate("Home"){
                popUpTo(0)
                }
            })
        }
        composable("Home"){
            MyHomeScreen()
        }
    }
}
@Preview
@Composable
fun ComposePracticeLoginScreenPreview(){
    ComposePracTheme {
        LoginScreen(onLoginSuccess = {})
    }
}

