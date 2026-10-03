/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package mainapplication.models;

import java.util.ArrayList;
import mainapplication.controllers.Constants;

/**
 *
 * @author João Miguel
 */
public class DroideExterminador extends DarkSide{
    
    public DroideExterminador(String name, int age, double weight) {
        super(name, age, weight , Constants.MOST_HP);
            setHp_ref(60);
            setHp(60);
    }
    public DroideExterminador(Guerreiro G) {
        super(G);
            setHp(60);
            setHp(60);
    }
    @Override
    public void attack(ArrayList<Guerreiro> Gs) {// Função N° 13
        super.attack(Gs);
        System.out.println("\n\n->> [HABILIDADE] Guerreiro Droide Exterminador "+ this.getName() + " MATOU o guerreiro " +Gs.getFirst().getClass().getSimpleName() +" "+Gs.get(0).getName() + "!!!");   
        hit(Gs, 0, "Droide Exterminador", this.getHit());
    }
}
