package com.tpc.digigate.ui.screens.home

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Settings
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.tpc.digigate.R
import com.tpc.digigate.ui.theme.DigiGateTheme

data class OptionItem(
    val id: Int,
    @StringRes val title: Int,
    @DrawableRes val images: Int,
)

val recentRequests = listOf("", "", "", "")

@Composable
fun HomeScreenLayout(onSettingsClicked: () -> Unit) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(MaterialTheme.colorScheme.background),
    ) {
        TopBar(onSettingsClicked = onSettingsClicked)
        Spacer(modifier = Modifier.height(30.dp))
        OptionsGrid(onOptionsClicked = {})
        Spacer(modifier = Modifier.height(30.dp))
        Text(
            text = "Past requests:",
            color = MaterialTheme.colorScheme.onBackground,
            style = MaterialTheme.typography.headlineMedium,
            modifier = Modifier.padding(start = 28.dp)
        )
        Spacer(modifier = Modifier.height(16.dp))
        PastRequests(recentRequests)
    }
}

@Composable
fun OptionsGrid(
    onOptionsClicked: (Int) -> Unit
) {
    val options = listOf(
        OptionItem(1, R.string.leave_form, R.drawable.leave_image),
        OptionItem(2, R.string.mess_rebate, R.drawable.mess_rebate_image),
        OptionItem(3, R.string.library_entry, R.drawable.library_image),
        OptionItem(4, R.string.sac_entry, R.drawable.sac_image)
    )

    LazyVerticalGrid(
        columns = GridCells.Fixed(2),
        verticalArrangement = Arrangement.Center,
        horizontalArrangement = Arrangement.Center,
        modifier = Modifier
            .background(Color.Transparent)
            .padding(horizontal = 22.dp, vertical = 8.dp)
    ) {
        items(options) { item ->
            Card(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(140.dp)
                    .padding(horizontal = 6.dp, vertical = 8.dp),
                shape = RoundedCornerShape(25.dp),
                colors = CardDefaults.cardColors(
                    containerColor = MaterialTheme.colorScheme.primary
                ),
            )
            {
                Column(
                    modifier = Modifier
                        .fillMaxSize()
                        .clickable { onOptionsClicked(item.id) },
                    verticalArrangement = Arrangement.Center,
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    Image(
                        painter = painterResource(item.images),
                        contentDescription = null,
                        modifier = Modifier.size(50.dp)
                    )
                    Spacer(modifier = Modifier.padding(1.dp))
                    Text(
                        text = stringResource(item.title),
                        color = Color.Black,
                        style = MaterialTheme.typography.labelLarge.copy(
                            fontWeight = FontWeight.Bold
                        ),
                    )
                }
            }
        }
    }
}

@Composable
fun PastRequests(
    requestInfo: List<String> = recentRequests
) {
    LazyColumn(
        modifier = Modifier
            .fillMaxWidth()
            .height(230.dp)
            .padding(horizontal = 32.dp)
    ) {
        items(requestInfo) { request ->
            Card(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(78.dp)
                    .padding(vertical = 12.dp)
                    .border(1.dp, Color(0xFFF1F1F1), shape = RoundedCornerShape(10.dp)),
                colors = CardDefaults.cardColors(
                    containerColor = MaterialTheme.colorScheme.surface
                ),
            ) {
                Box(
                    modifier = Modifier
                        .fillMaxSize()
                        .padding(start = 10.dp),
                    contentAlignment = Alignment.CenterStart
                ) {
                    Text(
                        text = request,
                        style = MaterialTheme.typography.titleLarge,
                        color = MaterialTheme.colorScheme.onSurface
                    )
                }
            }
        }
    }
}

@Composable
fun TopBar(
    onSettingsClicked: () -> Unit
) {
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .height(58.dp)
            .background(MaterialTheme.colorScheme.background),
    ) {
        Text(
            text = stringResource(R.string.app_name),
            style = MaterialTheme.typography.displaySmall.copy(
                fontWeight = FontWeight.Bold
            ),
            color = MaterialTheme.colorScheme.onBackground,
            modifier = Modifier.align(Alignment.Center)
        )

        IconButton(
            onClick = onSettingsClicked,
            modifier = Modifier
                .align(Alignment.CenterEnd)
                .padding(end = 10.dp)
        ) {
            Icon(
                imageVector = Icons.Default.Settings,
                contentDescription = null,
                tint = MaterialTheme.colorScheme.onBackground,
                modifier = Modifier.size(35.dp)
            )
        }
    }
}


@Preview
@Composable
fun DarkHomeScreenPreview() {
    DigiGateTheme(darkTheme = true) {
        HomeScreenLayout(onSettingsClicked = {})
    }
}

@Preview
@Composable
fun LightHomeScreenPreview() {
    DigiGateTheme(darkTheme = false) {
        HomeScreenLayout(onSettingsClicked = {})
    }
}
