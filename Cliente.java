package projecto_final;

public class Cliente extends Persona {
    String nombre;
    int edad;
    int id;
    int librosPrestados;

    public Cliente(String nombre, int edad, int id) {
        this.nombre = nombre;
        this.edad = edad;
        this.id = id;
        this.librosPrestados = 0;
    }

    public Cliente() {
        this.librosPrestados = 0;
    }
}