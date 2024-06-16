package View;

import javax.swing.*;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.math.BigDecimal;
import java.sql.Connection;
import java.util.List;

import DAO.ProdutoDAO;
import Model.Produto;

public class TelaConsultaProd extends JPanel {

    private static final long serialVersionUID = 1L;
    private JTextField txtPesquisa;
    private JTable table;

    /**
     * Create the panel.
     */
    public TelaConsultaProd() {
        setLayout(null);

        JLabel lblConsultaDeProdutos = new JLabel("Consulta de Produtos");
        lblConsultaDeProdutos.setForeground(new Color(47, 79, 79));
        lblConsultaDeProdutos.setHorizontalAlignment(SwingConstants.CENTER);
        lblConsultaDeProdutos.setFont(new Font("OCR A Extended", Font.BOLD, 40));
        lblConsultaDeProdutos.setBounds(138, 18, 515, 70);
        add(lblConsultaDeProdutos);

        JLabel lblDataInicial = new JLabel("Filtrar por Descrição:");
        lblDataInicial.setForeground(new Color(47, 79, 79));
        lblDataInicial.setFont(new Font("OCR A Extended", Font.BOLD, 15));
        lblDataInicial.setBounds(10, 98, 217, 47);
        add(lblDataInicial);

        txtPesquisa = new JTextField();
        txtPesquisa.setColumns(10);
        txtPesquisa.setBounds(237, 112, 255, 20);
        add(txtPesquisa);

        Panel panel = new Panel();
        panel.setLayout(null);
        panel.setBounds(10, 138, 780, 247);
        add(panel);

        JScrollPane scrollPane = new JScrollPane();
        scrollPane.setBounds(10, 11, 760, 251);
        panel.add(scrollPane);

        table = new JTable();
        table.setForeground(new Color(47, 79, 79));
        table.setFont(new Font("OCR A Extended", Font.PLAIN, 10));
        table.setModel(new DefaultTableModel(
            new Object[][] {},
            new String[] {
                "ID", "Descrição", "Preço Unitário"
            }
        ));
        scrollPane.setViewportView(table);
        table.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                int selectedRow = table.getSelectedRow();
                if (selectedRow != -1) {
                    Object idProd = table.getValueAt(selectedRow, 0);
                    Object descProd = table.getValueAt(selectedRow, 1);
                    Object precoUnitario = table.getValueAt(selectedRow, 2);
                    
                    Object[] opcoes = {"Atualizar", "Apagar"};
                    int escolha = JOptionPane.showOptionDialog(null, "Escolha uma opção:", "Caixa de diálogo com opções",
                                            JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE, null,
                                            opcoes, opcoes[0]);

                    if (escolha == 0) {
                        TelaAtualizarProd telaAtualizarProd = new TelaAtualizarProd(null);
                        telaAtualizarProd.preencherCampos(idProd.toString(), descProd.toString(), precoUnitario.toString());

                        JFrame frameAtualizarProd = new JFrame("Atualização de Produtos");
                        frameAtualizarProd.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
                        frameAtualizarProd.getContentPane().add(telaAtualizarProd);
                        frameAtualizarProd.pack();
                        frameAtualizarProd.setSize(800, 450);
                        frameAtualizarProd.setLocationRelativeTo(null);
                        frameAtualizarProd.setVisible(true);
                    } else if (escolha == 1) {
                        int confirmacao = JOptionPane.showConfirmDialog(null, "Tem certeza que deseja excluir este produto?", "Confirmação de Exclusão", JOptionPane.YES_NO_OPTION);
                        if (confirmacao == JOptionPane.YES_OPTION) {
            				ProdutoDAO produtoDAO = new ProdutoDAO(null);
                            Produto produto = new Produto();
                            produto.setIdProduto(Integer.parseInt(idProd.toString()));
                            produtoDAO.delete(produto);
                            updateTable();
                        }
                    }
                }
            }
        });

        

        JButton btnVoltar = new JButton("Voltar");
        btnVoltar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                JFrame parentFrame = (JFrame) TelaConsultaProd.this.getTopLevelAncestor();
                if (parentFrame != null) {
                    parentFrame.dispose();  // This will close the JFrame
                }
            }
        });
        btnVoltar.setForeground(new Color(47, 79, 79));
        btnVoltar.setFont(new Font("OCR A Extended", Font.BOLD, 18));
        btnVoltar.setBackground(new Color(245, 245, 245));
        btnVoltar.setBounds(337, 398, 117, 31);
        add(btnVoltar);

        // Add DocumentListener to txtPesquisa
        txtPesquisa.getDocument().addDocumentListener(new DocumentListener() {
            public void changedUpdate(DocumentEvent e) {
                updateTable();
            }
            public void removeUpdate(DocumentEvent e) {
                updateTable();
            }
            public void insertUpdate(DocumentEvent e) {
                updateTable();
            }

            
        });
        
    }
    public void updateTable() {
        String searchText = txtPesquisa.getText();
        List<Produto> produtos = new ProdutoDAO(null).searchByDescription(searchText);
        DefaultTableModel model = (DefaultTableModel) table.getModel();
        model.setRowCount(0);  // Clear existing rows
        for (Produto produto : produtos) {
            String formattedPrice = String.format("R$ %.2f", produto.getPrecoUnitario());
            model.addRow(new Object[]{produto.getIdProduto(), produto.getDescProduto(), formattedPrice});
        }
    }
    
    
}
