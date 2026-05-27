package Reserva_Cine;

import java.util.ArrayList;
import java.util.Scanner;

public class reserva {
	
	    public static void main(String[] args) {

	        Scanner entrada = new Scanner(System.in);

	        String peliculas[]={
	                "Avengers",
	                "Spider-Man",
	                "Batman"
	        };

	        String asientos[][]={
	                {"O","O","O","O","O"},
	                {"O","O","O","O","O"},
	                {"O","O","O","O","O"},
	                {"O","O","O","O","O"}
	        };

	        ArrayList<String> reservados=
	                new ArrayList<>();

	        double total=0;

	        System.out.println("===== CINE =====");

	        for(int i=0;i<peliculas.length;i++){

	            System.out.println(
	                    (i+1)+". "+peliculas[i]);
	        }

	        System.out.print(
	                "Seleccione una pelicula: ");

	        int opcion=
	                entrada.nextInt();

	        if(opcion>=1 &&
	                opcion<=peliculas.length){

	            System.out.println(
	                    "\nPelicula: "
	                    +peliculas[opcion-1]);

	            mostrarAsientos(asientos);

	            System.out.print(
	                    "\n¿Cuántos boletos desea?: ");

	            int cantidad=
	                    entrada.nextInt();

	            for(int i=0;i<cantidad;i++){

	                System.out.println(
	                        "\nReserva "
	                        +(i+1));

	                System.out.println(
	                        "Tipo de persona");

	                System.out.println(
	                        "1. Niño ($3)");

	                System.out.println(
	                        "2. Adolescente ($5)");

	                System.out.println(
	                        "3. Adulto ($7)");

	                System.out.print(
	                        "Seleccione: ");

	                int tipo=
	                        entrada.nextInt();

	                double precio=0;

	                switch(tipo){

	                    case 1:
	                        precio=3;
	                        break;

	                    case 2:
	                        precio=5;
	                        break;

	                    case 3:
	                        precio=7;
	                        break;

	                    default:
	                        System.out.println(
	                                "Opcion incorrecta");
	                        i--;
	                        continue;
	                }

	                total+=precio;

	                mostrarAsientos(asientos);

	                System.out.print(
	                        "Fila (1-4): ");

	                int fila=
	                        entrada.nextInt()-1;

	                System.out.print(
	                        "Columna (1-5): ");

	                int columna=
	                        entrada.nextInt()-1;

	                if(fila>=0 &&
	                        fila<4 &&
	                        columna>=0 &&
	                        columna<5){

	                    if(asientos[fila][columna]
	                            .equals("O")){

	                        asientos[fila][columna]="X";

	                        reservados.add(
	                                "Fila "
	                                +(fila+1)
	                                +" Asiento "
	                                +(columna+1));

	                        System.out.println(
	                                "Asiento reservado");

	                    }else{

	                        System.out.println(
	                                "Asiento ocupado");

	                        i--;
	                    }

	                }else{

	                    System.out.println(
	                            "Asiento inválido");

	                    i--;
	                }

	            }

	            System.out.println(
	                    "\n===== PAGO =====");

	            System.out.println(
	                    "Total: $"+total);

	            System.out.print(
	                    "Ingrese dinero: ");

	            double pago=
	                    entrada.nextDouble();

	            if(pago>=total){

	                double cambio=
	                        pago-total;

	                System.out.println(
	                        "\n===== CONFIRMACION =====");

	                System.out.println(
	                        "Pago realizado correctamente");

	                System.out.println(
	                        "Pelicula: "
	                        +peliculas[opcion-1]);

	                System.out.println(
	                        "\nAsientos reservados:");

	                for(String asiento:
	                        reservados){

	                    System.out.println(
	                            asiento);
	                }

	                System.out.println(
	                        "\nCambio: $"
	                        +cambio);

	            }else{

	                System.out.println(
	                        "Dinero insuficiente");
	            }

	        }else{

	            System.out.println(
	                    "Película no válida");
	        }

	    }

	    public static void mostrarAsientos(
	            String asientos[][]){

	        System.out.println(
	                "\nASIENTOS");

	        for(int i=0;
	                i<asientos.length;
	                i++){

	            for(int j=0;
	                    j<asientos[i].length;
	                    j++){

	                System.out.print(
	                        asientos[i][j]
	                        +" ");
	            }

	            System.out.println();
	        }

	    }

	}
