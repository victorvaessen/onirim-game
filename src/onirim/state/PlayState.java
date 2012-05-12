/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package onirim.state;

import java.util.Scanner;
import onirim.Onirim;
import onirim.entity.Card;
import onirim.entity.Door;
import onirim.entity.Labyrinth;

/**
 *
 * @author Marco António
 */
public class PlayState implements State{

    private Onirim onirim;
    Scanner sc = new Scanner(System.in);
    private String aux;

    public PlayState(Onirim onirim) {
        this.onirim = onirim;
    }
    
    @Override
    public void buyHand() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public void play() {
        
        boolean jogadaValida=false;
        int i,count=0;
        Card cardFound;
        
        do{
            
            System.out.println(onirim.getHand().toString());
        
            System.out.println("Choose a card to play: ");
       
            aux=sc.nextLine();

            //Correct Command
            for(i=0; i<onirim.getCardCorresponding().getListCard().size();i++){
                if(aux.compareTo(onirim.getCardCorresponding().getListCard().get(i).getCommand())==0){
                    break;
                }                    
            }
            
            //Card its in the Hand?
            if(onirim.getHand().show().contains(
            new Labyrinth(onirim.getCardCorresponding().getListCard().get(i).getSymbol(),onirim.getCardCorresponding().getListCard().get(i).getColor()))){
                //Type of the Card
                if(onirim.getCardCorresponding().getListCard().get(i).getType().compareTo("LABYRINTH")==0){    
                    //Symbol is equal to the last of the labyrinth stack
                    if(((Labyrinth)onirim.getLabyrinthStack().showLastCard()).getSymbol().equals(onirim.getCardCorresponding().getListCard().get(i).getSymbol())){
                        System.out.println("Não pode jogar tem o mesmo simbolo do anterior");
                    }
                    else{
                        onirim.getLabyrinthStack().addCard(onirim.getHand().discard(onirim.getHand().show().indexOf(new Labyrinth(onirim.getCardCorresponding().getListCard().get(i).getSymbol(),onirim.getCardCorresponding().getListCard().get(i).getColor()))));
                    }
                    
                    // verify sequence of last 3 cards
                    for(int j=1;j<onirim.getLabyrinthStack().showSequence().size();j++)
                    {
                        if(((Labyrinth)onirim.getLabyrinthStack().showSequence().get(j)).getColor().
                        equals(((Labyrinth)onirim.getLabyrinthStack().showSequence().get(0)).getColor())){
                            count++;
                        }
                    }
                    //Case 3 card same color get the door corresponding
                    if(count==2){
                        cardFound=onirim.getDeck().searchCard(new Door(((Labyrinth)onirim.getLabyrinthStack().showSequence().get(0)).getColor()));
                            if(cardFound!=null){
                                onirim.getDoorStack().addCard(cardFound);
                            }   
                    }
                    
                    onirim.getDeck().shuffle();
                    
                    //Case 8 door end of the game
                    //if(onirim.getDoorStack().VerifyAllDoorsCollected())
                        //end of the game
                   
                }
            }                     
        }while(jogadaValida==false);
        
        //Buy Fase
        onirim.setState(onirim.getBuyState());
        
}
        

    @Override
    public void discard() {
        
        System.out.println(onirim.getHand().toString());
    }

    @Override
    public void draw() {
        throw new UnsupportedOperationException("Not supported yet.");
    }
    
}
