<?php

$curl = curl_init();

curl_setopt_array($curl, array(
  CURLOPT_URL => "http://apinew.local.area/v1/credits",
  CURLOPT_RETURNTRANSFER => true,
  CURLOPT_ENCODING => "",
  CURLOPT_MAXREDIRS => 10,
  CURLOPT_TIMEOUT => 30,
  CURLOPT_HTTP_VERSION => CURL_HTTP_VERSION_1_1,
  CURLOPT_CUSTOMREQUEST => "GET",
  CURLOPT_HTTPHEADER => array(
    "authorization: Basic Zm9vOmJhcg==",
    "cache-control: no-cache",
    "postman-token: 134f6408-9945-9ac7-01ab-bca88fc71398"
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
