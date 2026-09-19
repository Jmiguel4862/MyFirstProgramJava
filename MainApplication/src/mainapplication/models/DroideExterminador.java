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
public class DroideExterminador extends DarkSide{
    
    public DroideExterminador(String name, int age, double weight) {
        super(name, age, weight , 0);
        this.defineHp(60);
    }
    public DroideExterminador(Guerreiro G) {
        super(G);
        this.defineHp(60);
    }
    @Override
    public void attack(ArrayList<Guerreiro> Gs) {
        super.attack(Gs);
        Gs.getFirst().setHp(0);
        System.out.println("\n\n->> [HABILIDADE] Guerreiro Droide Exterminador"+ this.getName() + " MATOU o guerreiro " +Gs.getFirst().getClass().getSimpleName() +" "+Gs.get(0).getName() + "!!!");   
        Gs.remove(Gs.getFirst());
    }
}
