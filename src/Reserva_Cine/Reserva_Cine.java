package Reserva_Cine;

import java.util.ArrayList;
import java.util.Scanner;

public class Reserva_Cine {
	public static final String RESET = "\u001B[0m";
    public static final String CYAN = "\u001B[36m";
    public static final String VERDE = "\u001B[32m";
    public static final String ROJO = "\u001B[31m";
    public static final String AMARILLO = "\u001B[33m";
    public static final String PURPURA = "\u001B[35m";
    public static final String AZUL = "\u001B[34m";

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		

        
        MusicaFondo.encenderMusica(); 
        
        boolean continuarPrograma = true;
        
        do {
            System.out.println(CYAN + "\n┌─────────────────────────────────────────────────────────┐" + RESET);
            System.out.println(CYAN + "│" + CYAN + "             SISTEMA CENTRAL DE CINE                     " + CYAN + "│" + RESET);
            System.out.println(CYAN + "├─────────────────────────────────────────────────────────┤" + RESET);
            System.out.println(CYAN + "│" + VERDE + "  1. Acceder como Cliente (Comprar Boletos)              " + CYAN + "│" + RESET);
            System.out.println(CYAN + "│" + VERDE + "  2. Acceder como Empleado (Panel de Gestión)            " + CYAN + "│" + RESET);
            System.out.println(CYAN + "│" + ROJO + "  3. Apagar el Sistema                                   " + CYAN + "│" + RESET);
            System.out.println(CYAN + "└─────────────────────────────────────────────────────────┘" + RESET);
            
            System.out.print(" Seleccione su modo de acceso: ");
            String rol = sc.nextLine().trim();

            if (rol.equals("1")) {
                // Contraseña: 1234
                if (Menus.iniciarSesion(rol)) {
                    // FLUJO NORMAL DE CLIENTE
                    String peliculaSeleccionada = "";
                    boolean confirmado = false;
                    
                    while (!confirmado) {
                        peliculaSeleccionada = Menus.menuPeli();
                        
                        if (peliculaSeleccionada.equals("Salir")) {
                            System.out.println(AMARILLO + "\nReserva cancelada desde la cartelera." + RESET);
                            break; 
                        }
                        
                        System.out.println("\n Ha seleccionado: " + PURPURA + peliculaSeleccionada + RESET);
                        System.out.print("¿Está seguro de la película seleccionada? (si/no): ");
                        String respuesta = sc.nextLine().trim().toLowerCase();
                        
                        if (respuesta.equals("si") || respuesta.equals("sí")) {
                            confirmado = true; 
                            System.out.println(VERDE + " Película confirmada con éxito." + RESET);
                        } else {
                            System.out.println(AMARILLO + "\n Volviendo a la cartelera..." + RESET);
                        }
                    }
                    
                    if (!peliculaSeleccionada.equals("Salir")) {
                        String horarioFinal = Menus.mostrarHorarios(peliculaSeleccionada);
                        reserva.gestionarReserva(peliculaSeleccionada, horarioFinal);
                    }
                }

            } else if (rol.equals("2")) {
                //Contraseña: 8888
                if (Menus.iniciarSesion(rol)) {
                    Empleado.menuPanelEmpleado();
                }

            } else if (rol.equals("3")) {
                System.out.println(ROJO + "\n Apagando servidores... Muchas gracias por usar el sistema." + RESET);
                continuarPrograma = false;
            } else {
                System.out.println(ROJO + " Entrada inválida. Digite 1, 2 o 3." + RESET);
            }
            
        } while (continuarPrograma); 
        
        sc.close();
    }
}