package dev.tymoshenko.xpersona.ui.anims

import android.annotation.SuppressLint
import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.State
import androidx.compose.runtime.derivedStateOf
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.BiasAlignment
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import dev.tymoshenko.xpersona.utils.dpToF

@SuppressLint("UnrememberedMutableState")
@Composable
fun animateAlignmentAsState(
    targetAlignment: Alignment,
    offsetX: Dp = 0.dp,
    offsetY: Dp = 0.dp,
): State<Alignment> {
    val cfg = LocalConfiguration.current
    val screenWithDp = cfg.screenWidthDp.dp
    val screenHeightDp = cfg.screenHeightDp.dp

    val biased = targetAlignment as BiasAlignment
    val horizontal by animateFloatAsState(biased.horizontalBias + offsetX.dpToF(screenWithDp))
    val vertical by animateFloatAsState(biased.verticalBias + offsetY.dpToF(screenHeightDp))
    return derivedStateOf { BiasAlignment(horizontal, vertical) }
}