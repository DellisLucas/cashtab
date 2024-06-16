package Cashtab;

import javax.swing.JPanel;
import javax.swing.JButton;
import java.awt.Font;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import java.awt.Panel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import java.awt.Color;

public class TelaConsultaDesp extends JPanel {

	private static final long serialVersionUID = 1L;
	private JTextField textField;
	private JTextField textField_1;
	private JTable table;

	/**
	 * Create the panel.
	 */
	public TelaConsultaDesp() {
		setLayout(null);
		
		JLabel lblTituloCadReceita = new JLabel("Consulta de Despesas");
		lblTituloCadReceita.setForeground(new Color(47, 79, 79));
		lblTituloCadReceita.setHorizontalAlignment(SwingConstants.CENTER);
		lblTituloCadReceita.setFont(new Font("OCR A Extended", Font.BOLD, 40));
		lblTituloCadReceita.setBounds(127, 10, 515, 70);
		add(lblTituloCadReceita);
		
		JLabel lblFiltrarPor = new JLabel("Filtrar por:");
		lblFiltrarPor.setForeground(new Color(47, 79, 79));
		lblFiltrarPor.setFont(new Font("OCR A Extended", Font.BOLD, 15));
		lblFiltrarPor.setBounds(10, 67, 120, 47);
		add(lblFiltrarPor);
		
		JLabel lblDataInicial = new JLabel("Data Inicial:");
		lblDataInicial.setForeground(new Color(47, 79, 79));
		lblDataInicial.setFont(new Font("OCR A Extended", Font.BOLD, 15));
		lblDataInicial.setBounds(10, 98, 143, 47);
		add(lblDataInicial);
		
		textField = new JTextField();
		textField.setColumns(10);
		textField.setBounds(143, 112, 132, 20);
		add(textField);
		
		JLabel lblDataFinal = new JLabel("Data Final:");
		lblDataFinal.setForeground(new Color(47, 79, 79));
		lblDataFinal.setFont(new Font("OCR A Extended", Font.BOLD, 15));
		lblDataFinal.setBounds(323, 98, 114, 47);
		add(lblDataFinal);
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(437, 112, 132, 20);
		add(textField_1);
		
		Panel panel = new Panel();
		panel.setLayout(null);
		panel.setBounds(10, 140, 780, 247);
		add(panel);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 11, 760, 251);
		panel.add(scrollPane);
		
		table = new JTable();
		table.setBackground(new Color(255, 255, 255));
		table.setForeground(new Color(47, 79, 79));
		table.setFont(new Font("OCR A Extended", Font.PLAIN, 10));
		table.setModel(new DefaultTableModel(
			new Object[][] {
				{null, null, null, null},
				{null, null, null, null},
				{null, null, null, null},
				{null, null, null, null},
				{null, null, null, null},
				{null, null, null, null},
				{null, null, null, null},
				{null, null, null, null},
				{null, null, null, null},
				{null, null, null, null},
				{null, null, null, null},
				{null, null, null, null},
				{null, null, null, null},
			},
			new String[] {
				"ID", "Descri\u00E7\u00E3o", "Data Faturamento", "Valor Pago"
			}
		));
		scrollPane.setViewportView(table);
		
		JButton btnVoltar = new JButton("Voltar");
		btnVoltar.setForeground(new Color(47, 79, 79));
		btnVoltar.setFont(new Font("OCR A Extended", Font.BOLD, 18));
		btnVoltar.setBackground(new Color(245, 245, 245));
		btnVoltar.setBounds(340, 396, 117, 31);
		add(btnVoltar);

	}

}
