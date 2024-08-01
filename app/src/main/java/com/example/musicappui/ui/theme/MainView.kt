//package com.example.musicappui.ui
//
//
//import androidx.compose.foundation.background
//import androidx.compose.foundation.clickable
//import androidx.compose.foundation.layout.PaddingValues
//import androidx.compose.foundation.layout.Row
//
//import androidx.compose.foundation.layout.fillMaxWidth
//import androidx.compose.foundation.layout.padding
//import androidx.compose.foundation.lazy.LazyColumn
//import androidx.compose.foundation.lazy.items
//import androidx.compose.material.ScaffoldState
//import androidx.compose.material.icons.Icons
//import androidx.compose.material.icons.filled.AccountCircle
//import androidx.compose.material.rememberScaffoldState
//import androidx.compose.material3.ExperimentalMaterial3Api
//import androidx.compose.material3.Icon
//import androidx.compose.material3.IconButton
//import androidx.compose.material3.MaterialTheme
//import androidx.compose.material.Scaffold
//import androidx.compose.material3.Text
//import androidx.compose.material3.TopAppBar
//import androidx.compose.runtime.Composable
//import androidx.compose.runtime.getValue
//import androidx.compose.runtime.mutableStateOf
//import androidx.compose.runtime.remember
//import androidx.compose.runtime.rememberCoroutineScope
//import androidx.compose.ui.Modifier
//import androidx.compose.ui.graphics.Color
//import androidx.compose.ui.res.painterResource
//import androidx.compose.ui.unit.dp
//import androidx.lifecycle.viewmodel.compose.viewModel
//import androidx.navigation.NavController
//import androidx.navigation.NavHostController
//import androidx.navigation.compose.NavHost
//import androidx.navigation.compose.composable
//import androidx.navigation.compose.currentBackStackEntryAsState
//import androidx.navigation.compose.rememberNavController
//import com.example.musicappui.MainViewModel
//import com.example.musicappui.Screen
//import com.example.musicappui.screensInDrawer
//import com.example.musicappui.ui.theme.AccountDialog
//import kotlinx.coroutines.CoroutineScope
//import kotlinx.coroutines.launch
//
//
//@OptIn(ExperimentalMaterial3Api::class)
//@Composable
//fun MainView(){
//
//    val viewModel : MainViewModel= viewModel()
//    val scaffoldState: ScaffoldState= rememberScaffoldState()
//    val scope: CoroutineScope= rememberCoroutineScope()
//
//    //allows us to find out at which screen we currently are
//    val controller: NavController=rememberNavController()
//    val navBackStackEntry by controller.currentBackStackEntryAsState()
//    val currentRoute=navBackStackEntry?.destination?.route
//
//    val currentScreen= remember{
//        viewModel.currentScreen.value
//    }
//
//    val title= remember{
//        //change that to currentScreen.title
//        mutableStateOf(currentScreen.title)
//    }
//
//    val dialogOpen=remember{
//        mutableStateOf(false)
//    }
//
//    Scaffold(
//        topBar = {
//            TopAppBar(title = { Text(text = "Home") },
//                navigationIcon = { IconButton(onClick = {
//                    //Open the drawer
//                    scope.launch {
//                        scaffoldState.drawerState.open()
//                    }
//                }) {
//                    Icon(imageVector = Icons.Default.AccountCircle, contentDescription ="Menu" )
//                }}
//            )
//        },
//        scaffoldState=scaffoldState,
//        drawerContent = {
//            LazyColumn(Modifier.padding(16.dp)){
//                items(screensInDrawer){
//                    item->
//                    DrawerItem(selected = currentRoute==item.dRoute , item = item) {
//                         scope.launch {
//                             scaffoldState.drawerState.close()  //drawer will close on clicking away or on clicking on the item
//                         }
//                        if(item.dRoute=="add_account"){
//                            //open dialog
//                            dialogOpen.value=true
//
//                        }else{
//                            controller.navigate(item.dRoute)
//                            title.value=item.dTitle
//                        }
//                    }
//                }
//            }
//        }
//    ) {
//        //content of the scaffold
//        Navigation(navController = controller, viewModel =viewModel , pd = it)
//        AccountDialog(dialogOpen = dialogOpen)
//
//    }
//}
//
//@Composable
//fun DrawerItem(
//    selected:Boolean,
//    item: Screen.DrawerScreen,
//    onDrawerItemClicked : ()->Unit
//){
//    val background=if(selected) Color.DarkGray else Color.White
//    Row(
//        Modifier
//            .fillMaxWidth()
//            .padding(horizontal = 8.dp, vertical = 16.dp)
//            .background(background)
//            .clickable {
//                onDrawerItemClicked()
//            }
//    ) {
//
//        Icon(painter = painterResource(id = item.icon),
//            contentDescription =item.dTitle,
//            Modifier.padding(end = 8.dp, top = 4.dp))
//
//        Text(text = item.dTitle,
//            style = MaterialTheme.typography.headlineMedium)
//
//    }
//}
//
//@Composable
//fun Navigation(navController: NavController,viewModel: MainViewModel,pd:PaddingValues){
//    NavHost(navController = navController as NavHostController, startDestination = Screen.DrawerScreen.AddAccount.route,modifier=Modifier.padding(pd) ){
//        composable(Screen.DrawerScreen.Account.route){
//
//        }
//        composable(Screen.DrawerScreen.Subscription.route){
//
//        }
//
//
//    }
//}


