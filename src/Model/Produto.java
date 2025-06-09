package Model;

// Classe que representa um produto no sistema :

public class Produto {

// Atributos da classe Produto :

    private int id;
    private String nome;
    private String categoria;
    private double preco;
    private int quantidade;

    // Construtores da classe Produto :
    // Construtor vazio e construtor com parâmetros

    public Produto() {
    }

    public Produto(int id, String nome, String categoria, double preco, int quantidade) {
        this.id = id;
        this.nome = nome;
        this.categoria = categoria;
        this.preco = preco;
        this.quantidade = quantidade;
    }

    // Getters e Setters para acessar e modificar os atributos da classe Produto :
    
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public String getNome() {
        return nome;
    }
    public void setNome(String nome) {
        this.nome = nome;
    }
    public String getCategoria() {
        return categoria;
    }
    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }
    public double getPreco() {
        return preco;
    }
    public void setPreco(double preco) {
        this.preco = preco;
    }
    public int getQuantidade() {
        return quantidade;
    }
    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }
}
