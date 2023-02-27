package com.example.artspace

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.artspace.ui.theme.ArtSpaceTheme

class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ArtSpaceTheme {
                ArtSpaceApp()
            }
        }
    }
}

@Composable
fun ArtSpaceApp() {
    var currentPiece by remember { mutableStateOf(1) }

    Surface(
        modifier = Modifier.fillMaxSize(),
        color = MaterialTheme.colors.background
    ) {
        when (currentPiece) {
            1 -> {
                ArtSpaceTextAndImage(
                    textLabelResourceId = R.string.leuven,
                    drawableResourceId = R.drawable.img_1768_4s,
                    contentDescriptionResourceId = R.string.leuven_content_description,
                    showNextPiece = {
                        currentPiece++
                    },
                    showPreviousPiece = {
                        currentPiece = 4
                    }
                )
            }
            2 -> {
                ArtSpaceTextAndImage(
                    textLabelResourceId = R.string.britt,
                    drawableResourceId = R.drawable.img_1915s,
                    contentDescriptionResourceId = R.string.britt_content_description,
                    showNextPiece = {
                        currentPiece++
                    },
                    showPreviousPiece = {
                        currentPiece--
                    }
                )
            }
            3 -> {
                ArtSpaceTextAndImage(
                    textLabelResourceId = R.string.moon,
                    drawableResourceId = R.drawable.img_3181s,
                    contentDescriptionResourceId = R.string.moon_content_description,
                    showNextPiece = {
                        currentPiece++
                    },
                    showPreviousPiece = {
                        currentPiece--
                    }
                )
            }
            4 -> {
                ArtSpaceTextAndImage(
                    textLabelResourceId = R.string.birb,
                    drawableResourceId = R.drawable.img_3284,
                    contentDescriptionResourceId = R.string.birb_content_description,
                    showNextPiece = {
                        currentPiece = 1
                    },
                    showPreviousPiece = {
                        currentPiece--
                    }
                )
            }
        }
    }
}

@Composable
fun ArtSpaceTextAndImage(
    textLabelResourceId: Int,
    drawableResourceId: Int,
    contentDescriptionResourceId: Int,
    showNextPiece: () -> Unit,
    showPreviousPiece: () -> Unit,
    modifier: Modifier = Modifier
) {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center,
        modifier = modifier.fillMaxSize()
    ) {
        Image(
            painter = painterResource(drawableResourceId),
            contentDescription = stringResource(contentDescriptionResourceId),
            modifier = Modifier
                .wrapContentSize()
        )
        Spacer(modifier = Modifier.height(16.dp))
        Text(
            text = stringResource(textLabelResourceId),
            fontSize = 32.sp,
        )
        Spacer(modifier = Modifier.height(64.dp))
        Text(
            text = "Next",
            fontSize = 24.sp,
            modifier = Modifier.clickable(
                onClick = showNextPiece
            )
        )
        Spacer(modifier = Modifier.height(16.dp))
        Text(
            text = "Previous",
            fontSize = 24.sp,
            modifier = Modifier.clickable(
                onClick = showPreviousPiece
            )
        )
    }
}

@Preview
@Composable
fun ArtSpacePreview() {
    ArtSpaceTheme() {
        ArtSpaceApp()
    }
}