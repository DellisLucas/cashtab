package Cashtab;

import javax.swing.JPanel;
import java.awt.Color;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.JButton;

public class TelaApagarProd extends JPanel {

	private static final long serialVersionUID = 1L;
	private JTextField textCodProd;
	private JTextField textNomeProd;
	private JTextField textPrecUnitProd;
	private JTextField textFornProd;

	/**
	 * Create the panel.
	 */
	public TelaApagarProd() {
		setBackground(new Color(245, 245, 245));
		setLayout(null);
		
		JLabel lblApagarrProd = new JLabel("Apagar Dados de Produtos");
		lblApagarrProd.setForeground(new Color(47, 79, 79));
		lblApagarrProd.setFont(new Font("OCR A Extended", Font.BOLD, 40));
		lblApagarrProd.setBounds(96, 22, 617, 48);
		add(lblApagarrProd);
		
		JLabel lblCodProd = new JLabel("Código:");
		lblCodProd.setHorizontalAlignment(SwingConstants.CENTER);
		lblCodProd.setForeground(new Color(47, 79, 79));
		lblCodProd.setFont(new Font("OCR A Extended", Font.BOLD, 20));
		lblCodProd.setBackground(Color.BLACK);
		lblCodProd.setBounds(109, 98, 182, 39);
		add(lblCodProd);
		
		textCodProd = new JTextField();
		textCodProd.setHorizontalAlignment(SwingConstants.LEFT);
		textCodProd.setForeground(new Color(211, 211, 211));
		textCodProd.setFont(new Font("OCR A Extended", Font.PLAIN, 20));
		textCodProd.setColumns(10);
		textCodProd.setBackground(Color.WHITE);
		textCodProd.setBounds(254, 98, 402, 39);
		add(textCodProd);
		
		JLabel lblNomeProd = new JLabel("Produto: ");
		lblNomeProd.setHorizontalAlignment(SwingConstants.CENTER);
		lblNomeProd.setForeground(new Color(47, 79, 79));
		lblNomeProd.setFont(new Font("OCR A Extended", Font.BOLD, 20));
		lblNomeProd.setBackground(Color.BLACK);
		lblNomeProd.setBounds(109, 161, 182, 39);
		add(lblNomeProd);
		
		textNomeProd = new JTextField();
		textNomeProd.setHorizontalAlignment(SwingConstants.LEFT);
		textNomeProd.setForeground(new Color(211, 211, 211));
		textNomeProd.setFont(new Font("OCR A Extended", Font.PLAIN, 20));
		textNomeProd.setColumns(10);
		textNomeProd.setBackground(Color.WHITE);
		textNomeProd.setBounds(254, 161, 402, 39);
		add(textNomeProd);
		
		JLabel lblPrecProd = new JLabel("Preço Unitário: ");
		lblPrecProd.setHorizontalAlignment(SwingConstants.CENTER);
		lblPrecProd.setForeground(new Color(47, 79, 79));
		lblPrecProd.setFont(new Font("OCR A Extended", Font.BOLD, 20));
		lblPrecProd.setBackground(Color.BLACK);
		lblPrecProd.setBounds(37, 222, 240, 39);
		add(lblPrecProd);
		
		textPrecUnitProd = new JTextField();
		textPrecUnitProd.setHorizontalAlignment(SwingConstants.LEFT);
		textPrecUnitProd.setForeground(new Color(211, 211, 211));
		textPrecUnitProd.setFont(new Font("OCR A Extended", Font.PLAIN, 20));
		textPrecUnitProd.setColumns(10);
		textPrecUnitProd.setBackground(Color.WHITE);
		textPrecUnitProd.setBounds(254, 222, 402, 39);
		add(textPrecUnitProd);
		
		JLabel lblCdigoDoFornecedor = new JLabel("Código do \r\nFornecedor: ");
		lblCdigoDoFornecedor.setHorizontalAlignment(SwingConstants.CENTER);
		lblCdigoDoFornecedor.setForeground(new Color(47, 79, 79));
		lblCdigoDoFornecedor.setFont(new Font("OCR A Extended", Font.BOLD, 20));
		lblCdigoDoFornecedor.setBackground(Color.BLACK);
		lblCdigoDoFornecedor.setBounds(49, 284, 288, 39);
		add(lblCdigoDoFornecedor);
		
		textFornProd = new JTextField();
		textFornProd.setHorizontalAlignment(SwingConstants.LEFT);
		textFornProd.setForeground(new Color(47, 79, 79));
		textFornProd.setFont(new Font("OCR A Extended", Font.PLAIN, 20));
		textFornProd.setColumns(10);
		textFornProd.setBackground(Color.WHITE);
		textFornProd.setBounds(329, 284, 327, 39);
		add(textFornProd);
		
		JButton btnVoltar = new JButton("Voltar");
		btnVoltar.setForeground(new Color(47, 79, 79));
		btnVoltar.setFont(new Font("OCR A Extended", Font.PLAIN, 20));
		btnVoltar.setBackground(new Color(245, 245, 245));
		btnVoltar.setBounds(227, 368, 117, 31);
		add(btnVoltar);
		
		JButton btnApagar = new JButton("Apagar");
		btnApagar.setForeground(new Color(47, 79, 79));
		btnApagar.setFont(new Font("OCR A Extended", Font.PLAIN, 20));
		btnApagar.setBackground(new Color(245, 245, 245));
		btnApagar.setBounds(397, 368, 117, 31);
		add(btnApagar);

	}

}
