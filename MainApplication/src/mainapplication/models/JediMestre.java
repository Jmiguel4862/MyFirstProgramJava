/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package mainapplication.models;

/**
 *
 * @author João Miguel
 */
public class JediMestre extends LightSide{
    private boolean ability = false;
    public JediMestre(String name, int age, double weight) {
        super(name, age, weight , 35 , "Jedi Mestre");
    }

    @Override
    public void attack(Arena arena) {// Função N° 13
        super.attack(arena);
        hit(0 , arena);
        if(arena.getFirstAttack()) ability = true;
    }

    @Override
    public void alterHp(int alter  , Arena arena) {// Função N° 11
        if(ability)
        {
            System.out.println("\n\n->> [HABILIDADE] Devido a habilidade do Jedi Mestre por ser o primeiro a atacar ele empurara o adversario para o final da fila e anulara seu ataque.");
            ability = false;
        }
        else
            super.alterHp(alter , arena);
    }
    
}
