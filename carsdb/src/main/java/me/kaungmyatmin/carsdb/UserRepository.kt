package me.kaungmyatmin.carsdb

import android.content.Context

class UserRepository {

    fun registerUser(context: Context, user: User) {

    }

    fun loginUser(context: Context, user: User) {

    }

    fun getUser(): User? {

        return null
    }

    fun isLogged(context: Context): Boolean {
        return false
    }

    fun saveLogged(context: Context) {


    }

    fun logout(context: Context) {

    }

    private fun showToast(
        context: Context,
        message: String
    ) {

    }
}
