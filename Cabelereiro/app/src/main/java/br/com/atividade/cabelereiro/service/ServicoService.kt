package br.com.atividade.cabelereiro.service

import retrofit2.http.DELETE
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.PUT

interface ServicoService {


    @GET("servico/listar.php")
    fun listar()

    @POST("servico/cadastrar.php")
    fun cadastrar()

    @PUT("servico/atualizar.php")
    fun atualizar()

    @DELETE("servico/apagar.php")
    fun apagar()
}