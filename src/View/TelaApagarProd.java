package View;

import javax.swing.JPanel;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import java.awt.Font;
import javax.swing.SwingConstants;
import DAO.ProdutoDAO;
import Model.Produto;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JFrame;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.sql.Connection;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

/**
 * Um JPanel para apagar dados de produtos do sistema.
 * Este painel permite aos usuários inserir informações do produto e deletá-las do banco de dados.
 */
public class TelaApagarProd extends JPanel {

    private static final long serialVersionUID = 1L;
    private JTextField textCodProd;
    private JTextField textNomeProd;
    private JTextField textPrecUnitProd;
    private Connection conexao;

    /**
     * Cria o painel e inicializa seus componentes.
     */
    public TelaApagarProd() {
        this.conexao = conexao;
        setBackground(new Color(245, 245, 245));
        setLayout(null);

        JLabel lblApagarrProd = new JLabel("Apagar Dados de Produtos");
        lblApagarrProd.setForeground(new Color(47, 79, 79));
        lblApagarrProd.setFont(new Font("OCR A Extended", Font.BOLD, 40));
        lblApagarrProd.setBounds(96, 22, 617, 48);
        add(lblApagarrProd);

        JLabel lblCodProd = new JLabel("Código:");
        lblCodProd.setHorizontalAlignment(SwingConstants.CENTER);
        lblCodProd.setForeground(new Color(47, 79, 79));
        lblCodProd.setFont(new Font("OCR A Extended", Font.BOLD, 20));
        lblCodProd.setBackground(Color.BLACK);
        lblCodProd.setBounds(109, 98, 182, 39);
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
                        textNomeProd.setText(produto.getDescProduto());
                        textPrecUnitProd.setText(produto.getPrecoUnitario().toString());
                    } else {
                        JOptionPane.showMessageDialog(null, "Produto não encontrado!", "Erro", JOptionPane.ERROR_MESSAGE);
                    }
                } catch (Exception ex) {
                    ex.printStackTrace();
                }
            }
        });
        textCodProd.setHorizontalAlignment(SwingConstants.LEFT);
        textCodProd.setForeground(Color.BLACK);
        textCodProd.setFont(new Font("OCR A Extended", Font.PLAIN, 20));
        textCodProd.setColumns(10);
        textCodProd.setBackground(Color.WHITE);
        textCodProd.setBounds(254, 98, 402, 39);
        add(textCodProd);

        JLabel lblNomeProd = new JLabel("Produto: ");
        lblNomeProd.setHorizontalAlignment(SwingConstants.CENTER);
        lblNomeProd.setForeground(new Color(47, 79, 79));
        lblNomeProd.setFont(new Font("OCR A Extended", Font.BOLD, 20));
        lblNomeProd.setBackground(Color.BLACK);
        lblNomeProd.setBounds(109, 161, 182, 39);
        add(lblNomeProd);

        textNomeProd = new JTextField();
        textNomeProd.setHorizontalAlignment(SwingConstants.LEFT);
        textNomeProd.setForeground(Color.BLACK);
        textNomeProd.setFont(new Font("OCR A Extended", Font.PLAIN, 20));
        textNomeProd.setColumns(10);
        textNomeProd.setBackground(Color.WHITE);
        textNomeProd.setBounds(254, 161, 402, 39);
        add(textNomeProd);

        JLabel lblPrecProd = new JLabel("Preço Unitário: ");
        lblPrecProd.setHorizontalAlignment(SwingConstants.CENTER);
        lblPrecProd.setForeground(new Color(47, 79, 79));
        lblPrecProd.setFont(new Font("OCR A Extended", Font.BOLD, 20));
        lblPrecProd.setBackground(Color.BLACK);
        lblPrecProd.setBounds(37, 222, 240, 39);
        add(lblPrecProd);

        textPrecUnitProd = new JTextField();
        textPrecUnitProd.setHorizontalAlignment(SwingConstants.LEFT);
        textPrecUnitProd.setForeground(Color.BLACK);
        textPrecUnitProd.setFont(new Font("OCR A Extended", Font.PLAIN, 20));
        textPrecUnitProd.setColumns(10);
        textPrecUnitProd.setBackground(Color.WHITE);
        textPrecUnitProd.setBounds(254, 222, 402, 39);
        add(textPrecUnitProd);

        JButton btnVoltar = new JButton("Voltar");
        btnVoltar.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                JFrame parentFrame = (JFrame) TelaApagarProd.this.getTopLevelAncestor();
                if (parentFrame != null) {
                    parentFrame.dispose();  // Isso fechará o JFrame
                }
            }
        });
        btnVoltar.setForeground(new Color(47, 79, 79));
        btnVoltar.setFont(new Font("OCR A Extended", Font.PLAIN, 20));
        btnVoltar.setBackground(new Color(245, 245, 245));
        btnVoltar.setBounds(227, 368, 117, 31);
        add(btnVoltar);

        JButton btnApagar = new JButton("Apagar");
        btnApagar.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                ProdutoDAO produtoDAO = new ProdutoDAO(null);
                Produto produto = new Produto();

                try {
                    produto.setIdProduto(Integer.parseInt(textCodProd.getText()));
                    produtoDAO.delete(produto);
                    JOptionPane.showMessageDialog(null, "Produto deletado com sucesso!");
                    // Limpar os campos de texto após salvar
                    textCodProd.setText("");
                    textNomeProd.setText("");
                    textPrecUnitProd.setText("");
                } catch (Exception ex) {
                    System.out.println("Erro ao formatar número: " + ex.getMessage());
                    JOptionPane.showMessageDialog(null, "Erro ao apagar produto! " + ex.getMessage());
                }
            }
        });
        btnApagar.setForeground(new Color(47, 79, 79));
        btnApagar.setFont(new Font("OCR A Extended", Font.PLAIN, 20));
        btnApagar.setBackground(new Color(245, 245, 245));
        btnApagar.setBounds(397, 368, 117, 31);
        add(btnApagar);
    }
}