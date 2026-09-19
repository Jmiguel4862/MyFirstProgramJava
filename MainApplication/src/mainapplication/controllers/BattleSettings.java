package mainapplication.controllers;

import mainapplication.models.*;
import java.util.ArrayList;
import mainapplication.repositorys.querys.*;
import java.util.Scanner;

/**
 * BattleSettings
 */
public class BattleSettings {

    private static int[] orderOfBattle = new int[]{1,1};
    private static ArrayList<Guerreiro> SideJediClones = new ArrayList<>();
    private static ArrayList<Guerreiro> SideSithDroides = new ArrayList<>();;

    public static ArrayList<Guerreiro> getSideJediClones() {
        return SideJediClones;
    }

    public static ArrayList<Guerreiro> getSideSithDroides() {
        return SideSithDroides;
    }

    public static void setSideJediClones(ArrayList<Guerreiro> SideJediClones) {
        BattleSettings.SideJediClones = SideJediClones;
    }

    public static void setSideSithDroides(ArrayList<Guerreiro> SideSithDroides) {
        BattleSettings.SideSithDroides = SideSithDroides;
    }

    public static int getOrder(int team){
        return orderOfBattle[team-1];
    }

    public static void pushGuerreiro(int side , int line) {
        ArrayList<Guerreiro> Gs = FileOfLine.reader_Guerreiros(side, line);
        if (Gs == null)
            return ;
        Guerreiro temp = Gs.removeFirst();
        Gs.add(temp);
        FileOfLine.write_Guerreiros(Gs, side, line);
    }

    private static void pushSide(int side){
        for (int i = 1; i <= Constants.MAX_FILES; i++)
            pushGuerreiro(side, i);
    }
    
    private static void remove_Defeated(ArrayList<Guerreiro> Gs){
        for (int i = 0; i < Gs.size(); i++){
            if (Gs.get(i).getHp() <= 0 )
            {
                System.out.println("\n\nEVENTO DA GUERRA ->> Guerreiro "+Gs.get(i).getClass().getSimpleName()+Gs.get(i).getName()+" foi derrotado(MORREU)!!\n\n");
                Gs.remove(i);
                i--;
            }
        }
    }

    private static boolean fileSettings(ArrayList<Guerreiro> Gs, int side){
        int i = side -1;
        ArrayList<Guerreiro> temp = null;
        while (orderOfBattle[i] <=  Constants.MAX_FILES)
        {
            temp = FileOfLine.reader_Guerreiros(side, orderOfBattle[i]);
            if (temp != null)
            {
                Gs.addAll(temp);
                return true;
            }
            orderOfBattle[i]++;
        }
        orderOfBattle[i] = Constants.MAX_FILES;
        while (orderOfBattle[i] >= 1)
        {
            temp = FileOfLine.reader_Guerreiros(side, orderOfBattle[i]);
            if (temp != null)
            {
                Gs.addAll(temp);
                return true;
            }
            orderOfBattle[i]--;
        }
        return false;
    }

    private static boolean battle(ArrayList<Guerreiro> attacker ,ArrayList<Guerreiro> wholesale , int side){
        ArrayList<Guerreiro> temp = FileOfLine.reader_Guerreiros(side, orderOfBattle[side -1]);
        if (temp != null)
        {
            attacker.clear();
            attacker.addAll(temp);
        }
        else 
            return false;
        wholesale.clear();
        if(!fileSettings(wholesale, (side==1)?2:1 ))
            return  false;
        attacker.getFirst().attack(wholesale);
        BattleSettings.remove_Defeated(wholesale);
        return true;
    }

    public static int battleArena(){  
        Scanner scan = new Scanner(System.in);
        while(true){
            for (int i = 1; i <= 2; i++)
            {
                if (i == 1)
                    System.out.println("JEDI E CLONES VÃO ATACAR O SITH E OS DROIDES ");
                else 
                    System.out.println("SITH E OS DROIDES VÃO ATACAR O JEDI E CLONES DA FILA");
                    
                for (int j = 1; j <= Constants.MAX_FILES; j++) 
                {
                    orderOfBattle[0] = j;
                    orderOfBattle[1] = j;
                    if (i == 1){
                        if(!battle(SideJediClones, SideSithDroides , i))
                            continue;
                    }
                    else {
                        if(!battle(SideSithDroides, SideJediClones , i))
                            continue; 
                    }
                    FileOfLine.write_Guerreiros(SideJediClones, 1, j);
                    FileOfLine.write_Guerreiros(SideSithDroides, 2, j);
                    scan.nextLine();
                }
            }
            if (SideJediClones.size() > 0 && SideSithDroides.size() > 0)
            {
                pushSide(1);
                pushSide(2);
            }
            else
                break;
        }
       return  (SideJediClones.size() > 0)? 1: 2;
    }
    
}