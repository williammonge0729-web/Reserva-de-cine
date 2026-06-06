package Reserva_Cine;
import java.util.Scanner;

public class Empleado {

	
	public static int boletosVendidosTotal = 0;
    public static double ingresosRecaudadosTotal = 0.0;

   
    public static boolean verificarContraseniaEmpleado() {
        Scanner sc = new Scanner(System.in);
        
        System.out.println(Reserva_Cine.CYAN + "\n===========================================================" + Reserva_Cine.RESET);
        System.out.println(Reserva_Cine.ROJO + "          ÁREA RESTRINGIDA: CONTROL DE SEGURIDAD         " + Reserva_Cine.RESET);
        System.out.println(Reserva_Cine.CYAN + "===========================================================" + Reserva_Cine.RESET);
        System.out.print("Ingrese la clave de administrador: ");
        String clave = sc.nextLine().trim();

       
        if (clave.equals("8888")) {
            System.out.println(Reserva_Cine.VERDE + " Credencial de empleado verificada. Accediendo..." + Reserva_Cine.RESET);
            return true;
        } else {
            System.out.println(Reserva_Cine.ROJO + " Clave incorrecta. Acceso denegado al panel." + Reserva_Cine.RESET);
            return false;
        }
    }

    
    public static void menuPanelEmpleado() {
        Scanner sc = new Scanner(System.in);
        boolean enPanel = true;

        while (enPanel) {
            System.out.println(Reserva_Cine.CYAN + "\n┌─────────────────────────────────────────────────────────┐" + Reserva_Cine.RESET);
            System.out.println(Reserva_Cine.CYAN + "│" + Reserva_Cine.AZUL + "                 PANEL DE ADMINISTRACIÓN                " + Reserva_Cine.CYAN + "│" + Reserva_Cine.RESET);
            System.out.println(Reserva_Cine.CYAN + "├─────────────────────────────────────────────────────────┤" + Reserva_Cine.RESET);
            System.out.println(Reserva_Cine.CYAN + "│" + Reserva_Cine.AZUL + "  1. Ver Reporte Global de Ventas                        " + Reserva_Cine.CYAN + "│" + Reserva_Cine.RESET);
            System.out.println(Reserva_Cine.CYAN + "│" + Reserva_Cine.AZUL + "  2. Ver Estado Operativo de Salas                       " + Reserva_Cine.CYAN + "│" + Reserva_Cine.RESET);
            System.out.println(Reserva_Cine.CYAN + "│" + Reserva_Cine.AMARILLO + "  3. Volver al Menú Principal                            " + Reserva_Cine.CYAN + "│" + Reserva_Cine.RESET);
            System.out.println(Reserva_Cine.CYAN + "└─────────────────────────────────────────────────────────┘" + Reserva_Cine.RESET);
            System.out.print(" Seleccione una opción: ");
            
            String opcion = sc.nextLine().trim();

            switch (opcion) {
                case "1": mostrarReporteVentas(); break;
                case "2": mostrarEstadoSalas(); break;
                case "3": 
                    System.out.println(Reserva_Cine.AMARILLO + "\n[i] Cerrando sesión de empleado..." + Reserva_Cine.RESET);
                    enPanel = false; 
                    break;
                default: 
                    System.out.println(Reserva_Cine.ROJO + "\n Opción incorrecta." + Reserva_Cine.RESET); 
                    break;
            }
        }
    }

    private static void mostrarReporteVentas() {
        System.out.println(Reserva_Cine.CYAN + "\n===========================================================" + Reserva_Cine.RESET);
        System.out.println(Reserva_Cine.AZUL + "                 REPORTE DE VENTAS DIARIAS               " + Reserva_Cine.RESET);
        System.out.println(Reserva_Cine.CYAN + "===========================================================" + Reserva_Cine.RESET);
        System.out.printf("  %-35s %-15s\n", "CONCEPTO", "VALOR TOTAL");
        System.out.println(Reserva_Cine.CYAN + "-----------------------------------------------------------" + Reserva_Cine.RESET);
        System.out.printf("  %-35s " + Reserva_Cine.VERDE + "%-15d\n" + Reserva_Cine.RESET, "🎟️ Total de Boletos Vendidos:", boletosVendidosTotal);
        System.out.printf("  %-35s " + Reserva_Cine.VERDE + "$%-14.2f\n" + Reserva_Cine.RESET, "💰 Ingresos Brutos Recaudados:", ingresosRecaudadosTotal);
        System.out.println(Reserva_Cine.CYAN + "-----------------------------------------------------------" + Reserva_Cine.RESET);
        System.out.println("  Estado del Arqueo: " + Reserva_Cine.VERDE + "Balance Correcto" + Reserva_Cine.RESET);
        System.out.println(Reserva_Cine.CYAN + "===========================================================" + Reserva_Cine.RESET);
        System.out.print("Presione ENTER para continuar...");
        Scanner sc = new Scanner(System.in);
        sc.nextLine();
    }

    private static void mostrarEstadoSalas() {
        System.out.println(Reserva_Cine.CYAN + "\n===========================================================" + Reserva_Cine.RESET);
        System.out.println(Reserva_Cine.AZUL + "                ESTADO OPERATIVO DE SALAS                " + Reserva_Cine.RESET);
        System.out.println(Reserva_Cine.CYAN + "===========================================================" + Reserva_Cine.RESET);
        System.out.printf("  %-15s %-20s %-15s\n", "SALA", "PROYECCIÓN", "ESTADO");
        System.out.println(Reserva_Cine.CYAN + "-----------------------------------------------------------" + Reserva_Cine.RESET);
        System.out.printf("  %-15s %-20s " + Reserva_Cine.VERDE + "%-15s\n" + Reserva_Cine.RESET, "Sala 1", "Cartelera General", "🟢 DISPONIBLE");
        System.out.printf("  %-15s %-20s " + Reserva_Cine.ROJO + "%-15s\n" + Reserva_Cine.RESET, "Sala 2 (VIP)", "Mantenimiento Técnico", "🔴 INACTIVA");
        System.out.printf("  %-15s %-20s " + Reserva_Cine.AMARILLO + "%-15s\n" + Reserva_Cine.RESET, "Sala 3 (3D)", "Pruebas de Audio", "🟡 RESERVADA");
        System.out.println(Reserva_Cine.CYAN + "===========================================================" + Reserva_Cine.RESET);
        System.out.print("Presione ENTER para continuar...");
        Scanner sc = new Scanner(System.in);
        sc.nextLine();
    }
}