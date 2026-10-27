/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package domain;

import java.io.Serializable;


/**
 *
 * @author Giovany
 */
public class Filme implements Serializable {
    private int codigo;
    private String nome, genero, produtora, datacompra;
    private double preco;
    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public String getDatacompra() {
        return datacompra;
    }

    public void setDatacompra(String datacompra) {
        this.datacompra = datacompra;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getProdutora() {
        return produtora;
    }

    public void setProdutora(String produtora) {
        this.produtora = produtora;
    }
    
    public double getPreco(){
        return preco;
    }

    public void setPreco(double preco){
        this.preco = preco;
    }

}
