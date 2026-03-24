import javax.swing.*;
import java.util.ArrayList;
import java.util.Scanner;
import javax.swing.JOptionPane;
//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        //Catálogo
        ArrayList<ItemBiblioteca> catalogo=new ArrayList<ItemBiblioteca>();
        Revista item1=new Revista(1,"Hola",false,562);
        DVD item2=new DVD(2,"Buscando a nemo",false,"Alguien");
        Libro item3=new Libro(3,"Invisible",false,"Pepe");
        catalogo.add(item1);
        catalogo.add(item2);
        catalogo.add(item3);
        GestorMediateca gestor = new GestorMediateca(catalogo);

        //Menú

        boolean programa=true;
        int opcion=0;
        Scanner ScanPrograma = new Scanner(System.in);
        while(programa==true){
             System.out.println("     Menú     \n" +
                    "********************\n" +
                    "Opciones:\n" +
                    "1.Mostrar Catálogo\n" +
                    "2.Añadir nuevo ítem\n" +
                    "3.Modificar título\n" +
                    "4.Prestar ítem\n" +
                    "5.Devolver ítem\n" +
                    "6.Salir");
            try{
                opcion=ScanPrograma.nextInt();
                //opcion=Integer.parseInt(menu);
                switch(opcion){
                    case 1:
                        System.out.println(gestor);
                        break;
                    case 2:
                        gestor.nuevoProducto();
                        break;
                    case 3:
                        gestor.cambiaTitulo();
                        break;
                    case 4:
                        gestor.prestarItem();
                        break;
                    case 5:
                        gestor.devolverItem();
                        break;
                    case 6:
                        programa=false;
                        break;
                    default:
                        System.out.println("Elige una opción compatible");
                        break;
                }
            }catch (Exception e){
                System.out.println("Elige una opción compatible");
            }

        }

    }
}