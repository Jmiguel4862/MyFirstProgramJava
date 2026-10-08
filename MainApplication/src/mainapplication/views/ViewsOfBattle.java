package mainapplication.views;

import java.util.Random;
import java.util.Scanner;
import mainapplication.controllers.BattleArena;

/**
 * ViewsOfBattle
 */
public class ViewsOfBattle {
    public static int overviewBattle(Scanner scan){

        while(winner == 0){
            for (int i = first;indCpm(inc , i); i += inc)
            {
                if(winner != 0)
                    break;
                if (i == 1)
                    System.out.println("JEDI E CLONES VÃO ATACAR O SITH E OS DROIDES ");
                else 
                    System.out.println("SITH E OS DROIDES VÃO ATACAR O JEDI E CLONES DA FILA");
                winner = BattleArena.battleArena(i, scan);
                    
            }
            if (winner != 0)
                return winner;
            BattleArena.resetVeriablesBattle();
            Presentation.StatusBattle(scan);
            BattleArena.pullSide(1);
            BattleArena.pullSide(2);
        }
        return winner;
    }
}