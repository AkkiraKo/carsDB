package me.kaungmyatmin.carsdb

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.ktx.Firebase
import kotlinx.android.synthetic.main.activity_register.*

class RegisterActivity : AppCompatActivity() {

    companion object {
        fun newIntent(context: Context): Intent {
            val intent = Intent(context, RegisterActivity::class.java)
            return intent
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_register)

        tvLogin.setOnClickListener {
            val intent = LoginActivity.newIntent(this)
            startActivity(intent)
        }

        btnRegister.setOnClickListener {
            val email = etEmail.text.toString()
            val password = etPassword.text.toString()
            val confirmPassword = etConfirmPassword.text.toString()

            if (password != confirmPassword) {
                Toast.makeText(this, "Password doesn't match", Toast.LENGTH_LONG).show()
            } else {
                /*val userRepository = UserRepository()
                val user = User(email, password)
                userRepository.registerUser(this,user)*/

                val auth = FirebaseAuth.getInstance()
                auth.createUserWithEmailAndPassword(email, password)
                    .addOnCompleteListener {take ->

                        if (take.isSuccessful){

                            //Toast.makeText(this,"Success", Toast.LENGTH_SHORT).show()
                        }else{
                            Toast.makeText(this,
                            take.exception?.message ?: "Unknown Error",
                            Toast.LENGTH_LONG
                            ).show()
                        }

                    }
            }
        }
    }


}
