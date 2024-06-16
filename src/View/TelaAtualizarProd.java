package Cashtab;

import javax.swing.JPanel;
import java.awt.GridLayout;
import java.awt.Color;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.JButton;

public class TelaAtualizarProd extends JPanel {

	private static final long serialVersionUID = 1L;
	private JTextField textDescProd;
	private JTextField textPrcUnitProduto;
	private JTextField textFornProd;
	private JTextField textCodProd;

	/**
	 * Create the panel.
	 */
	public TelaAtualizarProd() {
		setBackground(new Color(245, 245, 245));
		setLayout(null);
		
		JLabel lblAtualizarProd = new JLabel("Atualizar Dados de Produtos");
		lblAtualizarProd.setForeground(new Color(47, 79, 79));
		lblAtualizarProd.setFont(new Font("OCR A Extended", Font.BOLD, 40));
		lblAtualizarProd.setBounds(49, 22, 695, 48);
		add(lblAtualizarProd);
		
		JLabel lblNomeProd = new JLabel("Produto: ");
		lblNomeProd.setHorizontalAlignment(SwingConstants.CENTER);
		lblNomeProd.setForeground(new Color(47, 79, 79));
		lblNomeProd.setFont(new Font("OCR A Extended", Font.BOLD, 20));
		lblNomeProd.setBackground(Color.BLACK);
		lblNomeProd.setBounds(109, 159, 182, 39);
		add(lblNomeProd);
		
		textDescProd = new JTextField();
		textDescProd.setHorizontalAlignment(SwingConstants.LEFT);
		textDescProd.setForeground(new Color(211, 211, 211));
		textDescProd.setFont(new Font("OCR A Extended", Font.PLAIN, 20));
		textDescProd.setColumns(10);
		textDescProd.setBackground(Color.WHITE);
		textDescProd.setBounds(254, 159, 402, 39);
		add(textDescProd);
		
		JLabel lblPrecProd = new JLabel("Preço Unitário: ");
		lblPrecProd.setHorizontalAlignment(SwingConstants.CENTER);
		lblPrecProd.setForeground(new Color(47, 79, 79));
		lblPrecProd.setFont(new Font("OCR A Extended", Font.BOLD, 20));
		lblPrecProd.setBackground(Color.BLACK);
		lblPrecProd.setBounds(37, 220, 240, 39);
		add(lblPrecProd);
		
		textPrcUnitProduto = new JTextField();
		textPrcUnitProduto.setHorizontalAlignment(SwingConstants.LEFT);
		textPrcUnitProduto.setForeground(new Color(211, 211, 211));
		textPrcUnitProduto.setFont(new Font("OCR A Extended", Font.PLAIN, 20));
		textPrcUnitProduto.setColumns(10);
		textPrcUnitProduto.setBackground(Color.WHITE);
		textPrcUnitProduto.setBounds(254, 220, 402, 39);
		add(textPrcUnitProduto);
		
		JLabel lblCdigoDoFornecedor = new JLabel("Código do \r\nFornecedor: ");
		lblCdigoDoFornecedor.setHorizontalAlignment(SwingConstants.CENTER);
		lblCdigoDoFornecedor.setForeground(new Color(47, 79, 79));
		lblCdigoDoFornecedor.setFont(new Font("OCR A Extended", Font.BOLD, 20));
		lblCdigoDoFornecedor.setBackground(Color.BLACK);
		lblCdigoDoFornecedor.setBounds(49, 282, 288, 39);
		add(lblCdigoDoFornecedor);
		
		textFornProd = new JTextField();
		textFornProd.setHorizontalAlignment(SwingConstants.LEFT);
		textFornProd.setForeground(new Color(47, 79, 79));
		textFornProd.setFont(new Font("OCR A Extended", Font.PLAIN, 20));
		textFornProd.setColumns(10);
		textFornProd.setBackground(Color.WHITE);
		textFornProd.setBounds(329, 282, 327, 39);
		add(textFornProd);
		
		JButton btnVoltar = new JButton("Voltar");
		btnVoltar.setForeground(new Color(47, 79, 79));
		btnVoltar.setFont(new Font("OCR A Extended", Font.PLAIN, 20));
		btnVoltar.setBackground(new Color(245, 245, 245));
		btnVoltar.setBounds(227, 366, 117, 31);
		add(btnVoltar);
		
		JButton btnRegistrar = new JButton("Salvar");
		btnRegistrar.setForeground(new Color(47, 79, 79));
		btnRegistrar.setFont(new Font("OCR A Extended", Font.PLAIN, 20));
		btnRegistrar.setBackground(new Color(245, 245, 245));
		btnRegistrar.setBounds(397, 366, 117, 31);
		add(btnRegistrar);
		
		JLabel lblCodProd = new JLabel("Código:");
		lblCodProd.setHorizontalAlignment(SwingConstants.CENTER);
		lblCodProd.setForeground(new Color(47, 79, 79));
		lblCodProd.setFont(new Font("OCR A Extended", Font.BOLD, 20));
		lblCodProd.setBackground(Color.BLACK);
		lblCodProd.setBounds(109, 96, 182, 39);
		add(lblCodProd);
		
		textCodProd = new JTextField();
		textCodProd.setHorizontalAlignment(SwingConstants.LEFT);
		textCodProd.setForeground(new Color(211, 211, 211));
		textCodProd.setFont(new Font("OCR A Extended", Font.PLAIN, 20));
		textCodProd.setColumns(10);
		textCodProd.setBackground(Color.WHITE);
		textCodProd.setBounds(254, 96, 402, 39);
		add(textCodProd);

	}
}
