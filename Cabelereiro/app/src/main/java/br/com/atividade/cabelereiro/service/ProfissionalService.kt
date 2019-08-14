package br.com.atividade.cabelereiro.service

import retrofit2.http.DELETE
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.PUT

interface ProfissionalService {
    @GET("profissional/listar.php")
    fun listar()

    @POST("profissional/cadastrar.php")
    fun cadastrar()

    @PUT("profissional/atualizar.php")
    fun atualizar()

    @DELETE("profissional/apagar.php")
    fun apagar()
}