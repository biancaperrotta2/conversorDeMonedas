package Services;

import com.google.gson.Gson;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class ConversorService {
    public double obtenerTasaCambio(String monedaBase, String monedaDestino) {
        String url = "https://v6.exchangerate-api.com/v6/fa6f0265a5ef6684ea4c25ec/pair/" + monedaBase + "/" + monedaDestino;

        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(url))
                .build();

        try {
            HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());

            String json = response.body();
            Gson gson = new Gson();
            RespuestaConversion respuesta = gson.fromJson(json, RespuestaConversion.class);

            if ("success".equalsIgnoreCase(respuesta.result())) {
                return respuesta.conversion_rate();
            } else {
                System.out.println("La API no devolvió un resultado exitoso.");
                return -1;
            }

        } catch (IOException | InterruptedException e) {
            System.out.println("Error al obtener la tasa: " + e.getMessage());
            return -1;
        }
    }

    public double convertir (double cantidad, double conversion_rate){
        return cantidad * conversion_rate;
    }
}

