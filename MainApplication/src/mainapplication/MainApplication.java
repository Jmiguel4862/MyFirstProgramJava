/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package mainapplication;

import java.io.IOException;
import java.util.Scanner;
import mainapplication.views.*;
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
        Scanner scan= new Scanner(System.in);
        Begin.introduction(scan);
        scan.close();
    }
}