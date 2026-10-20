package com.example.navigationapplicationandroid.ui.screens

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
//--------------------------------------/UI/------------------------------------------//
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ComponentListScreen(
    onComponentClick: (String) -> Unit = {} //Call back cho card
) {
    Scaffold(
        topBar = {
            CenterAlignedTopAppBar(
                title = {
                    Text(
                        text = "UI Components List",
                        fontWeight = FontWeight.Bold,
                        color = Color(85, 135, 250)
                    )
                }
            )
        }
    ) { innerPadding ->
        LazyColumn(
            modifier = Modifier
                .fillMaxSize()
                .padding(innerPadding)
                .padding(16.dp)
        ) {
            // ====/ Display /====
            item {
                SectionHeader(title = "Display")
            }
            item {
                ComponentCard(
                    title = "Text",
                    description = "Displays text",
                    bottomSpacing = 10.dp,
                    onClick = { onComponentClick("Text") }
                )
            }
            item {
                ComponentCard(
                    title = "Image",
                    description = "Displays an Image",
                    bottomSpacing = 10.dp,
                    onClick = { onComponentClick("Image") }
                )
            }
            item {
                ComponentCard(
                    title = "Icon",
                    description = "Displays a vector graphic icon",
                    bottomSpacing = 20.dp,
                    onClick = { onComponentClick("Icon") }
                )
            }

            // ====/ Input /====
            item {
                SectionHeader(title = "Input")
            }
            item {
                ComponentCard(
                    title = "Text Field",
                    description = "Input field for text",
                    bottomSpacing = 10.dp,
                    onClick = { onComponentClick("Text Field") }
                )
            }
            item {
                ComponentCard(
                    title = "Password Field",
                    description = "Input field for passwords",
                    bottomSpacing = 10.dp,
                    onClick = { onComponentClick("Password Field") }
                )
            }
            item {
                ComponentCard(
                    title = "Toggle / Switch",
                    description = "On/off switch",
                    bottomSpacing = 10.dp,
                    onClick = { onComponentClick("Toggle / Switch") }
                )
            }
            item {
                ComponentCard(
                    title = "Slider",
                    description = "Selects a value from a range",
                    bottomSpacing = 10.dp,
                    onClick = { onComponentClick("Slider") }
                )
            }
            item {
                ComponentCard(
                    title = "DatePicker",
                    description = "Selects a date and time",
                    bottomSpacing = 10.dp,
                    onClick = { onComponentClick("DatePicker") }
                )
            }
            item {
                ComponentCard(
                    title = "TimePicker",
                    description = "Selects a time of day",
                    bottomSpacing = 20.dp,
                    onClick = { onComponentClick("TimePicker") }
                )
            }

            // ====/ Layout /====
            item {
                SectionHeader(title = "Layout")
            }
            item {
                ComponentCard(
                    title = "Column",
                    description = "Arranges elements vertically",
                    bottomSpacing = 10.dp,
                    onClick = { onComponentClick("Column") }
                )
            }
            item {
                ComponentCard(
                    title = "Row",
                    description = "Arranges elements horizontally",
                    bottomSpacing = 10.dp,
                    onClick = { onComponentClick("Row") }
                )
            }
            item {
                ComponentCard(
                    title = "List (LazyColumn)",
                    description = "Displays a list of items",
                    bottomSpacing = 10.dp,
                    onClick = { onComponentClick("List (LazyColumn)") }
                )
            }
            item {
                ComponentCard(
                    title = "Divider / HorizontalDivider",
                    description = "Separates content into sections",
                    bottomSpacing = 10.dp,
                    onClick = { onComponentClick("Divider / HorizontalDivider") }
                )
            }
            item {
                ComponentCard(
                    title = "Box",
                    description = "Stacks elements on top of each other",
                    bottomSpacing = 20.dp,
                    onClick = { onComponentClick("Box") }
                )
            }

            // ====/ Selection /====
            item {
                SectionHeader(title = "Selection")
            }
            item {
                ComponentCard(
                    title = "Button",
                    description = "Triggers an action when tapped",
                    bottomSpacing = 10.dp,
                    onClick = { onComponentClick("Button") }
                )
            }
            item {
                ComponentCard(
                    title = "Checkbox",
                    description = "Allows user to select multiple options",
                    bottomSpacing = 10.dp,
                    onClick = { onComponentClick("Checkbox") }
                )
            }
            item {
                ComponentCard(
                    title = "Radio Button",
                    description = "Allows user to select a single option",
                    bottomSpacing = 10.dp,
                    onClick = { onComponentClick("Radio Button") }
                )
            }
            item {
                ComponentCard(
                    title = "Picker / ExposedDropdownMenu",
                    description = "Allows user to select an option from a list",
                    bottomSpacing = 20.dp,
                    onClick = { onComponentClick("Picker / ExposedDropdownMenu") }
                )
            }

            //====/ Navigation /====

            item { SectionHeader(title = "Navigation") }

            item {
                ComponentCard(
                    title = "NavigationView / TopAppBar",
                    description = "Navigation container with title and back button",
                    bottomSpacing = 10.dp,
                    onClick = { onComponentClick("NavigationView / TopAppBar") }
                )
            }
            item {
                ComponentCard(
                    title = "TabBar, TabRow",
                    description = "Switches between main sections",
                    bottomSpacing = 10.dp,
                    onClick = { onComponentClick("TabBar, TabRow") }
                )
            }
            item {
                ComponentCard(
                    title = "Menu / DropdownMenu / Drawer",
                    description = "Shows a menu with multiple actions",
                    bottomSpacing = 10.dp,
                    onClick = { onComponentClick("Menu / DropdownMenu / Drawer") }
                )
            }
            item {
                ComponentCard(
                    title = "Float Action Botton (FAB)",
                    description = "A button that appears at the bottom of the screen",
                    bottomSpacing = 20.dp,
                    onClick = { onComponentClick("Float Action Botton (FAB)") }

                )
            }

        }


    }
}

//----------------------------------------//LOGIC//----------------------------------------//
/**
 * Hàm dùng chung cho tiêu đề các nhóm (Display, Input, ...)
 */
@Composable
fun SectionHeader(title: String) {
    Column {
        Text(
            text = title,
            fontWeight = FontWeight.Bold,
            fontSize = 20.sp
        )
        Spacer(modifier = Modifier.height(10.dp))
    }
}

/**
 * Hàm Card tùy chỉnh riêng truyền Tên, Mô tả và Khoảng cách phía dưới
 */
@Composable
fun ComponentCard(
    title: String,
    description: String,
    bottomSpacing: Dp = 10.dp,
    onClick: () -> Unit = {}
) {
    Column {
        Card(
            modifier = Modifier
                .fillMaxWidth()
                .clickable { onClick() },
            colors = CardDefaults.cardColors(
                containerColor = Color(189, 217, 255)
            )
        ) {
            Column(modifier = Modifier.padding(10.dp)) {
                Text(
                    text = title,
                    fontWeight = FontWeight.Bold,
                    fontSize = 18.sp
                )
                Spacer(modifier = Modifier.height(1.dp))
                Text(text = description)
            }
        }
        Spacer(modifier = Modifier.height(bottomSpacing))
    }
}