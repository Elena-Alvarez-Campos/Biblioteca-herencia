public abstract class ItemBiblioteca {
    //Atributos
    public int id;
    public String titulo;
    public boolean estadoPrestado;
    //Construcotr
    //Solo las usan las hijas!!
    public ItemBiblioteca(int id, String titulo, boolean estadoPrestado){
        this.estadoPrestado=estadoPrestado;
        this.id=id;
        this.titulo=titulo;
    }
    //Getters y Setters
    public void setId(int id) {
        this.id = id;
    }
    public void setEstadoPrestado(boolean estadoPrestado) {
        this.estadoPrestado = estadoPrestado;
    }
    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }
    public int getId() {
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
        this.estadoPrestado=true;
        return this.estadoPrestado;
    }
    public boolean devolver(){
        this.estadoPrestado=false;
        return this.estadoPrestado;
    }



    public abstract double calcularMulta(int diasRetraso);
    public abstract int getDiasMaximosPrestamo();
}
