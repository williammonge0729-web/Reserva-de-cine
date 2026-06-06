package Reserva_Cine;

import java.util.ArrayList;
import java.util.Scanner;

public class Reserva {

    public static final String CYAN = "\u001B[36m";
    public static final String RESET = "\u001B[0m";

    public static void gestionarReserva(String peliculaElegida, String horarioElegido) {

        Scanner entrada = new Scanner(System.in);

        String[][] asientos = new String[4][5];

        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 5; j++) {
                asientos[i][j] = "O";
            }
        }

        ArrayList<String> reservados = new ArrayList<>();

        double total = 0;

        int ninos = 0;
        int adolescentes = 0;
        int adultos = 0;

        mostrarAsientos(asientos);

        System.out.print(CYAN + "\n🎟 ¿Cuántos boletos desea comprar?: " + RESET);
        int cantidad = entrada.nextInt();

        for (int i = 0; i < cantidad; i++) {

            System.out.println(CYAN + "\n========== BOLETO " + (i + 1) + " ==========" + RESET);

            System.out.println("1. 👦 Niño ($3)");
            System.out.println("2. 🧑 Adolescente ($5)");
            System.out.println("3. 👨 Adulto ($7)");
            System.out.print("Seleccione una opción: ");

            int tipo = entrada.nextInt();
            double precio = 0;

            switch (tipo) {
                case 1:
                    precio = 3;
                    ninos++;
                    break;
                case 2:
                    precio = 5;
                    adolescentes++;
                    break;
                case 3:
                    precio = 7;
                    adultos++;
                    break;
                default:
                    System.out.println("❌ Opción inválida");
                    i--;
                    continue;
            }

            mostrarAsientos(asientos);

            System.out.print("Seleccione la fila (A-D): ");
            String letraFila = entrada.next().toUpperCase();

            int fila = letraFila.charAt(0) - 'A';

            System.out.print("Seleccione el asiento (1-5): ");
            int columna = entrada.nextInt() - 1;

            if (fila >= 0 && fila < 4 && columna >= 0 && columna < 5) {

                if (asientos[fila][columna].equals("O")) {

                    asientos[fila][columna] = "X";

                    reservados.add("Fila " + letraFila
                            + " - Asiento " + (columna + 1));

                    total += precio;

                    System.out.println("✅ Reserva realizada correctamente");
                    System.out.println("💵 Subtotal actual: $" + total);

                } else {

                    System.out.println("❌ Ese asiento ya está ocupado");
                    i--;
                }

            } else {

                System.out.println("❌ Asiento inválido");
                i--;
            }
        }

        System.out.println(CYAN + "\n========== RESUMEN DE COMPRA ==========" + RESET);

        System.out.println("👦 Niños: " + ninos);
        System.out.println("🧑 Adolescentes: " + adolescentes);
        System.out.println("👨 Adultos: " + adultos);

        System.out.println("\n🎟 Asientos reservados:");

        for (String asiento : reservados) {
            System.out.println("• " + asiento);
        }

        System.out.println("\n💰 Total a pagar: $" + total);

        System.out.print("\n💵 Ingrese dinero: $");
        double pago = entrada.nextDouble();

        if (pago >= total) {

            double cambio = pago - total;

            System.out.println(CYAN);
            System.out.println("╔══════════════════════════════════════╗");
            System.out.println("║         🎬 CINEMA STAR 🎬            ║");
            System.out.println("╚══════════════════════════════════════╝");
            System.out.println(RESET);

            System.out.println("🎥 Película : " + peliculaElegida);
            System.out.println("🕒 Horario  : " + horarioElegido);

            System.out.println("\n🎟 BOLETOS");
            System.out.println("👦 Niños: " + ninos);
            System.out.println("🧑 Adolescentes: " + adolescentes);
            System.out.println("👨 Adultos: " + adultos);

            System.out.println("\n💺 ASIENTOS");

            for (String asiento : reservados) {
                System.out.println("🎫 " + asiento);
            }

            System.out.println("\n💰 Total pagado : $" + total);
            System.out.println("💵 Cambio       : $" + cambio);

            System.out.println("\n🍿 ¡Disfrute la función!");
            System.out.println("══════════════════════════════════════");

        } else {

            System.out.println("❌ Dinero insuficiente. Reserva cancelada.");
        }
    }

    public static void mostrarAsientos(String[][] asientos) {

        System.out.println(CYAN);

        System.out.println("╔══════════════════════════════════════╗");
        System.out.println("║            🎬 PANTALLA 🎬            ║");
        System.out.println("╚══════════════════════════════════════╝");

        System.out.println("\n          ───── PASILLO ─────\n");

        System.out.println("         1    2      3    4    5");

        char filaLetra = 'A';

        for (int i = 0; i < asientos.length; i++) {

            System.out.print("Fila " + filaLetra + "   ");

            for (int j = 0; j < asientos[i].length; j++) {

                if (asientos[i][j].equals("O")) {
                    System.out.print("🟢   ");
                } else {
                    System.out.print("🔴   ");
                }

                if (j == 1) {
                    System.out.print("   ");
                }
            }

            filaLetra++;
            System.out.println();
        }

        System.out.println("\n🟢 Disponible");
        System.out.println("🔴 Ocupado");

        System.out.println(RESET);
    }
}