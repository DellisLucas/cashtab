package View;

import javax.swing.JPanel;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JFormattedTextField;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.SpinnerDateModel;
import javax.swing.JSpinner;
import javax.swing.SwingConstants;
import javax.swing.text.NumberFormatter;

import DAO.DespesaDAO;
import Model.Despesa;
import Model.Usuario;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.text.DateFormat;
import java.text.NumberFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Calendar;
import java.util.Date;
import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.SQLException;

public class TelaAtualizarDesp extends JPanel {
	private Usuario usuario;

    private static final long serialVersionUID = 1L;
	private JTextField textDescDesp;
    private JSpinner dtpData;
	private JTextField textVlrPagoDesp;
	private JTextField txtUsuario;
	
    private DespesaDAO despesaDAO;
    private Connection conexao;
	private JComponent btnVoltar;
	private JComponent btnRegistrar;

	public TelaAtualizarDesp(DespesaDAO despesaDAO) {
	    this.despesaDAO = despesaDAO;
        setBackground(new Color(245, 245, 245));
        setLayout(null);

		JLabel lblTituloCadDespesa = new JLabel("Atualizar Despesas");
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
		textDescDesp.setForeground(new Color(0, 0, 0));
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
		textVlrPagoDesp.setForeground(new Color(0, 0, 0));
		textVlrPagoDesp.setFont(new Font("OCR A Extended", Font.PLAIN, 20));
		textVlrPagoDesp.setColumns(10);
		textVlrPagoDesp.setBackground(Color.WHITE);
		textVlrPagoDesp.setBounds(316, 310, 402, 39);
		add(textVlrPagoDesp);
		
		JButton btnAtualizar = new JButton("Salvar");
		btnAtualizar.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                try {
                	int idDesp = Integer.parseInt(txtUsuario.getText());
                	
                    String desc = textDescDesp.getText();

                    // Obtém a data do componente DateTimePicker
                    Date data = new Date(((java.util.Date) dtpData.getValue()).getTime());

                    // Obtém o valor do campo formatado e converte para String
                    String valor = textVlrPagoDesp.getText().replaceAll("[^0-9,]", ""); // Remove caracteres não numéricos exceto a vírgula

                    // Cria a despesa sem a necessidade de referência ao usuário
                    Despesa despesa = new Despesa(idDesp, 1, desc, valor, data);

                    if (despesaDAO.atualizarDespesa(despesa)) {
                        System.out.println("Despesa atualizada com sucesso!");
                        JOptionPane.showMessageDialog(null, "Despesa atualizada com sucesso!");
                        textDescDesp.setText("");
                        textVlrPagoDesp.setText("");
                    } else {
                        System.out.println("Erro ao atualizar despesa!");
                        JOptionPane.showMessageDialog(null, "Erro ao atualizar despesa!", "Erro", JOptionPane.ERROR_MESSAGE);
                    }
                } catch (NumberFormatException | ClassCastException ex) {
                    ex.printStackTrace();
                    System.out.println("Erro ao converter valores para os tipos de dados corretos.");
                    JOptionPane.showMessageDialog(null, "Erro ao converter valores para os tipos de dados corretos.", "Erro", JOptionPane.ERROR_MESSAGE);
                }
            }

        });
		btnAtualizar.setForeground(new Color(47, 79, 79));
		btnAtualizar.setFont(new Font("OCR A Extended", Font.PLAIN, 20));
		btnAtualizar.setBackground(new Color(245, 245, 245));
		btnAtualizar.setBounds(408, 396, 117, 31);
		add(btnAtualizar);

		JButton btnVoltar = new JButton("Voltar");
		btnVoltar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				JFrame parentFrame = (JFrame) TelaAtualizarDesp.this.getTopLevelAncestor();
                if (parentFrame != null) {
                    parentFrame.dispose();  // Isso fechará o JFrame
                }
			}
		});
		btnVoltar.setForeground(new Color(47, 79, 79));
		btnVoltar.setFont(new Font("OCR A Extended", Font.PLAIN, 20));
		btnVoltar.setBackground(new Color(245, 245, 245));
		btnVoltar.setBounds(243, 396, 117, 31);
		add(btnVoltar);
		
		JLabel lblUsurio = new JLabel("Codigo Despesa:");
		lblUsurio.setHorizontalAlignment(SwingConstants.CENTER);
		lblUsurio.setForeground(new Color(47, 79, 79));
		lblUsurio.setFont(new Font("OCR A Extended", Font.BOLD, 20));
		lblUsurio.setBounds(106, 139, 216, 47);
		add(lblUsurio);
		
		txtUsuario = new JTextField();
		txtUsuario.setHorizontalAlignment(SwingConstants.LEFT);
		txtUsuario.setForeground(new Color(0, 0, 0));
		txtUsuario.setFont(new Font("OCR A Extended", Font.PLAIN, 20));
		txtUsuario.setColumns(10);
		txtUsuario.setBackground(Color.WHITE);
		txtUsuario.setBounds(317, 143, 402, 39);
		add(txtUsuario);
    }

    public void preencherCampos(String idUsuario, String descricao, String dataFaturamento, String valorDespesa) {
        try {
            // Tenta converter a data usando diferentes formatos
            Date parsedDate = null;
            String[] formatos = {"dd/MM/yyyy", "yyyy-MM-dd"};
            for (String formato : formatos) {
                try {
                    DateFormat dateFormat = new SimpleDateFormat(formato);
                    parsedDate = dateFormat.parse(dataFaturamento);
                    break;
                } catch (ParseException ignored) {}
            }

            if (parsedDate == null) {
                throw new ParseException("Formato de data não reconhecido: " + dataFaturamento, 0);
            }

            // Limpa o valor monetário
            String valorLimpo = valorDespesa.replace(",", ".").trim();


            // Verifica se o valor contém apenas um ponto decimal
            if (valorLimpo.indexOf('.') != valorLimpo.lastIndexOf('.')) {
                throw new NumberFormatException("O valor contém mais de um ponto decimal.");
            }

            // Verifica se o valor contém apenas caracteres válidos (números e ponto decimal)
            if (!valorLimpo.matches("[0-9.]+")) {
                throw new NumberFormatException("O valor contém caracteres inválidos.");
            }

            // Converte a string do valor para BigDecimal
            BigDecimal parsedValor = new BigDecimal(valorLimpo);

            // Preenche os campos com os valores convertidos
            txtUsuario.setText(idUsuario);
            textDescDesp.setText(descricao);
            dtpData.setValue(parsedDate);
            textVlrPagoDesp.setText(parsedValor.toString());
        } catch (ParseException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(this, "Erro ao formatar a data: " + e.getMessage());
        } catch (NumberFormatException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(this, "Erro ao formatar o valor: " + e.getMessage());
        }
    }

}