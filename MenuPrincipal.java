import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
// Ejercicio Colas Realizado por Johnatan Moreno Acosta
public class MenuPrincipal {
    private Scanner scanner = new Scanner(System.in);
    private MetodosBanco metodosBanco = new MetodosBanco(scanner);

    public void mostrarMenuPrincipal() {
        System.out.println("\n--- Menú Principal del Banco ---");
        System.out.println("1. Tomar un turno");
        System.out.println("2. Atender siguiente");
        System.out.println("3. Mostrar estado de la fila de espera");
        System.out.println("4. Salir");
        System.out.println("-----------------------------------\n");
    }

    public void ejecutarMenu() {
        int opcionPrincipal = 0;
        
        while (opcionPrincipal != 4) {
            mostrarMenuPrincipal();
            System.out.print("Seleccione una opción: ");
            if (scanner.hasNextInt()) {
                opcionPrincipal = scanner.nextInt();
                scanner.nextLine(); 
                
                switch (opcionPrincipal) {
                    case 1:
                        mostrarMenuTomarTurno();
                        break;
                    case 2:
                        atenderSiguienteConPrioridad(); 
                        break;
                    case 3:
                        metodosBanco.mostrarEstadoCola();
                        break;
                    case 4:
                        System.out.println("Gracias por usar nuestro sistema.");
                        break;
                    default:
                        System.out.println("Opción inválida. Intente nuevamente.");
                }
            } else {
                System.out.println("Entrada inválida. Por favor, ingrese un número.");
                scanner.next(); 
            }
        }
        scanner.close();
    }

    public void mostrarMenuTomarTurno() {
        System.out.println("\n--- Tomar Nuevo Turno ---");
        System.out.println("1. Cliente Regular");
        System.out.println("2. Cliente Preferencial");
        System.out.println("3. Asunto Prioritario");
        System.out.println("4. Volver al menú principal");
        System.out.println("---------------------------\n");

        int opcionSubMenu = 0;
        
        while (opcionSubMenu != 4) {
            System.out.print("Seleccione una opción: ");
            if (scanner.hasNextInt()) {
                opcionSubMenu = scanner.nextInt();
                scanner.nextLine();
                
                switch (opcionSubMenu) {
                    case 1:
                        metodosBanco.agregarClienteRegular();
                        break;
                    case 2:
                        metodosBanco.agregarClientePreferencial();
                        break;
                    case 3:
                        metodosBanco.agregarAsuntoPrioritario();
                        break;
                    case 4:
                        System.out.println("Volviendo al menú principal.");
                        break;
                    default:
                        System.out.println("Opción inválida. Intente nuevamente.");
                }
            } else {
                System.out.println("Entrada inválida. Por favor, ingrese un número.");
                scanner.next(); 
            }
        }
    }

    public void atenderSiguienteConPrioridad() {
        Queue<Object> cola = metodosBanco.getCola();
        LinkedList<Object> nuevaCola = new LinkedList<>();
        Object elementoAtendido = null;

        // Primero buscar y atender Asuntos Prioritarios
        for (Object elemento : cola) {
            if (elemento instanceof AsuntoPrioritario) {
                elementoAtendido = elemento;
                cola.remove(elemento);
                break;
            }
        }

        // Si no se atendió un Asunto Prioritario, buscar Clientes Preferenciales
        if (elementoAtendido == null) {
            for (Object elemento : cola) {
                if (elemento instanceof ClientePreferencial) {
                    elementoAtendido = elemento;
                    cola.remove(elemento);
                    break;
                }
            }
        }

        // Si no se atendió ni Asunto Prioritario ni Cliente Preferencial, atender Cliente Regular (el primero en la cola)
        if (elementoAtendido == null) {
            elementoAtendido = cola.poll();
        }

        if (elementoAtendido != null) {
            System.out.println("\n--- Atendiendo a ---");
            System.out.println(elementoAtendido);
            System.out.println("-----------------------\n");
        } else {
            System.out.println("La fila de espera está vacía.");
        }

        metodosBanco.setCola(cola); 
    }

    public static void main(String[] args) {
        MenuPrincipal menu = new MenuPrincipal();
        menu.ejecutarMenu();
    }
}


