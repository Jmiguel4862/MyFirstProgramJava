package mainapplication.models;

import mainapplication.controllers.*;

public abstract class DarkSide extends Guerreiro{

    private static int preference_hit = -1 ;

    public DarkSide(String name, int age, double weight , int hit , String baseName) {
        super(name, age, weight , hit , baseName);
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
    public void attack(){// Função N° 13
        if (preference_hit > -1){
            BattleSettings.setOrder(1, preference_hit);
        }
        //System.out.println("\n\nQuantidade de Guerreiros sendo atacados: " + BattleSettings.getCurrentLineSithDroides().size());
    }
}
