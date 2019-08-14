package br.com.atividade.cabelereiro.service

import retrofit2.http.DELETE
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.PUT

interface HorarioService {
    @GET("horario/listar.php")
    fun listar()

    @POST("horario/cadastrar.php")
    fun cadastrar()

    @PUT("horario/atualizar.php")
    fun atualizar()

    @DELETE("horario/apagar.php")
    fun apagar()
}