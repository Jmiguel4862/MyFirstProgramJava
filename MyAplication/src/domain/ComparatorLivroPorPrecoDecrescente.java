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
public class ComparatorLivroPorPrecoDecrescente implements Comparator<Livro>{
    public int compare(Livro o1, Livro o2) {
        return ((-1) * o1.getPreco().compareTo(o2.getPreco()));
    }
}
