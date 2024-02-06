package np.com.paurakh.friendchat

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.navigation.compose.composable
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.hilt.navigation.compose.hiltViewModel


import androidx.navigation.compose.NavHost
import androidx.navigation.compose.rememberNavController
import np.com.paurakh.friendchat.screens.LoginClass
import np.com.paurakh.friendchat.screens.SignupScreen
import np.com.paurakh.friendchat.ui.theme.FriendChatTheme

sealed class DestinationScreen(var route:String) {
    object SignUp:DestinationScreen("signup")
    object Login:DestinationScreen("login")
    object Profile:DestinationScreen("profile")
    object ChatList:DestinationScreen("chatList")
    object SingleChat:DestinationScreen("singleChat/{chatId}"){
        fun createRoute(id:String) = "singleChat/$id"

    }
    object statusList:DestinationScreen("statusList")
    object SingleStatus:DestinationScreen("status/{userId}"){
        fun createRoute(userId:String) = "singleChat/$userId"

    }


}

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            FriendChatTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    AppNavigation()
                }
            }
        }
    }
    @Composable
    fun AppNavigation(){
        val navigationController = rememberNavController()
        var vm = hiltViewModel<FCViewModel>()
        NavHost(navController = navigationController, startDestination = DestinationScreen.SignUp.route){
            composable(DestinationScreen.SignUp.route){
                SignupScreen(navigationController,vm)
            }

            composable(DestinationScreen.Login.route){
                LoginClass()

            }
        }
    }
}

