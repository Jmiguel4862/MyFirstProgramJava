/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package mainapplication.models;

import mainapplication.controllers.BattleSettings;

/**
 *
 * @author João Miguel
 */
public class JediGeneral extends LightSide{
    
    public JediGeneral(String name, int age, double weight) {
        super(name, age, weight , 50 , "Jedi General");
    }
    public JediGeneral(Guerreiro G) {
        super(G);
    }
    @Override
    public void attack() {// Função N° 13
        super.attack();
        if ((BattleSettings.getCurrentLineSithDroides().get(0).getHp() + this.getHit()) < 1) {
            this.alterHp(50);
            this.setHit(this.getHit() - 5);
            System.out.println("\n\n->> [HABILIDADE] Jide General matou o inimigo, conseguindo se aproximar mais do equilibriu da força, ganhou 5 pontos a mais de ataque e recuperou 50 pontos de vita");
        }
        hit(0);
    }
    
}
