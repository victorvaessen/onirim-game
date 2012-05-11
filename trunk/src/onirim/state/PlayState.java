/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package onirim.state;

import java.util.Scanner;
import onirim.Onirim;
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
        int i;
        
        System.out.println(onirim.getHand().toString());
        
        System.out.println("Choose a card to play: ");
       
        do{
            aux=sc.nextLine();

            //Correct Command
            for(i=0; i<onirim.getCardCorresponding().getListCard().size();i++){
                if(aux.compareTo(onirim.getCardCorresponding().getListCard().get(i).getCommand())==0){
                    break;
                }
                else
                    i++;
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
                    
                    
                   
                }
            }                     
        }while(jogadaValida==false);
        
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
