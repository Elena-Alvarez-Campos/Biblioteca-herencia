public class DVD extends ItemBiblioteca {
    //Attributes
    private String director;
    //COnstructor
    public DVD(int id, String titulo, boolean estadoPrestado,String director){
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
        double precioMulta=0;
        if (getDiasMaximosPrestamo()-diasRetraso<0){
            precioMulta=2*(diasRetraso-getDiasMaximosPrestamo());
        }
        return precioMulta;
    }
    @Override
    public String toString(){
        return"\nID: "+id+", tipo de arículo: DVD, título: "+titulo+", director: "+director+", estado prestado: "+estadoPrestado;
    }
}