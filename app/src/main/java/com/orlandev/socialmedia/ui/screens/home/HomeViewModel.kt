package com.orlandev.socialmedia.ui.screens.home

import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import com.orlandev.socialmedia.data.models.PostersList
import com.orlandev.socialmedia.data.models.UserList
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor() : ViewModel() {

    val users = mutableStateOf(UserList.mock)
    val currentUser = mutableStateOf(users.value.first()) //Siempre el mismo
    val posters = mutableStateOf(PostersList.mock)

}