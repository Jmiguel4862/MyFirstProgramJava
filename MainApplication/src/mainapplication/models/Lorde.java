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
public class Lorde extends DarkSide{
    private boolean espectro = false;
    public Lorde(String name, int age, double weight) {
        super(name, age, weight , 50 , "Lorde");
    }
    public Lorde(Guerreiro G) {
        super(G);
    }
    public void setEspectro(boolean bool){
        this.espectro = bool;
    }

    @Override 
    public void alterHp(int alter , Arena arena){// Função N° 11
        super.alterHp(alter , arena);
        Acolito acolito = null;
        if (this.getHp() ==  0 && !espectro) {
            System.out.println("\n->> [HABILIDADE] Lorde morreu, porém deixou 4 acolitos em seu lugar para terminarem o trabalho que ele começou!!");
            for (int i = 0; i < 4; i++) {
                acolito = new Acolito(this.getName(), this.getAge(), this.getWeight());
                arena.getCurrentLineTeam2().add(acolito);
                acolito = null;
            }
        }
    }

    @Override
    public void attack(Arena arena) {// Função N° 13
        super.attack(arena);
        ArrayList<Guerreiro> gs = arena.getCurrentLineTeam1();
        Lorde sith = null;
        if ((gs.getFirst().getHp() - this.getHit()) < 1 && !espectro)
        {
            sith = new Lorde(gs.getFirst().getName(), gs.getFirst().getAge(), gs.getFirst().getWeight());
            System.out.println("\n->> [HABILIDADE] Lorde fez seu Ritual de reanimação e trouxe inimigo derrotado de volta a vida");
            sith.setHit(-5);
            sith.setBaseName("Espectro Sith");
            sith.espectro = true;
            arena.getCurrentLineTeam2().add(sith);
        }
        hit(0 , arena);
        
    }
}
