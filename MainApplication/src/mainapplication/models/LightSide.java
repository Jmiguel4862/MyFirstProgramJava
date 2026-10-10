package mainapplication.models;

import java.util.ArrayList;

public abstract class LightSide extends Guerreiro{


    private boolean poisoned = false;

    public LightSide(String name, int age, double weight , int hit, String baseName) {
        super(name, age, weight , hit , baseName);
    }

    public void setPoisoned(boolean poisoned){
        this.poisoned = poisoned;
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
        ArrayList<Guerreiro> guerreiros = arena.getCurrentLineTeam2();
        guerreiros.get(order).alterHp(this.getHit() , arena);
        if (guerreiros.get(order).getHp() > 0)
            System.out.println("\n\n> Guerreiro "+this.getBaseName()+" "+ this.getName() + " atacou o guerreiro " +guerreiros.get(order).getBaseName() +" "+guerreiros.get(order).getName() + " e causou "+ (-this.getHit()) +" de dano");    
        else 
            System.out.println("\n\n[EVENTO DA GUERRA] ->> Guerreiro "+this.getBaseName()+" "+ this.getName() + " MATOU " + guerreiros.get(order).getBaseName() +" "+ guerreiros.get(order).getName()+" foi derrotado(MORREU)!!\n\n");
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
