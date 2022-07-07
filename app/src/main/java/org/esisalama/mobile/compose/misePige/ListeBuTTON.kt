package org.esisalama.mobile.compose.misePige

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.MaterialTheme
import androidx.compose.material.OutlinedButton
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp


@Composable
fun ListeShow(names: List<String> = listOf("word !","hello")){
    Column {
        for (name in names){
            ListeButton(name = name)
        }
    }
}

@Composable
fun ListeButton( name: String) {
    val expanded = remember { mutableStateOf(false) }
    val extraPadding = if (expanded.value) 48.dp else 0.dp
        Surface(
            color = MaterialTheme.colors.primary,
            modifier = Modifier.padding(vertical = 4.dp, horizontal = 8.dp)
        ) {
            Column() {
                Row(Modifier.padding(24.dp)) {
                    Column(modifier = Modifier.weight(1f).padding(bottom = extraPadding)) {
                        Text(text = "hello !")
                        Text(text = name)
                    }
                    OutlinedButton(onClick = { expanded.value = !expanded.value }) {
                        Text(if (expanded.value) "show more" else "show  less")
                    }
                }
            }
        }
}

@Preview(showBackground = true)
@Composable
fun PreviewLis() {
    ListeShow()
}