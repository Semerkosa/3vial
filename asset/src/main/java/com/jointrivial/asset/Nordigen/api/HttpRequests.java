package com.jointrivial.asset.Nordigen.api;

import java.io.IOException;
import java.net.*;
import java.net.http.*;

public class HttpRequests {
    private static final HttpClient client = HttpClient.newHttpClient();

    // country's alpha 2 code(bg, en, ....)
    public static String availableBanks(String country) throws IOException, InterruptedException, URISyntaxException {

        // HTTP/2 protocol, by default. Another version could be defined.
        HttpRequest request = HttpRequest.newBuilder()
                .uri(new URI("https://ob.nordigen.com/api/aspsps/?country=" + country))
                .header("Authorization", "Token 8ebcc40fa36d43bbfc13326817fa42a5824f481a")
                .GET()
                .build();

        // The Nordigen response bodies' are always in JSON format
        HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());

        int responseCode = response.statusCode();

        if (responseCode == 200) {
           return response.body();
        }

        return "Something went wrong with the request!";
    }
}


