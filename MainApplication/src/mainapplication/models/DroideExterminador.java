/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package mainapplication.models;

import mainapplication.controllers.*;

/**
 *
 * @author João Miguel
 */
public class DroideExterminador extends DarkSide{
    
    public DroideExterminador(String name, int age, double weight) {
        super(name, age, (weight + 200), Constants.MOST_HP, "Droide Exterminador");
        setHp_ref(60);
        setHp(60);
    }
    public DroideExterminador(Guerreiro G) {
        super(G);
        setHp(60);
        setHp(60);
    }
    @Override
    public void attack(Arena arena) {// Função N° 13
        super.attack(arena);
        System.out.println("\n\n->> [HABILIDADE] Guerreiro Droide Exterminador "+ this.getName() + " MATOU o guerreiro " + arena.getCurrentLineTeam1().get(0).getBaseName() +" "+ arena.getCurrentLineTeam1().get(0).getName() + "!!!");   
        hit(0 , arena);
    }
}
