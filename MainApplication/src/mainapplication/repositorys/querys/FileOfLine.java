/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package mainapplication.repositorys.querys;

import mainapplication.models.Guerreiro;

import java.io.*;
import java.util.Scanner;
import mainapplication.controllers.*;
import java.util.Formatter;
import java.util.ArrayList;

/**
 *
 * @author 2025122760081
 */
public class FileOfLine {
    
    /**
     *
     * @param G
     * @param side
     * @param queue
     * @return 
     */

    public static ArrayList<Guerreiro> reader_Guerreiros( int side, int queue){
       try {
            String line = "MainApplication/src/mainapplication/repositorys/database/fila"+side+ queue +".txt";
            String last[] = null;
            int count = 0;
            Scanner scan = new Scanner(new FileInputStream(line));
            ArrayList<Guerreiro> Gs = new ArrayList<>();
            while (scan.hasNextLine()) 
            {
                last = scan.nextLine().split(",");
                Gs.add(TypeGuerreiro.get_guerreiro(side, last));
                Gs.get(count).setHp(Integer.parseInt(last[4]));
                count++;
            }
            scan.close();
            return (Gs.size() > 0) ? Gs:null;
       } catch (IOException e) {
           System.out.println("\n [ERRO] arquivo não encontrado");
           return null;
       }
    }

    public static boolean write_Guerreiros( ArrayList<Guerreiro> Gs , int side, int queue){
        try {
            String line = "MainApplication/src/mainapplication/repositorys/database/fila"+side+ queue +".txt";
            String guerreiros = null;
            Formatter form;
            if ( Gs == null || Gs.size() == 0)
            {
                form = new Formatter(line);
                form.close();
                return true;
            }
            for (Guerreiro G : Gs)
                guerreiros = (guerreiros == null) ? TypeGuerreiro.get_guerreiro(side, G) + ","+ G.getName() + "," + G.getAge() + "," + G.getWeight() + "," + G.getHp() : guerreiros + "\n" + TypeGuerreiro.get_guerreiro(side, G) + ","+ G.getName() + "," + G.getAge() + "," + G.getWeight() + "," + G.getHp();
            form = new Formatter(line);
            form.format(guerreiros);
            form.close();
            return true;
        } catch (IOException e) {
            System.out.println("\n [ERRO] Programa não conseguiu achar o caminho");
            return false;
        }
    }
}
