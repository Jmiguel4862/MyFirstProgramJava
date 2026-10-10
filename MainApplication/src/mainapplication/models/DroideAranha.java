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
public class DroideAranha extends DarkSide{
    
    public DroideAranha(String name, int age, double weight) {
        super(name, age, weight , 10 , "Droide Aranha");
    }

    @Override
    public void attack(Arena arena) {// Função N° 13
        super.attack(arena);
        System.out.println("\n\n->> [HABILIDADE] Droide Aranha usa seu canhão para causar dano a todos os presente na fila adversaria!!");
        ArrayList<Guerreiro> guerreiros = arena.getCurrentLineTeam1();
        for(int i = 0; i < guerreiros.size();i++)
            hit(i , arena);  
    }

}
