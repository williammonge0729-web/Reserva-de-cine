package Reserva_Cine;

public class Reserva_Cine {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		 boolean loginExitoso = Menus.iniciarSesion();
	        
	        // 2. Si el inicio de sesión fue correcto, mostramos el menú
	        if (loginExitoso) {
	            
	            // Llamamos a tu método del menú
	            String peliculaSeleccionada = Menus.menuPeli();
	            
	            // Mostramos el resultado final si no eligió salir o si ingresó algo válido
	            if (!peliculaSeleccionada.equals("Salir") && !peliculaSeleccionada.equals("Opción inválida")) {
	                System.out.println("\n🎬 Pelicula elegida con éxito: " + peliculaSeleccionada);
	            } else {
	                System.out.println("\nPrograma terminado o acción cancelada.");
	            }
	            
	        } else {
	            // Si las credenciales fueron incorrectas, el menú nunca se ejecuta
	            System.out.println("No puedes ver el menú sin iniciar sesión.");
	        }
	        
	    }
	}