package com.example.musicappui.ui

import android.util.Log
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.BottomNavigation
import androidx.compose.material.BottomNavigationItem
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.material.ModalBottomSheetLayout
import androidx.compose.material.ModalBottomSheetValue
import androidx.compose.material.Scaffold
import androidx.compose.material.ScaffoldState
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountCircle
import androidx.compose.material.icons.filled.MoreVert
import androidx.compose.material.primarySurface
import androidx.compose.material.rememberModalBottomSheetState
import androidx.compose.material.rememberScaffoldState
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.example.musicappui.MainViewModel
import com.example.musicappui.Screen
import com.example.musicappui.screensInBottom
import com.example.musicappui.screensInDrawer
import com.example.musicappui.ui.theme.AccountDialog
import com.example.musicappui.ui.theme.AccountView
import com.example.musicappui.ui.theme.Browse
import com.example.musicappui.ui.theme.Home
import com.example.musicappui.ui.theme.Library
import com.example.musicappui.ui.theme.Subscription
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.launch
import com.example.musicappui.R

@OptIn(ExperimentalMaterial3Api::class, ExperimentalMaterialApi::class)
@Composable
fun MainView() {
    val viewModel: MainViewModel = viewModel()
    val scaffoldState: ScaffoldState = rememberScaffoldState()
    val scope: CoroutineScope = rememberCoroutineScope()

    // Allows us to find out at which screen we currently are
    val navController: NavHostController = rememberNavController()
    val navBackStackEntry by navController.currentBackStackEntryAsState()
    val currentRoute = navBackStackEntry?.destination?.route

    val isSheetFullScreen by remember {
        mutableStateOf(false)
    }
    val modifier=if(isSheetFullScreen) Modifier.fillMaxSize()else Modifier.fillMaxWidth()

    val currentScreen= remember{
        viewModel.currentScreen.value
    }

    val title= remember{
        //change that to currentScreen.title
        mutableStateOf(currentScreen.title)
    }

    val dialogOpen = remember {
        mutableStateOf(false)
    }


//    The confirmStateChange lambda is called whenever there is an attempt to change the state of the modal bottom sheet.
//    It allows you to determine whether the state transition should be allowed or not
//      Initial State: The bottom sheet starts in the Hidden state as specified by initialValue.
//
//      State Change Attempt: Whenever there is an attempt to change the state of the bottom sheet, the confirmStateChange lambda is called with the target state as its argument (it).
//
//      Condition Check: The lambda checks if the target state is ModalBottomSheetValue.HalfExpanded.
//
//      Return Value:
//
//      If the target state is HalfExpanded, the lambda returns false, preventing the state change.
//      For all other states, the lambda returns true, allowing the state change.
    val modalSheetState= rememberModalBottomSheetState(
        initialValue = ModalBottomSheetValue.Hidden,
        confirmStateChange = {
            it!=ModalBottomSheetValue.HalfExpanded   //prevents from half expanded state
        })

    val roundedCornerRadius=if(isSheetFullScreen)0.dp else 12.dp

    val bottomBar: @Composable ()->Unit={
        if(currentScreen is Screen.DrawerScreen || currentScreen==Screen.BottomScreen.Home){
            BottomNavigation(Modifier.wrapContentSize()) {
                screensInBottom.forEach{
                    item->
                    val isSelected = currentRoute==item.bRoute
                    Log.d("Navigation","Item: ${item.bTitle},Current Route: $currentRoute, Is Selected: $isSelected")   //It  is a debug log statement in Kotlin used to print a message to the logcat, which is a tool used in Android development for logging messages.
                    val tint=if(isSelected)Color.White else Color.Black
                    BottomNavigationItem(
                        selected = currentRoute==item.bRoute ,
                        onClick = { navController.navigate(item.bRoute)
                                    title.value=item.bTitle},
                        icon = { Icon(painter = painterResource(id = item.icon),
                            contentDescription = item.bTitle,
                            tint=tint) },
                        label = { Text(text = item.bTitle,color=tint)},
                        selectedContentColor = Color.White,
                        unselectedContentColor = Color.Black
                    )
                }
            }
        }
    }

    ModalBottomSheetLayout(
        sheetState = modalSheetState,    //sheetState: Controls the state of the sheet (hidden, expanded, etc.)
        sheetShape = RoundedCornerShape(topStart = roundedCornerRadius, topEnd = roundedCornerRadius),
        sheetElevation = 5.dp ,
        sheetContent = {
        MoreBottomSheet(modifier=modifier)
    }) {
        Scaffold(
            bottomBar = bottomBar,
            topBar = {
                TopAppBar(

                    title = { Text(text = title.value) },
                    actions = {
                              IconButton(onClick = {
                                  scope.launch {
                                      if(modalSheetState.isVisible){
                                          modalSheetState.hide()
                                      }
                                      else modalSheetState.show()
                                  }
                              }) {
                                  Icon(imageVector = Icons.Default.MoreVert, contentDescription = "Actions")
                              }
                    },
                    navigationIcon = {
                        IconButton(onClick = {
                            // Open the drawer
                            scope.launch {
                                scaffoldState.drawerState.open()
                            }
                        }) {
                            Icon(imageVector = Icons.Default.AccountCircle, contentDescription = "Menu")
                        }
                    }
                )
            },
            scaffoldState = scaffoldState,
            drawerContent = {
                LazyColumn(Modifier.padding(16.dp)) {
                    items(screensInDrawer) { item ->
                        DrawerItem(selected = currentRoute == item.dRoute, item = item) {
                            scope.launch {
                                scaffoldState.drawerState.close() // Drawer will close on clicking away or on clicking on the item
                            }
                            if (item.dRoute == "add_account") {
                                // Open dialog
                                dialogOpen.value = true
                            } else {
                                navController.navigate(item.dRoute) {
                                    // Ensure we don't duplicate destinations
//                                popUpTo(navController.graph.startDestinationId) {
//                                    saveState = true
//                                }
//                                launchSingleTop = true
//                                restoreState = true
                                }
                                title.value = item.dTitle
                            }
                        }
                    }
                }
            }
        ) { padding ->
            // Content of the scaffold
            Navigation(navController = navController, viewModel = viewModel, paddingValues = padding)
            if (dialogOpen.value) {
                AccountDialog(dialogOpen = dialogOpen)
            }
        }
    }
    }



