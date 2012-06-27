/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package onirim.entity;

/**
 *
 * @author Bino
 */
public class CardsFactory implements ICardsFactory {

    @Override
    public Card criaCard(String type, String command) {
        if(type.equalsIgnoreCase("NIGHTMARE"))
        {
            return new NightMare();
        }
        else{
            return null;
        }
    }

    @Override
    public Card criaCard(String type, String command, String color) {
         if(type.equalsIgnoreCase("DOOR"))
        {
            return new Door(command, color);
        }
        else{
            return null;
        }
    }

    @Override
    public Card criaCard(String type, String command, String color, String symbol) {
         if(type.equalsIgnoreCase("LABYRINTH"))
        {
            return new Labyrinth(symbol, command, color);
        }
        else{
            return null;
        }
    }

    @Override
    public Card criaCard(String type, String command, String color, String symbolRight, String symbolLeft, Integer number) {
         if(type.equalsIgnoreCase("TOWER"))
        {
            return new Tower(command, color, symbolRight, symbolLeft, number);
        }
        else{
            return null;
        }
    }
    
    
}
