package Controller;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import Data.Database;
import Model.EntradaProduto;

public class EntradaProdutoController {

    public EntradaProdutoController() {
    }

    // Método para obter uma lista de entradas de produtos do banco de dados :

    public List<EntradaProduto> getEntradasProduto() throws SQLException {

        Database.getconnection();
        List<EntradaProduto> entradas = new ArrayList<>();

        String sql = "SELECT * FROM entradaproduto";
        ResultSet rs = null;

        // Executa a consulta SQL e preenche a lista de entradas de produtos :

        try {
            rs = Database.SelectData(sql);
            while (rs.next()) {
                int id = rs.getInt("id");
                int idProduto = rs.getInt("idProduto");
                int quantidade = rs.getInt("quantidade");
                LocalDate dataEntrada = rs.getDate("dataEntrada").toLocalDate();
                String fornecedor = rs.getString("fornecedor");

                EntradaProduto entrada = new EntradaProduto(id, idProduto, quantidade, dataEntrada, fornecedor);
                entradas.add(entrada);
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

        // Retorna a lista de entradas de produtos :

        return entradas;
    }
}


