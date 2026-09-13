/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package mainapplication.models;

import java.util.ArrayList;
import mainapplication.repositorys.querys.FileOfLine;
import mainapplication.controllers.BattleSettings;

/**
 *
 * @author João Miguel
 */
public class Lorde extends Guerreiro{
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
    public void attack(ArrayList<Guerreiro> Gs) {
        String nameL = "Lorde";
        ArrayList<Guerreiro> sd = null;
        Guerreiro sith = null;
        if (espectro)nameL = "Espectro Sith";
        hit(Gs, 1, nameL, this.getHit());
        if (Gs.getFirst().getHp() == 0 && !espectro)
        {
            sd = FileOfLine.reader_Guerreiros(2, BattleSettings.getOrder(2));
            sith = new Lorde(Gs.getFirst().getName(), Gs.getFirst().getAge(), Gs.getFirst().getWeight());
            sith.setHit(5);
            sd.add(sith);
        }
    }
}
