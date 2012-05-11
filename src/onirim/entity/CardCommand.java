/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package onirim.entity;

/**
 *
 * @author Bino
 */
public class CardCommand {

    private String command;
    private String type;
    private String color;
    private String symbol;
    
    public CardCommand() {
        command=null;
        type=null;
        color=null;
        symbol=null;
    }

    public CardCommand(String command, String type, String color, String symbol) {
        this.command = command;
        this.type = type;
        this.color = color;
        this.symbol = symbol;
    }

    public String getColor() {
        return color;
    }

    public String getCommand() {
        return command;
    }

    public String getSymbol() {
        return symbol;
    }

    public String getType() {
        return type;
    }
    
    
    
    
    
    
    
    
    
}
