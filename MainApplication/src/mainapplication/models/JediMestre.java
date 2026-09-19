/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package mainapplication.models;
import mainapplication.controllers.BattleSettings;
import java.util.ArrayList;

/**
 *
 * @author João Miguel
 */
public class JediMestre extends LightSide{
    public JediMestre(String name, int age, double weight) {
        super(name, age, weight , 35);
    }
    public JediMestre(Guerreiro G) {
        super(G);
    }

    @Override
    public void attack(ArrayList<Guerreiro> Gs) {
        super.attack(Gs);
        hit(Gs, 1, "Jedi Mestre" , this.getHit());
    }

    @Override
    public void alterHp(int alter) {
        if(BattleSettings.getOrder(1) == 1)
            System.out.println("\n\n->> [HABILIDADE] Devido a habilidade do Jedi Mestre por ser o primeiro a atacar ele empurara o adversario para o final da fila e anulara seu ataque.");
        else
            super.alterHp(alter);
    }
    
}
