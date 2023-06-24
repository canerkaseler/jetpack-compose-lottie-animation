package com.canerkaseler.composelottie

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.airbnb.lottie.compose.LottieAnimation
import com.airbnb.lottie.compose.LottieClipSpec
import com.airbnb.lottie.compose.LottieCompositionSpec
import com.airbnb.lottie.compose.LottieConstants
import com.airbnb.lottie.compose.rememberLottieComposition

@Composable
fun ComposeLottieScreen() {

    var isSuccess by remember { mutableStateOf(false) }

    Box(modifier = Modifier
        .fillMaxSize()
        .background(color = Color.White)
    ){
        ComposeLottieAnimation(
            modifier = Modifier.align(alignment = Alignment.Center),
            isCompleted = isSuccess
        )

        Column(
            modifier = Modifier.align(Alignment.BottomCenter)
        ) {


            // Successful button.
            Button(
                modifier = Modifier
                    .align(alignment = Alignment.CenterHorizontally)
                    .padding(bottom = 15.dp),
                onClick = { isSuccess = true }
            ) {
                Text(
                    text = "Successful"
                )
            }

            // Restart button.
            Button(
                modifier = Modifier
                    .align(alignment = Alignment.CenterHorizontally)
                    .padding(bottom = 45.dp),
                onClick = { isSuccess = false }
            ) {
                Text(
                    text = "Restart"
                )
            }
        }
    }
}

@Composable
fun ComposeLottieAnimation(modifier: Modifier, isCompleted: Boolean) {

    val clipSpecs = LottieClipSpec.Progress(
        min = 0.0f,
        max = if (isCompleted) 0.44f else 0.282f
    )

    val composition by rememberLottieComposition(LottieCompositionSpec.RawRes(R.raw.anim_loading_success_failed))

    LottieAnimation(
        modifier = modifier,
        composition = composition,
        iterations = if (isCompleted) 1 else LottieConstants.IterateForever,
        clipSpec = clipSpecs,
    )
}

@Preview
@Composable
fun MainScreenPreview() {
    ComposeLottieScreen()
}