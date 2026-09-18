package mainapplication.models;

import java.util.ArrayList;
import mainapplication.repositorys.querys.FileOfLine;
import mainapplication.controllers.BattleSettings;

public abstract class DarkSide extends Guerreiro{

    private static boolean Preference_hit = false;

    public DarkSide(String name, int age, double weight , int hit) {
        super(name, age, weight , hit);
    }

    public DarkSide(Guerreiro G) {
        super(G);
    }

    public static boolean getPreference_hit(){
        return  Preference_hit;
    }

    public static void setPreference_hit(boolean preferece){
        Preference_hit = preferece;
    }
    
    @Override 
    public void attack(ArrayList<Guerreiro> Gs){
        if (Preference_hit){
            Gs = null;
            Gs = FileOfLine.reader_Guerreiros(1, BattleSettings.getOrder(1));
        }
    }


}
