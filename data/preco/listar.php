<?php

//permite o acesso a qualquer protocolo(https, http, file)

header("Access-Control-Allow-Origin:*"); // permitir o acesso controlado de todos os protocolos

//formato de trânsito, json com acentuação
header("Content-Type: application/json;charset=utf-8");

include_once "../../config/database.php"; // incluindo uma vez o arquivo database

include_once "../../domain/preco.php"; //incluindo os dmls(CRUDS)

$database = new Database();
$db = $database->getConnection(); // efetua a conexao com o banco

$preco = new Preco($db);

$stmt =$preco->listar();

if($stmt->rowCount()>0){
    $preco_arr = array();
    $preco_arr["saida"]=array();
    while($linha = $stmt->fetch(PDO::FETCH_ASSOC)){ // pegar todas a linhas que retornaram do banco e formar um novo array
        extract($linha);
        $array_item = array(
            "idpreco"=>$id,
            "preco"=>$preco
        );
        
        array_push($preco_arr["saida"],$array_item);
    }
    header('HTTP/1.0 200');
    echo json_encode($preco_arr);
}
else{
    header('HTTP/1.0 400');
    echo json_encode(array("mensagem"=>"Não há Precos cadastrados"));
}

?>