## Projecto Final

**Enunciado**  
Se creo un sistema de biblioteca que tiene lo siguiente:
Se pueden consultar los libros disponible asi como pedirlos prestados y devolverlos posteriormente
Valida que los datos ingresados sean correctos y coherentes y en caso de no serlo le pide al usuario que intente de nuevo.
Controla que no se presten más libros de los que hay disponibles ni que se exceda el límite de dos ejemplares por usuario.
Genera reportes (impresiones en pantalla) sobre el estado de la biblioteca, así como del número de libros y préstamos.
Inclueye abstraccion en varias partes del codigo.
Tiene encapsulamiento en ciertas partes de los atributos de las clases.
Utiliza herencia en las clases para un mejor funcionamiento.
Usa el polimorfismo en la parte de los clientes.
*falta por implementar la conversion de objetos*

**Codigo**
````java
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

````

**Salida final**
En esta salida se mostrara el contro de errores ademas del codigo funcional
````
¿Tienes un usuario? (si/no): no
¿Quieres crear un usuario? (si/no): si
Creando nuevo usuario
Escribe tu nombre: Angel
Ingresa tu edad (en numeros): 18
Elige un ID de 4 dígitos (ex. 1234): 1404 
Usuario creado
Bienvenido Angel

=== MENÚ BIBLIOTECA ===
1. Ver información de los libros
2. Pedir prestado un libro
3. Devolver un libro
4. Ver cantidad de libros que tienes
5. Salir
Elige una opción (1 a 5): 1

--- Libro 1 ---
Título: El Señor de los Anillos
Autor: Tolkien
Género: Fantasía
Año: 1954
Copias totales: 3
Prestadas: 0
Disponibles: 3

--- Libro 2 ---
Título: Cien años de soledad
Autor: García Márquez
Género: Novela
Año: 1967
Copias totales: 2
Prestadas: 0
Disponibles: 2

--- Libro 3 ---
Título: La metamorfosis
Autor: Kafka
Género: Novela
Año: 1915
Copias totales: 4
Prestadas: 0
Disponibles: 4

--- Libro 4 ---
Título: La odisea
Autor: Homero
Género: Epopeya
Año: 0
Copias totales: 2
Prestadas: 0
Disponibles: 2

--- Libro 5 ---
Título: Estravagario
Autor: Pablo Neruda
Género: Poesía
Año: 1958
Copias totales: 3
Prestadas: 0
Disponibles: 3

--- Libro 6 ---
Título: Danza de Dragones
Autor: George R. R. Martin
Género: Fantasía
Año: 2011
Copias totales: 2
Prestadas: 0
Disponibles: 2

=== MENÚ BIBLIOTECA ===
1. Ver información de los libros
2. Pedir prestado un libro
3. Devolver un libro
4. Ver cantidad de libros que tienes
5. Salir
Elige una opción (1 a 5): 2

Qué libro quieres pedir prestado?
1. El Señor de los Anillos
2. Cien años de soledad
3. La metamorfosis
4. La odisea
5. Estravagario
6. Danza de Dragones
Opción (1 a 6): 7
Error: Opción fuera de rango.
Opción (1 a 6): 1
Préstamo realizado con éxito.

=== MENÚ BIBLIOTECA ===
1. Ver información de los libros
2. Pedir prestado un libro
3. Devolver un libro
4. Ver cantidad de libros que tienes
5. Salir
Elige una opción (1 a 5): 3

Qué libro quieres devolver?
1. El Señor de los Anillos
2. Cien años de soledad
3. La metamorfosis
4. La odisea
5. Estravagario
6. Danza de Dragones
Opción (1 a 6): el señor de los anillos
Error: Debes ingresar un número del 1 al 6.
Opción (1 a 6): 1
Devolución completada.

=== MENÚ BIBLIOTECA ===
1. Ver información de los libros
2. Pedir prestado un libro
3. Devolver un libro
4. Ver cantidad de libros que tienes
5. Salir
Elige una opción (1 a 5): 4
Libros prestados por Angel: 0

=== MENÚ BIBLIOTECA ===
1. Ver información de los libros
2. Pedir prestado un libro
3. Devolver un libro
4. Ver cantidad de libros que tienes
5. Salir
Elige una opción (1 a 5): 6
Error: Opción fuera de rango.
Elige una opción (1 a 5): 5
Saliendo de la biblioteca...
````