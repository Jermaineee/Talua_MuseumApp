package ph.edu.comteq.talua_lab3

import android.os.Build
import androidx.annotation.RequiresApi
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.DatePicker
import androidx.compose.material3.DatePickerDefaults
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.IconButton
import androidx.compose.material3.SelectableDates
import androidx.compose.material3.Text
import androidx.compose.material3.rememberDatePickerState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import java.time.Instant
import java.time.Duration

@RequiresApi(Build.VERSION_CODES.O)
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TicketingServiceScreen(onBackClick: () -> Unit) {
    var generalAdmissionCount by remember { mutableStateOf(0) }
    var freeAdmissionCount by remember { mutableStateOf(0) }
    val generalTicketPrice = 500
    val totalPrice = (generalAdmissionCount * generalTicketPrice)

    val datePickerState = rememberDatePickerState(
        initialSelectedDateMillis = Instant.now()
            .plus(Duration.ofDays(2)).toEpochMilli(),
        selectableDates = object: SelectableDates {
            override fun isSelectableDate(utcTimeMillis: Long): Boolean {
                return utcTimeMillis >= Instant.now()
                    .plus(Duration.ofDays(1)).toEpochMilli()
            }
        }
    )

    Column(
        modifier = Modifier.background(Color.Black)
    ) {
        Column(
            modifier = Modifier
                .weight(1f)
                .verticalScroll(rememberScrollState())
        ) {
            // Header
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(160.dp),
                contentAlignment = Alignment.Center
            ) {
                Image(
                    painter = painterResource(id = R.drawable.background),
                    contentDescription = "Museum",
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(160.dp),
                    contentScale = ContentScale.Crop
                )
                // Black overlay
                Box(
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(160.dp)
                        .background(Color.Black.copy(alpha = 0.7f))
                )
                Text(
                    "Official\nTicketing Service",
                    fontSize = 30.sp,
                    fontFamily = playfairdisplayregular,
                    color = Color.White,
                    textAlign = TextAlign.Center,
                    lineHeight = 34.sp
                )
            }

            // Inner container for date and ticket types
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 4.dp, vertical = 20.dp)
            ) {
                // Section 1: Date to Visit
                Text(
                    "1. Date to Visit",
                    fontSize = 26.sp,
                    fontFamily = playfairdisplayregular,
                    color = Color(0xFFD29F1B)
                )

                HorizontalDivider(
                    color = Color(0xFFD29F1B),
                    thickness = 1.dp,
                    modifier = Modifier.padding(vertical = 8.dp)
                )

                DatePicker(
                    modifier = Modifier
                        .padding(0.dp)
                        .fillMaxWidth()
                        .height(380.dp),
                    state = datePickerState,
                    title = null,
                    showModeToggle = false,
                    headline = null,
                    colors = DatePickerDefaults.colors(
                        containerColor = Color.Transparent,
                        titleContentColor = Color(0xFFD29F1B),
                        headlineContentColor = Color(0xFFD29F1B),
                        weekdayContentColor = Color(0xFFD29F1B),
                        currentYearContentColor = Color(0xFFD29F1B),
                        selectedYearContentColor = Color.Black,
                        selectedYearContainerColor = Color(0xFFD29F1B),
                        dayContentColor = Color.White,
                        selectedDayContentColor = Color.Black,
                        selectedDayContainerColor = Color(0xFFD29F1B),
                        todayContentColor = Color(0xFFD29F1B),
                        todayDateBorderColor = Color(0xFFD29F1B),
                        disabledDayContentColor = Color.Gray,
                        navigationContentColor = Color.White,
                        yearContentColor = Color.White
                    )
                )

                // Section 2: Number of Tickets
                Text(
                    "2. Number of Tickets",
                    fontSize = 26.sp,
                    fontFamily = playfairdisplayregular,
                    color = Color(0xFFD29F1B)
                )

                HorizontalDivider(
                    color = Color(0xFFD29F1B),
                    thickness = 1.dp,
                    modifier = Modifier.padding(vertical = 8.dp)
                )

                Spacer(modifier = Modifier.height(16.dp))

                // General Admission Ticket Row
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceBetween,
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Column {
                        Text(
                            "General Admission",
                            fontSize = 18.sp,
                            fontFamily = playfairdisplayregular,
                            color = Color.White
                        )
                        Text(
                            "P$generalTicketPrice",
                            fontSize = 28.sp,
                            fontFamily = playfairdisplayregular,
                            color = Color(0xFFD29F1B),
                            fontWeight = FontWeight.Normal
                        )
                    }

                    Row(
                        verticalAlignment = Alignment.CenterVertically,
                        horizontalArrangement = Arrangement.spacedBy(16.dp)
                    ) {
                        // Minus Button
                        IconButton(
                            onClick = {
                                if (generalAdmissionCount > 0) {
                                    generalAdmissionCount--
                                }
                            },
                            modifier = Modifier
                                .size(48.dp)
                                .border(2.dp, Color.White, CircleShape)
                        ) {
                            Text(
                                "−",
                                fontSize = 24.sp,
                                color = Color.White
                            )
                        }

                        // Count
                        Text(
                            generalAdmissionCount.toString(),
                            fontSize = 24.sp,
                            fontFamily = playfairdisplayregular,
                            color = Color.White
                        )

                        // Plus Button
                        IconButton(
                            onClick = { generalAdmissionCount++ },
                            modifier = Modifier
                                .size(48.dp)
                                .border(2.dp, Color.White, CircleShape)
                        ) {
                            Text(
                                "+",
                                fontSize = 24.sp,
                                color = Color.White
                            )
                        }
                    }
                }

                Spacer(modifier = Modifier.height(24.dp))

                // Free Admission Ticket Row
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceBetween,
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Column {
                        Text(
                            "Under 18s, Under 26s\nresidents of the EEA,\nMuseum members,\nProfessionals",
                            fontSize = 14.sp,
                            fontFamily = playfairdisplayregular,
                            color = Color.White,
                            lineHeight = 18.sp
                        )
                        Text(
                            "FREE",
                            fontSize = 28.sp,
                            fontFamily = playfairdisplayregular,
                            color = Color(0xFFD29F1B),
                            fontWeight = FontWeight.Normal
                        )
                    }

                    Row(
                        verticalAlignment = Alignment.CenterVertically,
                        horizontalArrangement = Arrangement.spacedBy(16.dp)
                    ) {
                        // Minus Button
                        IconButton(
                            onClick = {
                                if (freeAdmissionCount > 0) {
                                    freeAdmissionCount--
                                }
                            },
                            modifier = Modifier
                                .size(48.dp)
                                .border(2.dp, Color.White, CircleShape)
                        ) {
                            Text(
                                "−",
                                fontSize = 24.sp,
                                color = Color.White
                            )
                        }

                        // Count
                        Text(
                            freeAdmissionCount.toString(),
                            fontSize = 24.sp,
                            fontFamily = playfairdisplayregular,
                            color = Color.White
                        )

                        // Plus Button
                        IconButton(
                            onClick = { freeAdmissionCount++ },
                            modifier = Modifier
                                .size(48.dp)
                                .border(2.dp, Color.White, CircleShape)
                        ) {
                            Text(
                                "+",
                                fontSize = 24.sp,
                                color = Color.White
                            )
                        }
                    }
                }

                Spacer(modifier = Modifier.height(32.dp))
            }
        }

        // Bottom bar for totals
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .height(80.dp)
                .background(Color(0xFFD29F1B))
                .padding(horizontal = 20.dp),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text(
                "Total: P$totalPrice",
                fontSize = 26.sp,
                fontFamily = playfairdisplayregular,
                color = Color.Black,
                fontWeight = FontWeight.Normal
            )
            Button(
                modifier = Modifier.padding(5.dp),
                onClick = { /* TODO */ },
                colors = ButtonDefaults.buttonColors(containerColor = Color.Black)
            ) {
                Text(
                    "Checkout",
                    fontSize = 20.sp,
                    fontFamily = playfairdisplayregular,
                    color = Color(0xFFD29F1B),
                    fontWeight = FontWeight.Normal
                )
            }
        }
    }
}