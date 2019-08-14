package br.com.atividade.cabelereiro.service

import android.graphics.ColorSpace
import okhttp3.*
import org.json.JSONArray
import retrofit2.http.POST

class OkHttpRequest {

    /*
    OkHttpClient:
    OKhttp é uma biblioteca para acesso a conteudos de api usando java ou usando Kotlin.
    Estamos consumindo o conteudo de api essa, por sua vez, está hospedada em um servidor.
    Por isso precisamos usar a classe na versão client do OkHttp
     */

    val client = OkHttpClient()

    /*
    O método GET foi criado para realizar a requisição de dados de uma api, independente de classe que esteja
    sendo usada no momento.
    Temos os parametros: url->onde você deve passar o endereco da api e callback->a maneira como será executada a chamada
    em segundo plano
     */

    fun GET(url:String, callback: Callback): Call{

        /*
        Vamos preparar a url para ser executada. Foi ultilizado o método Request(requisicao) com Builder(Construtor)
        url(Caminho da api) o build que realiza a construção da api para fazer a requisição
         */

        val request = Request.Builder().url(url).build()

        /*
        O comando client.newCall realiza uma chamada ao conteudo da api, porém não executa efetivamente.
        Isso será feito na ultilização
         */

        val call = client.newCall(request)
        /*
        O comando enqueue enfileira a lista de execução para que esta seja feita.
         */
        call.enqueue(callback)
        /*
        retorna os dados encontrados

         */
        return call
    }
    /*
    Objeto de conversão para Json
     */

companion object {
    val JSON = MediaType.parse("application/json;charset=utf-8")
}
    /*
    Criação do método para realizar o POST, ou seja, cadastrar os dados em banco de dados.
    No metodo POST está sendo pedido a url, um mapeamento e funcao de callback.
    url->O endereco da Api
    parameters:Map<STribg, String> -> Neste ponto está sendo pedido os elementos referentes ao conteudo de dados Json.
    Você deve lembrar que o conteudo de um json é sempre dividido em 2 partes, sendo essa uma ao lado esquerdo e outra ao direito.
    DO lado esquerdo é a representação do que está em banco de dados e ao lado direito é valor que se deseja inserir no banco.
    Portanto o ecxemplo abaixo mostra como se dara o mapeamento dos dados
    {"login": "admin"}
    Map<String,String>
     */
    fun POST(url:String, parameters:Map<String,String>, callback: Callback):Call{

        /*
        A constante builder foi criada para formar(contruir|Builder) a estrutura de dados
         */

        val builder = FormBody.Builder()
        /*
        a constante it foi criada para realizar a interação no mapeamento do json.
        Como iremos passar vários dados para serem cadastrados sera
        necessario a interação dos dados com iterator
         */


        val it = parameters.entries.iterator()
        /*
        O laço while verifica se há dados no mapeamento, caso afirmativo é realizada a construção de um par(pair) de dados.
        Onde key=> é o campo no banco de dados e value=> é a informação que se deseja cadastrar no banco
         */


        while(it.hasNext()){
            val pair = it.next() as Map.Entry<*,*>
            builder.add(pair.key.toString(),pair.value.toString())

        }
        /*
        Depois de construi as infromações no mapeamento acima, chegou a hora de formar a estrutura  de dados que será executada
         */



        val formBody = builder.build()
        val request = Request.Builder()
            .url(url)
            .post(formBody)
            .build()

        val call = client.newCall(request)
        call.enqueue(callback)
        return call

    }


}