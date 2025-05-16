package com.bluelanka_guide.services;

import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class CurrencyAPIConnection {
    public double getExchangeRates(String currency1, String currency2) {
        try {
            // API key for the exchange rate API
            String apiKey = "a3e2c66397453eb563cb3220";
            String urlString ="https://v6.exchangerate-api.com/v6/" + apiKey + "/latest/" + currency1 ;

            URL url = new URL(urlString);
            HttpURLConnection request = (HttpURLConnection) url.openConnection();
            request.connect();

            JsonParser jp = new JsonParser();
            JsonElement root = jp.parse(new InputStreamReader((InputStream) request.getContent()));
            JsonObject jsonobj = root.getAsJsonObject();

            JsonObject conversionRates = jsonobj.getAsJsonObject("conversion_rates");
            return conversionRates.get(currency2).getAsDouble();

        } catch (Exception e) {
            System.out.println(e.getMessage());
            return -1;
        }
    }
}
