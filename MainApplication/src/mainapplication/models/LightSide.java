package mainapplication.models;

import java.util.ArrayList;
import mainapplication.controllers.BattleSettings;

public abstract class LightSide extends Guerreiro{


    private boolean poisoned = false;

    public void set_poisoned(boolean poisoned){
        this.poisoned = poisoned;
    }

    public boolean get_poisoned(){
        return poisoned;
    }

    public LightSide(String name, int age, double weight , int hit) {
        super(name, age, weight , hit);
    }
    public LightSide(Guerreiro G) {
        super(G);
    }

    @Override 
    public void alterHp(int alter){
        super.alterHp(alter);
        if (BattleSettings.getSideSithDroides().getFirst().getClass() == Assassino.class) {
            this.poisoned =true;
        }
    }
    
    @Override
    public void attack(ArrayList<Guerreiro> Gs){
        if (poisoned)
        {
            System.out.println("\n ->> O querreito que esta atacando esta envenenado por algum assasino e vai perder 5 ponto de HP por isso. ");
            this.alterHp(5);
        }
    }

}
