package DAO;

import Model.Despesa;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * Classe responsável pelo acesso aos dados da entidade Despesa no banco de dados.
 * <p>
 * Esta classe contém métodos para salvar, atualizar, deletar e ler despesas, 
 * além de obter despesas por intervalo de datas.
 * </p>
 */
public class DespesaDAO {
    private Connection conexao;

    /**
     * Construtor da classe DespesaDAO.
     * 
     * @param conexao A conexão com o banco de dados.
     */
    public DespesaDAO(Connection conexao) {
        this.conexao = conexao;
    }

    /**
     * Salva uma nova despesa no banco de dados.
     * 
     * @param despesa A despesa a ser salva.
     * @return true se a despesa foi salva com sucesso, false caso contrário.
     */
    public boolean salvarDespesa(Despesa despesa) {
        String sql = "INSERT INTO Despesa (IdUsuario, ValorPago, DescDespesa, DataFaturamento) " +
                     "VALUES (?, ?, ?, ?)";
        
        try (Connection conn = ConexãoBanco.conectar();
                PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, despesa.getIdUsuario());
            stmt.setString(2, despesa.getValorDespesa());
            stmt.setString(3, despesa.getDescricaoDespesa());
            stmt.setDate(4, despesa.getDataFaturamento());
            
            return stmt.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    /**
     * Obtém uma lista de despesas no intervalo de datas especificado.
     * 
     * @param dataInicial A data inicial do intervalo.
     * @param dataFinal A data final do intervalo.
     * @return Uma lista de despesas no intervalo de datas especificado.
     */
    public List<Despesa> obterDespesasPorIntervalo(Date dataInicial, Date dataFinal) {
        String sql = "SELECT * FROM Despesa WHERE DataFaturamento BETWEEN ? AND ?";
        List<Despesa> despesas = new ArrayList<>();

        try (PreparedStatement stmt = conexao.prepareStatement(sql)) {
            stmt.setDate(1, dataInicial);
            stmt.setDate(2, dataFinal);
            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {
                int id = rs.getInt("IdDespesa");
                int idUsuario = rs.getInt("IdUsuario");
                String descricao = rs.getString("DescDespesa");
                String valorPago = rs.getString("ValorPago");
                Date dataFaturamento = rs.getDate("DataFaturamento");

                Despesa despesa = new Despesa(id, idUsuario, valorPago, descricao, dataFaturamento);
                despesas.add(despesa);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return despesas;
    }

    /**
     * Atualiza uma despesa existente no banco de dados.
     * 
     * @param despesa A despesa a ser atualizada.
     * @return true se a despesa foi atualizada com sucesso, false caso contrário.
     */
    public boolean atualizarDespesa(Despesa despesa) {
        String sql = "UPDATE Despesa SET ValorPago = ?, DescDespesa = ?, DataFaturamento = ? WHERE IdDespesa = ?";
        
        try (Connection conn = ConexãoBanco.conectar();
                PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, despesa.getDescricaoDespesa());
            stmt.setDate(2, despesa.getDataFaturamento());
            stmt.setString(3, despesa.getValorDespesa());
            stmt.setInt(4, despesa.getIdDespesa());

            return stmt.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    /**
     * Deleta uma despesa do banco de dados.
     * 
     * @param idDesp O ID da despesa a ser deletada.
     * @return null após a execução.
     */
    public Despesa delete(int idDesp) {
        String sql = "DELETE FROM Despesa WHERE IdDespesa = ?";
 
        try (Connection conn = ConexãoBanco.conectar();
                PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, idDesp);
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * Lê uma despesa do banco de dados pelo ID.
     * 
     * @param idDesp O ID da despesa a ser lida.
     * @return A despesa correspondente ao ID, ou null se não for encontrada.
     */
    public Despesa read(int idDesp) {
        String sql = "SELECT * FROM Despesa WHERE IdDespesa = ?";
        Despesa despesa = null;
 
        try (Connection conn = ConexãoBanco.conectar();
                PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, idDesp);
            ResultSet rs = stmt.executeQuery();
 
            if (rs.next()) {
                despesa = new Despesa();
                despesa.setIdDespesa(rs.getInt("IdDespesa"));
                despesa.setIdUsuario(rs.getInt("IdUsuario"));
                despesa.setDescricaoDespesa(rs.getString("DescDespesa"));
                despesa.setValorDespesa(rs.getString("ValorPago"));
                despesa.setDataFaturamento(rs.getDate("DataFaturamento"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
 
        return despesa;
    }
}
