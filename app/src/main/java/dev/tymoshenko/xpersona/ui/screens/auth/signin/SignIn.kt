package dev.tymoshenko.xpersona.ui.screens.auth.signin

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import dev.tymoshenko.xpersona.R
import dev.tymoshenko.xpersona.data.models.AuthStatus
import dev.tymoshenko.xpersona.ui.screens.auth.AuthViewModel
import dev.tymoshenko.xpersona.ui.screens.auth.signin.error.SignInError
import dev.tymoshenko.xpersona.utils.LOW_SPACER_SIZE
import org.koin.androidx.compose.koinViewModel

@Composable
fun SignIn() {
    val ctx = LocalContext.current
    val viewModel = koinViewModel<AuthViewModel>()
    val authStatus by remember {
        viewModel.authState
    }

    Box(
        modifier = Modifier
            .fillMaxHeight(0.5f)
            .fillMaxWidth()
    ) {
        Column(
            modifier = Modifier
                .wrapContentWidth()
                .align(alignment = Alignment.TopCenter),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(
                text = ctx.getString(R.string.greeting),
            )

            Spacer(
                modifier = Modifier
                    .height(LOW_SPACER_SIZE)
            )

            SignInWithGoogle(
                onSignInWithGoogle = { viewModel.signInWithGoogle(ctx) }
            )

            if (authStatus is AuthStatus.GotException) {
                Spacer(
                    modifier = Modifier
                        .height(LOW_SPACER_SIZE)
                )

                SignInError(
                    errorMessage = (authStatus as AuthStatus.GotException).exception.message
                        ?: ""
                )
            }
        }
    }
}

@Preview
@Composable
fun SignInPreview() {
    SignIn()
}