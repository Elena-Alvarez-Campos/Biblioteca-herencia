import java.util.ArrayList;

public class GestorMediateca {
    //Atributos
    public ArrayList<ItemBiblioteca> catalogo;
    //Constructor
    public GestorMediateca(ArrayList<ItemBiblioteca> catalogo ){
        this.catalogo=catalogo;
    }
    //Setters y getters
    public void setCatalogo(ArrayList<ItemBiblioteca> catalogo) {
        this.catalogo = catalogo;
    }
    public ArrayList<ItemBiblioteca> getCatalogo() {
        return catalogo;
    }
    //Métodos
    public void nuevoItem(){

    }
}
