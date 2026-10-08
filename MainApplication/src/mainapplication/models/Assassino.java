/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package mainapplication.models;


/**
 *
 * @author João Miguel
 */
public class Assassino extends DarkSide{
    
    public Assassino(String name, int age, double weight) {
        super(name, age, weight , 20, "Assassino");
    }

    @Override
    public void attack() {// Função N° 13
        super.attack();
        System.out.println("\n\n->> [HABILIDADE] Este assasino enveneno o guerreiro atacado agora a cada ataque deste guereiro ele perdera 5 pontos ");
        hit(0 );
    }   
}
