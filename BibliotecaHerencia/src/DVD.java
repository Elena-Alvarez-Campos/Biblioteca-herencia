public abstract class DVD extends ItemBiblioteca {
    //Attributes
    private String director;
    //COnstructor
    public DVD(String director,String id, String titulo, boolean estadoPrestado){
        super(id, titulo ,estadoPrestado);
        this.director=director;
    }
    //Getters y setters
    public void setDirector(String director) {
        this.director = director;
    }
    public String getDirector() {
        return director;
    }
    //Métodos

    @Override
    public int getDiasMaximosPrestamo() {
        return 3;
    }
    @Override
    public double calcularMulta(int diasRetraso) {
        return 2;
    }
}