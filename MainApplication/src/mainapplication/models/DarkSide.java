package mainapplication.models;

import java.util.ArrayList;
import mainapplication.repositorys.querys.FileOfLine;
import mainapplication.controllers.*;

public abstract class DarkSide extends Guerreiro{

    private static int Preference_hit = 0;

    public DarkSide(String name, int age, double weight , int hit) {
        super(name, age, weight , hit);
    }

    public DarkSide(Guerreiro G) {
        super(G);
    }

    public static int getPreference_hit(){// Função N° 15
        return  Preference_hit;
    }

    public static void setPreference_hit(int preferece){// Função N° 16
        Preference_hit = preferece;
    }
    
    @Override 
    public void attack(ArrayList<Guerreiro> Gs){// Função N° 13
        ArrayList<Guerreiro> temp = null;
        int i = 1;
        if (Preference_hit != 0){
            do{
                temp = FileOfLine.reader_Guerreiros(1, Preference_hit);
                i++;
            }while(temp == null && i <= Constants.MAX_FILES);
            if (temp != null) {
                Gs.clear();
                Gs.addAll(temp);
            }
            BattleSettings.setOrder(1, (i-1));
        }
    }


}
