/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package mainapplication.controllers;
import mainapplication.models.*;
/**
 *
 * @author 2025122760081
 */
public class TypeGuerreiro {

    public static Guerreiro get_guerreiro(int side, String field[]){
        int type = Integer.parseInt(field[0]);
        String name = field[1];
        int age = Integer.parseInt(field[2]);
        double weight = Double.parseDouble(field[3]);
        if(side == 1)
        {
            return switch (type) {
                case 1 -> new JediMestre(name, age, weight);
                case 2 -> new JediConsular(name, age, weight);
                case 3 -> new JediGeneral(name, age, weight);
                case 4 -> new CloneMedico(name, age, weight);
                case 5 -> new CloneComando(name, age, weight);
                case 6 -> new ClonePesado(name, age, weight);
                default -> null;
            };
        }
        else 
        {
            return switch (type) {
                case 1 -> new DroideBatalhaB2(name, age, weight);
                case 2 -> new DroideAranha(name, age, weight);
                case 3 -> new DroideExterminador(name, age, weight);
                case 4 -> new Acolito(name, age, weight);
                case 5 -> new Assassino(name, age, weight);
                case 6 -> new Lorde(name, age, weight);
                default -> null;
            };
        }
    }
    public static int get_guerreiro(int side, Guerreiro G){
        if(side == 1)
        {
            return switch (G.getClass().getSimpleName()) {
                case "JediMestre" -> 1;
                case "JediConsular" -> 2;
                case "JediGeneral" -> 3;
                case "CloneMedico" -> 4;
                case "CloneComando" -> 5;
                case "ClonePesado" -> 6;
                default -> -1;
            };
        }
        else 
        {
            return switch (G.getClass().getSimpleName()) {
                case "DroideBatalhaB2" -> 1;
                case "DroideAranha" -> 2;
                case "DroideExterminador" -> 3;
                case "Acolito" -> 4;
                case "Assassino" -> 5;
                case "Lorde" -> 6;
                default -> -1;
            };
        }
    }
}


