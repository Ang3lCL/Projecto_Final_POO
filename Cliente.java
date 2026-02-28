package projecto_final;

class Cliente extends Persona {

    private int id;
    private int librosPrestados;

    public Cliente(String nombre, int edad, int id) {
        super(nombre, edad); // HERENCIA
        this.id = id;
        this.librosPrestados = 0;
    }

    // Encapsulamiento
    public int getId() {
        return id;
    }

    public int getLibrosPrestados() {
        return librosPrestados;
    }

    public void aumentarPrestamo() {
        librosPrestados++;
    }

    public void disminuirPrestamo() {
        librosPrestados--;
    }

    // POLIMORFISMO (override)
    @Override
    public String getTipo() {
        return "Cliente";
    }
}