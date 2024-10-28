package com.example.apartmentmanager3

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.apartmentmanager3.ui.theme.*



@Composable
fun LoginPage(
    modifier: Modifier = Modifier,
    onLoginClick: () -> Unit
) {
    var username by rememberSaveable { mutableStateOf("") }
    var password by rememberSaveable { mutableStateOf("") }
    val filled = username.isNotEmpty() && password.isNotEmpty()

    Column(
        modifier = modifier.fillMaxSize()
    ) {
        // Ảnh nền phía trên, chiếm 25% chiều cao
        Image(
            painter = painterResource(id = R.drawable.login_background),
            contentDescription = null,
            contentScale = ContentScale.Crop,
            modifier = Modifier
                .fillMaxWidth()
                .fillMaxHeight(0.25f)
        )

        // Giao diện đăng nhập chiếm 75% chiều cao, bắt đầu từ 25% chiều cao
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .fillMaxHeight()
                .background(Background),
            verticalArrangement = Arrangement.Top,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(
                text = "Welcome to Apartment!",
                modifier = Modifier.padding(top = 80.dp, bottom = 40.dp),
                fontFamily = FontFamily.SansSerif,
                style = MaterialTheme.typography.headlineLarge
            )

            // Trường nhập tên đăng nhập và mật khẩu
            UsernameBar(username = username, onUsernameChange = { username = it })

            PasswordBar(password = password, onPasswordChange = { password = it })

            // Các nút đăng nhập và đăng ký
            Row(
                modifier = Modifier.fillMaxWidth().padding(vertical = 10.dp),
                horizontalArrangement = Arrangement.SpaceAround
            ) {
                OutlinedButton(
                    onClick = {}
                ) {
                    Text("Sign up")
                }

                Button(
                    onClick = onLoginClick,
                    enabled = filled
                ) {
                    Text("Sign in")
                }
            }
            Text(
                text = "Forgot password?",
                modifier = Modifier.padding(top = 10.dp),
                color = Blue,
                fontFamily = FontFamily.SansSerif,
                style = MaterialTheme.typography.bodySmall
            )
        }
    }
}


//Trường nhập tên đăng nhập
@Composable
private fun UsernameBar(username: String, modifier: Modifier = Modifier, onUsernameChange: (String) -> Unit) {
    TextField(
        shape = ShapeDefaults.ExtraLarge,
        value = username,
        onValueChange = onUsernameChange,
        placeholder = { Text("Your username...") },
        label = { Text("Username") },
        singleLine = true,
        colors = TextFieldDefaults.colors(
            unfocusedContainerColor = LightBlue_TextField,
            focusedContainerColor = Blue_TextField,
            unfocusedIndicatorColor = Color.Transparent,
            focusedIndicatorColor = Color.Transparent
        ),
        modifier = modifier.padding(vertical = 10.dp)
    )
}


//Trường nhập mật khẩu
@Composable
private fun PasswordBar(password: String, modifier: Modifier = Modifier, onPasswordChange: (String) -> Unit) {
    TextField(
        shape = ShapeDefaults.ExtraLarge,
        value = password,
        onValueChange = onPasswordChange,
        placeholder = { Text("Your password...") },
        label = { Text("Password") },
        singleLine = true,
        colors = TextFieldDefaults.colors(
            unfocusedContainerColor = LightBlue_TextField,
            focusedContainerColor = Blue_TextField,
            unfocusedIndicatorColor = Color.Transparent,
            focusedIndicatorColor = Color.Transparent
        ),
        modifier = modifier.padding(vertical = 10.dp)
    )
}



@Preview(showBackground = true)
@Composable
fun LoginPreview() {
    ApartmentManager3Theme {
        LoginPage(onLoginClick = {})
    }
}