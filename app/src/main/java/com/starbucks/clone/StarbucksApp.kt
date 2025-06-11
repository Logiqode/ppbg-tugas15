package com.starbucks.clone

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.starbucks.clone.ui.theme.*

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun StarbucksApp() {
    Scaffold(
        bottomBar = { BottomNavigationBar() },
        floatingActionButton = { PayButton() },
        floatingActionButtonPosition = FabPosition.End
    ) { paddingValues ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(paddingValues)
                .verticalScroll(rememberScrollState())
                .background(Color.White)
        ) {
            TopHeader()
            QuickActionButtons()
            StarBalanceSection()
            ActionButtons()
            Spacer(modifier = Modifier.height(24.dp))
            ProgramsAndPromotionSection()
            PromotionalCard()
            Spacer(modifier = Modifier.height(24.dp))
            StarbucksNewsSection()
            Spacer(modifier = Modifier.height(100.dp)) // Space for bottom nav
        }
    }
}

@Composable
fun TopHeader() {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp),
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.Top
    ) {
        Column {
            Text(
                text = "Good Afternoon,",
                style = MaterialTheme.typography.titleLarge,
                color = Color.Black
            )
            Text(
                text = "Jeremy",
                style = MaterialTheme.typography.titleLarge,
                color = Color.Black,
                fontWeight = FontWeight.Bold
            )
        }
        Text(
            text = "Green Level",
            style = MaterialTheme.typography.titleMedium,
            color = StarbucksGreen,
            fontWeight = FontWeight.SemiBold
        )
    }
}

@Composable
fun QuickActionButtons() {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 16.dp),
        horizontalArrangement = Arrangement.SpaceEvenly
    ) {
        QuickActionButton(
            icon = Icons.Default.Person,
            label = "Profile",
            modifier = Modifier.weight(1f)
        )
        Spacer(modifier = Modifier.width(16.dp))
        QuickActionButton(
            icon = Icons.Default.Email,
            label = "Inbox",
            modifier = Modifier.weight(1f)
        )
        Spacer(modifier = Modifier.width(16.dp))
        QuickActionButton(
            icon = Icons.Default.LocalOffer,
            label = "E-Code",
            modifier = Modifier.weight(1f)
        )
    }
}

@Composable
fun QuickActionButton(
    icon: ImageVector,
    label: String,
    modifier: Modifier = Modifier
) {
    Column(
        modifier = modifier,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Card(
            modifier = Modifier.size(48.dp),
            shape = RoundedCornerShape(12.dp),
            colors = CardDefaults.cardColors(containerColor = LightGray)
        ) {
            Box(
                modifier = Modifier.fillMaxSize(),
                contentAlignment = Alignment.Center
            ) {
                Icon(
                    imageVector = icon,
                    contentDescription = label,
                    tint = DarkGray,
                    modifier = Modifier.size(24.dp)
                )
            }
        }
        Spacer(modifier = Modifier.height(8.dp))
        Text(
            text = label,
            style = MaterialTheme.typography.bodySmall,
            color = Color.Black
        )
    }
}

@Composable
fun StarBalanceSection() {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp)
    ) {
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Row(verticalAlignment = Alignment.CenterVertically) {
                Text(
                    text = "0",
                    style = MaterialTheme.typography.displayMedium,
                    color = Color.Black,
                    fontWeight = FontWeight.Bold
                )
                Icon(
                    imageVector = Icons.Default.Star,
                    contentDescription = "Star",
                    tint = StarbucksGreen,
                    modifier = Modifier
                        .size(32.dp)
                        .padding(start = 4.dp)
                )
            }
            Row(
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text(
                    text = "Rewards details",
                    style = MaterialTheme.typography.bodyMedium,
                    color = Color.Black
                )
                Icon(
                    imageVector = Icons.Default.ChevronRight,
                    contentDescription = "Arrow",
                    tint = Color.Black,
                    modifier = Modifier.size(20.dp)
                )
            }
        }
        
        Spacer(modifier = Modifier.height(8.dp))
        
        Text(
            text = "Star balance",
            style = MaterialTheme.typography.bodySmall,
            color = DarkGray
        )
        
        Spacer(modifier = Modifier.height(16.dp))
        
        // Progress bar
        ProgressBar()
    }
}

