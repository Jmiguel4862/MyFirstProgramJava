package mainapplication.controllers;

import mainapplication.models.*;
import  mainapplication.repositorys.querys.FileOfLine;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * BattleSettings
 */
public class BattleSettings {

    private static int[] orderOfBattle = new int[]{0,0};
    private static ArrayList<ArrayList<Guerreiro>> SideJediClones = new ArrayList<>();
    private static ArrayList<ArrayList<Guerreiro>> SideSithDroides = new ArrayList<>();
    private static Guerreiro lastdie = null;
    private static Guerreiro lastattacker = null; 
    private static boolean FirstAttack = false;
    
    public static Guerreiro getLastDie(){
        return lastdie;
    }

    public static Guerreiro getLastAttacker(){
        return lastattacker;
    }

    public static boolean getFirstAttack() {
        return FirstAttack;
    }

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
        return SideSithDroides.get(getOrder(2));
    }

    public static int getOrder(int team){
        return orderOfBattle[team-1];
    }

    public static void setOrder(int team , int neworder){
        if(neworder < 4 && neworder >= 0)
            orderOfBattle[team-1] = neworder;
    }

    public static void pullGuerreiro(int side , int line) {
        ArrayList<Guerreiro> Gs = (side == 1)? SideJediClones.get(line):SideSithDroides.get(line);
        if (Gs.size() < 1)
            return ;
        Guerreiro temp = Gs.removeFirst();
        Gs.add(temp);
    }

    private static void checkKills(ArrayList<ArrayList<Guerreiro>> wholesale ){
        for(int i = 0; i < Constants.MAX_FILES; i++)
            for(int j = 0; j < wholesale.get(i).size(); j++)
                if (wholesale.get(i).get(j).getHp() <= 0)
                    {
                        lastdie = null;
                        lastdie = wholesale.get(i).remove(j);
                    }
    }

    public static void pullSide(int side){
        for (int i = 0; i < Constants.MAX_FILES; i++)
            pullGuerreiro(side, i);
    }

    public static void resetVeriablesBattle(){
        DarkSide.setPreference_hit(-1);
    }
    
    private static boolean LileSettings(ArrayList<ArrayList<Guerreiro>> Gs, int side){
        int i = side -1;
        for(int j = orderOfBattle[i]; j <  Constants.MAX_FILES;j++)
        {
            if (Gs.get(j).size() > 0)
            {
                orderOfBattle[i] = j;
                return true;
            }
        }
        for(int j = (orderOfBattle[i] - 1); j >= 0;j--)
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
        if(!LileSettings(wholesale, sideW ))
            return  false;
        attacker.get(getOrder(side)).getFirst().attack();
        checkKills(wholesale);
        lastattacker = null;
        lastattacker = attacker.get(getOrder(side)).getFirst();
        return true;
    }


    public static void loadingGuerreiros(){
        for (int i = 1; i <= Constants.MAX_FILES; i++) {
            SideJediClones.add(FileOfLine.reader_Guerreiros(1, i));
            SideSithDroides.add(FileOfLine.reader_Guerreiros(2, i));
        }
    }

    public static int hasWinner(){
        boolean ContentLight = false, ContentDark = false;
        for(int j = 0; j < Constants.MAX_FILES; j++)
        {
            if(SideJediClones.get(j).size() > 0 && !ContentLight ) 
                ContentLight = true;
            if(SideSithDroides.get(j).size() > 0 && !ContentDark) 
                ContentDark = true;
            if(ContentLight && ContentDark)
                break;
        }
        return (ContentLight && ContentDark)? 0 : (ContentLight)? 1 : 2;
    }

    public static int battleArena(int side , Scanner scan){
        int winner = hasWinner();
        if(winner != 0)
            return winner;
        for (int j = 0; j < Constants.MAX_FILES; j++) 
        {
            orderOfBattle[0] = j;
            orderOfBattle[1] = j;
            if (j != 0) FirstAttack = false;
            if (side == 1){
                if(!battle(SideJediClones, SideSithDroides , side))
                    continue;
            }
            else {
                if(!battle(SideSithDroides, SideJediClones , side))
                    continue;
            }
            winner = hasWinner();
            System.out.println("\n=========================================\n");
            if(winner != 0)
                return winner;
        }
       return  winner;
    }
}