package View;


import javax.swing.JPanel;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.SwingConstants;

import DAO.FornecedorDAO;
import DAO.ProdutoDAO;
import Model.Fornecedor;
import Model.Produto;

import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JFrame;

import java.awt.event.ActionListener;
import java.math.BigDecimal;
import java.sql.Connection;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class TelaRegistroForn extends JPanel {

	private static final long serialVersionUID = 1L;
	private JTextField textTelForn;
	private JTextField textMailForn;
	private JTextField textNomeForn;
	private JTextField textEndForn;
	private JTextField textEstForn;
	private JTextField textCidadeForn;

	/**
	 * Create the panel.
	 */
	public TelaRegistroForn() {
		setBackground(new Color(245, 245, 245));
		setLayout(null);
		
		JLabel lblRegistroForn = new JLabel("Registro de Fornecedores");
		lblRegistroForn.setHorizontalAlignment(SwingConstants.CENTER);
		lblRegistroForn.setForeground(new Color(47, 79, 79));
		lblRegistroForn.setFont(new Font("OCR A Extended", Font.BOLD, 40));
		lblRegistroForn.setBackground(Color.BLACK);
		lblRegistroForn.setBounds(76, 24, 639, 43);
		add(lblRegistroForn);
		
		JButton btnVoltar = new JButton("Voltar");
		btnVoltar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				JFrame parentFrame = (JFrame) TelaRegistroForn.this.getTopLevelAncestor();
                if (parentFrame != null) {
                    parentFrame.dispose();  // This will close the JFrame
                }
			}
		});
		btnVoltar.setForeground(new Color(47, 79, 79));
		btnVoltar.setFont(new Font("OCR A Extended", Font.PLAIN, 20));
		btnVoltar.setBackground(new Color(245, 245, 245));
		btnVoltar.setBounds(260, 365, 117, 31);
		add(btnVoltar);
		
		JButton btnRegistrar = new JButton("Salvar");
		btnRegistrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Connection conexao = null;
				FornecedorDAO fornecedorDAO = new FornecedorDAO(conexao);
                Fornecedor fornecedor = new Fornecedor();

                try {
                	fornecedor.setNomeFornecedor(textNomeForn.getText());
                	fornecedor.setTelefone(textTelForn.getText());
                	fornecedor.setEndereco(textEndForn.getText());  
                	fornecedor.setCidade(textCidadeForn.getText());
                	fornecedor.setEstado(textEstForn.getText());
                	fornecedor.setEmailForn(textMailForn.getText());
                	
                	
                	fornecedorDAO.create(fornecedor);
                    JOptionPane.showMessageDialog(null, "Produto adicionado com sucesso!");
                    textNomeForn.setText("");
                    textTelForn.setText("");
                    textEndForn.setText("");
                    textCidadeForn.setText("");
                    textEstForn.setText("");
                } catch (Exception ex) {
                    System.out.println("Erro ao formatar número: " + ex.getMessage());
                    JOptionPane.showMessageDialog(null, "Erro ao adicionar despesa! " + ex.getMessage());
                }
			}
		});
		btnRegistrar.setForeground(new Color(47, 79, 79));
		btnRegistrar.setFont(new Font("OCR A Extended", Font.PLAIN, 20));
		btnRegistrar.setBackground(new Color(245, 245, 245));
		btnRegistrar.setBounds(430, 365, 117, 31);
		add(btnRegistrar);
		
		textTelForn = new JTextField();
		textTelForn.setHorizontalAlignment(SwingConstants.LEFT);
		textTelForn.setForeground(new Color(0, 0, 0));
		textTelForn.setFont(new Font("OCR A Extended", Font.PLAIN, 20));
		textTelForn.setColumns(10);
		textTelForn.setBackground(Color.WHITE);
		textTelForn.setBounds(250, 196, 402, 39);
		add(textTelForn);
		
		JLabel lblTelefoneForn = new JLabel("Telefone:");
		lblTelefoneForn.setHorizontalAlignment(SwingConstants.CENTER);
		lblTelefoneForn.setForeground(new Color(47, 79, 79));
		lblTelefoneForn.setFont(new Font("OCR A Extended", Font.BOLD, 20));
		lblTelefoneForn.setBackground(Color.BLACK);
		lblTelefoneForn.setBounds(125, 196, 128, 39);
		add(lblTelefoneForn);
		
		JLabel lblEmailForn = new JLabel("E-mail:");
		lblEmailForn.setHorizontalAlignment(SwingConstants.CENTER);
		lblEmailForn.setForeground(new Color(47, 79, 79));
		lblEmailForn.setFont(new Font("OCR A Extended", Font.BOLD, 20));
		lblEmailForn.setBackground(Color.BLACK);
		lblEmailForn.setBounds(145, 146, 115, 39);
		add(lblEmailForn);
		
		textMailForn = new JTextField();
		textMailForn.setHorizontalAlignment(SwingConstants.LEFT);
		textMailForn.setForeground(new Color(0, 0, 0));
		textMailForn.setFont(new Font("OCR A Extended", Font.PLAIN, 20));
		textMailForn.setColumns(10);
		textMailForn.setBackground(Color.WHITE);
		textMailForn.setBounds(250, 146, 402, 39);
		add(textMailForn);
		
		textNomeForn = new JTextField();
		textNomeForn.setHorizontalAlignment(SwingConstants.LEFT);
		textNomeForn.setForeground(new Color(0, 0, 0));
		textNomeForn.setFont(new Font("OCR A Extended", Font.PLAIN, 20));
		textNomeForn.setColumns(10);
		textNomeForn.setBackground(Color.WHITE);
		textNomeForn.setBounds(250, 96, 402, 39);
		add(textNomeForn);
		
		JLabel lblNomeForn = new JLabel("Fornecedor:");
		lblNomeForn.setHorizontalAlignment(SwingConstants.CENTER);
		lblNomeForn.setForeground(new Color(47, 79, 79));
		lblNomeForn.setFont(new Font("OCR A Extended", Font.BOLD, 20));
		lblNomeForn.setBackground(Color.BLACK);
		lblNomeForn.setBounds(104, 96, 145, 39);
		add(lblNomeForn);
		
		JLabel lblEndForn = new JLabel("Endereço:");
		lblEndForn.setHorizontalAlignment(SwingConstants.CENTER);
		lblEndForn.setForeground(new Color(47, 79, 79));
		lblEndForn.setFont(new Font("OCR A Extended", Font.BOLD, 20));
		lblEndForn.setBackground(Color.BLACK);
		lblEndForn.setBounds(125, 246, 128, 39);
		add(lblEndForn);
		
		textEndForn = new JTextField();
		textEndForn.setHorizontalAlignment(SwingConstants.LEFT);
		textEndForn.setForeground(new Color(0, 0, 0));
		textEndForn.setFont(new Font("OCR A Extended", Font.PLAIN, 20));
		textEndForn.setColumns(10);
		textEndForn.setBackground(Color.WHITE);
		textEndForn.setBounds(250, 246, 402, 39);
		add(textEndForn);
		
		textEstForn = new JTextField();
		textEstForn.setHorizontalAlignment(SwingConstants.LEFT);
		textEstForn.setForeground(new Color(0, 0, 0));
		textEstForn.setFont(new Font("OCR A Extended", Font.PLAIN, 20));
		textEstForn.setColumns(10);
		textEstForn.setBackground(Color.WHITE);
		textEstForn.setBounds(550, 295, 102, 39);
		add(textEstForn);
		
		JLabel lblEstadoForn = new JLabel("Estado:");
		lblEstadoForn.setHorizontalAlignment(SwingConstants.CENTER);
		lblEstadoForn.setForeground(new Color(47, 79, 79));
		lblEstadoForn.setFont(new Font("OCR A Extended", Font.BOLD, 20));
		lblEstadoForn.setBackground(Color.BLACK);
		lblEstadoForn.setBounds(444, 295, 115, 39);
		add(lblEstadoForn);
		
		JLabel lblCidadeForn = new JLabel("Cidade:");
		lblCidadeForn.setHorizontalAlignment(SwingConstants.CENTER);
		lblCidadeForn.setForeground(new Color(47, 79, 79));
		lblCidadeForn.setFont(new Font("OCR A Extended", Font.BOLD, 20));
		lblCidadeForn.setBackground(Color.BLACK);
		lblCidadeForn.setBounds(143, 296, 117, 39);
		add(lblCidadeForn);
		
		textCidadeForn = new JTextField();
		textCidadeForn.setHorizontalAlignment(SwingConstants.LEFT);
		textCidadeForn.setForeground(new Color(0, 0, 0));
		textCidadeForn.setFont(new Font("OCR A Extended", Font.PLAIN, 20));
		textCidadeForn.setColumns(10);
		textCidadeForn.setBackground(Color.WHITE);
		textCidadeForn.setBounds(250, 296, 202, 39);
		add(textCidadeForn);

	}

}
