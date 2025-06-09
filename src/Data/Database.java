package Data;

// importação dos pacotes do MySQL :

import java.sql.DriverManager;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.ResultSet;

// Classe que vai conectar o banco de dados ao sistema :

public class Database {

    private final String JDBC_DRIVE = "com.mysql.cj.jdbc.Driver";
    private static final String URL = "jdbc:mysql://localhost:3306/estoque";
    private static final String USER = "root";
    private static final String PASS = "Rafa_151330";

    static Connection dbconn = null;
    static Statement sqlmgr = null;
    static ResultSet rs = null;
    public static String mensagem;

    public static Connection getconnection() throws SQLException {

        if(dbconn == null|| dbconn.isClosed()) {

            connection();

        }
        return dbconn;
    }

    public static void connection() throws SQLException {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            dbconn = DriverManager.getConnection(URL, USER, PASS);
            System.out.println("Conectado ao banco de dados com sucesso em: " + URL);

            sqlmgr = dbconn.createStatement();
        } catch (SQLException | ClassNotFoundException e) {

            mensagem = "Erro ao conectar ao banco de dados: " + e.getMessage();
            System.out.println(mensagem);
            CloseDatabase();

        }
    }

    // Método que finaliza a conexão com o banco de dados :

    public static void CloseDatabase() throws SQLException {
        try {
            if (rs != null) rs.close();
            if(sqlmgr != null) sqlmgr.close();
            if (dbconn != null) dbconn.close();
            System.out.println("Conexão com o banco de dados fechada com sucesso!");
        } catch (SQLException e) {
            mensagem = "Erro ao fechar a conexão com o banco de dados: " + e.getMessage();
            System.out.println(mensagem);
        }
    }

    // Método que insere dados no banco e recebe via sql :
    
    public String InsertData(String sql) {
        try {
            sqlmgr.executeUpdate(sql);
        } catch (SQLException e) {
            mensagem = "Erro ao inserir dados no banco de dados: " + e.getMessage();
            System.out.println(mensagem);
            return mensagem;
        }

        System.out.println("Dados inseridos com sucesso! - " + sql);
        return "Dados inseridos com sucesso!";
    }

    // Método que atualiza os dados no banco via sql :

    public String UpdateData(String sql) {
        try{
            sqlmgr.executeUpdate(sql);
        } catch (SQLException e) {
            mensagem = "Erro ao atualizar dados no banco de dados: " + e.getMessage();
            System.out.println(mensagem);
            return mensagem;
        }
        return "Dados atualizados com sucesso!";
    }

    // Método que deleta dados no banco via sql :

    public String DeleteData(String sql) {
        try {
            sqlmgr.executeUpdate(sql);
        } catch (SQLException e) {
            mensagem = "Erro ao deletar dados no banco de dados: " + e.getMessage();
            System.out.println(mensagem);
            return mensagem;
        }
        return "Dados deletados com sucesso!";
    }

    // Método que consulta no banco via sql :

    public static ResultSet SelectData(String sql) {
        try {
            rs = sqlmgr.executeQuery(sql);
        } catch (SQLException e) {
            mensagem = "Erro ao executar consulta no banco de dados: " + e.getMessage();
            System.out.println(mensagem);
        }
        return rs;
    }
}