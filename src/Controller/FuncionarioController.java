package Controller;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import Data.Database;
import Model.Funcionario;

public class FuncionarioController {

    public FuncionarioController() {
    }

    //Metodo para obter uma lista de Funcionarios do banco de dados :

    public List<Funcionario> getFuncionarios() throws SQLException {

        Database.getconnection();

        List<Funcionario> funcionarios = new ArrayList<>();

        String sql = "SELECT * FROM funcionario";

        ResultSet rs = null;

        // Executa a consulta SQL e preenche a lista de funcionários :

        try {
            rs = Database.SelectData(sql);
            while (rs.next()) {
                int id = rs.getInt("id");
                String nome = rs.getString("nome");
                String cargo = rs.getString("cargo");
                String login = rs.getString("login");
                String senha = rs.getString("senha");
                Funcionario funcionario = new Funcionario(id, nome, cargo, login, senha);
                funcionarios.add(funcionario);
            }
        } catch (SQLException e) {
            System.out.println("Erro ao processar ResultSet: " + e.getMessage());
            Database.CloseDatabase();
        
        } finally {
            if (rs != null) {
                try {
                    rs.getStatement().close();
                    rs.close();
                    Database.CloseDatabase();
                } catch (SQLException e) {
                    System.out.println("Erro ao fechar ResultSet: " + e.getMessage());
                }
            }
        }

        // Retorna a lista de Funcionarios :

        return funcionarios;
    }

}
