package View;

import javax.swing.JPanel;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.SwingConstants;

import DAO.DespesaDAO;
import Model.Despesa;

import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JFrame;

import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.sql.Connection;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.math.BigDecimal;

/**
 * This class represents a GUI panel for deleting expense data.
 * It provides the user interface for displaying and deleting expenses.
 */
public class TelaApagarDesp extends JPanel {

    private static final long serialVersionUID = 1L;
    private JTextField textDescDesp;
    private JTextField textDtFaturDesp;
    private JTextField textVlrPagoDesp;
    private JTextField textCodDesp;

    /**
     * Create the panel.
     */
    public TelaApagarDesp() {
        setBackground(new Color(245, 245, 245));
        setLayout(null);

        JLabel lblApagarDesp = new JLabel("Apagar de Dados de Despesas");
        lblApagarDesp.setHorizontalAlignment(SwingConstants.CENTER);
        lblApagarDesp.setForeground(new Color(47, 79, 79));
        lblApagarDesp.setFont(new Font("OCR A Extended", Font.BOLD, 40));
        lblApagarDesp.setBounds(23, 29, 753, 48);
        add(lblApagarDesp);

        JLabel lblNewLabel = new JLabel("Descrição: ");
        lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
        lblNewLabel.setForeground(new Color(47, 79, 79));
        lblNewLabel.setFont(new Font("OCR A Extended", Font.BOLD, 20));
        lblNewLabel.setBounds(182, 162, 144, 47);
        add(lblNewLabel);

        JLabel lblDataDoFaturamento = new JLabel("Data do Faturamento:");
        lblDataDoFaturamento.setHorizontalAlignment(SwingConstants.CENTER);
        lblDataDoFaturamento.setForeground(new Color(47, 79, 79));
        lblDataDoFaturamento.setFont(new Font("OCR A Extended", Font.BOLD, 20));
        lblDataDoFaturamento.setBounds(54, 226, 262, 40);
        add(lblDataDoFaturamento);

        JLabel lblValorPago = new JLabel("Valor Pago: ");
        lblValorPago.setHorizontalAlignment(SwingConstants.CENTER);
        lblValorPago.setForeground(new Color(47, 79, 79));
        lblValorPago.setFont(new Font("OCR A Extended", Font.BOLD, 20));
        lblValorPago.setBounds(161, 276, 172, 47);
        add(lblValorPago);

        textDescDesp = new JTextField();
        textDescDesp.setHorizontalAlignment(SwingConstants.LEFT);
        textDescDesp.setForeground(new Color(0, 0, 0));
        textDescDesp.setFont(new Font("OCR A Extended", Font.PLAIN, 20));
        textDescDesp.setColumns(10);
        textDescDesp.setBackground(Color.WHITE);
        textDescDesp.setBounds(321, 166, 402, 39);
        add(textDescDesp);

        textDtFaturDesp = new JTextField();
        textDtFaturDesp.setHorizontalAlignment(SwingConstants.LEFT);
        textDtFaturDesp.setForeground(new Color(0, 0, 0));
        textDtFaturDesp.setFont(new Font("OCR A Extended", Font.PLAIN, 20));
        textDtFaturDesp.setColumns(10);
        textDtFaturDesp.setBackground(Color.WHITE);
        textDtFaturDesp.setBounds(321, 224, 402, 39);
        add(textDtFaturDesp);

        textVlrPagoDesp = new JTextField();
        textVlrPagoDesp.setHorizontalAlignment(SwingConstants.LEFT);
        textVlrPagoDesp.setForeground(new Color(0, 0, 0));
        textVlrPagoDesp.setFont(new Font("OCR A Extended", Font.PLAIN, 20));
        textVlrPagoDesp.setColumns(10);
        textVlrPagoDesp.setBackground(Color.WHITE);
        textVlrPagoDesp.setBounds(321, 280, 402, 39);
        add(textVlrPagoDesp);

        JButton btnApagar = new JButton("Apagar");
        btnApagar.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                DespesaDAO despesaDAO = new DespesaDAO(null);
                Despesa despesa = new Despesa();

                try {
                    int idDesp = Integer.parseInt(textCodDesp.getText());
                    despesaDAO.delete(idDesp);
                    JOptionPane.showMessageDialog(null, "Despesa deletada com sucesso!");
                    // Clear the text fields after saving
                    textCodDesp.setText("");
                    textDescDesp.setText("");
                    textVlrPagoDesp.setText("");
                    textDtFaturDesp.setText("");
                } catch (Exception ex) {
                    System.out.println("Erro ao formatar número: " + ex.getMessage());
                    JOptionPane.showMessageDialog(null, "Erro ao apagar produto! " + ex.getMessage());
                }
            }
        });
        btnApagar.setForeground(new Color(47, 79, 79));
        btnApagar.setFont(new Font("OCR A Extended", Font.PLAIN, 20));
        btnApagar.setBackground(new Color(245, 245, 245));
        btnApagar.setBounds(417, 360, 117, 31);
        add(btnApagar);

        JButton btnVoltar = new JButton("Voltar");
        btnVoltar.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                JFrame parentFrame = (JFrame) TelaApagarDesp.this.getTopLevelAncestor();
                if (parentFrame != null) {
                    parentFrame.dispose();  // This will close the JFrame
                }
            }
        });
        btnVoltar.setForeground(new Color(47, 79, 79));
        btnVoltar.setFont(new Font("OCR A Extended", Font.PLAIN, 20));
        btnVoltar.setBackground(new Color(245, 245, 245));
        btnVoltar.setBounds(247, 360, 117, 31);
        add(btnVoltar);

        textCodDesp = new JTextField();
        textCodDesp.addFocusListener(new FocusAdapter() {
            @Override
            public void focusLost(FocusEvent e) {
                try {
                    int idDesp = Integer.parseInt(textCodDesp.getText());
                    Connection conexao = null;
                    DespesaDAO despesaDAO = new DespesaDAO(conexao);
                    Despesa despesa = despesaDAO.read(idDesp);

                    if (despesa != null) {
                        textDescDesp.setText(despesa.getDescricaoDespesa());
                        textDtFaturDesp.setText(despesa.getDataFaturamento().toString());
                        textVlrPagoDesp.setText(despesa.getValorDespesa());
                    } else {
                        JOptionPane.showMessageDialog(null, "Despesa não encontrado!", "Erro", JOptionPane.ERROR_MESSAGE);
                    }
                } catch (Exception ex) {
                    ex.printStackTrace();
                }
            }
        });
        textCodDesp.setHorizontalAlignment(SwingConstants.LEFT);
        textCodDesp.setForeground(new Color(0, 0, 0));
        textCodDesp.setFont(new Font("OCR A Extended", Font.PLAIN, 20));
        textCodDesp.setColumns(10);
        textCodDesp.setBackground(Color.WHITE);
        textCodDesp.setBounds(321, 109, 402, 39);
        add(textCodDesp);

        JLabel lblCodDesp = new JLabel("Código:");
        lblCodDesp.setHorizontalAlignment(SwingConstants.CENTER);
        lblCodDesp.setForeground(new Color(47, 79, 79));
        lblCodDesp.setFont(new Font("OCR A Extended", Font.BOLD, 20));
        lblCodDesp.setBounds(194, 105, 144, 47);
        add(lblCodDesp);
    }
    
    public void preencherCampos(String idDespesa, String descricao, String dataFaturamento, String valorDespesa) {
            textCodDesp.setText(idDespesa);
            textDescDesp.setText(descricao);
            textDtFaturDesp.setText(dataFaturamento);
            textVlrPagoDesp.setText(valorDespesa);
}
}
