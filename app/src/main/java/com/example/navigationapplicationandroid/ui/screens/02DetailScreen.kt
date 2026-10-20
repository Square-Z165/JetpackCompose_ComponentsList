package com.example.navigationapplicationandroid.ui.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.AsyncImage
import com.example.navigationapplicationandroid.R

private const val NETWORK_IMAGE_URL =
    "https://gtvtthanhpho.edu.vn/wp-content/uploads/2023/01/Logo-GTVT.png"

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun DetailScreen(
    componentTitle: String,
    onReadyClick: () -> Unit = {}
) {
    Scaffold(
        topBar = {
            CenterAlignedTopAppBar(
                title = {
                    Text(
                        text = "$componentTitle Detail",
                        fontWeight = FontWeight.Bold,
                        color = Color(85, 135, 250)
                    )
                },
                navigationIcon = {
                    IconButton(onClick = onReadyClick) {
                        Icon(
                            imageVector = Icons.AutoMirrored.Filled.ArrowBack,
                            contentDescription = "Back",
                            tint = Color(85, 135, 250)
                        )
                    }
                }
            )
        }
    ) { innerPadding ->
        Box(
            modifier = Modifier
                .fillMaxSize()
                .padding(innerPadding)
        ) {
            when (componentTitle) {
                "Text" -> Box(Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
                    TextComponent()
                }
                "Image" -> ImageComponent()
                "Icon" -> Box(Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
                    IconComponent()
                }
                "Text Field" -> TextFieldComponent()
                "Password Field" -> PasswordFieldComponent()
                "Toggle / Switch" -> Box(Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
                    ToggleSwitchComponent()
                }
                "Slider" -> Box(Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
                    SliderComponent()
                }
                "DatePicker" -> DatePickerComponent()
                "TimePicker" -> TimePickerComponent()
                "Column" -> ColumnLayoutComponent()
                "Row" -> RowLayoutComponent()
                "List (LazyColumn)" -> LazyListComponent()
                "Divider / HorizontalDivider" -> Box(Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
                    DividerComponent()
                }
                "Box" -> Box(Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
                    BoxLayoutComponent()
                }
                "Button" -> Box(Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
                    ButtonComponent()
                }
                "Checkbox" -> Box(Modifier.fillMaxSize(), contentAlignment = Alignment.TopCenter) {
                    CheckboxComponent()
                }
                "Radio Button" -> Box(Modifier.fillMaxSize(), contentAlignment = Alignment.TopCenter) {
                    RadioButtonComponent()
                }
                "Picker / ExposedDropdownMenu" -> PickerComponent()
                "NavigationView / TopAppBar" -> TopAppBarDemoComponent()
                "TabBar, TabRow" -> TabRowComponent()
                "Menu / DropdownMenu / Drawer" -> Box(Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
                    MenuDropdownComponent()
                }
                "Float Action Botton (FAB)" -> FabComponent()
                else -> Box(Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
                    Text(text = "Chưa có demo: $componentTitle")
                }
            }
        }
    }
}

@Composable
fun TextComponent() {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(10.dp),
        colors = CardDefaults.cardColors(containerColor = Color.White),
        elevation = CardDefaults.cardElevation()
    ) {
        StyledTextDemo()
    }
}

@Composable
fun StyledTextDemo() {
    val multiStyleText = buildAnnotatedString {
        append("The ")
        withStyle(style = SpanStyle(textDecoration = TextDecoration.LineThrough)) {
            append("quick")
        }
        append(" ")
        withStyle(style = SpanStyle(color = Color(0xFFC79100), fontWeight = FontWeight.Bold)) {
            append("Brown")
        }
        append(" fox j u m p s ")
        withStyle(style = SpanStyle(fontWeight = FontWeight.Bold, fontStyle = FontStyle.Italic)) {
            append("over")
        }
        append(" ")
        withStyle(style = SpanStyle(textDecoration = TextDecoration.Underline)) {
            append("the")
        }
        append(" ")
        withStyle(style = SpanStyle(fontFamily = FontFamily.Cursive)) {
            append("lazy")
        }
        append(" dog.")
    }

    Text(text = multiStyleText, fontSize = 28.sp, modifier = Modifier.padding(12.dp))
}

@Composable
fun ImageComponent() {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .verticalScroll(rememberScrollState())
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Card(
            modifier = Modifier
                .fillMaxWidth()
                .height(200.dp),
            shape = RoundedCornerShape(12.dp),
            elevation = CardDefaults.cardElevation(defaultElevation = 4.dp)
        ) {
            AsyncImage(
                model = NETWORK_IMAGE_URL,
                contentDescription = "Ảnh từ internet — GTVT",
                contentScale = ContentScale.Crop,
                modifier = Modifier.fillMaxSize()
            )
        }

        Spacer(modifier = Modifier.height(6.dp))

        Text(
            text = NETWORK_IMAGE_URL,
            fontSize = 11.sp,
            textAlign = TextAlign.Center,
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 8.dp)
        )

        Spacer(modifier = Modifier.height(24.dp))

        Card(
            modifier = Modifier
                .fillMaxWidth()
                .height(200.dp),
            shape = RoundedCornerShape(12.dp),
            elevation = CardDefaults.cardElevation(defaultElevation = 4.dp)
        ) {
            Image(
                painter = painterResource(id = R.drawable.pickinapp),
                contentScale = ContentScale.Crop,
                contentDescription = "Ảnh trong app",
                modifier = Modifier.fillMaxSize()
            )
        }

        Spacer(modifier = Modifier.height(8.dp))

        Text(
            text = "In app",
            fontSize = 14.sp,
            color = Color.Black,
            textAlign = TextAlign.Center
        )
    }
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun DetailScreenPreview() {
    DetailScreen(componentTitle = "Image")
}