@Composable
fun ProgressBar() {
    val progressValues = listOf(30, 60, 120, 240, 400)
    
    Column {
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .height(8.dp)
        ) {
            // Background track
            Box(
                modifier = Modifier
                    .fillMaxSize()
                    .background(
                        color = LightGray,
                        shape = RoundedCornerShape(4.dp)
                    )
            )
            
            // Progress indicator (currently at 0)
            Box(
                modifier = Modifier
                    .size(12.dp)
                    .background(
                        color = StarbucksGreen,
                        shape = CircleShape
                    )
                    .align(Alignment.CenterStart)
            )
        }
        
        Spacer(modifier = Modifier.height(8.dp))
        
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            progressValues.forEach { value ->
                Text(
                    text = value.toString(),
                    style = MaterialTheme.typography.bodySmall,
                    color = DarkGray
                )
            }
        }
    }
}

@Composable
fun ActionButtons() {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 16.dp),
        horizontalArrangement = Arrangement.spacedBy(12.dp)
    ) {
        OutlinedButton(
            onClick = { },
            modifier = Modifier.weight(1f),
            colors = ButtonDefaults.outlinedButtonColors(
                contentColor = StarbucksGreen
            ),
            border = androidx.compose.foundation.BorderStroke(1.dp, StarbucksGreen)
        ) {
            Text("Details")
        }
        
        Button(
            onClick = { },
            modifier = Modifier.weight(1f),
            colors = ButtonDefaults.buttonColors(
                containerColor = Color.Black,
                contentColor = Color.White
            )
        ) {
            Icon(
                imageVector = Icons.Default.Star,
                contentDescription = "Star",
                modifier = Modifier.size(16.dp)
            )
            Spacer(modifier = Modifier.width(4.dp))
            Text("Redeem")
        }
    }
}

@Composable
fun ProgramsAndPromotionSection() {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 16.dp),
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically
    ) {
        Text(
            text = "Programs and Promotion",
            style = MaterialTheme.typography.titleMedium,
            color = Color.Black,
            fontWeight = FontWeight.SemiBold
        )
        Text(
            text = "See All",
            style = MaterialTheme.typography.bodyMedium,
            color = StarbucksGreen,
            fontWeight = FontWeight.Medium
        )
    }
}

@Composable
fun PromotionalCard() {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp)
            .height(200.dp),
        shape = RoundedCornerShape(16.dp)
    ) {
        Box(
            modifier = Modifier
                .fillMaxSize()
                .background(
                    brush = Brush.horizontalGradient(
                        colors = listOf(
                            OrangeGradientStart,
                            YellowGradient,
                            OrangeGradientEnd
                        )
                    )
                )
        ) {
            Row(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(16.dp),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                // Left side with phone and coffee cup placeholder
                Box(
                    modifier = Modifier
                        .size(120.dp)
                        .background(
                            color = Color.White.copy(alpha = 0.3f),
                            shape = RoundedCornerShape(12.dp)
                        )
                ) {
                    // Placeholder for phone and coffee image
                    Icon(
                        imageVector = Icons.Default.Coffee,
                        contentDescription = "Coffee",
                        modifier = Modifier
                            .size(60.dp)
                            .align(Alignment.Center),
                        tint = Color.White
                    )
                }
                
                // Right side with text
                Column(
                    modifier = Modifier.weight(1f).padding(start = 16.dp),
                    verticalArrangement = Arrangement.Center
                ) {
                    Text(
                        text = "STARBUCKS",
                        style = MaterialTheme.typography.labelSmall,
                        color = Color.Black,
                        fontWeight = FontWeight.Bold
                    )
                    Text(
                        text = "REWARDS",
                        style = MaterialTheme.typography.labelSmall,
                        color = Color.Black,
                        fontWeight = FontWeight.Bold
                    )
                    
                    Spacer(modifier = Modifier.height(8.dp))
                    
                    Text(
                        text = "COFFEE TREAT",
                        style = MaterialTheme.typography.titleLarge,
                        color = StarbucksGreen,
                        fontWeight = FontWeight.Bold
                    )
                    Text(
                        text = "repeat",
                        style = MaterialTheme.typography.titleMedium,
                        color = StarbucksGreen,
                        fontWeight = FontWeight.Normal
                    )
                    
                    Spacer(modifier = Modifier.height(8.dp))
                    
                    Card(
                        colors = CardDefaults.cardColors(containerColor = StarbucksGreen),
                        shape = RoundedCornerShape(8.dp)
                    ) {
                        Column(
                            modifier = Modifier.padding(8.dp)
                        ) {
                            Text(
                                text = "GET 30% OFF REWARD*",
                                style = MaterialTheme.typography.bodySmall,
                                color = Color.White,
                                fontWeight = FontWeight.Bold
                            )
                            Text(
                                text = "UPON YOUR PURCHASE",
                                style = MaterialTheme.typography.bodySmall,
                                color = Color.White,
                                fontWeight = FontWeight.Bold
                            )
                        }
                    }
                }
            }
        }
    }
}

