package View;

import java.awt.Color;
import java.awt.Font;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

import DAO.ConexãoBanco;
import DAO.UsuarioDAO;
import Model.Usuario;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.Connection;

public class TelaSignIn extends JPanel {

    private static final long serialVersionUID = 1L;
    private JTextField txtEmail;
    private JTextField txtSenha;

    private Connection conexao;
    private Usuario usuarioLogado; // Campo para armazenar o usuário logado

    /**
     * Create the panel.
     */
    public TelaSignIn() {
        conexao = ConexãoBanco.conectar();

        setBackground(new Color(245, 245, 245));
        setLayout(null);

        JLabel lblLogin = new JLabel("Sign in to CashTab");
        lblLogin.setForeground(new Color(47, 79, 79));
        lblLogin.setFont(new Font("OCR A Extended", Font.BOLD, 40));
        lblLogin.setHorizontalAlignment(SwingConstants.CENTER);
        lblLogin.setBounds(183, 14, 451, 59);
        add(lblLogin);

        JLabel lblEmail = new JLabel("E-mail:");
        lblEmail.setHorizontalAlignment(SwingConstants.CENTER);
        lblEmail.setForeground(new Color(47, 79, 79));
        lblEmail.setFont(new Font("OCR A Extended", Font.BOLD, 20));
        lblEmail.setBounds(78, 127, 182, 39);
        add(lblEmail);

        txtEmail = new JTextField();
        txtEmail.setHorizontalAlignment(SwingConstants.LEFT);
        txtEmail.setForeground(Color.BLACK);
        txtEmail.setFont(new Font("OCR A Extended", Font.PLAIN, 20));
        txtEmail.setBounds(223, 127, 402, 39);
        add(txtEmail);
        txtEmail.setColumns(10);

        JLabel lblSenha = new JLabel("Senha:");
        lblSenha.setHorizontalAlignment(SwingConstants.CENTER);
        lblSenha.setForeground(new Color(47, 79, 79));
        lblSenha.setFont(new Font("OCR A Extended", Font.BOLD, 20));
        lblSenha.setBounds(78, 208, 182, 39);
        add(lblSenha);

        txtSenha = new JTextField();
        txtSenha.setHorizontalAlignment(SwingConstants.LEFT);
        txtSenha.setForeground(Color.BLACK);
        txtSenha.setFont(new Font("OCR A Extended", Font.PLAIN, 20));
        txtSenha.setColumns(10);
        txtSenha.setBounds(223, 208, 402, 39);
        add(txtSenha);

        JButton btnConfirmar = new JButton("Sign in");
        btnConfirmar.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                try {
                    String email = txtEmail.getText();
                    String senha = txtSenha.getText();

                    UsuarioDAO usuarioDAO = new UsuarioDAO(conexao);
                    usuarioLogado = usuarioDAO.login(email, senha); // Obtém o usuário logado

                    if (usuarioLogado != null) {
                        ConexãoBanco.fecharConexao(conexao);
                        JFrame frame = (JFrame) getTopLevelAncestor();
                        frame.setContentPane(new TelaHome(usuarioLogado)); // Passa o usuário logado
                        frame.revalidate();
                    } else {
                        System.out.println("Email ou senha incorretos.");
                        JOptionPane.showMessageDialog(null, "Email ou senha incorretos.", "Erro", JOptionPane.ERROR_MESSAGE);
                    }
                } catch (Exception ex) {
                    ex.printStackTrace();
                    System.out.println("Erro ao fazer login.");
                    JOptionPane.showMessageDialog(null, "Erro ao fazer login.", "Erro", JOptionPane.ERROR_MESSAGE);
                }
            }
        });
        btnConfirmar.setBackground(new Color(245, 245, 245));
        btnConfirmar.setForeground(new Color(47, 79, 79));
        btnConfirmar.setFont(new Font("OCR A Extended", Font.PLAIN, 20));
        btnConfirmar.setBounds(335, 372, 128, 31);
        add(btnConfirmar);

        JLabel lblForgetMy = new JLabel("Esqueceu sua senha?");
        lblForgetMy.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                JFrame frame = (JFrame) getTopLevelAncestor();
                frame.setContentPane(new TelaRecSenha(conexao));
                frame.revalidate();
            }
        });
        lblForgetMy.setHorizontalAlignment(SwingConstants.CENTER);
        lblForgetMy.setForeground(new Color(47, 79, 79));
        lblForgetMy.setFont(new Font("OCR A Extended", Font.BOLD, 17));
        lblForgetMy.setBounds(373, 254, 324, 39);
        add(lblForgetMy);

        JLabel lblAindaNoPossui = new JLabel("Ainda não possui cadastro?");
        lblAindaNoPossui.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                JFrame frame = (JFrame) getTopLevelAncestor();
                frame.setContentPane(new TelaSignUp());
                frame.revalidate();
            }
        });
        lblAindaNoPossui.setHorizontalAlignment(SwingConstants.CENTER);
        lblAindaNoPossui.setForeground(new Color(47, 79, 79));
        lblAindaNoPossui.setFont(new Font("OCR A Extended", Font.BOLD, 17));
        lblAindaNoPossui.setBounds(411, 291, 324, 39);
        add(lblAindaNoPossui);
    }
}
