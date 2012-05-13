
import java.util.Scanner;
import onirim.Onirim;

/*
 * To change this template, choose Tools | Templates and open the template in
 * the editor.
 */
/**
 *
 * @author Marco António
 */
public class Main {

    private static Scanner sc = new Scanner(System.in);
    private static String aux;

    public static void main(String[] args) {
        Onirim onirim = new Onirim();
        boolean confirm;
        onirim.buyHand();

        do {
            do {
                confirm=false;
                System.out.println(onirim.getLabyrinthStack().toString() + "\n");
                System.out.println(onirim.getHand().toString());
                System.out.println(" \nYou Want: \n [1] Play \n [2] Discard");
                aux = sc.nextLine();

                if (aux.equalsIgnoreCase("1")) {
                    onirim.play();
                    confirm=true;
                } else if (aux.equalsIgnoreCase("2")) {
                    onirim.discard();
                    confirm=true;
                } else {
                    System.out.println("Opcao Errada");
                }
            } while (confirm == false);
            
              onirim.draw();
              
              onirim.shuffle();
              
        } while (onirim.getState().equals(onirim.getPlayState()));
    }
    
    //funcões extra para teste
    //ver as proximas 7 cartas do deck
    
    
    // acrescentar uma carta ao deck
    
    // acrescentar uma carta à mão
    
    // acrecentar uma carta à pilha de labirintos
    
    // acrescentar uma carta à pilha das portas
    
}
