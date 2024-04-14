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
import com.example.swiftnewsapp.authentication.components.CheckboxComponent
import com.example.swiftnewsapp.authentication.components.ClickableLoginTextComponent
import com.example.swiftnewsapp.authentication.components.DividerTextComponent
import com.example.swiftnewsapp.authentication.components.HeadingTextComponent
import com.example.swiftnewsapp.authentication.components.NormalTextComponent
//import com.example.swiftnewsapp.components.PasswordTextFieldComponent
import com.example.swiftnewsapp.authentication.components.TextFieldComponent

@Composable
fun SignUpScreen (){

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
                painterResource(id = R.drawable.ic_profile)
            )
            TextFieldComponent(
                labelValue = stringResource(id = R.string.last_name),
                painterResource = painterResource(id = R.drawable.ic_profile)
            )
            TextFieldComponent(
                labelValue = stringResource(id = R.string.email),
                painterResource = painterResource(id = R.drawable.ic_email)
            )
            TextFieldComponent(
                labelValue = stringResource(id = R.string.password),
                painterResource = painterResource(id = R.drawable.ic_lock)

            )

            CheckboxComponent(value = stringResource(id = R.string.terms_conditions))

            Spacer(modifier = Modifier.height(80.dp))

            ButtonComponent(value = stringResource(id = R.string.register))

            Spacer(modifier = Modifier.height(20.dp))

            DividerTextComponent()

            ClickableLoginTextComponent(tryToLogin = true, onTextSelected = {

            })





        }

    }
}


@Preview
@Composable
fun DefaultPreviewOfSignUpScreen(){
    SignUpScreen()
}