import View.View;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import javax.swing.JOptionPane;

public class conexao {

    private static final String URL = "jdbc:mysql://localhost:3306/estoque";
    private static final String USUARIO = "root"; // Seu usuário do MySQL
    private static final String SENHA = "Rafa_151330"; // AQUI A CORREÇÃO DE "String String" PARA APENAS "String"

    public static Connection conectar() {
        Connection conexao = null;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            conexao = DriverManager.getConnection(URL, USUARIO, SENHA);
        } catch (ClassNotFoundException e) {
            JOptionPane.showMessageDialog(null, "Driver JDBC do MySQL não encontrado! Erro: " + e.getMessage(), "Erro de Driver", JOptionPane.ERROR_MESSAGE);
            e.printStackTrace();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Erro ao conectar com o banco de dados! Erro: " + e.getMessage(), "Erro de Conexão", JOptionPane.ERROR_MESSAGE);
            e.printStackTrace();
        }
        return conexao;
    }

    public static void fecharConexao(Connection conexao) {
        if (conexao != null) {
            try {
                conexao.close();
            } catch (SQLException e) {
                JOptionPane.showMessageDialog(null, "Erro ao fechar a conexão: " + e.getMessage(), "Erro ao Fechar Conexão", JOptionPane.ERROR_MESSAGE);
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args) {
         Connection testConn = conexao.conectar();
        if (testConn != null) {
            JOptionPane.showMessageDialog(null, "Conexão com o banco de dados OK!", "Teste de Conexão", JOptionPane.INFORMATION_MESSAGE);
            View.menu();
        } else {
            JOptionPane.showMessageDialog(null, "Falha na conexão com o banco de dados. Verifique o console para mais detalhes.", "Teste de Conexão", JOptionPane.ERROR_MESSAGE);
        }
    }

}