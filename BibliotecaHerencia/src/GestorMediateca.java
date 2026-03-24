import javax.swing.*;
import java.util.ArrayList;
import java.util.Scanner;

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
            Scanner objeto=new Scanner(System.in);
            System.out.println("¿Que tipo de artículo se va a añadir?**********\n" +
                "1.Libro\n" +
                "2.Revista\n" +
                "3.DVD\n"+
                "4.Salir");
            try{
                opcion=objeto.nextInt();
                //opcion=Integer.parseInt(categoria);
                if(opcion==4){programa=false;}
                else if (opcion<=0&opcion>4){
                    System.out.println("Elige una opción correcta");
                }
                else{
                    int id=this.catalogo.size()+1;

                    boolean prestado=false;
                    //String titulo="";
                    switch (opcion){
                        case 1://libro
                            Scanner ScanLibro=new Scanner(System.in);
                            System.out.println("Introduce el nombre del autor");
                            String autor=ScanLibro.nextLine();
                            System.out.println("Introduce el título del libro");
                            String tituloL=ScanLibro.nextLine();
                            Libro libroNuevo=new Libro(id,tituloL,prestado,autor);
                            this.catalogo.add(libroNuevo);
                            programa=false;
                            break;
                        case 2://revista
                            Scanner ScanRevista=new Scanner(System.in);
                            System.out.println("Introduce el título de la revista");
                            String tituloR=ScanRevista.nextLine();
                            System.out.println("Introduce el número de edición");
                            try{
                                int numEdicion=ScanRevista.nextInt();
                                //int numEdicion=Integer.parseInt(edicion);

                                Revista revistaNueva=new Revista(id,tituloR,prestado,numEdicion);
                                this.catalogo.add(revistaNueva);
                                programa=false;
                            }catch (Exception e){
                                System.out.println("El número dela revista no puede ser una letra\n"+"Revista no guardada");
                            }
                            break;
                        case 3://DVD
                            Scanner ScanD=new Scanner(System.in);
                            System.out.println("Introduce el nombre del direcor");
                            String director= ScanD.nextLine();
                            System.out.println("Introduce el título del libro");
                            String tituloD=ScanD.nextLine();
                            DVD DVDNuevo=new DVD(id,tituloD,prestado,director);
                            this.catalogo.add(DVDNuevo);
                            programa=false;
                            break;
                        default:
                            System.out.println("Elige una opción correcta");
                    }
                }
            }catch(Exception e){
                System.out.println("Elige una opción correcta");
            }

        }
    }
    //Cambiar título*************************************
    public void cambiaTitulo() {
        Scanner ScanTitulo= new Scanner(System.in);
        Scanner ScanID=new Scanner(System.in);
        System.out.println("Introduce el ID del artículo para cambiarle el título");
        try{
            int id=ScanID.nextInt();
            //int id=Integer.parseInt(texto);
            boolean encontrado=false;
            for(int i=0; i<=this.catalogo.size();i++){
                if(this.catalogo.get(i).id==id){
                    System.out.println("Introduce el nuevo título\n" +
                            "Anterior título: "+this.catalogo.get(i).titulo+"\n"+
                            "ID: "+this.catalogo.get(i).id);
                    String titulo=ScanTitulo.nextLine();
                    this.catalogo.get(i).titulo=titulo;
                    encontrado=true;
                    System.out.println("Cambio guardado");
                    break;
                }
            }
            if(encontrado==false){
                System.out.println("No se ha encontrado el ID");
            }

        }catch(Exception e){
            System.out.println("ID no compatible");
        }
    }
    //Prestar ítem**************************************************************************************************
    public void prestarItem() {
        Scanner ScanID=new Scanner(System.in);
        System.out.println("Introduce el ID del artículo para prestar");
        try{
            int id=ScanID.nextInt();
            //int id=Integer.parseInt(texto);
            boolean encontrado=false;
            for(int i=0; i<=this.catalogo.size();i++){
                if(this.catalogo.get(i).id==id){
                    this.catalogo.get(i).estadoPrestado=true;
                    encontrado=true;
                    System.out.println("Se ha prestado: "+this.catalogo.get(i).titulo+
                            "\n Días para devolver: "+this.catalogo.get(i).getDiasMaximosPrestamo());
                    break;
                }
            }
            if(encontrado==false){
                System.out.println("No se ha encontrado el ID");
            }

        }catch(Exception e){
            System.out.println("ID no compatible");
        }
    }
    //Devolver item***************************************************************************************************
    public void devolverItem(){
        Scanner ScanID=new Scanner(System.in);
        Scanner ScanTiempo=new Scanner(System.in);
        System.out.println("Introduce el ID del artículo para devolver");
        try{
            int id=ScanID.nextInt();
            //int id=Integer.parseInt(texto);
            boolean encontrado=false;
            for(int i=0; i<=this.catalogo.size();i++){
                if(this.catalogo.get(i).id==id){
                    this.catalogo.get(i).estadoPrestado=false;
                    try {
                        while (encontrado==false){
                            System.out.println("Introduce los días que se tardó en devolver:");
                            int dias=ScanTiempo.nextInt();
                            //int dias=Integer.parseInt(tiempo);
                            if(dias<=this.catalogo.get(i).getDiasMaximosPrestamo()){
                                System.out.println("No hubo retraso");
                            }
                            else{
                                System.out.println("Multa: "+this.catalogo.get(i).calcularMulta(dias)+"€");
                            }
                            encontrado=true;
                        }
                        break;
                    }catch (Exception e){
                        System.out.println("ID no compatible");
                    }
                }
            }
            if(encontrado==false){
                System.out.println("No se ha encontrado el ID");
            }

        }catch(Exception e){
            System.out.println("ID no compatible");
        }
    }

}
