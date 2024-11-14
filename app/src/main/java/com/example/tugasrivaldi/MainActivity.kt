package com.example.tugasrivaldi

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.List
import androidx.compose.material.icons.filled.Person
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.tugasrivaldi.ui.theme.TugasRIVALDITheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            TugasRIVALDITheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    MainScreen(modifier = Modifier.padding(innerPadding))
                }
            }
        }
    }
}

@Composable
fun TopBar() {
    Surface(
        modifier = Modifier
            .fillMaxWidth()
            .height(56.dp),
        color = Color(0xFF35C2AA)
    ) {
        Box(
            modifier = Modifier
                .fillMaxSize()
                .padding(horizontal = 16.dp),
            contentAlignment = Alignment.Center
        ) {
            Text(
                text = "Mobil LOVERS",
                color = Color.White,
                fontSize = 20.sp,
                fontWeight = FontWeight.Bold
            )
        }
    }
}

@Composable
fun MainScreen(modifier: Modifier = Modifier) {
    var selectedTab by remember { mutableStateOf(0) }

    Scaffold(
        modifier = modifier.fillMaxSize(),
        bottomBar = {
            BottomNavigationBar(
                selectedTab = selectedTab,
                onTabSelected = { selectedTab = it }
            )
        }
    ) { innerPadding ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(innerPadding)
        ) {
            TopBar()
            when (selectedTab) {
                0 -> HomeScreen()
                1 -> DetailMobil()
                2 -> ProfilScreen()
            }
        }
    }
}

@Composable
fun HomeScreen() {
    val contoh1Names = listOf(
        "Toyota Crown", "Chrysler", "Datsun 510", "Morris Minor", "Suzuki Carry",
        "Dodge Charger", "Carry Futura", "Suzuki Vitara", "Chevrolet", "Toyota Kijang"
    )

    val mobilSportNames = listOf(
        "Ferrari", "Lamborghini", "Porsche", "McLaren", "Bugatti",
        "Aston Martin", "Maserati", "Koenigsegg", "Pagani", "Bentley"
    )

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
    ) {
        Text(
            text = "Selamat datang Pecinta Mobil",
            fontSize = 24.sp,
            fontWeight = FontWeight.Bold,
            color = Color.Black,
            modifier = Modifier.padding(bottom = 16.dp)
        )

        Text("Mobil Jadul", fontSize = 20.sp, color = Color.Black)

        LazyRow(
            modifier = Modifier.padding(vertical = 8.dp),
            horizontalArrangement = Arrangement.spacedBy(8.dp)
        ) {
            items(10) { index ->
                val imageResId = when (index) {
                    0 -> R.drawable.mobil1
                    1 -> R.drawable.mobil2
                    2 -> R.drawable.mobil3
                    3 -> R.drawable.mobil4
                    4 -> R.drawable.mobil5
                    5 -> R.drawable.mobil6
                    6 -> R.drawable.mobil7
                    7 -> R.drawable.mobil8
                    8 -> R.drawable.mobil9
                    9 -> R.drawable.mobil10
                    else -> return@items
                }
                val label = contoh1Names[index]
                Contoh1Item(imageResId = imageResId, label = label)
            }
        }

        Spacer(modifier = Modifier.height(16.dp))

        Text("Mobil Sport Terbaru", fontSize = 20.sp, color = Color.Black)

        LazyColumn(
            modifier = Modifier.padding(vertical = 8.dp),
            verticalArrangement = Arrangement.spacedBy(8.dp)
        ) {
            items(10) { index ->
                val imageResId = when (index) {
                    0 -> R.drawable.mobila
                    1 -> R.drawable.mobilb
                    2 -> R.drawable.mobilc
                    3 -> R.drawable.mobild
                    4 -> R.drawable.mobile
                    5 -> R.drawable.mobilf
                    6 -> R.drawable.mobilg
                    7 -> R.drawable.mobilh
                    8 -> R.drawable.mobili
                    9 -> R.drawable.mobilj
                    else -> return@items
                }
                val label = mobilSportNames[index]
                Contoh2Item(imageResId = imageResId, label = label)
            }
        }
    }
}

