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

    @Override 
    public void setHp(int hp){
        super.setHp(hp);
    }

    @Override
    public void alterHp(int alter , Arena arena) {// Função N° 11
        if((this.getHp() + alter) > 0 && arena.getPreferenceOrder() >= 0)
        {
            if(this == arena.getCurrentLineTeam1().getFirst()) System.out.println("\n\n->> [HABILIDADE] enquanto clone pessado estiver vivo ou a rodada acabar o este clone pessado será atacado!!");
        }
        else
        {
            if (arena.getPreferenceOrder() >= 0)
                arena.setPreferenceOrder(arena.getPreferenceOrder()-1);
        }
        super.alterHp(alter , arena);
    }
    @Override
    public void attack(Arena arena) {// Função N° 13
        int index;
        ArrayList<Guerreiro> temp;
        super.attack(arena);
        hit(0 , arena);
        if(arena.getFirstAttack())
        {
            index = arena.getOrder(1);
            do{
                index++;
                if(index >= Constants.MAX_FILES) break;
                temp = arena.getTeam1().get(index);
            }while(temp.size() > 0 && temp.getFirst().getClass() == ClonePesado.class);
            arena.setPreferenceOrder(index-1);
        }
    }
    
}
