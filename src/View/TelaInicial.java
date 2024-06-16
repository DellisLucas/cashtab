package View;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class TelaInicial extends JFrame {

    private static final long serialVersionUID = 1L;

    /**
     * Create the frame.
     */
    public TelaInicial() {
        setTitle("CashTab");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 800, 600);
        getContentPane().setBackground(new Color(245, 245, 245));
        getContentPane().setLayout(null);

        JLabel lblCashTab = new JLabel("CashTab");
        lblCashTab.setHorizontalAlignment(SwingConstants.CENTER);
        lblCashTab.setForeground(new Color(47, 79, 79));
        lblCashTab.setFont(new Font("OCR A Extended", Font.BOLD, 70));
        lblCashTab.setBackground(Color.BLACK);
        lblCashTab.setBounds(160, 70, 451, 59);
        getContentPane().add(lblCashTab);

        JButton btnSignIn = new JButton("Sign in");
        btnSignIn.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                TelaSignIn telaSignIn = new TelaSignIn();
                setContentPane(telaSignIn);
                revalidate();
            }
        });
        btnSignIn.setForeground(new Color(47, 79, 79));
        btnSignIn.setFont(new Font("OCR A Extended", Font.PLAIN, 20));
        btnSignIn.setBackground(new Color(245, 245, 245));
        btnSignIn.setBounds(328, 221, 134, 31);
        getContentPane().add(btnSignIn);

        JButton btnSignUp = new JButton("Sign up");
        btnSignUp.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
            	TelaSignUp telaSignUp = new TelaSignUp();
            	setContentPane(telaSignUp);
                revalidate();
            }
        });
        btnSignUp.setForeground(new Color(47, 79, 79));
        btnSignUp.setFont(new Font("OCR A Extended", Font.PLAIN, 20));
        btnSignUp.setBackground(new Color(245, 245, 245));
        btnSignUp.setBounds(328, 295, 134, 31);
        getContentPane().add(btnSignUp);
    }

    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    TelaInicial frame = new TelaInicial();
                    frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }
}
