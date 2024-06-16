package View;


import javax.swing.JPanel;
import java.awt.Color;

import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;

import Model.Usuario;

import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JMenu;
import javax.swing.JPopupMenu;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class TelaHome extends JPanel {
	private Usuario usuario;

	private static final long serialVersionUID = 1L;
	/**
	 * @wbp.nonvisual location=839,179
	 */
	/**
	 * Create the panel.
	 * @param usuario 
	 */
	public TelaHome(Usuario usuario) {
		this.usuario = usuario;
		setBackground(new Color(245, 245, 245));
		setLayout(null);
		
		JLabel lblCashTab = new JLabel("CashTab");
		lblCashTab.setHorizontalAlignment(SwingConstants.CENTER);
		lblCashTab.setForeground(new Color(47, 79, 79));
		lblCashTab.setFont(new Font("OCR A Extended", Font.BOLD, 25));
		lblCashTab.setBackground(Color.BLACK);
		lblCashTab.setBounds(670, 393, 130, 57);
		add(lblCashTab);
		
		JMenuBar menuBar = new JMenuBar();
		menuBar.setBounds(0, 0, 800, 22);
		add(menuBar);
		
		JMenu mnProdutos = new JMenu("Produtos");
		mnProdutos.setForeground(new Color(47, 79, 79));
		mnProdutos.setFont(new Font("OCR A Extended", Font.BOLD, 15));
		mnProdutos.setBackground(new Color(245, 245, 245));
		menuBar.add(mnProdutos);
		
		JMenu mnRegistroProd = new JMenu("Registrar");
		mnRegistroProd.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				JFrame frame = new JFrame();
                frame.setSize(800, 500);
                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                frame.setLocationRelativeTo(null);
                frame.setContentPane(new TelaRegistroProd(null, usuario));
                frame.setVisible(true);
                TelaHome.this.dispose(); // Fecha a tela
			}
		});
		mnRegistroProd.setForeground(new Color(47, 79, 79));
		mnRegistroProd.setFont(new Font("OCR A Extended", Font.BOLD, 15));
		mnProdutos.add(mnRegistroProd);
		
		JMenu mnAlterarProd = new JMenu("Atualizar");
		mnAlterarProd.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				JFrame frame = new JFrame();
                frame.setSize(800, 500);
                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                frame.setLocationRelativeTo(null);
                frame.setContentPane(new TelaAtualizarProd(null));
                frame.setVisible(true);
                TelaHome.this.dispose(); // Fecha a tela
			}
		});
		mnAlterarProd.setForeground(new Color(47, 79, 79));
		mnAlterarProd.setFont(new Font("OCR A Extended", Font.BOLD, 15));
		mnProdutos.add(mnAlterarProd);
		
		JMenu mnApagarProd = new JMenu("Apagar");
		mnApagarProd.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				JFrame frame = new JFrame();
                frame.setSize(800, 500);
                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                frame.setLocationRelativeTo(null);
                frame.setContentPane(new TelaApagarProd());
                frame.setVisible(true);
                TelaHome.this.dispose(); // Fecha a tela
			}
		});
		mnApagarProd.setForeground(new Color(47, 79, 79));
		mnApagarProd.setFont(new Font("OCR A Extended", Font.BOLD, 15));
		mnProdutos.add(mnApagarProd);
		
		JMenu mnConsultarProd = new JMenu("Consultar");
		mnConsultarProd.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				JFrame frame = new JFrame();
                frame.setSize(800, 500);
                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                frame.setLocationRelativeTo(null);
                frame.setContentPane(new TelaConsultaProd());
                frame.setVisible(true);
                TelaHome.this.dispose(); // Fecha a tela
			}
		});
		mnConsultarProd.setForeground(new Color(47, 79, 79));
		mnConsultarProd.setFont(new Font("OCR A Extended", Font.BOLD, 15));
		mnProdutos.add(mnConsultarProd);
		
		JMenu mnFornecedor = new JMenu("Fornecedor");
		mnFornecedor.setForeground(new Color(47, 79, 79));
		mnFornecedor.setFont(new Font("OCR A Extended", Font.BOLD, 15));
		mnProdutos.add(mnFornecedor);
		
		JMenu mnRegistrarForn = new JMenu("Registrar");
		mnRegistrarForn.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				JFrame frame = new JFrame();
                frame.setSize(800, 500);
                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                frame.setLocationRelativeTo(null);
                frame.setContentPane(new TelaRegistroForn());
                frame.setVisible(true);
			}
		});
		mnRegistrarForn.setForeground(new Color(47, 79, 79));
		mnRegistrarForn.setFont(new Font("OCR A Extended", Font.BOLD, 15));
		mnFornecedor.add(mnRegistrarForn);
		
		JMenu mnAtualizarForn = new JMenu("Atualizar");
		mnAtualizarForn.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				JFrame frame = new JFrame();
                frame.setSize(800, 500);
                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                frame.setLocationRelativeTo(null);
                frame.setContentPane(new TelaAtualizarForn());
                frame.setVisible(true);
			}
		});
		mnAtualizarForn.setForeground(new Color(47, 79, 79));
		mnAtualizarForn.setFont(new Font("OCR A Extended", Font.BOLD, 15));
		mnFornecedor.add(mnAtualizarForn);
		
		JMenu mnApagarForn = new JMenu("Apagar");
		mnApagarForn.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				JFrame frame = new JFrame();
                frame.setSize(800, 500);
                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                frame.setLocationRelativeTo(null);
                frame.setContentPane(new TelaApagarForn());
                frame.setVisible(true);
			}
		});
		mnApagarForn.setForeground(new Color(47, 79, 79));
		mnApagarForn.setFont(new Font("OCR A Extended", Font.BOLD, 15));
		mnFornecedor.add(mnApagarForn);
		
		JMenu mnConsultarForn = new JMenu("Consultar");
		mnConsultarForn.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				JFrame frame = new JFrame();
                frame.setSize(800, 500);
                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                frame.setLocationRelativeTo(null);
                frame.setContentPane(new TelaConsultaForn());
                frame.setVisible(true);
			}
		});
		mnConsultarForn.setForeground(new Color(47, 79, 79));
		mnConsultarForn.setFont(new Font("OCR A Extended", Font.BOLD, 15));
		mnFornecedor.add(mnConsultarForn);
		
		JMenu mnReceitas = new JMenu("Receitas");
		mnReceitas.setForeground(new Color(47, 79, 79));
		mnReceitas.setFont(new Font("OCR A Extended", Font.BOLD, 15));
		menuBar.add(mnReceitas);
		
		JMenu mnRegistroRec = new JMenu("Registrar");
		mnRegistroRec.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				JFrame frame = new JFrame();
                frame.setSize(800, 500);
                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                frame.setLocationRelativeTo(null);
                frame.setContentPane(new TelaRegistroRec(null, usuario));
                frame.setVisible(true);
			}
		});
		mnRegistroRec.setForeground(new Color(47, 79, 79));
		mnRegistroRec.setFont(new Font("OCR A Extended", Font.BOLD, 15));
		mnReceitas.add(mnRegistroRec);
		
		JMenu mnAtualizarRec = new JMenu("Atualizar");
		mnAtualizarRec.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				JFrame frame = new JFrame();
                frame.setSize(800, 500);
                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                frame.setLocationRelativeTo(null);
                frame.setContentPane(new TelaAtualizarRec(null, usuario));
                frame.setVisible(true);
			}
		});
		mnAtualizarRec.setForeground(new Color(47, 79, 79));
		mnAtualizarRec.setFont(new Font("OCR A Extended", Font.BOLD, 15));
		mnReceitas.add(mnAtualizarRec);
		
		JMenu mnApagarRec = new JMenu("Apagar");
		mnApagarRec.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				JFrame frame = new JFrame();
                frame.setSize(800, 500);
                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                frame.setLocationRelativeTo(null);
                frame.setContentPane(new TelaApagarRec());
                frame.setVisible(true);
			}
		});
		mnApagarRec.setForeground(new Color(47, 79, 79));
		mnApagarRec.setFont(new Font("OCR A Extended", Font.BOLD, 15));
		mnReceitas.add(mnApagarRec);
		
		JMenu mnConsultarRec = new JMenu("Consultar");
		mnConsultarRec.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				JFrame frame = new JFrame();
                frame.setSize(800, 500);
                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                frame.setLocationRelativeTo(null);
                frame.setContentPane(new ConsultaReceita(null));
                frame.setVisible(true);
			}
		});
		mnConsultarRec.setForeground(new Color(47, 79, 79));
		mnConsultarRec.setFont(new Font("OCR A Extended", Font.BOLD, 15));
		mnReceitas.add(mnConsultarRec);
		
		JMenu mnDespesas = new JMenu("Despesas");
		mnDespesas.setForeground(new Color(47, 79, 79));
		mnDespesas.setFont(new Font("OCR A Extended", Font.BOLD, 15));
		menuBar.add(mnDespesas);
		
		JMenu mnRegistroDesp = new JMenu("Registrar");
		mnRegistroDesp.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				JFrame frame = new JFrame();
                frame.setSize(800, 500);
                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                frame.setLocationRelativeTo(null);
                frame.setContentPane(new TelaRegistroDesp(null, usuario));
                frame.setVisible(true);
                TelaHome.this.dispose(); // Fecha a tela
			}
		});
		mnRegistroDesp.setForeground(new Color(47, 79, 79));
		mnRegistroDesp.setFont(new Font("OCR A Extended", Font.BOLD, 15));
		mnDespesas.add(mnRegistroDesp);
		
		JMenu mnAtualizarDesp = new JMenu("Atualizar");
		mnAtualizarDesp.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				JFrame frame = new JFrame();
                frame.setSize(800, 500);
                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                frame.setLocationRelativeTo(null);
                frame.setContentPane(new TelaAtualizarDesp(null));
                frame.setVisible(true);
			}
		});
		mnAtualizarDesp.setForeground(new Color(47, 79, 79));
		mnAtualizarDesp.setFont(new Font("OCR A Extended", Font.BOLD, 15));
		mnAtualizarDesp.setBackground(new Color(240, 240, 240));
		mnDespesas.add(mnAtualizarDesp);
		
		JMenu mnApagarDesp = new JMenu("Apagar");
		mnApagarDesp.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				JFrame frame = new JFrame();
                frame.setSize(800, 500);
                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                frame.setLocationRelativeTo(null);
                frame.setContentPane(new TelaApagarDesp());
                frame.setVisible(true);
                TelaHome.this.dispose(); // Fecha a tela
			}
		});
		mnApagarDesp.setForeground(new Color(47, 79, 79));
		mnApagarDesp.setFont(new Font("OCR A Extended", Font.BOLD, 15));
		mnDespesas.add(mnApagarDesp);
		
		JMenu mnConsultarDesp = new JMenu("Consultar");
		mnConsultarDesp.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				JFrame frame = new JFrame();
                frame.setSize(800, 500);
                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                frame.setLocationRelativeTo(null);
                frame.setContentPane(new TelaConsultaDesp());
                frame.setVisible(true);
                TelaHome.this.dispose(); // Fecha a tela
			}
		});
		mnConsultarDesp.setForeground(new Color(47, 79, 79));
		mnConsultarDesp.setFont(new Font("OCR A Extended", Font.BOLD, 15));
		mnDespesas.add(mnConsultarDesp);
		
		JMenu mnRelatórios = new JMenu("Relatórios");
		mnRelatórios.setForeground(new Color(47, 79, 79));
		mnRelatórios.setFont(new Font("OCR A Extended", Font.BOLD, 15));
		mnRelatórios.setBackground(new Color(245, 245, 245));
		menuBar.add(mnRelatórios);
		
		JMenu mnVisualizarRel = new JMenu("Visualizar");
		mnVisualizarRel.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				JFrame frame = new JFrame();
                frame.setSize(900, 500);
                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                frame.setLocationRelativeTo(null);
                frame.setContentPane(new TelaVisualizarRelat());
                frame.setVisible(true);
                TelaHome.this.dispose(); // Fecha a tela
			}
		});
		mnVisualizarRel.setForeground(new Color(47, 79, 79));
		mnVisualizarRel.setFont(new Font("OCR A Extended", Font.BOLD, 15));
		mnRelatórios.add(mnVisualizarRel);
		
		JMenu mnMeuPerfil = new JMenu("Meu Perfil");
		mnMeuPerfil.setForeground(new Color(47, 79, 79));
		mnMeuPerfil.setFont(new Font("OCR A Extended", Font.BOLD, 15));
		menuBar.add(mnMeuPerfil);
		
		JMenu mnMeusDados = new JMenu("Meus Dados");
		mnMeusDados.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				String userDetails = "Nome: " + usuario.getNomeUsuario() + "\n" +
                        "E-mail: " + usuario.getEmail() + "\n" +
                        "Nome do Negócio: " + usuario.getNomeNegocio() + "\n" +
                        "MEI: " + usuario.getMei() + "\n" +
                        "Endereço: " + usuario.getEndereco() + "\n" +
                        "Cidade: " + usuario.getCidade() + "\n" +
                        "Estado: " + usuario.getEstado();

   // Exibe a mensagem de diálogo
   JOptionPane.showMessageDialog(null, userDetails, "Meus Dados", JOptionPane.INFORMATION_MESSAGE);
			}
		});
		mnMeusDados.setForeground(new Color(47, 79, 79));
		mnMeusDados.setFont(new Font("OCR A Extended", Font.BOLD, 15));
		mnMeuPerfil.add(mnMeusDados);
		
		JMenu mnAtualizarPerfil = new JMenu("Atualizar");
		mnAtualizarPerfil.setForeground(new Color(47, 79, 79));
		mnAtualizarPerfil.setFont(new Font("OCR A Extended", Font.BOLD, 15));
		mnMeuPerfil.add(mnAtualizarPerfil);
		
		JMenu mnSairPerfil = new JMenu("Sair");
		mnSairPerfil.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				System.exit(ABORT);
			}
		});
		mnSairPerfil.setForeground(new Color(47, 79, 79));
		mnSairPerfil.setFont(new Font("OCR A Extended", Font.BOLD, 15));
		mnMeuPerfil.add(mnSairPerfil);
		
		JLabel lblWeShapeFinancial = new JLabel("We shape the freedom");
		lblWeShapeFinancial.setHorizontalAlignment(SwingConstants.CENTER);
		lblWeShapeFinancial.setForeground(new Color(47, 79, 79));
		lblWeShapeFinancial.setFont(new Font("OCR A Extended", Font.BOLD, 40));
		lblWeShapeFinancial.setBackground(Color.BLACK);
		lblWeShapeFinancial.setBounds(283, 344, 517, 59);
		add(lblWeShapeFinancial);

	}
	protected void dispose() {
		// TODO Auto-generated method stub
		
	}
}
