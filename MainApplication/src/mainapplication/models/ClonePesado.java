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
public class ClonePesado extends LightSide{
    
    public ClonePesado(String name, int age, double weight) {
        super(name, age, weight , 30);
        defineHp(400);
    }

    public ClonePesado(Guerreiro G) {
        super(G);
        defineHp(400);
    }

    @Override
    public void alterHp(int alter) {
        super.alterHp(alter);
        System.out.println("\n\n->> [HABILIDADE] enquanto clone pessado estiver vivo ou a rodada acabar o este clone pessado será atacado!!");
        if(BattleSettings.getOrder(1) == 1)
            DarkSide.setPreference_hit(true);
        else
            DarkSide.setPreference_hit(false);
    }
    @Override
    public void attack(ArrayList<Guerreiro> Gs) {
        super.attack(Gs);
        hit(Gs, 1, "Clone Pesado", this.getHit());
    }

    
    
}
