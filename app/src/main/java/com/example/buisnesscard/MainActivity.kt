package com.example.buisnesscard

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Email
import androidx.compose.material.icons.filled.Phone
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.buisnesscard.ui.theme.BuisnessCardTheme


class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            BuisnessCardTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    BusinessCard(
                        "Pronin Aleksandr",
                        "Android Developer",
                        79655556677,
                        "makkurano@gmail.com",
                        "@komato",
                        R.drawable.photocard
                    )
                }
            }
        }
    }
}

@Composable
fun BusinessCard(
    name: String,
    title: String,
    phNumber: Long,
    email: String,
    socialAccount: String,
    imageResId: Int,
) {
    val image: Painter = painterResource(id = imageResId)
    val gradientColors = listOf(
        Color(0xFFE3B9EB).copy(alpha = 0.7f),
        Color(0xFFC3DABA).copy(alpha = 0.7f),
        Color(0xFFE4BBAF).copy(alpha = 0.7f)
    )
    Box(
        modifier = Modifier
            .fillMaxSize()
            .padding(9.dp)
            .border(2.dp, Color.Gray, shape = RoundedCornerShape(16.dp))
            .background(
                Brush.horizontalGradient(
                    colors = gradientColors,
                    startX = 0f,
                    endX = Float.POSITIVE_INFINITY
                ),
                shape = RoundedCornerShape(16.dp)
            )
    )
    {
        Column(
            Modifier
                .fillMaxHeight(),
            verticalArrangement = Arrangement.Top,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Image(
                painter = image,
                contentDescription = "Photo of $name with title $title",
                Modifier
                    .padding(0.dp, 40.dp)
                    .clip(RoundedCornerShape(16.dp))
                    .border(2.dp, Color.White, shape = RoundedCornerShape(16.dp))
            )
            Spacer(
                Modifier.height(10.dp)
            )
            Text(
                text = name,
                fontSize = 35.sp,
                fontWeight = FontWeight.Bold,
                fontStyle = FontStyle.Italic,
                lineHeight = 35.sp,
                textAlign = TextAlign.Center,
                softWrap = true,
                maxLines = 2
            )
            Text(
                text = title,
                fontSize = 30.sp,
                textAlign = TextAlign.Center,
                softWrap = true,
                maxLines = 2,
                color = Color.Gray,
                modifier = Modifier
                    .padding(0.dp, 0.dp, 0.dp, 18.dp)
            )
            Spacer(
                Modifier.height(20.dp)
            )
            Row(
                Modifier
                    .padding(18.dp, 0.dp, 0.dp, 15.dp),
                verticalAlignment = Alignment.CenterVertically
            ) {
                Icon(
                    imageVector = Icons.Default.Phone,
                    contentDescription = "Phone Icon",
                    tint = Color.DarkGray,
                    modifier = Modifier
                        .size(48.dp)
                        .align(Alignment.CenterVertically)
                )
                Spacer(
                    Modifier.width(20.dp)
                )
                Text(
                    text = "+$phNumber",
                    fontSize = 20.sp,
                    modifier = Modifier
                        .fillMaxWidth()
                        .align(Alignment.CenterVertically)
                        .padding(0.dp, 0.dp, 0.dp, 4.dp)
                )
            }
            Row(
                Modifier
                    .padding(18.dp, 0.dp, 0.dp, 15.dp),
                verticalAlignment = Alignment.CenterVertically
            ) {
                Icon(
                    imageVector = Icons.Default.Email,
                    contentDescription = "Email Icon",
                    tint = Color.DarkGray,
                    modifier = Modifier
                        .size(48.dp)
                        .align(Alignment.CenterVertically)
                )
                Spacer(
                    Modifier.width(20.dp)
                )
                Text(
                    text = email,
                    fontSize = 20.sp,
                    maxLines = 2,
                    modifier = Modifier
                        .fillMaxWidth()
                        .align(Alignment.CenterVertically)
                        .padding(0.dp, 0.dp, 0.dp, 5.dp)
                )
            }
            Row(
                Modifier
                    .padding(18.dp, 0.dp, 0.dp, 15.dp),
                verticalAlignment = Alignment.CenterVertically

            ) {
                Icon(
                    painter = painterResource(R.drawable.telegram),
                    contentDescription = "Telegram Icon",
                    tint = Color.DarkGray,
                    modifier = Modifier
                        .size(44.dp)
                        .align(Alignment.CenterVertically)
                )
                Spacer(
                    Modifier.width(20.dp)
                )
                Text(
                    text = socialAccount,
                    fontSize = 20.sp,
                    maxLines = 1,
                    modifier = Modifier
                        .fillMaxWidth()
                        .align(Alignment.CenterVertically)
                        .padding(0.dp, 0.dp, 0.dp, 5.dp)
                )
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun BusinessCardPreview() {
    BuisnessCardTheme {
        BusinessCard(
            "Pronin Aleksandr",
            "Android Developer",
            79655556677,
            "makkurano@gmail.com",
            "@komato",
            R.drawable.photocard
        )
    }
}