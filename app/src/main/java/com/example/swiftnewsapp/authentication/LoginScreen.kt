package com.example.swiftnewsapp.authentication

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.swiftnewsapp.R
import com.example.swiftnewsapp.authentication.components.ButtonComponent
import com.example.swiftnewsapp.authentication.components.ClickableLoginTextComponent
import com.example.swiftnewsapp.authentication.components.DividerTextComponent
import com.example.swiftnewsapp.authentication.components.HeadingTextComponent
import com.example.swiftnewsapp.authentication.components.NormalTextComponent
import com.example.swiftnewsapp.authentication.components.TextFieldComponent
import com.example.swiftnewsapp.authentication.components.UnderlinedTextComponent

@Composable
fun LoginScreen(){

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
                painterResource = painterResource(id = R.drawable.ic_email))

            TextFieldComponent(labelValue = stringResource(id = R.string.password),
                painterResource = painterResource(id = R.drawable.ic_lock))

            Spacer(modifier = Modifier.height(40.dp))

            UnderlinedTextComponent(value = stringResource(id = R.string.forgot_password))

            Spacer(modifier = Modifier.height(40.dp))

            ButtonComponent(value = stringResource(id = R.string.login))

            Spacer(modifier = Modifier.height(20.dp))

            DividerTextComponent()

            Spacer(modifier = Modifier.height(20.dp))

            ClickableLoginTextComponent(tryToLogin = false, onTextSelected = {

            })

        }

    }
}

@Preview
@Composable
fun LoginScreenPreview(){
    LoginScreen()
}