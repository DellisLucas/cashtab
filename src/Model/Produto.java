package Model;

import java.math.BigDecimal;

/**
 * A classe Produto representa um produto com informações de preço e descrição.
 */
public class Produto {
    private int idProduto;
    private int idUsuario;
    private BigDecimal precoUnitario;
    private String descProduto;
    private int idForn;

    /**
     * Construtor padrão da classe Produto.
     */
    public Produto() {}

    /**
     * Construtor parametrizado da classe Produto.
     *
     * @param idProduto     o ID do produto
     * @param idUsuario     o ID do usuário
     * @param precoUnitario o preço unitário do produto
     * @param descProduto   a descrição do produto
     */
    public Produto(int idProduto, int idUsuario, BigDecimal precoUnitario, String descProduto) {
        this.idProduto = idProduto;
        this.idUsuario = idUsuario;
        this.precoUnitario = precoUnitario;
        this.descProduto = descProduto;
    }

    /**
     * Obtém o ID do fornecedor do produto.
     *
     * @return o ID do fornecedor
     */
    public int getIdForn() {
        return idForn;
    }

    /**
     * Define o ID do fornecedor do produto.
     *
     * @param idForn o ID do fornecedor
     */
    public void setIdForn(int idForn) {
        this.idForn = idForn;
    }

    /**
     * Obtém o ID do produto.
     *
     * @return o ID do produto
     */
    public int getIdProduto() {
        return idProduto;
    }

    /**
     * Define o ID do produto.
     *
     * @param idProduto o ID do produto
     */
    public void setIdProduto(int idProduto) {
        this.idProduto = idProduto;
    }

    /**
     * Obtém o ID do usuário que cadastrou o produto.
     *
     * @return o ID do usuário
     */
    public int getIdUsuario() {
        return idUsuario;
    }

    /**
     * Define o ID do usuário que cadastrou o produto.
     *
     * @param idUsuario o ID do usuário
     */
    public void setIdUsuario(int idUsuario) {
        this.idUsuario = idUsuario;
    }

    /**
     * Obtém o preço unitário do produto.
     *
     * @return o preço unitário do produto
     */
    public BigDecimal getPrecoUnitario() {
        return precoUnitario;
    }

    /**
     * Define o preço unitário do produto.
     *
     * @param precoUnitario o preço unitário do produto
     */
    public void setPrecoUnitario(BigDecimal precoUnitario) {
        this.precoUnitario = precoUnitario;
    }

    /**
     * Obtém a descrição do produto.
     *
     * @return a descrição do produto
     */
    public String getDescProduto() {
        return descProduto;
    }

    /**
     * Define a descrição do produto.
     *
     * @param descProduto a descrição do produto
     */
    public void setDescProduto(String descProduto) {
        this.descProduto = descProduto;
    }
}
