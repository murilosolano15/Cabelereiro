package br.com.atividade.cabelereiro.service

import retrofit2.http.DELETE
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.PUT

interface PrecoService {
    @GET("preco/listar.php")
    fun listar()

    @POST("preco/cadastrar.php")
    fun cadastrar()

    @PUT("preco/atualizar.php")
    fun atualizar()

    @DELETE("preco/apagar.php")
    fun apagar()
}