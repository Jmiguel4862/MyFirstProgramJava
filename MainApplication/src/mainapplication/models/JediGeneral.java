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
public class JediGeneral extends LightSide{
    
    public JediGeneral(String name, int age, double weight) {
        super(name, age, weight , 50);
    }
    public JediGeneral(Guerreiro G) {
        super(G);
    }
    @Override
    public void attack(ArrayList<Guerreiro> Gs) {
        super.attack(Gs);
        hit(Gs,1, "Jide General", this.getHit());
        if (Gs.getFirst().getHp() == 0) {
            this.alterHp(50);
            this.setHit(this.getHit() + 5);
            System.out.println("\n\n->> [HABILIDADE] Jide General matou o inimigo, conseguindo se aproximar mais do equilibriu da força, ganhou 5 pontos a mais de ataque e recuperou 50 pontos de vita");
        }
    }
    
}
