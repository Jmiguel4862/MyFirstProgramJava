/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package mainapplication.models;

import java.util.ArrayList;
import mainapplication.controllers.*;

/**
 *
 * @author João Miguel
 */
public class ClonePesado extends LightSide{
    
    public ClonePesado(String name, int age, double weight) {
        super(name, age, (weight + 300), 30, "Clone Pesado");
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
        if((this.getHp()-alter) > 1 && DarkSide.getPreference_hit() >= 0)
            if(this == BattleSettings.getCurrentLineJediClones().getFirst()) System.out.println("\n\n->> [HABILIDADE] enquanto clone pessado estiver vivo ou a rodada acabar o este clone pessado será atacado!!");
        else
            if (DarkSide.getPreference_hit() >= 0) 
                DarkSide.setPreference_hit(DarkSide.getPreference_hit()-1);
        super.alterHp(alter);
    }
    @Override
    public void attack() {// Função N° 13
        int index;
        ArrayList<Guerreiro> temp;
        super.attack();
        hit(0);
        if(BattleSettings.getFirstAttack())
        {
            index = BattleSettings.getOrder(1) + 1;
            do{
                if(index > (Constants.MAX_FILES-1)) break;
                temp = BattleSettings.getSideJediClones().get(index);
                index++;
            }while(temp.size() > 0 && temp.getFirst().getClass() == ClonePesado.class);
            DarkSide.setPreference_hit(index-1);
        }
    }
    
}
