/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package onirim.entity;

/**
 *
 * @author Marco António
 */
public class Door extends Entity {
    
    private String color;
    
    public Door(String color) {
        super("DOOR");
    }
 
    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }
}
