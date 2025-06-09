package Controller;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import Data.Database;
import Model.SaidaProduto;

public class SaidaProdutoController {

    public SaidaProdutoController() {
    }

    // Método para obter uma lista de saídas de produtos do banco de dados :

    public List<SaidaProduto> getSaidasProduto() throws SQLException {

        Database.getconnection();
        List<SaidaProduto> saidas = new ArrayList<>();

        String sql = "SELECT * FROM saidaproduto";
        ResultSet rs = null;

        // Executa a consulta SQL e preenche a lista de saídas de produtos :

        try {
            rs = Database.SelectData(sql);
            while (rs.next()) {
                int id = rs.getInt("id");
                int idProduto = rs.getInt("idProduto");
                int quantidade = rs.getInt("quantidade");
                LocalDate dataSaida = rs.getDate("dataSaida").toLocalDate();
                String destinatario = rs.getString("destinatario");

                SaidaProduto saida = new SaidaProduto(id, idProduto, quantidade, dataSaida, destinatario);
                saidas.add(saida);
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

        // Retorna a lista de saídas de produtos :

        return saidas;
    }
}
