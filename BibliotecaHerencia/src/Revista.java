public abstract class Revista extends ItemBiblioteca {
    //Attributes
    private int numeroEdicion;
    //COnstructor
    public Revista(int numeroEdicion,String id, String titulo, boolean estadoPrestado){
        super(id, titulo ,estadoPrestado);
        this.numeroEdicion=numeroEdicion;
    }
    //Getters y setters
    public void setNumeroEdicion(int numeroEdicion) {
        this.numeroEdicion = numeroEdicion;
    }
    public int getNumeroEdicion() {
        return numeroEdicion;
    }
    //Métodos
    @Override
    public int getDiasMaximosPrestamo() {
        return 7;
    }
    @Override
    public double calcularMulta(int diasRetraso) {
        return 1;
    }
}