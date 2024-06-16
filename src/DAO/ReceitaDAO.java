package DAO;

import Model.Receita;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Classe responsável pelo acesso aos dados da entidade Receita no banco de dados.
 * <p>
 * Esta classe contém métodos para criar, ler, atualizar e deletar receitas,
 * além de buscar receitas por intervalo de datas.
 * </p>
 */
public class ReceitaDAO {
    private Connection connection;

    /**
     * Construtor da classe ReceitaDAO.
     * 
     * @param connection A conexão com o banco de dados.
     */
    public ReceitaDAO(Connection connection) {
        this.connection = connection;
    }

    /**
     * Insere uma nova receita no banco de dados.
     * 
     * @param receita A receita a ser inserida.
     * @throws SQLException Se ocorrer um erro ao acessar o banco de dados.
     */
    public void insert(Receita receita) throws SQLException {
        String sql = "INSERT INTO dbo.Receita (IdUsuario, ValorRecebido, DescReceita, DataRecebimento) VALUES (?, ?, ?, ?)";
        try (Connection conn = ConexãoBanco.conectar();
                PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, receita.getIdUsuario());
            stmt.setBigDecimal(2, receita.getValorRecebido());
            stmt.setString(3, receita.getDescReceita());
            stmt.setDate(4, receita.getDataRecebimento());
            stmt.executeUpdate();
        }
    }

    /**
     * Lê uma receita do banco de dados pelo ID.
     * 
     * @param idReceita O ID da receita a ser lida.
     * @return A receita correspondente ao ID, ou null se não for encontrada.
     * @throws SQLException Se ocorrer um erro ao acessar o banco de dados.
     */
    public static Receita read(int idReceita) throws SQLException {
        String sql = "SELECT * FROM Receita WHERE IdReceita = ?";
        try (Connection conn = ConexãoBanco.conectar();
                PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, idReceita);
            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    return extractReceitaFromResultSet(rs);
                }
            }
        }
        return null;
    }

    /**
     * Lê todas as receitas do banco de dados.
     * 
     * @return Uma lista de todas as receitas.
     * @throws SQLException Se ocorrer um erro ao acessar o banco de dados.
     */
    public List<Receita> findAll() throws SQLException {
        String sql = "SELECT * FROM Receita";
        List<Receita> receitas = new ArrayList<>();
        try (Statement stmt = connection.createStatement(); ResultSet rs = stmt.executeQuery(sql)) {
            while (rs.next()) {
                receitas.add(extractReceitaFromResultSet(rs));
            }
        }
        return receitas;
    }

    /**
     * Busca receitas por intervalo de datas.
     * 
     * @param dataInicial A data inicial do intervalo.
     * @param dataFinal A data final do intervalo.
     * @return Uma lista de receitas dentro do intervalo de datas especificado.
     */
    public List<Receita> findByDateRange(Date dataInicial, Date dataFinal) {
        List<Receita> receitas = new ArrayList<>();
        String sql = "SELECT * FROM Receita WHERE DataRecebimento BETWEEN ? AND ?";

        try (Connection conn = ConexãoBanco.conectar();
                PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setDate(1, dataInicial);
            stmt.setDate(2, dataFinal);
            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {
                Receita receita = new Receita();
                receita.setIdReceita(rs.getInt("IdReceita"));
                receita.setIdUsuario(rs.getInt("IdUsuario"));
                receita.setValorRecebido(rs.getBigDecimal("ValorRecebido"));
                receita.setDescReceita(rs.getString("DescReceita"));
                receita.setDataRecebimento(rs.getDate("DataRecebimento"));
                receitas.add(receita);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return receitas;
    }

    /**
     * Atualiza uma receita existente no banco de dados.
     * 
     * @param receita A receita a ser atualizada.
     * @return true se a atualização foi bem-sucedida, false caso contrário.
     * @throws SQLException Se ocorrer um erro ao acessar o banco de dados.
     */
    public boolean update(Receita receita) throws SQLException {
        String sql = "UPDATE Receita SET ValorRecebido = ?, DescReceita = ?, DataRecebimento = ? WHERE IdReceita = ?";
        try (Connection conn = ConexãoBanco.conectar();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setBigDecimal(1, receita.getValorRecebido());
            stmt.setString(2, receita.getDescReceita());
            stmt.setDate(3, receita.getDataRecebimento());
            stmt.setInt(4, receita.getIdReceita());
            int rowsAffected = stmt.executeUpdate();
            return rowsAffected > 0;
        }
    }

    /**
     * Deleta uma receita do banco de dados.
     * 
     * @param id O ID da receita a ser deletada.
     * @throws SQLException Se ocorrer um erro ao acessar o banco de dados.
     */
    public void delete(int id) throws SQLException {
        String sql = "DELETE FROM Receita WHERE IdReceita = ?";
        try (Connection conn = ConexãoBanco.conectar();
                PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, id);
            stmt.executeUpdate();
        }
    }

    /**
     * Extrai uma receita de um ResultSet.
     * 
     * @param rs O ResultSet de onde a receita será extraída.
     * @return A receita extraída do ResultSet.
     * @throws SQLException Se ocorrer um erro ao acessar o banco de dados.
     */
    private static Receita extractReceitaFromResultSet(ResultSet rs) throws SQLException {
        Receita receita = new Receita();
        receita.setIdReceita(rs.getInt("IdReceita"));
        receita.setIdUsuario((Integer) rs.getObject("IdUsuario"));
        receita.setValorRecebido(rs.getBigDecimal("ValorRecebido"));
        receita.setDescReceita(rs.getString("DescReceita"));
        receita.setDataRecebimento(rs.getDate("DataRecebimento"));
        return receita;
    }
}
