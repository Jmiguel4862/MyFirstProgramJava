/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package mainapplication.models;

import java.util.ArrayList;
import mainapplication.controllers.BattleSettings;

/**
 *
 * @author João Miguel
 */
public class Lorde extends DarkSide{
    private boolean espectro = false;
    public Lorde(String name, int age, double weight) {
        super(name, age, weight, 50);
    }
    public Lorde(Guerreiro G) {
        super(G);
    }
    public void setEspectro(boolean bool){
        this.espectro = bool;
    }

    @Override 
    public void alterHp(int alter){
        super.alterHp(alter);
        ArrayList<Guerreiro> sd = null;
        Acolito acolito = null;
        /*if (this.getHp() ==  0) {
            sd = BattleSettings.getSideSithDroides();
            System.out.println("\n->> [HABILIDADE] Lorde morreu, porém deixou 4 acolitos em seu lugar para terminarem o trabalho que ele começou!!");
            for (int i = 0; i < 4; i++) {
                acolito = new Acolito(this.getName(), this.getAge(), this.getWeight());
                sd.add(acolito);
                acolito = null;
            }
        }*/
    }

    @Override
    public void attack(ArrayList<Guerreiro> Gs) {
        super.attack(Gs);
        String nameL = null;
        ArrayList<Guerreiro> sd = null;
        Lorde sith = new Lorde(Gs.getFirst().getName(), Gs.getFirst().getAge(), Gs.getFirst().getWeight());
        if (espectro)nameL = "Espectro Sith";
        else nameL = "Lorde";
        if (hit(Gs, 1, nameL, this.getHit()))
        {
            System.out.println("\n->> [HABILIDADE] Lorde fez seu Ritual de reanimação e trouxe inimigo derrotado de volta a vida");
            sd = BattleSettings.getSideSithDroides();
            sith.setHit(5);
            sith.espectro = true;
            sd.add(sith);
        }
    }
}
