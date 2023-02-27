package com.example.happybirthday

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.material.Icon
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.*
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight

import com.example.happybirthday.ui.theme.BusinessCardTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            BusinessCardTheme {
                // A surface container using the 'background' color from the theme
                Surface(modifier = Modifier.fillMaxSize(), color = MaterialTheme.colors.background) {
                    BusinessCardProfile(
                        name = "Yannic Fréson",
                        title = "Creative Developer"
                    )
                    BusinessCardDetails(
                        phone = "0470648712",
                        social = "twitter.com/yannicfreson",
                        email = "yannic@gmail.com"
                    )
                }
            }
        }
    }
}


@Composable
fun BusinessCardProfile(name: String, title: String) {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .fillMaxHeight(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        val image = painterResource(R.drawable.profilepicture)
        Image(
            painter = image,
            contentDescription = null,
            modifier = Modifier.padding(horizontal = 128.dp)
        )
        Text(
            text = name,
            fontSize = 36.sp,
            fontWeight = FontWeight.Black
        )
        Text(
            text = title,
            fontSize = 24.sp
        )
    }
}
@Composable
fun BusinessCardDetails(phone: String, social: String, email: String) {
Column(modifier = Modifier
    .fillMaxWidth()
    .fillMaxHeight()
    .padding(vertical = 128.dp)
) {
    Row(
        modifier = Modifier
            .padding(horizontal = 64.dp)
            .padding(vertical = 4.dp)
            .fillMaxWidth(),
        horizontalArrangement = Arrangement.SpaceBetween

    ) {
        Icon(Icons.Rounded.Phone, contentDescription = null, tint = Color.Green)
        Text(text = phone)

    }
    Row(
        modifier = Modifier
            .padding(horizontal = 64.dp)
            .padding(vertical = 4.dp)
            .fillMaxWidth(),
        horizontalArrangement = Arrangement.SpaceBetween

    ) {
        Icon(Icons.Rounded.Share, contentDescription = null, tint = Color.Green)
        Text(text = social)
    }
    Row(
        modifier = Modifier
            .padding(horizontal = 64.dp)
            .padding(vertical = 4.dp)
            .fillMaxWidth(),
        horizontalArrangement = Arrangement.SpaceBetween

    ) {
        Icon(Icons.Rounded.Email, contentDescription = null, tint = Color.Green)
        Text(text = email)
    }
}
}




@Preview(showBackground = true)
@Composable
fun BusinessCardPreview() {
    BusinessCardTheme {
        BusinessCardProfile(
            name = "Yannic Fréson",
            title = "Creative Developer"
        )
        BusinessCardDetails(
            phone = "0470648712",
            social = "twitter.com/yannicfreson",
            email = "yannic@gmail.com"
        )
    }
}
