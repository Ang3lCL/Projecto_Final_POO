package projecto_final;

public class LibroDigital extends Libro {

    private String formato;  
    private double tamanioMB; 


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

    
    @Override
    public boolean prestar() {
        return true;
    }

    
    @Override
    public boolean devolver() {
        return true;
    }

    
    @Override
    public String toString() {
        return super.toString()
                + "\nFormato: " + formato
                + "\nTamaño: " + tamanioMB + " MB"
                + "\n[LIBRO DIGITAL]";
    }
}