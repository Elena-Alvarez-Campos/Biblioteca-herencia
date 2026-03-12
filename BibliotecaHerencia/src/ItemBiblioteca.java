public abstract class ItemBiblioteca {
    //Atributos
    private String id;
    private String titulo;
    private boolean estadoPrestado;
    //Construcotr
    public ItemBiblioteca(String id, String titulo, boolean estadoPrestado){
        this.estadoPrestado=estadoPrestado;
        this.id=id;
        this.titulo=titulo;
    }
    //Getters y Setters
    public void setId(String id) {
        this.id = id;
    }
    public void setEstadoPrestado(boolean estadoPrestado) {
        this.estadoPrestado = estadoPrestado;
    }
    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }
    public String getId() {
        return id;
    }
    public String getTitulo() {
        return titulo;
    }
    public boolean getEstadoPrestado() {
        return estadoPrestado;
    }
    //Métodos
    public boolean prestar(){
        return true;
    }
    public boolean devolver(){
        return true;
    }

    public abstract double calcularMulta(int diasRetraso);
    public abstract int getDiasMaximosPrestamo();
}
