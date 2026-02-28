package projecto_final;

import java.util.Scanner;

public class Projecto_final {
    
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        Cliente[] usuarios = new Cliente[10];
        int totalUsuarios = 0;
        Cliente usuarioActual = null;

        Libro libro1 = new Libro("El Señor de los Anillos", "Tolkien", "Fantasía", 1954, 3);
        Libro libro2 = new Libro("Cien años de soledad", "García Márquez", "Novela", 1967, 2);
        Libro libro3 = new Libro("La metamorfosis", "Kafka", "Novela", 1915, 4);
        Libro libro4 = new Libro("La odisea", "Homero", "Epopeya", 0, 2);
        Libro libro5 = new Libro("Estravagario", "Pablo Neruda", "Poesía", 1958, 3);
        Libro libro6 = new Libro("Danza de Dragones", "George R. R. Martin", "Fantasía", 2011, 2);

        System.out.print("¿Tienes un usuario? (si/no): ");
        String respuesta = sc.nextLine();

        while (!respuesta.equalsIgnoreCase("si") && !respuesta.equalsIgnoreCase("no")) {
            System.out.println("Error, opcion invalida, solo puedes escribir 'si' o 'no'. Intenta de nuevo.");
            System.out.print("¿Tienes un usuario? (si/no): ");
            respuesta = sc.nextLine();
        }

        if (respuesta.equalsIgnoreCase("no")) {

            System.out.print("¿Quieres crear un usuario? (si/no): ");
            String crear = sc.nextLine();

            while (!crear.equalsIgnoreCase("si") && !crear.equalsIgnoreCase("no")) {
                System.out.println("Error, opcion invalida, solo puedes escribir 'si' o 'no'. Intenta de nuevo.");
                System.out.print("¿Quieres crear un usuario? (si/no): ");
                crear = sc.nextLine();
            }

            if (crear.equalsIgnoreCase("no")) {
                System.out.println("Regresa pronto");
                System.out.println("Programa terminado.");
                sc.close();
                return;
            }

            Cliente nuevo = new Cliente();
            System.out.println("Creando nuevo usuario");

        
            System.out.print("Escribe tu nombre: ");
            nuevo.nombre = sc.nextLine();

            while (nuevo.nombre.trim().isEmpty()) {
                System.out.println("Error: el nombre no puede estar vacío. Intenta de nuevo.");
                System.out.print("Escribe tu nombre: ");
                nuevo.nombre = sc.nextLine();
            }

            
            System.out.print("Ingresa tu edad (en numeros): ");
            while (!sc.hasNextInt()) {
                System.out.println("Error: debes escribir un número válido.");
                System.out.print("Ingresa tu edad (en numeros): ");
                sc.next(); 
            }
            nuevo.edad = sc.nextInt();

            
            System.out.print("Elige un ID de 4 dígitos (ex. 1234): ");
            while (!sc.hasNextInt()) {
                System.out.println("Error: debes escribir un número de 4 dígitos.");
                System.out.print("Elige un ID de 4 dígitos (ex. 1234): ");
                sc.next();
            }
            nuevo.id = sc.nextInt();

            while (nuevo.id < 1000 || nuevo.id > 9999) {
                System.out.println("Error: el ID debe tener exactamente 4 dígitos.");
                System.out.print("Elige un ID de 4 dígitos (ex. 1234): ");
                while (!sc.hasNextInt()) {
                    System.out.println("Error: debes escribir un número válido.");
                    System.out.print("Elige un ID de 4 dígitos (ex. 1234): ");
                    sc.next();
                }
                nuevo.id = sc.nextInt();
            }

            nuevo.librosPrestados = 0;
            sc.nextLine(); 

            usuarios[totalUsuarios++] = nuevo;
            totalUsuarios++;
            usuarioActual = nuevo;

            System.out.println("Usuario creado");
            System.out.println("Bienvenido " + nuevo.nombre);

        } else if (respuesta.equalsIgnoreCase("si")) {
            
            System.out.print("Cual es tu usuario?: ");
            String xd = sc.nextLine();
            if (usuarioActual == null) {
                System.out.println("Usuario "+ xd + " no encontrado.");
                System.out.println("--------------------------------");
                System.out.println("Nesesitas crear un usuario");
                Cliente nuevo = new Cliente();
                System.out.println("Creando nuevo usuario");

            
                System.out.print("Escribe tu nombre: ");
                nuevo.nombre = sc.nextLine();

                while (nuevo.nombre.trim().isEmpty()) {
                    System.out.println("Error: el nombre no puede estar vacío. Intenta de nuevo.");
                    System.out.print("Escribe tu nombre: ");
                    nuevo.nombre = sc.nextLine();
                }

                
                System.out.print("Ingresa tu edad (en numeros): ");
                while (!sc.hasNextInt()) {
                    System.out.println("Error: debes escribir un número válido.");
                    System.out.print("Ingresa tu edad (en numeros): ");
                    sc.next(); 
                }
                nuevo.edad = sc.nextInt();

                
                System.out.print("Elige un ID de 4 dígitos (ex. 1234): ");
                while (!sc.hasNextInt()) {
                    System.out.println("Error: debes escribir un número de 4 dígitos.");
                    System.out.print("Elige un ID de 4 dígitos (ex. 1234): ");
                    sc.next();
                }
                nuevo.id = sc.nextInt();

                while (nuevo.id < 1000 || nuevo.id > 9999) {
                    System.out.println("Error: el ID debe tener exactamente 4 dígitos.");
                    System.out.print("Elige un ID de 4 dígitos (ex. 1234): ");
                    while (!sc.hasNextInt()) {
                        System.out.println("Error: debes escribir un número válido.");
                        System.out.print("Elige un ID de 4 dígitos (ex. 1234): ");
                        sc.next();
                    }
                    nuevo.id = sc.nextInt();
                }

                nuevo.librosPrestados = 0;
                sc.nextLine(); 

                usuarios[totalUsuarios++] = nuevo;
                totalUsuarios++;
                usuarioActual = nuevo;

                System.out.println("Usuario creado");
                System.out.println("Bienvenido " + nuevo.nombre);
                    
                }

        } else if (totalUsuarios == 0) {
                System.out.println("No hay usuarios registrados.");
                sc.close();
                return;
            }

