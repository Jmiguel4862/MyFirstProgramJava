package mainapplication.controllers;

import mainapplication.models.*;
import mainapplication.repositorys.querys.*;
import mainapplication.repositorys.querys.ManipulationTxt;
import java.util.Random;
import java.util.ArrayList;

public class Generate {
    private static Guerreiro generateGuerreiro(int line , int ind_name) {
        Random rand = new Random();
        String name = ManipulationTxt.ReadTxt(ind_name);
        int age = rand.nextInt(50) + 18; // idade entre 18 e 67
        double weight = rand.nextDouble() * 100 + 50; // peso entre 50 e 150
        String fields[] = {String.valueOf(rand.nextInt(6) + 1), name, String.valueOf(age), String.valueOf(weight)};
        return TypeGuerreiro.get_guerreiro(line, fields);
    }
    private static ArrayList<Guerreiro> generateGuerreiros(int side , ArrayList<Integer> usedIndices) {
        ArrayList<Guerreiro> guerreiros = new ArrayList<>();
        Random rand = new Random();
        for (int i = 1; i <= Constants.MAX_GUERREIROS; i++) {
            int index;
            do {
                index = rand.nextInt(Constants.MAX_NAME_LENGTH);
            } while (usedIndices.contains(index));
            usedIndices.add(index);
            guerreiros.add(generateGuerreiro(side, index));
        }
        return guerreiros;
    }
    public static boolean create_Side(int side) {
    ArrayList<Integer> usedIndices = new ArrayList<>();
    for (int i = 1; i <= Constants.MAX_FILES; i++)
        if(! FileOfLine.write_Guerreiros(Generate.generateGuerreiros(side, usedIndices), side, i))
            return false;
    return true;
}
}
