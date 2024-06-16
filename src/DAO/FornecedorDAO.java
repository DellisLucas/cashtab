package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import Model.Fornecedor;

/**
 * Classe responsável pelo acesso aos dados da entidade Fornecedor no banco de dados.
 * <p>
 * Esta classe contém métodos para criar, ler, atualizar e deletar fornecedores,
 * além de buscar fornecedores por descrição.
 * </p>
 */
public class FornecedorDAO {
    private Connection conexao;

    /**
     * Construtor da classe FornecedorDAO.
     * 
     * @param conexao A conexão com o banco de dados.
     */
    public FornecedorDAO(Connection conexao) {
        this.conexao = conexao;
    }

    /**
     * Cria um novo fornecedor no banco de dados.
     * 
     * @param fornecedor O fornecedor a ser criado.
     */
    public void create(Fornecedor fornecedor) {
        String sql = "INSERT INTO Fornecedor (NomeFornecedor, Telefone, Endereco, Cidade, Estado, EmailForn) VALUES (?, ?, ?, ?, ?, ?)";

        try (Connection conn = ConexãoBanco.conectar();
                PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, fornecedor.getNomeFornecedor());
            stmt.setString(2, fornecedor.getTelefone());
            stmt.setString(3, fornecedor.getEndereco());
            stmt.setString(4, fornecedor.getCidade());
            stmt.setString(5, fornecedor.getEstado());
            stmt.setString(6, fornecedor.getEmailForn());

            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    /**
     * Lê um fornecedor do banco de dados pelo ID.
     * 
     * @param idFornecedor O ID do fornecedor a ser lido.
     * @return O fornecedor correspondente ao ID, ou null se não for encontrado.
     */
    public Fornecedor read(int idFornecedor) {
        String sql = "SELECT * FROM Fornecedor WHERE IdFornecedor = ?";
        Fornecedor fornecedor = null;

        try (Connection conn = ConexãoBanco.conectar();
                PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, idFornecedor);
            ResultSet rs = stmt.executeQuery();

            if (rs.next()) {
                fornecedor = new Fornecedor();
                fornecedor.setIdFornecedor(rs.getInt("IdFornecedor"));
                fornecedor.setNomeFornecedor(rs.getString("NomeFornecedor"));
                fornecedor.setTelefone(rs.getString("Telefone"));
                fornecedor.setEndereco(rs.getString("Endereco"));
                fornecedor.setCidade(rs.getString("Cidade"));
                fornecedor.setEstado(rs.getString("Estado"));
                fornecedor.setEmailForn(rs.getString("EmailForn"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return fornecedor;
    }

    /**
     * Lê todos os fornecedores do banco de dados.
     * 
     * @return Uma lista de todos os fornecedores.
     */
    public List<Fornecedor> readAll() {
        String sql = "SELECT * FROM Fornecedor";
        List<Fornecedor> fornecedores = new ArrayList<>();

        try (PreparedStatement stmt = conexao.prepareStatement(sql)) {
            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {
                Fornecedor fornecedor = new Fornecedor();
                fornecedor.setIdFornecedor(rs.getInt("IdFornecedor"));
                fornecedor.setNomeFornecedor(rs.getString("NomeFornecedor"));
                fornecedor.setTelefone(rs.getString("Telefone"));
                fornecedor.setEndereco(rs.getString("Endereco"));
                fornecedor.setCidade(rs.getString("Cidade"));
                fornecedor.setEstado(rs.getString("Estado"));
                fornecedor.setEmailForn(rs.getString("EmailForn"));
                fornecedores.add(fornecedor);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return fornecedores;
    }

    /**
     * Atualiza um fornecedor existente no banco de dados.
     * 
     * @param fornecedor O fornecedor a ser atualizado.
     */
    public void update(Fornecedor fornecedor) {
        String sql = "UPDATE Fornecedor SET NomeFornecedor = ?, Telefone = ?, Endereco = ?, Cidade = ?, Estado = ?, EmailForn = ? WHERE IdFornecedor = ?";

        try (Connection conn = ConexãoBanco.conectar();
                PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, fornecedor.getNomeFornecedor());
            stmt.setString(2, fornecedor.getTelefone());
            stmt.setString(3, fornecedor.getEndereco());
            stmt.setString(4, fornecedor.getCidade());
            stmt.setString(5, fornecedor.getEstado());
            stmt.setString(6, fornecedor.getEmailForn());
            stmt.setInt(7, fornecedor.getIdFornecedor());

            stmt.executeUpdate();
            ConexãoBanco.fecharConexao(conn);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    /**
     * Deleta um fornecedor do banco de dados.
     * 
     * @param fornecedor O fornecedor a ser deletado.
     */
    public void delete(Fornecedor fornecedor) {
        String sql = "DELETE FROM Fornecedor WHERE IdFornecedor = ?";

        try (Connection conn = ConexãoBanco.conectar();
                PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, fornecedor.getIdFornecedor());
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    /**
     * Busca fornecedores pelo nome.
     * 
     * @param nomeForn O nome (ou parte dele) dos fornecedores a serem buscados.
     * @return Uma lista de fornecedores cujo nome corresponde ao critério de busca.
     */
    public List<Fornecedor> searchByDescription(String nomeForn) {
        List<Fornecedor> fornecedores = new ArrayList<>();
        String sql = "SELECT IdFornecedor, NomeFornecedor, Telefone, Endereco, Cidade, Estado, EmailForn FROM Fornecedor WHERE NomeFornecedor LIKE ?";

        try (Connection conn = ConexãoBanco.conectar();
                PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, "%" + nomeForn + "%");
            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {
                Fornecedor fornecedor = new Fornecedor();
                fornecedor.setIdFornecedor(rs.getInt("IdFornecedor"));
                fornecedor.setNomeFornecedor(rs.getString("NomeFornecedor"));
                fornecedor.setTelefone(rs.getString("Telefone"));
                fornecedor.setEndereco(rs.getString("Endereco"));
                fornecedor.setCidade(rs.getString("Cidade"));
                fornecedor.setEstado(rs.getString("Estado"));
                fornecedor.setEmailForn(rs.getString("EmailForn"));
                fornecedores.add(fornecedor);
            }
        } catch (SQLException e) {
            System.out.println("Erro ao buscar fornecedores: " + e.getMessage());
        }

        return fornecedores;
    }
}
