package View;

import javax.swing.*;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.math.BigDecimal;
import java.util.List;

import DAO.ProdutoDAO;
import Model.Produto;

public class TelaConsultaRec extends JPanel {

    private static final long serialVersionUID = 1L;
    private JTextField txtPesquisa;
    private JTable table;

    /**
     * Create the panel.
     */
    public TelaConsultaRec() {
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

        JButton btnVoltar = new JButton("Voltar");
        btnVoltar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                JFrame parentFrame = (JFrame) TelaConsultaRec.this.getTopLevelAncestor();
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
        });
    }
}
