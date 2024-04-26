package com.example.swiftnewsapp.authentication

import android.util.Log
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.swiftnewsapp.R
import com.example.swiftnewsapp.authentication.components.ButtonComponent
import com.example.swiftnewsapp.authentication.components.ClickableLoginTextComponent
import com.example.swiftnewsapp.authentication.components.DividerTextComponent
import com.example.swiftnewsapp.authentication.components.HeadingTextComponent
import com.example.swiftnewsapp.authentication.components.NormalTextComponent
import com.example.swiftnewsapp.authentication.components.TextFieldComponent
import com.example.swiftnewsapp.authentication.components.UnderlinedTextComponent
import com.example.swiftnewsapp.presentation.nvgraph.Route

@Composable
fun LoginScreen(navController: NavController,
                viewModel: loginViewModel = androidx.lifecycle.viewmodel.compose.viewModel()
                ){

    val email = remember {
        mutableStateOf("")
    }

    val password = remember {
        mutableStateOf("")
    }

    var showPassword = remember {
        mutableStateOf(false)
    }

    Surface (
        modifier = Modifier
            .fillMaxSize()
            .background(Color.White)
            .padding(28.dp)
    ){

        Column (modifier = Modifier
            .fillMaxSize()){

            NormalTextComponent(value = stringResource(id = R.string.login))
            HeadingTextComponent(value = stringResource(id = R.string.welcome))

            Spacer(modifier = Modifier.height(20.dp))

            TextFieldComponent(labelValue = stringResource(id = R.string.email),
                painterResource = painterResource(id = R.drawable.ic_email),
                value = email.value,
                onChange = {email.value = it},
                )

            TextFieldComponent(
                labelValue = stringResource(id = R.string.password),
                painterResource = painterResource(id = R.drawable.ic_lock),
                value = password.value,
                onChange = {password.value = it},
                inputType = if (showPassword.value) VisualTransformation.None else PasswordVisualTransformation(),
                iconOnClick = {
                    showPassword.value = !showPassword.value
                              Log.d("pressed", showPassword.value.toString())
                              },
                )

            Spacer(modifier = Modifier.height(40.dp))

            UnderlinedTextComponent(value = stringResource(id = R.string.forgot_password))

            Spacer(modifier = Modifier.height(40.dp))

            if(viewModel.isLoading) {
                CircularProgressIndicator()
            }else {
            ButtonComponent(value = stringResource(id = R.string.login),
                onClick = {
                    viewModel.signInWithEmailAndPassword(email.value, password.value){
                        navController.navigate(Route.NewsNavigatorScreen.route)
                    }
//                    Log.d("test", "testing click")

                }
            )}

            Spacer(modifier = Modifier.height(20.dp))

            DividerTextComponent()

            Spacer(modifier = Modifier.height(20.dp))


            Text(
                text = "Do not have an account? Register",
                style = TextStyle(
                    fontSize = 21.sp,
                    fontWeight = FontWeight.Normal,
                    fontStyle = FontStyle.Normal,
                    textAlign = TextAlign.Center
                ),
                modifier = Modifier
                    .fillMaxWidth()
                    .clickable
                    {
                        navController.navigate(Route.SignUpScreen.route)
                    })

        }

    }
}

@Preview
@Composable
fun LoginScreenPreview(){
    LoginScreen(
        rememberNavController()
    )
}