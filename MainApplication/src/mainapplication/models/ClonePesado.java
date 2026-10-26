/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package mainapplication.models;

import java.util.ArrayList;

/**
 *
 * @author João Miguel
 */
public class ClonePesado extends LightSide{
    
    public ClonePesado(String name, int age, double weight) {
        super(name, age, (weight + 300), 30, "Clone Pesado");
        this.setHp(400);
        this.setHp_ref(400);
    }

    @Override
    public void alterHp(int alter , Arena arena) {// Função N° 11
        if((this.getHp() + alter) > 0 && arena.getPreferenceOrder(2) >= 0)// verifica se ao alterar a vida do Clone Pesado ele ainda continua vivo e se o Preference Order do time adiversario na rodada.
        {
             System.out.println("\n\n->> [HABILIDADE] enquanto clone pessado estiver vivo ou a rodada acabar o este clone pessado será atacado!!");
        }
        else
        {
            if (arena.getPreferenceOrder(2) >= 0)// Cai nesse else ou se o guerreiro morreu ou a abilidade dele esta ativada se a abilidade tiver ativida
                arena.setPreferenceOrder( 2, arena.getPreferenceOrder(2)-1);// Decrementa a habilidade para ir para o proximo Clone Pesado(>-1) se ouver(-1)
        }
        super.alterHp(alter , arena);
    }
    @Override
    public void attack(Arena arena) {// Função N° 13
        int index;
        ArrayList<Guerreiro> temp;
        super.attack(arena);
        hit(0 , arena);
        if(arena.getFirstAttack())// se for primeiro a atacar
        {
            index = arena.getOrder(1);// pegar a Ordem em que a arena esta
            do{
                index++;// incremente para pega o proximo fila
                if(index >= arena.getQuantityLine()) break;// verifica de passou do numero maximo de Filas daquela arena
                temp = arena.getTeam1().get(index);// pegando o indice da proxima fila
            }while(temp.size() > 0 && temp.getFirst().getClass() == ClonePesado.class);// varifica se tem gente na fila, e se o primeiro da fila e um clone pesado, se sim ele continua para verifica se o proximo tambem é clone pesado.
            arena.setPreferenceOrder(2 , (index-1));//Altera o Ordem de Preferencia do time adversario,como o codigo so para se for mais que 4, (5) ou se o proximo não for um clone pesado ai ele, nos dois casos ele vai precisa decrementar 1 para volta para o clone pesado mais proximo se ouver. 
        }
    }
    
}
