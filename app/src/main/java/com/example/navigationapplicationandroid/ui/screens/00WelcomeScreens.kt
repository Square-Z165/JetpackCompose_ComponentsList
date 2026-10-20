package com.example.navigationapplicationandroid.ui.screens


import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.navigationapplicationandroid.R

@Composable
fun WelcomeScreen(
    onReadyClick: () -> Unit = {},
    onBackClick: () -> Unit = {},
) {
    Surface( // Nền cho màn hình
        modifier = Modifier.fillMaxSize(), // Ép Surface bung toàn màn hình
        color = MaterialTheme.colorScheme.background // Phủ nền Surface theo thiết lập hệ thống
    ) {
            Column(
                modifier = Modifier.fillMaxSize().padding(all = 16.dp), // padding đê tránh bị lẹm
                verticalArrangement = Arrangement.Center, // Căn chính giữa theo chiều dọc điện thoại
                horizontalAlignment = Alignment.CenterHorizontally // Căn chính giữa theo chiều ngang đt
            ) {
                Spacer(modifier = Modifier.height(80.dp))

                // 01. Logo
                Image(
                    painter = painterResource(id = R.drawable.jetpack_compose_icon),
                    contentDescription = "Logo jetpack compose"
                )

                Spacer(modifier = Modifier.height(50.dp)) // Flutter dùng Sizebox

                //02. Tiêu đề
                Text(
                    text = "Jetpack Compose",
                    fontSize = 25.sp,  // *DP và SP
                    fontWeight = FontWeight.ExtraBold
                )

                Spacer(modifier = Modifier.height(15.dp))

                //03. Subtitle
                Text(
                    textAlign = TextAlign.Center,
                    text = "Jetpack Compose is a modern UI toolkit for building native Android " +
                            "application using a declarative programming approach.",
                    fontSize = 12.sp,
                    fontWeight = FontWeight.Normal,

                )

                Spacer(modifier = Modifier.weight(1f)) // đẩy button xuống dưới cùng

                //04.Button
                Button(
                    onClick = { onReadyClick()
                    },
                    modifier = Modifier.fillMaxWidth(),
                    colors = ButtonDefaults.buttonColors(
                        containerColor = Color(85, 135, 250)
                    ),
                ) {
                    Text(
                        text = "I'm ready!",
                        fontSize = 25.sp,
                        fontWeight = FontWeight.Bold
                    )
                }
            }

    }

}
@Preview(showBackground = true, showSystemUi = true)
@Composable
fun ShowPreview() {
    WelcomeScreen()
}