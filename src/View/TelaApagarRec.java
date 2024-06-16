package View;


import javax.swing.JPanel;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.SwingConstants;

import DAO.ProdutoDAO;
import DAO.ReceitaDAO;
import Model.Produto;
import Model.Receita;

import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JFrame;

import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.sql.Connection;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class TelaApagarRec extends JPanel {

	private static final long serialVersionUID = 1L;
	private JTextField textDescRec;
	private JTextField textDtRecebRec;
	private JTextField textVlrRecebRec;
	private JTextField textCodRec;

	/**
	 * Create the panel.
	 */
	public TelaApagarRec() {
		setBackground(new Color(245, 245, 245));
		setLayout(null);
		
		JLabel lblApagarDadosDe = new JLabel("Apagar Dados de Receitas");
		lblApagarDadosDe.setHorizontalAlignment(SwingConstants.CENTER);
		lblApagarDadosDe.setForeground(new Color(47, 79, 79));
		lblApagarDadosDe.setFont(new Font("OCR A Extended", Font.BOLD, 40));
		lblApagarDadosDe.setBounds(53, 29, 706, 55);
		add(lblApagarDadosDe);
		
		JLabel lblDescRec = new JLabel("Descrição: ");
		lblDescRec.setHorizontalAlignment(SwingConstants.CENTER);
		lblDescRec.setForeground(new Color(47, 79, 79));
		lblDescRec.setFont(new Font("OCR A Extended", Font.BOLD, 20));
		lblDescRec.setBounds(178, 161, 144, 47);
		add(lblDescRec);
		
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
		textDescRec.setForeground(new Color(0, 0, 0));
		textDescRec.setFont(new Font("OCR A Extended", Font.PLAIN, 20));
		textDescRec.setColumns(10);
		textDescRec.setBackground(Color.WHITE);
		textDescRec.setBounds(317, 165, 402, 39);
		add(textDescRec);
		
		textDtRecebRec = new JTextField();
		textDtRecebRec.setHorizontalAlignment(SwingConstants.LEFT);
		textDtRecebRec.setForeground(new Color(0, 0, 0));
		textDtRecebRec.setFont(new Font("OCR A Extended", Font.PLAIN, 20));
		textDtRecebRec.setColumns(10);
		textDtRecebRec.setBackground(Color.WHITE);
		textDtRecebRec.setBounds(317, 223, 402, 39);
		add(textDtRecebRec);
		
		textVlrRecebRec = new JTextField();
		textVlrRecebRec.setHorizontalAlignment(SwingConstants.LEFT);
		textVlrRecebRec.setForeground(new Color(0, 0, 0));
		textVlrRecebRec.setFont(new Font("OCR A Extended", Font.PLAIN, 20));
		textVlrRecebRec.setColumns(10);
		textVlrRecebRec.setBackground(Color.WHITE);
		textVlrRecebRec.setBounds(317, 279, 402, 39);
		add(textVlrRecebRec);
		
		JButton btnApagar = new JButton("Apagar");
		btnApagar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				ReceitaDAO receitaDAO = new ReceitaDAO(null);
                Receita receita = new Receita();

                try {
                    receitaDAO.delete(Integer.parseInt(textCodRec.getText()));
                    JOptionPane.showMessageDialog(null, "Receita deletada com sucesso!");
                    // Clear the text fields after saving
                    textCodRec.setText("");
                    textDescRec.setText("");
                    textVlrRecebRec.setText("");
                    textDtRecebRec.setText("");
                } catch (Exception ex) {
                    System.out.println("Erro ao formatar número: " + ex.getMessage());
                    JOptionPane.showMessageDialog(null, "Erro ao apagar receita! " + ex.getMessage());
                }
			}
		});
		btnApagar.setForeground(new Color(47, 79, 79));
		btnApagar.setFont(new Font("OCR A Extended", Font.PLAIN, 20));
		btnApagar.setBackground(new Color(245, 245, 245));
		btnApagar.setBounds(412, 350, 117, 31);
		add(btnApagar);
		
		JButton btnVoltar = new JButton("Voltar");
		btnVoltar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				JFrame parentFrame = (JFrame) TelaApagarRec.this.getTopLevelAncestor();
                if (parentFrame != null) {
                    parentFrame.dispose();  // Isso fechará o JFrame
                }
			}
		});
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
		textCodRec.addFocusListener(new FocusAdapter() {
			@Override
			public void focusLost(FocusEvent e) {
				try {
                    int idRec = Integer.parseInt(textCodRec.getText());
                    Connection conexao = null;
					ReceitaDAO receitaDAO = new ReceitaDAO(conexao);
                    Receita receita = ReceitaDAO.read(idRec);

                    if (receita != null) {
                        textDescRec.setText(receita.getDescReceita());
                        textDtRecebRec.setText(receita.getDataRecebimento().toString());
                        textVlrRecebRec.setText(receita.getValorRecebido().toString());
                    } else {
                    	JOptionPane.showMessageDialog(null, "Produto não encontrado!", "Erro", JOptionPane.ERROR_MESSAGE);
                    }
                } catch (Exception ex) {
                    ex.printStackTrace();
                }
			}
		});
		textCodRec.setHorizontalAlignment(SwingConstants.LEFT);
		textCodRec.setForeground(new Color(0, 0, 0));
		textCodRec.setFont(new Font("OCR A Extended", Font.PLAIN, 20));
		textCodRec.setColumns(10);
		textCodRec.setBackground(Color.WHITE);
		textCodRec.setBounds(317, 108, 402, 39);
		add(textCodRec);

	}
	
	public void preencherCampos(String id, String descricao, String dataRecebimento, String valorRecebido) {
        textCodRec.setText(id);
        textDescRec.setText(descricao);
        textDtRecebRec.setText(dataRecebimento);
        textVlrRecebRec.setText(valorRecebido);
    }

}
