package View;

import javax.swing.JPanel;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JFrame;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.math.BigDecimal;
import java.sql.Connection;
import DAO.ProdutoDAO;
import Model.Produto;
import Model.Usuario;

public class TelaRegistroProd extends JPanel {

    private static final long serialVersionUID = 1L;
    private JTextField textProd;
    private JTextField textPrecUnitProd;
    private Connection conexao;
    private Usuario usuario;

    /**
     * Create the panel.
     */
    public TelaRegistroProd(Connection conexao, Usuario usuario) {
        this.conexao = conexao;
        this.usuario = usuario;

        setBackground(new Color(245, 245, 245));
        setLayout(null);

        JLabel lblRegistroProd = new JLabel("Registro de Produtos");
        lblRegistroProd.setBounds(125, 22, 546, 43);
        lblRegistroProd.setHorizontalAlignment(SwingConstants.CENTER);
        lblRegistroProd.setForeground(new Color(47, 79, 79));
        lblRegistroProd.setFont(new Font("OCR A Extended", Font.BOLD, 40));
        lblRegistroProd.setBackground(Color.BLACK);
        add(lblRegistroProd);

        JLabel lblNomeProd = new JLabel("Produto: ");
        lblNomeProd.setHorizontalAlignment(SwingConstants.CENTER);
        lblNomeProd.setForeground(new Color(47, 79, 79));
        lblNomeProd.setFont(new Font("OCR A Extended", Font.BOLD, 20));
        lblNomeProd.setBackground(Color.BLACK);
        lblNomeProd.setBounds(114, 127, 182, 39);
        add(lblNomeProd);

        textProd = new JTextField();
        textProd.setHorizontalAlignment(SwingConstants.LEFT);
        textProd.setForeground(new Color(47, 79, 79));
        textProd.setFont(new Font("OCR A Extended", Font.PLAIN, 20));
        textProd.setColumns(10);
        textProd.setBackground(Color.WHITE);
        textProd.setBounds(259, 127, 402, 39);
        add(textProd);

        JLabel lblPrecProd = new JLabel("Preço Unitário: ");
        lblPrecProd.setHorizontalAlignment(SwingConstants.CENTER);
        lblPrecProd.setForeground(new Color(47, 79, 79));
        lblPrecProd.setFont(new Font("OCR A Extended", Font.BOLD, 20));
        lblPrecProd.setBackground(Color.BLACK);
        lblPrecProd.setBounds(37, 191, 240, 39);
        add(lblPrecProd);

        textPrecUnitProd = new JTextField();
        textPrecUnitProd.setHorizontalAlignment(SwingConstants.LEFT);
        textPrecUnitProd.setForeground(new Color(47, 79, 79));
        textPrecUnitProd.setFont(new Font("OCR A Extended", Font.PLAIN, 20));
        textPrecUnitProd.setColumns(10);
        textPrecUnitProd.setBackground(Color.WHITE);
        textPrecUnitProd.setBounds(259, 191, 402, 39);
        add(textPrecUnitProd);

        JButton btnVoltar = new JButton("Voltar");
        btnVoltar.setForeground(new Color(47, 79, 79));
        btnVoltar.setFont(new Font("OCR A Extended", Font.PLAIN, 20));
        btnVoltar.setBackground(new Color(245, 245, 245));
        btnVoltar.setBounds(233, 360, 117, 31);
        add(btnVoltar);

        JButton btnRegistrar = new JButton("Salvar");
        btnRegistrar.setForeground(new Color(47, 79, 79));
        btnRegistrar.setFont(new Font("OCR A Extended", Font.PLAIN, 20));
        btnRegistrar.setBackground(new Color(245, 245, 245));
        btnRegistrar.setBounds(403, 360, 117, 31);
        add(btnRegistrar);

        // Add action listener to the Salvar button
        btnRegistrar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ProdutoDAO produtoDAO = new ProdutoDAO(conexao);
                Produto produto = new Produto();

                try {
                    produto.setDescProduto(textProd.getText());
                    produto.setPrecoUnitario(new BigDecimal(textPrecUnitProd.getText()));
                    produto.setIdUsuario(usuario.getIdUsuario());  // Setting the user ID

                    produtoDAO.create(produto, produto.getIdUsuario());
                    JOptionPane.showMessageDialog(null, "Produto adicionado com sucesso!");
                    textProd.setText("");
                    textPrecUnitProd.setText("");
                } catch (Exception ex) {
                    System.out.println("Erro ao formatar número: " + ex.getMessage());
                    JOptionPane.showMessageDialog(null, "Erro ao adicionar produto! " + ex.getMessage());
                }
            }
        });

        // Add action listener to the Voltar button (optional, if you have an action for it)
        btnVoltar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Code to handle back action, e.g., switch to a different panel
                JFrame parentFrame = (JFrame) TelaRegistroProd.this.getTopLevelAncestor();
                if (parentFrame != null) {
                    parentFrame.dispose();  // This will close the JFrame
                }
            }
        });
    }
}

