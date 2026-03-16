public class Revista extends ItemBiblioteca {
    //Attributes
    private int numeroEdicion;
    //COnstructor
    public Revista(int id, String titulo, boolean estadoPrestado,int numeroEdicion){
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
        double precioMulta=0;
        if (getDiasMaximosPrestamo()-diasRetraso<0){
            precioMulta=1*(diasRetraso-getDiasMaximosPrestamo());
        }
        return precioMulta;
    }
    @Override
    public String toString(){
        return"\nID: "+id+", tipo de arículo: Revista, título: "+titulo+", numero de edición: "+numeroEdicion+", estado prestado: "+estadoPrestado;
    }
}