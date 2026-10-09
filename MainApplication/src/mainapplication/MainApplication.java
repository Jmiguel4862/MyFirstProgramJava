/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package mainapplication;

import mainapplication.views.*;

import java.io.IOException;
import java.util.Scanner;

import mainapplication.controllers.Generate;
import mainapplication.models.Arena;
/**
 *
 * @author 2025122760081
 */
public class MainApplication {

    /**
     * @param args the command line arguments
     * @throws IOException 
     */
    public static void main(String[] args){
        
        //java.io.File f = new File("MainApplication/src/mainapplication/repositorys/database/fila11.txt");
        //System.out.println("Arquivo existe: " + f.exists());
        Scanner scan = new  Scanner(System.in);
        Arena arena = null;
        if (Generate.createSide(1) && Generate.createSide(2))
        {
            System.out.println("\n <<< CLIQUE EM QUALQUER TECLA PARA CARREGAR OS GUERREIROS >>>");
            scan.nextLine();
            Begin.introduction(arena , scan);
        }
        else
            System.out.println("[ERRO] Programa não conseguiu gerar as filas");
        scan.close();
    }
}