package com.example.swiftnewsapp.authentication

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
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
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.ViewModel
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.swiftnewsapp.R
import com.example.swiftnewsapp.authentication.components.ButtonComponent
import com.example.swiftnewsapp.authentication.components.CheckboxComponent
import com.example.swiftnewsapp.authentication.components.ClickableLoginTextComponent
import com.example.swiftnewsapp.authentication.components.DividerTextComponent
import com.example.swiftnewsapp.authentication.components.HeadingTextComponent
import com.example.swiftnewsapp.authentication.components.NormalTextComponent
//import com.example.swiftnewsapp.components.PasswordTextFieldComponent
import com.example.swiftnewsapp.authentication.components.TextFieldComponent
import com.example.swiftnewsapp.presentation.nvgraph.Route

@Composable
fun SignUpScreen (
    navController: NavController,
    viewModel: loginViewModel = androidx.lifecycle.viewmodel.compose.viewModel()
){


    val firstName = remember {
        mutableStateOf("")
    }

    val lastName = remember {
        mutableStateOf("")
    }

    val email = remember {
        mutableStateOf("")
    }

    val password = remember {
        mutableStateOf("")
    }


    Surface (
        color = Color.White,
        modifier = Modifier
            .fillMaxSize()
            .background(Color.White)
            .padding(28.dp)
    ){
        Column (modifier = Modifier.fillMaxSize()){

            NormalTextComponent(value = stringResource(id = R.string.hello))
            HeadingTextComponent(value = stringResource(id = R.string.create_account))
            Spacer(modifier = Modifier.height(20.dp))
            TextFieldComponent(
                labelValue = stringResource(id = R.string.first_name),
                painterResource(id = R.drawable.ic_profile),
                value = firstName.value,
                onChange = {firstName.value = it}
            )
            TextFieldComponent(
                labelValue = stringResource(id = R.string.last_name),
                painterResource = painterResource(id = R.drawable.ic_profile),
                value = lastName.value,
                onChange = {lastName.value = it}
            )
            TextFieldComponent(
                labelValue = stringResource(id = R.string.email),
                painterResource = painterResource(id = R.drawable.ic_email),
                value = email.value,
                onChange = {email.value = it}
            )
            TextFieldComponent(
                labelValue = stringResource(id = R.string.password),
                painterResource = painterResource(id = R.drawable.ic_lock),
                value = password.value,
                onChange = {password.value = it}

            )

            CheckboxComponent(value = stringResource(id = R.string.terms_conditions))

            Spacer(modifier = Modifier.height(80.dp))

            ButtonComponent(value = stringResource(id = R.string.register),
                onClick = {
                    viewModel.createUserWithEmailAndPassword(email.value, password.value) {
                        navController.navigate(Route.NewsNavigatorScreen.route)
                    }
                }
                )

            Spacer(modifier = Modifier.height(20.dp))

            DividerTextComponent()

            Text(
                text = "Already have an account? Login",
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
                    navController.navigate(Route.LoginScreen.route)
                })




        }

    }
}


@Preview
@Composable
fun DefaultPreviewOfSignUpScreen(){
    SignUpScreen(
        rememberNavController()
    )
}