package mainapplication.views;

import java.util.Scanner;
import mainapplication.controllers.BattleArena;
import mainapplication.controllers.Generate;

public class Begin {
    public static void introduction(Scanner scan){

        if (Generate.create_Side(1) && Generate.create_Side(2))
        {
            System.out.println("\n <<< CLIQUE EM QUALQUER TECLA PARA CARREGAR OS GUERREIROS >>>");
            scan.nextLine();
            BattleArena.loadingGuerreiros();
            Presentation.presentationGuerreiros();
            System.out.println("\n <<< CLIQUE EM QUALQUER TECLA PARA COMEÇAR AS BATALHAS >>>");
            scan.nextLine();// Espera pelo entrada do usuario
            if(ViewsOfBattle.overviewBattle(scan) == 1)
                System.out.println("\n <<< OS JEDI & CLONES VENCERAM A BATALHA >>>");
            else
                System.out.println("\n <<< OS SITH &DROIDES VENCERAM A BATALHA >>>");

            System.out.println("\n\n ULTIMO GUERREIRO A MORRER:\n ");
            System.out.println("Nome:" + BattleArena.getLastDie().getName()+ "\n");
            System.out.println("Idade:" + BattleArena.getLastDie().getAge()+ "\n");
            System.out.println("Altura:" + BattleArena.getLastDie().getWeight()+ "\n");
            System.out.println("Tipo :" + BattleArena.getLastDie().getBaseName()+ "\n");
            System.out.println("\n\n ULTIMO GUERREIRO A ATACAR: \n");
            System.out.println("Nome:" + BattleArena.getLastAttacker().getName()+ "\n");
            System.out.println("Idade:" + BattleArena.getLastAttacker().getAge()+ "\n");
            System.out.println("Altura:" + BattleArena.getLastAttacker().getWeight()+ "\n");
            System.out.println("Tipo :" + BattleArena.getLastAttacker().getBaseName()+ "\n");
            scan.close();
        }
        else
            System.out.println("[ERRO] Programa não conseguiu gerar as filas");
    }
}
