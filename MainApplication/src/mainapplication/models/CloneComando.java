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
public class CloneComando extends Guerreiro{
    
    public CloneComando(String name, int age, double weight) {
        super(name, age, weight , 40);
    }

    @Override
    public void attack(ArrayList<Guerreiro> Gs) {
        int equals =0;
       ArrayList<Guerreiro> jc = FileOfLine.reader_Guerreiros(1, BattleSettings.getOrder(1));
       if (jc.size() > 1)
        {
            for (int i = 0; i < jc.size(); i++) 
                if(jc.get(i).getClass() == this.getClass())
                    equals++;
            if (equals > 1)System.out.println("\n\n->> O Clone Comando atual encontro "+equals+" semelhantes seus na fila para ajuda no ataque e vai dar "+(equals*8)+" a mais de dano neste ataque");
        }
        hit(Gs, 1, "Clone Comando", (this.getHit()) + (equals*8));
    }

}
