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
    private static ArrayList<Guerreiro> SideSithDroides = new ArrayList<>();
    private static boolean FirstOfLine = false;

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
        if (FirstOfLine)
            return  1;
        else
        return orderOfBattle[team-1];
    }

    public static void setOrder(int team , int neworder){
        if(team <= 4 || team >= 1)
            orderOfBattle[team-1] = neworder;
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

    private static void resetVeriablesBattle(){
        DarkSide.setPreference_hit(0);
    }
    
    private static boolean fileSettings(ArrayList<Guerreiro> Gs, int side){
        int i = side -1;
        ArrayList<Guerreiro> temp = null;
        Gs.clear();
        for(int j = orderOfBattle[i]; j <=  Constants.MAX_FILES;j++)
        {
            temp = FileOfLine.reader_Guerreiros(side, j);
            if (temp != null)
            {
                Gs.addAll(temp);
                orderOfBattle[i] = j;
                return true;
            }
        }
        for(int j = (orderOfBattle[i] - 1); j > 0;j--)
        {
            temp = FileOfLine.reader_Guerreiros(side, j);
            if (temp != null)
            {
                Gs.addAll(temp);
                orderOfBattle[i] = j;
                return true;
            }
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
        if(!fileSettings(wholesale, (side==1)?2:1 ))
            return  false;
        attacker.getFirst().attack(wholesale);
        return true;
    }

    public static int battleArena(){  
        Scanner scan = new Scanner(System.in);
        int count_defeat = 0;
        while(count_defeat != Constants.MAX_FILES){
            for (int i = 1; i <= 2; i++)
            {
                count_defeat = 0;
                if (i == 1)
                    System.out.println("JEDI E CLONES VÃO ATACAR O SITH E OS DROIDES ");
                else 
                    System.out.println("SITH E OS DROIDES VÃO ATACAR O JEDI E CLONES DA FILA");
                    
                for (int j = 1; j <= Constants.MAX_FILES; j++) 
                {
                    orderOfBattle[0] = j;
                    orderOfBattle[1] = j;
                    if (j == 1) FirstOfLine = true;
                    else FirstOfLine = false;
                    if (i == 1){
                        if(!battle(SideJediClones, SideSithDroides , i))
                            {
                                count_defeat++;
                                continue;
                            }
                    }
                    else {
                        if(!battle(SideSithDroides, SideJediClones , i))
                            {
                                count_defeat++;
                                continue;
                            }
                    }
                    FileOfLine.write_Guerreiros(SideJediClones, 1, orderOfBattle[0]);
                    FileOfLine.write_Guerreiros(SideSithDroides, 2, orderOfBattle[1]);
                    scan.nextLine();
                    System.out.println("\n=========================================\n");
                }
            }
            if(count_defeat != Constants.MAX_FILES)
            {
                resetVeriablesBattle();
                pushSide(1);
                pushSide(2);
            }
        }
       return  (SideJediClones.size() > 0)? 1: 2;
    }
    
}