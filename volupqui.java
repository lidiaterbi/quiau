import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.net.http.HttpRequest.BodyPublishers;

public class Main {
    public static void main(String[] args) throws Exception {
        var url = "http://31.129.97.50:8000/utochnenie_diagnoza";
        var client = HttpClient.newHttpClient();
        var request = HttpRequest.newBuilder()
                .uri(URI.create(url))
                .header("Content-Type", "application/json")
                .POST(BodyPublishers.ofString("{\"data\":\"dataTest\"}"))
                .build();

        var response = client.send(request, HttpResponse.BodyHandlers.ofString());
        
        if (response.statusCode() == 200) {
            System.out.println("Success: " + response.body());
        } else {
            System.out.println("Failed: " + response.statusCode() + ", " + response.body());
        }
    }
}
