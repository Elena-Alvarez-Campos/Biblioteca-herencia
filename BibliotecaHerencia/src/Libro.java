public abstract class Libro extends ItemBiblioteca {
    //Attributes
    private String autor;
    //COnstructor
    public Libro(String autor,String id, String titulo, boolean estadoPrestado){
        super(id, titulo ,estadoPrestado);
        this.autor=autor;
    }
    //Getters y setters
    public void setAutor(String autor) {
        this.autor = autor;
    }
    public String getAutor() {
        return autor;
    }
    //Métodos

    @Override
    public int getDiasMaximosPrestamo() {
        return 14;
    }
    @Override
    public double calcularMulta(int diasRetraso) {
        return 0.50;
    }
}
