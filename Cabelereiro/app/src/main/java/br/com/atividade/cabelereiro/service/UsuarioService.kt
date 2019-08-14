package br.com.atividade.cabelereiro.service

import retrofit2.http.DELETE
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.PUT

interface UsuarioService {
    /*
    Neste serviço teremos as 4 operações basicas do Rest.
    @GET -> onde você fará as consultas
    @Post -> onde você fará os inserts (cadastro)
    @Put -> onde fará as atualizações
    @Delete -> onde fará as deleções
     */


    /*
    Abaixo estão os endpoints para acessar todos os usuarios e listá-los, cadastrar, atualizar e apagar.
    A urlBase foi construida no serviço principal do refroit que está no diretorio do Retroifit
     */

    @GET("us/listar.php")
    fun listar()

    @POST("us/cadastrar.php")
    fun cadastrar()

    @PUT("us/atualizar.php")
    fun atualizar()

    @DELETE("us/apagar.php")
    fun apagar()







}