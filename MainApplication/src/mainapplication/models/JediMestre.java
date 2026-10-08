/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package mainapplication.models;
import mainapplication.controllers.BattleArena;

/**
 *
 * @author João Miguel
 */
public class JediMestre extends LightSide{
    public JediMestre(String name, int age, double weight) {
        super(name, age, weight , 35 , "Jedi Mestre");
    }
    public JediMestre(Guerreiro G) {
        super(G);
    }

    @Override
    public void attack() {// Função N° 13
        super.attack();
        hit(0);
    }

    @Override
    public void alterHp(int alter) {// Função N° 11
        if(BattleArena.getFirstAttack() && this == BattleArena.getSideJediClones().get(BattleArena.getOrder(1)).getFirst())
            System.out.println("\n\n->> [HABILIDADE] Devido a habilidade do Jedi Mestre por ser o primeiro a atacar ele empurara o adversario para o final da fila e anulara seu ataque.");
        else
            super.alterHp(alter);
    }
    
}
