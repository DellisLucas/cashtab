	package View;
	
	import javax.swing.JPanel;
	import javax.swing.JLabel;
	import javax.swing.JOptionPane;
	
	import java.awt.Font;
	import javax.swing.SwingConstants;
	import javax.swing.event.DocumentEvent;
	import javax.swing.event.DocumentListener;
	import javax.swing.JTextField;
	import java.awt.Panel;
	import java.util.List;
	
	import javax.swing.JScrollPane;
	import javax.swing.JTable;
	import javax.swing.table.DefaultTableModel;
	
	import DAO.FornecedorDAO;
	import Model.Fornecedor;
	
	import javax.swing.JButton;
	import javax.swing.JFrame;
	
	import java.awt.Color;
	import java.awt.Component;
	import java.awt.event.MouseAdapter;
	import java.awt.event.MouseEvent;
	
	public class TelaConsultaForn extends JPanel {
	
		private static final long serialVersionUID = 1L;
		private JTextField txtNomeForn;
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
			
			txtNomeForn = new JTextField();
			txtNomeForn.setColumns(10);
			txtNomeForn.setBounds(64, 113, 274, 20);
			add(txtNomeForn);
			
			Panel panel = new Panel();
			panel.setLayout(null);
			panel.setBounds(10, 138, 780, 247);
			add(panel);
			
			JScrollPane scrollPane = new JScrollPane();
			scrollPane.setBounds(10, 11, 760, 251);
			panel.add(scrollPane);
			
			table = new JTable();
	        table.setForeground(new Color(47, 79, 79));
	        table.setFont(new Font("OCR A Extended", Font.PLAIN, 10));
	        table.setModel(new DefaultTableModel(
	            new Object[][] {},
	            new String[] {
	                "ID", "Nome Fornecedor", "Telefone", "Endereco", "Email", "Cidade", "Estado"
	            }
	        ));
	        scrollPane.setViewportView(table);
	
	        
	        table.addMouseListener(new MouseAdapter() {
	            @Override
	            public void mouseClicked(MouseEvent e) {
	                int selectedRow = table.getSelectedRow();
	                if (selectedRow != -1) {
	                    Object idForn = table.getValueAt(selectedRow, 0);
	                    Object nomeForn = table.getValueAt(selectedRow, 1);
	                    Object telefone = table.getValueAt(selectedRow, 2);
	                    Object endereco = table.getValueAt(selectedRow, 3);
	                    Object email = table.getValueAt(selectedRow, 4);
	                    Object cidade = table.getValueAt(selectedRow, 5);
	                    Object estado = table.getValueAt(selectedRow, 6);
	                    
	                    Object[] opcoes = {"Atualizar", "Apagar"};
	                    int escolha = JOptionPane.showOptionDialog(null, "Escolha uma opção:", "Caixa de diálogo com opções",
	                                            JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE, null,
	                                            opcoes, opcoes[0]);
	                    
	                    if (escolha == 0) {
	                        TelaAtualizarForn telaAtualizarForn = new TelaAtualizarForn();
	                        telaAtualizarForn.preencherCampos(idForn.toString(), nomeForn.toString(), telefone.toString(), endereco.toString(), email.toString(), cidade.toString(), estado.toString());
	
	                        JFrame frameAtualizarForn = new JFrame("Atualização de Fornecedores");
	                        frameAtualizarForn.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
	                        frameAtualizarForn.getContentPane().add(telaAtualizarForn);
	                        frameAtualizarForn.pack();
	                        frameAtualizarForn.setSize(800, 450);
	                        frameAtualizarForn.setLocationRelativeTo(null);
	                        frameAtualizarForn.setVisible(true);
	                    } else if (escolha == 1) {
	                        TelaApagarForn telaApagarForn = new TelaApagarForn();
	                        telaApagarForn.preencherCampos(idForn.toString(), nomeForn.toString(), telefone.toString(), endereco.toString(), email.toString(), cidade.toString(), estado.toString());
	
	                        JFrame frameApagarForn = new JFrame("Apagar Fornecedor");
	                        frameApagarForn.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
	                        frameApagarForn.getContentPane().add(telaApagarForn);
	                        frameApagarForn.pack();
	                        frameApagarForn.setSize(800, 450);
	                        frameApagarForn.setLocationRelativeTo(null);
	                        frameApagarForn.setVisible(true);
	                    }
	                }
	            }
	        });
	        
			
			JButton btnVoltar = new JButton("Voltar");
			btnVoltar.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent e) {
					JFrame parentFrame = (JFrame) TelaConsultaForn.this.getTopLevelAncestor();
	                if (parentFrame != null) {
	                    parentFrame.dispose();
	                }
				}
			});
			btnVoltar.setForeground(new Color(47, 79, 79));
			btnVoltar.setFont(new Font("OCR A Extended", Font.BOLD, 18));
			btnVoltar.setBackground(new Color(245, 245, 245));
			btnVoltar.setBounds(337, 395, 117, 31);
			add(btnVoltar);
			
			txtNomeForn.getDocument().addDocumentListener(new DocumentListener() {
	            public void changedUpdate(DocumentEvent e) {
	                updateTable();
	            }
	            public void removeUpdate(DocumentEvent e) {
	                updateTable();
	            }
	            public void insertUpdate(DocumentEvent e) {
	                updateTable();
	            }
	
	            public void updateTable() {
	                String searchText = txtNomeForn.getText();
	                List<Fornecedor> fornecedores = new FornecedorDAO(null).searchByDescription(searchText);
	                DefaultTableModel model = (DefaultTableModel) table.getModel();
	                model.setRowCount(0);
	                for (Fornecedor fornecedor : fornecedores) {
	                    model.addRow(new Object[]{fornecedor.getIdFornecedor(), fornecedor.getNomeFornecedor(), fornecedor.getTelefone(), fornecedor.getEndereco(), fornecedor.getEmailForn(), fornecedor.getCidade(), fornecedor.getEstado()});
	                }
	            }
	        });
		}
	}
