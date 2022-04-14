package com.example.myapplication

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.material.icons.materialIcon
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.unit.dp
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.launch

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Surface(color = Color.White) {
                // Scaffold we created
                LayoutDesign()
            }
        }
    }
}

@Composable
fun Drawer() {
    // Column Composable
    Column(
        Modifier
            .background(Color.White)
            .fillMaxSize()
    ) {
        // Repeat is a loop which
        // takes count as argument
        repeat(5) { item ->
            Text(text = "Item number $item", modifier = Modifier.padding(8.dp), color = Color.Black)
        }
    }
}
@Composable

fun LayoutDesign(){
    val coroutinescope= rememberCoroutineScope()
    val scaffoldState =
        rememberScaffoldState(
            rememberDrawerState(initialValue = DrawerValue.Closed)
        )
    Scaffold (

        scaffoldState =scaffoldState,
        topBar =
    {
        TopAppBar(
        title = {
            Text(text = "LayoutsCodelab")

        },
            navigationIcon ={  Icon(
                imageVector = Icons.Default.Menu,
                contentDescription = "Menu",

                // When clicked trigger onClick
                // Callback to trigger drawer open
                modifier = Modifier.clickable(onClick = {coroutinescope.launch { scaffoldState.drawerState.open() }}),
                tint = Color.White
            )}
    )
    },
        bottomBar = {



        },
        drawerContent = {Drawer()},
        floatingActionButton = {
            FloatingActionButton(onClick = {  coroutinescope.launch {
                when (
                    scaffoldState.snackbarHostState.showSnackbar(
                    // Message In the snackbar
                    message = "Snack Bar",
                    actionLabel = "Dismiss"
                )) {}

            } }) {
                Icon(
                    imageVector = Icons.Default.Add,
                    contentDescription = "add",

                    // When clicked trigger onClick
                    // Callback to trigger drawer open
                    tint = Color.White
                )
            }
        }
    )
        { innerPadding->
        BodyContent(Modifier.padding(innerPadding))
    }

    }

@Composable
fun BodyContent(modifier: Modifier = Modifier) {
    Column(modifier = modifier.padding((8.dp))) {
        Text(text = "Hi there!")
        Text(text = "Thanks for going through the Layouts codelab")
    }
}
