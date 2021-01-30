package me.kaungmyatmin.carsdb

import android.os.Bundle
import android.os.Handler
import androidx.appcompat.app.AppCompatActivity
import com.google.firebase.auth.FirebaseAuth

class SplashActivity : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)

        val handler = Handler()
        handler.postDelayed({
            val repository = UserRepository()
            //val isLogged = repository.isLogged(this)
            val isLogged = FirebaseAuth.getInstance().currentUser != null
            val intent = if (isLogged) {
                MainActivity.newIntent(this)
            } else {
                LoginActivity.newIntent(this)
            }

            startActivity(intent)
            finish()
        }, 1000)


    }
}