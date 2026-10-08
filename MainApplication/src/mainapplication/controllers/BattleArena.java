package mainapplication.controllers;

import mainapplication.models.*;
import  mainapplication.repositorys.querys.FileOfLine;
import mainapplication.views.Presentation;

import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

/**
 * BattleSettings
 */
public class BattleArena {

    private  int[] orderOfBattle = new int[]{0,0};
    private  ArrayList<ArrayList<Guerreiro>> SideJediClones = new ArrayList<>();
    private  ArrayList<ArrayList<Guerreiro>> SideSithDroides = new ArrayList<>();
    private  Guerreiro lastdie = null;
    private  Guerreiro lastattacker = null; 
    private  boolean FirstAttack = false;

    public BattleArena(int side , Scanner scan){
        Random ran = new Random();
        boolean firstRound = true;
        int winner = hasWinner() ,first = ran.nextInt(2)+1, last = (first == 1)?2:1, inc = (first == 1)?1:-1;
        while (winner == 0) {

            for (int i = first;indCpm(inc , i); i += inc)
            {
                if(winner != 0)
                    break;
                if (i == 1)
                    System.out.println("JEDI E CLONES VÃO ATACAR O SITH E OS DROIDES ");
                else 
                    System.out.println("SITH E OS DROIDES VÃO ATACAR O JEDI E CLONES DA FILA");
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
                        break;
                }
            }
            if (winner != 0)
                break;
            BattleArena.resetVeriablesBattle();
            Presentation.StatusBattle(scan);
            BattleArena.pullSide(1);
            BattleArena.pullSide(2);
            
        }
    }

    public static boolean indCpm(int inc , int ind){
        if (inc > 0)
        {
            if (ind <= 2) return true;
            else return false;
        } else {
            if (ind >= 1) return true;
            else return false;
        }
    }

    public void setLastdie(Guerreiro lastdie) {
        this.lastdie = lastdie;
    }

    public void setLastattacker(Guerreiro lastattacker) {
        this.lastattacker = lastattacker;
    }
    
    public  Guerreiro getLastDie(){
        return lastdie;
    }

    public  Guerreiro getLastAttacker(){
        return lastattacker;
    }

    public  boolean getFirstAttack() {
        return FirstAttack;
    }

    public  ArrayList<ArrayList<Guerreiro>> getSideJediClones() {
        return SideJediClones;
    }

    public  ArrayList<ArrayList<Guerreiro>> getSideSithDroides() {
        return SideSithDroides;
    }

    public   ArrayList<Guerreiro> getCurrentLineJediClones(){
        return SideJediClones.get(getOrder(1));
    }

    public   ArrayList<Guerreiro> getCurrentLineSithDroides(){
        return SideSithDroides.get(getOrder(2));
    }

    public  int getOrder(int team){
        return orderOfBattle[team-1];
    }

    public  void setOrder(int team , int neworder){
        if(neworder < 4 && neworder >= 0)
            orderOfBattle[team-1] = neworder;
    }

    public  void pullGuerreiro(int side , int line) {
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
                        wholesale.setLastdie() = null;
                        wholesale.lastdie = wholesale.get(i).remove(j);
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

    public int hasWinner(){
        boolean ContentLight = false, ContentDark = false;
        for(int j = 0; j < Constants.MAX_FILES; j++)
        {
            if(this.SideJediClones.get(j).size() > 0 && !ContentLight ) 
                ContentLight = true;
            if(this.SideSithDroides.get(j).size() > 0 && !ContentDark) 
                ContentDark = true;
            if(ContentLight && ContentDark)
                break;
        }
        return (ContentLight && ContentDark)? 0 : (ContentLight)? 1 : 2;
    }
}