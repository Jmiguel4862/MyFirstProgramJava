/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package mainapplication.models;

import java.util.ArrayList;
import mainapplication.repositorys.querys.FileOfLine;
import mainapplication.controllers.BattleSettings;

/**
 *
 * @author João Miguel
 */
public class JediConsular extends LightSide{
    
    public JediConsular(String name, int age, double weight) {
        super(name, age, weight , 30);
    }
    public JediConsular(Guerreiro G) {
        super(G);
    }
    @Override
    public void attack(ArrayList<Guerreiro> Gs) {
        super.attack(Gs);
        ArrayList<Guerreiro> gsNext = null;
        ArrayList<Guerreiro> gsPrev = null;
        hit(Gs , 1 , "Jedi Consular" , this.getHit());
        if ((BattleSettings.getOrder(2)+ 1 ) <= 4)
        {
            gsNext = FileOfLine.reader_Guerreiros(2, BattleSettings.getOrder(2) + 1 );
            System.out.println("\n->> HABILIDADO DO JIDE CONSULAR(ATACA INIMICO A DIREITA)");
            if (gsNext != null)
                hit(gsNext , 1 , "Jedi Consular" , (this.getHit()/2));
            FileOfLine.write_Guerreiros(gsNext, 2, BattleSettings.getOrder(2)+1);
        }
        if(BattleSettings.getOrder(2) - 1 >= 1){
            gsPrev = FileOfLine.reader_Guerreiros(2, BattleSettings.getOrder(2) - 1 );
            System.out.println("\n->> HABILIDADO DO JIDE CONSULAR(ATACA INIMICO A ESQUERDA)");
            if (gsPrev != null)      
                hit(gsPrev , 1 , "Jedi Consular" , (this.getHit()/2));
            FileOfLine.write_Guerreiros(gsPrev, 2, BattleSettings.getOrder(2)-1);
        }
    }
}
