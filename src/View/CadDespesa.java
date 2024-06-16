package View;

import javax.swing.*;
import javax.swing.text.NumberFormatter;
import DAO.ConexãoBanco;
import DAO.DespesaDAO;
import Model.Despesa;
import java.awt.*;
import java.awt.event.*;
import java.sql.Connection;
import java.text.NumberFormat;
import java.time.*;
import java.util.*;

/**
 * A classe CadDespesa representa a interface gráfica para o registro de despesas.
 */
public class CadDespesa extends JFrame {

    private static final long serialVersionUID = 1L;
    private JTextField txtDescricao;
    private JSpinner dtpData;
    private JFormattedTextField txtValorPag;
    private JTextField txtUsuario;

    private DespesaDAO despesaDAO;
    private Connection conexao;

    /**
     * Constrói o painel de registro de despesas.
     */
    public CadDespesa() {
        conexao = ConexãoBanco.conectar();
        despesaDAO = new DespesaDAO(conexao);

        getContentPane().setLayout(null);

        JLabel lblTituloCadDespesa = new JLabel("Registro de despesas");
        lblTituloCadDespesa.setHorizontalAlignment(SwingConstants.CENTER);
        lblTituloCadDespesa.setFont(new Font("OCR A Extended", Font.BOLD, 40));
        lblTituloCadDespesa.setBounds(137, 0, 515, 112);
        getContentPane().add(lblTituloCadDespesa);

        txtDescricao = new JTextField();
        txtDescricao.setBounds(237, 177, 321, 28);
        getContentPane().add(txtDescricao);
        txtDescricao.setColumns(10);

        JLabel lblNewLabel = new JLabel("Descrição");
        lblNewLabel.setFont(new Font("OCR A Extended", Font.BOLD, 18));
        lblNewLabel.setBounds(10, 166, 120, 47);
        getContentPane().add(lblNewLabel);

        JLabel lblDataDoFaturamento = new JLabel("Data do faturamento");
        lblDataDoFaturamento.setFont(new Font("OCR A Extended", Font.BOLD, 18));
        lblDataDoFaturamento.setBounds(10, 227, 231, 40);
        getContentPane().add(lblDataDoFaturamento);

        // Configuração do JSpinner para a seleção da data
        SpinnerDateModel dateModel = new SpinnerDateModel(new Date(), null, null, Calendar.DAY_OF_MONTH);
        dtpData = new JSpinner(dateModel);
        dtpData.setFont(new Font("Tahoma", Font.PLAIN, 19));
        JSpinner.DateEditor de_dtpData = new JSpinner.DateEditor(dtpData, "dd/MM/yyyy");
        dtpData.setEditor(de_dtpData);
        dtpData.setBounds(237, 235, 321, 28);
        getContentPane().add(dtpData);

        // Configuração do NumberFormatter para valores monetários
        NumberFormat currencyFormat = NumberFormat.getNumberInstance();
        currencyFormat.setMinimumFractionDigits(2);
        currencyFormat.setMaximumFractionDigits(2);
        NumberFormatter currencyFormatter = new NumberFormatter(currencyFormat);
        currencyFormatter.setAllowsInvalid(false); // Impede a entrada de valores inválidos
        currencyFormatter.setOverwriteMode(true);

        txtValorPag = new JFormattedTextField(currencyFormatter);
        txtValorPag.setColumns(10);
        txtValorPag.setBounds(237, 291, 321, 28);
        getContentPane().add(txtValorPag);

        JLabel lblValorPago = new JLabel("Valor pago");
        lblValorPago.setFont(new Font("OCR A Extended", Font.BOLD, 18));
        lblValorPago.setBounds(10, 279, 120, 47);
        getContentPane().add(lblValorPago);

        JButton btnNewButton = new JButton("Salvar");
        btnNewButton.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                try {
                    int idUsuario = Integer.parseInt(txtUsuario.getText());
                    String desc = txtDescricao.getText();

                    // Obtém a data do componente DateTimePicker
                    Date dataUtil = (Date) dtpData.getValue();

                    // Converte de java.util.Date para java.time.LocalDate
                    Instant instant = dataUtil.toInstant();
                    LocalDateTime dataHora = LocalDateTime.ofInstant(instant, ZoneId.systemDefault());

                    // Converte de LocalDateTime para Date
                    java.sql.Date data = (java.sql.Date) Date.from(dataHora.atZone(ZoneId.systemDefault()).toInstant());

                    // Obtém o valor do campo formatado e converte para String
                    String valor = txtValorPag.getText().replaceAll("[^0-9,]", ""); // Remove caracteres não numéricos exceto a vírgula

                    Despesa despesa = new Despesa(0, idUsuario, valor, desc, data);

                    if (despesaDAO.salvarDespesa(despesa)) {
                        System.out.println("Despesa adicionada com sucesso!");
                        JOptionPane.showMessageDialog(null, "Despesa adicionada com sucesso!");
                        txtDescricao.setText("");
                        txtUsuario.setText("");
                        txtValorPag.setText("");
                    } else {
                        System.out.println("Erro ao adicionar despesa!");
                        JOptionPane.showMessageDialog(null, "Erro ao adicionar despesa!", "Erro", JOptionPane.ERROR_MESSAGE);
                    }
                } catch (NumberFormatException | ClassCastException ex) {
                    ex.printStackTrace();
                    System.out.println("Erro ao converter valores para os tipos de dados corretos.");
                    JOptionPane.showMessageDialog(null, "Erro ao converter valores para os tipos de dados corretos.", "Erro", JOptionPane.ERROR_MESSAGE);
                }
            }
        });
        btnNewButton.setFont(new Font("OCR A Extended", Font.BOLD, 15));
        btnNewButton.setBounds(633, 379, 134, 47);
        getContentPane().add(btnNewButton);

        JLabel lblUsurio = new JLabel("Usuário");
        lblUsurio.setFont(new Font("OCR A Extended", Font.BOLD, 18));
        lblUsurio.setBounds(10, 122, 120, 47);
        getContentPane().add(lblUsurio);

        txtUsuario = new JTextField();
        txtUsuario.setColumns(10);
        txtUsuario.setBounds(237, 133, 321, 28);
        getContentPane().add(txtUsuario);
    }
}
