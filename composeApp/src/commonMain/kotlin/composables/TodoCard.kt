package composables

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material.Checkbox
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Delete
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.style.TextDecoration


data class Todo(val content: String, val checked: Boolean)

@Composable
fun TodoCard(todo: Todo, onDelete: (() -> Unit)?) {
    val (checked, setChecked) = remember { mutableStateOf(todo.checked) }
    val decorationStyle = when (checked) {
        true -> TextDecoration.LineThrough
        false -> TextDecoration.None
    }
    Row(
        horizontalArrangement = Arrangement.Center,
        modifier = Modifier.fillMaxWidth(),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Text(text = todo.content, style = TextStyle(textDecoration = decorationStyle))
        Checkbox(
            checked = checked,
            onCheckedChange = setChecked,
        )

        IconButton(
            onClick = onDelete ?: {}
        ) {
            Icon(
                imageVector = Icons.Default.Delete,
                tint = Color(org.jetbrains.skia.Color.RED),
                contentDescription = null
            )
        }
    }
}