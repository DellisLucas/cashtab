package View;

import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import DAO.ProdutoDAO;
import Model.Produto;

import javax.swing.JButton;
import javax.swing.JFrame;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.math.BigDecimal;
import java.sql.Connection;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;

public class TelaAtualizarProd extends JPanel {

    private static final long serialVersionUID = 1L;
    private JTextField textDescProd;
    private JTextField textPrcUnitProduto;
    private JTextField textCodProd;

    private Connection conexao;

    public TelaAtualizarProd(Connection conexao) {
        this.conexao = conexao;

        setBackground(new Color(245, 245, 245));
        setLayout(null);

        JLabel lblAtualizarProd = new JLabel("Atualizar Dados de Produtos");
        lblAtualizarProd.setForeground(new Color(47, 79, 79));
        lblAtualizarProd.setFont(new Font("OCR A Extended", Font.BOLD, 30));
        lblAtualizarProd.setBounds(50, 20, 637, 40);
        add(lblAtualizarProd);

        JLabel lblCodProd = new JLabel("Código:");
        lblCodProd.setHorizontalAlignment(JLabel.RIGHT);
        lblCodProd.setForeground(new Color(47, 79, 79));
        lblCodProd.setFont(new Font("OCR A Extended", Font.BOLD, 20));
        lblCodProd.setBounds(79, 80, 200, 30);
        add(lblCodProd);

        textCodProd = new JTextField();
        textCodProd.addFocusListener(new FocusAdapter() {
        	@Override
        	public void focusLost(FocusEvent e) {
        		try {
                    int idProd = Integer.parseInt(textCodProd.getText());
                    ProdutoDAO produtoDAO = new ProdutoDAO(conexao);
                    Produto produto = produtoDAO.read(idProd);

                    if (produto != null) {
                        textDescProd.setText(produto.getDescProduto());
                        textPrcUnitProduto.setText(produto.getPrecoUnitario().toString());
                    } else {
                    	JOptionPane.showMessageDialog(null, "Produto não encontrado!", "Erro", JOptionPane.ERROR_MESSAGE);
                    }
                } catch (Exception ex) {
                    ex.printStackTrace();
                }
        	}
        });
        textCodProd.setForeground(new Color(47, 79, 79));
        textCodProd.setFont(new Font("OCR A Extended", Font.PLAIN, 20));
        textCodProd.setBounds(311, 80, 200, 30);
        add(textCodProd);

        JLabel lblNomeProd = new JLabel("Produto:");
        lblNomeProd.setHorizontalAlignment(JLabel.RIGHT);
        lblNomeProd.setForeground(new Color(47, 79, 79));
        lblNomeProd.setFont(new Font("OCR A Extended", Font.BOLD, 20));
        lblNomeProd.setBounds(79, 130, 200, 30);
        add(lblNomeProd);

        textDescProd = new JTextField();
        textDescProd.setForeground(new Color(47, 79, 79));
        textDescProd.setFont(new Font("OCR A Extended", Font.PLAIN, 20));
        textDescProd.setBounds(311, 130, 200, 30);
        add(textDescProd);

        JLabel lblPrecProd = new JLabel("Preço Unitário:");
        lblPrecProd.setHorizontalAlignment(JLabel.RIGHT);
        lblPrecProd.setForeground(new Color(47, 79, 79));
        lblPrecProd.setFont(new Font("OCR A Extended", Font.BOLD, 20));
        lblPrecProd.setBounds(79, 180, 200, 30);
        add(lblPrecProd);

        textPrcUnitProduto = new JTextField();
        textPrcUnitProduto.setForeground(new Color(47, 79, 79));
        textPrcUnitProduto.setFont(new Font("OCR A Extended", Font.PLAIN, 20));
        textPrcUnitProduto.setBounds(311, 180, 200, 30);
        add(textPrcUnitProduto);

        JButton btnVoltar = new JButton("Voltar");
        btnVoltar.addMouseListener(new MouseAdapter() {
        	@Override
        	public void mouseClicked(MouseEvent e) {
        		JFrame parentFrame = (JFrame) TelaAtualizarProd.this.getTopLevelAncestor();
                if (parentFrame != null) {
                    parentFrame.dispose();  // This will close the JFrame
                }
        	}
        });
        btnVoltar.setForeground(new Color(47, 79, 79));
        btnVoltar.setFont(new Font("OCR A Extended", Font.PLAIN, 20));
        btnVoltar.setBounds(144, 280, 135, 30);
        add(btnVoltar);

        JButton btnRegistrar = new JButton("Salvar");
        btnRegistrar.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
            	ProdutoDAO produtoDAO = new ProdutoDAO(null);
                Produto produto = new Produto();

                try {
                	produto.setIdProduto(Integer.parseInt(textCodProd.getText()));
                    produto.setDescProduto(textDescProd.getText());
                    produto.setPrecoUnitario(new BigDecimal(textPrcUnitProduto.getText()));

                    produtoDAO.update(produto);
                    JOptionPane.showMessageDialog(null, "Produto atualizado com sucesso!");
                    // Clear the text fields after saving
                    textCodProd.setText("");
                    textDescProd.setText("");
                    textPrcUnitProduto.setText("");
                } catch (Exception ex) {
                    System.out.println("Erro ao formatar número: " + ex.getMessage());
                    JOptionPane.showMessageDialog(null, "Erro ao adicionar despesa! " + ex.getMessage());
                }
            }
        });
        btnRegistrar.setForeground(new Color(47, 79, 79));
        btnRegistrar.setFont(new Font("OCR A Extended", Font.PLAIN, 20));
        btnRegistrar.setBounds(359, 280, 121, 30);
        add(btnRegistrar);

    }

	protected void dispose() {
		// TODO Auto-generated method stub
		
	}
	public void preencherCampos(String idProd, String descProd, String precoUnitario) {
	    textCodProd.setText(idProd);
	    textDescProd.setText(descProd);
	    textPrcUnitProduto.setText(precoUnitario);
	}

}