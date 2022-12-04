package metier;

import java.util.Scanner;

public interface InteractiveConsole {

    Scanner clavier = new Scanner(System.in);

    default void fermerClavier(){

            clavier.close();

    }


}
