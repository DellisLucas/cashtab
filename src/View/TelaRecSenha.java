package View;

import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import DAO.UsuarioDAO;
import Model.Usuario;

import javax.swing.JButton;
import javax.swing.JFrame;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.Connection;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;

public class TelaRecSenha extends JPanel {

    private static final long serialVersionUID = 1L;
    private JTextField textEmail;
    private JTextField textNovaSenha;
    private JTextField textConfirmaSenha;

    private Connection conexao;

    public TelaRecSenha(Connection conexao) {
        this.conexao = conexao;

        setBackground(new Color(245, 245, 245));
        setLayout(null);

        JLabel lblRecuperarSenha = new JLabel("Recuperar Senha");
        lblRecuperarSenha.setForeground(new Color(47, 79, 79));
        lblRecuperarSenha.setFont(new Font("OCR A Extended", Font.BOLD, 30));
        lblRecuperarSenha.setBounds(256, 10, 295, 40);
        add(lblRecuperarSenha);

        JLabel lblEmail = new JLabel("Email:");
        lblEmail.setHorizontalAlignment(JLabel.RIGHT);
        lblEmail.setForeground(new Color(47, 79, 79));
        lblEmail.setFont(new Font("OCR A Extended", Font.BOLD, 20));
        lblEmail.setBounds(79, 80, 200, 30);
        add(lblEmail);

        textEmail = new JTextField();
        textEmail.setForeground(new Color(47, 79, 79));
        textEmail.setFont(new Font("OCR A Extended", Font.PLAIN, 20));
        textEmail.setBounds(311, 80, 200, 30);
        textEmail.addFocusListener(new FocusAdapter() {
            @Override
            public void focusLost(FocusEvent e) {
                verificarEmail();
            }
        });
        add(textEmail);

        JLabel lblNovaSenha = new JLabel("Nova Senha:");
        lblNovaSenha.setHorizontalAlignment(JLabel.RIGHT);
        lblNovaSenha.setForeground(new Color(47, 79, 79));
        lblNovaSenha.setFont(new Font("OCR A Extended", Font.BOLD, 20));
        lblNovaSenha.setBounds(79, 130, 200, 30);
        add(lblNovaSenha);

        textNovaSenha = new JTextField();
        textNovaSenha.setForeground(new Color(47, 79, 79));
        textNovaSenha.setFont(new Font("OCR A Extended", Font.PLAIN, 20));
        textNovaSenha.setBounds(311, 130, 200, 30);
        textNovaSenha.setEnabled(false);
        add(textNovaSenha);

        JLabel lblConfirmaSenha = new JLabel("Confirmar Senha:");
        lblConfirmaSenha.setHorizontalAlignment(JLabel.RIGHT);
        lblConfirmaSenha.setForeground(new Color(47, 79, 79));
        lblConfirmaSenha.setFont(new Font("OCR A Extended", Font.BOLD, 20));
        lblConfirmaSenha.setBounds(57, 180, 222, 30);
        add(lblConfirmaSenha);

        textConfirmaSenha = new JTextField();
        textConfirmaSenha.setForeground(new Color(47, 79, 79));
        textConfirmaSenha.setFont(new Font("OCR A Extended", Font.PLAIN, 20));
        textConfirmaSenha.setBounds(311, 180, 200, 30);
        textConfirmaSenha.setEnabled(false);
        add(textConfirmaSenha);

        JButton btnVoltar = new JButton("Voltar");
        btnVoltar.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                JFrame parentFrame = (JFrame) TelaRecSenha.this.getTopLevelAncestor();
                if (parentFrame != null) {
                    parentFrame.dispose();  // This will close the JFrame
                }
            }
        });
        btnVoltar.setForeground(new Color(47, 79, 79));
        btnVoltar.setFont(new Font("OCR A Extended", Font.PLAIN, 20));
        btnVoltar.setBounds(144, 258, 135, 30);
        add(btnVoltar);

        JButton btnSalvar = new JButton("Salvar");
        btnSalvar.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                salvarNovaSenha();
            }
        });
        btnSalvar.setForeground(new Color(47, 79, 79));
        btnSalvar.setFont(new Font("OCR A Extended", Font.PLAIN, 20));
        btnSalvar.setBounds(359, 258, 121, 30);
        btnSalvar.setEnabled(false);
        add(btnSalvar);
    }

    private void verificarEmail() {
        UsuarioDAO usuarioDAO = new UsuarioDAO(conexao);
        String email = textEmail.getText();

        try {
            Usuario usuario = usuarioDAO.getUsuarioByEmail(email);

            if (usuario != null) {
                textNovaSenha.setEnabled(true);
                textConfirmaSenha.setEnabled(true);
                JOptionPane.showMessageDialog(null, "Email encontrado. Por favor, insira a nova senha.");
            } else {
                textNovaSenha.setEnabled(false);
                textConfirmaSenha.setEnabled(false);
                JOptionPane.showMessageDialog(null, "Email não encontrado!", "Erro", JOptionPane.ERROR_MESSAGE);
            }
        } catch (Exception ex) {
            ex.printStackTrace();
            JOptionPane.showMessageDialog(null, "Erro ao verificar email! " + ex.getMessage());
        }
    }

    private void salvarNovaSenha() {
        UsuarioDAO usuarioDAO = new UsuarioDAO(conexao);
        String email = textEmail.getText();
        String novaSenha = textNovaSenha.getText();
        String confirmaSenha = textConfirmaSenha.getText();

        if (!novaSenha.equals(confirmaSenha)) {
            JOptionPane.showMessageDialog(null, "As senhas não coincidem!", "Erro", JOptionPane.ERROR_MESSAGE);
            return;
        }

        try {
            boolean sucesso = usuarioDAO.updateSenha(email, novaSenha);
            if (sucesso) {
                JOptionPane.showMessageDialog(null, "Senha atualizada com sucesso!");
                textEmail.setText("");
                textNovaSenha.setText("");
                textConfirmaSenha.setText("");
                textNovaSenha.setEnabled(false);
                textConfirmaSenha.setEnabled(false);
            } else {
                JOptionPane.showMessageDialog(null, "Erro ao atualizar a senha!", "Erro", JOptionPane.ERROR_MESSAGE);
            }
        } catch (Exception ex) {
            ex.printStackTrace();
            JOptionPane.showMessageDialog(null, "Erro ao atualizar a senha! " + ex.getMessage());
        }
    }
}