@Composable
fun StarbucksNewsSection() {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 16.dp)
    ) {
        Text(
            text = "Starbucks News",
            style = MaterialTheme.typography.titleMedium,
            color = Color.Black,
            fontWeight = FontWeight.SemiBold
        )
        
        Spacer(modifier = Modifier.height(12.dp))
        
        Row(
            modifier = Modifier.fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically
        ) {
            // News image placeholder
            Box(
                modifier = Modifier
                    .size(80.dp)
                    .background(
                        color = LightGray,
                        shape = RoundedCornerShape(8.dp)
                    )
            ) {
                Icon(
                    imageVector = Icons.Default.Coffee,
                    contentDescription = "Coffee beans",
                    modifier = Modifier
                        .size(40.dp)
                        .align(Alignment.Center),
                    tint = DarkGray
                )
            }
            
            Spacer(modifier = Modifier.width(12.dp))
            
            Column(
                modifier = Modifier.weight(1f)
            ) {
                Text(
                    text = "Tanggapan Starbucks mengenai",
                    style = MaterialTheme.typography.bodyMedium,
                    color = DarkGray
                )
                Text(
                    text = "TRUTH MATTERS",
                    style = MaterialTheme.typography.titleSmall,
                    color = Color.Black,
                    fontWeight = FontWeight.Bold
                )
            }
        }
    }
}

@Composable
fun PayButton() {
    FloatingActionButton(
        onClick = { },
        containerColor = StarbucksGreen,
        contentColor = Color.White,
        modifier = Modifier.size(64.dp)
    ) {
        Text(
            text = "Pay",
            style = MaterialTheme.typography.titleSmall,
            fontWeight = FontWeight.Bold
        )
    }
}

@Composable
fun BottomNavigationBar() {
    NavigationBar(
        containerColor = Color.White,
        contentColor = DarkGray
    ) {
        val items = listOf(
            BottomNavItem("Home", Icons.Default.Home, true),
            BottomNavItem("Card", Icons.Default.CreditCard, false),
            BottomNavItem("Order", Icons.Default.ShoppingCart, false),
            BottomNavItem("Reward", Icons.Default.Star, false),
            BottomNavItem("Store", Icons.Default.Store, false)
        )
        
        items.forEach { item ->
            NavigationBarItem(
                icon = {
                    Icon(
                        imageVector = item.icon,
                        contentDescription = item.label,
                        modifier = Modifier.size(24.dp)
                    )
                },
                label = {
                    Text(
                        text = item.label,
                        style = MaterialTheme.typography.labelSmall
                    )
                },
                selected = item.selected,
                onClick = { },
                colors = NavigationBarItemDefaults.colors(
                    selectedIconColor = StarbucksGreen,
                    selectedTextColor = StarbucksGreen,
                    unselectedIconColor = DarkGray,
                    unselectedTextColor = DarkGray,
                    indicatorColor = Color.Transparent
                )
            )
        }
    }
}

data class BottomNavItem(
    val label: String,
    val icon: ImageVector,
    val selected: Boolean
)

