package com.bluelanka_guide.services;

import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class UnitConverterAPIConnection {

    public double getConvertedData(String amount, String from, String to){

        String apiKey = "6b82daae-3c68-49da-bcfc-c3fe6b13760e";
        String urlStr = "https://api.apiverve.com/v1/unitconverter?value=" +amount + "&from=" + from + "&to=" + to;

        HttpRequest request = HttpRequest.newBuilder().uri(URI.create(urlStr)).header("x-api-key", apiKey).method("GET", HttpRequest.BodyPublishers.noBody()).build();
        HttpResponse<String> response = null;

        try {
            response = HttpClient.newHttpClient().send(request, HttpResponse.BodyHandlers.ofString());
        } catch (IOException  | InterruptedException e) {
            System.out.println("API request failed: "+ e.getMessage());
        }

        JsonObject JsonResponse = JsonParser.parseString(response.body()).getAsJsonObject();
        try{
            JsonObject getData = JsonResponse.getAsJsonObject("data");
            JsonObject getResult = getData.getAsJsonObject("result");
            return getResult.get("result").getAsDouble();
        } catch (Exception e) {
            System.out.println("Data Fetching Error:" + e.getMessage());
        }

        return 0.0;
    }

}
