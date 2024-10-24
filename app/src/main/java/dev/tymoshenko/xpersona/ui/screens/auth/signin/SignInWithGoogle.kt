package dev.tymoshenko.xpersona.ui.screens.auth.signin

import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.material3.FilledTonalIconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import dev.tymoshenko.xpersona.R

@Composable
fun SignInWithGoogle(
    onSignInWithGoogle: () -> Unit,
) {
    val ctx = LocalContext.current

    Row(
        modifier = Modifier.wrapContentWidth(),
        verticalAlignment = Alignment.CenterVertically,
    ) {
        Text(
            text = ctx.getString(R.string.sign_in_with),
        )

        Spacer(modifier = Modifier.width(8.dp))

        FilledTonalIconButton(
            modifier = Modifier.size(32.dp),
            onClick = { onSignInWithGoogle.invoke() }
        ) {
            Text(
                text = "G", fontWeight = FontWeight.Bold
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun SignInWithGooglePreview() {
    SignInWithGoogle(onSignInWithGoogle = {})
}