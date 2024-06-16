package View;


import javax.swing.JPanel;
import java.awt.Color;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JButton;

public class TelaSairPerfil extends JPanel {

	private static final long serialVersionUID = 1L;

	/**
	 * Create the panel.
	 */
	public TelaSairPerfil() {
		setBackground(new Color(245, 245, 245));
		setLayout(null);
		
		JLabel lblSair = new JLabel("Sign out to CashTab");
		lblSair.setHorizontalAlignment(SwingConstants.CENTER);
		lblSair.setForeground(new Color(47, 79, 79));
		lblSair.setFont(new Font("OCR A Extended", Font.BOLD, 40));
		lblSair.setBackground(Color.BLACK);
		lblSair.setBounds(144, 97, 492, 59);
		add(lblSair);
		
		JButton btnSignOut = new JButton("Sign out");
		btnSignOut.setForeground(new Color(47, 79, 79));
		btnSignOut.setFont(new Font("OCR A Extended", Font.PLAIN, 20));
		btnSignOut.setBackground(new Color(245, 245, 245));
		btnSignOut.setBounds(323, 217, 135, 31);
		add(btnSignOut);

	}

}
