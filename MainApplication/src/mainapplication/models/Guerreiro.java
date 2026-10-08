/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package mainapplication.models;

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

    public Guerreiro(Guerreiro g){
        this.name = g.name;
        this.age = g.age;
        this.weight = g.weight;
        this.hit = g.hit;
        this.baseName = g.baseName;
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

    public void alterHp(int alter , Arena arena){// Função N° 11
        this.hp = hp + alter;
        if(this.hp < 0)
            this.hp = 0;
        if (this.hp > hp_ref)
            this.hp = hp_ref;
    }

    public abstract void hit( int order , Arena arena);
    
    public abstract void attack(Arena arena);// Função N° 14

}
