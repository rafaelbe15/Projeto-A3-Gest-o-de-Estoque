package Controller;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import Data.Database;
import Model.RelatorioSaida;

public class RelatorioSaidaController {

    public RelatorioSaidaController() {
    }

    // Método para obter uma lista de relatórios de saída do banco de dados :

    public List<RelatorioSaida> getRelatoriosSaida() throws SQLException {

        Database.getconnection();
        List<RelatorioSaida> relatorios = new ArrayList<>();

        String sql = "SELECT * FROM relatoriosaida";
        ResultSet rs = null;

        // Executa a consulta SQL e preenche a lista de relatórios de saída :

        try {
            rs = Database.SelectData(sql);
            while (rs.next()) {
                int id = rs.getInt("id");
                int idSaidaProduto = rs.getInt("idSaidaProduto");
                String tipo = rs.getString("tipo");
                LocalDate dataEmissao = rs.getDate("dataEmissao").toLocalDate();
                String detalhes = rs.getString("detalhes");

                RelatorioSaida relatorio = new RelatorioSaida(id, idSaidaProduto, tipo, dataEmissao, detalhes);
                relatorios.add(relatorio);
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

        // Retorna a lista de relatórios de saída :

        return relatorios;
    }
}