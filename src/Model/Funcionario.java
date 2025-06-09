package Model;

// Classe que representa um funcionário do sistema :

public class Funcionario {

    // Atributos da classe Funcionario :

    private int id;
    private String nome;
    private String cargo;
    private String login;
    private String senha;

    // Construtores da classe Funcionario :
    // Construtor vazio e construtor com parâmetros

    public Funcionario() {
    }

    public Funcionario(int id, String nome, String cargo, String login, String senha) {
        this.id = id;
        this.nome = nome;
        this.cargo = cargo;
        this.login = login;
        this.senha = senha;
    }

    // Getters e Setters para acessar e modificar os atributos da classe Funcionario :

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
    public String getCargo() {
        return cargo;
    }
    public void setCargo(String cargo) {
        this.cargo = cargo;
    }
    public String getLogin() {
        return login;
    }
    public void setLogin(String login) {
        this.login = login;
    }
    public String getSenha() {
        return senha;
    }
    public void setSenha(String senha) {
        this.senha = senha;
    }
}
