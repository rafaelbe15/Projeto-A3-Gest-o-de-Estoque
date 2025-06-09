package Model;

import java.time.LocalDate;

// Classe que representa a saída de um produto do estoque :

public class SaidaProduto {

    // Atributos da classe SaidaProduto :

    private int id;
    private int idProduto;
    private int quantidade;
    private LocalDate dataSaida;
    private String destinatario;

    // Construtores da classe SaidaProduto :
    // Construtor vazio e construtor com parâmetros

    public SaidaProduto() {
    }

    public SaidaProduto(int id, int idProduto, int quantidade, LocalDate dataSaida, String destinatario) {
        this.id = id;
        this.idProduto = idProduto;
        this.quantidade = quantidade;
        this.dataSaida = dataSaida;
        this.destinatario = destinatario;
    }

    // Getters e Setters para acessar e modificar os atributos da classe SaidaProduto :

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
    public LocalDate getDataSaida() {
        return dataSaida;
    }
    public void setDataSaida(LocalDate dataSaida) {
        this.dataSaida = dataSaida;
    }
    public String getDestinatario() {
        return destinatario;
    }
    public void setDestinatario(String destinatario) {
        this.destinatario = destinatario;
    }

}
