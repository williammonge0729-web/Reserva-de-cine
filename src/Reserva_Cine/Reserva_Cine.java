package Reserva_Cine;

import java.util.ArrayList;
import java.util.Scanner;

public class Reserva_Cine {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
	        
	        Scanner sc = new Scanner(System.in);
	        
	        
	        boolean loginExitoso = Menus.iniciarSesion();
	        
	        if (loginExitoso) {
	            String peliculaSeleccionada = "";
	            boolean confirmado = false;
	            
	            // Este bucle se repetirá mientras 'confirmado' sea false
	            while (!confirmado) {
	                peliculaSeleccionada = Menus.menuPeli();
	                
	                if (peliculaSeleccionada.equals("Salir") || peliculaSeleccionada.equals("Opción inválida")) {
	                    System.out.println("\nReserva Cancelada o inválida.");
	                    return; // Finaliza el programa
	                }
	                
	                // Preguntamos si está seguro
	                System.out.println("\n🎬 Ha seleccionado: " + peliculaSeleccionada);
	                System.out.print("¿Está seguro de la película seleccionada? (si/no): ");
	                String respuesta = sc.nextLine().trim().toLowerCase();
	                
	                if (respuesta.equals("si") || respuesta.equals("sí")) {
	                    confirmado = true; // Rompe el bucle y continúa el código
	                    System.out.println("\nPelícula confirmada con éxito.");
	                } else {
	                    System.out.println("\n🔄 Volviendo al menú de selección...");
	                }

	              String horarioFinal = Menus.mostrarHorarios(peliculaSeleccionada);
	            
	                reserva.gestionarReserva(peliculaSeleccionada, horarioFinal);
	         

	            } else {
	                System.out.println("\nReserva Cancelada.");
	            // Si el usuario confirmó la película, el programa continúa con los horarios y asientos
	            String horarioFinal = Menus.mostrarHorarios(peliculaSeleccionada);
	            reserva.gestionarReserva(peliculaSeleccionada, horarioFinal);
	            
	        } else {
	            System.out.println("No puedes ver el menú sin iniciar sesión.");
	        
	    }
	}

}