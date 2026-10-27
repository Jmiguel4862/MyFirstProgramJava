/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package domain;

import java.util.Comparator;

/**
 *
 * @author Joao Miguel
 */
public class ComparatorFilmePorNomeDecrescente implements Comparator<Filme> {
    public int compare(Filme o1, Filme o2) {
        return ((-1) * o1.getNome().compareTo(o2.getNome()));
    }

}
