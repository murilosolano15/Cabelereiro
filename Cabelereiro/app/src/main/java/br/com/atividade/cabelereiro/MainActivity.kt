package br.com.atividade.cabelereiro

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.design.widget.NavigationView
import android.support.design.widget.Snackbar
import android.support.v4.view.GravityCompat
import android.support.v4.widget.DrawerLayout
import android.support.v7.app.ActionBarDrawerToggle
import android.support.v7.widget.Toolbar
import android.view.Menu
import android.view.MenuItem
import android.widget.Toast
import br.com.atividade.cabelereiro.service.OkHttpRequest
import okhttp3.*
import org.json.JSONObject
import java.io.IOException
import java.lang.Exception

class MainActivity : AppCompatActivity(), NavigationView.OnNavigationItemSelectedListener {


    val  client = OkHttpClient()


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //Teste de carregamento da API

        val request = OkHttpRequest()
        request.GET("http://10.26.45.45/cabelereiro/data/us/listar.php",object :Callback{
            override fun onFailure(call: Call, e: IOException) {
                Toast.makeText(this@MainActivity,"Erro ao tentar carregar dados"+e.message,Toast.LENGTH_LONG).show()
            }

            override fun onResponse(call: Call, response: Response) {
                val responseData = response.body()?.string()

                runOnUiThread{
                    try{
                    var json = JSONObject(responseData)
                    println("Encontramos os dados")
                    println(json)
                }

                catch (e:Exception){
                    e.printStackTrace()

                }
                }

            }


        })

       // run("http://10.26.45.45/cabelereiro/data/us/listar.php")



        val toolbar:Toolbar = findViewById(R.id.toolbar)

        setSupportActionBar(toolbar)

        val drawerLayout:DrawerLayout = findViewById(R.id.principal)

        val nav:NavigationView = findViewById(R.id.menuLateral)

        val toggle = ActionBarDrawerToggle(this, drawerLayout, toolbar, R.string.open_drawer,R.string.close_drawer)

        drawerLayout.addDrawerListener(toggle)
        toggle.syncState()

        nav.setNavigationItemSelectedListener (this)


    }

    override fun onNavigationItemSelected(p0: MenuItem): Boolean {
        when(p0.itemId){
            R.id.menuPerfil->{
                val tlPr = Intent(this,Perfil::class.java)
                startActivity(tlPr)
            }
            R.id.menuAgendar->{
                val tlAgenda = Intent(this, AgendarServico::class.java)
                startActivity(tlAgenda)
            }

            R.id.menuHistorico->{
                val tlHis = Intent(this,Historico::class.java)
                startActivity(tlHis
                )
            }
            R.id.menuPreco->{
                val tlPrc = Intent(this,Preco::class.java)
                startActivity(tlPrc
                )
            }
            R.id.menuProfissional->{
                val tlPro = Intent(this,Profissional::class.java)
                startActivity(tlPro
                )
            }
            R.id.menuUnidade->{
                val tlUni = Intent(this,Unidades::class.java)
                startActivity(tlUni
                )
            }
            R.id.menuPolitica->{
                val tlPol = Intent(this,Politica::class.java)
                startActivity(tlPol
                )
            }
            R.id.menuSair->{
                Toast.makeText(this,"Você saiu do aplicativo",Toast.LENGTH_LONG).show()

            }



        }
        val drawerLayout:DrawerLayout = findViewById(R.id.principal)
        drawerLayout.closeDrawer(GravityCompat.START)
        return true
    }

    override fun onBackPressed() {
        val drawerLayout:DrawerLayout = findViewById(R.id.principal)
        if(drawerLayout.isDrawerOpen(GravityCompat.START)){
            drawerLayout.closeDrawer(GravityCompat.START)
        }
         else{
            super.onBackPressed()
        }
    }

    //Ler o conteudo api
//    fun run(url:String){
//        val request = Request.Builder().url(url).build()
//
//        //fazer chamada e ser executada em segundo plano (CallBack) chamada em segundo plano
//        client.newCall(request).enqueue(object:Callback{
//            override fun onResponse(call: Call, response: Response) {
//                println(response.body()?.string())
//            }
//
//            override fun onFailure(call: Call, e: IOException) {
//                println("Falha ao tentar acessar os dados da api -> "+e.message)
//            }
//
//        })
//    }


}

