import javax.swing.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Jarras_Agua {
    public static void main(String[] args) {
        int x = 0;
        int y = 0;
        int cont = 0;
        int r;
        while (x != 2){
            //Integer.parseInt(JOptionPane.showInputDialog("ingrese una regla"))
            r = reglas_aplicables(x,y);
            switch (r){
                case 1:
                    x = 4;
                    break;
                case 2:
                    y = 3;
                    break;
                case 3:
                    x = 0;
                    break;
                case 4:
                    y = 0;
                    break;
                case 5:
                    x = x-(3-y);
                    y = 3;
                    break;
                case 6:
                    y = y - (4 - x);
                    x = 4;
                    break;
                case 7:
                    x = 0;
                    y = x + y;
                    break;
                case 8:
                    x = x + y;
                    y = 0;
                    break;
            }
            cont++;
            System.out.println("(" + x + " , " + y + ")" + "  Iteracion: "+cont +" Regla: " + r );
        }
    }

    public static int reglas_aplicables(int x, int y){
        Random rm = new Random();
        List<Integer> listaEnteros = new ArrayList<>();
        if(x < 4)
            listaEnteros.add(1);
        if(y < 3)
            listaEnteros.add(2);
        if(x > 0)
            listaEnteros.add(3);
        if(y > 0)
            listaEnteros.add(4);
        if(x > 0 && y < 3 && x + y >= 3)
            listaEnteros.add(5);
        if(x < 4 && y > 0 && x + y >= 4)
            listaEnteros.add(6);
        if(x > 0 && y < 3 && x + y <= 3)
            listaEnteros.add(7);
        if(x < 4 && y > 0 && x + y <= 4)
            listaEnteros.add(8);
        return listaEnteros.get(rm.nextInt(listaEnteros.size()));
    }
}
