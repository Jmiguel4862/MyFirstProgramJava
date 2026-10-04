/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package mainapplication.models;

import java.util.ArrayList;
import mainapplication.controllers.*;

/**
 *
 * @author 2025122760081
 */
public abstract class Guerreiro {
    private String name;
    private int age;    
    private double weight;
    private int hp_ref = 100;
    private int hp = 100;
    private int hit = -10;
    private String baseName = null;
    
    public Guerreiro(String name, int age, double weight , int hit , String baseName){
        this.name = name;
        this.age = age;
        this.weight = weight;
        this.hit = -hit;
        this.baseName = baseName;

    }

    public Guerreiro(Guerreiro G){
        this.name = G.getName();
        this.age = G.getAge();
        this.weight = G.getWeight();
        this.hp_ref = G.getHp_ref();
        this.hp = G.getHp_ref();
        this.hit = G.getHit();

    }

    public String getName(){// Função N° 1
        return name;
    }
    
    public void setName(String name) {// Função N° 2
        this.name = name;
    }
    
    public int getAge() {// Função N° 3
        return age;
    }
    
    public double getWeight() {// Função N° 4
        return weight;
    }

    public int getHp_ref(){// Função N° 5
        return hp_ref;
    }
    
    public void setHp_ref(int newhp){// Função N° 6
        this.hp_ref = newhp;
    }
    
    public int getHp() {// Função N° 7
        return hp;
    }
    
    public void setHp(int hp) { // Função N° 8
        this.hp = hp;
    }

    public int getHit(){// Função N° 9
        return hit;
    }
    
    public String getBaseName(){// Função N° 12
        return baseName;
    }

    public void setHit(int hit){// Função N° 10
        this.hit = hit;
    }


    public void setBaseName(String baseName){// Função N° 12
        this.baseName = baseName;
    }

    public void alterHp(int alter){// Função N° 11
        this.hp = hp + alter;
        if(this.hp < 0)
            this.hp = 0;
        if (this.hp > hp_ref)
            this.hp = hp_ref;
    }

    public boolean hit(int order){// Função N° 13
        ArrayList<Guerreiro> gs = (this instanceof LightSide) ? BattleSettings.getCurrentLineSithDroides() : BattleSettings.getCurrentLineJediClones();
        gs.get(order).alterHp(this.getHit());
        if (gs.get(order).getHp() > 0)
        {
            System.out.println("\n\n> Guerreiro "+this.getBaseName()+" "+ this.getName() + " atacou o guerreiro " +gs.get(order).getBaseName() +" "+gs.get(order).getName() + " e causou "+ (-this.getHit()) +" de dano");    
            return false;
        }
        else 
        {
            System.out.println("\n\n[EVENTO DA GUERRA] ->> Guerreiro "+this.getBaseName()+" "+ this.getName() + " MATOU " + gs.get(order).getBaseName() +" "+ gs.get(order).getName()+" foi derrotado(MORREU)!!\n\n");
            gs.remove(order);
            return true;
        }
    }
    
    public abstract void attack();// Função N° 14

}
