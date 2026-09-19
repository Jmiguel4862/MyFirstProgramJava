/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package mainapplication.models;

import java.util.ArrayList;
import mainapplication.controllers.BattleSettings;

/**
 *
 * @author João Miguel
 */
public class DroideBatalhaB2 extends DarkSide{
    public DroideBatalhaB2(String name, int age, double weight) {
        super(name, age, weight , 10);
    }
    
    public DroideBatalhaB2(Guerreiro G) {
        super(G);
    }

    @Override
    public void attack(ArrayList<Guerreiro> Gs) {
        super.attack(Gs);
        hit(Gs, 1, "Droide de Batalha B2", this.getHit());
    }   

    @Override
    public void alterHp(int alter) {
        ArrayList <Guerreiro> sd =null;
        Guerreiro newb2 = null;
        super.alterHp(alter); 
        if (this.getHp() == 0 && this.getHp_ref() > 1) {
            System.out.println("\n\n->> [HABILIDADE] O Droide B2 se morreu e renaceu em dois novos Droides B2 cada um com " +  (this.getHp_ref()/2));
            sd = BattleSettings.getSideSithDroides();
            for (int i = 1; i <= 2; i++) {
                newb2 = new DroideBatalhaB2(this);
                newb2.defineHp(this.getHp_ref()/2);
                newb2.setName(this.getName()+"."+i);
                sd.add(newb2);
                newb2 = null;
            }
        }
    }
}
