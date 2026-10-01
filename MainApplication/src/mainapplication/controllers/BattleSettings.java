package mainapplication.controllers;

import mainapplication.models.*;
import  mainapplication.repositorys.querys.FileOfLine;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.Random;

/**
 * BattleSettings
 */
public class BattleSettings {

    private static int[] orderOfBattle = new int[]{1,1};
    private static ArrayList<ArrayList<Guerreiro>> SideJediClones = new ArrayList<>();
    private static ArrayList<ArrayList<Guerreiro>> SideSithDroides = new ArrayList<>();
    private static boolean FirstOfLine = false;

    public static ArrayList<ArrayList<Guerreiro>> getSideJediClones() {
        return SideJediClones;
    }

    public static ArrayList<ArrayList<Guerreiro>> getSideSithDroides() {
        return SideSithDroides;
    }

    public static  ArrayList<Guerreiro> getCurrentLineJediClones(){
        return SideJediClones.get(getOrder(1));
    }

    public static  ArrayList<Guerreiro> getCurrentLineSithDroides(){
        return SideJediClones.get(getOrder(2));
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
        ArrayList<Guerreiro> Gs = (side == 1)? SideJediClones.get(line):SideSithDroides.get(line);
        if (Gs.size() == 0)
            return ;
        Guerreiro temp = Gs.removeFirst();
        Gs.add(temp);
    }

    private static void pushSide(int side){
        for (int i = 1; i <= Constants.MAX_FILES; i++)
            pushGuerreiro(side, i);
    }

    private static void resetVeriablesBattle(){
        DarkSide.setPreference_hit(0);
    }
    
    private static boolean fileSettings(ArrayList<ArrayList<Guerreiro>> Gs, int side){
        int i = side -1;
        for(int j = orderOfBattle[i]; j <=  Constants.MAX_FILES;j++)
        {
            if (Gs.get(j).size() > 0)
            {
                orderOfBattle[i] = j;
                return true;
            }
        }
        for(int j = (orderOfBattle[i] - 1); j > 0;j--)
        {
            if (Gs.get(j).size() > 0)
            {
                orderOfBattle[i] = j;
                return true;
            }
        }
        return false;
    }

    private static boolean battle(ArrayList<ArrayList<Guerreiro>> attacker ,ArrayList<ArrayList<Guerreiro>> wholesale , int side){
        int sideW= (side==1)?2:1;
        if (attacker.get(getOrder(side)).size() < 1)
            return false;
        if(!fileSettings(wholesale, sideW ))
            return  false;
        attacker.get(getOrder(side)).getFirst().attack(wholesale.get(getOrder(sideW)));
        return true;
    }


    public static void loadingGuerreiros(){
        for (int i = 1; i <= Constants.MAX_FILES; i++) {
            SideJediClones.add(FileOfLine.reader_Guerreiros(1, i));
            SideSithDroides.add(FileOfLine.reader_Guerreiros(2, i));
        }
    }

    public static int battleArena(){  
        Scanner scan = new Scanner(System.in);
        Random ran = new Random();
        boolean firstRound = true;
        int count_defeat = 0;
        while(count_defeat != Constants.MAX_FILES){
            for (int i = 1; i <= 2; i++)
            {
                if (!firstRound)
                {
                    firstRound = false;
                    i = ran.nextInt() / 2 + 1;   
                }
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