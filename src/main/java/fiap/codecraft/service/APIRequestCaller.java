package fiap.codecraft.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.Map;

@Component
public class APIRequestCaller {

    private ObjectMapper objectMapper;

    public APIRequestCaller(ObjectMapper objectMapper) {
        this.objectMapper = objectMapper;
    }

    public String get(String url) throws IOException, InterruptedException {
        HttpRequest request = HttpRequest.newBuilder(URI.create(url))
                .GET()
                .build();

        HttpResponse<String> response = HttpClient
                .newBuilder()
                .build()
                .send(request, HttpResponse.BodyHandlers.ofString());
        System.out.println("APIRequestCaller response: " + response.statusCode() + " jsonBody: " + response.body());
        return response.body();
    };

    public String post(String url, Map<String, String> headers, String jsonBody) throws IOException, InterruptedException{

        HttpRequest.Builder httpBuilder = HttpRequest.newBuilder(URI.create(url));

        for(Map.Entry<String, String> entry : headers.entrySet()){
            httpBuilder.header(entry.getKey(), entry.getValue());
        }

        HttpRequest request = httpBuilder.POST(HttpRequest.BodyPublishers.ofString(jsonBody))
                .build();

        HttpResponse<String> response = HttpClient
                .newBuilder()
                .build()
                .send(request, HttpResponse.BodyHandlers.ofString());

        return response.body();
    }
}
