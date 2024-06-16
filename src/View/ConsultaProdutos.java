package View;

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

/**
 * A classe ConsultaProdutos representa a interface gráfica para consulta de produtos.
 */
public class ConsultaProdutos extends JPanel {

	private static final long serialVersionUID = 1L;
	private JTextField textField;
	private JTextField textField_1;
	private JTable table;

	/**
	 * Cria o painel de consulta de produtos.
	 */
	public ConsultaProdutos() {
		setLayout(null);
		
		JLabel lblConsultaDeProdutos = new JLabel("Consulta de Produtos");
		lblConsultaDeProdutos.setHorizontalAlignment(SwingConstants.CENTER);
		lblConsultaDeProdutos.setFont(new Font("OCR A Extended", Font.BOLD, 40));
		lblConsultaDeProdutos.setBounds(137, 0, 515, 70);
		add(lblConsultaDeProdutos);
		
		JLabel lblFiltrarPor = new JLabel("Filtrar por:");
		lblFiltrarPor.setFont(new Font("OCR A Extended", Font.BOLD, 15));
		lblFiltrarPor.setBounds(10, 67, 120, 47);
		add(lblFiltrarPor);
		
		JLabel lblDataInicial = new JLabel("Data Inicial:");
		lblDataInicial.setFont(new Font("OCR A Extended", Font.BOLD, 15));
		lblDataInicial.setBounds(10, 98, 143, 47);
		add(lblDataInicial);
		
		textField = new JTextField();
		textField.setColumns(10);
		textField.setBounds(143, 112, 132, 20);
		add(textField);
		
		JLabel lblDataFinal = new JLabel("Data Final:");
		lblDataFinal.setFont(new Font("OCR A Extended", Font.BOLD, 15));
		lblDataFinal.setBounds(321, 98, 114, 47);
		add(lblDataFinal);
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(433, 112, 132, 20);
		add(textField_1);
		
		Panel panel = new Panel();
		panel.setLayout(null);
		panel.setBounds(10, 138, 780, 247);
		add(panel);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 11, 760, 251);
		panel.add(scrollPane);
		
		table = new JTable();
		table.setModel(new DefaultTableModel(
			new Object[][] {
				{null, null, null},
				{null, null, null},
				{null, null, null},
				{null, null, null},
				{null, null, null},
				{null, null, null},
				{null, null, null},
				{null, null, null},
				{null, null, null},
				{null, null, null},
				{null, null, null},
				{null, null, null},
				{null, null, null},
			},
			new String[] {
				"ID", "Descrição", "Preço Unitário"
			}
		));
		scrollPane.setViewportView(table);
		
		JButton btnNewButton = new JButton("Voltar");
		btnNewButton.setFont(new Font("OCR A Extended", Font.BOLD, 15));
		btnNewButton.setBounds(339, 400, 120, 39);
		add(btnNewButton);
	}
}
