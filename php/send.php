<?php

$curl = curl_init();

$basic = base64_encode("USERNAME" . ":" . "PASSWORD");
$messageText = "TESTE API v1 21MOBILE";
$destination = "11999999999";
$correlationId = "idDeControle";

$json = json_encode(array("sms" => array(array("messageText" => $messageText, "destination" => $destination, "correlationId" => $correlationId))));

curl_setopt_array($curl, array(
  CURLOPT_URL => "https://api.21mobile.com.br/v1/send",
  CURLOPT_RETURNTRANSFER => true,
  CURLOPT_ENCODING => "",
  CURLOPT_MAXREDIRS => 10,
  CURLOPT_TIMEOUT => 30,
  CURLOPT_HTTP_VERSION => CURL_HTTP_VERSION_1_1,
  CURLOPT_CUSTOMREQUEST => "POST",
  CURLOPT_POSTFIELDS => $json,
  CURLOPT_HTTPHEADER => array(
    "authorization: Basic $basic",
    "cache-control: no-cache",
    "content-type: application/json",
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
