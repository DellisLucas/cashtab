package DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import com.microsoft.sqlserver.jdbc.SQLServerDriver;

/**
 * Classe responsável por gerenciar a conexão com o banco de dados.
 * Utiliza JDBC para conectar a um banco de dados Microsoft SQL Server.
 * <p>
 * Esta classe contém métodos para conectar e desconectar do banco de dados.
 * </p>
 */
public class ConexãoBanco {
    private static final String URL = "jdbc:sqlserver://localhost:1433;databaseName=CASHTAB;encrypt=false";
    private static final String USER = "sa";
    private static final String PASSWORD = "pi";

    static {
        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
        } catch (ClassNotFoundException e) {
            System.err.println("Erro ao carregar o driver JDBC: " + e.getMessage());
        }
    }

    /**
     * Tenta estabelecer uma conexão com o banco de dados.
     * 
     * @return A conexão estabelecida ou null se ocorrer um erro.
     */
    public static Connection conectar() {
        System.out.println("Tentando conectar ao banco de dados...");
        System.out.println("URL: " + URL);
        System.out.println("Usuário: " + USER);
        try {
            Connection conexao = DriverManager.getConnection(URL, USER, PASSWORD);
            System.out.println("Conexão estabelecida com sucesso!");
            return conexao;
        } catch (SQLException e) {
            System.err.println("Erro ao conectar ao banco de dados: " + e.getMessage());
            return null;
        }
    }

    /**
     * Fecha a conexão com o banco de dados.
     * 
     * @param conexao A conexão a ser fechada.
     */
    public static void fecharConexao(Connection conexao) {
        if (conexao != null) {
            try {
                conexao.close();
            } catch (SQLException e) {
                System.err.println("Erro ao fechar a conexão: " + e.getMessage());
            }
        }
    }
}
