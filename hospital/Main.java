package hospital;

import java.io.*;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        VectorHeap<Paciente> cola = new VectorHeap<>();

        try (BufferedReader br = new BufferedReader(new FileReader("pacientes.txt"))) {
            String linea;
            while ((linea = br.readLine()) != null) {
                if (linea.trim().isEmpty()) continue;
                String[] partes = linea.split(",");
                cola.add(new Paciente(partes[0], partes[1], partes[2].trim().charAt(0)));
            }
        } catch (IOException e) {
            System.out.println("Error al leer el archivo: " + e.getMessage());
        }

        System.out.println("=== Emergencias (VectorHeap) — " + cola.size() + " pacientes ===\n");

        Scanner scanner = new Scanner(System.in);
        while (!cola.isEmpty()) {
            System.out.println("Siguiente: " + cola.peek());
            System.out.print("ENTER para atender, 'q' para salir: ");
            String input = scanner.nextLine().trim();
            if (input.equalsIgnoreCase("q")) break;
            System.out.println(">>> ATENDIENDO: " + cola.remove() + "\n");
        }

        if (cola.isEmpty()) System.out.println("No hay más pacientes.");
        scanner.close();
    }
}
