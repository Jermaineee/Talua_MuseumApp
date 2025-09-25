package ph.edu.comteq.talua_lab3

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.foundation.layout.statusBarsPadding

@Composable
fun ExploreScreen(onBackClick: () -> Unit, onTicketingClick: () -> Unit) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.Black)
            .statusBarsPadding()
            .padding(16.dp)
            .verticalScroll(rememberScrollState())
    ) {

        Text(
            "Explore",
            fontSize = 28.sp,
            color = Color(0xFFFFD700),
            fontWeight = FontWeight.Bold
        )

        Spacer(modifier = Modifier.height(20.dp))


        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text(
                "Upcoming Events",
                fontSize = 18.sp,
                color = Color.White,
                fontWeight = FontWeight.SemiBold
            )
            Text(
                "Tickets >",
                fontSize = 16.sp,
                color = Color(0xFFFFD700),
                fontWeight = FontWeight.Medium,
                modifier = Modifier.clickable { onTicketingClick() }
            )
        }

        Spacer(modifier = Modifier.height(16.dp))


        Card(
            modifier = Modifier
                .fillMaxWidth()
                .wrapContentHeight(),
            shape = RoundedCornerShape(16.dp),
            colors = CardDefaults.cardColors(containerColor = Color.DarkGray)
        ) {
            Column {
                Image(
                    painter = painterResource(id = R.drawable.renaissance),
                    contentDescription = "Renaissance Exhibition",
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(180.dp),
                    contentScale = ContentScale.Crop
                )

                Column(modifier = Modifier.padding(14.dp)) {
                    Text("10 OCT", fontSize = 18.sp, color = Color.White, fontWeight = FontWeight.Bold)
                    Spacer(modifier = Modifier.height(6.dp))
                    Text("Renaissance Exhibition", fontSize = 20.sp, color = Color.White, fontWeight = FontWeight.Bold)
                    Spacer(modifier = Modifier.height(4.dp))
                    Text("9:00 AM - 6:00 PM", fontSize = 14.sp, color = Color.LightGray)
                    Spacer(modifier = Modifier.height(4.dp))
                    Text("Indulge in the rich tapestry of Renaissance art", fontSize = 14.sp, color = Color.LightGray)
                    Spacer(modifier = Modifier.height(4.dp))
                    Text("+33 (0)1 23 45 67 89", fontSize = 14.sp, color = Color.LightGray)

                    Spacer(modifier = Modifier.height(12.dp))

                    // Visit Gallery Button
                    Button(
                        onClick = { /* TODO: gallery details */ },
                        modifier = Modifier
                            .fillMaxWidth()
                            .height(46.dp),
                        colors = ButtonDefaults.buttonColors(containerColor = Color(0xFFFFD700)),
                        shape = RoundedCornerShape(8.dp)
                    ) {
                        Text("Visit Gallery", color = Color.Black, fontWeight = FontWeight.Bold, fontSize = 15.sp)
                    }
                }
            }
        }

        Spacer(modifier = Modifier.height(20.dp))
    }
}
