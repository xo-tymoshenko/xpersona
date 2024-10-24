package dev.tymoshenko.xpersona.utils

import androidx.compose.ui.unit.Density
import androidx.compose.ui.unit.Dp

fun Dp.dpToF(size: Dp) = (this / size) / 100F

fun Dp.dpToPx(density: Density) = with(density) { this@dpToPx.toPx() }
fun Int.pxToDp(density: Density) = with(density) { this@pxToDp.toDp() }

fun Pair<Int, Int>.pxToDp(density: Density) = with(density) {
    this@pxToDp.first.toDp() to this@pxToDp.second.toDp()
}
