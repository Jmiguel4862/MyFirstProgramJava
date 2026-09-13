/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package mainapplication.models;

import java.util.ArrayList;
import  mainapplication.repositorys.querys.FileOfLine;
import  mainapplication.controllers.BattleSettings;

/**
 *
 * @author João Miguel
 */
public class CloneMedico extends Guerreiro{
    
    public CloneMedico(String name, int age, double weight) {
        super(name, age, weight , 20);
    }

    @Override
    public void attack(ArrayList<Guerreiro> Gs) {
        ArrayList <Guerreiro> gs = null;
        hit(Gs , 1 , "Clone Médico" , this.getHit());
        gs = FileOfLine.reader_Guerreiros(1, BattleSettings.getOrder(1));
        if(gs.size() > 1)
            gs.get(1).alterHp(20);
    }
    
}
