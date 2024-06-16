package Cashtab;

import javax.swing.JPanel;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import java.awt.Panel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.JButton;
import java.awt.Color;

public class TelaConsultaForn extends JPanel {

	private static final long serialVersionUID = 1L;
	private JTextField textField;
	private JTable table;

	/**
	 * Create the panel.
	 */
	public TelaConsultaForn() {
		setLayout(null);
		
		JLabel lblConsultaDeProdutos = new JLabel("Consulta de Fornecedores");
		lblConsultaDeProdutos.setForeground(new Color(47, 79, 79));
		lblConsultaDeProdutos.setHorizontalAlignment(SwingConstants.CENTER);
		lblConsultaDeProdutos.setFont(new Font("OCR A Extended", Font.BOLD, 40));
		lblConsultaDeProdutos.setBounds(94, 10, 609, 70);
		add(lblConsultaDeProdutos);
		
		JLabel lblFiltrarPor = new JLabel("Filtrar por:");
		lblFiltrarPor.setForeground(new Color(47, 79, 79));
		lblFiltrarPor.setFont(new Font("OCR A Extended", Font.BOLD, 15));
		lblFiltrarPor.setBounds(10, 67, 120, 47);
		add(lblFiltrarPor);
		
		JLabel lblDataInicial = new JLabel("Nome:");
		lblDataInicial.setForeground(new Color(47, 79, 79));
		lblDataInicial.setFont(new Font("OCR A Extended", Font.BOLD, 15));
		lblDataInicial.setBounds(10, 98, 143, 47);
		add(lblDataInicial);
		
		textField = new JTextField();
		textField.setColumns(10);
		textField.setBounds(64, 113, 274, 20);
		add(textField);
		
		Panel panel = new Panel();
		panel.setLayout(null);
		panel.setBounds(10, 138, 780, 247);
		add(panel);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 11, 760, 251);
		panel.add(scrollPane);
		
		table = new JTable();
		table.setBackground(new Color(255, 255, 255));
		table.setFont(new Font("OCR A Extended", Font.PLAIN, 13));
		table.setForeground(new Color(47, 79, 79));
		table.setModel(new DefaultTableModel(
			new Object[][] {
				{null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null},
			},
			new String[] {
				"ID", "Nome", "Email", "Telefone", "Endere\u00E7o", "Cidade", "Estado"
			}
		));
		scrollPane.setViewportView(table);
		
		JButton btnVoltar = new JButton("Voltar");
		btnVoltar.setForeground(new Color(47, 79, 79));
		btnVoltar.setFont(new Font("OCR A Extended", Font.BOLD, 18));
		btnVoltar.setBackground(new Color(245, 245, 245));
		btnVoltar.setBounds(337, 395, 117, 31);
		add(btnVoltar);

	}

}
