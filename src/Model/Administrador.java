package Model;

// Classe que representa um administrador do sistema (Singleton):

public class Administrador {

    // Atributos da classe Administrador:
    private int id;
    private String nome;
    private String login;
    private String senha;

    // Instância única (Singleton)
    private static Administrador instancia;

    // Construtor privado para impedir instanciamento externo
    private Administrador() {}

    // Método para obter a instância única
    public static Administrador getInstancia() {
        if (instancia == null) {
            instancia = new Administrador();
        }
        return instancia;
    }

    // Método para configurar os dados do administrador (caso necessário)
    public void configurar(int id, String nome, String login, String senha) {
        this.id = id;
        this.nome = nome;
        this.login = login;
        this.senha = senha;
    }

    // Getters e Setters:
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
