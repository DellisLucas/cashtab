package Cashtab;

import javax.swing.JPanel;
import java.awt.Color;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.JButton;

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
		textDescDesp.setForeground(new Color(211, 211, 211));
		textDescDesp.setFont(new Font("OCR A Extended", Font.PLAIN, 20));
		textDescDesp.setColumns(10);
		textDescDesp.setBackground(Color.WHITE);
		textDescDesp.setBounds(321, 166, 402, 39);
		add(textDescDesp);
		
		textDtFaturDesp = new JTextField();
		textDtFaturDesp.setHorizontalAlignment(SwingConstants.LEFT);
		textDtFaturDesp.setForeground(new Color(211, 211, 211));
		textDtFaturDesp.setFont(new Font("OCR A Extended", Font.PLAIN, 20));
		textDtFaturDesp.setColumns(10);
		textDtFaturDesp.setBackground(Color.WHITE);
		textDtFaturDesp.setBounds(321, 224, 402, 39);
		add(textDtFaturDesp);
		
		textVlrPagoDesp = new JTextField();
		textVlrPagoDesp.setHorizontalAlignment(SwingConstants.LEFT);
		textVlrPagoDesp.setForeground(new Color(211, 211, 211));
		textVlrPagoDesp.setFont(new Font("OCR A Extended", Font.PLAIN, 20));
		textVlrPagoDesp.setColumns(10);
		textVlrPagoDesp.setBackground(Color.WHITE);
		textVlrPagoDesp.setBounds(321, 280, 402, 39);
		add(textVlrPagoDesp);
		
		JButton btnApagar = new JButton("Apagar");
		btnApagar.setForeground(new Color(47, 79, 79));
		btnApagar.setFont(new Font("OCR A Extended", Font.PLAIN, 20));
		btnApagar.setBackground(new Color(245, 245, 245));
		btnApagar.setBounds(417, 360, 117, 31);
		add(btnApagar);
		
		JButton btnVoltar = new JButton("Voltar");
		btnVoltar.setForeground(new Color(47, 79, 79));
		btnVoltar.setFont(new Font("OCR A Extended", Font.PLAIN, 20));
		btnVoltar.setBackground(new Color(245, 245, 245));
		btnVoltar.setBounds(247, 360, 117, 31);
		add(btnVoltar);
		
		textCodDesp = new JTextField();
		textCodDesp.setHorizontalAlignment(SwingConstants.LEFT);
		textCodDesp.setForeground(new Color(211, 211, 211));
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

}
