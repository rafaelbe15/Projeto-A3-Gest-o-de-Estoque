package Model;

import java.time.LocalDate;

// Classe que representa um relatório de entrada de produtos no estoque :

public class RelatorioEntrada {

    // Atributos da classe RelatorioEntrada :

    private int id;
    private int idEntradaProduto;
    private String tipo;
    private LocalDate dataEmissao;
    private String detalhes;

    // Construtores da classe RelatorioEntrada :
    // Construtor vazio e construtor com parâmetros

    public RelatorioEntrada() {
    }

    public RelatorioEntrada(int id, int idEntradaProduto, String tipo, LocalDate dataEmissao, String detalhes) {
        this.id = id;
        this.idEntradaProduto = idEntradaProduto;
        this.tipo = tipo;
        this.dataEmissao = dataEmissao;
        this.detalhes = detalhes;
    }

    // Getters e Setters para acessar e modificar os atributos da classe RelatorioEntrada :

    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public int getIdEntradaProduto() {
        return idEntradaProduto;
    }
    public void setIdEntradaProduto(int idEntradaProduto) {
        this.idEntradaProduto = idEntradaProduto;
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
