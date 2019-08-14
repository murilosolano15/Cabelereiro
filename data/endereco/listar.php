<?php

//permite o acesso a qualquer protocolo(https, http, file)

header("Access-Control-Allow-Origin:*"); // permitir o acesso controlado de todos os protocolos

//formato de trânsito, json com acentuação
header("Content-Type: application/json;charset=utf-8");

include_once "../../config/database.php"; // incluindo uma vez o arquivo database

include_once "../../domain/endereco.php"; //incluindo os dmls(CRUDS)

$database = new Database();
$db = $database->getConnection(); // efetua a conexao com o banco

$endereco = new Endereco($db);

$stmt =$endereco->listar();

if($stmt->rowCount()>0){
    $endereco_arr = array();
    $endereco_arr["saida"]=array();
    while($linha = $stmt->fetch(PDO::FETCH_ASSOC)){ // pegar todas a linhas que retornaram do banco e formar um novo array
        extract($linha);
        $array_item = array(
            "idendereco"=>$id,
            "tipo"=>$tipo,
            "logradouro"=>$logradouro,
            "numero"=>$numero,
            "complemento"=>$complemento,
            "cep"=>$cep,
            "bairro"=>$bairro,
            "cidade"=>$cidade,
            "estado"=>$estado

        );
        
        array_push($endereco_arr["saida"],$array_item);
    }
    header('HTTP/1.0 200');
    echo json_encode($endereco_arr);
}
else{
    header('HTTP/1.0 400');
    echo json_encode(array("mensagem"=>"Não há enderecos cadastrados"));
}

?>