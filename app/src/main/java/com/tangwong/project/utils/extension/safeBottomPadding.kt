package com.tangwong.project.utils.extension

import androidx.annotation.DimenRes
import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.asPaddingValues
import androidx.compose.foundation.layout.navigationBars
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.plus

@Composable
fun Modifier.safeBottomPadding(@DimenRes extraPaddingRes: Int): Modifier {
    val insetPadding = WindowInsets.navigationBars
        .asPaddingValues()
        .calculateBottomPadding()

    val extraPadding = dimensionResource(id = extraPaddingRes)

    return this.padding(bottom = insetPadding + extraPadding)
}
