/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package onirim.entity;

/**
 *
 * @author Bino
 */
public interface ICardsFactory {
    
    Card criaCard(String type, String command); // Cria Nightmares
    Card criaCard(String type, String command, String color); // cria porta
    Card criaCard(String type, String command, String color, String symbol);// cria labirinto
    Card criaCard(String type, String command, String color, String symbolRight, String symbolLeft, Integer number);// cria torre
}
