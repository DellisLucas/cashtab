package View;

import javax.swing.JPanel;
import javax.swing.JButton;
import java.awt.Font;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import java.awt.Panel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import java.sql.Connection;
import java.text.SimpleDateFormat;
import java.util.List;
import java.util.Properties;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.util.Date;

import org.jdatepicker.impl.JDatePanelImpl;
import org.jdatepicker.impl.JDatePickerImpl;
import org.jdatepicker.impl.UtilDateModel;

import DAO.DespesaDAO;
import Model.Despesa;

/**
 * A classe ConsultaDespesa representa a interface gráfica para consulta de despesas.
 */
public class ConsultaDespesa extends JPanel {

    private static final long serialVersionUID = 1L;
    private JTable table;
    private JDatePickerImpl datePickerDataInicial;
    private JDatePickerImpl datePickerDataFinal;
    private Connection conexao;

    /**
     * Cria o painel de consulta de despesas.
     * 
     * @param conexao Conexão com o banco de dados
     */
    public ConsultaDespesa(Connection conexao) {
        this.conexao = conexao;
        setLayout(null);
        
        JLabel lblTituloCadReceita = new JLabel("Consulta de Despesas");
        lblTituloCadReceita.setHorizontalAlignment(SwingConstants.CENTER);
        lblTituloCadReceita.setFont(new Font("OCR A Extended", Font.BOLD, 40));
        lblTituloCadReceita.setBounds(138, 0, 515, 70);
        add(lblTituloCadReceita);
        
        JLabel lblFiltrarPor = new JLabel("Filtrar por:");
        lblFiltrarPor.setFont(new Font("OCR A Extended", Font.BOLD, 15));
        lblFiltrarPor.setBounds(10, 67, 120, 47);
        add(lblFiltrarPor);
        
        JLabel lblDataInicial = new JLabel("Data Inicial:");
        lblDataInicial.setFont(new Font("OCR A Extended", Font.BOLD, 15));
        lblDataInicial.setBounds(10, 98, 143, 47);
        add(lblDataInicial);
        
        JLabel lblDataFinal = new JLabel("Data Final:");
        lblDataFinal.setFont(new Font("OCR A Extended", Font.BOLD, 15));
        lblDataFinal.setBounds(353, 98, 114, 47);
        add(lblDataFinal);

        // Model for JDatePicker
        UtilDateModel modelDataInicial = new UtilDateModel();
        UtilDateModel modelDataFinal = new UtilDateModel();

        // Properties for JDatePicker
        Properties p = new Properties();
        p.put("text.today", "Hoje");
        p.put("text.month", "Mês");
        p.put("text.year", "Ano");

        // DatePanel for JDatePicker
        JDatePanelImpl datePanelDataInicial = new JDatePanelImpl(modelDataInicial, p);
        JDatePanelImpl datePanelDataFinal = new JDatePanelImpl(modelDataFinal, p);

        // JDatePicker
        datePickerDataInicial = new JDatePickerImpl(datePanelDataInicial, new DateLabelFormatter());
        datePickerDataInicial.setBounds(143, 112, 200, 30);
        add(datePickerDataInicial);

        datePickerDataFinal = new JDatePickerImpl(datePanelDataFinal, new DateLabelFormatter());
        datePickerDataFinal.setBounds(477, 112, 200, 30);
        add(datePickerDataFinal);
        
        Panel panel = new Panel();
        panel.setLayout(null);
        panel.setBounds(10, 140, 780, 247);
        add(panel);
        
        JScrollPane scrollPane = new JScrollPane();
        scrollPane.setBounds(10, 11, 760, 251);
        panel.add(scrollPane);
        
        table = new JTable();
        table.setModel(new DefaultTableModel(
            new Object[][] {},
            new String[] {
                "ID", "Descrição", "Data Faturamento", "Valor Pago"
            }
        ));
        scrollPane.setViewportView(table);
        
        JButton btnBuscar = new JButton("Buscar");
        btnBuscar.setFont(new Font("OCR A Extended", Font.BOLD, 15));
        btnBuscar.setBounds(338, 400, 120, 39);
        add(btnBuscar);
        
        JButton btnVoltar = new JButton("Voltar");
        btnVoltar.setFont(new Font("OCR A Extended", Font.BOLD, 15));
        btnVoltar.setBounds(338, 450, 120, 39);
        add(btnVoltar);

        // Adicionando ActionListener ao botão "Buscar"
        btnBuscar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                try {
                    // Obtendo as datas de entrada
                    Date dataInicial = (Date) datePickerDataInicial.getModel().getValue();
                    Date dataFinal = (Date) datePickerDataFinal.getModel().getValue();

                    // Validar se as datas foram preenchidas
                    if (dataInicial == null || dataFinal == null) {
                        JOptionPane.showMessageDialog(null, "Por favor, preencha ambas as datas.");
                        return;
                    }

                    // Criando uma instância de DespesaDAO
                    DespesaDAO despesaDAO = new DespesaDAO(conexao);
                    
                    // Buscando despesas no intervalo de datas
                    List<Despesa> despesas = despesaDAO.obterDespesasPorIntervalo(new java.sql.Date(dataInicial.getTime()), new java.sql.Date(dataFinal.getTime()));
                    
                    // Atualizando a tabela com os dados das despesas
                    DefaultTableModel model = (DefaultTableModel) table.getModel();
                    model.setRowCount(0); // Limpando a tabela

                    SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
                    for (Despesa despesa : despesas) {
                        model.addRow(new Object[]{
                            despesa.getIdDespesa(),
                            despesa.getDescricaoDespesa(),
                            sdf.format(despesa.getDataFaturamento()),
                            despesa.getValorDespesa()
                        });
                    }
                } catch (Exception ex) {
                    JOptionPane.showMessageDialog(null, "Erro ao buscar despesas: " + ex.getMessage());
                }
            }
        });
    }
}
