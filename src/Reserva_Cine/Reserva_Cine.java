package Reserva_Cine;

import java.util.ArrayList;
import java.util.Scanner;

public class Reserva_Cine {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
	        
	        boolean loginExitoso = Menus.iniciarSesion();
	        
	        if (loginExitoso) {
	            
	            String peliculaSeleccionada = Menus.menuPeli();
	            
	            if (!peliculaSeleccionada.equals("Salir") && !peliculaSeleccionada.equals("Opción inválida")) {
	                System.out.println("\n🎬 Pelicula elegida con éxito: " + peliculaSeleccionada);
	                
	                String horarioFinal = Menus.mostrarHorarios(peliculaSeleccionada);
	                
	                // === AQUÍ SE CONECTA LA CLASE DE TU COMPAÑERO ===
	                // Llamamos a su clase y método, pasándole la película y el horario
	                reserva.gestionarReserva(peliculaSeleccionada, horarioFinal);
	                // ===============================================

	            } else {
	                System.out.println("\nReserva Cancelada.");
	            }
	            
	        } else {
	            System.out.println("No puedes ver el menú sin iniciar sesión.");
	        }
	    }
	}

