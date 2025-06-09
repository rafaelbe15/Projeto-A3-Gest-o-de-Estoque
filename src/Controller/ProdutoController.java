package Controller;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import Data.Database;
import Model.Produto;

public class ProdutoController {

    public ProdutoController() {
    }

    // Método para obter uma lista de produtos do banco de dados :

    public List<Produto> getProdutos() throws SQLException {
        Database.getconnection();
        List<Produto> produtos = new ArrayList<>();
        String sql = "SELECT * FROM produto";
        ResultSet rs = null;

        // Executa a consulta SQL e preenche a lista de produtos :

        try {
            rs = Database.SelectData(sql);
            while (rs.next()) {
                int id = rs.getInt("id");
                String nome = rs.getString("nome");
                String categoria = rs.getString("categoria");
                int quantidade = rs.getInt("quantidade");
                double preco = rs.getDouble("preco");
                Produto produto = new Produto(id, nome, categoria, preco, quantidade);
                produtos.add(produto);
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

        // Retorna a lista de produtos :

        return produtos;
    }
}

