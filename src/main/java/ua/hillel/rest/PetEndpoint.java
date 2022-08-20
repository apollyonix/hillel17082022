package ua.hillel.rest;

import com.google.gson.Gson;
import okhttp3.*;
import org.json.JSONArray;
import org.json.JSONObject;
import org.json.JSONWriter;
import ua.hillel.rest.entities.Pet;

import java.io.IOException;

/**
 * @author Maxim Karpenko mkarpenko@modeln.com
 */

public class PetEndpoint {
  public void getPetById(int id) throws IOException {

    Request request = new Request.Builder()
        .get()
        .url("https://petstore.swagger.io/v2/pet/" + id)
        .build();

    OkHttpClient client = new OkHttpClient();
    Response response = client.newCall(request).execute();
    System.out.println(response.body().string());
  }


  public void createPet() throws IOException {
    String json = "{\n" + "  \"id\": 0,\n" + "  \"category\": {\n" + "    \"id\": 0,\n"
        + "    \"name\": \"string\"\n" + "  },\n" + "  \"name\": \"doggie\",\n"
        + "  \"photoUrls\": [\n" + "    \"string\"\n" + "  ],\n" + "  \"tags\": [\n" + "    {\n"
        + "      \"id\": 0,\n" + "      \"name\": \"string\"\n" + "    }\n" + "  ],\n"
        + "  \"status\": \"available\"\n" + "}";

    RequestBody requestBody = RequestBody.create(json.getBytes());
//    RequestBody requestBody = RequestBody.create(MediaType.parse("application/json"), json);

    Request request = new Request.Builder()
        .post(requestBody)
        .url("https://petstore.swagger.io/v2/pet")
//        .header("Content-Type", "application/json")
        .build();

    OkHttpClient client = new OkHttpClient();
    Response response = client.newCall(request).execute();
    System.out.println(response.body().string());
  }


  public String createPetWithJSON(String name, String status) throws IOException {
    JSONObject category = new JSONObject();
    category.put("name", "name");

    JSONObject jsonObject = new JSONObject();
    jsonObject.put("name", name);
    jsonObject.put("status", status);
    jsonObject.put("newField", "newValue");
    jsonObject.put("price", 100);
    jsonObject.put("isActive", true);
    jsonObject.put("category", category);


    RequestBody requestBody = RequestBody.create(jsonObject.toString().getBytes());

    Request request = new Request.Builder()
        .post(requestBody)
        .url("https://petstore.swagger.io/v2/pet")
        .header("Content-Type", "application/json")
        .build();

    OkHttpClient client = new OkHttpClient();
    Response response = client.newCall(request).execute();
    String responseBody = response.body().string();
    System.out.println(responseBody);

    jsonObject = new JSONObject(responseBody);
    return jsonObject.get("id").toString();
  }


  public Pet createPetWithGson(Pet pet) throws IOException {
    Gson gson = new Gson();
    String petString = gson.toJson(pet);

    RequestBody requestBody = RequestBody.create(petString.getBytes());

    Request request = new Request.Builder()
        .post(requestBody)
        .url("https://petstore.swagger.io/v2/pet")
        .header("Content-Type", "application/json")
        .build();

    OkHttpClient client = new OkHttpClient();
    Response response = client.newCall(request).execute();
    String responseBody = response.body().string();
    System.out.println(responseBody);


    Pet newPet = gson.fromJson(responseBody, Pet.class);
    return newPet;
  }
}
