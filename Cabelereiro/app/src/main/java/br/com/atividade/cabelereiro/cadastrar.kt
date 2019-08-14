package br.com.atividade.cabelereiro

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.RadioButton
import android.widget.Toast
import br.com.atividade.cabelereiro.service.OkHttpRequest
import okhttp3.Call
import okhttp3.Callback
import okhttp3.Response
import org.json.JSONObject
import java.io.IOException
import java.lang.Exception

class cadastrar : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_cadastrar)

        val txtLogin = findViewById<EditText>(R.id.tlCadastrartxtLogin)
        val txtSenha = findViewById<EditText>(R.id.tlCadastrartxtSenha)
        val txtNome = findViewById<EditText>(R.id.tlCadastrartxtNome)
        val txtCpf = findViewById<EditText>(R.id.tlCadastrartxtCPF)
        val rbtMascuino = findViewById<RadioButton>(R.id.tlCadastrarRbtMasculino)
        val rbtFeminino = findViewById<RadioButton>(R.id.tlCadastrarRbtFeminino)
        val txtTelefone = findViewById<EditText>(R.id.tlCadastrartxtTelefone)
        val txtEmail = findViewById<EditText>(R.id.tlCadastrartxtEmail)
        val txtTipo = findViewById<EditText>(R.id.tlCadastrartxtTipo)
        val txtLogradouro = findViewById<EditText>(R.id.tlCadastrartxtLogradouro)
        val txtNumero = findViewById<EditText>(R.id.tlCadastrartxtNumero)
        val txtComplemento = findViewById<EditText>(R.id.tlCadastrartxtComplemento)
        val txtCep = findViewById<EditText>(R.id.tlCadastrartxtCep)
        val txtBairro = findViewById<EditText>(R.id.tlCadastrartxtBairro)
        val txtCidade = findViewById<EditText>(R.id.tlCadastrartxtCidade)
        val txtEstado = findViewById<EditText>(R.id.tlCadastrartxtEstado)

        var mapUsuario:Map<String,String> = hashMapOf("login" to txtLogin.text.toString(),"senha" to txtSenha.text.toString())
        var mapContato:Map<String,String> = hashMapOf("telefone" to txtTelefone.text.toString(), "email" to txtEmail.text.toString())
        var mapEndereco:Map<String,String> = hashMapOf("tipo" to txtTipo.text.toString(), "logradouro" to txtLogradouro.text.toString(), "numero" to txtNumero.text.toString(),
            "complemento" to txtComplemento.text.toString(), "cep" to txtCep.text.toString(), "bairro" to txtBairro.text.toString(), "cidade" to txtCidade.text.toString(), "estado" to txtEstado.text.toString())

        var mapCliente:Map<String,String> = hashMapOf("nome" to txtNome.text.toString(), "cpf" to txtCpf.text.toString(), "sexo" to "M")







        val cadastrarBtnCadastrar = findViewById<Button>(R.id.tlCadastrarBtnCadastrar)

        cadastrarBtnCadastrar.setOnClickListener{
//            val principal = Intent(this, MainActivity::class.java)
//            startActivity(principal)

            val request = OkHttpRequest()
            request.POST("http://10.26.45.45/cabelereiro/data/us/cadastrar.php",mapUsuario,object : Callback {
                override fun onFailure(call: Call, e: IOException) {
                    Toast.makeText(this@cadastrar,"Erro ao tentar carregar dados"+e.message, Toast.LENGTH_LONG).show()
                }

                override fun onResponse(call: Call, response: Response) {
                    val responseData = response.body()?.string()

                    runOnUiThread{
                        try{
                            var json = JSONObject(responseData)
                            println("Dados cadastrados")
                            println(json)
                        }

                        catch (e: Exception){
                            e.printStackTrace()

                        }
                    }

                }


            })
        }


    }
}
