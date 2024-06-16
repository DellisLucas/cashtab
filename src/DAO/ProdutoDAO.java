package DAO;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import Model.Produto;

/**
 * Classe responsável pelo acesso aos dados da entidade Produto no banco de dados.
 * <p>
 * Esta classe contém métodos para criar, ler, atualizar e deletar produtos,
 * além de buscar produtos por descrição.
 * </p>
 */
public class ProdutoDAO {
    private Connection conexao;

    /**
     * Construtor da classe ProdutoDAO.
     * 
     * @param conexao A conexão com o banco de dados.
     */
    public ProdutoDAO(Connection conexao) {
        this.conexao = conexao;
    }

    /**
     * Cria um novo produto no banco de dados.
     * 
     * @param produto O produto a ser criado.
     * @param idUsuario O ID do usuário associado ao produto.
     */
    public void create(Produto produto, int idUsuario) {
        String sql = "INSERT INTO Produto (IdUsuario, PrecoUnitario, DescProduto) VALUES (?, ?, ?)";

        try (Connection conn = ConexãoBanco.conectar();
                PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, idUsuario);
            stmt.setBigDecimal(2, produto.getPrecoUnitario());
            stmt.setString(3, produto.getDescProduto());

            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    /**
     * Lê um produto do banco de dados pelo ID.
     * 
     * @param idProduto O ID do produto a ser lido.
     * @return O produto correspondente ao ID, ou null se não for encontrado.
     */
    public Produto read(int idProduto) {
        String sql = "SELECT * FROM Produto WHERE IdProduto = ?";
        Produto produto = null;

        try (Connection conn = ConexãoBanco.conectar();
                PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, idProduto);
            ResultSet rs = stmt.executeQuery();

            if (rs.next()) {
                produto = new Produto();
                produto.setIdProduto(rs.getInt("IdProduto"));
                produto.setIdUsuario(rs.getInt("IdUsuario"));
                produto.setPrecoUnitario(rs.getBigDecimal("PrecoUnitario"));
                produto.setDescProduto(rs.getString("DescProduto"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return produto;
    }

    /**
     * Lê todos os produtos do banco de dados.
     * 
     * @return Uma lista de todos os produtos.
     */
    public List<Produto> readAll() {
        String sql = "SELECT * FROM Produto";
        List<Produto> produtos = new ArrayList<>();

        try (PreparedStatement stmt = conexao.prepareStatement(sql)) {
            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {
                Produto produto = new Produto();
                produto.setIdProduto(rs.getInt("IdProduto"));
                produto.setIdUsuario(rs.getInt("IdUsuario"));
                produto.setPrecoUnitario(rs.getBigDecimal("PrecoUnitario"));
                produto.setDescProduto(rs.getString("DescProduto"));
                produtos.add(produto);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return produtos;
    }

    /**
     * Atualiza um produto existente no banco de dados.
     * 
     * @param produto O produto a ser atualizado.
     */
    public void update(Produto produto) {
        String sql = "UPDATE Produto SET DescProduto = ?, PrecoUnitario = ? WHERE IdProduto = ?";

        try (Connection conn = ConexãoBanco.conectar();
                PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, produto.getDescProduto());
            stmt.setBigDecimal(2, produto.getPrecoUnitario());
            stmt.setInt(3, produto.getIdProduto());
            stmt.executeUpdate();
            ConexãoBanco.fecharConexao(conn);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    /**
     * Deleta um produto do banco de dados.
     * 
     * @param produto O produto a ser deletado.
     */
    public void delete(Produto produto) {
        String sql = "DELETE FROM Produto WHERE IdProduto = ?";

        try (Connection conn = ConexãoBanco.conectar();
                PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, produto.getIdProduto());
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    /**
     * Busca produtos pela descrição.
     * 
     * @param desc A descrição (ou parte dela) dos produtos a serem buscados.
     * @return Uma lista de produtos cuja descrição corresponde ao critério de busca.
     */
    public List<Produto> searchByDescription(String desc) {
        List<Produto> produtos = new ArrayList<>();
        String sql = "SELECT IdProduto, DescProduto, PrecoUnitario FROM Produto WHERE DescProduto LIKE ?";

        try (Connection conn = ConexãoBanco.conectar();
                PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, "%" + desc + "%");
            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {
                Produto produto = new Produto();
                produto.setIdProduto(rs.getInt("IdProduto"));
                produto.setDescProduto(rs.getString("DescProduto"));
                produto.setPrecoUnitario(rs.getBigDecimal("PrecoUnitario"));
                produtos.add(produto);
            }
        } catch (SQLException e) {
            System.out.println("Erro ao buscar produtos: " + e.getMessage());
        }

        return produtos;
    }
}
