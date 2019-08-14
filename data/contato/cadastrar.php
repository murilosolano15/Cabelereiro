<?php

#Vamos definir os cabeçalhos de acesso e escrita de informações para a API

header("Access-Control-Allow-Origin:*");
header("Content-Type:application/json; charset=utf-8");
header("Access-Control-Allow-Methods: POST");
header("Access-Control-Max-Age:3600"); // Quanto tempo leva para processar o cadastro(1minuto)

// Importação da conexão como banco e dados
include_once "../../config/database.php";

// Importação da classe usuario
include_once "../../domain/contato.php";

// Iniciar a instancia do banco de dados
$database = new Database();

// Chamada da função de conexão com o banco de dados
$db = $database->getConnection();

// Instancia da classe usuario
$contato = new Contato($db);

/*
Vamos preparar o php para receber os dados que estão sendo enviados pelo usuario
Utilizaremos o comando php:/input
*/

$data = json_decode(file_get_contents("php://input"));

//Verificar se os dados enviados pelo usuario estão realmente com dados, se nao há nada vazio

if (!empty($data->telefone) && !empty($data->email)){ //"!" - é uma negação 

    $contato->telefone = $data->telefone;
    $contato->email = $data->email;
if($contato->cadastro()){
    header("HTTP/1.0 201");
    echo json_encode(array("mensagem"=>"Contato cadastrado com sucesso"));
}

 
else {
    header("HTTP/1.0 400");
    echo json_encode(array("mensagem"=>"Nao foi possivel cadastrar"));
     }
}
else{
    header("HTTP/1.0 400");
    echo json_encode(array("mensagem"=>"Voce deve passar todos os dados"));
}
?>