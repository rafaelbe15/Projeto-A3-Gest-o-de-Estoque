package Model;

import java.time.LocalDate;

// Classe que representa a entrada de um produto no estoque :

public class EntradaProduto {

    // Atributos da classe EntradaProduto :

    private int id;
    private int idProduto;
    private int quantidade;
    private LocalDate dataEntrada;
    private String fornecedor;

    // Construtores da classe EntradaProduto :
    // Construtor vazio e construtor com parâmetros

    public EntradaProduto() {
    }

    public EntradaProduto(int id, int idProduto, int quantidade, LocalDate dataEntrada, String fornecedor) {
        this.id = id;
        this.idProduto = idProduto;
        this.quantidade = quantidade;
        this.dataEntrada = dataEntrada;
        this.fornecedor = fornecedor;
    }

    // Getters e Setters para acessar e modificar os atributos da classe EntradaProduto :

    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public int getIdProduto() {
        return idProduto;
    }
    public void setIdProduto(int idProduto) {
        this.idProduto = idProduto;
    }
    public int getQuantidade() {
        return quantidade;
    }
    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }
    public LocalDate getDataEntrada() {
        return dataEntrada;
    }
    public void setDataEntrada(LocalDate dataEntrada) {
        this.dataEntrada = dataEntrada;
    }
    public String getFornecedor() {
        return fornecedor;
    }
    public void setFornecedor(String fornecedor) {
        this.fornecedor = fornecedor;
    }

}