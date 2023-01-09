package com.orlandev.socialmedia.ui.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import coil.compose.SubcomposeAsyncImage
import com.orlandev.socialmedia.R
import com.orlandev.socialmedia.data.models.User
import com.orlandev.socialmedia.ui.theme.facebookBlue
import com.orlandev.socialmedia.ui.theme.facebookFucsiaColor
import com.orlandev.socialmedia.ui.theme.facebookGray
import com.orlandev.socialmedia.ui.theme.facebookGreenColor
import compose.icons.FontAwesomeIcons
import compose.icons.fontawesomeicons.Brands
import compose.icons.fontawesomeicons.brands.Facebook

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HomeScreen(homeViewModel: HomeViewModel = hiltViewModel()) {

    val currentUser = homeViewModel.currentUser.value
    val users = homeViewModel.users.value

    //Banner
    Scaffold(
        modifier = Modifier.fillMaxSize(),
        topBar = {
            TopAppBar(
                modifier = Modifier.padding(horizontal = 8.dp),
                navigationIcon = {
                    //Icon
                    Icon(
                        modifier = Modifier.size(40.dp),
                        imageVector = FontAwesomeIcons.Brands.Facebook,
                        contentDescription = null,
                        tint = facebookBlue
                    )
                },
                title = {},
                actions = {

                    Box(
                        modifier = Modifier
                            .size(40.dp)
                            .clip(CircleShape)
                            .background(facebookGray)
                            .clickable { }, contentAlignment = Alignment.Center
                    ) {
                        Icon(imageVector = Icons.Default.Search, contentDescription = null)
                    }

                    Spacer(modifier = Modifier.size(14.dp))

                    SubcomposeAsyncImage(
                        modifier = Modifier
                            .size(40.dp)
                            .clip(CircleShape),
                        model = currentUser.avatar, contentDescription = null,
                        contentScale = ContentScale.Crop
                    )

                }
            )
        }
    ) { innerPadding ->

        LazyColumn(
            modifier = Modifier
                .fillMaxSize()
                .padding(innerPadding),
            verticalArrangement = Arrangement.spacedBy(20.dp)
        ) {

            item {

                Column(
                    modifier = Modifier.fillMaxWidth(),
                    verticalArrangement = Arrangement.spacedBy(14.dp)
                ) {
                    Box(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(horizontal = 12.dp)
                            .height(40.dp)
                            .clip(RoundedCornerShape(50))
                            .background(facebookGray),
                        contentAlignment = Alignment.Center
                    ) {

                        Text(
                            modifier = Modifier
                                .fillMaxWidth()
                                .padding(start = 14.dp),
                            fontWeight = FontWeight.Bold,
                            letterSpacing = 2.sp,
                            style = MaterialTheme.typography.bodyMedium,
                            color = Color.Gray.copy(alpha = 0.6f),
                            text = stringResource(id = R.string.home_message_text)
                        )

                        /*BasicTextField(
                            modifier = Modifier
                                .fillMaxWidth()
                                .padding(8.dp),
                            textStyle = MaterialTheme.typography.bodyMedium,
                            value = "What's on your mind?",
                            onValueChange = { "" })*/
                    }

                    Row(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(horizontal = 16.dp),
                        verticalAlignment = Alignment.CenterVertically,
                        horizontalArrangement = Arrangement.spacedBy(20.dp)
                    ) {

                        CommonButton(
                            color = facebookFucsiaColor,
                            text = "Live",
                            icon = Icons.Default.Camera,
                            onClick = {}
                        )

                        CommonButton(
                            color = facebookGreenColor,
                            text = "Photo",
                            icon = Icons.Default.Image,
                            onClick = {}
                        )

                        CommonButton(
                            color = facebookGray,
                            width = 50.dp,
                            icon = Icons.Default.MoreHoriz,
                            tintColor = Color.Black,
                            onClick = {}
                        )
                    }
                }
            }

            //STORY
            item {
                StoryBoard(currentUser = currentUser, usersList = users)
            }

        }
    }
}

