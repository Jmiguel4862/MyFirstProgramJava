/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package mainapplication.models;

import java.util.ArrayList;

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
    private String metaData[] = null;
    
    public Guerreiro(String name, int age, double weight , int hit, String metaData){
        this.name = name;
        this.age = age;
        this.weight = weight;
        this.hit = -hit;
        this.metaData = metaData.split(" ");

    }

    public Guerreiro(Guerreiro G){
        this.name = G.getName();
        this.age = G.getAge();
        this.weight = G.getWeight();
        this.hp_ref = G.getHp();
        this.hp = G.getHp();
        this.hit = G.getHit();
        this.metaData = G.getMetaData();
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
    

    public void setHit(int hit){// Função N° 10
        this.hit = hit;
    }


    public void alterHp(int alter){// Função N° 11
        this.hp = hp + alter;
        if(this.hp < 0)
            this.hp = 0;
        if (this.hp > hp_ref)
            this.hp = hp_ref;
    }

    public String[] getMetaData(){// Função N° 12
        return metaData;
    }

    public boolean hit(ArrayList<Guerreiro> gs , int order, String sideName , int damage){// Função N° 13
        int index = order - 1;
        gs.get(index).alterHp(damage);
        if (gs.get(index).hp > 0)
        {
            System.out.println("\n\n> Guerreiro "+sideName+" "+ this.getName() + " atacou o guerreiro " +gs.get(index).getClass().getSimpleName() +" "+gs.get(index).getName() + " e causou "+ (-damage) +" de dano");    
            return false;
        }
        else 
        {
            System.out.println("\n\n[EVENTO DA GUERRA] ->> Guerreiro "+sideName+" "+ this.getName() + " MATOU " + gs.get(index).getClass().getSimpleName() +" "+ gs.get(index).getName()+" foi derrotado(MORREU)!!\n\n");
            gs.remove(index);
            return true;
        }
    }
    
    
    public abstract void attack(ArrayList<Guerreiro> Gs);// Função N° 14

}
