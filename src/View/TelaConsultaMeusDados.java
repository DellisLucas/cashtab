package View;


import javax.swing.JPanel;
import java.awt.Color;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;

public class TelaConsultaMeusDados extends JPanel {

	private static final long serialVersionUID = 1L;

	/**
	 * Create the panel.
	 */
	public TelaConsultaMeusDados() {
		setBackground(new Color(245, 245, 245));
		setLayout(null);
		
		JLabel lblMeusDados = new JLabel("Meus Dados");
		lblMeusDados.setHorizontalAlignment(SwingConstants.CENTER);
		lblMeusDados.setForeground(new Color(47, 79, 79));
		lblMeusDados.setFont(new Font("OCR A Extended", Font.BOLD, 40));
		lblMeusDados.setBounds(138, 43, 515, 70);
		add(lblMeusDados);
		
		JLabel lblDellisFazO = new JLabel("Dellis, faz o PopUp dos\r\n Dados ");
		lblDellisFazO.setHorizontalAlignment(SwingConstants.CENTER);
		lblDellisFazO.setForeground(new Color(255, 99, 71));
		lblDellisFazO.setFont(new Font("OCR A Extended", Font.BOLD, 40));
		lblDellisFazO.setBounds(-36, 123, 904, 122);
		add(lblDellisFazO);
		
		JLabel lblDoUsurioAqui = new JLabel("do Usuário Aqui");
		lblDoUsurioAqui.setHorizontalAlignment(SwingConstants.CENTER);
		lblDoUsurioAqui.setForeground(new Color(178, 34, 34));
		lblDoUsurioAqui.setFont(new Font("OCR A Extended", Font.BOLD, 40));
		lblDoUsurioAqui.setBounds(150, 211, 515, 70);
		add(lblDoUsurioAqui);

	}

}
