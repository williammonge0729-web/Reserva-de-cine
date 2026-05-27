package Reserva_Cine;
import java.util.Scanner;

public class Menus {

    // NUEVO MÉTODO: Devuelve true si inicia sesión correctamente, o false si falla
	 public static boolean iniciarSesion() {
	        Scanner sc = new Scanner(System.in);
	        boolean loginExitoso = false; // Bandera para saber si ya entró
	        
	        // El bucle se repetirá MIENTRAS 'loginExitoso' sea falso
	        while (!loginExitoso) {
	            System.out.println("=================================");
	            System.out.println("       INICIO DE SESIÓN         ");
	            System.out.println("=================================");
	            System.out.print("Ingresa tu usuario: ");
	            String usuario = sc.nextLine();
	            
	            System.out.print("Ingresa tu contraseña: ");
	            String contrasenia = sc.nextLine();
	            
	            // Validamos la contraseña (sigue siendo 1234)
	            if (contrasenia.equals("1234")) {
	                System.out.println("\n✅ ¡Bienvenido/a " + usuario + "! Has iniciado sesión con éxito.");
	                loginExitoso = true; // Cambia a true para romper el bucle y salir del while
	            } else {
	                System.out.println("\n❌ Contraseña incorrecta. Inténtalo de nuevo.\n");
	                // Al no cambiar la variable, el ciclo 'while' vuelve a empezar
	            }
	        }
	        
	        return loginExitoso; // Al final siempre devolverá true porque no puede salir del bucle de otra forma
	    }

	    // Tu método del menú se queda exactamente igual
	    public static String menuPeli() { 
	        Scanner sc = new Scanner(System.in);
	        
	        System.out.println("\n====== Peliculas Disponibles ======");
	        System.out.println("1. Mario");
	        System.out.println("2. Avengers");
	        System.out.println("3. Spiderman");
	        System.out.println("4. Tu ano");
	        System.out.println("5. Salir");
	        System.out.print("Elige una opcion (numero o nombre): ");
	        
	        String entrada = sc.nextLine().trim(); 
	        String pelicula = ""; 
	        
	        switch(entrada.toLowerCase()) {
	            case "1": case "mario": pelicula = "Mario"; break;
	            case "2": case "avengers": pelicula = "Avengers"; break;
	            case "3": case "spiderman": pelicula = "Spiderman"; break;
	            case "4": case "tu ano": pelicula = "Tu ano"; break;
	            case "5": case "salir": pelicula = "Salir"; break;
	            default: pelicula = "Opción inválida"; break;
	        }
	        
	        return pelicula; 
	    }
	}
	

