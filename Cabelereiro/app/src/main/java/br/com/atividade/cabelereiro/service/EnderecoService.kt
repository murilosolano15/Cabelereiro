package br.com.atividade.cabelereiro.service

import retrofit2.http.DELETE
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.PUT

interface EnderecoService {

    @GET("endereco/listar.php")
    fun listar()

    @POST("endereco/cadastrar.php")
    fun cadastrar()

    @PUT("endereco/atualizar.php")
    fun atualizar()

    @DELETE("endereco/apagar.php")
    fun apagar()
}