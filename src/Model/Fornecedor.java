package Model;

import java.math.BigDecimal;

/**
 * A classe Fornecedor representa um fornecedor com informações de contato e endereço.
 */
public class Fornecedor {
    private int idFornecedor;
    private String NomeFornecedor;
    private String Telefone;
    private String Endereco;
    private String Cidade;
    private String Estado;
    private String EmailForn;
    
    /**
     * Construtor padrão da classe Fornecedor.
     */
    public Fornecedor() {}

    /**
     * Construtor parametrizado da classe Fornecedor.
     *
     * @param idFornecedor   o ID do fornecedor
     * @param NomeFornecedor o nome do fornecedor
     * @param Telefone       o telefone do fornecedor
     * @param Endereco       o endereço do fornecedor
     * @param Cidade         a cidade do fornecedor
     * @param Estado         o estado do fornecedor
     * @param EmailForn      o e-mail do fornecedor
     */
    public Fornecedor(int idFornecedor, String NomeFornecedor, String Telefone, String Endereco, String Cidade, String Estado, String EmailForn) {
        this.idFornecedor = idFornecedor;
        this.NomeFornecedor = NomeFornecedor;
        this.Telefone = Telefone;
        this.Endereco = Endereco;
        this.Cidade = Cidade;
        this.Estado = Estado;
        this.EmailForn = EmailForn;
    }

    /**
     * Obtém o e-mail do fornecedor.
     *
     * @return o e-mail do fornecedor
     */
    public String getEmailForn() {
        return EmailForn;
    }

    /**
     * Define o e-mail do fornecedor.
     *
     * @param emailForn o e-mail do fornecedor
     */
    public void setEmailForn(String emailForn) {
        EmailForn = emailForn;
    }

    /**
     * Obtém o telefone do fornecedor.
     *
     * @return o telefone do fornecedor
     */
    public String getTelefone() {
        return Telefone;
    }

    /**
     * Define o telefone do fornecedor.
     *
     * @param telefone o telefone do fornecedor
     */
    public void setTelefone(String telefone) {
        Telefone = telefone;
    }

    /**
     * Obtém o ID do fornecedor.
     *
     * @return o ID do fornecedor
     */
    public int getIdFornecedor() {
        return idFornecedor;
    }

    /**
     * Define o ID do fornecedor.
     *
     * @param idFornecedor o ID do fornecedor
     */
    public void setIdFornecedor(int idFornecedor) {
        this.idFornecedor = idFornecedor;
    }

    /**
     * Obtém o nome do fornecedor.
     *
     * @return o nome do fornecedor
     */
    public String getNomeFornecedor() {
        return NomeFornecedor;
    }

    /**
     * Define o nome do fornecedor.
     *
     * @param nomeFornecedor o nome do fornecedor
     */
    public void setNomeFornecedor(String nomeFornecedor) {
        NomeFornecedor = nomeFornecedor;
    }

    /**
     * Obtém o endereço do fornecedor.
     *
     * @return o endereço do fornecedor
     */
    public String getEndereco() {
        return Endereco;
    }

    /**
     * Define o endereço do fornecedor.
     *
     * @param endereco o endereço do fornecedor
     */
    public void setEndereco(String endereco) {
        Endereco = endereco;
    }

    /**
     * Obtém a cidade do fornecedor.
     *
     * @return a cidade do fornecedor
     */
    public String getCidade() {
        return Cidade;
    }

    /**
     * Define a cidade do fornecedor.
     *
     * @param cidade a cidade do fornecedor
     */
    public void setCidade(String cidade) {
        Cidade = cidade;
    }

    /**
     * Obtém o estado do fornecedor.
     *
     * @return o estado do fornecedor
     */
    public String getEstado() {
        return Estado;
    }

    /**
     * Define o estado do fornecedor.
     *
     * @param estado o estado do fornecedor
     */
    public void setEstado(String estado) {
        Estado = estado;
    }
}
