package com.tangwong.project.presentation.ui.components

import androidx.annotation.DimenRes
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.unit.dp
import com.tangwong.project.utils.extension.safeBottomPadding

@Composable
fun GradientButton(
    text: String,
    modifier: Modifier = Modifier,
    @DimenRes bottomPaddingRes: Int,
    colors: List<Color>,
    onClick: () -> Unit,
    shape: Shape = RoundedCornerShape(40.dp),
    widthFraction: Float = 0.5f
) {
    TextButton(
        onClick = onClick,
        modifier = modifier
            .fillMaxWidth(widthFraction)
            .safeBottomPadding(bottomPaddingRes)
            .background(
                brush = Brush.linearGradient(colors),
                shape = shape
            )
    ) {
        Text(text)
    }
}

