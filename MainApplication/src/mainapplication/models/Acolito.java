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
public class Acolito extends DarkSide{
    
    public Acolito(String name, int age, double weight) {
        super(name, age, weight , 15);
    }

    @Override
    public void attack(ArrayList<Guerreiro> Gs) {
        super.attack(Gs);
        hit(Gs, 1, "Acolito", this.getHit());
        hit(Gs, Gs.size(), "Acolito", this.getHit());
    }
}
