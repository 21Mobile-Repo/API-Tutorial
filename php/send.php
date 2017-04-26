<?php

$curl = curl_init();

curl_setopt_array($curl, array(
  CURLOPT_URL => "https://api.21mobile.com.br/v1/send",
  CURLOPT_RETURNTRANSFER => true,
  CURLOPT_ENCODING => "",
  CURLOPT_MAXREDIRS => 10,
  CURLOPT_TIMEOUT => 30,
  CURLOPT_HTTP_VERSION => CURL_HTTP_VERSION_1_1,
  CURLOPT_CUSTOMREQUEST => "POST",
  CURLOPT_POSTFIELDS => "{\"sms\": [{\"messageText\" : \"Tesnte API v1 21mobile\", \"destination\": \"11999999999\", \"correlationId\" : \"2u76543\"}]}\n",
  CURLOPT_HTTPHEADER => array(
    "authorization: Basic Zm9vOmJhcg==",
    "cache-control: no-cache",
    "content-type: application/json",
    "postman-token: 597bce62-a731-870e-b88d-b99ced1ba019"
  ),
));

$response = curl_exec($curl);
$err = curl_error($curl);

curl_close($curl);

if ($err) {
  echo "cURL Error #:" . $err;
} else {
  echo $response;
}
