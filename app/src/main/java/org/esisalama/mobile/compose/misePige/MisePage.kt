package org.esisalama.mobile.compose.misePige

import android.content.res.Configuration
import android.view.Surface
import android.widget.Space
import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import org.esisalama.mobile.compose.R

data class message(val nom:String,val message: String)

@Composable
fun MisePage(msg:message) {

    Column() {
        Row(modifier = Modifier.padding(all = 8.dp)) {
            Image(
                painter = painterResource(R.drawable.profile_img),
                contentDescription = "",
                modifier = Modifier
                    .size(60.dp)
                    .clip(CircleShape)
                    .border(2.dp, MaterialTheme.colors.secondary, CircleShape)
            )
            Spacer(modifier = Modifier.width(8.dp))

            var isExpanded by remember {
                mutableStateOf(false)
            }
            Column(modifier = Modifier.clickable { isExpanded = !isExpanded }) {
                Text(
                    text = msg.nom, fontWeight = FontWeight.Bold,
                    color = MaterialTheme.colors.secondary,
                    style = MaterialTheme.typography.subtitle1
                )
                Spacer(modifier = Modifier.padding(top = 5.dp, bottom = 5.dp))
                Surface(shape = MaterialTheme.shapes.medium, elevation = 2.dp){
                    Text(
                        text = msg.message,
                        modifier = Modifier.padding(all = 8.dp),
                        maxLines =if (isExpanded) Int.MAX_VALUE else 1,
                        style = MaterialTheme.typography.h5
                    )
                }
            }
        }

        Row(modifier = Modifier.padding(all = 8.dp)) {
            Image(
                painter = painterResource(R.drawable.profile_img),
                contentDescription = "",
                modifier = Modifier
                    .size(60.dp)
                    .clip(CircleShape)
                    .border(2.dp, MaterialTheme.colors.secondary, CircleShape)
            )
            Spacer(modifier = Modifier.width(8.dp))

            var isExpanded by remember {
                mutableStateOf(false)
            }
            Column(modifier = Modifier.clickable { isExpanded = !isExpanded }) {
                Text(
                    text = msg.nom, fontWeight = FontWeight.Bold,
                    color = MaterialTheme.colors.secondary,
                    style = MaterialTheme.typography.subtitle1
                )
                Spacer(modifier = Modifier.padding(top = 5.dp, bottom = 5.dp))
                Surface(shape = MaterialTheme.shapes.medium, elevation = 2.dp){
                    Text(
                        text = msg.message,
                        modifier = Modifier.padding(all = 8.dp),
                        maxLines =if (isExpanded) Int.MAX_VALUE else 1,
                        style = MaterialTheme.typography.h5
                    )
                }
            }
        }
        
        Row(verticalAlignment = Alignment.CenterVertically) {
            Image(painter = painterResource(id = R.drawable.compose), contentDescription = "",
                modifier = Modifier.padding(4.dp).
                        size(50.dp)
                    .clip(CircleShape)
                    .border(3.dp, color = Color.Green, CircleShape)
            )
        }

    }

}




@Preview(name = "light Mode")
@Preview(
    name = "Dark Mode",
    uiMode = Configuration.UI_MODE_NIGHT_YES,
    showBackground = true
)
@Composable
fun PreviewMessage() {
    MisePage(
        msg = message("nathan", " je suis author")
    )
}