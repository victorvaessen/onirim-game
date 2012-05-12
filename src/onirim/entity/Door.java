/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package onirim.entity;

/**
 *
 * @author Marco António
 */
public class Door extends Card {
    
    private String color;
    
    public Door(String command, String color) {
        super("DOOR", command);
        this.color = color;
        this.color=color;
    }
 
    public String getColor() {
        return color;
    }

    @Override
    public String toString() {
        return "DOOR " + color;
    }
    
}
