package mainapplication.views;

import java.util.Random;
import java.util.Scanner;
import mainapplication.controllers.BattleSettings;

/**
 * ViewsOfBattle
 */
public class ViewsOfBattle {
    private static boolean indCpm(int inc , int ind){
        if(inc > 0)
        {
            if(ind <= 2)return true;
            else return false;
        }
        else
        {
            if(ind >= 1)return true;
            else return false;
        }
    }
    public static int overviewBattle(Scanner scan){
        Random ran = new Random();
        boolean firstRound = true;
        int winner = 0 , first = ran.nextInt(2)+1, last = (first == 1)?2:1, inc = (first == 1)?1:-1;
        while(winner == 0){
            for (int i = first;indCpm(inc , i); i += inc)
            {
                if(winner != 0)
                    break;
                if (i == 1)
                    System.out.println("JEDI E CLONES VÃO ATACAR O SITH E OS DROIDES ");
                else 
                    System.out.println("SITH E OS DROIDES VÃO ATACAR O JEDI E CLONES DA FILA");
                winner = mainapplication.controllers.BattleSettings.battleArena(i, scan);
                    
            }
            if (winner != 0)
                return winner;
            BattleSettings.resetVeriablesBattle();
            Presentation.StatusBattle(scan);
            BattleSettings.pullSide(1);
            BattleSettings.pullSide(2);
        }
        return winner;
    }
}