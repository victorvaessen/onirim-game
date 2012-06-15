/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package onirim.entity;

/**
 *
 * @author Bino
 */
public class Tower extends Card{
    
    private String color;
    private String symbolRight;
    private String symbolLeft;
    private Integer number;
    

    public Tower(String command, String color, String symbolRight, String symbolLeft, Integer number) {
        super("TOWER", command);
        this.color=color;
        this.symbolRight=symbolRight;
        this.symbolLeft=symbolLeft;
        this.number=number;
    }

    public String getColor() {
        return color;
    }

    public Integer getNumber() {
        return number;
    }

    public String getSymbolLeft() {
        return symbolLeft;
    }

    public String getSymbolRight() {
        return symbolRight;
    }

    @Override
    public String toString() {
        return "TOWER\t" + color + "\t" + symbolRight + "\t" + symbolLeft + "\t" + number + "\t" + this.getCommand();
    }

    
    
    
    
}
