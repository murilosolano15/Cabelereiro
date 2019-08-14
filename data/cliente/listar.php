<?php

//permite o acesso a qualquer protocolo(https, http, file)

header("Access-Control-Allow-Origin:*"); // permitir o acesso controlado de todos os protocolos

//formato de trânsito, json com acentuação
header("Content-Type: application/json;charset=utf-8");

include_once "../../config/database.php"; // incluindo uma vez o arquivo database

include_once "../../domain/cliente.php"; //incluindo os dmls(CRUDS)

$database = new Database();
$db = $database->getConnection(); // efetua a conexao com o banco

$cliente = new Cliente($db);

$stmt =$cliente->listar();

if($stmt->rowCount()>0){
    $cliente_arr = array();
    $cliente_arr["saida"]=array();
    while($linha = $stmt->fetch(PDO::FETCH_ASSOC)){ // pegar todas a linhas que retornaram do banco e formar um novo array
        extract($linha);
        $array_item = array(
            "idcliente"=>$id,
            "nome"=>$nome,
            "cpf"=>$cpf,
            "sexo"=>$sexo,
            "idendereco"=>$idendereco,
            "idcontato"=>$idcontato,
            "idusuario"=>$idusuario,

        );
        
        array_push($cliente_arr["saida"],$array_item);
    }
    header('HTTP/1.0 200');
    echo json_encode($cliente_arr);
}
else{
    header('HTTP/1.0 400');
    echo json_encode(array("mensagem"=>"Não há clientes cadastrados"));
}

?>