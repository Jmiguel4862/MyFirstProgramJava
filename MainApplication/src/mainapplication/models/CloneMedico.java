/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package mainapplication.models;

import java.util.ArrayList;

/**
 *
 * @author João Miguel
 */
public class CloneMedico extends LightSide{
    
    public CloneMedico(String name, int age, double weight) {
        super(name, age, weight , 20 , "Clone Médico");
    }

    @Override
    public void attack(Arena arena) {// Função N° 13
        super.attack(arena);
        ArrayList <Guerreiro> guerreiros = arena.getCurrentLineTeam1();
        hit(0 , arena);
        if(guerreiros.size() > 1 && guerreiros.get(1).getHp() < guerreiros.get(1).getHp_ref())
        {
            System.out.println("\n->> [HABILIDADE] Clone Medico recuperou 20 pontos de vida do guerreiro " + guerreiros.get(1).getClass().getSimpleName() +guerreiros.get(1).getName() +" logo atrás dele!!" );
            guerreiros.get(1).alterHp(20 , arena);
        }
    }
    
}
