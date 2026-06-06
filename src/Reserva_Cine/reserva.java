package Reserva_Cine;

import java.util.ArrayList;
import java.util.Scanner;

public class reserva {

	public static void gestionarReserva(String peliculaElegida, String horarioElegido) {
        
        Scanner entrada = new Scanner(System.in);

        String asientos[][] = {
                {"O","O","O","O","O"},
                {"O","O","O","O","O"},
                {"O","O","O","O","O"},
                {"O","O","O","O","O"}
        };

        ArrayList<String> reservados = new ArrayList<>();
        double total = 0;

        mostrarAsientos(asientos);

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

        for (int i = 0; i < cantidad; i++) {
            System.out.println("\nReserva " + (i + 1));
            System.out.println("Tipo de persona");
            System.out.println("1. Niño ($3)");
            System.out.println("2. Adolescente ($5)");
            System.out.println("3. Adulto ($7)");
            
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
                } else {
                    System.out.println(" Error: Debe realizar la selección usando números (1, 2 o 3).");
                }
            }

            total += precio;
            mostrarAsientos(asientos);

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

        // Confirmación final del ticket de pago
        if (pago >= total) {
            double cambio = pago - total;

            System.out.println("\n===== CONFIRMACION =====");
            System.out.println("¡Pago realizado correctamente!");
            System.out.println("Pelicula: " + peliculaElegida);
            System.out.println("Horario:  " + horarioElegido);

            System.out.println("\nAsientos reservados:");
            for (String asiento : reservados) {
                System.out.println(" • " + asiento);
            }

            System.out.println("\nCambio a devolver: $" + cambio);
            System.out.println("=========================================");
        } else {
            System.out.println(" Dinero insuficiente. Proceso de reserva cancelado.");
        }
    }

    public static void mostrarAsientos(String asientos[][]) {
        System.out.println("\nASIENTOS (O = Disponible, X = Ocupado)");
        for (int i = 0; i < asientos.length; i++) {
            for (int j = 0; j < asientos[i].length; j++) {
                System.out.print(asientos[i][j] + " ");
            }
            System.out.println();
        }
    }
}