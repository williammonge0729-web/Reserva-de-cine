package Reserva_Cine;
import java.util.Scanner;

public class Menus {
	public static final String RESET = "\u001B[0m";
    public static final String CYAN = "\u001B[36m";
    public static final String VERDE = "\u001B[32m";
    public static final String ROJO = "\u001B[31m";
    public static final String AMARILLO = "\u001B[33m";
    public static final String PURPURA = "\u001B[35m";
    public static final String AZUL = "\u001B[34m";

	public static boolean iniciarSesion() {
        Scanner sc = new Scanner(System.in);
        boolean loginExitoso = false; 
        
        while (!loginExitoso) {
            System.out.println(Reserva_Cine.CYAN + "===========================================================" + Reserva_Cine.RESET);
            System.out.println(Reserva_Cine.CYAN + "                 INICIO DE SESIÓN                        " + Reserva_Cine.RESET);
            System.out.println(Reserva_Cine.CYAN + "===========================================================" + Reserva_Cine.RESET);
            
            System.out.print(" Ingresa tu usuario: ");
            String usuario = sc.nextLine();
            
            System.out.print(" Ingresa tu contraseña: ");
            String contrasenia = sc.nextLine();
            
            if (contrasenia.equals("1234")) {
                System.out.println(Reserva_Cine.VERDE + "\n ¡Bienvenido/a " + usuario + "! Has iniciado sesión con éxito." + Reserva_Cine.RESET);
                loginExitoso = true; 
            } else {
                System.out.println(Reserva_Cine.ROJO + "\n Contraseña incorrecta. Inténtalo de nuevo.\n" + Reserva_Cine.RESET);
            }
        }
        
        return loginExitoso; 
    }

    
    public static String menuPeli() { 
        Scanner sc = new Scanner(System.in);
        
        System.out.println(Reserva_Cine.CYAN + "\n┌─────────────────────────────────────────────────────────┐" + Reserva_Cine.RESET);
        System.out.println(Reserva_Cine.CYAN + "│" + Reserva_Cine.PURPURA + "                PELÍCULAS DISPONIBLES                  "    + Reserva_Cine.CYAN + "  │ " + Reserva_Cine.RESET);
        System.out.println(Reserva_Cine.CYAN + "├─────────────────────────────────────────────────────────┤" + Reserva_Cine.RESET);
        System.out.println(Reserva_Cine.CYAN + "│" + Reserva_Cine.CYAN + "  1. La Odisea                                           " + Reserva_Cine.CYAN + "│" + Reserva_Cine.RESET);
        System.out.println(Reserva_Cine.CYAN + "│" + Reserva_Cine.CYAN + "  2. Super Mario Galaxy: La Pelicula                     " + Reserva_Cine.CYAN + "│" + Reserva_Cine.RESET);
        System.out.println(Reserva_Cine.CYAN + "│" + Reserva_Cine.CYAN + "  3. Scary Movie 6                                       " + Reserva_Cine.CYAN + "│" + Reserva_Cine.RESET);
        System.out.println(Reserva_Cine.CYAN + "│" + Reserva_Cine.CYAN + "  4. Backrooms: Sin Salida                               " + Reserva_Cine.CYAN + "│" + Reserva_Cine.RESET);
        System.out.println(Reserva_Cine.CYAN + "│" + Reserva_Cine.CYAN + "  5. Spiderman: Brand New Day                            " + Reserva_Cine.CYAN + "│" + Reserva_Cine.RESET);
        System.out.println(Reserva_Cine.CYAN + "│" + Reserva_Cine.CYAN + "  6. Mortal Kombat 2                                     " + Reserva_Cine.CYAN + "│" + Reserva_Cine.RESET);
        System.out.println(Reserva_Cine.CYAN + "│" + Reserva_Cine.ROJO + "  7. Salir                                               " + Reserva_Cine.CYAN + "│" + Reserva_Cine.RESET);
        System.out.println(Reserva_Cine.CYAN + "└─────────────────────────────────────────────────────────┘" + Reserva_Cine.RESET);
        System.out.print("Elige una opción: ");
        
        String entrada = sc.nextLine().trim(); 
        String pelicula = ""; 
        
        switch(entrada.toLowerCase()) {
            case "1": case "la odisea": pelicula = "La Odisea"; break;
            case "2": case "super mario galaxy: la pelicula": pelicula = "Super Mario Galaxy: La Pelicula"; break;
            case "3": case "scary movie 6": pelicula = "Scary Movie 6"; break;
            case "4": case "backrooms: sin salida": pelicula = "Backrooms: Sin Salida"; break;
            case "5": case "spiderman: brand new day": pelicula = "Spiderman: Brand New Day"; break;
            case "6": case "mortal kombat 2": pelicula = "Mortal Kombat 2"; break;
            case "7": case "salir": pelicula = "Salir"; break;
            default: pelicula = "Opción inválida"; break;
        }
        
        return pelicula; 
    }

