package com.learning.javaDemos.utils;

import org.yaml.snakeyaml.Yaml;

import java.io.IOException;
import java.io.InputStream;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.text.MessageFormat;
import java.util.Date;
import java.util.List;
import java.util.Map;

public class HttpUtils {
    private static final HttpUtils httpUtils = new HttpUtils();
    private final HttpClient httpClient;
    private final List<String> urls;

    private HttpUtils() {
        InputStream in = this.getClass().getClassLoader().getResourceAsStream("config.yaml");
        Yaml yaml = new Yaml();
        Map<String, Object> values = yaml.load(in);

        this.urls = (List<String>) values.get("urls");
        this.httpClient = HttpClient.newBuilder().build();
    }

    public static HttpUtils getInstance() {
        return httpUtils;
    }

    public List<String> getUrls() {
        return this.urls;
    }

    public Map<String, Integer> makeHttpCalls(String url) {
        HttpRequest request = HttpRequest.newBuilder(URI.create(url)).build();

        try {
            System.out.println(MessageFormat.format("[{0}]: Calling: {1}", new Date().toInstant(), url));
            HttpResponse<String> response = httpClient.send(request, HttpResponse.BodyHandlers.ofString());
            return Map.of(url, response.statusCode());
        } catch (IOException | InterruptedException e) {
            System.out.println(MessageFormat.format("Error while fetching data for {0}: {1}", url, e.getMessage()));
            return Map.of(url, 417);
        }
    }
}
