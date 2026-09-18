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
public class Assassino extends DarkSide{
    
    public Assassino(String name, int age, double weight) {
        super(name, age, weight, 20);
    }

    @Override
    public void attack(ArrayList<Guerreiro> Gs) {
        super.attack(Gs);
        System.out.println("\n\n->> Este assasino enveneno o guerreiro atacado agora a cada ataque deste guereiro ele perdera 5 pontos ");
        hit(Gs, 1, "Assasino", this.getHit());
    }   
}
