/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package onirim.entity;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Bino
 */
public class TowerStack {

    List<Card> cards;
    List<Tower> sequenceCards;
    boolean block;

    public TowerStack() {
        cards = new ArrayList<Card>();
        sequenceCards = new ArrayList<Tower>();
        block = false;
    }

    public boolean isBlock() {
        return block;
    }

    
    public Card showRightCard() {
        if (cards.size() > 0) {
            return cards.get(cards.size() - 1);
        } else {
            return null;
        }
    }

    public Card showLeftCard() {
        if (cards.size() > 0) {
            return cards.get(0);
        } else {
            return null;
        }
    }

    public List<Card> ShowAll() {
        return cards;
    }

    public boolean addCardRight(Card card) {
        cards.add(card);
        return this.verifySequence();
    }

    public boolean addCardLeft(Card card) {
        cards.add(0, card);
        return this.verifySequence();
    }

    public boolean verifySequence() {
        if (cards.size() >= 4) {
            for (int i = 0; i < cards.size() - 3; i++) {
                sequenceCards.clear();
                sequenceCards.add((Tower) cards.get(i));
                for (int j = i + 1; j < i + 4; j++) {
                    if (!((Tower) cards.get(j)).getColor().equalsIgnoreCase(sequenceCards.get(i).getColor())) {
                        sequenceCards.add((Tower) cards.get(j));
                    }
                }
                if (sequenceCards.size() == 4) {
                    block = true;
                    return true;
                }
            }
        }
        return false;
    }

    public Card removeCard(int index) {
        Card auxCard;
        auxCard=cards.remove(index);
        this.verifySequence();
        return auxCard;
    }
    
    public Card showLeftCard(int index){
        if(index<cards.size() && index>0)
            return cards.get(index-1);
        else
            return null;
    }
    
    public Card showRightCard(int index){
        if(index<cards.size()-1)
            return cards.get(index+1);
        else
            return null;
    }
}
//    public boolean addCard(Tower card) {
//        int k;
//        String choose = "";
//        List<Tower> auxseq = new ArrayList<Tower>();
//
//        if (cards.isEmpty()) {
//            this.addCardRight(card);
//            this.addCardLeft(card);
//            cards.add(card);
//            return false;
//        } else {
//            if (cards.size() < 4) {
//                //escolhe lado
//                if (choose.equalsIgnoreCase("Right")) {
//                    this.addCardRight(card);
//                    k = 0;
//                    while (!sequenceCardsLeft.get(k).getColor().equalsIgnoreCase(card.getColor())) {//fim da sequencia com cor diferente da que foi inserida
//                        auxseq.add(sequenceCardsLeft.get(k));
//                        k++;
//                    }
//                    sequenceCardsLeft.clear();
//                    sequenceCardsLeft.addAll(auxseq);
//                    sequenceCardsLeft.add(0, card);
//                    cards.add(0, card);
//                    if (sequenceCardsLeft.size() == 4) {
//                        block=true;
//                        return true;
//                    } else {
//                        return false;
//                    }
//
//                } else {
//                    this.addCardLeft(card);
//                    k = sequenceCardsRight.size() - 1;
//                    while (!sequenceCardsRight.get(k).getColor().equalsIgnoreCase(card.getColor())) {//fim da sequencia com cor diferente da que foi inserida
//                        auxseq.add(0, sequenceCardsRight.get(k));
//                        k--;
//                    }
//                    sequenceCardsRight.clear();
//                    sequenceCardsRight.addAll(auxseq);
//                    sequenceCardsRight.add(card);
//                    cards.add(card);
//                    if (sequenceCardsRight.size() == 4) {
//                        block=true;
//                        return true;
//                    } else {
//                        return false;
//                    }
//                }
//
//            } else {
//                //tamanho maior que 4
//                if (choose.equalsIgnoreCase("Right")) {
//                    return this.addCardRight(card);
//                } else {
//                    return this.addCardLeft(card);
//                }
//            }
//        }
//    }
//
//    public boolean addCardRight(Tower card) {
//        int diferentes = 0, k;
//        List<Tower> auxseq = new ArrayList<Tower>();
//
//        if (sequenceCardsRight.size() > 0) {
//            for (int i = 0; i < sequenceCardsRight.size(); i++) {
//                if (sequenceCardsRight.get(i).getColor().equalsIgnoreCase(card.getColor())) {
//                    diferentes++;//conta quantas diferentes
//                }
//            }
//            if (diferentes < sequenceCardsRight.size()) {//sequencia quebrada
//                k = sequenceCardsRight.size() - 1;
//                while (!sequenceCardsRight.get(k).getColor().equalsIgnoreCase(card.getColor())) {//fim da sequencia com cor diferente da que foi inserida
//                    auxseq.add(0, sequenceCardsRight.get(k));
//                    k--;
//                }
//                sequenceCardsRight.clear();
//                sequenceCardsRight.addAll(auxseq);
//                sequenceCardsRight.add(card);
//                cards.add(card);
//                return false;
//            } else { //sequencia certa
//                sequenceCardsRight.add(card);
//                cards.add(card);
//            }
//            if (sequenceCardsRight.size() == 4) {//quatro cartas diferentes cores
//                block=true;
//                return true;
//            }
//        } else//esta vazia
//        {
//            sequenceCardsRight.add(card);
//            cards.add(card);
//
//        }
//        return false;
//
//    }
//
//    public boolean addCardLeft(Tower card) {
//        int diferentes = 0, k;
//        List<Tower> auxseq = new ArrayList<Tower>();
//
//        if (sequenceCardsLeft.size() > 0) {
//            for (int i = 0; i < sequenceCardsLeft.size(); i++) {
//                if (sequenceCardsLeft.get(i).getColor().equalsIgnoreCase(card.getColor())) {
//                    diferentes++;//conta quantas diferentes
//                }
//            }
//            if (diferentes < sequenceCardsLeft.size()) {//sequencia quebrada
//                k = 0;
//                while (!sequenceCardsLeft.get(k).getColor().equalsIgnoreCase(card.getColor())) {//fim da sequencia com cor diferente da que foi inserida
//                    auxseq.add(sequenceCardsLeft.get(k));
//                    k++;
//                }
//                sequenceCardsLeft.clear();
//                sequenceCardsLeft.addAll(auxseq);
//                sequenceCardsLeft.add(0, card);
//                cards.add(0, card);
//                return false;
//            } else { //sequencia certa
//                sequenceCardsLeft.add(0, card);
//                cards.add(0, card);
//
//            }
//            if (sequenceCardsLeft.size() == 4) {//quatro cartas diferentes cores
//                block=true;
//                return true;
//            }
//        } else//esta vazia
//        {
//            sequenceCardsLeft.add(0, card);
//            cards.add(0, card);
//        }
//        return false;
//
//    }

