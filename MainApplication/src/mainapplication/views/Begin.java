package mainapplication.views;

import java.util.Scanner;
import mainapplication.models.Arena;
import mainapplication.controllers.*;

public class Begin {
    public static void introduction(Arena arena , Scanner scan){
        arena = InsertGuerreiros.loadingGuerreiros();
        Presentation.presentationGuerreiros(arena);
        System.out.println("\n <<< CLIQUE EM QUALQUER TECLA PARA COMEÇAR AS BATALHAS >>>");
        scan.nextLine();// Espera pelo entrada do usuario
        arena.battleArena(scan);
        if (arena.getWinner() == 1)
            System.out.println("\n <<< OS JEDI & CLONES VENCERAM A BATALHA >>>");
        else
            System.out.println("\n <<< OS SITH &DROIDES VENCERAM A BATALHA >>>");

        System.out.println("\n\n ULTIMO GUERREIRO A MORRER:\n");
        System.out.println("Nome:" + arena.getLastDie().getName()+ "\n");
        System.out.println("Idade:" + arena.getLastDie().getAge()+ "\n");
        System.out.println("Altura:" + arena.getLastDie().getWeight()+ "\n");
        System.out.println("Tipo :" + arena.getLastDie().getBaseName()+ "\n");
        System.out.println("\n\n ULTIMO GUERREIRO A ATACAR: \n");
        System.out.println("Nome:" + arena.getLastAttacker().getName()+ "\n");
        System.out.println("Idade:" + arena.getLastAttacker().getAge()+ "\n");
        System.out.println("Altura:" + arena.getLastAttacker().getWeight()+ "\n");
        System.out.println("Tipo :" + arena.getLastAttacker().getBaseName()+ "\n");
    }
}
