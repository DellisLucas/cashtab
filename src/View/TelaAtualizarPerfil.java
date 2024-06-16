package View;


import javax.swing.JPanel;
import java.awt.Color;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.JButton;

public class TelaAtualizarPerfil extends JPanel {

	private static final long serialVersionUID = 1L;
	private JTextField textMailUser;
	private JTextField textNomeUser;
	private JTextField textCNPJUser;
	private JTextField textMEI;
	private JTextField textNomeEmp;
	private JTextField textEndUser;
	private JTextField textCidUser;
	private JTextField textEstUser;
	private JTextField textTelUser;

	/**
	 * Create the panel.
	 */
	public TelaAtualizarPerfil() {
		setBackground(new Color(245, 245, 245));
		setLayout(null);
		
		JLabel lblEmail = new JLabel("E-mail:");
		lblEmail.setHorizontalAlignment(SwingConstants.CENTER);
		lblEmail.setForeground(new Color(47, 79, 79));
		lblEmail.setFont(new Font("OCR A Extended", Font.BOLD, 20));
		lblEmail.setBackground(Color.BLACK);
		lblEmail.setBounds(20, 112, 115, 39);
		add(lblEmail);
		
		textMailUser = new JTextField();
		textMailUser.setHorizontalAlignment(SwingConstants.LEFT);
		textMailUser.setForeground(new Color(211, 211, 211));
		textMailUser.setFont(new Font("OCR A Extended", Font.PLAIN, 20));
		textMailUser.setColumns(10);
		textMailUser.setBackground(Color.WHITE);
		textMailUser.setBounds(125, 112, 322, 39);
		add(textMailUser);
		
		JLabel lblName = new JLabel("Nome:");
		lblName.setHorizontalAlignment(SwingConstants.CENTER);
		lblName.setForeground(new Color(47, 79, 79));
		lblName.setFont(new Font("OCR A Extended", Font.BOLD, 20));
		lblName.setBackground(Color.BLACK);
		lblName.setBounds(20, 162, 115, 39);
		add(lblName);
		
		textNomeUser = new JTextField();
		textNomeUser.setHorizontalAlignment(SwingConstants.LEFT);
		textNomeUser.setForeground(new Color(211, 211, 211));
		textNomeUser.setFont(new Font("OCR A Extended", Font.PLAIN, 20));
		textNomeUser.setColumns(10);
		textNomeUser.setBackground(Color.WHITE);
		textNomeUser.setBounds(125, 162, 322, 39);
		add(textNomeUser);
		
		JLabel lblCNPJ = new JLabel("CNPJ:");
		lblCNPJ.setHorizontalAlignment(SwingConstants.CENTER);
		lblCNPJ.setForeground(new Color(47, 79, 79));
		lblCNPJ.setFont(new Font("OCR A Extended", Font.BOLD, 20));
		lblCNPJ.setBackground(Color.BLACK);
		lblCNPJ.setBounds(20, 212, 115, 39);
		add(lblCNPJ);
		
		textCNPJUser = new JTextField();
		textCNPJUser.setHorizontalAlignment(SwingConstants.LEFT);
		textCNPJUser.setForeground(new Color(211, 211, 211));
		textCNPJUser.setFont(new Font("OCR A Extended", Font.PLAIN, 20));
		textCNPJUser.setColumns(10);
		textCNPJUser.setBackground(Color.WHITE);
		textCNPJUser.setBounds(125, 212, 322, 39);
		add(textCNPJUser);
		
		textMEI = new JTextField();
		textMEI.setHorizontalAlignment(SwingConstants.LEFT);
		textMEI.setForeground(new Color(211, 211, 211));
		textMEI.setFont(new Font("OCR A Extended", Font.PLAIN, 20));
		textMEI.setColumns(10);
		textMEI.setBackground(Color.WHITE);
		textMEI.setBounds(125, 262, 322, 39);
		add(textMEI);
		
		JLabel lblMEI = new JLabel("MEI:");
		lblMEI.setHorizontalAlignment(SwingConstants.CENTER);
		lblMEI.setForeground(new Color(47, 79, 79));
		lblMEI.setFont(new Font("OCR A Extended", Font.BOLD, 20));
		lblMEI.setBackground(Color.BLACK);
		lblMEI.setBounds(20, 262, 115, 39);
		add(lblMEI);
		
		textNomeEmp = new JTextField();
		textNomeEmp.setHorizontalAlignment(SwingConstants.LEFT);
		textNomeEmp.setForeground(new Color(211, 211, 211));
		textNomeEmp.setFont(new Font("OCR A Extended", Font.PLAIN, 20));
		textNomeEmp.setColumns(10);
		textNomeEmp.setBackground(Color.WHITE);
		textNomeEmp.setBounds(125, 312, 322, 39);
		add(textNomeEmp);
		
		textEndUser = new JTextField();
		textEndUser.setHorizontalAlignment(SwingConstants.LEFT);
		textEndUser.setForeground(new Color(211, 211, 211));
		textEndUser.setFont(new Font("OCR A Extended", Font.PLAIN, 20));
		textEndUser.setColumns(10);
		textEndUser.setBackground(Color.WHITE);
		textEndUser.setBounds(584, 136, 203, 39);
		add(textEndUser);
		
		JLabel lblEndereco = new JLabel("Endereço:");
		lblEndereco.setHorizontalAlignment(SwingConstants.CENTER);
		lblEndereco.setForeground(new Color(47, 79, 79));
		lblEndereco.setFont(new Font("OCR A Extended", Font.BOLD, 20));
		lblEndereco.setBackground(Color.BLACK);
		lblEndereco.setBounds(467, 136, 115, 39);
		add(lblEndereco);
		
		JLabel lblCidade = new JLabel("Cidade:");
		lblCidade.setHorizontalAlignment(SwingConstants.CENTER);
		lblCidade.setForeground(new Color(47, 79, 79));
		lblCidade.setFont(new Font("OCR A Extended", Font.BOLD, 20));
		lblCidade.setBackground(Color.BLACK);
		lblCidade.setBounds(467, 186, 115, 39);
		add(lblCidade);
		
		textCidUser = new JTextField();
		textCidUser.setHorizontalAlignment(SwingConstants.LEFT);
		textCidUser.setForeground(new Color(211, 211, 211));
		textCidUser.setFont(new Font("OCR A Extended", Font.PLAIN, 20));
		textCidUser.setColumns(10);
		textCidUser.setBackground(Color.WHITE);
		textCidUser.setBounds(584, 186, 203, 39);
		add(textCidUser);
		
		JLabel lblEstado = new JLabel("Estado:");
		lblEstado.setHorizontalAlignment(SwingConstants.CENTER);
		lblEstado.setForeground(new Color(47, 79, 79));
		lblEstado.setFont(new Font("OCR A Extended", Font.BOLD, 20));
		lblEstado.setBackground(Color.BLACK);
		lblEstado.setBounds(467, 236, 115, 39);
		add(lblEstado);
		
		textEstUser = new JTextField();
		textEstUser.setHorizontalAlignment(SwingConstants.LEFT);
		textEstUser.setForeground(new Color(211, 211, 211));
		textEstUser.setFont(new Font("OCR A Extended", Font.PLAIN, 20));
		textEstUser.setColumns(10);
		textEstUser.setBackground(Color.WHITE);
		textEstUser.setBounds(584, 236, 203, 39);
		add(textEstUser);
		
		JLabel lblTelefone = new JLabel("Telefone:");
		lblTelefone.setHorizontalAlignment(SwingConstants.CENTER);
		lblTelefone.setForeground(new Color(47, 79, 79));
		lblTelefone.setFont(new Font("OCR A Extended", Font.BOLD, 20));
		lblTelefone.setBackground(Color.BLACK);
		lblTelefone.setBounds(457, 286, 125, 39);
		add(lblTelefone);
		
		textTelUser = new JTextField();
		textTelUser.setHorizontalAlignment(SwingConstants.LEFT);
		textTelUser.setForeground(new Color(211, 211, 211));
		textTelUser.setFont(new Font("OCR A Extended", Font.PLAIN, 20));
		textTelUser.setColumns(10);
		textTelUser.setBackground(Color.WHITE);
		textTelUser.setBounds(584, 286, 203, 39);
		add(textTelUser);
		
		JButton btnSalvar = new JButton("Salvar");
		btnSalvar.setForeground(new Color(47, 79, 79));
		btnSalvar.setFont(new Font("OCR A Extended", Font.PLAIN, 20));
		btnSalvar.setBackground(new Color(245, 245, 245));
		btnSalvar.setBounds(414, 378, 117, 31);
		add(btnSalvar);
		
		JButton btnVoltar = new JButton("Voltar");
		btnVoltar.setForeground(new Color(47, 79, 79));
		btnVoltar.setFont(new Font("OCR A Extended", Font.PLAIN, 20));
		btnVoltar.setBackground(new Color(245, 245, 245));
		btnVoltar.setBounds(250, 378, 117, 31);
		add(btnVoltar);
		
		JLabel lblNomeNeg = new JLabel("Empresa:");
		lblNomeNeg.setHorizontalAlignment(SwingConstants.CENTER);
		lblNomeNeg.setForeground(new Color(47, 79, 79));
		lblNomeNeg.setFont(new Font("OCR A Extended", Font.BOLD, 20));
		lblNomeNeg.setBackground(Color.BLACK);
		lblNomeNeg.setBounds(10, 312, 125, 39);
		add(lblNomeNeg);
		
		JLabel lblAtualizarPerfil = new JLabel("Atualizar Meus Dados");
		lblAtualizarPerfil.setHorizontalAlignment(SwingConstants.CENTER);
		lblAtualizarPerfil.setForeground(new Color(47, 79, 79));
		lblAtualizarPerfil.setFont(new Font("OCR A Extended", Font.BOLD, 40));
		lblAtualizarPerfil.setBackground(Color.BLACK);
		lblAtualizarPerfil.setBounds(136, 27, 523, 59);
		add(lblAtualizarPerfil);

	}
}
