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
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import org.apache.commons.codec.binary.Base64;

/**
 *
 * @author rafael_21
 */
public class ConsultaStatus {

    public void consulta() throws MalformedURLException, IOException {
        URL url = new URL("https://api.21mobile.com.br/v1/status");
        HttpURLConnection connection = (HttpURLConnection) url.openConnection();
        connection.setDoOutput(true);
        connection.setInstanceFollowRedirects(false);
        connection.setUseCaches(false);

        connection.setRequestMethod("GET");
        connection.setRequestProperty("Host", "api.21mobile.com.br");
        connection.setRequestProperty("Content-Type", "application/json");

        //Monta Token de autenticacao
        String autenticacao = "Login:Senha";
        byte[] encoded = Base64.encodeBase64(autenticacao.getBytes());
        connection.setRequestProperty("Authorization", "Basic " + new String(encoded));

        System.err.println(connection.getResponseCode());
        System.err.println(connection.getResponseMessage());

        InputStream in = connection.getInputStream();
        InputStreamReader ins = new InputStreamReader(in, "UTF-8");
        BufferedReader streamReader = new BufferedReader(ins);

        System.err.println(streamReader.readLine());

    }

    public void consultaComData(long timestampUnix) throws MalformedURLException, IOException {

        URL url = new URL("https://api.21mobile.com.br/v1/status/date/?date=" + timestampUnix);
        HttpURLConnection connection = (HttpURLConnection) url.openConnection();
        connection.setDoOutput(true);
        connection.setInstanceFollowRedirects(false);
        connection.setUseCaches(false);

        connection.setRequestMethod("GET");
        connection.setRequestProperty("Host", "api.21mobile.com.br");
        connection.setRequestProperty("Content-Type", "application/json");

        //Monta Token de autenticacao
        String autenticacao = "Login:Senha";
        byte[] encoded = Base64.encodeBase64(autenticacao.getBytes());
        connection.setRequestProperty("Authorization", "Basic " + new String(encoded));

        System.err.println(connection.getResponseCode());
        System.err.println(connection.getResponseMessage());

        //recebe o input da conexao e interpreta 
        InputStream in = connection.getInputStream();
        InputStreamReader ins = new InputStreamReader(in, "UTF-8");
        BufferedReader streamReader = new BufferedReader(ins);

        System.err.println(streamReader.readLine());

    }
}
