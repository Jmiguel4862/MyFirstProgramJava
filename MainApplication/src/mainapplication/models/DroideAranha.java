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
public class DroideAranha extends Guerreiro{
    
    public DroideAranha(String name, int age, double weight) {
        super(name, age, weight , 10);
    }
    
    public DroideAranha(Guerreiro G) {
        super(G);
    }

    @Override
    public void attack(ArrayList<Guerreiro> Gs) {
        for(int i = 1; i <= Gs.size();i++)
          hit(Gs,i, "Droide Aranha", this.getHit());  
    }

}
