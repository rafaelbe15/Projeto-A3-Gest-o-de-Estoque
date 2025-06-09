package Model;

import java.time.LocalDate;

// Classe que representa um relatório de saída de produtos do estoque :

public class RelatorioSaida {

    // Atributos da classe RelatorioSaida :

    private int id;
    private int idSaidaProduto;
    private String tipo;
    private LocalDate dataEmissao;
    private String detalhes;

    // Construtores da classe RelatorioSaida :
    // Construtor vazio e construtor com parâmetros

    public RelatorioSaida() {
    }

    public RelatorioSaida(int id, int idSaidaProduto, String tipo, LocalDate dataEmissao, String detalhes) {
        this.id = id;
        this.idSaidaProduto = idSaidaProduto;
        this.tipo = tipo;
        this.dataEmissao = dataEmissao;
        this.detalhes = detalhes;
    }

    // Getters e Setters para acessar e modificar os atributos da classe RelatorioSaida :

    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public int getIdSaidaProduto() {
        return idSaidaProduto;
    }
    public void setIdSaidaPoduto(int idSaidaProduto) {
        this.idSaidaProduto = idSaidaProduto;
    }
    public String getTipo() {
        return tipo;
    }
    public void setTipo(String tipo) {
        this.tipo = tipo;
    }
    public LocalDate getDataEmissao () {
        return dataEmissao;
    }
    public void setDataEmissao(LocalDate dataEmissao) {
        this.dataEmissao = dataEmissao;
    }
    public String getDetalhes() {
        return detalhes;
    }
    public void setDetalhes(String detalhes) {
        this.detalhes = detalhes;
    }
}
