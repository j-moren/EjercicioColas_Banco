
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Scanner;

public class MetodosBanco {
    private Queue<Object> cola = new LinkedList<>();
    private int nextClienteRegularId = 1001;
    private int nextClientePreferencialId = 2001;
    private int nextAsuntoId = 3001;
    private Scanner scanner;
    private final List<String> tiposTransaccionPermitidos = Arrays.asList("Retiro", "Depósito", "Transferencia", "Pago de Servicios", "Consulta de Saldo");

    public MetodosBanco(Scanner scanner) {
        this.scanner = scanner;
    }

    public void agregarClienteRegular() {
        System.out.println("\n--- Agregar Cliente Regular ---");

        String nombre = "";
        
        while (nombre.isEmpty() || nombre.matches("-?\\d+(\\.\\d+)?")) {
            System.out.print("Ingrese su nombre: ");
            nombre = scanner.nextLine().trim();
            if (nombre.isEmpty()) {
                System.out.println("El nombre no puede estar vacío. Intente de nuevo.");
            } else if (nombre.matches("-?\\d+(\\.\\d+)?")) {
                System.out.println("El nombre no puede contener solo números. Intente de nuevo.");
            }
        }

        String transaccion = "";
        while (transaccion.isEmpty() || !tiposTransaccionPermitidos.contains(transaccion)) {
            System.out.println("Tipos de transacción permitidos: " + tiposTransaccionPermitidos);
            System.out.print("Ingrese el tipo de transacción: ");
            transaccion = scanner.nextLine().trim();
            if (transaccion.isEmpty()) {
                System.out.println("El tipo de transacción no puede estar vacío. Intente de nuevo.");
            } else if (!tiposTransaccionPermitidos.contains(transaccion)) {
                System.out.println("Tipo de transacción inválido. Por favor, elija entre los tipos permitidos.");
            }
        }

        int edad = -1;
        while (edad < 0 || edad > 120) {
            System.out.print("Ingrese su edad: ");
            if (scanner.hasNextInt()) {
                edad = scanner.nextInt();
                scanner.nextLine();
                if (edad < 0 || edad > 120) {
                    System.out.println("Edad inválida. Ingrese una edad entre 0 y 120.");
                }
            } else {
                System.out.println("Entrada inválida. Ingrese un número para la edad.");
                scanner.next();
            }
        }

        String horaLlegada = LocalDateTime.now().format(DateTimeFormatter.ofPattern("HH:mm:ss"));
        ClienteRegular cliente = new ClienteRegular(nextClienteRegularId++, nombre, transaccion, edad, horaLlegada);
        cola.offer(cliente);
        System.out.println("Cliente Regular tomó un turno.");
    }

    public void agregarClientePreferencial() {
        System.out.println("\n--- Agregar Cliente Preferencial ---");

        String nombre = "";
        
        while (nombre.isEmpty() || nombre.matches("-?\\d+(\\.\\d+)?")) {
            System.out.print("Ingrese su nombre: ");
            nombre = scanner.nextLine().trim();
            if (nombre.isEmpty()) {
                System.out.println("El nombre no puede estar vacío. Intente de nuevo.");
            } else if (nombre.matches("-?\\d+(\\.\\d+)?")) {
                System.out.println("El nombre no puede contener solo números. Intente de nuevo.");
            }
        }

        String transaccion = "";
        while (transaccion.isEmpty() || !tiposTransaccionPermitidos.contains(transaccion)) {
            System.out.println("Tipos de transacción permitidos: " + tiposTransaccionPermitidos);
            System.out.print("Ingrese el tipo de transacción: ");
            transaccion = scanner.nextLine().trim();
            if (transaccion.isEmpty()) {
                System.out.println("El tipo de transacción no puede estar vacío. Intente de nuevo.");
            } else if (!tiposTransaccionPermitidos.contains(transaccion)) {
                System.out.println("Tipo de transacción inválido. Por favor, elija entre los tipos permitidos.");
            }
        }

        int edad = -1;
        while (edad < 0 || edad > 120) {
            System.out.print("Ingrese su edad: ");
            if (scanner.hasNextInt()) {
                edad = scanner.nextInt();
                scanner.nextLine();
                if (edad < 0 || edad > 120) {
                    System.out.println("Edad inválida. Ingrese una edad entre 0 y 120.");
                }
            } else {
                System.out.println("Entrada inválida. Ingrese un número para la edad.");
                scanner.next();
            }
        }

        System.out.print("Ingrese el motivo de preferencia: ");
        String motivo = scanner.nextLine();

        String horaLlegada = LocalDateTime.now().format(DateTimeFormatter.ofPattern("HH:mm:ss"));
        ClientePreferencial cliente = new ClientePreferencial(nextClientePreferencialId++, nombre, transaccion, edad, horaLlegada, motivo);
        cola.offer(cliente);
        System.out.println("Cliente Preferencial tomó un turno.");
    }

    public void agregarAsuntoPrioritario() {
        System.out.println("\n--- Registrar Asunto Prioritario ---");
        System.out.print("Ingrese la descripción del asunto prioritario: ");
        String descripcion = scanner.nextLine();
        System.out.print("Ingrese el nombre del cliente que reporta: ");
        String clienteReporta = scanner.nextLine();
        System.out.print("Ingrese el nombre del empleado que atenderá: ");
        String empleado = scanner.nextLine();
        String horaReporte = LocalDateTime.now().format(DateTimeFormatter.ofPattern("HH:mm:ss"));
        AsuntoPrioritario asunto = new AsuntoPrioritario(nextAsuntoId++, descripcion, clienteReporta, horaReporte, empleado);
        LinkedList<Object> tempCola = new LinkedList<>(cola);
        tempCola.addFirst(asunto);
        cola = tempCola;
        System.out.println("Asunto Prioritario registrado (alta prioridad).");
    }

    public Object atenderSiguiente() {
        if (cola.isEmpty()) {
            System.out.println("La fila de espera está vacía.");
            return null;
        }
        return cola.poll();
    }

    public void mostrarEstadoCola() {
        if (cola.isEmpty()) {
            System.out.println("La fila de espera está vacía.");
            return;
        }
        System.out.println("\n--- Estado de la Fila de Espera ---");
        int i = 1;
        for (Object elemento : cola) {
            System.out.println(i + ". " + elemento);
            i++;
        }
        System.out.println("-----------------------------------\n");
    }

    public Queue<Object> getCola() {
        return cola;
    }

    public void setCola(Queue<Object> nuevaCola) {
        this.cola = nuevaCola;
    }
}
