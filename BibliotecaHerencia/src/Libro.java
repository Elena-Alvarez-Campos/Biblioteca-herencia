public class Libro extends ItemBiblioteca {
    //Attributes
    private String autor;
    //COnstructor
    public Libro(int id, String titulo, boolean estadoPrestado,String autor){
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
        double precioMulta=0;
        if (getDiasMaximosPrestamo()-diasRetraso<0){
            precioMulta=0.50*(diasRetraso-getDiasMaximosPrestamo());
        }
        return 0.50;
    }
    @Override
    public String toString(){
        return"\nID: "+id+", tipo de arículo: Libro, título: "+titulo+", autor: "+autor+", estado prestado: "+estadoPrestado;
    }
}
