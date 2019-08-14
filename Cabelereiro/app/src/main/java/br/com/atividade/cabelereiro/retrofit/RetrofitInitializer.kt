package br.com.atividade.cabelereiro.retrofit

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class RetrofitInitializer {

        /*
        A função init inicializa a comunicação com o servidor de API
         */

        fun init(){

            /*
            Retrofit.Builder=>Constrtutor de url base para acesso ao conteudo da API.
            addConverterFactory=>Usando um mecanismo para realizar a conversão de json para android para json.
            build=> realiza a construção da url base
             */

            Retrofit.Builder().baseUrl("http://10.26.45.45/cabelereiro/data/").addConverterFactory(GsonConverterFactory.create()).build()

    }



}