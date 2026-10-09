package mainapplication.models;

import mainapplication.controllers.*;
import mainapplication.views.Presentation;

import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

/**
 * BattleSettings
 */
public class Arena {

    private int[] orderOfBattle = new int[]{0,0};
    private int[] preferenceOrder = new int[] {-1, -1};
    private ArrayList<ArrayList<Guerreiro>> team1 = new ArrayList<>();
    private ArrayList<ArrayList<Guerreiro>> team2 = new ArrayList<>();
    private Guerreiro lastdie = null;
    private Guerreiro lastattacker = null; 
    private boolean firstAttack = false;
    private int winner = 0;

    public Arena (ArrayList<ArrayList<Guerreiro>> team1 , ArrayList<ArrayList<Guerreiro>> team2){
        this.team1 = team1;
        this.team2 = team2;
    }

    public void battleArena(Scanner scan){
        Random ran = new Random();
        int first = ran.nextInt(2)+1, inc = (first == 1)?1:-1;
        this.winner = hasWinner();
        while (winner == 0) {
            for (int i = first;indCpm(inc , i); i += inc)
            {
                if(winner != 0)break;
                if (i == 1)
                    System.out.println("JEDI E CLONES VÃO ATACAR O SITH E OS DROIDES ");
                else 
                    System.out.println("SITH E OS DROIDES VÃO ATACAR O JEDI E CLONES DA FILA");
                for (int j = 0; j < Constants.MAX_FILES; j++) 
                {
                    orderOfBattle[0] = j;
                    orderOfBattle[1] = j;
                    if(j == 0) firstAttack = true;
                    if (i == 1){
                        if(!battle(team1, team2 , i))
                            continue;
                    }
                    else {
                        if(!battle(team2, team1 , i))
                            continue;
                    }
                    if (firstAttack) firstAttack = false;
                    winner = hasWinner();
                    System.out.println("\n=========================================\n");
                    if(winner != 0)
                        break;
                }
            }
            if (winner != 0)
                break;
            this.resetVeriablesBattle();
            Presentation.StatusBattle(this, scan);
            this.pullSide(this.team1);
            this.pullSide(this.team2);
            
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

    public int getWinner(){
        return  winner;
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
        return firstAttack;
    }

    public  ArrayList<ArrayList<Guerreiro>> getTeam1() {
        return team1;
    }

    public  ArrayList<ArrayList<Guerreiro>> getTeam2() {
        return team2;
    }

    public   ArrayList<Guerreiro> getCurrentLineTeam1(){
        return team1.get(getOrder(1));
    }

    public   ArrayList<Guerreiro> getCurrentLineTeam2(){
        return team2.get(getOrder(2));
    }

    public  int getOrder(int team){
        return orderOfBattle[team-1];
    }

    public  void setOrder(int team , int neworder){
        if(neworder < 4 && neworder >= 0)
            orderOfBattle[team-1] = neworder;
    }

    public int getPreferenceOrder(int side){// Função N° 15
        return  preferenceOrder[side-1];
    }

    public void setPreferenceOrder(int side ,int preference){// Função N° 16
        if(side > 2 || side < 1)
            return;
        if (preference >= 0 && preference < Constants.MAX_FILES)
            preferenceOrder[side-1] = preference;
        else 
            preferenceOrder[side-1]= -1;
    }

    private  void pullGuerreiro(ArrayList<Guerreiro> generic) {
        if (generic.size() < 1)
            return ;
        Guerreiro temp = generic.removeFirst();
        generic.add(temp);
    }

    private void checkKills(ArrayList<ArrayList<Guerreiro>> wholesale ){
        for(int i = 0; i < Constants.MAX_FILES; i++)
            for(int j = 0; j < wholesale.get(i).size(); j++)
                if (wholesale.get(i).get(j).getHp() <= 0)
                        this.setLastdie(wholesale.get(i).remove(j));
    }

    private void pullSide(ArrayList<ArrayList<Guerreiro>> generic){
        for (int i = 0; i < Constants.MAX_FILES; i++)
            this.pullGuerreiro(generic.get(i));
    }

    private void resetVeriablesBattle(){
        this.preferenceOrder[0]= -1;
        this.preferenceOrder[1] = -1;
    }
    
    private boolean LileSettings(ArrayList<ArrayList<Guerreiro>> generic, int side){
        int i = side -1;
        for(int j = this.orderOfBattle[i]; j <  Constants.MAX_FILES;j++)
        {
            if (generic.get(j).size() > 0)
            {
                this.orderOfBattle[i] = j;
                return true;
            }
        }
        for(int j = (this.orderOfBattle[i] - 1); j >= 0;j--)
        {
            if (generic.get(j).size() > 0)
            {
                this.orderOfBattle[i] = j;
                return true;
            }
        }
        return false;
    }

    private boolean battle(ArrayList<ArrayList<Guerreiro>> attacker ,ArrayList<ArrayList<Guerreiro>> wholesale , int side){
        int sideW= (side==1)?2:1;
        if (attacker.get(getOrder(side)).size() < 1)
            return false;
        if(!LileSettings(wholesale, sideW ))
            return  false;
        attacker.get(getOrder(side)).getFirst().attack(this);
        checkKills(wholesale);
        lastattacker = null;
        lastattacker = attacker.get(getOrder(side)).getFirst();
        return true;
    }

    private int hasWinner(){
        boolean ContentLight = false, ContentDark = false;
        for(int j = 0; j < Constants.MAX_FILES; j++)
        {
            if(this.team1.get(j).size() > 0 && !ContentLight ) 
                ContentLight = true;
            if(this.team2.get(j).size() > 0 && !ContentDark) 
                ContentDark = true;
            if(ContentLight && ContentDark)
                break;
        }
        return (ContentLight && ContentDark)? 0 : (ContentLight)? 1 : 2;
    }
}