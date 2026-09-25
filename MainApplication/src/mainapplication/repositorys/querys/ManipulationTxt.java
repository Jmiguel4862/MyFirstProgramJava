package mainapplication.repositorys.querys;

import java.io.IOException;
import java.io.FileInputStream;
import java.util.Scanner;



public class ManipulationTxt {

    public static String ReadTxt(int n){
        try{
            String result = null;
            Scanner scan = new Scanner(new FileInputStream("MainApplication/src/mainapplication/repositorys/database/nomes.txt"));
            for(int i = 0 ; i < n && scan.hasNextLine() ; i++){
                result = scan.nextLine();
            }
            
            scan.close();
            return result;
        }catch(IOException e){
            System.out.println("\n [ERRO] arquivo não encontrado");
            return null;
        }
    }
}
