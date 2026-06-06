package Reserva_Cine;

import java.util.Scanner;

public class Menus {

	 public static boolean iniciarSesion() {
		        Scanner sc = new Scanner(System.in);
		        boolean loginExitoso = false; 
		        
		        while (!loginExitoso) {
		            System.out.println("=================================");
		            System.out.println("       INICIO DE SESIÓN         ");
		            System.out.println("=================================");
		            System.out.print("Ingresa tu usuario: ");
		            String usuario = sc.nextLine();
		            
		            System.out.print("Ingresa tu contraseña: ");
		            String contrasenia = sc.nextLine();
		            
		            if (contrasenia.equals("1234")) {
		                System.out.println("\n ¡Bienvenido/a " + usuario + "! Has iniciado sesión con éxito.");
		                loginExitoso = true; 
		            } else {
		                System.out.println("\n Contraseña incorrecta. Inténtalo de nuevo.\n");
		            }
		        }
		        
		        return loginExitoso; 
		    }

		    public static String menuPeli() { 
		        Scanner sc = new Scanner(System.in);
		        
		        System.out.println("\n====== Peliculas Disponibles ======");
		        System.out.println("1. La Odisea");
		        System.out.println("2. Super Mario Galaxy: La Pelicula");
		        System.out.println("3. Scary Movie 6");
		        System.out.println("4. Backrooms: Sin Salida");
		        System.out.println("5. Spiderman: Brand New Day");
		        System.out.println("6. Mortal Kombat 2");
		        System.out.println("7. Salir");
		        System.out.print("Elige una opcion: ");
		        
		        String entrada = sc.nextLine().trim(); 
		        String pelicula = ""; 
		        
		        switch(entrada.toLowerCase()) {
		            case "1": case "la odisea": pelicula = "La Odisea"; 
		            break;
		            case "2": case "super mario galaxy: la pelicula": pelicula = "Super Mario Galaxy: La Pelicula";
		            break;
		            case "3": case "scary movie 6": pelicula = "Scary Movie 6"; 
		            break;
		            case "4": case "backrooms: sin salida": pelicula = "Backrooms: Sin Salida";
		            break;
		            case "5": case "spiderman: brand new day": pelicula = "Spiderman: Brand New Day"; 
		            break;
		            case "6": case "mortal kombat 2": pelicula = "Mortal Kombat 2";
		            break;
		            case "7": case "salir": pelicula = "Salir";
		            break;
		            default: pelicula = "Opción inválida"; 
		            break;
		        }
		        
		        return pelicula; 
		    }

		    public static String mostrarHorarios(String pelicula) {
		        Scanner sc = new Scanner(System.in);
		        
		        System.out.println("\n=================================");
		        System.out.println("     HORARIOS DISPONIBLES        ");
		        System.out.println("=================================");
		        
		        String h1 = "";
		        String h2 = "";
		        String h3 = "";
		        int totalHorarios = 0;
		        
		        switch (pelicula) {
		            case "La Odisea":
		                System.out.println("Película: La Odisea");
		                h1 = "09:00 AM (2D Español)";
		                h2 = "02:00 PM (2D Subtitulada)";
		                totalHorarios = 2;
		                break;
		            case "Super Mario Galaxy: La Pelicula":
		                System.out.println("Película: Super Mario Galaxy: La Pelicula");
		                h1 = "10:30 AM (3D Español)";
		                h2 = "01:45 PM (2D Español)";
		                h3 = "04:15 PM (2D Español)";
		                totalHorarios = 3;
		                break;
		            case "Scary Movie 6":
		                System.out.println("Película: Scary Movie 6");
		                h1 = "04:00 PM (2D Español)";
		                h2 = "07:00 PM (2D Español)";
		                h3 = "09:30 PM (2D Subtitulada)";
		                totalHorarios = 3;
		                break;
		            case "Backrooms: Sin Salida":
		                System.out.println("Película: Backrooms: Sin Salida");
		                h1 = "02:00 PM (2D Español)";
		                h2 = "06:15 PM (2D Español)";
		                totalHorarios = 2;
		                break;
		            case "Spiderman: Brand New Day":
		                System.out.println("Película: Spiderman: Brand New Day");
		                h1 = "12:00 PM (2D Español)";
		                h2 = "05:00 PM (3D Español)";
		                h3 = "08:30 PM (3D Español)";
		                totalHorarios = 3;
		                break;
		            case "Mortal Kombat 2":
		                System.out.println("Película: Mortal Kombat 2");
		                h1 = "10:00 AM (2D Español)";
		                h2 = "03:15 PM (3D Español)";
		                h3 = "08:30 PM (3D Español)";
		                totalHorarios = 3;
		                break;
		            default:
		                System.out.println("No hay horarios disponibles.");
		                return "Ninguno";
		        }
		        
		        System.out.println("1. " + h1);
		        System.out.println("2. " + h2);
		        if (totalHorarios == 3) {
		            System.out.println("3. " + h3);
		        }
		        System.out.println("=================================");
		        
		        String horarioElegido = "";
		        boolean horarioValido = false;
		        
		        // Bucle para obligar al usuario a meter una opción correcta
		        while (!horarioValido) {
		            System.out.print("Ingresa el número del horario en el que desea ver la película: ");
		            String entrada = sc.nextLine().trim();
		            
		            if (entrada.equals("1")) {
		                horarioElegido = h1;
		                horarioValido = true;
		            } else if (entrada.equals("2")) {
		                horarioElegido = h2;
		                horarioValido = true;
		            } else if (entrada.equals("3") && totalHorarios == 3) {
		                horarioElegido = h3;
		                horarioValido = true;
		            } else {
		                System.out.println("\n Error: Debe ingresar el número del horario correcto.\n");
		            }
		        }
		        
		        return horarioElegido;
		    }
		}

