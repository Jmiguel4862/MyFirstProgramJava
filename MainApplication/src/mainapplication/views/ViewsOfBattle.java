package mainapplication.views;

import java.util.Random;
import java.util.Scanner;
import mainapplication.controllers.BattleSettings;

/**
 * ViewsOfBattle
 */
public class ViewsOfBattle {
    public static int overviewBattle(Scanner scan){
        Random ran = new Random();
        boolean firstRound = true;
        int winner = 0;
        while(winner == 0){
            for (int i = 1; i <= 2; i++)
            {
                if(winner != 0)
                    break;
                if (firstRound)
                {
                    firstRound = false;
                    i = ran.nextInt(2) + 1;
                }
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