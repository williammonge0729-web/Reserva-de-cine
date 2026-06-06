package Reserva_Cine;

import java.util.ArrayList;
import java.util.Scanner;

public class reserva {

<<<<<<< HEAD
    public static final String CYAN = "\u001B[36m";
    public static final String RESET = "\u001B[0m";

    public static void gestionarReserva(String peliculaElegida, String horarioElegido) {

=======
	public static void gestionarReserva(String peliculaElegida, String horarioElegido) {
        
>>>>>>> 30663dd2fb3977d676e5cc1926ed2f992af50169
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

<<<<<<< HEAD
        System.out.print(CYAN + "\n¿Cuántos boletos desea?: " + RESET);
        int cantidad = entrada.nextInt();
=======
        int cantidad = 0;
       
        while (true) {
            System.out.print("\n¿Cuántos boletos desea?: ");
            String inputBoletos = entrada.nextLine().trim();
            
            
            if (inputBoletos.matches("[0-9]+") && !inputBoletos.equals("0")) {
                cantidad = Integer.parseInt(inputBoletos);
                break; 
            } else {
                System.out.println("❌ Error: Debe ingresar la cantidad en números enteros (mayores a 0).");
            }
        }
>>>>>>> 30663dd2fb3977d676e5cc1926ed2f992af50169

        for (int i = 0; i < cantidad; i++) {

            System.out.println(CYAN + "\n========== RESERVA " + (i + 1) + " ==========" + RESET);

            System.out.println("Tipo de persona");
            System.out.println("1. Niño ($3)");
            System.out.println("2. Adolescente ($5)");
            System.out.println("3. Adulto ($7)");
<<<<<<< HEAD
            System.out.print("Seleccione: ");

            int tipo = entrada.nextInt();
=======
            
>>>>>>> 30663dd2fb3977d676e5cc1926ed2f992af50169
            double precio = 0;
            
            
            while (true) {
                System.out.print("Seleccione: ");
                String inputTipo = entrada.nextLine().trim();
                
                if (inputTipo.equals("1")) {
                    precio = 3;
                    break;
                } else if (inputTipo.equals("2")) {
                    precio = 5;
                    break;
                } else if (inputTipo.equals("3")) {
                    precio = 7;
                    break;
<<<<<<< HEAD
                default:
                    System.out.println("❌ Opción incorrecta");
                    i--;
                    continue;
=======
                } else {
                    System.out.println(" Error: Debe realizar la selección usando números (1, 2 o 3).");
                }
>>>>>>> 30663dd2fb3977d676e5cc1926ed2f992af50169
            }

            total += precio;
            mostrarAsientos(asientos);

<<<<<<< HEAD
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
=======
            int fila = -1;
            // VALIDACIÓN: Fila del asiento
            while (true) {
                System.out.print("Fila (1-4): ");
                String inputFila = entrada.nextLine().trim();
                
                if (inputFila.equals("1") || inputFila.equals("2") || inputFila.equals("3") || inputFila.equals("4")) {
                    fila = Integer.parseInt(inputFila) - 1;
                    break;
                } else {
                    System.out.println(" Error: Debe ingresar el número de la fila correcto (1 al 4).");
                }
            }

            int columna = -1;
            // VALIDACIÓN: Columna del asiento
            while (true) {
                System.out.print("Columna (1-5): ");
                String inputColumna = entrada.nextLine().trim();
                
                if (inputColumna.equals("1") || inputColumna.equals("2") || inputColumna.equals("3") || inputColumna.equals("4") || inputColumna.equals("5")) {
                    columna = Integer.parseInt(inputColumna) - 1;
                    break;
                } else {
                    System.out.println(" Error: Debe ingresar el número de la columna correcto (1 al 5).");
                }
            }

            // Lógica de marcado del asiento ocupado o disponible
            if (asientos[fila][columna].equals("O")) {
                asientos[fila][columna] = "X";
                reservados.add("Fila " + (fila + 1) + " Asiento " + (columna + 1));
                System.out.println("✅ Asiento reservado con éxito.");
            } else {
                System.out.println(" Asiento ya ocupado. Intente con otro.");
                i--; // Resta el intento para repetir este boleto
            }
        }

        System.out.println("\n===== PAGO =====");
        System.out.println("Total a pagar: $" + total);
        
        double pago = 0;
        // VALIDACIÓN: El pago con dinero
        while (true) {
            System.out.print("Ingrese dinero: $");
            String inputPago = entrada.nextLine().trim();
            
            try {
                pago = Double.parseDouble(inputPago);
                if (pago >= 0) {
                    break;
                } else {
                    System.out.println(" El dinero no puede ser un valor negativo.");
                }
            } catch (NumberFormatException e) {
                System.out.println(" Error: Debe ingresar el monto en números (Ej: 10 o 15.50).");
            }
        }
>>>>>>> 30663dd2fb3977d676e5cc1926ed2f992af50169

        // Confirmación final del ticket de pago
        if (pago >= total) {

            double cambio = pago - total;

<<<<<<< HEAD
            System.out.println(CYAN + "\n========== CONFIRMACIÓN ==========" + RESET);
            System.out.println("✅ Pago realizado correctamente");
            System.out.println("Película: " + peliculaElegida);
            System.out.println("Horario: " + horarioElegido);
=======
            System.out.println("\n===== CONFIRMACION =====");
            System.out.println("¡Pago realizado correctamente!");
            System.out.println("Pelicula: " + peliculaElegida);
            System.out.println("Horario:  " + horarioElegido);
>>>>>>> 30663dd2fb3977d676e5cc1926ed2f992af50169

            System.out.println("\nAsientos reservados:");

            for (String asiento : reservados) {
<<<<<<< HEAD
                System.out.println("• " + asiento);
            }

            System.out.println("\nCambio: $" + cambio);

        } else {

            System.out.println("❌ Dinero insuficiente. Reserva cancelada.");
=======
                System.out.println(" • " + asiento);
            }

            System.out.println("\nCambio a devolver: $" + cambio);
            System.out.println("=========================================");
        } else {
            System.out.println(" Dinero insuficiente. Proceso de reserva cancelado.");
>>>>>>> 30663dd2fb3977d676e5cc1926ed2f992af50169
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