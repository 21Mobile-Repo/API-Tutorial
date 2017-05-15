/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Requisicoes;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.time.Instant;
import org.json.JSONException;
import org.json.JSONObject;
import org.json.JSONArray;
import org.apache.commons.codec.binary.Base64;

/**
 *
 * @author rafael_21
 */
public class Envio {

    public void MandaSMS() throws JSONException, MalformedURLException, IOException {
        //Monta objeto Json
        JSONObject JsonMsg = new JSONObject();

        //Mensagem a ser enviada
        JsonMsg.put("messageText", "Mensagem a ser enviada");

        //destinatario
        JsonMsg.put("destination", "51999999999");

        //Identificador 
        JsonMsg.put("correlationId", "21Mobile");

        //Data no formato atual no formato UNIX Timestamp
        JsonMsg.put("scheduledDate", Instant.now().getEpochSecond());

        //inicializa Array com todos os objetos contendo as SMSs a serem enviadas
        JSONArray arrayJson = new JSONArray();

        arrayJson.put(JsonMsg);

        //Monta Json final a ser enviado com o array ja alimentado
        JSONObject JsonFinal = new JSONObject();
        JsonFinal.put("sms", arrayJson);

        //inicializa objeto de url
        URL url = new URL("https://api.21mobile.com.br/v1/send");
        HttpURLConnection connection = (HttpURLConnection) url.openConnection();

        connection.setDoOutput(true);
        connection.setInstanceFollowRedirects(false);
        connection.setUseCaches(false);
        //seta metodo POST para o envio do sms
        connection.setRequestMethod("POST");
        connection.setRequestProperty("Host", "api.21mobile.com.br");
        connection.setRequestProperty("Accept", "application/json");
        connection.setRequestProperty("Content-Type", "application/json");

        //Monta Token de autenticacao
        String autenticacao = "Login:Senha";
        byte[] encoded = Base64.encodeBase64(autenticacao.getBytes());
        connection.setRequestProperty("Authorization", "Basic " + new String(encoded));

        connection.setRequestProperty("Content-Type", "application/json");

        connection.connect();

        OutputStream os = connection.getOutputStream();
        os.write(JsonFinal.toString().getBytes("UTF-8"));
        os.close();

        System.err.println("Codigo da Requisição: ");
        System.err.println(connection.getResponseCode());
        System.err.println("Mensagem Resposta da Requisição: ");
        System.err.println(connection.getResponseMessage());

        InputStream in = connection.getInputStream();
        InputStreamReader ins = new InputStreamReader(in, "UTF-8");
        BufferedReader streamReader = new BufferedReader(ins);

        String result;

        result = streamReader.readLine();
        System.err.println(result);

    }

}
