package test.co.mvi.intent

sealed class UserIntent {
    data class UpdateUser(val name: String, val age: Int) : UserIntent()
}