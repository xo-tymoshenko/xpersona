package dev.tymoshenko.xpersona.ui.screens.auth.signin.error

import android.annotation.SuppressLint
import androidx.compose.animation.animateContentSize
import androidx.compose.animation.core.animateDpAsState
import androidx.compose.animation.core.tween
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.sizeIn
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.material3.FilledTonalIconButton
import androidx.compose.material3.IconButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.onSizeChanged
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import dev.tymoshenko.xpersona.R
import dev.tymoshenko.xpersona.utils.LOW_SPACER_SIZE
import dev.tymoshenko.xpersona.utils.pxToDp

@SuppressLint("UseOfNonLambdaOffsetOverload", "UnrememberedMutableState")
@Composable
fun SignInError(
    errorMessage: String
) {
    val cfg = LocalConfiguration.current

    val isExpanded = remember { mutableStateOf(false) }
    val isMessageVisible = remember { mutableStateOf(false) }

    val warningWidth = remember { mutableStateOf(0.dp) }
    val buttonWidth = remember { mutableStateOf(0.dp) }
    val messageWidth = remember { mutableStateOf(0.dp) }

    val maxMessageWidth: Dp by lazy {
        cfg.screenWidthDp.dp - (buttonWidth.value + LOW_SPACER_SIZE)
    }
    val normalWidth: Dp by lazy {
        warningWidth.value + LOW_SPACER_SIZE + buttonWidth.value
    }
    val expandedWidth: Dp by lazy {
        buttonWidth.value + LOW_SPACER_SIZE + messageWidth.value
    }

    val width = animateDpAsState(
        targetValue = if (isExpanded.value) {
            expandedWidth
        } else {
            normalWidth
        },
        animationSpec = tween(1000)
    )

    val offset = animateDpAsState(
        targetValue = if (isExpanded.value) {
            -(warningWidth.value + LOW_SPACER_SIZE)
        } else {
            0.dp
        },
        animationSpec = tween(1000)
    )

    Row(
        modifier = Modifier
            .then(
                other = if (isMessageVisible.value) {
                    Modifier.width(width.value)
                } else {
                    Modifier
                }
            )
            .animateContentSize()
            .offset(x = offset.value)
            .wrapContentWidth(unbounded = true, align = Alignment.Start),
        verticalAlignment = Alignment.CenterVertically
    ) {
        SignInErrorContent(
            isExpanded = isExpanded.value,
            isMessageVisible = isMessageVisible.value,
            errorMessage = errorMessage,
            maxMessageWidth = maxMessageWidth,
            onWarningCreated = { size -> warningWidth.value = size },
            onButtonCreated = { size -> buttonWidth.value = size },
            onMessageCreated = { size -> messageWidth.value = size },
            onExpand = {
                isMessageVisible.value = true
                isExpanded.value = !isExpanded.value
            }
        )
    }
}

@Preview(showBackground = true)
@Composable
fun SignInErrorPreview() {
    SignInError(errorMessage = "Some Error Message")
}