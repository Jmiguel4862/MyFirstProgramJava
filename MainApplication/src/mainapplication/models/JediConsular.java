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
public class JediConsular extends LightSide{
    
    public JediConsular(String name, int age, double weight) {
        super(name, age, weight , 30 , "Jedi Consular");
    }
    
    @Override
    public void attack(Arena arena) {// Função N° 13
        ArrayList<Guerreiro> guerreirosRight= null;
        ArrayList<Guerreiro> guerreirosLeft= null;
        int orderSith = arena.getOrder(2);
        super.attack(arena);
        hit(0 , arena );
        this.setHit(this.getHit()/2);
        if ((orderSith + 1 ) < Constants.MAX_FILES) 
        {
            guerreirosRight = arena.getTeam2().get(orderSith+1);
            if (guerreirosRight.size() > 0)
            {
                System.out.println("\n\n->> [HABILIDADE] JIDE CONSULAR(ATACA INIMICO A DIREITA)!!");
                hit( 0 , arena);
            }    
        }
        if((orderSith - 1) > -1)
        {
            guerreirosLeft =  arena.getTeam2().get(orderSith - 1);
            if (guerreirosLeft.size() > 0)
            {
                System.out.println("\n\n->> [HABILIDADE] JIDE CONSULAR(ATACA INIMICO A ESQUERDA)!!");
                hit( 0 , arena);
            }    
        }
        this.setHit(this.getHit()*2);
    }
}
