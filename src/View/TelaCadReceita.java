package View;

import javax.swing.JPanel;
import javax.swing.JSpinner;
import javax.swing.JLabel;
import java.awt.Font;
import java.util.Calendar;
import java.util.Date;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.SpinnerDateModel;
import javax.swing.JButton;

public class TelaCadReceita extends JPanel {

    private static final long serialVersionUID = 1L;
    private JTextField txtDescricao;
    private JTextField txtValorRecebido;
    private JSpinner dtpData;

    /**
     * Create the panel.
     */
    public TelaCadReceita() {
        setLayout(null);

        JLabel lblTituloCadReceita = new JLabel("Registro de receitas");
        lblTituloCadReceita.setHorizontalAlignment(SwingConstants.CENTER);
        lblTituloCadReceita.setFont(new Font("OCR A Extended", Font.BOLD, 40));
        lblTituloCadReceita.setBounds(138, 0, 515, 112);
        add(lblTituloCadReceita);

        txtDescricao = new JTextField();
        txtDescricao.setColumns(10);
        txtDescricao.setBounds(237, 177, 321, 28);
        add(txtDescricao);

        JLabel lblNewLabel = new JLabel("Descrição");
        lblNewLabel.setFont(new Font("OCR A Extended", Font.BOLD, 18));
        lblNewLabel.setBounds(10, 166, 120, 47);
        add(lblNewLabel);

        JLabel lblDataDoRecebimento = new JLabel("Data do recebimento");
        lblDataDoRecebimento.setFont(new Font("OCR A Extended", Font.BOLD, 18));
        lblDataDoRecebimento.setBounds(10, 227, 231, 40);
        add(lblDataDoRecebimento);

        // Configuração do JSpinner para a seleção da data
        SpinnerDateModel dateModel = new SpinnerDateModel(new Date(), null, null, Calendar.DAY_OF_MONTH);
        dtpData = new JSpinner(dateModel);
        dtpData.setFont(new Font("Tahoma", Font.PLAIN, 19));
        JSpinner.DateEditor de_dtpData = new JSpinner.DateEditor(dtpData, "dd/MM/yyyy");
        dtpData.setEditor(de_dtpData);
        dtpData.setBounds(237, 235, 321, 28);
        add(dtpData);

        txtValorRecebido = new JTextField();
        txtValorRecebido.setColumns(10);
        txtValorRecebido.setBounds(237, 291, 321, 28);
        add(txtValorRecebido);

        JLabel lblValorRecebido = new JLabel("Valor recebido");
        lblValorRecebido.setFont(new Font("OCR A Extended", Font.BOLD, 18));
        lblValorRecebido.setBounds(10, 279, 174, 47);
        add(lblValorRecebido);

        JButton btnSalvar = new JButton("Salvar");
        btnSalvar.setFont(new Font("OCR A Extended", Font.BOLD, 15));
        btnSalvar.setBounds(632, 378, 134, 47);
        add(btnSalvar);
    }
}
