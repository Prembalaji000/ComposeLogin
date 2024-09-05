package com.example.composeprac

import android.widget.Toast
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.ExitToApp
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Notifications
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.PlayArrow
import androidx.compose.material.icons.filled.Search
import androidx.compose.material.icons.filled.Settings
import androidx.compose.material.icons.filled.Star
import androidx.compose.material.icons.filled.ThumbUp
import androidx.compose.material.icons.rounded.Menu
import androidx.compose.material3.BottomAppBar
import androidx.compose.material3.Divider
import androidx.compose.material3.DrawerValue
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.ModalBottomSheet
import androidx.compose.material3.ModalDrawerSheet
import androidx.compose.material3.ModalNavigationDrawer
import androidx.compose.material3.NavigationDrawerItem
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.material3.rememberDrawerState
import androidx.compose.material3.rememberModalBottomSheetState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.tooling.preview.Wallpapers
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.composeprac.screensUI.Home
import com.example.composeprac.screensUI.Notification
import com.example.composeprac.screensUI.Post
import com.example.composeprac.screensUI.Profile
import com.example.composeprac.screensUI.Search
import com.example.composeprac.screensUI.Setting
import com.example.composeprac.ui.theme.ComposePracTheme
import com.example.composeprac.ui.theme.redjc
import kotlinx.coroutines.launch

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MyHomeScreen() {
    val context = LocalContext.current.applicationContext
    val coroutinesScope = rememberCoroutineScope()
    val navigationController = rememberNavController()
    val sheetState = rememberModalBottomSheetState()
    val drawerState = rememberDrawerState(initialValue = DrawerValue.Closed)
    val selected = remember {
        mutableStateOf(Icons.Default.Home)
    }
    var showBottomSheet by remember {
        mutableStateOf(false)
    }
    Box(modifier = Modifier.fillMaxSize()) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .align(Alignment.Center),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            Text(text = "Home Screen", fontSize = 40.sp, fontStyle = FontStyle.Italic)
        }
    }
    ModalNavigationDrawer(
        drawerState = drawerState,
        gesturesEnabled = true,
        drawerContent = {
            ModalDrawerSheet {
                Box(
                    modifier = Modifier
                        .background(redjc)
                        .fillMaxWidth()
                        .height(150.dp)
                )
                {
                    Text(text = "")
                }
                Divider()
                NavigationDrawerItem(label = { Text(text = "Home", color = redjc) },
                    selected = false,
                    icon = {
                        Icon(
                            imageVector = Icons.Default.Home,
                            contentDescription = "Home",
                            tint = redjc
                        )
                    },
                    onClick = {
                        coroutinesScope.launch {
                            drawerState.close()
                        }
                        navigationController.navigate(Screens.Home.Screen) {
                            popUpTo(0)
                        }
                    }
                )
                NavigationDrawerItem(label = { Text(text = "Profile", color = redjc) },
                    selected = false,
                    icon = {
                        Icon(
                            imageVector = Icons.Default.Person,
                            contentDescription = "Profile",
                            tint = redjc
                        )
                    },
                    onClick = {
                        coroutinesScope.launch {
                            drawerState.close()
                        }
                        navigationController.navigate(Screens.Profile.Screen) {
                            popUpTo(0)
                        }
                    }
                )
                NavigationDrawerItem(label = { Text(text = "Settings", color = redjc) },
                    selected = false,
                    icon = {
                        Icon(
                            imageVector = Icons.Default.Settings,
                            contentDescription = "Settings",
                            tint = redjc
                        )
                    },
                    onClick = {
                        coroutinesScope.launch {
                            drawerState.close()
                        }
                        navigationController.navigate(Screens.Setting.Screen) {
                            popUpTo(0)
                        }
                    }
                )
                NavigationDrawerItem(label = { Text(text = "Logout", color = redjc) },
                    selected = false,
                    icon = {
                        Icon(
                            imageVector = Icons.Default.ExitToApp,
                            contentDescription = "Logout",
                            tint = redjc
                        )
                    },
                    onClick = {
                        coroutinesScope.launch {
                            drawerState.close()
                        }
                        Toast.makeText(context, "Logout", Toast.LENGTH_LONG).show()
                    }
                )
            }
        },
    ) {
        Scaffold(
            topBar = {
                TopAppBar(
                    title = { Text(text = "HastenOzone") },
                    colors = TopAppBarDefaults.topAppBarColors(
                        containerColor = redjc,
                        titleContentColor = Color.White,
                        navigationIconContentColor = Color.White
                    ),
                    actions = {
                        IconButton(onClick = {
                            Toast.makeText(
                                context,
                                "Person icon",
                                Toast.LENGTH_LONG
                            ).show()
                        }) {
                            Icon(
                                imageVector = Icons.Filled.Person,
                                contentDescription = "Person icon",
                                tint = Color.White
                            )
                        }
                        IconButton(onClick = {
                            Toast.makeText(
                                context,
                                "Search icon",
                                Toast.LENGTH_LONG
                            ).show()
                        }) {
                            Icon(
                                imageVector = Icons.Filled.Search,
                                contentDescription = "Search icon",
                                tint = Color.White
                            )
                        }
                        IconButton(onClick = {
                            Toast.makeText(
                                context,
                                "Settings icon",
                                Toast.LENGTH_LONG
                            ).show()
                        }) {
                            Icon(
                                imageVector = Icons.Filled.Settings,
                                contentDescription = "Settings icon",
                                tint = Color.White
                            )
                        }
                    },
                    navigationIcon = {
                        IconButton(onClick = {
                            coroutinesScope.launch {
                                drawerState.open()
                            }
                        }) {
                            Icon(
                                Icons.Rounded.Menu, contentDescription = "MenuButton"
                            )
                        }
                    },
                )
            },
            bottomBar = {
                BottomAppBar(
                    containerColor = redjc
                ) {
                    IconButton(
                        onClick = {
                            selected.value = Icons.Default.Home
                            navigationController.navigate(Screens.Home.Screen) {
                                popUpTo(0)
                            }
                        },
                        modifier = Modifier.weight(1f)
                    ) {
                        Icon(
                            Icons.Default.Home,
                            contentDescription = null,
                            modifier = Modifier.size(26.dp),
                            tint = if (selected.value == Icons.Default.Home) Color.White else Color.DarkGray
                        )
                    }
                    IconButton(
                        onClick = {
                            selected.value = Icons.Default.Search
                            navigationController.navigate(Screens.Search.Screen) {
                                popUpTo(0)
                            }
                        },
                        modifier = Modifier.weight(1f)
                    ) {
                        Icon(
                            Icons.Default.Search,
                            contentDescription = null,
                            modifier = Modifier.size(26.dp),
                            tint = if (selected.value == Icons.Default.Search) Color.White else Color.DarkGray
                        )
                    }
                    Box(
                        modifier = Modifier
                            .weight(1f)
                            .padding(16.dp),
                        contentAlignment = Alignment.Center
                    ) {
                        FloatingActionButton(onClick = { showBottomSheet = true }) {
                            Icon(Icons.Default.Add, contentDescription = null, tint = redjc)
                        }
                    }
                    IconButton(
                        onClick = {
                            selected.value = Icons.Default.Notifications
                            navigationController.navigate(Screens.Notification.Screen) {
                                popUpTo(0)
                            }
                        },
                        modifier = Modifier.weight(1f)
                    ) {
                        Icon(
                            Icons.Default.Notifications,
                            contentDescription = null,
                            modifier = Modifier.size(26.dp),
                            tint = if (selected.value == Icons.Default.Notifications) Color.White else Color.DarkGray
                        )
                    }
                    IconButton(
                        onClick = {
                            selected.value = Icons.Default.Person
                            navigationController.navigate(Screens.Profile.Screen) {
                                popUpTo(0)
                            }
                        },
                        modifier = Modifier.weight(1f)
                    ) {
                        Icon(
                            Icons.Default.Person,
                            contentDescription = null,
                            modifier = Modifier.size(26.dp),
                            tint = if (selected.value == Icons.Default.Person) Color.White else Color.DarkGray
                        )
                    }
                }
            }
        ) { paddingValues ->
            NavHost(
                navController = navigationController,
                startDestination = Screens.Home.Screen,
                modifier = Modifier.padding(paddingValues)
            ) {
                composable(Screens.Home.Screen) { Home() }
                composable(Screens.Notification.Screen) { Notification() }
                composable(Screens.Setting.Screen) { Setting() }
                composable(Screens.Profile.Screen) { Profile() }
                composable(Screens.Search.Screen) { Search() }
                composable(Screens.Post.Screen) { Post() }
            }
        }
        if (showBottomSheet) {
            ModalBottomSheet(
                onDismissRequest = { showBottomSheet = false },
                sheetState = sheetState
            )
            {
                Column(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(18.dp),
                    verticalArrangement = Arrangement.spacedBy(20.dp)
                ) {
                    BottomSheetItem(icon = Icons.Default.ThumbUp, title = "Create a post") {
                        showBottomSheet = false
                        navigationController.navigate(Screens.Post.Screen) {
                            popUpTo(0)
                        }
                    }
                    BottomSheetItem(icon = Icons.Default.Star, title = "Add a story") {
                        Toast.makeText(context, "story", Toast.LENGTH_SHORT).show()
                    }
                    BottomSheetItem(icon = Icons.Default.PlayArrow, title = "Create a Reel") {
                        Toast.makeText(context, "reel", Toast.LENGTH_SHORT).show()
                    }
                    BottomSheetItem(icon = Icons.Default.Favorite, title = "Go live") {
                        Toast.makeText(context, "live", Toast.LENGTH_SHORT).show()
                    }
                }
            }
        }
    }
}
@Composable
fun BottomSheetItem(icon : ImageVector, title : String, onClick : () -> Unit){
    Row (verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.spacedBy(16.dp),
        modifier = Modifier.clickable { onClick() }
    ) {
        Icon(icon, contentDescription =null, tint = redjc )
        Text(text = title, color = redjc, fontSize = 22.sp)
    }
}
@Preview
@Composable
fun HomeScreenPreview(){
    ComposePracTheme {
        MyHomeScreen()
    }
}
