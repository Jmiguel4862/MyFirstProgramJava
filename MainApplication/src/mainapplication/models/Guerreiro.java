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
    private int hit = -10;
    private int hp_ref = 100;
    private int hp = 100;
    
    public Guerreiro(String name, int age, double weight , int hit){
        this.name = name;
        this.age = age;
        this.weight = weight;
        this.hit = -hit;
    }

    public Guerreiro(Guerreiro G){
        this.name = G.getName();
        this.age = G.getAge();
        this.weight = G.getWeight();
        this.hp_ref = G.getHp();
        this.hp = G.getHp();
        this.hit = G.getHit();
    }

     public int getHp_ref(){
        return hp_ref;
     }

    public String getName() {
        return name;
    }

    
    public int getAge() {
        return age;
    }
    
    public double getWeight() {
        return weight;
    }
    
    public int getHit(){
        return hit;
    }
    
    public int getHp() {
        return hp;
    }
    
    public void setName(String name) {
        this.name = name;
    }

    public void setHit(int hit){
        this.hit = hit;
    }

    public void setHp(int hp) {
        this.hp = hp;
    }

    public void defineHp(int newhp){
        this.hp_ref = newhp;
        this.hp = newhp;
    }

    public boolean hit(ArrayList<Guerreiro> gs , int order, String sideName , int damage){
        int index = order - 1;
        gs.get(index).alterHp(damage);
        if (gs.get(index).hp > 0)
        {
            System.out.println("\n\n> Guerreiro "+sideName+" "+ this.getName() + " atacou o guerreiro " +gs.get(index).getClass().getSimpleName() +" "+gs.get(index).getName() + " e causou "+ (-damage) +" de dano");    
            return false;
        }
        else 
        {
            gs.remove(index);
            System.out.println("\n\n[EVENTO DA GUERRA] ->> Guerreiro "+sideName+" "+ this.getName() + " MATOU " + gs.get(index).getClass().getSimpleName()+gs.get(index).getName()+" foi derrotado(MORREU)!!\n\n");
            return true;
        }
    }
    
    public void alterHp(int alter){
        this.hp = hp + alter;
        if(this.hp < 0)
            this.hp = 0;
        if (this.hp > hp_ref)
            this.hp = hp_ref;
    }
    
    public abstract void attack(ArrayList<Guerreiro> Gs);
}
