package mainapplication.controllers;

import mainapplication.repositorys.querys.FileOfLine;
import mainapplication.models.*;
import java.util.ArrayList;


public class InsertGuerreiros {
        public static Arena loadingGuerreiros(){
        ArrayList<ArrayList<Guerreiro>> team1 = new ArrayList<>() , team2 = new  ArrayList<>();
        for (int i = 1; i <= Constants.MAX_FILES; i++) {
            team1.add(FileOfLine.readerGuerreiros(1, i));
            team2.add(FileOfLine.readerGuerreiros(2, i));
        }
        return new Arena(team1 , team2);
    }
}
