package br.com.atividade.cabelereiro.domain

class Endereco {
    var idendereco:Int
    get() = idendereco
    set(value) {idendereco=value}



    var tipo:String
    get() = tipo
    set(value) {tipo=value}


    var logradouro:String
    get() = logradouro
    set(value) {logradouro=value}


    var numero:String
    get() = numero
    set(value) {numero=value}


    var complemento:String
    get() = complemento
    set(value){complemento=value}


    var cep:String
    get() = cep
    set(value){cep=value}


    var bairro:String
    get() = bairro
    set(value) {bairro=value}


    var cidade:String
    get() = cidade
    set(value) {cidade=value}


    var estado:String
    get() = estado
    set(value) {estado=value}


}