        int opcion;
        do {
            System.out.println("\n=== MENÚ BIBLIOTECA ===");
            System.out.println("1. Ver información de los libros");
            System.out.println("2. Pedir prestado un libro");
            System.out.println("3. Devolver un libro");
            System.out.println("4. Ver cantidad de libros que tienes");
            System.out.println("5. Salir");
            System.out.print("Elige una opción (1 a 5): ");

            
            while (!sc.hasNextInt()) {
                System.out.println("Error: Debes ingresar un número del 1 al 5.");
                System.out.print("Elige una opción (1 a 5): ");
                sc.next();
            }

            opcion = sc.nextInt();

            
            while (opcion < 1 || opcion > 5) {
                System.out.println("Error: Opción fuera de rango.");
                System.out.print("Elige una opción (1 a 5): ");
                while (!sc.hasNextInt()) {
                    System.out.println("Error: Debes ingresar un número.");
                    System.out.print("Elige una opción (1 a 5): ");
                    sc.next();
                }
                opcion = sc.nextInt();
            }

            switch (opcion) {

                case 1:
                    System.out.println("\n--- Libro 1 ---");
                    System.out.println(libro1);
                    System.out.println("\n--- Libro 2 ---");
                    System.out.println(libro2);
                    System.out.println("\n--- Libro 3 ---");
                    System.out.println(libro3);
                    System.out.println("\n--- Libro 4 ---");
                    System.out.println(libro4);
                    System.out.println("\n--- Libro 5 ---");
                    System.out.println(libro5);
                    System.out.println("\n--- Libro 6 ---");
                    System.out.println(libro6);
                    break;

                case 2:
                    if (usuarioActual.librosPrestados >= 2) {
                        System.out.println("No puedes pedir más de 2 libros.");
                        break;
                    }

                    System.out.println("\nQué libro quieres pedir prestado?");
                    System.out.println("1. " + libro1.getTitulo());
                    System.out.println("2. " + libro2.getTitulo());
                    System.out.println("3. " + libro3.getTitulo());
                    System.out.println("4. " + libro4.getTitulo());
                    System.out.println("5. " + libro5.getTitulo());
                    System.out.println("6. " + libro6.getTitulo());
                    System.out.print("Opción (1 a 6): ");

                    while (!sc.hasNextInt()) {
                        System.out.println("Error: Debes ingresar un número del 1 al 6.");
                        System.out.print("Opción (1 a 6): ");
                        sc.next();
                    }

                    int p = sc.nextInt();

                    while (p < 1 || p > 6) {
                        System.out.println("Error: Opción fuera de rango.");
                        System.out.print("Opción (1 a 6): ");
                        while (!sc.hasNextInt()) {
                            System.out.println("Error: Debes ingresar un número.");
                            System.out.print("Opción (1 a 6): ");
                            sc.next();
                        }
                        p = sc.nextInt();
                    }

                    Libro libroP = null;
                    if (p == 1) libroP = libro1;
                    else if (p == 2) libroP = libro2;
                    else if (p == 3) libroP = libro3;
                    else if (p == 4) libroP = libro4;
                    else if (p == 5) libroP = libro5;
                    else if (p == 6) libroP = libro6;

                    if (libroP != null && libroP.prestar()) {
                        usuarioActual.librosPrestados++;
                        System.out.println("Préstamo realizado con éxito.");
                    } else {
                        System.out.println("No hay copias disponibles.");
                    }
                    break;

                case 3:
                    System.out.println("\nQué libro quieres devolver?");
                    System.out.println("1. " + libro1.getTitulo());
                    System.out.println("2. " + libro2.getTitulo());
                    System.out.println("3. " + libro3.getTitulo());
                    System.out.println("4. " + libro4.getTitulo());
                    System.out.println("5. " + libro5.getTitulo());
                    System.out.println("6. " + libro6.getTitulo());
                    System.out.print("Opción (1 a 6): ");

                    while (!sc.hasNextInt()) {
                        System.out.println("Error: Debes ingresar un número del 1 al 6.");
                        System.out.print("Opción (1 a 6): ");
                        sc.next();
                    }

                    int d = sc.nextInt();

                    while (d < 1 || d > 6) {
                        System.out.println("Error: Opción fuera de rango.");
                        System.out.print("Opción (1 a 6): ");
                        while (!sc.hasNextInt()) {
                            System.out.println("Error: Debes ingresar un número.");
                            System.out.print("Opción (1 a 6): ");
                            sc.next();
                        }
                        d = sc.nextInt();
                    }

                    Libro libroD = null;
                    if (d == 1) libroD = libro1;
                    else if (d == 2) libroD = libro2;
                    else if (d == 3) libroD = libro3;
                    else if (d == 4) libroD = libro4;
                    else if (d == 5) libroD = libro5;
                    else if (d == 6) libroD = libro6;

                    if (libroD != null && libroD.devolver()) {
                        usuarioActual.librosPrestados--;
                        System.out.println("Devolución completada.");
                    } else {
                        System.out.println("No tienes ese libro.");
                    }
                    break;

                case 4:
                    System.out.println("Libros prestados por " + usuarioActual.nombre + ": "
                            + usuarioActual.librosPrestados);
                    break;

                case 5:
                    System.out.println("Saliendo de la biblioteca...");
                    break;
            }

        } while (opcion != 5);

        sc.close();
    }

}
