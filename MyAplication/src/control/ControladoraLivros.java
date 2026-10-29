/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package control;

import dao.*;
import domain.Livro;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Vector;


public class ControladoraLivros {
    private Vector<Livro> livros;
    private int marcador;
    LivroFileDao livroDao;
    
    private String obterNomeColunaBanco(String coluna) {
        if (coluna.equals("Código"))
            return "codigo";
        if (coluna.equals("Nome"))
            return "nome";
        if (coluna.equals("Genero"))
            return "genero";
        if (coluna.equals("Produtora"))
            return "produtora";
        if(coluna.equals("Preco"))
            return "Preco";
        if (coluna.equals("Data Compra"))
            return "datacompra";
        return "id";
    }

    public ControladoraLivros() {
        this.livroDao = new LivroFileDao();
    }
    
    private void atualizarLivro(Livro livro, Vector linha){
        livro.setCodigo(Integer.parseInt(linha.get(0).toString()));
        livro.setNome(linha.get(1).toString());
        livro.setGenero(linha.get(2).toString());
        livro.setProdutora(linha.get(3).toString());
        livro.setPreco(Double.parseDouble(linha.get(4).toString()));
        livro.setDatacompra(linha.get(5).toString());       
    }
    
    private Vector criarLinhaLivro(Livro livro) {
        Vector linha = new Vector();
        linha.addElement(livro.getCodigo());
        linha.addElement(livro.getNome());
        linha.addElement(livro.getGenero());
        linha.addElement(livro.getProdutora());
        linha.addElement(livro.getPreco());
        linha.addElement(livro.getDatacompra());
        return linha;
    }
     
    
    public void inserirNovoLivro(Vector linha) throws FileNotFoundException, IOException, ClassNotFoundException{
        Livro livro = new Livro();
        this.atualizarLivro(livro, linha);
        this.livros.add(livro);
        livroDao.salvarLivros(this.livros);
    }
    
    public void setMarcador(int marcador){
        this.marcador = marcador;
    }

    public void alterarLivro(Vector linha) throws FileNotFoundException, IOException, ClassNotFoundException {
        Livro livro = livros.get(marcador);
        this.atualizarLivro(livro, linha);
        livroDao.salvarLivros(this.livros);
    }
    
    public void  excluirLivro() throws FileNotFoundException, IOException, ClassNotFoundException{
        livros.remove(marcador);
        livroDao.salvarLivros(this.livros);
    }
    
    private Vector<Livro> obterLivros(String coluna, boolean crescente) throws FileNotFoundException, IOException, ClassNotFoundException{
        String nomeColunaBanco = this.obterNomeColunaBanco(coluna);
        livros = livroDao.obterLivros(nomeColunaBanco, crescente);
        return livros; 
    }

    public Vector obterLinhasLivros(String coluna, boolean crescente) throws FileNotFoundException, IOException, ClassNotFoundException {
        Vector<Livro> livros = obterLivros(coluna, crescente);
        Vector linhas = new Vector();
        
        // Montando as linhas
        for(int i = 0; i < livros.size(); i++){
            Livro livro = livros.get(i);
            linhas.addElement(this.criarLinhaLivro(livro));
        }
        return linhas;
    }
}
