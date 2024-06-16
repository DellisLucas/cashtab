package View;


import javax.swing.JPanel;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.SwingConstants;

import DAO.UsuarioDAO;
import Model.Usuario;

import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JFrame;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class TelaSignUp extends JPanel {

	private static final long serialVersionUID = 1L;
	private JTextField textMail;
	private JTextField textName;
	private JTextField textCNPJ;
	private JTextField textMEI;
	private JTextField textNomNeg;
	private JTextField textEndereco;
	private JTextField textCidade;
	private JTextField textEstado;
	private JTextField textField;
	private JTextField textSenha;

	/**
	 * Create the panel.
	 */
	public TelaSignUp() {
		setBackground(new Color(245, 245, 245));
		setLayout(null);
		
		JLabel lblCadastrar = new JLabel("Sign up to CashTab");
		lblCadastrar.setHorizontalAlignment(SwingConstants.CENTER);
		lblCadastrar.setForeground(new Color(47, 79, 79));
		lblCadastrar.setFont(new Font("OCR A Extended", Font.BOLD, 40));
		lblCadastrar.setBackground(Color.BLACK);
		lblCadastrar.setBounds(185, 23, 451, 59);
		add(lblCadastrar);
		
		JLabel lblEmail = new JLabel("E-mail:");
		lblEmail.setHorizontalAlignment(SwingConstants.CENTER);
		lblEmail.setForeground(new Color(47, 79, 79));
		lblEmail.setFont(new Font("OCR A Extended", Font.BOLD, 20));
		lblEmail.setBackground(Color.BLACK);
		lblEmail.setBounds(10, 102, 115, 39);
		add(lblEmail);
		
		textMail = new JTextField();
		textMail.setHorizontalAlignment(SwingConstants.LEFT);
		textMail.setForeground(Color.BLACK);
		textMail.setFont(new Font("OCR A Extended", Font.PLAIN, 20));
		textMail.setColumns(10);
		textMail.setBackground(Color.WHITE);
		textMail.setBounds(115, 102, 322, 39);
		add(textMail);
		
		JLabel lblName = new JLabel("Nome:");
		lblName.setHorizontalAlignment(SwingConstants.CENTER);
		lblName.setForeground(new Color(47, 79, 79));
		lblName.setFont(new Font("OCR A Extended", Font.BOLD, 20));
		lblName.setBackground(Color.BLACK);
		lblName.setBounds(10, 152, 115, 39);
		add(lblName);
		
		textName = new JTextField();
		textName.setHorizontalAlignment(SwingConstants.LEFT);
		textName.setForeground(Color.BLACK);
		textName.setFont(new Font("OCR A Extended", Font.PLAIN, 20));
		textName.setColumns(10);
		textName.setBackground(Color.WHITE);
		textName.setBounds(115, 152, 322, 39);
		add(textName);
		
		JLabel lblCNPJ = new JLabel("CNPJ:");
		lblCNPJ.setHorizontalAlignment(SwingConstants.CENTER);
		lblCNPJ.setForeground(new Color(47, 79, 79));
		lblCNPJ.setFont(new Font("OCR A Extended", Font.BOLD, 20));
		lblCNPJ.setBackground(Color.BLACK);
		lblCNPJ.setBounds(10, 202, 115, 39);
		add(lblCNPJ);
		
		textCNPJ = new JTextField();
		textCNPJ.setHorizontalAlignment(SwingConstants.LEFT);
		textCNPJ.setForeground(Color.BLACK);
		textCNPJ.setFont(new Font("OCR A Extended", Font.PLAIN, 20));
		textCNPJ.setColumns(10);
		textCNPJ.setBackground(Color.WHITE);
		textCNPJ.setBounds(115, 202, 322, 39);
		add(textCNPJ);
		
		textMEI = new JTextField();
		textMEI.setHorizontalAlignment(SwingConstants.LEFT);
		textMEI.setForeground(Color.BLACK);
		textMEI.setFont(new Font("OCR A Extended", Font.PLAIN, 20));
		textMEI.setColumns(10);
		textMEI.setBackground(Color.WHITE);
		textMEI.setBounds(115, 252, 322, 39);
		add(textMEI);
		
		JLabel lblMEI = new JLabel("MEI:");
		lblMEI.setHorizontalAlignment(SwingConstants.CENTER);
		lblMEI.setForeground(new Color(47, 79, 79));
		lblMEI.setFont(new Font("OCR A Extended", Font.BOLD, 20));
		lblMEI.setBackground(Color.BLACK);
		lblMEI.setBounds(10, 252, 115, 39);
		add(lblMEI);
		
		textNomNeg = new JTextField();
		textNomNeg.setHorizontalAlignment(SwingConstants.LEFT);
		textNomNeg.setForeground(Color.BLACK);
		textNomNeg.setFont(new Font("OCR A Extended", Font.PLAIN, 20));
		textNomNeg.setColumns(10);
		textNomNeg.setBackground(Color.WHITE);
		textNomNeg.setBounds(115, 302, 322, 39);
		add(textNomNeg);
		
		JLabel lblNomeNeg = new JLabel("Empresa:");
		lblNomeNeg.setHorizontalAlignment(SwingConstants.CENTER);
		lblNomeNeg.setForeground(new Color(47, 79, 79));
		lblNomeNeg.setFont(new Font("OCR A Extended", Font.BOLD, 20));
		lblNomeNeg.setBackground(Color.BLACK);
		lblNomeNeg.setBounds(0, 302, 125, 39);
		add(lblNomeNeg);
		
		textEndereco = new JTextField();
		textEndereco.setHorizontalAlignment(SwingConstants.LEFT);
		textEndereco.setForeground(Color.BLACK);
		textEndereco.setFont(new Font("OCR A Extended", Font.PLAIN, 20));
		textEndereco.setColumns(10);
		textEndereco.setBackground(Color.WHITE);
		textEndereco.setBounds(574, 102, 203, 39);
		add(textEndereco);
		
		JLabel lblEndereco = new JLabel("Endereço:");
		lblEndereco.setHorizontalAlignment(SwingConstants.CENTER);
		lblEndereco.setForeground(new Color(47, 79, 79));
		lblEndereco.setFont(new Font("OCR A Extended", Font.BOLD, 20));
		lblEndereco.setBackground(Color.BLACK);
		lblEndereco.setBounds(457, 102, 115, 39);
		add(lblEndereco);
		
		JLabel lblCidade = new JLabel("Cidade:");
		lblCidade.setHorizontalAlignment(SwingConstants.CENTER);
		lblCidade.setForeground(new Color(47, 79, 79));
		lblCidade.setFont(new Font("OCR A Extended", Font.BOLD, 20));
		lblCidade.setBackground(Color.BLACK);
		lblCidade.setBounds(457, 152, 115, 39);
		add(lblCidade);
		
		textCidade = new JTextField();
		textCidade.setHorizontalAlignment(SwingConstants.LEFT);
		textCidade.setForeground(Color.BLACK);
		textCidade.setFont(new Font("OCR A Extended", Font.PLAIN, 20));
		textCidade.setColumns(10);
		textCidade.setBackground(Color.WHITE);
		textCidade.setBounds(574, 152, 203, 39);
		add(textCidade);
		
		JLabel lblEstado = new JLabel("Estado:");
		lblEstado.setHorizontalAlignment(SwingConstants.CENTER);
		lblEstado.setForeground(new Color(47, 79, 79));
		lblEstado.setFont(new Font("OCR A Extended", Font.BOLD, 20));
		lblEstado.setBackground(Color.BLACK);
		lblEstado.setBounds(457, 202, 115, 39);
		add(lblEstado);
		
		textEstado = new JTextField();
		textEstado.setHorizontalAlignment(SwingConstants.LEFT);
		textEstado.setForeground(Color.BLACK);
		textEstado.setFont(new Font("OCR A Extended", Font.PLAIN, 20));
		textEstado.setColumns(10);
		textEstado.setBackground(Color.WHITE);
		textEstado.setBounds(574, 202, 203, 39);
		add(textEstado);
		
		JLabel lblTelefone = new JLabel("Telefone:");
		lblTelefone.setHorizontalAlignment(SwingConstants.CENTER);
		lblTelefone.setForeground(new Color(47, 79, 79));
		lblTelefone.setFont(new Font("OCR A Extended", Font.BOLD, 20));
		lblTelefone.setBackground(Color.BLACK);
		lblTelefone.setBounds(447, 252, 125, 39);
		add(lblTelefone);
		
		textField = new JTextField();
		textField.setHorizontalAlignment(SwingConstants.LEFT);
		textField.setForeground(Color.BLACK);
		textField.setFont(new Font("OCR A Extended", Font.PLAIN, 20));
		textField.setColumns(10);
		textField.setBackground(Color.WHITE);
		textField.setBounds(574, 252, 203, 39);
		add(textField);
		
		JLabel lblSenha = new JLabel("Senha:");
		lblSenha.setHorizontalAlignment(SwingConstants.CENTER);
		lblSenha.setForeground(new Color(47, 79, 79));
		lblSenha.setFont(new Font("OCR A Extended", Font.BOLD, 20));
		lblSenha.setBackground(Color.BLACK);
		lblSenha.setBounds(470, 302, 115, 39);
		add(lblSenha);
		
		textSenha = new JTextField();
		textSenha.setHorizontalAlignment(SwingConstants.LEFT);
		textSenha.setForeground(Color.BLACK);
		textSenha.setFont(new Font("OCR A Extended", Font.PLAIN, 20));
		textSenha.setColumns(10);
		textSenha.setBackground(Color.WHITE);
		textSenha.setBounds(574, 302, 203, 39);
		add(textSenha);
		
		JButton btnSignUp = new JButton("Sign up");
		btnSignUp.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				salvarUsuario();
			}
		});
		btnSignUp.setForeground(new Color(47, 79, 79));
		btnSignUp.setFont(new Font("OCR A Extended", Font.PLAIN, 20));
		btnSignUp.setBackground(new Color(245, 245, 245));
		btnSignUp.setBounds(404, 375, 130, 31);
		add(btnSignUp);
		
		JButton btnVoltar = new JButton("Voltar");
		btnVoltar.setForeground(new Color(47, 79, 79));
		btnVoltar.setFont(new Font("OCR A Extended", Font.PLAIN, 20));
		btnVoltar.setBackground(new Color(245, 245, 245));
		btnVoltar.setBounds(240, 375, 117, 31);
		add(btnVoltar);

	}
	
	public void salvarUsuario() {
        // Obtém os dados dos campos de texto
        String email = textMail.getText();
        String nome = textName.getText();
        String cnpj = textCNPJ.getText();
        String mei = textMEI.getText();
        String empresa = textNomNeg.getText();
        String endereco = textEndereco.getText();
        String cidade = textCidade.getText();
        String estado = textEstado.getText();
        String senha = textSenha.getText();

        Usuario usuario = new Usuario(1, nome, cnpj, empresa, mei, endereco, cidade, estado, email, senha);

        UsuarioDAO usuarioDAO = new UsuarioDAO(null);
        boolean sucesso = usuarioDAO.salvarUsuario(usuario);

        if (sucesso) {
            System.out.println("Usuário cadastrado com sucesso!");
            JOptionPane.showMessageDialog(null, "MEI Cadastrado com sucesso!");
			JFrame frame = new JFrame();
            frame.setSize(800, 500);
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.setLocationRelativeTo(null);
            frame.setContentPane(new TelaHome(null));
            frame.setVisible(true);
            TelaSignUp.this.dispose(); // Fecha a tela
        } else {
        	JOptionPane.showMessageDialog(null, "Erro ao cadastrar MEI!");
        }
    }

	private void dispose() {
		// TODO Auto-generated method stub
		
	}
}
