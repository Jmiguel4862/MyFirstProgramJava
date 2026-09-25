/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package mainapplication;

import mainapplication.controllers.*;
import mainapplication.models.Guerreiro;

import java.util.ArrayList;
import java.util.Scanner;
import mainapplication.views.*;
import mainapplication.repositorys.querys.FileOfLine;
import mainapplication.models.*;
/**
 *
 * @author 2025122760081
 */
public class MainApplication {

    /**
     * @param args the command line arguments
     * @throws IOException 
     */
    private static void cleanGuerreiros(int side , int line){
        ArrayList<Guerreiro> Gs = FileOfLine.reader_Guerreiros(side, line);
        Gs.clear();
        FileOfLine.write_Guerreiros(Gs, side, line);
    }
    public static void main(String[] args){
        
        //java.io.File f = new File("MainApplication/src/mainapplication/repositorys/database/fila11.txt");
        //System.out.println("Arquivo existe: " + f.exists());

        Scanner scan= new Scanner(System.in);
        if (Generate.create_Side(1) && Generate.create_Side(2))
        {
            Presentation.presentationGuerreiros();
            System.out.println("\n <<< CLIQUE EM QUALQUER TECLA PARA COMEÇAR AS BATALHAS >>>");
            scan.nextLine();// Espera pelo entrada do usuario
            if(BattleSettings.battleArena() == 1)
                System.out.println("\n <<< OS JEDI & CLONES VENCERAM A BATALHA >>>");
            else
                System.out.println("\n <<< OS SITH &DROIDES VENCERAM A BATALHA >>>");
            scan.close();
        }
        else
            System.out.println("[ERRO] Programa não conseguiu gerar as filas");
    }
}