package projecto_final;

import java.util.Scanner;

public class Projecto_final {
    
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        // LIBROS
        Libro libro1 = new Libro("Cien Años de Soledad", "García Márquez", "Novela", 1967, 2);
        Libro libro2 = new Libro("El Principito", "Antoine de Saint-Exupéry", "Fábula", 1943, 3);
        Libro libro3 = new Libro("Don Quijote", "Cervantes", "Clásico", 1605, 1);
        Libro libro4 = new Libro("1984", "George Orwell", "Distopía", 1949, 2);
        Libro libro5 = new Libro("La Odisea", "Homero", "Épico", -800, 1);
        Libro libro6 = new LibroDigital("Java Pro", "Autor X", "Programación", 2024, 1);

        // ================= CREAR USUARIO =================
        System.out.println("Creando nuevo usuario");

        System.out.print("Escribe tu nombre: ");
        String nombre = sc.nextLine();
        while (nombre.trim().isEmpty()) {
            System.out.println("Error: nombre vacío.");
            nombre = sc.nextLine();
        }

        System.out.print("Ingresa tu edad: ");
        while (!sc.hasNextInt()) {
            System.out.println("Error: escribe un número.");
            sc.next();
        }
        int edad = sc.nextInt();

        System.out.print("Elige un ID de 4 dígitos: ");
        while (!sc.hasNextInt()) {
            System.out.println("Error: escribe números.");
            sc.next();
        }
        int id = sc.nextInt();
        while (id < 1000 || id > 9999) {
            System.out.println("Error: debe ser de 4 dígitos.");
            id = sc.nextInt();
        }

        Cliente usuarioActual = new Cliente(nombre, edad, id);

        // ================= CASTING =================
        Persona personaRef = usuarioActual; // conversión automática
        if (personaRef instanceof Cliente) {
            Cliente c = (Cliente) personaRef; // casting
            System.out.println("Bienvenido " + c.getNombre());
        }

        // ================= MENÚ =================
        int opcion;
        do {
            System.out.println("\n=== MENÚ BIBLIOTECA ===");
            System.out.println("1. Ver libros");
            System.out.println("2. Pedir libro");
            System.out.println("3. Devolver libro");
            System.out.println("4. Ver mis libros");
            System.out.println("5. Salir");
            System.out.print("Opción: ");

            while (!sc.hasNextInt()) {
                System.out.println("Error: ingresa número.");
                sc.next();
            }
            opcion = sc.nextInt();

            switch (opcion) {

                case 1:
                    System.out.println(libro1);
                    System.out.println(libro2);
                    System.out.println(libro3);
                    System.out.println(libro4);
                    System.out.println(libro5);
                    System.out.println(libro6);
                    break;

                case 2:
                    if (usuarioActual.getLibrosPrestados() >= 2) {
                        System.out.println("Máximo 2 libros.");
                        break;
                    }

                    System.out.println("1-6 para elegir libro:");
                    int p = sc.nextInt();

                    Libro libroP = null;
                    if (p == 1) libroP = libro1;
                    else if (p == 2) libroP = libro2;
                    else if (p == 3) libroP = libro3;
                    else if (p == 4) libroP = libro4;
                    else if (p == 5) libroP = libro5;
                    else if (p == 6) libroP = libro6;

                    if (libroP != null && libroP.prestar()) {
                        usuarioActual.aumentarPrestamo();
                        System.out.println("Préstamo exitoso.");
                    } else {
                        System.out.println("No disponible.");
                    }
                    break;

                case 3:
                    System.out.println("1-6 para devolver libro:");
                    int d = sc.nextInt();

                    Libro libroD = null;
                    if (d == 1) libroD = libro1;
                    else if (d == 2) libroD = libro2;
                    else if (d == 3) libroD = libro3;
                    else if (d == 4) libroD = libro4;
                    else if (d == 5) libroD = libro5;
                    else if (d == 6) libroD = libro6;

                    if (libroD != null && libroD.devolver()) {
                        usuarioActual.disminuirPrestamo();
                        System.out.println("Devuelto.");
                    }
                    break;

                case 4:
                    System.out.println("Libros prestados: "
                            + usuarioActual.getLibrosPrestados());
                    break;

                case 5:
                    System.out.println("Saliendo...");
                    break;

                default:
                    System.out.println("Opción inválida.");
            }

        } while (opcion != 5);

        sc.close();
    }
}