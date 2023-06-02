    package com.example.quizika

    import android.os.Bundle
    import androidx.activity.ComponentActivity
    import androidx.activity.compose.setContent
    import androidx.annotation.StringRes
    import androidx.compose.foundation.background
    import androidx.compose.foundation.layout.fillMaxSize
    import androidx.compose.foundation.layout.padding
    import androidx.compose.material.icons.Icons
    import androidx.compose.material.icons.filled.ArrowBack
    import androidx.compose.material3.ExperimentalMaterial3Api
    import androidx.compose.material3.Icon
    import androidx.compose.material3.IconButton
    import androidx.compose.material3.MaterialTheme
    import androidx.compose.material3.Scaffold
    import androidx.compose.material3.Surface
    import androidx.compose.material3.Text
    import androidx.compose.material3.TextField
    import androidx.compose.material3.TopAppBar
    import androidx.compose.material3.TopAppBarDefaults
    import androidx.compose.runtime.Composable
    import androidx.compose.runtime.getValue
    import androidx.compose.ui.Modifier
    import androidx.compose.ui.graphics.Color
    import androidx.compose.ui.res.stringResource
    import androidx.compose.ui.tooling.preview.Preview
    import androidx.navigation.NavHost
    import androidx.navigation.NavHostController
    import androidx.navigation.compose.currentBackStackEntryAsState
    import androidx.navigation.compose.rememberNavController
    import com.example.quizika.data.userInput
    import com.example.quizika.ui.theme.QuizikaTheme
    import androidx.navigation.compose.NavHost
    import androidx.navigation.compose.rememberNavController
    import androidx.navigation.compose.composable

    class MainActivity : ComponentActivity() {
        override fun onCreate(savedInstanceState: Bundle?) {
            super.onCreate(savedInstanceState)
            setContent {
                QuizikaTheme {
                    // A surface container using the 'background' color from the theme
                    Surface(
                        modifier = Modifier.fillMaxSize(),
                        color = MaterialTheme.colorScheme.background
                    ) {
                    Start()
                    }
                }
            }
        }
    }


    enum class Screens(@StringRes val title: Int) {
        Welcome(title = R.string.welcome),
        Game(title = R.string.game), //this one is static just updates content
        Finish(title = R.string.finish)
    }

    @OptIn(ExperimentalMaterial3Api::class)
    @Composable
    fun CustomTextField() {

        //var userName by remember { mutableStateOf(TextFieldValue("")) }
        TextField(
            modifier = Modifier.background(Color(0xFFF2F2F2)),
            onValueChange = {
                //userName = it
                    newText ->
                userInput.value = newText

            },
            value = userInput.value,
            //value = userName,

            label = { Text(text = "Name") },
            placeholder = { Text(text = "Type your name") }

        )
    }

    @OptIn(ExperimentalMaterial3Api::class)
    @Composable
    fun AppBar(
        currentScreen: Screens,
        canNavigateBack: Boolean,
        navigateUp: () -> Unit,
        modifier: Modifier = Modifier
    ) {
        TopAppBar(
            title = { Text(stringResource(id = currentScreen.title), color = Color.Black) },
            colors = TopAppBarDefaults.mediumTopAppBarColors(
                containerColor = Color(android.graphics.Color.parseColor("#c2edd5"))
            ),
            modifier = modifier,
            navigationIcon = {
                if (canNavigateBack) {
                    IconButton(onClick = navigateUp) {
                        Icon(
                            imageVector = Icons.Filled.ArrowBack,
                            contentDescription = stringResource(R.string.back_button)
                        )
                    }
                }
            }
        )
    }


    @OptIn(ExperimentalMaterial3Api::class)
    @Composable
    fun Start() {
        val navController: NavHostController = rememberNavController()
        val backStackEntry by navController.currentBackStackEntryAsState()

        val currentScreen = Screens.valueOf(
            backStackEntry?.destination?.route ?: Screens.Welcome.name
        )

        Scaffold(
            topBar = {
                AppBar(
                    currentScreen = currentScreen,
                    canNavigateBack = navController.previousBackStackEntry != null,
                    navigateUp = { navController.navigateUp() }
                )
            }
        ) { innerPadding ->
            NavHost(
                navController = navController,
                startDestination = Screens.Welcome.name,
                modifier = Modifier.padding(innerPadding)
            ) {
                composable(route = Screens.Welcome.name) {
                    WelcomeScreen(onNextButtonClicked = { navController.navigate(Screens.Game.name) })
                }
                composable(route = Screens.Game.name) {
                    GameScreen(navController=navController)
                }
                composable(route = Screens.Finish.name) {
                    Finish(onCancelButton = { navController.popBackStack(Screens.Welcome.name, inclusive = false) })
                }
            }
        }
    }

    @Preview(showBackground = true)
    @Composable
    fun GreetingPreview() {
        QuizikaTheme {

        }
    }