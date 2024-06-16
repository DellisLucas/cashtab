package Cashtab;

import javax.swing.JPanel;
import java.awt.Color;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JButton;
import javax.swing.JTextField;

public class TelaApagarForn extends JPanel {

	private static final long serialVersionUID = 1L;
	private JTextField textTelForn;
	private JTextField textMailForn;
	private JTextField textNomeForn;
	private JTextField textEndForn;
	private JTextField textEstadoForn;
	private JTextField textCidForn;
	private JTextField textCodForn;

	/**
	 * Create the panel.
	 */
	public TelaApagarForn() {
		setBackground(new Color(245, 245, 245));
		setLayout(null);
		
		JLabel lblApagarForn = new JLabel("Apagar Dados de Fornecedores");
		lblApagarForn.setHorizontalAlignment(SwingConstants.CENTER);
		lblApagarForn.setForeground(new Color(47, 79, 79));
		lblApagarForn.setFont(new Font("OCR A Extended", Font.BOLD, 40));
		lblApagarForn.setBackground(Color.BLACK);
		lblApagarForn.setBounds(10, 23, 779, 43);
		add(lblApagarForn);
		
		JButton btnVoltar = new JButton("Voltar");
		btnVoltar.setForeground(new Color(47, 79, 79));
		btnVoltar.setFont(new Font("OCR A Extended", Font.PLAIN, 20));
		btnVoltar.setBackground(new Color(245, 245, 245));
		btnVoltar.setBounds(263, 394, 117, 31);
		add(btnVoltar);
		
		JButton btnApagar = new JButton("Apagar");
		btnApagar.setForeground(new Color(47, 79, 79));
		btnApagar.setFont(new Font("OCR A Extended", Font.PLAIN, 20));
		btnApagar.setBackground(new Color(245, 245, 245));
		btnApagar.setBounds(433, 394, 117, 31);
		add(btnApagar);
		
		textTelForn = new JTextField();
		textTelForn.setHorizontalAlignment(SwingConstants.LEFT);
		textTelForn.setForeground(new Color(211, 211, 211));
		textTelForn.setFont(new Font("OCR A Extended", Font.PLAIN, 20));
		textTelForn.setColumns(10);
		textTelForn.setBackground(Color.WHITE);
		textTelForn.setBounds(253, 237, 402, 39);
		add(textTelForn);
		
		JLabel lblTelefoneForn = new JLabel("Telefone:");
		lblTelefoneForn.setHorizontalAlignment(SwingConstants.CENTER);
		lblTelefoneForn.setForeground(new Color(47, 79, 79));
		lblTelefoneForn.setFont(new Font("OCR A Extended", Font.BOLD, 20));
		lblTelefoneForn.setBackground(Color.BLACK);
		lblTelefoneForn.setBounds(128, 237, 128, 39);
		add(lblTelefoneForn);
		
		JLabel lblEmailForn = new JLabel("E-mail:");
		lblEmailForn.setHorizontalAlignment(SwingConstants.CENTER);
		lblEmailForn.setForeground(new Color(47, 79, 79));
		lblEmailForn.setFont(new Font("OCR A Extended", Font.BOLD, 20));
		lblEmailForn.setBackground(Color.BLACK);
		lblEmailForn.setBounds(148, 187, 115, 39);
		add(lblEmailForn);
		
		textMailForn = new JTextField();
		textMailForn.setHorizontalAlignment(SwingConstants.LEFT);
		textMailForn.setForeground(new Color(211, 211, 211));
		textMailForn.setFont(new Font("OCR A Extended", Font.PLAIN, 20));
		textMailForn.setColumns(10);
		textMailForn.setBackground(Color.WHITE);
		textMailForn.setBounds(253, 187, 402, 39);
		add(textMailForn);
		
		textNomeForn = new JTextField();
		textNomeForn.setHorizontalAlignment(SwingConstants.LEFT);
		textNomeForn.setForeground(new Color(211, 211, 211));
		textNomeForn.setFont(new Font("OCR A Extended", Font.PLAIN, 20));
		textNomeForn.setColumns(10);
		textNomeForn.setBackground(Color.WHITE);
		textNomeForn.setBounds(253, 137, 402, 39);
		add(textNomeForn);
		
		JLabel lblNomeForn = new JLabel("Fornecedor:");
		lblNomeForn.setHorizontalAlignment(SwingConstants.CENTER);
		lblNomeForn.setForeground(new Color(47, 79, 79));
		lblNomeForn.setFont(new Font("OCR A Extended", Font.BOLD, 20));
		lblNomeForn.setBackground(Color.BLACK);
		lblNomeForn.setBounds(107, 137, 145, 39);
		add(lblNomeForn);
		
		JLabel lblEndForn = new JLabel("Endereço:");
		lblEndForn.setHorizontalAlignment(SwingConstants.CENTER);
		lblEndForn.setForeground(new Color(47, 79, 79));
		lblEndForn.setFont(new Font("OCR A Extended", Font.BOLD, 20));
		lblEndForn.setBackground(Color.BLACK);
		lblEndForn.setBounds(128, 287, 128, 39);
		add(lblEndForn);
		
		textEndForn = new JTextField();
		textEndForn.setHorizontalAlignment(SwingConstants.LEFT);
		textEndForn.setForeground(new Color(211, 211, 211));
		textEndForn.setFont(new Font("OCR A Extended", Font.PLAIN, 20));
		textEndForn.setColumns(10);
		textEndForn.setBackground(Color.WHITE);
		textEndForn.setBounds(253, 287, 402, 39);
		add(textEndForn);
		
		textEstadoForn = new JTextField();
		textEstadoForn.setHorizontalAlignment(SwingConstants.LEFT);
		textEstadoForn.setForeground(new Color(211, 211, 211));
		textEstadoForn.setFont(new Font("OCR A Extended", Font.PLAIN, 20));
		textEstadoForn.setColumns(10);
		textEstadoForn.setBackground(Color.WHITE);
		textEstadoForn.setBounds(553, 336, 102, 39);
		add(textEstadoForn);
		
		JLabel lblEstadoForn = new JLabel("Estado:");
		lblEstadoForn.setHorizontalAlignment(SwingConstants.CENTER);
		lblEstadoForn.setForeground(new Color(47, 79, 79));
		lblEstadoForn.setFont(new Font("OCR A Extended", Font.BOLD, 20));
		lblEstadoForn.setBackground(Color.BLACK);
		lblEstadoForn.setBounds(447, 336, 115, 39);
		add(lblEstadoForn);
		
		JLabel lblCidadeForn = new JLabel("Cidade:");
		lblCidadeForn.setHorizontalAlignment(SwingConstants.CENTER);
		lblCidadeForn.setForeground(new Color(47, 79, 79));
		lblCidadeForn.setFont(new Font("OCR A Extended", Font.BOLD, 20));
		lblCidadeForn.setBackground(Color.BLACK);
		lblCidadeForn.setBounds(146, 337, 117, 39);
		add(lblCidadeForn);
		
		textCidForn = new JTextField();
		textCidForn.setHorizontalAlignment(SwingConstants.LEFT);
		textCidForn.setForeground(new Color(211, 211, 211));
		textCidForn.setFont(new Font("OCR A Extended", Font.PLAIN, 20));
		textCidForn.setColumns(10);
		textCidForn.setBackground(Color.WHITE);
		textCidForn.setBounds(253, 337, 202, 39);
		add(textCidForn);
		
		JLabel lblCodForn = new JLabel("Código:");
		lblCodForn.setHorizontalAlignment(SwingConstants.CENTER);
		lblCodForn.setForeground(new Color(47, 79, 79));
		lblCodForn.setFont(new Font("OCR A Extended", Font.BOLD, 20));
		lblCodForn.setBackground(Color.BLACK);
		lblCodForn.setBounds(133, 88, 145, 39);
		add(lblCodForn);
		
		textCodForn = new JTextField();
		textCodForn.setHorizontalAlignment(SwingConstants.LEFT);
		textCodForn.setForeground(new Color(211, 211, 211));
		textCodForn.setFont(new Font("OCR A Extended", Font.PLAIN, 20));
		textCodForn.setColumns(10);
		textCodForn.setBackground(Color.WHITE);
		textCodForn.setBounds(253, 88, 402, 39);
		add(textCodForn);

	}

}
