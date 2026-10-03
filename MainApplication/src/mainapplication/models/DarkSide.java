package mainapplication.models;

import java.util.ArrayList;
import mainapplication.controllers.*;

public abstract class DarkSide extends Guerreiro{

    private static int preference_hit = -1 ;

    public DarkSide(String name, int age, double weight , int hit) {
        super(name, age, weight , hit);
    }

    public DarkSide(Guerreiro G) {
        super(G);
    }

    public static int getPreference_hit(){// Função N° 15
        return  preference_hit;
    }

    public static void setPreference_hit(int preferece){// Função N° 16
        preferece--;
        if (preferece >= 0 && preferece < Constants.MAX_FILES)
            preference_hit = preferece;
    }
    
    @Override 
    public void attack(ArrayList<Guerreiro> Gs){// Função N° 13
        if (preference_hit > -1){
            Gs = null;
            Gs = BattleSettings.getSideJediClones().get(preference_hit);
            System.out.println(Gs.getFirst().getName() + " foi atacado por preferencia do lado escuro!!");
        }
    }


}
