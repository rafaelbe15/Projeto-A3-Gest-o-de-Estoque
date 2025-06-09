package Controller;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import Data.Database;
import Model.RelatorioEntrada;

public class RelatorioEntradaController {

    public RelatorioEntradaController() {
    }

    // Método para obter uma lista de relatórios de entrada do banco de dados :

        public List<RelatorioEntrada> getRelatoriosEntrada() throws SQLException {

        Database.getconnection();
        List<RelatorioEntrada> relatorios = new ArrayList<>();

        String sql = "SELECT * FROM relatorioentrada";
        ResultSet rs = null;

        // Executa a consulta SQL e preenche a lista de relatórios de entrada :

        try {
            rs = Database.SelectData(sql);
            while (rs.next()) {
                int id = rs.getInt("id");
                int idEntradaProduto = rs.getInt("idEntradaProduto");
                String tipo = rs.getString("tipo");
                LocalDate dataEmissao = rs.getDate("dataEmissao").toLocalDate();
                String detalhes = rs.getString("detalhes");

                RelatorioEntrada relatorio = new RelatorioEntrada(id, idEntradaProduto, tipo, dataEmissao, detalhes);
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

        // Retorna a lista de relatórios de entrada :

        return relatorios;
    }
}


