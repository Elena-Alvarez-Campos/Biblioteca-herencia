import javax.swing.*;
import java.util.ArrayList;
import javax.swing.JOptionPane;
//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        //Catálogo
        GestorMediateca catalogo1 = new GestorMediateca();

        //Menú

        boolean programa=true;
        int opcion=0;
        while(programa==true){
            String menu= JOptionPane.showInputDialog("     Menú     \n" +
                    "********************\n" +
                    "Opciones:\n" +
                    "1.Mostrar Catálogo\n" +
                    "2.Añadir nuevo ítem\n" +
                    "3.Modificar título\n" +
                    "4.Prestar ítem\n" +
                    "5.Devolver ítem\n" +
                    "6.Salir");
            try{
                opcion=Integer.parseInt(menu);
                switch(opcion){
                    case 1:

                        break;
                    case 2:
                        break;
                    case 3:
                        break;
                    case 4:
                        break;
                    case 5:
                        break;
                    case 6:
                        programa=false;
                        break;
                    default:
                        JOptionPane.showMessageDialog(null,"Elige una opción compatible");
                        break;
                }
            }catch (Exception e){
                JOptionPane.showMessageDialog(null,"Elige una opción compatible");
            }

        }

    }
}