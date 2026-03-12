public abstract class Libro extends ItemBiblioteca {
    //Attributes
    private String autor;
    //COnstructor
    public Libro(String autor,String id, String titulo, boolean estadoPrestado){
        super(String id, String titulo, boolean estadoPrestado);
        this.autor=autor;
    }
}
