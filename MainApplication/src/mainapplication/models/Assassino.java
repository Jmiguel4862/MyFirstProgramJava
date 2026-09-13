/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package mainapplication.models;

import java.util.ArrayList;

/**
 *
 * @author João Miguel
 */
public class Assassino extends Guerreiro{
    
    public Assassino(String name, int age, double weight) {
        super(name, age, weight, 30);
    }

    @Override
    public void attack(ArrayList<Guerreiro> Gs) {
        hit(Gs, 1, "Assasino", this.getHit());
    }
}
