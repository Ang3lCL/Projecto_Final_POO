package projecto_final;

public class LibroDigital extends Libro {

    private String formato;   // Ej: "PDF", "EPUB", "MOBI"
    private double tamanioMB; // Tamaño del archivo en MB

    // Constructor: usa super() para inicializar los atributos de Libro
    // Se pasa 999 como copias porque un libro digital no se agota
    public LibroDigital(String titulo, String autor, String genero, int año, String formato, double tamanioMB) {
        super(titulo, autor, genero, año, 999);
        this.formato = formato;
        this.tamanioMB = tamanioMB;
    }

    public String getFormato() {
        return formato;
    }

    public double getTamanioMB() {
        return tamanioMB;
    }

    // Un libro digital siempre se puede "prestar" (es un archivo, no se agota)
    @Override
    public boolean prestar() {
        return true;
    }

    // La "devolución" también siempre es válida
    @Override
    public boolean devolver() {
        return true;
    }

    // Se extiende el toString() de Libro con la info extra del formato digital
    @Override
    public String toString() {
        return super.toString()
                + "\nFormato: " + formato
                + "\nTamaño: " + tamanioMB + " MB"
                + "\n[LIBRO DIGITAL]";
    }
}