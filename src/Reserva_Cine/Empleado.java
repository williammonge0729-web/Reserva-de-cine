package Reserva_Cine;
import java.util.Scanner;

public class Empleado {

	
	public static int boletosVendidosTotal = 0;
    public static double ingresosRecaudadosTotal = 0.0;

    public static void menuPanelEmpleado() {
        Scanner sc = new Scanner(System.in);
        boolean enPanel = true;

        while (enPanel) {
            System.out.println("┌─────────────────────────────────────────────────────────┐");
            System.out.println("│                  PANEL DE ADMINISTRACIÓN                │");
            System.out.println("├─────────────────────────────────────────────────────────┤");
            System.out.println("│  1. Ver Reporte Global de Ventas                        │");
            System.out.println("│  2. Ver Estado Operativo de Salas                       │");
            System.out.println("│  3. Volver al Menú Principal                            │");
            System.out.println("└─────────────────────────────────────────────────────────┘");
            System.out.print(" Seleccione una opción: ");
            
            String opcion = sc.nextLine().trim();

            switch (opcion) {
                case "1":
                    mostrarReporteVentas();
                    break;

                case "2":
                    mostrarEstadoSalas();
                    break;

                case "3":
                    System.out.println("Cerrando sesión de empleado. Volviendo al menú principal...");
                    enPanel = false;
                    break;

                default:
                    System.out.println(" Opción incorrecta. Por favor, digite un número del 1 al 3.");
                    break;
            }
        }
    }

    // --- DISEÑO: REPORTE FINANCIERO DE VENTAS ---
    private static void mostrarReporteVentas() {
        System.out.println("\n===========================================================");
        System.out.println("                 REPORTE DE VENTAS DIARIAS               ");
        System.out.println("===========================================================");
        System.out.printf("  %-35s %-15s\n", "CONCEPTO", "VALOR TOTAL");
        System.out.println("-----------------------------------------------------------");
        System.out.printf("  %-35s %-15d\n", " Total de Boletos Vendidos:", boletosVendidosTotal);
        System.out.printf("  %-35s $%-14.2f\n", " Ingresos Brutos Recaudados:", ingresosRecaudadosTotal);
        System.out.println("-----------------------------------------------------------");
        System.out.println("  Estado del Arqueo: Balance Correcto                     ");
        System.out.println("===========================================================");
        System.out.println("Presione ENTER para continuar...");
        new Scanner(System.in).nextLine();
    }

    // --- DISEÑO: ESTADO OPERATIVO ---
    private static void mostrarEstadoSalas() {
        System.out.println("\n===========================================================");
        System.out.println("               ESTADO OPERATIVO DE SALAS                ");
        System.out.println("===========================================================");
        System.out.printf("  %-15s %-20s %-15s\n", "SALA", "PROYECCIÓN", "ESTADO");
        System.out.println("-----------------------------------------------------------");
        System.out.printf("  %-15s %-20s %-15s\n", "Sala 1", "Cartelera General", " DISPONIBLE");
        System.out.printf("  %-15s %-20s %-15s\n", "Sala 2 (VIP)", "Mantenimiento Técnico", " INACTIVA");
        System.out.printf("  %-15s %-20s %-15s\n", "Sala 3 (3D)", "Pruebas de Audio", " RESERVADA");
        System.out.println("===========================================================");
        System.out.println("Presione ENTER para continuar...");
        new Scanner(System.in).nextLine();
    }
}