@Composable
fun StoryBoard(currentUser: User, usersList: List<User>) {

    Column(modifier = Modifier.fillMaxWidth()) {
        Text(
            modifier = Modifier.padding(horizontal = 20.dp),
            text = "Story",
            style = MaterialTheme.typography.titleMedium
        )
        Spacer(modifier = Modifier.size(10.dp))

        LazyRow(
            modifier = Modifier
                .fillMaxWidth()
                .padding(vertical = 8.dp),
            horizontalArrangement = Arrangement.spacedBy(16.dp)
        ) {

            item {
                Spacer(modifier = Modifier.size(5.dp))
            }

            item {
                StoryCard(
                    bannerImage = currentUser.bannerImage,
                    title = "Create Story",
                    color = facebookBlue
                ){
                    //TODO ONCLICK
                }
            }

            items(usersList) { user ->
                StoryCard(
                    avatarImage = user.avatar,
                    bannerImage = user.bannerImage,
                    title = user.name,
                    textColor = Color.Black
                ){
                    //TODO ONCLICK
                }
            }

            item {
                Spacer(modifier = Modifier.size(10.dp))
            }

        }

    }


}

@OptIn(ExperimentalMaterialApi::class)
@Composable
fun StoryCard(
    bannerImage: String,
    avatarImage: String? = null,
    title: String,
    color: Color = Color.White,
    textColor: Color = Color.White,
    onClick: () -> Unit
) {

    androidx.compose.material.Card(
        onClick = onClick,
        modifier = Modifier
            .height(170.dp)
            .width(90.dp),
        backgroundColor = color,
        elevation = 10.dp,
        shape = RoundedCornerShape(12.dp)
    ) {
        Box(
            modifier = Modifier.fillMaxSize()
        ) {
            SubcomposeAsyncImage(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(110.dp),
                model = bannerImage, contentScale = ContentScale.Crop,
                contentDescription = null
            )

            Column(
                modifier = Modifier
                    .wrapContentHeight()
                    .width(50.dp)
                    .align(Alignment.BottomCenter)
                    .padding(bottom = 8.dp),
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally
            ) {

                if (avatarImage == null) {

                    //TODO REVISAR LA SOMBRA
                    Box(
                        modifier = Modifier
                            .size(40.dp)
                            .clip(CircleShape)
                            .background(Color.White),
                        contentAlignment = Alignment.Center
                    ) {
                        Icon(
                            imageVector = Icons.Default.Add,
                            contentDescription = null,
                            tint = facebookBlue
                        )
                    }
                } else {
                    SubcomposeAsyncImage(
                        modifier = Modifier
                            .size(40.dp)
                            .clip(CircleShape)
                            .border(2.dp, color = Color.White, shape = CircleShape),
                        model = avatarImage, contentScale = ContentScale.Crop,
                        contentDescription = null
                    )
                }

                Text(
                    text = title,
                    textAlign = TextAlign.Center,
                    style = MaterialTheme.typography.bodySmall,
                    fontWeight = FontWeight.Bold,
                    overflow = TextOverflow.Clip,
                    maxLines = 2, color = textColor
                )

            }

        }
    }

}

@Composable
fun CommonButton(
    color: Color = Color.Red,
    tintColor: Color = Color.White,
    icon: ImageVector,
    text: String? = null,
    width: Dp = 120.dp,
    onClick: () -> Unit
) {
    Box(
        modifier = Modifier
            .height(30.dp)
            .width(width)
            .shadow(elevation = 20.dp, shape = RoundedCornerShape(20.dp), spotColor = color)
    ) {

        //TODO ARREGLAR LA SOMBRA DEL BOTON

        Box(
            modifier = Modifier
                .height(30.dp)
                .width(width)
                .clip(CircleShape)
                .background(color = color)
                .clickable { onClick() },
            contentAlignment = Alignment.Center
        ) {
            Row(
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.Center
            ) {
                Icon(
                    modifier = Modifier.size(15.dp),
                    imageVector = icon,
                    contentDescription = null,
                    tint = tintColor
                )
                text?.let {
                    Spacer(modifier = Modifier.size(4.dp))
                    Text(text = text, color = tintColor)
                }
            }
        }
    }
}