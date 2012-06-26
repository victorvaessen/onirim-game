
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import onirim.Onirim;
import onirim.OnirimExpansion;
import onirim.entity.Card;
import onirim.entity.Door;
import onirim.entity.Labyrinth;
import onirim.entity.NightMare;

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
        boolean confirm;
        Onirim onirim;
        
        do{
            System.out.println("Pretende Jogar:\n 1 - Básico\n 2-Expansao\n");
            aux= sc.nextLine();
            
        }while(!aux.equals("1")&&!aux.equals("2"));
        
        if(aux.equals("1")){
            onirim = new Onirim();
        }   
        else{
            onirim = new OnirimExpansion();
        }
        
        onirim.buyHand();

        do {
            do {
                confirm=false;
                
                System.out.println(onirim.getLimbo().toString() + "\n");
                System.out.println(onirim.getDiscardStack().toString() + "\n");
                System.out.println(onirim.getDoorStack().toString() + "\n");
                System.out.println(onirim.getLabyrinthStack().toString() + "\n");
                System.out.println(onirim.getHand().toString());
                System.out.println(" \nYou want: \n [1] Play \n [2] Discard \n [3] Show extra cards"
                        + "\n [4] Add deck card \n [5] Add card hand \n [6] Add labyrinth card \n [7] Add door card");
                aux = sc.nextLine();

                if (aux.equalsIgnoreCase("1")) {
                    onirim.play();
                    confirm=true;
                } else if (aux.equalsIgnoreCase("2")) {
                    onirim.discard();
                    confirm=true;
                } else if (aux.equalsIgnoreCase("3")) {
                    ShowExtraCardsDeck(onirim);
                    confirm=true;
                } else if (aux.equalsIgnoreCase("4")) {
                    addCardDeck(onirim);
                    confirm=true;
                } else if (aux.equalsIgnoreCase("5")) {
                    addCardHand(onirim);
                    confirm=true;
                } else if (aux.equalsIgnoreCase("6")) {
                    addCardLabyrinthStack(onirim);
                    confirm=true;
                } else if (aux.equalsIgnoreCase("7")) {
                    addCardDoorStack(onirim);
                    confirm=true;
                } else {
                    System.out.println("Wrong option!");
                }
            } while (confirm == false);
            
              onirim.draw();
              
              onirim.shuffle();
              
        } while (onirim.getState().equals(onirim.getPlayState()));
    }
    
        //funcões extra para teste
    //ver as proximas 7 cartas do deck
    public static void ShowExtraCardsDeck(Onirim onirim) {
        List<Card> cards = new ArrayList<Card>();
        cards.addAll(onirim.getDeck().ShowExtraCards());
        for (int i = 0; i < cards.size(); i++) {
            System.out.println(cards.get(i).toString());
        }
    }
    //Escolhe a carta

    public static Card getCard() {
        Card card=null;
        boolean confirm = false;
        do {
            System.out.println("Insert the type of the card you want \n (L/D/N)");
            aux = sc.nextLine();

            if (aux.equalsIgnoreCase("N")) {
                card = new NightMare();
            } else if (aux.equalsIgnoreCase("D")) {
                System.out.println("Insert the Color of the  door card you want \n (R/B/G/C)");
                aux = sc.nextLine();

                if (aux.equalsIgnoreCase("R")) {
                    card = new Door("DR", "RED");
                } else if (aux.equalsIgnoreCase("B")) {
                    card = new Door("DB", "BLUE");
                } else if (aux.equalsIgnoreCase("G")) {
                    card = new Door("DG", "GREEN");
                } else if (aux.equalsIgnoreCase("C")) {
                    card = new Door("DC", "BROWN");
                } else {
                    System.out.println("Don't Reconize");
                    confirm = true;
                }

            } else if (aux.equalsIgnoreCase("L")) {
                System.out.println("Insert the Color of the Labyrinth card you want \n (R/B/G/C)");
                aux = sc.nextLine();

                if (aux.equalsIgnoreCase("R")) {
                    System.out.println("Insert the Symbol of the Labyrinth card you want \n (S/M/K)");
                    aux = sc.nextLine();

                    if (aux.equalsIgnoreCase("S")) {
                        card = new Labyrinth("SUN", "LSR", "RED");
                    } else if (aux.equalsIgnoreCase("M")) {
                        card = new Labyrinth("MOON", "LMR", "RED");
                    } else if (aux.equalsIgnoreCase("K")) {
                        card = new Labyrinth("KEY", "LKR", "RED");
                    }else {
                    System.out.println("Don't Reconize");
                    confirm = true;
                }

                } else if (aux.equalsIgnoreCase("B")) {
                    System.out.println("Insert the Symbol of the Labyrinth card you want \n (S/M/K)");
                    aux = sc.nextLine();

                    if (aux.equalsIgnoreCase("S")) {
                        card = new Labyrinth("SUN", "LSB", "BLUE");
                    } else if (aux.equalsIgnoreCase("M")) {
                        card = new Labyrinth("MOON", "LMB", "BLUE");
                    } else if (aux.equalsIgnoreCase("K")) {
                        card = new Labyrinth("KEY", "LKB", "BLUE");
                    }else {
                    System.out.println("Don't Reconize");
                    confirm = true;
                }
                } else if (aux.equalsIgnoreCase("G")) {
                    System.out.println("Insert the Symbol of the Labyrinth card you want \n (S/M/K)");
                    aux = sc.nextLine();

                    if (aux.equalsIgnoreCase("S")) {
                        card = new Labyrinth("SUN", "LSG", "GREEN");
                    } else if (aux.equalsIgnoreCase("M")) {
                        card = new Labyrinth("MOON", "LMG", "GREEN");
                    } else if (aux.equalsIgnoreCase("K")) {
                        card = new Labyrinth("KEY", "LKG", "GREEN");
                    }else {
                    System.out.println("Don't Reconize");
                    confirm = true;
                }
                } else if (aux.equalsIgnoreCase("C")) {
                    System.out.println("Insert the Symbol of the Labyrinth card you want \n (S/M/K)");
                    aux = sc.nextLine();

                    if (aux.equalsIgnoreCase("S")) {
                        card = new Labyrinth("SUN", "LSC", "BROWN");
                    } else if (aux.equalsIgnoreCase("M")) {
                        card = new Labyrinth("MOON", "LMC", "BROWN");
                    } else if (aux.equalsIgnoreCase("K")) {
                        card = new Labyrinth("KEY", "LKC", "BROWN");
                    } else {
                        System.out.println("Don't Reconize");
                        confirm = true;
                    }
                } else {
                    System.out.println("Don't Reconize");
                    confirm = true;
                }

            }else {
                    System.out.println("Don't Reconize");
                    confirm = true;
                }
        } while (confirm);
        
        return card;
    }
    // acrescentar uma carta ao deck
    
    public static void addCardDeck(Onirim onirim)
    {
        Card card;
        card = Main.getCard();
        
        onirim.getDeck().AddBeginCard(card);
    }
    
    // acrescentar uma carta à mão
    
    public static void addCardHand(Onirim onirim)
    {
        Card card;
        card = Main.getCard();
        
        if(card.getType().equalsIgnoreCase("LABYRINTH"))
            onirim.getHand().buyCard(card);
    }
    // acrecentar uma carta à pilha de labirintos
    public static void addCardLabyrinthStack(Onirim onirim)
    {
        Card card;
        card = Main.getCard();
        if(card.getType().equalsIgnoreCase("LABYRINTH"))
            onirim.getLabyrinthStack().addCard((Labyrinth)card);
    }
     
    // acrescentar uma carta à pilha das portas
    public static void addCardDoorStack(Onirim onirim)
    {
        Card card;
        card = Main.getCard();
        if(card.getType().equalsIgnoreCase("DOOR"))
            onirim.getDoorStack().addCard(card);
    }
    
}