@Composable
fun DrawerItem(
    selected: Boolean,
    item: Screen.DrawerScreen,
    onDrawerItemClicked: () -> Unit
) {
    val background = if (selected) Color.DarkGray else Color.White
    Row(
        Modifier
            .fillMaxWidth()
            .padding(horizontal = 8.dp, vertical = 16.dp)
            .background(background)
            .clickable {
                onDrawerItemClicked()
            }
    ) {
        Icon(
            painter = painterResource(id = item.icon),
            contentDescription = item.dTitle,
            Modifier.padding(end = 8.dp, top = 4.dp)
        )

        Text(
            text = item.dTitle,
            style = MaterialTheme.typography.headlineMedium
        )
    }
}

@Composable
fun MoreBottomSheet(modifier:Modifier){
    Box(modifier = Modifier
        .fillMaxWidth()
        .height(300.dp)
        .background(androidx.compose.material.MaterialTheme.colors.primarySurface)){
        Column(
            modifier=Modifier.padding(16.dp),
            verticalArrangement = Arrangement.SpaceBetween  //even spacing between the elements
        ) {
            Row (modifier=Modifier.padding(end = 8.dp)){
                Icon(painter = painterResource(id = R.drawable.ic_settings), contentDescription = "Settings",modifier=Modifier.padding(end = 8.dp))
                Text(text = "Settings", fontSize = 20.sp, color = Color.White)
            }
            Spacer(modifier = Modifier.height(16.dp))
            Row (modifier=Modifier.padding(end = 8.dp)){
                Icon(painter = painterResource(id = R.drawable.ic_share), contentDescription = "Share",modifier=Modifier.padding(end = 8.dp))
                Text(text = "Share", fontSize = 20.sp, color = Color.White)
            }
            Spacer(modifier = Modifier.height(16.dp))
            Row (modifier=Modifier.padding(end = 8.dp)){
                Icon(painter = painterResource(id = R.drawable.ic_help), contentDescription = "Help",modifier=Modifier.padding(end = 8.dp))
                Text(text = "Help", fontSize = 20.sp, color = Color.White)
            }
            Spacer(modifier = Modifier.height(16.dp))
        }
    }
}

@Composable
fun Navigation(navController: NavHostController, viewModel: MainViewModel, paddingValues: PaddingValues) {
    NavHost(navController = navController, startDestination = Screen.DrawerScreen.Account.route, modifier = Modifier.padding(paddingValues)) {

        composable(Screen.BottomScreen.Home.bRoute){
            Home()
        }
        composable(Screen.BottomScreen.Browse.bRoute){
            Browse()
        }
        composable(Screen.BottomScreen.Library.bRoute){
            Library()
        }

        composable(Screen.DrawerScreen.Account.route) {
            // Account Screen Content
            AccountView()
        }
        composable(Screen.DrawerScreen.Subscription.route) {
            // Subscription Screen Content
            Subscription()
        }

    }
}

