package ng.com.sirteefyapps.sirteefynotes.presentation.widgets

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Size
import androidx.compose.ui.graphics.Outline
import androidx.compose.ui.graphics.Path
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.unit.Density
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.LayoutDirection
import androidx.compose.ui.unit.dp

// Custom shape for beveled corners
fun beveledCornersShape(
    cornerSize: Dp = 10.dp, // Adjust the bevel size here
): Shape = object : Shape {
    override fun createOutline(
        size: Size
        layoutDirection: LayoutDirection,
        density: Density
    ): Outline {
        val cornerSizePx = with(density) { cornerSize.toPx() }

        return Outline.Generic(
            path = Path().apply {
                // Top-left corner (unchanged)
                moveTo(0f, 0f)
                // Top-right corner (beveled)
                lineTo(size.width - cornerSizePx, 0f)
                lineTo(size.width, cornerSizePx)
                // Bottom-right corner (unchanged)
                lineTo(size.width, size.height)
                // Bottom-left corner (beveled)
                lineTo(cornerSizePx, size.height)
                lineTo(0f, size.height - cornerSizePx)
                close()
            }
        )
    }
}

@Composable
fun BeveledCornerTextField(value: String,label: String, onValueChange: (String) -> Unit) {

    OutlinedTextField(
        value = value,
        onValueChange = onValueChange,
        shape = beveledCornersShape(), // Apply custom shape
        modifier = Modifier.fillMaxWidth(),
        label = { Text(label) },
        singleLine = true
    )
}
