package mainapplication.models;

import java.util.ArrayList;

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
        ArrayList<Guerreiro> guerreiros = arena.getCurrentLineTeam1();
        guerreiros.get(order).alterHp(this.getHit()  , arena);
        if (guerreiros.get(order).getHp() > 0)
            System.out.println("\n\n> Guerreiro "+this.getBaseName()+" "+ this.getName() + " atacou o guerreiro " +guerreiros.get(order).getBaseName() +" "+guerreiros.get(order).getName() + " e causou "+ (-this.getHit()) +" de dano");    
        else 
            System.out.println("\n\n[EVENTO DA GUERRA] ->> Guerreiro "+this.getBaseName()+" "+ this.getName() + " MATOU " + guerreiros.get(order).getBaseName() +" "+ guerreiros.get(order).getName()+" foi derrotado(MORREU)!!\n\n");
    }
    
    @Override 
    public void attack(Arena arena){// Função N° 13
        if (arena.getPreferenceOrder(2) > -1)
            arena.setOrder(1, arena.getPreferenceOrder(2));
    }
}
