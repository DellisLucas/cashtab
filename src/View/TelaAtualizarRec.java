package Cashtab;

import javax.swing.JPanel;
import java.awt.Color;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.JButton;

public class TelaAtualizarRec extends JPanel {

	private static final long serialVersionUID = 1L;
	private JTextField textDescRec;
	private JTextField textDtRecebRec;
	private JTextField textVlrRec;
	private JTextField textCodRec;

	/**
	 * Create the panel.
	 */
	public TelaAtualizarRec() {
		setBackground(new Color(245, 245, 245));
		setLayout(null);
		
		JLabel lblAtualizarDadosDe = new JLabel("Atualizar Dados de Receitas");
		lblAtualizarDadosDe.setHorizontalAlignment(SwingConstants.CENTER);
		lblAtualizarDadosDe.setForeground(new Color(47, 79, 79));
		lblAtualizarDadosDe.setFont(new Font("OCR A Extended", Font.BOLD, 40));
		lblAtualizarDadosDe.setBounds(53, 29, 706, 55);
		add(lblAtualizarDadosDe);
		
		JLabel lblNewLabel = new JLabel("Descrição: ");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setForeground(new Color(47, 79, 79));
		lblNewLabel.setFont(new Font("OCR A Extended", Font.BOLD, 20));
		lblNewLabel.setBounds(178, 161, 144, 47);
		add(lblNewLabel);
		
		JLabel lblDataDoRecebimento = new JLabel("Data do Recebimento:");
		lblDataDoRecebimento.setHorizontalAlignment(SwingConstants.CENTER);
		lblDataDoRecebimento.setForeground(new Color(47, 79, 79));
		lblDataDoRecebimento.setFont(new Font("OCR A Extended", Font.BOLD, 20));
		lblDataDoRecebimento.setBounds(52, 225, 262, 40);
		add(lblDataDoRecebimento);
		
		JLabel lblValorRecebido = new JLabel("Valor Recebido: ");
		lblValorRecebido.setHorizontalAlignment(SwingConstants.CENTER);
		lblValorRecebido.setForeground(new Color(47, 79, 79));
		lblValorRecebido.setFont(new Font("OCR A Extended", Font.BOLD, 20));
		lblValorRecebido.setBounds(81, 275, 279, 47);
		add(lblValorRecebido);
		
		textDescRec = new JTextField();
		textDescRec.setHorizontalAlignment(SwingConstants.LEFT);
		textDescRec.setForeground(new Color(211, 211, 211));
		textDescRec.setFont(new Font("OCR A Extended", Font.PLAIN, 20));
		textDescRec.setColumns(10);
		textDescRec.setBackground(Color.WHITE);
		textDescRec.setBounds(317, 165, 402, 39);
		add(textDescRec);
		
		textDtRecebRec = new JTextField();
		textDtRecebRec.setHorizontalAlignment(SwingConstants.LEFT);
		textDtRecebRec.setForeground(new Color(211, 211, 211));
		textDtRecebRec.setFont(new Font("OCR A Extended", Font.PLAIN, 20));
		textDtRecebRec.setColumns(10);
		textDtRecebRec.setBackground(Color.WHITE);
		textDtRecebRec.setBounds(317, 223, 402, 39);
		add(textDtRecebRec);
		
		textVlrRec = new JTextField();
		textVlrRec.setHorizontalAlignment(SwingConstants.LEFT);
		textVlrRec.setForeground(new Color(211, 211, 211));
		textVlrRec.setFont(new Font("OCR A Extended", Font.PLAIN, 20));
		textVlrRec.setColumns(10);
		textVlrRec.setBackground(Color.WHITE);
		textVlrRec.setBounds(317, 279, 402, 39);
		add(textVlrRec);
		
		JButton btnAtualizar = new JButton("Salvar");
		btnAtualizar.setForeground(new Color(47, 79, 79));
		btnAtualizar.setFont(new Font("OCR A Extended", Font.PLAIN, 20));
		btnAtualizar.setBackground(new Color(245, 245, 245));
		btnAtualizar.setBounds(412, 350, 117, 31);
		add(btnAtualizar);
		
		JButton btnVoltar = new JButton("Voltar");
		btnVoltar.setForeground(new Color(47, 79, 79));
		btnVoltar.setFont(new Font("OCR A Extended", Font.PLAIN, 20));
		btnVoltar.setBackground(new Color(245, 245, 245));
		btnVoltar.setBounds(242, 350, 117, 31);
		add(btnVoltar);
		
		JLabel lblCodRec = new JLabel("Código:");
		lblCodRec.setHorizontalAlignment(SwingConstants.CENTER);
		lblCodRec.setForeground(new Color(47, 79, 79));
		lblCodRec.setFont(new Font("OCR A Extended", Font.BOLD, 20));
		lblCodRec.setBounds(191, 104, 144, 47);
		add(lblCodRec);
		
		textCodRec = new JTextField();
		textCodRec.setHorizontalAlignment(SwingConstants.LEFT);
		textCodRec.setForeground(new Color(211, 211, 211));
		textCodRec.setFont(new Font("OCR A Extended", Font.PLAIN, 20));
		textCodRec.setColumns(10);
		textCodRec.setBackground(Color.WHITE);
		textCodRec.setBounds(317, 108, 402, 39);
		add(textCodRec);

	}

}
