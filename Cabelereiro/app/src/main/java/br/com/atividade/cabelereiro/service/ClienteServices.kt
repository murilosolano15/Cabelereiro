package br.com.atividade.cabelereiro.service

import retrofit2.http.DELETE
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.PUT


interface ClienteServices {

    @GET("cliente/listar.php")
    fun listar()

    @POST("cliente/cadastrar.php")
    fun cadastrar()

    @PUT("cliente/atualizar.php")
    fun atualizar()

    @DELETE("cliente/apagar.php")
    fun apagar()
}