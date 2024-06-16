package DAO;

import Model.Usuario;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Classe responsável pelas operações relacionadas aos usuários no banco de dados.
 */
public class UsuarioDAO {
    private static Connection conexao;

    /**
     * Construtor que inicializa a conexão com o banco de dados.
     *
     * @param conexao A conexão com o banco de dados.
     */
    public UsuarioDAO(Connection conexao) {
        this.conexao = conexao;
    }

    /**
     * Salva um novo usuário no banco de dados.
     *
     * @param usuario O objeto Usuário contendo os dados a serem salvos.
     * @return true se o usuário foi salvo com sucesso, false caso contrário.
     */
    public boolean salvarUsuario(Usuario usuario) {
        String sql = "INSERT INTO Usuario (NomeUsuario, CNPJ, NomeNegocio, MEI, Endereco, Cidade, Estado, Email, Senha) " +
                     "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)";
        
        try (Connection conn = ConexãoBanco.conectar();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, usuario.getNomeUsuario());
            stmt.setString(2, usuario.getCnpj());
            stmt.setString(3, usuario.getNomeNegocio());
            stmt.setString(4, usuario.getMei());
            stmt.setString(5, usuario.getEndereco());
            stmt.setString(6, usuario.getCidade());
            stmt.setString(7, usuario.getEstado());
            stmt.setString(8, usuario.getEmail());
            stmt.setString(9, usuario.getSenha());
            
            return stmt.executeUpdate() > 0; // Retorna true se a inserção foi bem-sucedida
        } catch (SQLException e) {
            e.printStackTrace();
            return false; // Retorna false se ocorreu uma exceção
        }
    }
    
    /**
     * Realiza o login do usuário com base no email e senha fornecidos.
     *
     * @param email O email do usuário.
     * @param senha A senha do usuário.
     * @return O objeto Usuário se as credenciais estiverem corretas, null caso contrário.
     * @throws SQLException Se ocorrer um erro durante a execução da consulta.
     */
    public Usuario login(String email, String senha) throws SQLException {
        String sql = "SELECT * FROM Usuario WHERE email = ? AND senha = ?";
        try (Connection conn = ConexãoBanco.conectar();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, email);
            stmt.setString(2, senha);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                return new Usuario(
                    rs.getInt("idUsuario"),
                    rs.getString("nomeUsuario"),
                    rs.getString("cnpj"),
                    rs.getString("nomeNegocio"),
                    rs.getString("mei"),
                    rs.getString("endereco"),
                    rs.getString("cidade"),
                    rs.getString("estado"),
                    rs.getString("email"),
                    rs.getString("senha")
                );
            } else {
                return null;
            }
        }
    }

    /**
     * Obtém um usuário com base no email fornecido.
     *
     * @param email O email do usuário.
     * @return O objeto Usuário se encontrado, null caso contrário.
     */
    public Usuario getUsuarioByEmail(String email) {
        String sql = "SELECT * FROM Usuario WHERE email = ?";
        try (PreparedStatement stmt = conexao.prepareStatement(sql)) {
            stmt.setString(1, email);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                return new Usuario(
                    rs.getInt("IdUsuario"),
                    rs.getString("nomeUsuario"),
                    rs.getString("cnpj"),
                    rs.getString("nomeNegocio"),
                    rs.getString("mei"),
                    rs.getString("endereco"),
                    rs.getString("cidade"),
                    rs.getString("estado"),
                    rs.getString("email"),
                    rs.getString("senha")
                );
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * Atualiza a senha de um usuário com base no email fornecido.
     *
     * @param email O email do usuário.
     * @param novaSenha A nova senha a ser renovada.
     * @return true se a atualização foi bem-sucedida, false caso contrário.
     */
    public boolean updateSenha(String email, String novaSenha) {
        String sql = "UPDATE Usuario SET senha = ? WHERE email = ?";
        try (PreparedStatement stmt = conexao.prepareStatement(sql)) {
            stmt.setString(1, novaSenha);
            stmt.setString(2, email);
            int rowsUpdated = stmt.executeUpdate();
            return rowsUpdated > 0;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }
}
