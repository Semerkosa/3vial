package com.jointrivial.asset.nordigen.api;

import org.springframework.stereotype.Component;

import java.io.IOException;
import java.net.*;
import java.net.http.*;

@Component
public class HttpRequests {
    private static final HttpClient client = HttpClient.newHttpClient();

    // country's alpha 2 code(bg, de, gb, ....). There are some exceptions(gb == gbr, both work)
    public String allBanksInCountry(String country) throws IOException, InterruptedException, URISyntaxException {

        // HTTP/2 protocol, by default. Another version could be defined.
        HttpRequest request = HttpRequest.newBuilder()
                .uri(new URI("https://ob.nordigen.com/api/aspsps/?country=" + country))
                .header("Authorization", "Token 8ebcc40fa36d43bbfc13326817fa42a5824f481a")
                .GET()
                .build();

        // The Nordigen responses are always in JSON format
        HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());

        if (response.statusCode() == 200) {
            return response.body();
        }

        // TODO handle exception properly
        return null;
    }
}
