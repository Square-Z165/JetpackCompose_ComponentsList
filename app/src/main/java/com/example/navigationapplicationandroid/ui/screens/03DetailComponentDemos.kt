package com.example.navigationapplicationandroid.ui.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material.icons.filled.Settings
import androidx.compose.material3.Button
import androidx.compose.material3.Checkbox
import androidx.compose.material3.DatePicker
import androidx.compose.material3.DropdownMenu
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.ExposedDropdownMenuBox
import androidx.compose.material3.ExposedDropdownMenuDefaults
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.RadioButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Slider
import androidx.compose.material3.Switch
import androidx.compose.material3.Tab
import androidx.compose.material3.TabRow
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TimePicker
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.rememberDatePickerState
import androidx.compose.material3.rememberTimePickerState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableFloatStateOf
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

private val demoBlue = Color(85, 135, 250)

@Composable
fun ImagePlaceholder(title: String) {
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .height(120.dp)
            .border(1.dp, Color.LightGray, RoundedCornerShape(8.dp)),
        contentAlignment = Alignment.Center
    ) {
        Text(
            text = "$title — thêm ảnh sau",
            color = Color.Gray,
            fontSize = 13.sp,
            textAlign = TextAlign.Center,
            modifier = Modifier.padding(8.dp)
        )
    }
}

@Composable
fun IconComponent() {
    Row(
        modifier = Modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.SpaceEvenly
    ) {
        Icon(Icons.Default.Home, contentDescription = "Home", tint = demoBlue)
        Icon(Icons.Default.Favorite, contentDescription = "Favorite", tint = Color.Red)
        Icon(Icons.Default.Settings, contentDescription = "Settings", tint = Color.Gray)
        Icon(Icons.Default.Menu, contentDescription = "Menu", tint = demoBlue)
    }
}

@Composable
fun TextFieldComponent() {
    var text by remember { mutableStateOf("") }

    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp)
    ) {
        OutlinedTextField(
            value = text,
            onValueChange = { text = it },
            modifier = Modifier.fillMaxWidth(),
            placeholder = { Text("Thông tin nhập") },
            singleLine = true
        )
        Spacer(modifier = Modifier.height(8.dp))
        Text(
            text = text.ifEmpty { "Tự động cập nhật dữ liệu theo textfield" }
                .let { if (text.isEmpty()) it else "Bạn đã nhập: $text" },
            color = Color.Red,
            fontSize = 14.sp
        )
    }
}

@Composable
fun PasswordFieldComponent() {
    var password by remember { mutableStateOf("") }

    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp)
    ) {
        OutlinedTextField(
            value = password,
            onValueChange = { password = it },
            modifier = Modifier.fillMaxWidth(),
            label = { Text("Password") },
            placeholder = { Text("Nhập mật khẩu") },
            visualTransformation = PasswordVisualTransformation(),
            singleLine = true
        )
        if (password.isNotEmpty()) {
            Spacer(modifier = Modifier.height(8.dp))
            Text(text = "Độ dài: ${password.length} ký tự", fontSize = 14.sp)
        }
    }
}

@Composable
fun ToggleSwitchComponent() {
    var checked by remember { mutableStateOf(false) }

    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        Text(text = if (checked) "Bật" else "Tắt")
        Switch(checked = checked, onCheckedChange = { checked = it })
    }
}

