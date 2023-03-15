package com.example.whiteday

import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update

data class EmailFollowerState(
    var arrEmail: ArrayList<String> = arrayListOf()
) {
}

class EmailFollowersViewModel: ViewModel(){

    private val _state = MutableStateFlow(EmailFollowerState())
    val uiState: StateFlow<EmailFollowerState> = _state.asStateFlow()

    fun addEmail(newEmail: String) {
        _state.update {
                currentState ->
            val currentList = ArrayList(currentState.arrEmail)
            currentList.add(newEmail)
            currentState.copy(arrEmail = currentList)
        }
    }

    fun removeEmail(){
        _state.update {
                currentState ->
            val currentList = ArrayList(currentState.arrEmail)
            currentList.removeAt(currentList.size - 1)
            currentState.copy(arrEmail = currentList)
        }
    }
}