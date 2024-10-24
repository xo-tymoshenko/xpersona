package dev.tymoshenko.xpersona.ui.screens.auth.signin.error

import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.sizeIn
import androidx.compose.foundation.layout.width
import androidx.compose.material3.FilledTonalIconButton
import androidx.compose.material3.IconButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.onSizeChanged
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import dev.tymoshenko.xpersona.R
import dev.tymoshenko.xpersona.utils.LOW_SPACER_SIZE
import dev.tymoshenko.xpersona.utils.pxToDp

@Composable
fun SignInErrorContent(
    isExpanded: Boolean,
    isMessageVisible: Boolean,
    errorMessage: String,
    maxMessageWidth: Dp,
    onWarningCreated: (Dp) -> Unit,
    onButtonCreated: (Dp) -> Unit,
    onMessageCreated: (Dp) -> Unit,
    onExpand: () -> Unit
) {
    val ctx = LocalContext.current
    val density = LocalDensity.current

    Text(
        modifier = Modifier
            .onSizeChanged {
                onWarningCreated.invoke(it.width.pxToDp(density = density))
            },
        text = ctx.getString(R.string.something_went_wrong),
    )

    Spacer(
        modifier = Modifier
            .width(width = LOW_SPACER_SIZE)
    )

    FilledTonalIconButton(
        modifier = Modifier
            .onSizeChanged {
                onButtonCreated.invoke(it.width.pxToDp(density = density))
            }
            .size(32.dp),
        onClick = {
            onExpand.invoke()
        },
        colors = IconButtonDefaults.iconButtonColors(
            containerColor = MaterialTheme.colorScheme.errorContainer,
            contentColor = MaterialTheme.colorScheme.onErrorContainer
        )
    ) {
        Text(
            text = if (isExpanded) "X" else "!",
            fontWeight = FontWeight.Bold,
        )
    }

    if (isMessageVisible) {
        Spacer(
            modifier = Modifier
                .width(width = LOW_SPACER_SIZE)
        )

        Text(
            modifier = Modifier
                .onSizeChanged {
                    onMessageCreated.invoke(it.width.pxToDp(density))
                }
                .sizeIn(maxWidth = maxMessageWidth),
            text = errorMessage,
            color = MaterialTheme.colorScheme.error,
            maxLines = 1,
            overflow = TextOverflow.Ellipsis
        )
    }
}