@Composable
fun DetailMobil() {
    val mobilSportNames = listOf(
        "Ferrari", "Lamborghini", "Porsche", "McLaren", "Bugatti",
        "Aston Martin", "Maserati", "Koenigsegg", "Pagani", "Bentley"
    )

    LazyVerticalGrid(
        columns = GridCells.Fixed(2),
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        verticalArrangement = Arrangement.spacedBy(8.dp),
        horizontalArrangement = Arrangement.spacedBy(8.dp)
    ) {
        items(10) { index ->
            val imageResId = when (index) {
                0 -> R.drawable.mobila
                1 -> R.drawable.mobilb
                2 -> R.drawable.mobilc
                3 -> R.drawable.mobild
                4 -> R.drawable.mobile
                5 -> R.drawable.mobilf
                6 -> R.drawable.mobilg
                7 -> R.drawable.mobilh
                8 -> R.drawable.mobili
                9 -> R.drawable.mobilj
                else -> return@items
            }
            val label = mobilSportNames[index]
            MobilItem(imageResId = imageResId, label = label)
        }
    }
}

@Composable
fun MobilItem(imageResId: Int, label: String) {
    TODO("Not yet implemented")
}

@Composable
fun ProfilScreen() {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Image(
            painter = painterResource(id = R.drawable.profil),
            contentDescription = "Profile Picture",
            contentScale = ContentScale.Crop,
            modifier = Modifier
                .size(100.dp)
                .background(Color.Gray, RoundedCornerShape(50))
        )
        Spacer(modifier = Modifier.height(16.dp))
        Text(
            text = "Rivaldi Andriano Situmorang",
            fontSize = 24.sp,
            fontWeight = FontWeight.Bold,
            color = Color.Black
        )
        Text(
            text = "Politeknik Negeri Batam",
            fontSize = 24.sp,
            fontWeight = FontWeight.Bold,
            color = Color.Black
        )
        Text(
            text = "Teknik Informatika",
            fontSize = 24.sp,
            fontWeight = FontWeight.Bold,
            color = Color.Black
        )
        Text(
            text = "rivaldisitumorang@gmail.com",
            fontSize = 16.sp,
            color = Color.Gray
        )
    }
}

@Composable
fun BottomNavigationBar(selectedTab: Int, onTabSelected: (Int) -> Unit) {
    NavigationBar(
        containerColor = Color(0xFF35C2AA)
    ) {
        NavigationBarItem(
            icon = { Icon(Icons.Filled.Home, contentDescription = "Home") },
            label = { Text("Home") },
            selected = selectedTab == 0,
            onClick = { onTabSelected(0) }
        )
        NavigationBarItem(
            icon = { Icon(Icons.Filled.List, contentDescription = "Daftar") },
            label = { Text("Daftar") },
            selected = selectedTab == 1,
            onClick = { onTabSelected(1) }
        )
        NavigationBarItem(
            icon = { Icon(Icons.Filled.Person, contentDescription = "Profil") },
            label = { Text("Profil") },
            selected = selectedTab == 2,
            onClick = { onTabSelected(2) }
        )
    }
}

@Composable
fun Contoh1Item(imageResId: Int, label: String) {
    Box(
        contentAlignment = Alignment.BottomCenter,
        modifier = Modifier
            .width(120.dp)
            .height(160.dp)
            .background(Color.Gray, RoundedCornerShape(16.dp))
    ) {
        Image(
            painter = painterResource(id = imageResId),
            contentDescription = label,
            modifier = Modifier.fillMaxSize(),
            contentScale = ContentScale.Crop
        )
        Text(
            text = label,
            color = Color.White,
            fontWeight = FontWeight.Bold,
            modifier = Modifier
                .background(Color(0x99000000), RoundedCornerShape(16.dp))
                .padding(8.dp)
        )
    }
}

@Composable
fun Contoh2Item(imageResId: Int, label: String) {
    Box(
        contentAlignment = Alignment.BottomCenter,
        modifier = Modifier
            .fillMaxWidth()
            .height(200.dp)
            .background(Color.Gray, RoundedCornerShape(16.dp))
    ) {
        Image(
            painter = painterResource(id = imageResId),
            contentDescription = label,
            modifier = Modifier.fillMaxSize(),
            contentScale = ContentScale.Crop
        )
        Text(
            text = label,
            color = Color.White,
            fontWeight = FontWeight.Bold,
            modifier = Modifier
                .background(Color(0x99000000), RoundedCornerShape(16.dp))
                .padding(8.dp)
        )
    }
}
