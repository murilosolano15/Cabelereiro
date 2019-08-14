package br.com.atividade.cabelereiro.service

import retrofit2.http.DELETE
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.PUT

interface ContatoService {

    @GET("contato/listar.php")
    fun listar()

    @POST("contato/cadastrar.php")
    fun cadastrar()

    @PUT("contato/atualizar.php")
    fun atualizar()

    @DELETE("contato/apagar.php")
    fun apagar()


}