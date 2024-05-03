package test.co.mvi.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import test.co.mvi.intent.UserIntent
import test.co.mvi.model.User

class UserViewModel : ViewModel() {
    private val _userState = MutableLiveData<User>()
    val userState: LiveData<User> get() = _userState

    fun handleIntent(intent: UserIntent) {
        when (intent) {
            is UserIntent.UpdateUser -> {
                _userState.value = User(intent.name, intent.age)
            }
        }
    }
}