package Modelo;

import Services.ConversorService;
import Services.RespuestaConversion;

import java.util.Scanner;

public class Conversor {
    Scanner entrada = new Scanner(System.in);
    ConversorService service = new ConversorService();
    boolean desicion = true;

    public void eleccionUserMenu() {
        while (desicion) {
            System.out.println("**************************************");
            System.out.println("Sea bienvenido/a al conversor de monedas!!!");
            System.out.println("""
                1) Dólar => Peso argentino
                2) Peso argentino => Dólar
                3) Dólar => Real brasileño
                4) Real brasileño => Dólar
                5) Dólar => Peso colombiano
                6) Peso colombiano => Dólar
                7) Salir""");
            System.out.println("Elija una opción válida:");
            int numero = entrada.nextInt();

            switch (numero) {
                case 1 -> convertirMoneda("USD", "ARS");
                case 2 -> convertirMoneda("ARS", "USD");
                case 3 -> convertirMoneda("USD", "BRL");
                case 4 -> convertirMoneda("BRL", "USD");
                case 5 -> convertirMoneda("USD", "COP");
                case 6 -> convertirMoneda("COP", "USD");
                case 7 -> {
                    System.out.println("¡Gracias por usar el conversor!");
                    desicion = false;
                }
                default -> System.out.println("Opción no válida. Intente de nuevo.");
            }

            System.out.println();
        }
    }

    private void convertirMoneda(String base, String destino) {
        System.out.print("Ingrese el valor que desea convertir: ");
        double valor = entrada.nextDouble();

        double tasa = service.obtenerTasaCambio(base, destino);
        if (tasa != -1) {
            double resultado = service.convertir(valor, tasa);
            System.out.printf("%.2f %s equivale a %.2f %s%n", valor, base, resultado, destino);
        } else {
            System.out.println("No se pudo obtener la tasa de conversión.");
        }
    }
}