    // ⏰ 3. HORARIOS DISPONIBLES (Mantiene tus títulos exactos adaptados al marco)
    public static String mostrarHorarios(String pelicula) {
        Scanner sc = new Scanner(System.in);
        
        System.out.println(Reserva_Cine.CYAN + "\n┌─────────────────────────────────────────────────────────┐" + Reserva_Cine.RESET);
        System.out.println(Reserva_Cine.CYAN + "│" + Reserva_Cine.CYAN + "                HORARIOS DISPONIBLES                   " + Reserva_Cine.CYAN + "│" + Reserva_Cine.RESET);
        System.out.println(Reserva_Cine.CYAN + "├─────────────────────────────────────────────────────────┤" + Reserva_Cine.RESET);
        
        String h1 = "";
        String h2 = "";
        String h3 = "";
        int totalHorarios = 0;
        
        switch (pelicula) {
            case "La Odisea":
                System.out.println(Reserva_Cine.CYAN + "│" + Reserva_Cine.PURPURA + "  Película: La Odisea                                    " + Reserva_Cine.CYAN + "│" + Reserva_Cine.RESET);
                h1 = "09:00 AM (2D Español)";
                h2 = "02:00 PM (2D Subtitulada)";
                totalHorarios = 2;
                break;
            case "Super Mario Galaxy: La Pelicula":
                System.out.println(Reserva_Cine.CYAN + "│" + Reserva_Cine.PURPURA + "  Película: Super Mario Galaxy: La Pelicula              " + Reserva_Cine.CYAN + "│" + Reserva_Cine.RESET);
                h1 = "10:30 AM (3D Español)";
                h2 = "01:45 PM (2D Español)";
                h3 = "04:15 PM (2D Español)";
                totalHorarios = 3;
                break;
            case "Scary Movie 6":
                System.out.println(Reserva_Cine.CYAN + "│" + Reserva_Cine.PURPURA + "  Película: Scary Movie 6                                " + Reserva_Cine.CYAN + "│" + Reserva_Cine.RESET);
                h1 = "04:00 PM (2D Español)";
                h2 = "07:00 PM (2D Español)";
                h3 = "09:30 PM (2D Subtitulada)";
                totalHorarios = 3;
                break;
            case "Backrooms: Sin Salida":
                System.out.println(Reserva_Cine.CYAN + "│" + Reserva_Cine.PURPURA + "  Película: Backrooms: Sin Salida                        " + Reserva_Cine.CYAN + "│" + Reserva_Cine.RESET);
                h1 = "02:00 PM (2D Español)";
                h2 = "06:15 PM (2D Español)";
                totalHorarios = 2;
                break;
            case "Spiderman: Brand New Day":
                System.out.println(Reserva_Cine.CYAN + "│" + Reserva_Cine.PURPURA + "  Película: Spiderman: Brand New Day                     " + Reserva_Cine.CYAN + "│" + Reserva_Cine.RESET);
                h1 = "12:00 PM (2D Español)";
                h2 = "05:00 PM (3D Español)";
                h3 = "08:30 PM (3D Español)";
                totalHorarios = 3;
                break;
            case "Mortal Kombat 2":
                System.out.println(Reserva_Cine.CYAN + "│" + Reserva_Cine.PURPURA + "  Película: Mortal Kombat 2                              " + Reserva_Cine.CYAN + "│" + Reserva_Cine.RESET);
                h1 = "10:00 AM (2D Español)";
                h2 = "03:15 PM (3D Español)";
                h3 = "08:30 PM (3D Español)";
                totalHorarios = 3;
                break;
            default:
                System.out.println(Reserva_Cine.ROJO + "│  No hay horarios disponibles.                           " + Reserva_Cine.CYAN + "│" + Reserva_Cine.RESET);
                System.out.println(Reserva_Cine.CYAN + "└─────────────────────────────────────────────────────────┘" + Reserva_Cine.RESET);
                return "Ninguno";
        }
        
        System.out.println(Reserva_Cine.CYAN + "├─────────────────────────────────────────────────────────┤" + Reserva_Cine.RESET);
        
        // 
        System.out.printf(Reserva_Cine.CYAN + "│" + Reserva_Cine.AZUL + "  1. %-52s" + Reserva_Cine.CYAN + "│\n" + RESET, h1);
        System.out.printf(Reserva_Cine.CYAN + "│" + Reserva_Cine.AZUL + "  2. %-52s" + Reserva_Cine.CYAN + "│\n" + RESET, h2);
        if (totalHorarios == 3) {
            System.out.printf(Reserva_Cine.CYAN + "│" + Reserva_Cine.AZUL + "  3. %-52s" + Reserva_Cine.CYAN + "│\n" + RESET, h3);
        }
        
        System.out.println(Reserva_Cine.CYAN + "└─────────────────────────────────────────────────────────┘" + Reserva_Cine.RESET);
        
        String horarioElegido = "";
        boolean horarioValido = false;
        
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
                System.out.println(Reserva_Cine.ROJO + "\nError: Debe ingresar el número del horario correcto.\n" + Reserva_Cine.RESET);
            }
        }
        
        return horarioElegido;
    }
}
