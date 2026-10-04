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
    public JediConsular(Guerreiro G) {
        super(G);
    }
    @Override
    public void attack() {// Função N° 13
        ArrayList<Guerreiro> gsRight= null;
        ArrayList<Guerreiro> gsLeft= null;
        int orderSith = (BattleSettings.getOrder(2));
        super.attack();
        hit(0 );
        this.setHit(this.getHit()/2);
        if ((orderSith + 1 ) < Constants.MAX_FILES) 
        {
            gsRight = BattleSettings.getSideSithDroides().get(orderSith+1);
            if (gsRight.size() > 0)
            {
                System.out.println("\n\n->> [HABILIDADE] JIDE CONSULAR(ATACA INIMICO A DIREITA)!!");
                hit( 0);
            }    
        }
        if((orderSith - 1) > -1)
        {
            gsLeft = BattleSettings.getSideSithDroides().get(orderSith - 1);
            if (gsLeft.size() > 0)
            {
                System.out.println("\n\n->> [HABILIDADE] JIDE CONSULAR(ATACA INIMICO A ESQUERDA)!!");
                hit( 0);
            }    
        }
        this.setHit(this.getHit()*2);
    }
}
