package mainapplication.views;


import mainapplication.models.*;
import mainapplication.controllers.*;
import java.util.ArrayList;
/**
 * PresentationGuerreiros
 */

class PresentationDatas{
    private double total_weight = 0;
    private Guerreiro most_Weight = null;
    public PresentationDatas(double total_weight, Guerreiro most_Weight){
        this.total_weight = total_weight;
        this.most_Weight = most_Weight;
    }
    public double getTotal_weight() {
        return total_weight;
    }
    public Guerreiro getMost_Weight() {
        return most_Weight;
    }
}

public class Presentation {

    private static PresentationDatas presentationGuerreiros(int side , String SideOfForce ){            
        double total_weight=0;
        Guerreiro Most_Weight = null;
        System.out.println("\n << GUERREIROS DO LADO DOS" + SideOfForce + ">>\n");
        for(int i = 0 ; i < Constants.MAX_FILES ; i++){
            System.out.println("\nGuerreiro da fila " + (i+1) + ":\n");
            for (Guerreiro G : ((side == 1)? BattleSettings.getSideJediClones().get(i):BattleSettings.getSideSithDroides().get(i))) {
                System.out.println(G.getBaseName() + " | " + G.getName() + " | " + G.getAge() + " anos | " + String.format("%.2f", G.getWeight()) + " kg | " + G.getHp() + " HP | "+ G.getHit() + " HIT");
                total_weight += G.getWeight();
                if (Most_Weight == null || G.getWeight() > Most_Weight.getWeight())
                    Most_Weight = G;
            }
        }
        return new PresentationDatas(total_weight, Most_Weight);
    }

    public static void presentationGuerreiros(){
        PresentationDatas datas1 = presentationGuerreiros(1, "JEDI & CLONES");
        PresentationDatas datas2 = presentationGuerreiros(2, "SITH & DROIDES");
        System.out.println("\n\nPESO TOTAL DO LADO DOS JEDI & CLONES:" + String.format("%.2f", datas1.getTotal_weight()) + " kg\n");
        System.out.println("\nGUERREIRO MAIS PESADO DO LADO DOS JEDI & CLONES: " + datas1.getMost_Weight().getName() + " - " + String.format("%.2f", datas1.getMost_Weight().getWeight()) + " kg\n");
        System.out.println("\n\nPESO TOTAL DO LADO DOS SITH & DROIDES:" + String.format("%.2f", datas2.getTotal_weight()) + " kg\n");
        System.out.println("\nGUERREIRO MAIS PESADO DO LADO DOS SITH & DROIDES: " + datas2.getMost_Weight().getName() + " - " + String.format("%.2f", datas2.getMost_Weight().getWeight()) + " kg\n");
    }

    private static void StatusSide(int side , String SideOfForce){
        System.out.println("\n << GUERREIROS DO LADO DOS " + SideOfForce + ">>\n");
        ArrayList<ArrayList<Guerreiro>> sideForce = (side == 1)? BattleSettings.getSideJediClones():BattleSettings.getSideSithDroides();
        for(int i = 0 ; i < Constants.MAX_FILES ; i++){
            System.out.println("\nGuerreiro da fila " + (i+1) + ":\n");
            if (sideForce.get(i).size() < 1)
                System.out.println("[DEROTADO] -> Guerreiros da fila " + (i+1) + " foram eliminados!\n");
            else
                for (Guerreiro G : sideForce.get(i))
                    System.out.println(G.getBaseName() + " | " + G.getName() + " | " + G.getAge() + " anos | " + String.format("%.2f", G.getWeight()) + " kg | " + G.getHp() + " HP | "+ G.getHit() + " HIT");
        }
    }

    public static void StatusBattle(){
        for(int i = 1 ; i <= 50 ; i++) System.out.print("\n");
        System.out.println("----------------------------------------------------------------");
        System.out.println("\n\n================== STATUS DA BATALHA ==================\n");
        StatusSide(1, "JEDI & CLONES");
        StatusSide(2, "SITH & DROIDES");
        System.out.println("----------------------------------------------------------------");
    }
}// goto line o_ceu_e_limite