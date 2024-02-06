package np.com.paurakh.friendchat.screens


import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Button
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

import androidx.navigation.NavController
import np.com.paurakh.friendchat.DestinationScreen
import np.com.paurakh.friendchat.FCViewModel
import np.com.paurakh.friendchat.R
import np.com.paurakh.friendchat.navigateTo


@Composable
fun SignupScreen(navController: NavController, vm: FCViewModel) {
    Box(modifier = Modifier.fillMaxSize()) {

        Column(
            modifier = Modifier
                .fillMaxSize()
                .wrapContentHeight()
                .verticalScroll(
                    rememberScrollState()
                ),
            horizontalAlignment = Alignment.CenterHorizontally

        ) {
            val nameState = remember {
                mutableStateOf(TextFieldValue())
            }

            val numberState = remember {
                mutableStateOf(TextFieldValue())
            }

            val emailState = remember {
                mutableStateOf(TextFieldValue())
            }
            val passwordState = remember {
                mutableStateOf(TextFieldValue())
            }
            Image(
                painter = painterResource(id = R.drawable.logo),
                contentDescription = null,
                modifier = Modifier
                    .width(200.dp)
                    .padding(top = 16.dp)
                    .padding(8.dp)
            )

            Text(
                text = "Sign Up",
                fontSize = 30.sp,
                fontFamily = FontFamily.SansSerif,
                fontWeight = FontWeight.Bold,
                modifier = Modifier.padding(8.dp)
            )

            OutlinedTextField(value = nameState.value, onValueChange = {
                nameState.value = it
            },
             label = {Text(text = "Enter Full Name") },

            )

            OutlinedTextField(value = numberState.value, onValueChange = {
                nameState.value = it
            },
                label = {Text(text = "Enter Your Phone Number") },

            )

            OutlinedTextField(value = emailState.value, onValueChange = {
                nameState.value = it
            },
                label = {Text(text = "Enter Your Email") },
            )

            OutlinedTextField(value = passwordState.value, onValueChange = {
                nameState.value = it
            },
                label = {Text(text = "Enter Your Email") },
                modifier = Modifier.padding(8.dp)
            )

            Button(onClick = { /*TODO*/ },

            modifier = Modifier.padding(8.dp)) {
                Text(text = "Signup")

            }

            Text(text = "Already hava an Account? Login",
                color= Color.Blue,
                modifier = Modifier.padding(8.dp)
                    .clickable {
                        navigateTo(navController, DestinationScreen.Login.route)
                    }

                )

        }
    }
}
