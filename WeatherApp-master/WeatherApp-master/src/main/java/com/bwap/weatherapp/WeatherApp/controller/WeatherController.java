package com.bwap.weatherapp.WeatherApp.controller;


import java.io.IOException;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bwap.weatherapp.WeatherApp.model.Weather;

import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

@Service
public class WeatherController {
    private OkHttpClient client;
    private Response response;
    @Autowired
    private Weather weather;
    private String APIkey = "ba61e79a0119a86f77cc471643451b24";

    
    public JSONObject getWeather(){
        client = new OkHttpClient();  
        Request request = new Request.Builder()
                .url("http://api.openweathermap.org/data/2.5/weather?q="+weather.getCityName()+"&units="+weather.getUnit()+"&appid="+APIkey)
                .build();

        try {
            response = client.newCall(request).execute();
            return new JSONObject(response.body().string());
        }catch (IOException | JSONException e){
            e.printStackTrace();
        }
        return null;
    }
    

    
    
   
}
