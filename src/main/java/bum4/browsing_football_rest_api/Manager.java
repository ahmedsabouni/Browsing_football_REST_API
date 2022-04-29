package bum4.browsing_football_rest_api;

import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.google.gson.reflect.TypeToken;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

import java.io.IOException;
import java.lang.reflect.Type;
import java.util.List;

public class Manager {


    public Manager() {
    }

    public List<Competition> competions() {

        String body=request("competitions");
        System.out.println("**"+body);
        Gson gson = new Gson();
        JsonObject jsonObject ;
        jsonObject = gson.fromJson(body, JsonObject.class);
        Type competitionListType = new TypeToken<List<Competition>>(){}.getType();
        return gson.fromJson(jsonObject.get("competitions"), competitionListType);
    }

    String request(String endpoint) {
        String result="";
        OkHttpClient client = new OkHttpClient();
        Request request = new Request.Builder()
                .url("https://api.football-data.org/v2/"+endpoint)
                .get()
                .addHeader("X-Auth-Token",System.getenv("TOKEN"))
                .build();
        try {
            Response response = client.newCall(request).execute();
            if (response.code() == 200) {
                result = response.body().string();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return result;
    }





}
