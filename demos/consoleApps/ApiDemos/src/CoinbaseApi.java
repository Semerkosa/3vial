import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;

public class CoinbaseApi {

    public static final String API_KEY = "";
    public static final String API_SECRET = "";

    public static final String BASE_URL = "https://api.coinbase.com/";
    public static final String REQUEST_METHOD = "GET";
    public static final String REQUEST_PATH = "/v2/accounts";
    public static final String REQUEST_BODY = "";

    public static void main(String[] args) throws URISyntaxException, IOException, InterruptedException {

        HttpClient client = HttpClient.newHttpClient();

        //The CB-ACCESS-TIMESTAMP header MUST be number of seconds since Unix Epoch in UTC.
        long timestamp = System.currentTimeMillis() / 1000;
        String message = timestamp + REQUEST_METHOD + REQUEST_PATH + REQUEST_BODY;
        String signature = generateHashWithHmac256(message, API_SECRET);

        HttpRequest request = HttpRequest.newBuilder()
                .uri(new URI(BASE_URL + REQUEST_PATH))
                .header("CB-ACCESS-KEY", API_KEY)
                .header("CB-ACCESS-TIMESTAMP", String.valueOf(timestamp))
                .header("CB-ACCESS-SIGN", signature)
                .GET()
                .build();

        HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());

        System.out.println("Status code: " + response.statusCode());
        System.out.println("JSON body: " + response.body());
    }

    public static String generateHashWithHmac256(String message, String apiSecret) {
        try {
            String hashingAlgorithm = "HmacSHA256"; //or "HmacSHA1", "HmacSHA512"
            byte[] bytes = hmac(hashingAlgorithm, apiSecret.getBytes(), message.getBytes());
            return bytesToHex(bytes);

        } catch (Exception e) {
            e.printStackTrace();
            return e.getMessage();
        }
    }

    public static byte[] hmac(String algorithm, byte[] key, byte[] message) throws NoSuchAlgorithmException, InvalidKeyException {
        Mac mac = Mac.getInstance(algorithm);
        mac.init(new SecretKeySpec(key, algorithm));
        return mac.doFinal(message);
    }

    public static String bytesToHex(byte[] bytes) {
        char[] hexArray = "0123456789abcdef".toCharArray();
        char[] hexChars = new char[bytes.length * 2];
        for (int j = 0, v; j < bytes.length; j++) {
            v = bytes[j] & 0xFF;
            hexChars[j * 2] = hexArray[v >>> 4];
            hexChars[j * 2 + 1] = hexArray[v & 0x0F];
        }
        return new String(hexChars);
    }
}
