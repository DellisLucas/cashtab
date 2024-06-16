package View;

import javax.swing.JPanel;
import javax.swing.JLabel;
import java.awt.Font;
import java.sql.Connection;
import javax.swing.SwingConstants;
import DAO.ReceitaDAO;
import Model.Receita;
import Model.Usuario;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.Color;
import org.jdatepicker.impl.JDatePanelImpl;
import org.jdatepicker.impl.JDatePickerImpl;
import org.jdatepicker.impl.SqlDateModel;
import javax.swing.JFormattedTextField;
import javax.swing.JFrame;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.math.BigDecimal;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Properties;
import javax.swing.JOptionPane;

public class TelaRegistroRec extends JPanel {

    private static final long serialVersionUID = 1L;
    private JTextField textDescRec;
    private JTextField textVlRecebRec;
    private ReceitaDAO receitaDAO;
    private Connection conexao;
    private Usuario usuario;
    private JDatePickerImpl datePicker;

    public TelaRegistroRec(Connection conexao, Usuario usuario) {
        this.conexao = conexao;
        this.usuario = usuario;
        this.receitaDAO = new ReceitaDAO(conexao);
        
        setLayout(null);
        
        JLabel lblTituloCadReceita = new JLabel("Registro de Receitas");
        lblTituloCadReceita.setForeground(new Color(47, 79, 79));
        lblTituloCadReceita.setHorizontalAlignment(SwingConstants.CENTER);
        lblTituloCadReceita.setFont(new Font("OCR A Extended", Font.BOLD, 40));
        lblTituloCadReceita.setBounds(137, 34, 515, 55);
        add(lblTituloCadReceita);
        
        JLabel lblNewLabel = new JLabel("Descrição: ");
        lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
        lblNewLabel.setForeground(new Color(47, 79, 79));
        lblNewLabel.setFont(new Font("OCR A Extended", Font.BOLD, 20));
        lblNewLabel.setBounds(178, 136, 144, 47);
        add(lblNewLabel);
        
        JLabel lblDataDoRecebimento = new JLabel("Data do Recebimento:");
        lblDataDoRecebimento.setHorizontalAlignment(SwingConstants.CENTER);
        lblDataDoRecebimento.setForeground(new Color(47, 79, 79));
        lblDataDoRecebimento.setFont(new Font("OCR A Extended", Font.BOLD, 20));
        lblDataDoRecebimento.setBounds(52, 200, 262, 40);
        add(lblDataDoRecebimento);
        
        JLabel lblValorRecebido = new JLabel("Valor Recebido: ");
        lblValorRecebido.setHorizontalAlignment(SwingConstants.CENTER);
        lblValorRecebido.setForeground(new Color(47, 79, 79));
        lblValorRecebido.setFont(new Font("OCR A Extended", Font.BOLD, 20));
        lblValorRecebido.setBounds(81, 250, 279, 47);
        add(lblValorRecebido);
        
        textDescRec = new JTextField();
        textDescRec.setHorizontalAlignment(SwingConstants.LEFT);
        textDescRec.setForeground(new Color(0, 0, 0));
        textDescRec.setFont(new Font("OCR A Extended", Font.PLAIN, 20));
        textDescRec.setColumns(10);
        textDescRec.setBackground(Color.WHITE);
        textDescRec.setBounds(317, 140, 402, 39);
        add(textDescRec);
        
        textVlRecebRec = new JTextField();
        textVlRecebRec.setHorizontalAlignment(SwingConstants.LEFT);
        textVlRecebRec.setForeground(new Color(0, 0, 0));
        textVlRecebRec.setFont(new Font("OCR A Extended", Font.PLAIN, 20));
        textVlRecebRec.setColumns(10);
        textVlRecebRec.setBackground(Color.WHITE);
        textVlRecebRec.setBounds(317, 254, 402, 39);
        add(textVlRecebRec);
        
        // Configure JDatePicker
        SqlDateModel model = new SqlDateModel();
        Properties p = new Properties();
        p.put("text.today", "Today");
        p.put("text.month", "Month");
        p.put("text.year", "Year");
        JDatePanelImpl datePanel = new JDatePanelImpl(model, p);
        datePicker = new JDatePickerImpl(datePanel, new DateLabelFormatter());
        datePicker.getJFormattedTextField().setFont(new Font("OCR A Extended", Font.PLAIN, 20));
        datePicker.setBounds(317, 200, 402, 40);
        add(datePicker);
        
        JButton btnRegistrar = new JButton("Salvar");
        btnRegistrar.setForeground(new Color(47, 79, 79));
        btnRegistrar.setFont(new Font("OCR A Extended", Font.PLAIN, 20));
        btnRegistrar.setBackground(new Color(245, 245, 245));
        btnRegistrar.setBounds(413, 343, 117, 31);
        add(btnRegistrar);
        
        JButton btnVoltar = new JButton("Voltar");
        btnVoltar.setForeground(new Color(47, 79, 79));
        btnVoltar.setFont(new Font("OCR A Extended", Font.PLAIN, 20));
        btnVoltar.setBackground(new Color(245, 245, 245));
        btnVoltar.setBounds(243, 343, 117, 31);
        add(btnVoltar);

        btnRegistrar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    String descricao = textDescRec.getText();
                    BigDecimal valorRecebido = new BigDecimal(textVlRecebRec.getText());
                    java.sql.Date dataRecebimento = new java.sql.Date(((java.util.Date) datePicker.getModel().getValue()).getTime());
                    
                    Receita receita = new Receita();
                    receita.setIdUsuario(usuario.getIdUsuario());
                    receita.setDescReceita(descricao);
                    receita.setValorRecebido(valorRecebido);
                    receita.setDataRecebimento(dataRecebimento);
                    
                    receitaDAO.insert(receita);
                    
                    JOptionPane.showMessageDialog(null, "Receita registrada com sucesso!");
                    
                    textDescRec.setText("");
                    textVlRecebRec.setText("");
                    datePicker.getModel().setValue(null);
                } catch (Exception ex) {
                    JOptionPane.showMessageDialog(null, "Erro ao registrar receita: " + ex.getMessage());
                }
            }
        });
        
        btnVoltar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
            	JFrame parentFrame = (JFrame) TelaRegistroRec.this.getTopLevelAncestor();
                if (parentFrame != null) {
                    parentFrame.dispose();  // This will close the JFrame
                }
            }
        });
    }
}

class DateLabelFormatter extends JFormattedTextField.AbstractFormatter {

    private String datePattern = "yyyy-MM-dd";
    private SimpleDateFormat dateFormatter = new SimpleDateFormat(datePattern);

    @Override
    public Object stringToValue(String text) throws ParseException {
        return dateFormatter.parseObject(text);
    }

    @Override
    public String valueToString(Object value) throws ParseException {
        if (value != null) {
            Calendar cal = (Calendar) value;
            return dateFormatter.format(cal.getTime());
        }

        return "";
    }
}
