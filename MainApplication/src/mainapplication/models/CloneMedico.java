/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package mainapplication.models;

import java.util.ArrayList;
import  mainapplication.controllers.BattleSettings;

/**
 *
 * @author João Miguel
 */
public class CloneMedico extends LightSide{
    
    public CloneMedico(String name, int age, double weight) {
        super(name, age, weight , 20);
    }

    @Override
    public void attack(ArrayList<Guerreiro> Gs) {
        super.attack(Gs);
        ArrayList <Guerreiro> gs = BattleSettings.getSideJediClones();
        hit(Gs , 1 , "Clone Médico" , this.getHit());
        if(gs.size() > 1 && gs.get(1).getHp() < gs.get(1).getHp_ref())
        {
            System.out.println("\n->> [HABILIDADE] Clone Medico recuperou 20 pontos de vida do guerreiro" + gs.get(1).getClass().getSimpleName() +gs.get(1).getName() +" logo atrás dele!!" );
            gs.get(1).alterHp(20);
        }
    }
    
}
