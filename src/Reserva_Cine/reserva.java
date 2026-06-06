package Reserva_Cine;

import java.util.ArrayList;
import java.util.Scanner;

public class reserva {

    public static final String CYAN = "\u001B[36m";
    public static final String RESET = "\u001B[0m";

    public static void gestionarReserva(String peliculaElegida, String horarioElegido) {

        Scanner entrada = new Scanner(System.in);

        // 4 filas y 5 asientos
        String asientos[][] = new String[4][5];

        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 5; j++) {
                asientos[i][j] = "O";
            }
        }

        ArrayList<String> reservados = new ArrayList<>();
        double total = 0;

        mostrarAsientos(asientos);

        System.out.print(CYAN + "\n¿Cuántos boletos desea?: " + RESET);
        int cantidad = entrada.nextInt();

        for (int i = 0; i < cantidad; i++) {

            System.out.println(CYAN + "\n========== RESERVA " + (i + 1) + " ==========" + RESET);

            System.out.println("Tipo de persona");
            System.out.println("1. Niño ($3)");
            System.out.println("2. Adolescente ($5)");
            System.out.println("3. Adulto ($7)");
            System.out.print("Seleccione: ");

            int tipo = entrada.nextInt();
            double precio = 0;

            switch (tipo) {
                case 1:
                    precio = 3;
                    break;
                case 2:
                    precio = 5;
                    break;
                case 3:
                    precio = 7;
                    break;
                default:
                    System.out.println("❌ Opción incorrecta");
                    i--;
                    continue;
            }

            total += precio;

            mostrarAsientos(asientos);

            System.out.print("Fila (1-4): ");
            int fila = entrada.nextInt() - 1;

            System.out.print("Asiento (1-5): ");
            int columna = entrada.nextInt() - 1;

            if (fila >= 0 && fila < 4 && columna >= 0 && columna < 5) {

                if (asientos[fila][columna].equals("O")) {

                    asientos[fila][columna] = "X";

                    reservados.add("Fila " + (fila + 1)
                            + " - Asiento " + (columna + 1));

                    System.out.println("✅ Asiento reservado correctamente");

                } else {

                    System.out.println("❌ Ese asiento ya está ocupado");
                    i--;
                }

            } else {

                System.out.println("❌ Asiento inválido");
                i--;
            }
        }

        System.out.println(CYAN + "\n========== PAGO ==========" + RESET);
        System.out.println("Total a pagar: $" + total);

        System.out.print("Ingrese dinero: $");
        double pago = entrada.nextDouble();

        if (pago >= total) {

            double cambio = pago - total;

            System.out.println(CYAN + "\n========== CONFIRMACIÓN ==========" + RESET);
            System.out.println("✅ Pago realizado correctamente");
            System.out.println("Película: " + peliculaElegida);
            System.out.println("Horario: " + horarioElegido);

            System.out.println("\nAsientos reservados:");

            for (String asiento : reservados) {
                System.out.println("• " + asiento);
            }

            System.out.println("\nCambio: $" + cambio);

        } else {

            System.out.println("❌ Dinero insuficiente. Reserva cancelada.");
        }
    }

    public static void mostrarAsientos(String asientos[][]) {

        System.out.println(CYAN);

        System.out.println("\n=================================");
        System.out.println("           PANTALLA");
        System.out.println("=================================\n");

        for (int i = 0; i < asientos.length; i++) {

            System.out.printf("Fila %-2d ", (i + 1));

            for (int j = 0; j < asientos[i].length; j++) {

                if (asientos[i][j].equals("O")) {
                    System.out.print("💺 ");
                } else {
                    System.out.print("❌ ");
                }
            }

            System.out.println();
        }

        System.out.println("\n💺 = Disponible");
        System.out.println("❌ = Ocupado");

        System.out.println(RESET);
    }
}