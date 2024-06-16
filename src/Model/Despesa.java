package Model;

import java.sql.Date;

/**
 * A classe Despesa representa uma despesa financeira associada a um usuário.
 */
public class Despesa {
    private int idDespesa;
    private int idUsuario;
    private String valorDespesa;
    private String descricaoDespesa;
    private Date dataFaturamento;
    
    /**
     * Construtor da classe Despesa.
     *
     * @param idDespesa        o ID da despesa
     * @param idUsuario        o ID do usuário associado à despesa
     * @param valorDespesa     o valor da despesa
     * @param descricaoDespesa a descrição da despesa
     * @param data             a data de faturamento da despesa
     */
    public Despesa(int idDespesa, int idUsuario, String valorDespesa, String descricaoDespesa, java.util.Date data) {
        this.idDespesa = idDespesa;
        this.idUsuario = idUsuario;
        this.valorDespesa = valorDespesa;
        this.descricaoDespesa = descricaoDespesa;
        this.dataFaturamento = data != null ? new Date(data.getTime()) : null;
    }

    /**
     * Construtor padrão da classe Despesa.
     */
    public Despesa() {
        // Construtor padrão
    }

    /**
     * Obtém o ID da despesa.
     *
     * @return o ID da despesa
     */
    public int getIdDespesa() {
        return idDespesa;
    }

    /**
     * Define o ID da despesa.
     *
     * @param idDespesa o ID da despesa
     */
    public void setIdDespesa(int idDespesa) {
        this.idDespesa = idDespesa;
    }

    /**
     * Obtém o ID do usuário associado à despesa.
     *
     * @return o ID do usuário
     */
    public int getIdUsuario() {
        return idUsuario;
    }

    /**
     * Define o ID do usuário associado à despesa.
     *
     * @param idUsuario o ID do usuário
     */
    public void setIdUsuario(int idUsuario) {
        this.idUsuario = idUsuario;
    }

    /**
     * Obtém o valor da despesa.
     *
     * @return o valor da despesa
     */
    public String getValorDespesa() {
        return valorDespesa;
    }

    /**
     * Define o valor da despesa.
     *
     * @param valorDespesa o valor da despesa
     */
    public void setValorDespesa(String valorDespesa) {
        this.valorDespesa = valorDespesa;
    }

    /**
     * Obtém a descrição da despesa.
     *
     * @return a descrição da despesa
     */
    public String getDescricaoDespesa() {
        return descricaoDespesa;
    }

    /**
     * Define a descrição da despesa.
     *
     * @param descricaoDespesa a descrição da despesa
     */
    public void setDescricaoDespesa(String descricaoDespesa) {
        this.descricaoDespesa = descricaoDespesa;
    }

    /**
     * Obtém a data de faturamento da despesa.
     *
     * @return a data de faturamento da despesa
     */
    public Date getDataFaturamento() {
        return dataFaturamento;
    }

    /**
     * Define a data de faturamento da despesa.
     *
     * @param dataFaturamento a data de faturamento da despesa
     */
    public void setDataFaturamento(Date dataFaturamento) {
        this.dataFaturamento = dataFaturamento;
    }
}
