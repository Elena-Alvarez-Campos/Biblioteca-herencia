import javax.swing.*;
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
    @Override
    public String toString(){
        return "Catálogo"+catalogo;
    }
    //Nuevo producto************************************************************************************************
    public void nuevoProducto(){
        boolean programa=true;
        int opcion=0;

        while (programa==true){
            String categoria= JOptionPane.showInputDialog("¿Que tipo de artículo se va a añadir?**********\n" +
                "1.Libro\n" +
                "2.Revista\n" +
                "3.DVD\n"+
                "4.Salir");
            try{
                opcion=Integer.parseInt(categoria);
                if(opcion==4){programa=false;}
                else if (opcion<=0&opcion>4){
                    JOptionPane.showMessageDialog(null,"Elige una opción correcta");
                }
                else{
                    int id=this.catalogo.size()+1;

                    boolean prestado=false;
                    String titulo="";
                    switch (opcion){
                        case 1://libro
                            String autor=JOptionPane.showInputDialog("Introduce el nombre del autor");
                            Libro libroNuevo=new Libro(id,titulo,prestado,autor);
                            this.catalogo.add(libroNuevo);
                            programa=false;
                            break;
                        case 2://revista
                            String edicion=JOptionPane.showInputDialog("Introduce el número de edición");
                            try{
                                int numEdicion=Integer.parseInt(edicion);
                                Revista revistaNueva=new Revista(id,titulo,prestado,numEdicion);
                                this.catalogo.add(revistaNueva);
                                programa=false;
                            }catch (Exception e){
                                JOptionPane.showMessageDialog(null,"Elige una opción correcta");
                            }
                            break;
                        case 3:
                            String director=JOptionPane.showInputDialog("Introduce el nombre del direcor");
                            DVD DVDNuevo=new DVD(id,titulo,prestado,director);
                            this.catalogo.add(DVDNuevo);
                            programa=false;
                            break;
                        default:
                            JOptionPane.showMessageDialog(null,"Elige una opción correcta");
                    }
                }
            }catch(Exception e){
                JOptionPane.showMessageDialog(null,"Elige una opción correcta");
            }

        }
    }
    //Cambiar título*************************************
    public void cambiaTitulo() {
        String texto = JOptionPane.showInputDialog("Introduce el ID del artículo para cambiarle el título");
        try{
            int id=Integer.parseInt(texto);
            boolean encontrado=false;
            for(int i=0; i<=this.catalogo.size();i++){
                if(this.catalogo.get(i).id==id){
                    String titulo=JOptionPane.showInputDialog("Introduce el nuevo título\n" +
                            "Anterior título: "+this.catalogo.get(i).titulo)+"\n"+
                            "ID: "+this.catalogo.get(i).id;
                    this.catalogo.get(i).titulo=titulo;
                    encontrado=true;
                    JOptionPane.showMessageDialog(null,"Cambio guardado");
                    break;
                }
            }
            if(encontrado==false){
                JOptionPane.showMessageDialog(null,"No se ha encontrado el ID");
            }

        }catch(Exception e){
            JOptionPane.showMessageDialog(null,"ID no compatible");
        }
    }
    //Prestar ítem**************************************************************************************************
    public void prestarItem() {
        String texto = JOptionPane.showInputDialog("Introduce el ID del artículo para prestar");
        try{
            int id=Integer.parseInt(texto);
            boolean encontrado=false;
            for(int i=0; i<=this.catalogo.size();i++){
                if(this.catalogo.get(i).id==id){
                    this.catalogo.get(i).estadoPrestado=true;
                    encontrado=true;
                    JOptionPane.showMessageDialog(null,"Se ha prestado: "+this.catalogo.get(i).titulo+
                            "\n Días para devolver: "+this.catalogo.get(i).getDiasMaximosPrestamo());
                    break;
                }
            }
            if(encontrado==false){
                JOptionPane.showMessageDialog(null,"No se ha encontrado el ID");
            }

        }catch(Exception e){
            JOptionPane.showMessageDialog(null,"ID no compatible");
        }
    }
    //Devolver item***************************************************************************************************
    public void devolverItem(){
        String texto = JOptionPane.showInputDialog("Introduce el ID del artículo para devolver");
        try{
            int id=Integer.parseInt(texto);
            boolean encontrado=false;
            for(int i=0; i<=this.catalogo.size();i++){
                if(this.catalogo.get(i).id==id){
                    this.catalogo.get(i).estadoPrestado=false;
                    try {
                        while (encontrado==false){
                            String tiempo = JOptionPane.showInputDialog("Introduce los días que se tardó en devolver:");
                            int dias=Integer.parseInt(tiempo);
                            if(dias<=this.catalogo.get(i).getDiasMaximosPrestamo()){
                                JOptionPane.showMessageDialog(null,"No hubo retraso");
                            }
                            else{
                                JOptionPane.showMessageDialog(null,"Multa: "+this.catalogo.get(i).calcularMulta(dias)+"€");
                            }
                            encontrado=true;
                        }
                        break;
                    }catch (Exception e){
                        JOptionPane.showMessageDialog(null,"ID no compatible");
                    }
                }
            }
            if(encontrado==false){
                JOptionPane.showMessageDialog(null,"No se ha encontrado el ID");
            }

        }catch(Exception e){
            JOptionPane.showMessageDialog(null,"ID no compatible");
        }
    }

}
