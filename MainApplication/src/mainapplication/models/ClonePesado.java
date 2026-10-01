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
        this.setHp(400);
        this.setHp_ref(400);
    }

    public ClonePesado(Guerreiro G) {
        super(G);
        setHp_ref(400);
        setHp(400);
    }

    @Override 
    public void setHp(int hp){
        super.setHp(hp);
    }

    @Override
    public void alterHp(int alter) {// Função N° 11
        if((this.getHp()-alter) > 1 && DarkSide.getPreference_hit() >= 1)
            BattleSettings.setOrder(1, DarkSide.getPreference_hit());
        else
            if (DarkSide.getPreference_hit() > 0) 
                DarkSide.setPreference_hit(DarkSide.getPreference_hit()-1);
        super.alterHp(alter);
        if(this == BattleSettings.getCurrentLineJediClones().getFirst()) System.out.println("\n\n->> [HABILIDADE] enquanto clone pessado estiver vivo ou a rodada acabar o este clone pessado será atacado!!");
    }
    @Override
    public void attack(ArrayList<Guerreiro> Gs) {// Função N° 13
        int index = 0;
        super.attack(Gs);
        hit(Gs, 1, "Clone Pesado", this.getHit());
        if(BattleSettings.getOrder(1) == 0)
        {
            do{
                index++;
            }while( BattleSettings.getSideJediClones().get(index).size() > 0 && BattleSettings.getSideJediClones().get(index).getFirst().getClass() == ClonePesado.class);
            DarkSide.setPreference_hit(index-1);
        }
    }
    
}
