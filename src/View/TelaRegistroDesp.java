package View;

import javax.swing.JPanel;
import javax.swing.JSpinner;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.text.NumberFormatter;

import DAO.ConexãoBanco;
import DAO.DespesaDAO;
import Model.Despesa;
import Model.Usuario;

import javax.swing.JTextField;
import javax.swing.SpinnerDateModel;
import javax.swing.JButton;
import javax.swing.JFormattedTextField;
import javax.swing.JFrame;

import java.awt.Color;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.Connection;
import java.text.NumberFormat;
import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Calendar;
import java.util.Date;

public class TelaRegistroDesp extends JPanel {

    private static final long serialVersionUID = 1L;
    private JTextField textDescDesp;
    private JSpinner dtpData;
    private JTextField textVlrPagoDesp;
    private JTextField txtUsuario;

    private DespesaDAO despesaDAO;
    private Connection conexao;
    private Usuario usuario;

    /**
     * Create the panel.
     */
    public TelaRegistroDesp(Connection conexao, Usuario usuario) {
        this.conexao = conexao;
        this.usuario = usuario;
        despesaDAO = new DespesaDAO(conexao);
        setLayout(null);

        JLabel lblTituloCadDespesa = new JLabel("Registro de Despesas");
        lblTituloCadDespesa.setForeground(new Color(47, 79, 79));
        lblTituloCadDespesa.setHorizontalAlignment(SwingConstants.CENTER);
        lblTituloCadDespesa.setFont(new Font("OCR A Extended", Font.BOLD, 40));
        lblTituloCadDespesa.setBounds(136, 42, 515, 40);
        add(lblTituloCadDespesa);

        JLabel lblNewLabel = new JLabel("Descrição: ");
        lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
        lblNewLabel.setForeground(new Color(47, 79, 79));
        lblNewLabel.setFont(new Font("OCR A Extended", Font.BOLD, 20));
        lblNewLabel.setBounds(178, 197, 144, 47);
        add(lblNewLabel);

        JLabel lblDataDoFaturamento = new JLabel("Data do Faturamento:");
        lblDataDoFaturamento.setHorizontalAlignment(SwingConstants.CENTER);
        lblDataDoFaturamento.setForeground(new Color(47, 79, 79));
        lblDataDoFaturamento.setFont(new Font("OCR A Extended", Font.BOLD, 20));
        lblDataDoFaturamento.setBounds(52, 255, 262, 40);
        add(lblDataDoFaturamento);

        JLabel lblValorPago = new JLabel("Valor Pago: ");
        lblValorPago.setForeground(new Color(47, 79, 79));
        lblValorPago.setHorizontalAlignment(SwingConstants.CENTER);
        lblValorPago.setFont(new Font("OCR A Extended", Font.BOLD, 20));
        lblValorPago.setBounds(161, 306, 172, 47);
        add(lblValorPago);

        textDescDesp = new JTextField();
        textDescDesp.setHorizontalAlignment(SwingConstants.LEFT);
        textDescDesp.setForeground(new Color(211, 211, 211));
        textDescDesp.setFont(new Font("OCR A Extended", Font.PLAIN, 20));
        textDescDesp.setColumns(10);
        textDescDesp.setBackground(Color.WHITE);
        textDescDesp.setBounds(317, 201, 402, 39);
        add(textDescDesp);

        SpinnerDateModel dateModel = new SpinnerDateModel(new Date(), null, null, Calendar.DAY_OF_MONTH);
        dtpData = new JSpinner(dateModel);
        dtpData.setFont(new Font("Tahoma", Font.PLAIN, 19));
        JSpinner.DateEditor de_dtpData = new JSpinner.DateEditor(dtpData, "dd/MM/yyyy");
        dtpData.setEditor(de_dtpData);
        dtpData.setBounds(317, 260, 402, 39);
        add(dtpData);

        NumberFormat currencyFormat = NumberFormat.getNumberInstance();
        currencyFormat.setMinimumFractionDigits(2);
        currencyFormat.setMaximumFractionDigits(2);
        NumberFormatter currencyFormatter = new NumberFormatter(currencyFormat);
        currencyFormatter.setAllowsInvalid(false); // Impede a entrada de valores inválidos
        currencyFormatter.setOverwriteMode(true);

        textVlrPagoDesp = new JFormattedTextField(currencyFormatter);
        textVlrPagoDesp.setHorizontalAlignment(SwingConstants.LEFT);
        textVlrPagoDesp.setForeground(new Color(211, 211, 211));
        textVlrPagoDesp.setFont(new Font("OCR A Extended", Font.PLAIN, 20));
        textVlrPagoDesp.setColumns(10);
        textVlrPagoDesp.setBackground(Color.WHITE);
        textVlrPagoDesp.setBounds(316, 310, 402, 39);
        add(textVlrPagoDesp);

        JButton btnRegistrar = new JButton("Salvar");
        btnRegistrar.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                try {
                    String desc = textDescDesp.getText();

                    // Obtém a data do componente DateTimePicker
                    Date dataUtil = (Date) dtpData.getValue();

                    // Converte de java.util.Date para java.time.LocalDate
                    Instant instant = dataUtil.toInstant();
                    LocalDateTime dataHora = LocalDateTime.ofInstant(instant, ZoneId.systemDefault());

                    // Converte de LocalDateTime para Date
                    Date data = Date.from(dataHora.atZone(ZoneId.systemDefault()).toInstant());

                    // Obtém o valor do campo formatado e converte para String
                    String valor = textVlrPagoDesp.getText().replaceAll("[^0-9,]", ""); // Remove caracteres não numéricos exceto a vírgula

                    Despesa despesa = new Despesa(0, usuario.getIdUsuario(), valor, desc, data);

                    if (despesaDAO.salvarDespesa(despesa)) {
                        System.out.println("Despesa adicionada com sucesso!");
                        JOptionPane.showMessageDialog(null, "Despesa adicionada com sucesso!");
                        textDescDesp.setText("");
                        textVlrPagoDesp.setText("");
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
        btnRegistrar.setForeground(new Color(47, 79, 79));
        btnRegistrar.setFont(new Font("OCR A Extended", Font.PLAIN, 20));
        btnRegistrar.setBackground(new Color(245, 245, 245));
        btnRegistrar.setBounds(408, 396, 117, 31);
        add(btnRegistrar);

        JButton btnVoltar = new JButton("Voltar");
        btnVoltar.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                JFrame frame = new JFrame();
                frame.setSize(800, 500);
                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                frame.setLocationRelativeTo(null);
                frame.setContentPane(new TelaHome(null));
                frame.setVisible(true);
                TelaRegistroDesp.this.dispose(); // Fecha a tela
            }
        });
        btnVoltar.setForeground(new Color(47, 79, 79));
        btnVoltar.setFont(new Font("OCR A Extended", Font.PLAIN, 20));
        btnVoltar.setBackground(new Color(245, 245, 245));
        btnVoltar.setBounds(243, 396, 117, 31);
        add(btnVoltar);

        JLabel lblUsurio = new JLabel("Usuário:");
        lblUsurio.setHorizontalAlignment(SwingConstants.CENTER);
        lblUsurio.setForeground(new Color(47, 79, 79));
        lblUsurio.setFont(new Font("OCR A Extended", Font.BOLD, 20));
        lblUsurio.setBounds(178, 139, 144, 47);
        add(lblUsurio);

        txtUsuario = new JTextField();
        txtUsuario.setText(usuario.getNomeUsuario()); // Definindo o nome do usuário no campo de texto
        txtUsuario.setHorizontalAlignment(SwingConstants.LEFT);
        txtUsuario.setForeground(new Color(211, 211, 211));
        txtUsuario.setFont(new Font("OCR A Extended", Font.PLAIN, 20));
        txtUsuario.setColumns(10);
        txtUsuario.setBackground(Color.WHITE);
        txtUsuario.setBounds(317, 143, 402, 39);
        txtUsuario.setEditable(false); // Impede que o usuário edite o campo de texto
        add(txtUsuario);
    }

    protected void dispose() {
        // Método dispose
    }
}

