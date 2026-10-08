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
public class Acolito extends DarkSide{
    
    public Acolito(String name, int age, double weight) {
        super(name, age, weight , 15 , "Acolito");
    }

    @Override
    public void attack(Arena arena) {// Função N° 13
        super.attack(arena);
        ArrayList<Guerreiro> Gs = arena.getCurrentLineTeam1();
        System.out.println("\n->> [HABILIDADE] Acalito atacou o primeiro da fila saltou e atacou o ultimo da fila ");
        hit(0 , arena);
        if(Gs.size() > 0) hit((Gs.size() - 1) , arena);
    }
}
