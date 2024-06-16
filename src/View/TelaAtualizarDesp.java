package Cashtab;

import javax.swing.JPanel;
import java.awt.Color;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.JButton;

public class TelaAtualizarDesp extends JPanel {

	private static final long serialVersionUID = 1L;
	private JTextField textDescDesp;
	private JTextField textDtFatur;
	private JTextField textValrPago;
	private JTextField textCodDesp;

	/**
	 * Create the panel.
	 */
	public TelaAtualizarDesp() {
		setBackground(new Color(245, 245, 245));
		setLayout(null);
		
		JLabel lblAtualizarDesp = new JLabel("Atualizar de Dados de Despesas");
		lblAtualizarDesp.setHorizontalAlignment(SwingConstants.CENTER);
		lblAtualizarDesp.setForeground(new Color(47, 79, 79));
		lblAtualizarDesp.setFont(new Font("OCR A Extended", Font.BOLD, 40));
		lblAtualizarDesp.setBounds(20, 25, 753, 48);
		add(lblAtualizarDesp);
		
		JLabel lblNewLabel = new JLabel("Descrição: ");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setForeground(new Color(47, 79, 79));
		lblNewLabel.setFont(new Font("OCR A Extended", Font.BOLD, 20));
		lblNewLabel.setBounds(179, 158, 144, 47);
		add(lblNewLabel);
		
		JLabel lblDataDoFaturamento = new JLabel("Data do Faturamento:");
		lblDataDoFaturamento.setHorizontalAlignment(SwingConstants.CENTER);
		lblDataDoFaturamento.setForeground(new Color(47, 79, 79));
		lblDataDoFaturamento.setFont(new Font("OCR A Extended", Font.BOLD, 20));
		lblDataDoFaturamento.setBounds(51, 222, 262, 40);
		add(lblDataDoFaturamento);
		
		JLabel lblValorPago = new JLabel("Valor Pago: ");
		lblValorPago.setHorizontalAlignment(SwingConstants.CENTER);
		lblValorPago.setForeground(new Color(47, 79, 79));
		lblValorPago.setFont(new Font("OCR A Extended", Font.BOLD, 20));
		lblValorPago.setBounds(158, 272, 172, 47);
		add(lblValorPago);
		
		textDescDesp = new JTextField();
		textDescDesp.setHorizontalAlignment(SwingConstants.LEFT);
		textDescDesp.setForeground(new Color(211, 211, 211));
		textDescDesp.setFont(new Font("OCR A Extended", Font.PLAIN, 20));
		textDescDesp.setColumns(10);
		textDescDesp.setBackground(Color.WHITE);
		textDescDesp.setBounds(318, 162, 402, 39);
		add(textDescDesp);
		
		textDtFatur = new JTextField();
		textDtFatur.setHorizontalAlignment(SwingConstants.LEFT);
		textDtFatur.setForeground(new Color(211, 211, 211));
		textDtFatur.setFont(new Font("OCR A Extended", Font.PLAIN, 20));
		textDtFatur.setColumns(10);
		textDtFatur.setBackground(Color.WHITE);
		textDtFatur.setBounds(318, 220, 402, 39);
		add(textDtFatur);
		
		textValrPago = new JTextField();
		textValrPago.setHorizontalAlignment(SwingConstants.LEFT);
		textValrPago.setForeground(new Color(211, 211, 211));
		textValrPago.setFont(new Font("OCR A Extended", Font.PLAIN, 20));
		textValrPago.setColumns(10);
		textValrPago.setBackground(Color.WHITE);
		textValrPago.setBounds(318, 276, 402, 39);
		add(textValrPago);
		
		JButton btnRegistrar = new JButton("Salvar");
		btnRegistrar.setForeground(new Color(47, 79, 79));
		btnRegistrar.setFont(new Font("OCR A Extended", Font.PLAIN, 20));
		btnRegistrar.setBackground(new Color(245, 245, 245));
		btnRegistrar.setBounds(414, 356, 117, 31);
		add(btnRegistrar);
		
		JButton btnVoltar = new JButton("Voltar");
		btnVoltar.setForeground(new Color(47, 79, 79));
		btnVoltar.setFont(new Font("OCR A Extended", Font.PLAIN, 20));
		btnVoltar.setBackground(new Color(245, 245, 245));
		btnVoltar.setBounds(244, 356, 117, 31);
		add(btnVoltar);
		
		textCodDesp = new JTextField();
		textCodDesp.setHorizontalAlignment(SwingConstants.LEFT);
		textCodDesp.setForeground(new Color(211, 211, 211));
		textCodDesp.setFont(new Font("OCR A Extended", Font.PLAIN, 20));
		textCodDesp.setColumns(10);
		textCodDesp.setBackground(Color.WHITE);
		textCodDesp.setBounds(318, 105, 402, 39);
		add(textCodDesp);
		
		JLabel lblCodDesp = new JLabel("Código:");
		lblCodDesp.setHorizontalAlignment(SwingConstants.CENTER);
		lblCodDesp.setForeground(new Color(47, 79, 79));
		lblCodDesp.setFont(new Font("OCR A Extended", Font.BOLD, 20));
		lblCodDesp.setBounds(191, 101, 144, 47);
		add(lblCodDesp);

	}
}
