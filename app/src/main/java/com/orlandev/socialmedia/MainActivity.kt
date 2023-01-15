package com.orlandev.socialmedia

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.selection.selectableGroup
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.*
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.orlandev.socialmedia.ui.screens.user_profile.UserProfileScreen
import com.orlandev.socialmedia.ui.theme.SocialMediaTheme
import com.orlandev.socialmedia.ui.theme.facebookBlue
import com.orlandev.socialmedia.ui.theme.facebookDarkGray
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            SocialMediaTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(), color = MaterialTheme.colorScheme.background
                ) {
                    SocialMediaContent()
                }
            }
        }
    }
}


@Preview
@Composable
fun SocialMediaContent() {
    //TODO CAMBIAR PARA USAR NAVCONTROLLER
    Box(modifier = Modifier.fillMaxSize()) {

        UserProfileScreen()


        //TODO Agregar composables dentro del NavHost
        //HomeScreen()
       // BottomNavBar()
    }

}


@Composable
fun BoxScope.BottomNavBar() {
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .height(72.dp)
            .padding(horizontal = 20.dp, vertical = 10.dp)
            .align(Alignment.BottomCenter)
            .shadow(elevation = 20.dp, shape = CircleShape)
        //.background(MaterialTheme.colorScheme.background)
    ) {
        val iconsColor = facebookDarkGray
        Row(
            modifier = Modifier
                .fillMaxSize()
                .selectableGroup()
                .clip(CircleShape)
                .background(MaterialTheme.colorScheme.background.copy(alpha = 0.97f)),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceAround
        ) {
            Icon(
                imageVector = Icons.Rounded.Home, contentDescription = null, tint = facebookBlue
            )
            Icon(
                imageVector = Icons.Rounded.PlayCircle, contentDescription = null, tint = iconsColor
            )
            Icon(
                imageVector = Icons.Rounded.ShoppingCart,
                contentDescription = null,
                tint = iconsColor
            )
            Icon(
                imageVector = Icons.Rounded.Notifications,
                contentDescription = null,
                tint = iconsColor
            )
            Icon(
                imageVector = Icons.Rounded.BorderAll, contentDescription = null, tint = iconsColor
            )


        }
    }
}

@Preview
@Composable
fun BottomBarPreview() {
    SocialMediaTheme {
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .height(100.dp)
        ) {
            BottomNavBar()
        }
    }
}