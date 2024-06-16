package Model;

/**
 * A classe Usuario representa um usuário do sistema.
 */
public class Usuario {
    private int idUsuario;
    private String nomeUsuario;
    private String cnpj;
    private String nomeNegocio;
    private String mei;
    private String endereco;
    private String cidade;
    private String estado;
    private String email;
    private String senha;

    /**
     * Construtor sem parâmetros para a classe Usuario.
     */
    public Usuario() {
    }

    /**
     * Construtor com parâmetros para a classe Usuario.
     *
     * @param idUsuario    o ID do usuário
     * @param nomeUsuario  o nome do usuário
     * @param cnpj         o CNPJ do usuário
     * @param nomeNegocio  o nome do negócio do usuário
     * @param mei          se o usuário é MEI
     * @param endereco     o endereço do usuário
     * @param cidade       a cidade do usuário
     * @param estado       o estado do usuário
     * @param email        o e-mail do usuário
     * @param senha        a senha do usuário
     */
    public Usuario(int idUsuario, String nomeUsuario, String cnpj, String nomeNegocio, String mei, String endereco, String cidade, String estado, String email, String senha) {
        this.idUsuario = idUsuario;
        this.nomeUsuario = nomeUsuario;
        this.cnpj = cnpj;
        this.nomeNegocio = nomeNegocio;
        this.mei = mei;
        this.endereco = endereco;
        this.cidade = cidade;
        this.estado = estado;
        this.email = email;
        this.senha = senha;
    }

    /**
     * Construtor simplificado para a classe Usuario (usado para login).
     *
     * @param idUsuario o ID do usuário
     * @param email     o e-mail do usuário
     * @param senha     a senha do usuário
     */
    public Usuario(int idUsuario, String email, String senha) {
        this.idUsuario = idUsuario;
        this.email = email;
        this.senha = senha;
    }

    /**
     * Obtém o ID do usuário.
     *
     * @return o ID do usuário
     */
    public int getIdUsuario() {
        return idUsuario;
    }

    /**
     * Define o ID do usuário.
     *
     * @param idUsuario o ID do usuário
     */
    public void setIdUsuario(int idUsuario) {
        this.idUsuario = idUsuario;
    }

    /**
     * Obtém o nome do usuário.
     *
     * @return o nome do usuário
     */
    public String getNomeUsuario() {
        return nomeUsuario;
    }

    /**
     * Define o nome do usuário.
     *
     * @param nomeUsuario o nome do usuário
     */
    public void setNomeUsuario(String nomeUsuario) {
        this.nomeUsuario = nomeUsuario;
    }

    /**
     * Obtém o CNPJ do usuário.
     *
     * @return o CNPJ do usuário
     */
    public String getCnpj() {
        return cnpj;
    }

    /**
     * Define o CNPJ do usuário.
     *
     * @param cnpj o CNPJ do usuário
     */
    public void setCnpj(String cnpj) {
        this.cnpj = cnpj;
    }

    /**
     * Obtém o nome do negócio do usuário.
     *
     * @return o nome do negócio do usuário
     */
    public String getNomeNegocio() {
        return nomeNegocio;
    }

    /**
     * Define o nome do negócio do usuário.
     *
     * @param nomeNegocio o nome do negócio do usuário
     */
    public void setNomeNegocio(String nomeNegocio) {
        this.nomeNegocio = nomeNegocio;
    }

    /**
     * Obtém a informação se o usuário é MEI.
     *
     * @return se o usuário é MEI
     */
    public String getMei() {
        return mei;
    }

    /**
     * Define a informação se o usuário é MEI.
     *
     * @param mei se o usuário é MEI
     */
    public void setMei(String mei) {
        this.mei = mei;
    }

    /**
     * Obtém o endereço do usuário.
     *
     * @return o endereço do usuário
     */
    public String getEndereco() {
        return endereco;
    }

    /**
     * Define o endereço do usuário.
     *
     * @param endereco o endereço do usuário
     */
    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    /**
     * Obtém a cidade do usuário.
     *
     * @return a cidade do usuário
     */
    public String getCidade() {
        return cidade;
    }

    /**
     * Define a cidade do usuário.
     *
     * @param cidade a cidade do usuário
     */
    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    /**
     * Obtém o estado do usuário.
     *
     * @return o estado do usuário
     */
    public String getEstado() {
        return estado;
    }

    /**
     * Define o estado do usuário.
     *
     * @param estado o estado do usuário
     */
    public void setEstado(String estado) {
        this.estado = estado;
    }

    /**
     * Obtém o e-mail do usuário.
     *
     * @return o e-mail do usuário
     */
    public String getEmail() {
        return email;
    }

    /**
     * Define o e-mail do usuário.
     *
     * @param email o e-mail do usuário
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     * Obtém a senha do usuário.
     *
     * @return a senha do usuário
     */
    public String getSenha() {
        return senha;
    }

    /**
     * Define a senha do usuário.
     *
     * @param senha a senha do usuário
     */
    public void setSenha(String senha) {
        this.senha = senha;
    }
}
