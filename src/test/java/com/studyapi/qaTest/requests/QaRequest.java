package com.studyapi.qaTest.requests;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import okhttp3.*;

public class QaRequest {

    private final OkHttpClient client;
    private final String baseUrl;


    public QaRequest(String baseUrl) {
        this.baseUrl = baseUrl;
        this.client = new OkHttpClient();
    }

    public Response createQa(String name, String country) throws Exception {
        MediaType mediaType = MediaType.parse("application/json");
        String jsonBody = String.format("{\"name\": \"%s\", \"country\": \"%s\"}", name, country);
        RequestBody body = RequestBody.create(mediaType, jsonBody);

        Request request = new Request.Builder()
                .url(baseUrl + "/qa")
                .method("POST", body)
                .addHeader("Content-Type", "application/json")
                .build();

        return client.newCall(request).execute();
    }

    public Response updateQa(int id, String name, String country) throws Exception {
        MediaType mediaType = MediaType.parse("application/json");
        String jsonBody = String.format("{\"name\": \"%s\", \"country\": \"%s\"}", name, country);
        RequestBody body = RequestBody.create(mediaType, jsonBody);

        Request request = new Request.Builder()
                .url(baseUrl + "/qa/" + id)
                .method("PUT", body)
                .addHeader("Content-Type", "application/json")
                .build();

        return client.newCall(request).execute();
    }

    public Response deleteQa(int id) throws Exception {
        Request request = new Request.Builder()
                .url(baseUrl + "/qa/" + id)
                .method("DELETE", null)
                .build();

        return client.newCall(request).execute();
    }

    public Response getAllQas() throws Exception {
        Request request = new Request.Builder()
                .url(baseUrl + "/qa")
                .method("GET", null)
                .build();

        return client.newCall(request).execute();
    }
    public int extractIdFromJsonResponse(String responseBody) throws Exception {
        ObjectMapper objectMapper = new ObjectMapper();
        JsonNode jsonNode = objectMapper.readTree(responseBody);

        if (jsonNode.has("id")) {
            return jsonNode.get("id").asInt();
        } else {
            throw new Exception("ID not found in JSON response");
        }
    }

    public int getQaIdById(int id) throws Exception {
        Request request = new Request.Builder()
                .url(baseUrl + "/qa/" + id)
                .method("GET", null)
                .build();

        Response response = client.newCall(request).execute();
        if (response.code() == 200) {
            String responseBody = response.body().string();
            return extractIdFromJsonResponse(responseBody);
        } else if (response.code() == 404) {
            throw new Exception("QA with ID " + id + " not found");
        } else {
            throw new Exception("Failed to retrieve QA with ID: " + id);
        }
    }


}
