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
        ArrayList <Guerreiro> gs = arena.getCurrentLineTeam1();
        hit(0 , arena);
        if(gs.size() > 1 && gs.get(1).getHp() < gs.get(1).getHp_ref())
        {
            System.out.println("\n->> [HABILIDADE] Clone Medico recuperou 20 pontos de vida do guerreiro " + gs.get(1).getClass().getSimpleName() +gs.get(1).getName() +" logo atrás dele!!" );
            gs.get(1).alterHp(20 , arena);
        }
    }
    
}
