package br.com.atividade.cabelereiro

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class Login : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        val loginBtnCadastrar = findViewById<Button>(R.id.tlLoginbtnCadastrar) //vinculo com o kotlin
        loginBtnCadastrar.setOnClickListener{
            val tlCadastro = Intent(this,cadastrar::class.java)
            startActivity(tlCadastro)


            val loginBtnLogin = findViewById<Button>(R.id.tlLoginbtnLogar) //vinculo com o kotlin
            loginBtnLogin.setOnClickListener{
                val principal = Intent(this,MainActivity::class.java)
                startActivity(principal)
            }
        }
    }
}
