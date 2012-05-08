/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package onirim.entity;

/**
 *
 * @author Marco António
 */
public class Labyrinth extends Entity {
        
    private String color;
    private String symbol;

    public Labyrinth(String symbol, String color) {
        super("LABYRINTH");
        this.symbol = symbol;
    }
    
    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }
}
