package mainapplication.models;

import java.util.ArrayList;

import mainapplication.controllers.*;

public abstract class DarkSide extends Guerreiro{

    private static String nameSide = "Sith & Droides";

    public DarkSide(String name, int age, double weight , int hit , String baseName) {
        super(name, age, weight , hit , baseName);
    }
    
    public DarkSide(Guerreiro g){
        super(g);
    }

    public static String getNameSide(){
        return nameSide;
    }

    @Override 
    public void hit(int order , Arena arena){// Função N° 13
        ArrayList<Guerreiro> gs = arena.getCurrentLineTeam1();
        gs.get(order).alterHp(this.getHit()  , arena);
        if (gs.get(order).getHp() > 0)
            System.out.println("\n\n> Guerreiro "+this.getBaseName()+" "+ this.getName() + " atacou o guerreiro " +gs.get(order).getBaseName() +" "+gs.get(order).getName() + " e causou "+ (-this.getHit()) +" de dano");    
        else 
            System.out.println("\n\n[EVENTO DA GUERRA] ->> Guerreiro "+this.getBaseName()+" "+ this.getName() + " MATOU " + gs.get(order).getBaseName() +" "+ gs.get(order).getName()+" foi derrotado(MORREU)!!\n\n");
    }
    
    @Override 
    public void attack(Arena arena){// Função N° 13
        if (arena.preferenceOrder() > -1)
            arena.setOrder(1, preference_hit);
    }
}
