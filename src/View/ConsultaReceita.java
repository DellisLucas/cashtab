package View;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import org.jdatepicker.impl.JDatePanelImpl;
import org.jdatepicker.impl.JDatePickerImpl;
import org.jdatepicker.impl.UtilDateModel;

import DAO.ReceitaDAO;
import Model.Receita;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.Connection;
import java.text.SimpleDateFormat;
import java.util.List;
import java.util.Properties;

public class ConsultaReceita extends JPanel {

    private JTable table;
    private JDatePickerImpl datePickerDataInicial;
    private JDatePickerImpl datePickerDataFinal;
    private Connection conexao;
    private ReceitaDAO receitaDAO;

    public ConsultaReceita(Connection conexao) {
        this.conexao = conexao;
        this.receitaDAO = new ReceitaDAO(conexao);
        setLayout(null);

        JLabel lblTituloCadReceita = new JLabel("Consulta de Receitas");
        lblTituloCadReceita.setHorizontalAlignment(SwingConstants.CENTER);
        lblTituloCadReceita.setFont(new Font("OCR A Extended", Font.BOLD, 40));
        lblTituloCadReceita.setBounds(139, 0, 515, 70);
        add(lblTituloCadReceita);

        JLabel lblDataInicial = new JLabel("Data Inicial:");
        lblDataInicial.setFont(new Font("OCR A Extended", Font.BOLD, 15));
        lblDataInicial.setBounds(30, 100, 150, 30);
        add(lblDataInicial);

        JLabel lblDataFinal = new JLabel("Data Final:");
        lblDataFinal.setFont(new Font("OCR A Extended", Font.BOLD, 15));
        lblDataFinal.setBounds(400, 100, 150, 30);
        add(lblDataFinal);

        UtilDateModel modelDataInicial = new UtilDateModel();
        UtilDateModel modelDataFinal = new UtilDateModel();

        Properties p = new Properties();
        p.put("text.today", "Hoje");
        p.put("text.month", "Mês");
        p.put("text.year", "Ano");

        JDatePanelImpl datePanelDataInicial = new JDatePanelImpl(modelDataInicial, p);
        JDatePanelImpl datePanelDataFinal = new JDatePanelImpl(modelDataFinal, p);

        datePickerDataInicial = new JDatePickerImpl(datePanelDataInicial, new DateLabelFormatter());
        datePickerDataInicial.getJFormattedTextField().setFont(new Font("OCR A Extended", Font.PLAIN, 20));
        datePickerDataInicial.setBounds(156, 100, 200, 30);
        add(datePickerDataInicial);

        datePickerDataFinal = new JDatePickerImpl(datePanelDataFinal, new DateLabelFormatter());
        datePickerDataFinal.getJFormattedTextField().setFont(new Font("OCR A Extended", Font.PLAIN, 20));
        datePickerDataFinal.setBounds(501, 100, 200, 30);
        add(datePickerDataFinal);

        JButton btnBuscar = new JButton("Buscar");
        btnBuscar.setFont(new Font("OCR A Extended", Font.BOLD, 15));
        btnBuscar.setBounds(338, 150, 120, 39);
        add(btnBuscar);

        btnBuscar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                buscarReceitas();
            }
        });

        JScrollPane scrollPane = new JScrollPane();
        scrollPane.setBounds(30, 200, 700, 300);
        add(scrollPane);

        table = new JTable();
        table.setModel(new DefaultTableModel(
            new Object[][] {},
            new String[] {
                "ID Receita", "Descrição", "Data Recebimento", "Valor Recebido"
            }
        ));
        scrollPane.setViewportView(table);

        table.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                int selectedRow = table.getSelectedRow();
                if (selectedRow != -1) {
                    Object idReceita = table.getValueAt(selectedRow, 0);
                    Object descricao = table.getValueAt(selectedRow, 1);
                    Object dataRecebimento = table.getValueAt(selectedRow, 2);
                    Object valorRecebido = table.getValueAt(selectedRow, 3);

                    Object[] opcoes = {"Atualizar", "Apagar"};
                    int escolha = JOptionPane.showOptionDialog(null, "Escolha uma opção:", "Opções",
                            JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE, null,
                            opcoes, opcoes[0]);

                    if (escolha == 0) {
                        TelaAtualizarRec telaAtualizarReceita = new TelaAtualizarRec(conexao, null);
                        telaAtualizarReceita.preencherCampos(idReceita.toString(), descricao.toString(), dataRecebimento.toString(), valorRecebido.toString());

                        JFrame frameAtualizarReceita = new JFrame("Atualização de Receita");
                        frameAtualizarReceita.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
                        frameAtualizarReceita.getContentPane().add(telaAtualizarReceita);
                        frameAtualizarReceita.pack();
                        frameAtualizarReceita.setSize(800, 450);
                        frameAtualizarReceita.setLocationRelativeTo(null);
                        frameAtualizarReceita.setVisible(true);
                    } else if (escolha == 1) {
                        TelaApagarRec telaApagarReceita = new TelaApagarRec();
                        telaApagarReceita.preencherCampos(idReceita.toString(), descricao.toString(), dataRecebimento.toString(), valorRecebido.toString());

                        JFrame frameApagarReceita = new JFrame("Apagar Receita");
                        frameApagarReceita.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
                        frameApagarReceita.getContentPane().add(telaApagarReceita);
                        frameApagarReceita.pack();
                        frameApagarReceita.setSize(800, 450);
                        frameApagarReceita.setLocationRelativeTo(null);
                        frameApagarReceita.setVisible(true);
                    }
                }
            }
        });

    }

    private void buscarReceitas() {
        try {
            java.util.Date dataInicial = (java.util.Date) datePickerDataInicial.getModel().getValue();
            java.util.Date dataFinal = (java.util.Date) datePickerDataFinal.getModel().getValue();

            if (dataInicial == null || dataFinal == null) {
                JOptionPane.showMessageDialog(null, "Por favor, preencha ambas as datas.");
                return;
            }

            List<Receita> receitas = receitaDAO.findByDateRange(new java.sql.Date(dataInicial.getTime()), new java.sql.Date(dataFinal.getTime()));

            DefaultTableModel model = (DefaultTableModel) table.getModel();
            model.setRowCount(0);

            SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
            for (Receita receita : receitas) {
                model.addRow(new Object[]{
                    receita.getIdReceita(),
                    receita.getDescReceita(),
                    sdf.format(receita.getDataRecebimento()),
                    receita.getValorRecebido()
                });
            }
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, "Erro ao buscar receitas: " + ex.getMessage());
            System.out.println("Erro ao buscar receitas: " + ex.getMessage());
        }
    }
}
