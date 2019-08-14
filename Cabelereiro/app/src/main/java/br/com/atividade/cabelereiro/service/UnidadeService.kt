package br.com.atividade.cabelereiro.service

import retrofit2.http.DELETE
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.PUT

interface UnidadeService {


    @GET("unidade/listar.php")
    fun listar()

    @POST("unidade/cadastrar.php")
    fun cadastrar()

    @PUT("unidade/atualizar.php")
    fun atualizar()

    @DELETE("unidade/apagar.php")
    fun apagar()
}