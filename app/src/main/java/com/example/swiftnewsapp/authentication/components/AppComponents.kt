package com.example.swiftnewsapp.authentication.components

import android.util.Log
import android.view.textclassifier.TextSelection
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.ClickableText
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Checkbox
import androidx.compose.material3.Divider
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.compose.rememberNavController
import com.example.swiftnewsapp.R
import com.example.swiftnewsapp.presentation.nvgraph.Route
import com.example.swiftnewsapp.ui.theme.GrayColor
import com.example.swiftnewsapp.ui.theme.Pink80
import com.example.swiftnewsapp.ui.theme.Primary
import com.example.swiftnewsapp.ui.theme.Secondary
import com.example.swiftnewsapp.ui.theme.TextColor
import com.example.swiftnewsapp.ui.theme.componentShapes

@Composable
fun NormalTextComponent(value:String){
    Text(text = value, modifier = Modifier
        .fillMaxWidth()
        .heightIn(min = 40.dp),
        style = TextStyle(
            fontSize = 24.sp,
            fontWeight = FontWeight.Normal,
            fontStyle = FontStyle.Normal
        )
    , color = colorResource(id = R.color.text_title),
        textAlign = TextAlign.Center
    )
}

@Composable
fun HeadingTextComponent(value:String){
    Text(text = value, modifier = Modifier
        .fillMaxWidth()
        .heightIn(),
        style = TextStyle(
            fontSize = 30.sp,
            fontWeight = FontWeight.Bold,
            fontStyle = FontStyle.Normal
        )
        , color = colorResource(id = R.color.text_title),
        textAlign = TextAlign.Center
    )
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
 fun TextFieldComponent(
    labelValue: String,
    painterResource: Painter,
    value: String = "",
    onChange: (String) -> Unit = {},
    inputType: VisualTransformation = VisualTransformation.None,
    iconOnClick: () -> Unit = {},
    ){



    OutlinedTextField(
        modifier = Modifier
            .fillMaxWidth()
            .clip(componentShapes.small),
        label = {Text(text = labelValue) },
        colors = TextFieldDefaults.outlinedTextFieldColors(
            focusedBorderColor = Primary,
            focusedLabelColor = Primary,
            cursorColor = Primary,


        ),
        keyboardOptions = KeyboardOptions.Default,
        value = value,
        onValueChange = onChange,
        leadingIcon = {
            Icon(painter = painterResource, contentDescription =" ",
                modifier = Modifier.clickable(onClick = iconOnClick))
        },
        visualTransformation = inputType
    )
}


@Composable
fun CheckboxComponent(value: String){
    Row (modifier = Modifier
        .fillMaxWidth()
        .heightIn(56.dp),
        verticalAlignment = Alignment.CenterVertically,

    ){

        val checkedState = remember {
            mutableStateOf(false)
        }
        Checkbox(checked = checkedState.value,
            onCheckedChange = {
                checkedState.value != checkedState.value
            } )

        ClickableTextComponent(value= value)
    }
}

@Composable
fun ClickableTextComponent(value: String){
    val initialText = "By continuing you accept our "
    val privacyPolicyText = "Privacy Policy "
    val andText = " and "
    val termsAndConditionsText = " Term of Use"

    val annotatedString = buildAnnotatedString {
        append(initialText)
        withStyle(style = SpanStyle(color = Primary)){
            pushStringAnnotation(tag = privacyPolicyText, annotation = privacyPolicyText)
            append(privacyPolicyText)
        }
        append(andText)
        withStyle(style = SpanStyle(color = Primary)) {
            pushStringAnnotation(tag = termsAndConditionsText, annotation = termsAndConditionsText)
            append(termsAndConditionsText)

        }
    }

    ClickableText(text = annotatedString , onClick = {offset ->

        annotatedString.getStringAnnotations(offset,offset)
            .firstOrNull()?.also {span->
                Log.d("ClickableTextComponent", "{$span}")

            }


    })
}

@Composable
fun ButtonComponent(value: String, onClick : () -> Unit){
    Button(onClick = onClick, modifier = Modifier
        .fillMaxWidth()
        .heightIn(48.dp),
        contentPadding = PaddingValues(),
        colors = ButtonDefaults.buttonColors(Color.Transparent)
    ) {

        Box(modifier = Modifier
            .fillMaxWidth()
            .heightIn(48.dp)
            .background(
                brush = Brush.horizontalGradient(listOf(Secondary, Pink80)),
                shape = RoundedCornerShape(50.dp)
            ),
            contentAlignment = Alignment.Center
        ){
            Text(text = value,
            fontSize = 18.sp,
                fontWeight = FontWeight.Bold)

        }


    }
}

@Composable
fun DividerTextComponent(){
    Row(
        modifier = Modifier.fillMaxWidth(),
        verticalAlignment = Alignment.CenterVertically

    ) {
        
        Divider(modifier = Modifier
            .fillMaxWidth()
            .weight(1f),
            color = GrayColor,
            thickness = 1.dp
        )

        Text(text = "or", fontSize = 18.sp, color = TextColor)
        Divider(modifier = Modifier
            .fillMaxWidth()
            .weight(1f),
            color = GrayColor,
            thickness = 1.dp
        )
        
    }
}

@Composable
fun ClickableLoginTextComponent(tryToLogin: Boolean = true,onTextSelected: (String) -> Unit) {
    val initialText = if (tryToLogin) "Already have an account? " else "Don't have an account yet? "
    val loginText = if (tryToLogin) "Login " else "Register"

    val annotatedString = buildAnnotatedString {
        append(initialText)
        withStyle(style = SpanStyle(color = Primary)){
            pushStringAnnotation(tag = loginText, annotation = loginText)
            append(loginText)
        }

    }

    ClickableText(
        modifier = Modifier
            .fillMaxWidth()
            .heightIn(min = 40.dp),
        style = TextStyle(
            fontSize = 21.sp,
            fontWeight = FontWeight.Normal,
            fontStyle = FontStyle.Normal,
            textAlign = TextAlign.Center
        ),
        text = annotatedString , onClick = {offset ->

        annotatedString.getStringAnnotations(offset,offset)
            .firstOrNull()?.also {span->
                Log.d("ClickableTextComponent", "{$span}")

                if (span.item == loginText){
                    onTextSelected(span.item)
                }

            }

    })
}

@Composable
fun UnderlinedTextComponent(value:String){
    Text(text = value, modifier = Modifier
        .fillMaxWidth()
        .heightIn(min = 40.dp),
        style = TextStyle(
            fontSize = 18.sp,
            fontWeight = FontWeight.Normal,
            fontStyle = FontStyle.Normal
        )
        , color = colorResource(id = R.color.colorGray),
        textAlign = TextAlign.Center,
        textDecoration = TextDecoration.Underline
    )
}