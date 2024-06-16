package Model;

import java.math.BigDecimal;
import java.sql.Date;

/**
 * A classe Receita representa uma receita financeira recebida por um usuário.
 */
public class Receita {
    private int idReceita;
    private int idUsuario;
    private BigDecimal valorRecebido;
    private String descReceita;
    private Date dataRecebimento;

    /**
     * Obtém o ID da receita.
     *
     * @return o ID da receita
     */
    public int getIdReceita() {
        return idReceita;
    }

    /**
     * Define o ID da receita.
     *
     * @param idReceita o ID da receita
     */
    public void setIdReceita(int idReceita) {
        this.idReceita = idReceita;
    }

    /**
     * Obtém o ID do usuário que recebeu a receita.
     *
     * @return o ID do usuário
     */
    public int getIdUsuario() {
        return idUsuario;
    }

    /**
     * Define o ID do usuário que recebeu a receita.
     *
     * @param idUsuario o ID do usuário
     */
    public void setIdUsuario(int idUsuario) {
        this.idUsuario = idUsuario;
    }

    /**
     * Obtém o valor recebido da receita.
     *
     * @return o valor recebido
     */
    public BigDecimal getValorRecebido() {
        return valorRecebido;
    }

    /**
     * Define o valor recebido da receita.
     *
     * @param valorRecebido o valor recebido
     */
    public void setValorRecebido(BigDecimal valorRecebido) {
        this.valorRecebido = valorRecebido;
    }

    /**
     * Obtém a descrição da receita.
     *
     * @return a descrição da receita
     */
    public String getDescReceita() {
        return descReceita;
    }

    /**
     * Define a descrição da receita.
     *
     * @param descReceita a descrição da receita
     */
    public void setDescReceita(String descReceita) {
        this.descReceita = descReceita;
    }

    /**
     * Obtém a data de recebimento da receita.
     *
     * @return a data de recebimento da receita
     */
    public Date getDataRecebimento() {
        return dataRecebimento;
    }

    /**
     * Define a data de recebimento da receita.
     *
     * @param dataRecebimento a data de recebimento da receita
     */
    public void setDataRecebimento(Date dataRecebimento) {
        this.dataRecebimento = dataRecebimento;
    }
}