@Composable
fun SliderComponent() {
    var value by remember { mutableFloatStateOf(0.5f) }

    Column(modifier = Modifier.padding(16.dp)) {
        Text(text = "Giá trị: ${"%.2f".format(value)}")
        Slider(
            value = value,
            onValueChange = { value = it },
            valueRange = 0f..1f
        )
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun DatePickerComponent() {
    val state = rememberDatePickerState()

    Column(
        modifier = Modifier
            .verticalScroll(rememberScrollState())
            .padding(8.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        DatePicker(state = state)
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TimePickerComponent() {
    val state = rememberTimePickerState()

    Column(
        modifier = Modifier.padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        TimePicker(state = state)
    }
}

@Composable
fun ColumnLayoutComponent() {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .verticalScroll(rememberScrollState())
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.spacedBy(12.dp)
    ) {
        ImagePlaceholder("Column")
        repeat(4) { index ->
            Box(
                modifier = Modifier
                    .fillMaxWidth(0.7f)
                    .height(48.dp)
                    .background(
                        demoBlue.copy(alpha = 0.35f + index * 0.12f),
                        RoundedCornerShape(12.dp)
                    )
            )
        }
    }
}

@Composable
fun RowLayoutComponent() {
    val shades = listOf(0.35f, 0.45f, 0.55f, 0.65f)

    Column(
        modifier = Modifier
            .fillMaxSize()
            .verticalScroll(rememberScrollState())
            .padding(16.dp),
        verticalArrangement = Arrangement.spacedBy(12.dp)
    ) {
        ImagePlaceholder("Row")
        repeat(4) { row ->
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.spacedBy(8.dp)
            ) {
                repeat(4) { col ->
                    Box(
                        modifier = Modifier
                            .weight(1f)
                            .height(56.dp)
                            .background(
                                demoBlue.copy(alpha = shades[(row + col) % shades.size]),
                                RoundedCornerShape(10.dp)
                            )
                    )
                }
            }
        }
    }
}

@Composable
fun LazyListComponent() {
    val items = (1..20).map { "Mục danh sách #$it" }

    LazyColumn(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        verticalArrangement = Arrangement.spacedBy(8.dp)
    ) {
        items(items) { item ->
            Text(
                text = item,
                modifier = Modifier
                    .fillMaxWidth()
                    .background(Color(189, 217, 255), RoundedCornerShape(8.dp))
                    .padding(12.dp)
            )
        }
    }
}

@Composable
fun DividerComponent() {
    Column(modifier = Modifier.padding(16.dp)) {
        Text("Phần trên")
        HorizontalDivider(modifier = Modifier.padding(vertical = 16.dp))
        Text("Phần dưới")
    }
}

@Composable
fun BoxLayoutComponent() {
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .height(160.dp)
            .padding(16.dp)
            .background(Color(189, 217, 255), RoundedCornerShape(12.dp)),
        contentAlignment = Alignment.Center
    ) {
        Text("Nền Box", color = Color.White)
        Box(
            modifier = Modifier
                .size(80.dp)
                .background(demoBlue, RoundedCornerShape(8.dp))
                .align(Alignment.TopEnd)
                .padding(8.dp)
        ) {
            Text("Chồng", color = Color.White, fontSize = 12.sp, modifier = Modifier.align(Alignment.Center))
        }
    }
}

@Composable
fun ButtonComponent() {
    Column(
        modifier = Modifier.padding(16.dp),
        verticalArrangement = Arrangement.spacedBy(12.dp)
    ) {
        Button(onClick = { }) { Text("Primary Button") }
        Button(onClick = { }, enabled = false) { Text("Disabled") }
    }
}

@Composable
fun CheckboxComponent() {
    var a by remember { mutableStateOf(true) }
    var b by remember { mutableStateOf(false) }

    Column(modifier = Modifier.padding(16.dp)) {
        Row(verticalAlignment = Alignment.CenterVertically) {
            Checkbox(checked = a, onCheckedChange = { a = it })
            Text("Tùy chọn A")
        }
        Row(verticalAlignment = Alignment.CenterVertically) {
            Checkbox(checked = b, onCheckedChange = { b = it })
            Text("Tùy chọn B")
        }
    }
}

@Composable
fun RadioButtonComponent() {
    val options = listOf("Một", "Hai", "Ba")
    var selected by remember { mutableStateOf(options.first()) }

    Column(modifier = Modifier.padding(16.dp)) {
        options.forEach { option ->
            Row(verticalAlignment = Alignment.CenterVertically) {
                RadioButton(
                    selected = selected == option,
                    onClick = { selected = option }
                )
                Text(option)
            }
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun PickerComponent() {
    val options = listOf("Android", "Kotlin", "Compose")
    var expanded by remember { mutableStateOf(false) }
    var selected by remember { mutableStateOf(options.first()) }

    ExposedDropdownMenuBox(
        expanded = expanded,
        onExpandedChange = { expanded = !expanded },
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp)
    ) {
        TextField(
            value = selected,
            onValueChange = {},
            readOnly = true,
            label = { Text("Chọn framework") },
            trailingIcon = { ExposedDropdownMenuDefaults.TrailingIcon(expanded = expanded) },
            modifier = Modifier
                .menuAnchor()
                .fillMaxWidth()
        )
        ExposedDropdownMenu(
            expanded = expanded,
            onDismissRequest = { expanded = false }
        ) {
            options.forEach { option ->
                DropdownMenuItem(
                    text = { Text(option) },
                    onClick = {
                        selected = option
                        expanded = false
                    }
                )
            }
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TopAppBarDemoComponent() {
    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text("TopAppBar demo") },
                navigationIcon = {
                    IconButton(onClick = { }) {
                        Icon(Icons.Default.Menu, contentDescription = "Menu")
                    }
                }
            )
        }
    ) { padding ->
        Box(
            modifier = Modifier
                .fillMaxSize()
                .padding(padding),
            contentAlignment = Alignment.Center
        ) {
            Text("NavigationView / TopAppBar")
        }
    }
}

@Composable
fun TabRowComponent() {
    val tabs = listOf("Tab 1", "Tab 2", "Tab 3")
    var selectedTab by remember { mutableIntStateOf(0) }

    Column(modifier = Modifier.fillMaxWidth()) {
        TabRow(selectedTabIndex = selectedTab) {
            tabs.forEachIndexed { index, title ->
                Tab(
                    selected = selectedTab == index,
                    onClick = { selectedTab = index },
                    text = { Text(title) }
                )
            }
        }
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .padding(24.dp),
            contentAlignment = Alignment.Center
        ) {
            Text("Nội dung ${tabs[selectedTab]}")
        }
    }
}

@Composable
fun MenuDropdownComponent() {
    var expanded by remember { mutableStateOf(false) }

    Box(modifier = Modifier.fillMaxWidth(), contentAlignment = Alignment.Center) {
        Button(onClick = { expanded = true }) {
            Text("Mở menu")
        }
        DropdownMenu(expanded = expanded, onDismissRequest = { expanded = false }) {
            DropdownMenuItem(
                text = { Text("Sao chép") },
                onClick = { expanded = false }
            )
            DropdownMenuItem(
                text = { Text("Chia sẻ") },
                onClick = { expanded = false }
            )
        }
    }
}

@Composable
fun FabComponent() {
    Scaffold(
        floatingActionButton = {
            FloatingActionButton(onClick = { }) {
                Icon(Icons.Default.Add, contentDescription = "Add")
            }
        }
    ) { padding ->
        Box(
            modifier = Modifier
                .fillMaxSize()
                .padding(padding),
            contentAlignment = Alignment.Center
        ) {
            Text("Floating Action Button ở góc dưới")
        }
    }
}
