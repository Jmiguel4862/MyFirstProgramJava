package mainapplication.models;

import java.util.ArrayList;

public abstract class LightSide extends Guerreiro{


    private boolean poisoned = false;
    private static String nameSide = "Jide & Clones";

    public LightSide(String name, int age, double weight , int hit, String baseName) {
        super(name, age, weight , hit , baseName);
    }

    public LightSide(Guerreiro g){
        super(g);
    }

    public static String getNameSide(){
        return nameSide;
    }

    public void set_poisoned(boolean poisoned){
        this.poisoned = poisoned;
    }

    public boolean get_poisoned(){
        return poisoned;
    }



    @Override 
    public void alterHp(int alter , Arena arena){// Função N° 11
        super.alterHp(alter , arena);
        if ( alter < 0 && arena.getCurrentLineTeam2().getFirst().getClass() == Assassino.class) {
            this.poisoned =true;
        }
    }

    @Override 
    public void hit(int order , Arena arena){// Função N° 13
        ArrayList<Guerreiro> gs = arena.getCurrentLineTeam2();
        gs.get(order).alterHp(this.getHit() , arena);
        if (gs.get(order).getHp() > 0)
            System.out.println("\n\n> Guerreiro "+this.getBaseName()+" "+ this.getName() + " atacou o guerreiro " +gs.get(order).getBaseName() +" "+gs.get(order).getName() + " e causou "+ (-this.getHit()) +" de dano");    
        else 
            System.out.println("\n\n[EVENTO DA GUERRA] ->> Guerreiro "+this.getBaseName()+" "+ this.getName() + " MATOU " + gs.get(order).getBaseName() +" "+ gs.get(order).getName()+" foi derrotado(MORREU)!!\n\n");
    }
    
    @Override
    public void attack(Arena arena){// Função N° 13
        if (poisoned)
        {
            System.out.println("\n ->> O guerreiro que esta atacando esta envenenado por algum assasino e vai perder 5 ponto de HP por isso. ");
            this.alterHp(-5 , arena);
        }

    }
}
