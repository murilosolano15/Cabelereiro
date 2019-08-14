package br.com.atividade.cabelereiro.domain

import java.sql.Date
import java.sql.Time

class Horario {

    var idhorario:Int
    get() = idhorario
    set(value) {idhorario=value}


    var idcliente:Int
    get() = idcliente
    set(value) {idcliente=value}


    var idservico:Int
    get() = idservico
    set(value) {idservico=value}


    var idprofissional:Int
    get() = idprofissional
    set(value) {idprofissional=value}


    var idunidade:Int
    get() = idunidade
    set(value) {idunidade=value}


    var dia:Date
    get() = dia
    set(value) {dia=value}


    var hora:Time
    get() = hora
    set(value) {hora=value}


}