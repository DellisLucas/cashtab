package View;

import javax.swing.JPanel;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import javax.swing.SpinnerDateModel;
import javax.swing.JScrollPane;
import javax.swing.JSpinner;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import java.awt.Color;
import java.awt.Font;
import java.awt.Panel;
import java.sql.Connection;
import java.util.Date;
import java.util.List;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.text.SimpleDateFormat;

import DAO.ConexãoBanco;
import DAO.DespesaDAO;
import Model.Despesa;

public class TelaConsultaDesp extends JPanel {

    private static final long serialVersionUID = 1L;
    private JSpinner dtpDataIni;
    private JSpinner dtpDataFim;
    private JTable table;

    private DespesaDAO despesaDAO;
    private Connection conexao;

    public TelaConsultaDesp() {
        conexao = ConexãoBanco.conectar();
        despesaDAO = new DespesaDAO(conexao);
        setLayout(null);

        JLabel lblTituloCadReceita = new JLabel("Consulta de Despesas");
        lblTituloCadReceita.setForeground(new Color(47, 79, 79));
        lblTituloCadReceita.setHorizontalAlignment(SwingConstants.CENTER);
        lblTituloCadReceita.setFont(new Font("OCR A Extended", Font.BOLD, 40));
        lblTituloCadReceita.setBounds(127, 10, 515, 70);
        add(lblTituloCadReceita);

        JLabel lblFiltrarPor = new JLabel("Filtrar por:");
        lblFiltrarPor.setForeground(new Color(47, 79, 79));
        lblFiltrarPor.setFont(new Font("OCR A Extended", Font.BOLD, 15));
        lblFiltrarPor.setBounds(10, 67, 120, 47);
        add(lblFiltrarPor);

        JLabel lblDataInicial = new JLabel("Data Inicial:");
        lblDataInicial.setForeground(new Color(47, 79, 79));
        lblDataInicial.setFont(new Font("OCR A Extended", Font.BOLD, 15));
        lblDataInicial.setBounds(10, 98, 143, 47);
        add(lblDataInicial);

        dtpDataIni = new JSpinner(new SpinnerDateModel());
        dtpDataIni.setFont(new Font("OCR A Extended", Font.PLAIN, 17));
        JSpinner.DateEditor de_dtpDataIni = new JSpinner.DateEditor(dtpDataIni, "dd/MM/yyyy");
        dtpDataIni.setEditor(de_dtpDataIni);
        dtpDataIni.setBounds(143, 112, 156, 20);
        add(dtpDataIni);

        JLabel lblDataFinal = new JLabel("Data Final:");
        lblDataFinal.setForeground(new Color(47, 79, 79));
        lblDataFinal.setFont(new Font("OCR A Extended", Font.BOLD, 15));
        lblDataFinal.setBounds(323, 98, 114, 47);
        add(lblDataFinal);

        dtpDataFim = new JSpinner(new SpinnerDateModel());
        dtpDataFim.setFont(new Font("OCR A Extended", Font.PLAIN, 17));
        JSpinner.DateEditor de_dtpDataFim = new JSpinner.DateEditor(dtpDataFim, "dd/MM/yyyy");
        dtpDataFim.setEditor(de_dtpDataFim);
        dtpDataFim.setBounds(437, 112, 153, 20);
        add(dtpDataFim);

        JButton btnBuscar = new JButton("Buscar");
        btnBuscar.setForeground(new Color(47, 79, 79));
        btnBuscar.setFont(new Font("OCR A Extended", Font.BOLD, 18));
        btnBuscar.setBackground(new Color(245, 245, 245));
        btnBuscar.setBounds(600, 112, 117, 31);
        btnBuscar.addActionListener(e -> buscarDespesas());
        add(btnBuscar);

        Panel panel = new Panel();
        panel.setLayout(null);
        panel.setBounds(10, 140, 780, 247);
        add(panel);

        JScrollPane scrollPane = new JScrollPane();
        scrollPane.setBounds(10, 11, 760, 251);
        panel.add(scrollPane);

        table = new JTable();
        table.setBackground(new Color(255, 255, 255));
        table.setForeground(new Color(47, 79, 79));
        table.setFont(new Font("OCR A Extended", Font.PLAIN, 10));
        table.setModel(new DefaultTableModel(
                new Object[][]{},
                new String[]{
                    "ID", "Descrição", "Data Faturamento", "Valor Pago"
                }
        ));
        scrollPane.setViewportView(table);

        table.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                int selectedRow = table.getSelectedRow();
                    Object idDespesa = table.getValueAt(selectedRow, 0);
                    Object descricao = table.getValueAt(selectedRow, 1);
                    Object dataFaturamento = table.getValueAt(selectedRow, 2);
                    Object valorDespesa = table.getValueAt(selectedRow, 3);

                    Object[] opcoes = {"Atualizar", "Apagar"};
                    int escolha = JOptionPane.showOptionDialog(null, "Escolha uma opção:", "Opções",
                            JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE, null,
                            opcoes, opcoes[0]);

                    if (escolha == 0) {
                        TelaAtualizarDesp telaAtualizarDesp = new TelaAtualizarDesp(despesaDAO);
                        telaAtualizarDesp.preencherCampos(idDespesa.toString(), descricao.toString(), dataFaturamento.toString(), valorDespesa.toString());

                        JFrame frameAtualizarDesp = new JFrame("Atualização de Despesa");
                        frameAtualizarDesp.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
                        frameAtualizarDesp.getContentPane().add(telaAtualizarDesp);
                        frameAtualizarDesp.pack();
                        frameAtualizarDesp.setSize(800, 450);
                        frameAtualizarDesp.setLocationRelativeTo(null);
                        frameAtualizarDesp.setVisible(true);
                    } else if (escolha == 1) {
                        TelaApagarDesp telaApagarDesp = new TelaApagarDesp();
                        telaApagarDesp.preencherCampos(idDespesa.toString(), descricao.toString(), dataFaturamento.toString(), valorDespesa.toString());

                        JFrame frameApagarDesp = new JFrame("Apagar Despesa");
                        frameApagarDesp.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
                        frameApagarDesp.getContentPane().add(telaApagarDesp);
                        frameApagarDesp.pack();
                        frameApagarDesp.setSize(800, 450);
                        frameApagarDesp.setLocationRelativeTo(null);
                        frameApagarDesp.setVisible(true);
                    }
                }
        });
    }

    private void buscarDespesas() {
        java.util.Date dataInicialUtil = (java.util.Date) dtpDataIni.getValue();
        java.util.Date dataFinalUtil = (java.util.Date) dtpDataFim.getValue();

        if (dataInicialUtil == null || dataFinalUtil == null) {
            JOptionPane.showMessageDialog(this, "Por favor, selecione ambas as datas.");
            return;
        }

        java.sql.Date dataInicialSql = new java.sql.Date(dataInicialUtil.getTime());
        java.sql.Date dataFinalSql = new java.sql.Date(dataFinalUtil.getTime());

        DefaultTableModel model = (DefaultTableModel) table.getModel();
        model.setRowCount(0);

        List<Despesa> despesas = despesaDAO.obterDespesasPorIntervalo(dataInicialSql, dataFinalSql);
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

        for (Despesa despesa : despesas) {
            Object[] rowData = {
                despesa.getIdDespesa(),
                despesa.getDescricaoDespesa(),
                sdf.format(despesa.getDataFaturamento()),
                despesa.getValorDespesa()
            };
            model.addRow(rowData);
        }
    }
}
